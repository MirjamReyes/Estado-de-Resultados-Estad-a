package b4a.FinanzasC;


import anywheresoftware.b4a.B4AMenuItem;
import android.app.Activity;
import android.os.Bundle;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.B4AActivity;
import anywheresoftware.b4a.ObjectWrapper;
import anywheresoftware.b4a.objects.ActivityWrapper;
import java.lang.reflect.InvocationTargetException;
import anywheresoftware.b4a.B4AUncaughtException;
import anywheresoftware.b4a.debug.*;
import java.lang.ref.WeakReference;

public class main extends Activity implements B4AActivity{
	public static main mostCurrent;
	static boolean afterFirstLayout;
	static boolean isFirst = true;
    private static boolean processGlobalsRun = false;
	BALayout layout;
	public static BA processBA;
	BA activityBA;
    ActivityWrapper _activity;
    java.util.ArrayList<B4AMenuItem> menuItems;
	public static final boolean fullScreen = false;
	public static final boolean includeTitle = false;
    public static WeakReference<Activity> previousOne;
    public static boolean dontPause;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        mostCurrent = this;
		if (processBA == null) {
			processBA = new BA(this.getApplicationContext(), null, null, "b4a.FinanzasC", "b4a.FinanzasC.main");
			processBA.loadHtSubs(this.getClass());
	        float deviceScale = getApplicationContext().getResources().getDisplayMetrics().density;
	        BALayout.setDeviceScale(deviceScale);
            
		}
		else if (previousOne != null) {
			Activity p = previousOne.get();
			if (p != null && p != this) {
                BA.LogInfo("Killing previous instance (main).");
				p.finish();
			}
		}
        processBA.setActivityPaused(true);
        processBA.runHook("oncreate", this, null);
		if (!includeTitle) {
        	this.getWindow().requestFeature(android.view.Window.FEATURE_NO_TITLE);
        }
        if (fullScreen) {
        	getWindow().setFlags(android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN,   
        			android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }
		
        processBA.sharedProcessBA.activityBA = null;
		layout = new BALayout(this);
		setContentView(layout);
		afterFirstLayout = false;
        WaitForLayout wl = new WaitForLayout();
        if (anywheresoftware.b4a.objects.ServiceHelper.StarterHelper.startFromActivity(this, processBA, wl, false))
		    BA.handler.postDelayed(wl, 5);

	}
	static class WaitForLayout implements Runnable {
		public void run() {
			if (afterFirstLayout)
				return;
			if (mostCurrent == null)
				return;
            
			if (mostCurrent.layout.getWidth() == 0) {
				BA.handler.postDelayed(this, 5);
				return;
			}
			mostCurrent.layout.getLayoutParams().height = mostCurrent.layout.getHeight();
			mostCurrent.layout.getLayoutParams().width = mostCurrent.layout.getWidth();
			afterFirstLayout = true;
			mostCurrent.afterFirstLayout();
		}
	}
	private void afterFirstLayout() {
        if (this != mostCurrent)
			return;
		activityBA = new BA(this, layout, processBA, "b4a.FinanzasC", "b4a.FinanzasC.main");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "b4a.FinanzasC.main", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
			_activity.reinitializeForShell(activityBA, "activity");
		}
        initializeProcessGlobals();		
        initializeGlobals();
        
        BA.LogInfo("** Activity (main) Create " + (isFirst ? "(first time)" : "") + " **");
        processBA.raiseEvent2(null, true, "activity_create", false, isFirst);
		isFirst = false;
		if (this != mostCurrent)
			return;
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (main) Resume **");
        processBA.raiseEvent(null, "activity_resume");
        if (android.os.Build.VERSION.SDK_INT >= 11) {
			try {
				android.app.Activity.class.getMethod("invalidateOptionsMenu").invoke(this,(Object[]) null);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
	public void addMenuItem(B4AMenuItem item) {
		if (menuItems == null)
			menuItems = new java.util.ArrayList<B4AMenuItem>();
		menuItems.add(item);
	}
	@Override
	public boolean onCreateOptionsMenu(android.view.Menu menu) {
		super.onCreateOptionsMenu(menu);
        try {
            if (processBA.subExists("activity_actionbarhomeclick")) {
                Class.forName("android.app.ActionBar").getMethod("setHomeButtonEnabled", boolean.class).invoke(
                    getClass().getMethod("getActionBar").invoke(this), true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (processBA.runHook("oncreateoptionsmenu", this, new Object[] {menu}))
            return true;
		if (menuItems == null)
			return false;
		for (B4AMenuItem bmi : menuItems) {
			android.view.MenuItem mi = menu.add(bmi.title);
			if (bmi.drawable != null)
				mi.setIcon(bmi.drawable);
            if (android.os.Build.VERSION.SDK_INT >= 11) {
				try {
                    if (bmi.addToBar) {
				        android.view.MenuItem.class.getMethod("setShowAsAction", int.class).invoke(mi, 1);
                    }
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			mi.setOnMenuItemClickListener(new B4AMenuItemsClickListener(bmi.eventName.toLowerCase(BA.cul)));
		}
        
		return true;
	}   
 @Override
 public boolean onOptionsItemSelected(android.view.MenuItem item) {
    if (item.getItemId() == 16908332) {
        processBA.raiseEvent(null, "activity_actionbarhomeclick");
        return true;
    }
    else
        return super.onOptionsItemSelected(item); 
}
@Override
 public boolean onPrepareOptionsMenu(android.view.Menu menu) {
    super.onPrepareOptionsMenu(menu);
    processBA.runHook("onprepareoptionsmenu", this, new Object[] {menu});
    return true;
    
 }
 protected void onStart() {
    super.onStart();
    processBA.runHook("onstart", this, null);
}
 protected void onStop() {
    super.onStop();
    processBA.runHook("onstop", this, null);
}
    public void onWindowFocusChanged(boolean hasFocus) {
       super.onWindowFocusChanged(hasFocus);
       if (processBA.subExists("activity_windowfocuschanged"))
           processBA.raiseEvent2(null, true, "activity_windowfocuschanged", false, hasFocus);
    }
	private class B4AMenuItemsClickListener implements android.view.MenuItem.OnMenuItemClickListener {
		private final String eventName;
		public B4AMenuItemsClickListener(String eventName) {
			this.eventName = eventName;
		}
		public boolean onMenuItemClick(android.view.MenuItem item) {
			processBA.raiseEventFromUI(item.getTitle(), eventName + "_click");
			return true;
		}
	}
    public static Class<?> getObject() {
		return main.class;
	}
    private Boolean onKeySubExist = null;
    private Boolean onKeyUpSubExist = null;
	@Override
	public boolean onKeyDown(int keyCode, android.view.KeyEvent event) {
        if (processBA.runHook("onkeydown", this, new Object[] {keyCode, event}))
            return true;
		if (onKeySubExist == null)
			onKeySubExist = processBA.subExists("activity_keypress");
		if (onKeySubExist) {
			if (keyCode == anywheresoftware.b4a.keywords.constants.KeyCodes.KEYCODE_BACK &&
					android.os.Build.VERSION.SDK_INT >= 18) {
				HandleKeyDelayed hk = new HandleKeyDelayed();
				hk.kc = keyCode;
				BA.handler.post(hk);
				return true;
			}
			else {
				boolean res = new HandleKeyDelayed().runDirectly(keyCode);
				if (res)
					return true;
			}
		}
		return super.onKeyDown(keyCode, event);
	}
	private class HandleKeyDelayed implements Runnable {
		int kc;
		public void run() {
			runDirectly(kc);
		}
		public boolean runDirectly(int keyCode) {
			Boolean res =  (Boolean)processBA.raiseEvent2(_activity, false, "activity_keypress", false, keyCode);
			if (res == null || res == true) {
                return true;
            }
            else if (keyCode == anywheresoftware.b4a.keywords.constants.KeyCodes.KEYCODE_BACK) {
				finish();
				return true;
			}
            return false;
		}
		
	}
    @Override
	public boolean onKeyUp(int keyCode, android.view.KeyEvent event) {
        if (processBA.runHook("onkeyup", this, new Object[] {keyCode, event}))
            return true;
		if (onKeyUpSubExist == null)
			onKeyUpSubExist = processBA.subExists("activity_keyup");
		if (onKeyUpSubExist) {
			Boolean res =  (Boolean)processBA.raiseEvent2(_activity, false, "activity_keyup", false, keyCode);
			if (res == null || res == true)
				return true;
		}
		return super.onKeyUp(keyCode, event);
	}
	@Override
	public void onNewIntent(android.content.Intent intent) {
        super.onNewIntent(intent);
		this.setIntent(intent);
        processBA.runHook("onnewintent", this, new Object[] {intent});
	}
    @Override 
	public void onPause() {
		super.onPause();
        if (_activity == null)
            return;
        if (this != mostCurrent)
			return;
		anywheresoftware.b4a.Msgbox.dismiss(true);
        if (!dontPause)
            BA.LogInfo("** Activity (main) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
        else
            BA.LogInfo("** Activity (main) Pause event (activity is not paused). **");
        if (mostCurrent != null)
            processBA.raiseEvent2(_activity, true, "activity_pause", false, activityBA.activity.isFinishing());		
        if (!dontPause) {
            processBA.setActivityPaused(true);
            mostCurrent = null;
        }

        if (!activityBA.activity.isFinishing())
			previousOne = new WeakReference<Activity>(this);
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        processBA.runHook("onpause", this, null);
	}

	@Override
	public void onDestroy() {
        super.onDestroy();
		previousOne = null;
        processBA.runHook("ondestroy", this, null);
	}
    @Override 
	public void onResume() {
		super.onResume();
        mostCurrent = this;
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (activityBA != null) { //will be null during activity create (which waits for AfterLayout).
        	ResumeMessage rm = new ResumeMessage(mostCurrent);
        	BA.handler.post(rm);
        }
        processBA.runHook("onresume", this, null);
	}
    private static class ResumeMessage implements Runnable {
    	private final WeakReference<Activity> activity;
    	public ResumeMessage(Activity activity) {
    		this.activity = new WeakReference<Activity>(activity);
    	}
		public void run() {
            main mc = mostCurrent;
			if (mc == null || mc != activity.get())
				return;
			processBA.setActivityPaused(false);
            BA.LogInfo("** Activity (main) Resume **");
            if (mc != mostCurrent)
                return;
		    processBA.raiseEvent(mc._activity, "activity_resume", (Object[])null);
		}
    }
	@Override
	protected void onActivityResult(int requestCode, int resultCode,
	      android.content.Intent data) {
		processBA.onActivityResult(requestCode, resultCode, data);
        processBA.runHook("onactivityresult", this, new Object[] {requestCode, resultCode});
	}
	private static void initializeGlobals() {
		processBA.raiseEvent2(null, true, "globals", false, (Object[])null);
	}
    public void onRequestPermissionsResult(int requestCode,
        String permissions[], int[] grantResults) {
        for (int i = 0;i < permissions.length;i++) {
            Object[] o = new Object[] {permissions[i], grantResults[i] == 0};
            processBA.raiseEventFromDifferentThread(null,null, 0, "activity_permissionresult", true, o);
        }
            
    }

public anywheresoftware.b4a.keywords.Common __c = null;
public static anywheresoftware.b4a.objects.B4XViewWrapper.XUI _xui = null;
public static de.donmanfred.XSSFWorkbookwrapper _xls = null;
public static b4a.FinanzasC.b4xformatter _formatter = null;
public anywheresoftware.b4a.objects.ButtonWrapper _iniciar = null;
public anywheresoftware.b4a.objects.ButtonWrapper _info = null;
public static String _usuario = "";
public static String _archivo = "";
public anywheresoftware.b4a.objects.EditTextWrapper _nombre = null;
public anywheresoftware.b4a.objects.ButtonWrapper _ingresos = null;
public static float _gadm = 0f;
public static float _gop = 0f;
public static float _ingresos_ = 0f;
public static float _utilidadb = 0f;
public static float _utilidadoai = 0f;
public static float _impuestos = 0f;
public static float _uoperativadesp_imp = 0f;
public anywheresoftware.b4a.objects.LabelWrapper _hiusuario = null;
public anywheresoftware.b4a.objects.ButtonWrapper _boton = null;
public anywheresoftware.b4a.objects.LabelWrapper _label1 = null;
public anywheresoftware.b4a.objects.LabelWrapper _label2 = null;
public anywheresoftware.b4a.objects.ButtonWrapper _analisis = null;
public anywheresoftware.b4a.objects.LabelWrapper _concepto = null;
public anywheresoftware.b4a.objects.LabelWrapper _concepto1 = null;
public anywheresoftware.b4a.objects.LabelWrapper _concepto2 = null;
public anywheresoftware.b4a.objects.LabelWrapper _concepto3 = null;
public anywheresoftware.b4a.objects.LabelWrapper _concepto4 = null;
public anywheresoftware.b4a.objects.LabelWrapper _concepto5 = null;
public anywheresoftware.b4a.objects.LabelWrapper _concepto6 = null;
public anywheresoftware.b4a.objects.LabelWrapper _concepto7 = null;
public anywheresoftware.b4a.objects.LabelWrapper _datos = null;
public anywheresoftware.b4a.objects.LabelWrapper _datos1 = null;
public anywheresoftware.b4a.objects.LabelWrapper _datos2 = null;
public anywheresoftware.b4a.objects.LabelWrapper _datos3 = null;
public anywheresoftware.b4a.objects.LabelWrapper _datos4 = null;
public anywheresoftware.b4a.objects.LabelWrapper _datos5 = null;
public anywheresoftware.b4a.objects.LabelWrapper _datos6 = null;
public anywheresoftware.b4a.objects.LabelWrapper _datos7 = null;
public anywheresoftware.b4a.objects.ButtonWrapper _er = null;
public anywheresoftware.b4a.objects.PanelWrapper _panel1 = null;
public anywheresoftware.b4a.objects.PanelWrapper _panel2 = null;
public anywheresoftware.b4a.objects.ButtonWrapper _regresar2 = null;
public anywheresoftware.b4a.objects.ButtonWrapper _infoub = null;
public anywheresoftware.b4a.objects.ButtonWrapper _infoum = null;
public anywheresoftware.b4a.objects.PanelWrapper _panelbarras = null;
public mpandroidchartwrapper.horizontalBarChartWrapper _mbc1 = null;
public anywheresoftware.b4a.objects.ButtonWrapper _regresar = null;
public anywheresoftware.b4a.objects.ButtonWrapper _regresar1 = null;
public b4a.FinanzasC.starter _starter = null;

public static boolean isAnyActivityVisible() {
    boolean vis = false;
vis = vis | (main.mostCurrent != null);
return vis;}
public static String  _activity_create(boolean _firsttime) throws Exception{
b4a.FinanzasC.b4xformatter._b4xformatdata _defaultformat = null;
b4a.FinanzasC.b4xformatter._b4xformatdata _negativeformat = null;
 //BA.debugLineNum = 88;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
 //BA.debugLineNum = 90;BA.debugLine="Activity.LoadLayout(\"Pantalla1\")";
mostCurrent._activity.LoadLayout("Pantalla1",mostCurrent.activityBA);
 //BA.debugLineNum = 92;BA.debugLine="If FirstTime Then";
if (_firsttime) { 
 //BA.debugLineNum = 93;BA.debugLine="formatter.Initialize";
_formatter._initialize /*String*/ (processBA);
 //BA.debugLineNum = 94;BA.debugLine="Dim DefaultFormat As B4XFormatData = formatter.G";
_defaultformat = _formatter._getdefaultformat /*b4a.FinanzasC.b4xformatter._b4xformatdata*/ ();
 //BA.debugLineNum = 95;BA.debugLine="DefaultFormat.MaximumFractions = 2";
_defaultformat.MaximumFractions /*int*/  = (int) (2);
 //BA.debugLineNum = 96;BA.debugLine="DefaultFormat.MinimumFractions = 2";
_defaultformat.MinimumFractions /*int*/  = (int) (2);
 //BA.debugLineNum = 97;BA.debugLine="DefaultFormat.Prefix = \"$ \"";
_defaultformat.Prefix /*String*/  = "$ ";
 //BA.debugLineNum = 98;BA.debugLine="Dim NegativeFormat As B4XFormatData = formatter.";
_negativeformat = _formatter._copyformatdata /*b4a.FinanzasC.b4xformatter._b4xformatdata*/ (_defaultformat);
 //BA.debugLineNum = 99;BA.debugLine="NegativeFormat.TextColor = xui.Color_Red";
_negativeformat.TextColor /*int*/  = _xui.Color_Red;
 //BA.debugLineNum = 100;BA.debugLine="NegativeFormat.Prefix = \"$ (\"";
_negativeformat.Prefix /*String*/  = "$ (";
 //BA.debugLineNum = 101;BA.debugLine="NegativeFormat.Postfix = \")\"";
_negativeformat.Postfix /*String*/  = ")";
 //BA.debugLineNum = 102;BA.debugLine="NegativeFormat.FormatFont = xui.CreateDefaultBol";
_negativeformat.FormatFont /*anywheresoftware.b4a.objects.B4XViewWrapper.B4XFont*/  = _xui.CreateDefaultBoldFont((float) (15));
 //BA.debugLineNum = 103;BA.debugLine="formatter.AddFormatData(NegativeFormat, formatte";
_formatter._addformatdata /*String*/ (_negativeformat,_formatter._min_value /*int*/ ,0,anywheresoftware.b4a.keywords.Common.False);
 };
 //BA.debugLineNum = 106;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
 //BA.debugLineNum = 112;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
 //BA.debugLineNum = 114;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
 //BA.debugLineNum = 108;BA.debugLine="Sub Activity_Resume";
 //BA.debugLineNum = 110;BA.debugLine="End Sub";
return "";
}
public static String  _analisis_click() throws Exception{
de.donmanfred.XLSSheetwrapper _sheet = null;
de.donmanfred.XSSFRowwrapper _row = null;
de.donmanfred.XSSFCellwrapper _cell = null;
 //BA.debugLineNum = 154;BA.debugLine="Private Sub Analisis_Click";
 //BA.debugLineNum = 156;BA.debugLine="Activity.RemoveAllViews";
mostCurrent._activity.RemoveAllViews();
 //BA.debugLineNum = 157;BA.debugLine="Activity.LoadLayout(\"Analisis\")";
mostCurrent._activity.LoadLayout("Analisis",mostCurrent.activityBA);
 //BA.debugLineNum = 159;BA.debugLine="File.Copy(File.DirAssets,archivo,File.DirRootExte";
anywheresoftware.b4a.keywords.Common.File.Copy(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),mostCurrent._archivo,anywheresoftware.b4a.keywords.Common.File.getDirRootExternal(),mostCurrent._archivo);
 //BA.debugLineNum = 160;BA.debugLine="xls.Initialize(\"\",File.Combine(File.DirRootExtern";
_xls.Initialize(processBA,"",anywheresoftware.b4a.keywords.Common.File.Combine(anywheresoftware.b4a.keywords.Common.File.getDirRootExternal(),mostCurrent._archivo));
 //BA.debugLineNum = 162;BA.debugLine="Dim sheet As XLSSheet = xls.getSheetAt(xls.Active";
_sheet = new de.donmanfred.XLSSheetwrapper();
_sheet = _xls.getSheetAt(_xls.getActiveSheetIndex());
 //BA.debugLineNum = 165;BA.debugLine="Dim row As XSSFRow =sheet.getRow(0)";
_row = new de.donmanfred.XSSFRowwrapper();
_row = (de.donmanfred.XSSFRowwrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new de.donmanfred.XSSFRowwrapper(), (org.apache.poi.xssf.usermodel.XSSFRow)(_sheet.getRow((int) (0))));
 //BA.debugLineNum = 166;BA.debugLine="Dim Cell As XSSFCell =row.getCell(0)";
_cell = new de.donmanfred.XSSFCellwrapper();
_cell = _row.getCell((int) (0));
 //BA.debugLineNum = 168;BA.debugLine="row=sheet.getRow(1)";
_row = (de.donmanfred.XSSFRowwrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new de.donmanfred.XSSFRowwrapper(), (org.apache.poi.xssf.usermodel.XSSFRow)(_sheet.getRow((int) (1))));
 //BA.debugLineNum = 169;BA.debugLine="Cell=row.getCell(2)";
_cell = _row.getCell((int) (2));
 //BA.debugLineNum = 170;BA.debugLine="Ingresos_ = Cell.NumericCellValue";
_ingresos_ = (float) (_cell.getNumericCellValue());
 //BA.debugLineNum = 172;BA.debugLine="row=sheet.getRow(2)";
_row = (de.donmanfred.XSSFRowwrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new de.donmanfred.XSSFRowwrapper(), (org.apache.poi.xssf.usermodel.XSSFRow)(_sheet.getRow((int) (2))));
 //BA.debugLineNum = 173;BA.debugLine="Cell=row.getCell(2)";
_cell = _row.getCell((int) (2));
 //BA.debugLineNum = 174;BA.debugLine="GOp = Cell.NumericCellValue";
_gop = (float) (_cell.getNumericCellValue());
 //BA.debugLineNum = 176;BA.debugLine="row=sheet.getRow(3)";
_row = (de.donmanfred.XSSFRowwrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new de.donmanfred.XSSFRowwrapper(), (org.apache.poi.xssf.usermodel.XSSFRow)(_sheet.getRow((int) (3))));
 //BA.debugLineNum = 177;BA.debugLine="Cell=row.getCell(2)";
_cell = _row.getCell((int) (2));
 //BA.debugLineNum = 178;BA.debugLine="UtilidadB = Cell.NumericCellValue";
_utilidadb = (float) (_cell.getNumericCellValue());
 //BA.debugLineNum = 180;BA.debugLine="row=sheet.getRow(4)";
_row = (de.donmanfred.XSSFRowwrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new de.donmanfred.XSSFRowwrapper(), (org.apache.poi.xssf.usermodel.XSSFRow)(_sheet.getRow((int) (4))));
 //BA.debugLineNum = 181;BA.debugLine="Cell=row.getCell(2)";
_cell = _row.getCell((int) (2));
 //BA.debugLineNum = 182;BA.debugLine="Gadm = Cell.NumericCellValue";
_gadm = (float) (_cell.getNumericCellValue());
 //BA.debugLineNum = 184;BA.debugLine="row=sheet.getRow(5)";
_row = (de.donmanfred.XSSFRowwrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new de.donmanfred.XSSFRowwrapper(), (org.apache.poi.xssf.usermodel.XSSFRow)(_sheet.getRow((int) (5))));
 //BA.debugLineNum = 185;BA.debugLine="Cell=row.getCell(2)";
_cell = _row.getCell((int) (2));
 //BA.debugLineNum = 186;BA.debugLine="UtilidadOai = Cell.NumericCellValue";
_utilidadoai = (float) (_cell.getNumericCellValue());
 //BA.debugLineNum = 188;BA.debugLine="row=sheet.getRow(6)";
_row = (de.donmanfred.XSSFRowwrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new de.donmanfred.XSSFRowwrapper(), (org.apache.poi.xssf.usermodel.XSSFRow)(_sheet.getRow((int) (6))));
 //BA.debugLineNum = 189;BA.debugLine="Cell=row.getCell(2)";
_cell = _row.getCell((int) (2));
 //BA.debugLineNum = 190;BA.debugLine="Impuestos = Cell.NumericCellValue";
_impuestos = (float) (_cell.getNumericCellValue());
 //BA.debugLineNum = 192;BA.debugLine="row=sheet.getRow(7)";
_row = (de.donmanfred.XSSFRowwrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new de.donmanfred.XSSFRowwrapper(), (org.apache.poi.xssf.usermodel.XSSFRow)(_sheet.getRow((int) (7))));
 //BA.debugLineNum = 193;BA.debugLine="Cell=row.getCell(2)";
_cell = _row.getCell((int) (2));
 //BA.debugLineNum = 194;BA.debugLine="UOperativaDesp_Imp = Cell.NumericCellValue";
_uoperativadesp_imp = (float) (_cell.getNumericCellValue());
 //BA.debugLineNum = 197;BA.debugLine="End Sub";
return "";
}
public static void  _boton_click() throws Exception{
ResumableSub_Boton_Click rsub = new ResumableSub_Boton_Click(null);
rsub.resume(processBA, null);
}
public static class ResumableSub_Boton_Click extends BA.ResumableSub {
public ResumableSub_Boton_Click(b4a.FinanzasC.main parent) {
this.parent = parent;
}
b4a.FinanzasC.main parent;
anywheresoftware.b4a.agraham.dialogs.InputDialog.FileDialog _fd = null;
Object _sf = null;
int _result = 0;

@Override
public void resume(BA ba, Object[] result) throws Exception{

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
 //BA.debugLineNum = 133;BA.debugLine="MsgboxAsync(\"Recuerda que para poder acceder a lo";
anywheresoftware.b4a.keywords.Common.MsgboxAsync(BA.ObjectToCharSequence("Recuerda que para poder acceder a los archivos primero necesitas ir a Configuración, Aplicaciones, buscar por el nombre de la aplicación 'FINANZAS CONTIGO' y dar permiso al acceso a los archivos y a la lectura de archivos"),BA.ObjectToCharSequence("HABILITACIÓN DE ACCESO"),processBA);
 //BA.debugLineNum = 134;BA.debugLine="Dim fd As FileDialog";
_fd = new anywheresoftware.b4a.agraham.dialogs.InputDialog.FileDialog();
 //BA.debugLineNum = 135;BA.debugLine="fd.FastScroll = True";
_fd.setFastScroll(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 136;BA.debugLine="fd.ShowOnlyFolders=False";
_fd.setShowOnlyFolders(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 137;BA.debugLine="fd.TextColor=Colors.Black";
_fd.TextColor = anywheresoftware.b4a.keywords.Common.Colors.Black;
 //BA.debugLineNum = 138;BA.debugLine="fd.FilePath = File.DirRootExternal";
_fd.setFilePath(anywheresoftware.b4a.keywords.Common.File.getDirRootExternal());
 //BA.debugLineNum = 139;BA.debugLine="fd.FileFilter = \".xlsx\"";
_fd.setFileFilter(".xlsx");
 //BA.debugLineNum = 140;BA.debugLine="Dim sf As Object = fd.ShowAsync(\"Seleccionar Arch";
_sf = _fd.ShowAsync(BA.ObjectToCharSequence("Seleccionar Archivo"),"SELECCIONAR","Cancelar","",mostCurrent.activityBA,(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null),anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 141;BA.debugLine="Wait For (sf) Dialog_Result(Result As Int)";
anywheresoftware.b4a.keywords.Common.WaitFor("dialog_result", processBA, this, _sf);
this.state = 5;
return;
case 5:
//C
this.state = 1;
_result = (Integer) result[0];
;
 //BA.debugLineNum = 142;BA.debugLine="If Result = DialogResponse.POSITIVE Then";
if (true) break;

case 1:
//if
this.state = 4;
if (_result==anywheresoftware.b4a.keywords.Common.DialogResponse.POSITIVE) { 
this.state = 3;
}if (true) break;

case 3:
//C
this.state = 4;
 //BA.debugLineNum = 143;BA.debugLine="Log(\"File path: \" & fd.FilePath)";
anywheresoftware.b4a.keywords.Common.LogImpl("1458763","File path: "+_fd.getFilePath(),0);
 //BA.debugLineNum = 144;BA.debugLine="archivo = fd.ChosenName";
parent.mostCurrent._archivo = _fd.getChosenName();
 //BA.debugLineNum = 145;BA.debugLine="Log(\"File name: \" & archivo)";
anywheresoftware.b4a.keywords.Common.LogImpl("1458765","File name: "+parent.mostCurrent._archivo,0);
 if (true) break;

case 4:
//C
this.state = -1;
;
 //BA.debugLineNum = 147;BA.debugLine="Label1.Text = \"Ruta = \" & fd.FilePath";
parent.mostCurrent._label1.setText(BA.ObjectToCharSequence("Ruta = "+_fd.getFilePath()));
 //BA.debugLineNum = 148;BA.debugLine="Label2.Text = \"Nombre del Archivo = \" & fd.Chosen";
parent.mostCurrent._label2.setText(BA.ObjectToCharSequence("Nombre del Archivo = "+_fd.getChosenName()));
 //BA.debugLineNum = 150;BA.debugLine="Log(\"File path: \" & archivo)";
anywheresoftware.b4a.keywords.Common.LogImpl("1458770","File path: "+parent.mostCurrent._archivo,0);
 //BA.debugLineNum = 152;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public static void  _dialog_result(int _result) throws Exception{
}
public static String  _er_click() throws Exception{
de.donmanfred.XLSSheetwrapper _sheet = null;
de.donmanfred.XSSFRowwrapper _row = null;
de.donmanfred.XSSFCellwrapper _cell = null;
String _texto1 = "";
 //BA.debugLineNum = 199;BA.debugLine="Private Sub ER_Click";
 //BA.debugLineNum = 200;BA.debugLine="File.Copy(File.DirAssets,archivo,File.DirRootExte";
anywheresoftware.b4a.keywords.Common.File.Copy(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),mostCurrent._archivo,anywheresoftware.b4a.keywords.Common.File.getDirRootExternal(),mostCurrent._archivo);
 //BA.debugLineNum = 201;BA.debugLine="xls.Initialize(\"\",File.Combine(File.DirRootExtern";
_xls.Initialize(processBA,"",anywheresoftware.b4a.keywords.Common.File.Combine(anywheresoftware.b4a.keywords.Common.File.getDirRootExternal(),mostCurrent._archivo));
 //BA.debugLineNum = 203;BA.debugLine="Dim sheet As XLSSheet = xls.getSheetAt(xls.Active";
_sheet = new de.donmanfred.XLSSheetwrapper();
_sheet = _xls.getSheetAt(_xls.getActiveSheetIndex());
 //BA.debugLineNum = 207;BA.debugLine="Activity.RemoveAllViews";
mostCurrent._activity.RemoveAllViews();
 //BA.debugLineNum = 208;BA.debugLine="Activity.LoadLayout(\"EstadoResultados\")";
mostCurrent._activity.LoadLayout("EstadoResultados",mostCurrent.activityBA);
 //BA.debugLineNum = 209;BA.debugLine="Dim row As XSSFRow =sheet.getRow(0)";
_row = new de.donmanfred.XSSFRowwrapper();
_row = (de.donmanfred.XSSFRowwrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new de.donmanfred.XSSFRowwrapper(), (org.apache.poi.xssf.usermodel.XSSFRow)(_sheet.getRow((int) (0))));
 //BA.debugLineNum = 210;BA.debugLine="Dim Cell As XSSFCell =row.getCell(0)";
_cell = new de.donmanfred.XSSFCellwrapper();
_cell = _row.getCell((int) (0));
 //BA.debugLineNum = 212;BA.debugLine="Dim Texto1 As String = NumberFormat2(0, 1, 2, 2,";
_texto1 = anywheresoftware.b4a.keywords.Common.NumberFormat2(0,(int) (1),(int) (2),(int) (2),anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 213;BA.debugLine="Texto1 = Cell.StringCellValue";
_texto1 = _cell.getStringCellValue();
 //BA.debugLineNum = 214;BA.debugLine="Concepto.text= Texto1";
mostCurrent._concepto.setText(BA.ObjectToCharSequence(_texto1));
 //BA.debugLineNum = 216;BA.debugLine="row=sheet.getRow(1)";
_row = (de.donmanfred.XSSFRowwrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new de.donmanfred.XSSFRowwrapper(), (org.apache.poi.xssf.usermodel.XSSFRow)(_sheet.getRow((int) (1))));
 //BA.debugLineNum = 217;BA.debugLine="Cell=row.getCell(0)";
_cell = _row.getCell((int) (0));
 //BA.debugLineNum = 218;BA.debugLine="Texto1 = Cell.StringCellValue";
_texto1 = _cell.getStringCellValue();
 //BA.debugLineNum = 220;BA.debugLine="Concepto1.text= Texto1";
mostCurrent._concepto1.setText(BA.ObjectToCharSequence(_texto1));
 //BA.debugLineNum = 222;BA.debugLine="row=sheet.getRow(2)";
_row = (de.donmanfred.XSSFRowwrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new de.donmanfred.XSSFRowwrapper(), (org.apache.poi.xssf.usermodel.XSSFRow)(_sheet.getRow((int) (2))));
 //BA.debugLineNum = 223;BA.debugLine="Cell=row.getCell(0)";
_cell = _row.getCell((int) (0));
 //BA.debugLineNum = 224;BA.debugLine="Texto1 = Cell.StringCellValue";
_texto1 = _cell.getStringCellValue();
 //BA.debugLineNum = 225;BA.debugLine="Concepto2.text= Texto1";
mostCurrent._concepto2.setText(BA.ObjectToCharSequence(_texto1));
 //BA.debugLineNum = 227;BA.debugLine="row=sheet.getRow(3)";
_row = (de.donmanfred.XSSFRowwrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new de.donmanfred.XSSFRowwrapper(), (org.apache.poi.xssf.usermodel.XSSFRow)(_sheet.getRow((int) (3))));
 //BA.debugLineNum = 228;BA.debugLine="Cell=row.getCell(0)";
_cell = _row.getCell((int) (0));
 //BA.debugLineNum = 229;BA.debugLine="Texto1 = Cell.StringCellValue";
_texto1 = _cell.getStringCellValue();
 //BA.debugLineNum = 230;BA.debugLine="Concepto3.text= Texto1";
mostCurrent._concepto3.setText(BA.ObjectToCharSequence(_texto1));
 //BA.debugLineNum = 232;BA.debugLine="row=sheet.getRow(4)";
_row = (de.donmanfred.XSSFRowwrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new de.donmanfred.XSSFRowwrapper(), (org.apache.poi.xssf.usermodel.XSSFRow)(_sheet.getRow((int) (4))));
 //BA.debugLineNum = 233;BA.debugLine="Cell=row.getCell(0)";
_cell = _row.getCell((int) (0));
 //BA.debugLineNum = 234;BA.debugLine="Texto1 = Cell.StringCellValue";
_texto1 = _cell.getStringCellValue();
 //BA.debugLineNum = 235;BA.debugLine="Concepto4.text= Texto1";
mostCurrent._concepto4.setText(BA.ObjectToCharSequence(_texto1));
 //BA.debugLineNum = 237;BA.debugLine="row=sheet.getRow(5)";
_row = (de.donmanfred.XSSFRowwrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new de.donmanfred.XSSFRowwrapper(), (org.apache.poi.xssf.usermodel.XSSFRow)(_sheet.getRow((int) (5))));
 //BA.debugLineNum = 238;BA.debugLine="Cell=row.getCell(0)";
_cell = _row.getCell((int) (0));
 //BA.debugLineNum = 239;BA.debugLine="Texto1 = Cell.StringCellValue";
_texto1 = _cell.getStringCellValue();
 //BA.debugLineNum = 240;BA.debugLine="Concepto5.text= Texto1";
mostCurrent._concepto5.setText(BA.ObjectToCharSequence(_texto1));
 //BA.debugLineNum = 242;BA.debugLine="row=sheet.getRow(6)";
_row = (de.donmanfred.XSSFRowwrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new de.donmanfred.XSSFRowwrapper(), (org.apache.poi.xssf.usermodel.XSSFRow)(_sheet.getRow((int) (6))));
 //BA.debugLineNum = 243;BA.debugLine="Cell=row.getCell(0)";
_cell = _row.getCell((int) (0));
 //BA.debugLineNum = 244;BA.debugLine="Texto1 = Cell.StringCellValue";
_texto1 = _cell.getStringCellValue();
 //BA.debugLineNum = 245;BA.debugLine="Concepto6.text= Texto1";
mostCurrent._concepto6.setText(BA.ObjectToCharSequence(_texto1));
 //BA.debugLineNum = 247;BA.debugLine="row=sheet.getRow(7)";
_row = (de.donmanfred.XSSFRowwrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new de.donmanfred.XSSFRowwrapper(), (org.apache.poi.xssf.usermodel.XSSFRow)(_sheet.getRow((int) (7))));
 //BA.debugLineNum = 248;BA.debugLine="Cell=row.getCell(0)";
_cell = _row.getCell((int) (0));
 //BA.debugLineNum = 249;BA.debugLine="Texto1 = Cell.StringCellValue";
_texto1 = _cell.getStringCellValue();
 //BA.debugLineNum = 250;BA.debugLine="Concepto7.text= Texto1";
mostCurrent._concepto7.setText(BA.ObjectToCharSequence(_texto1));
 //BA.debugLineNum = 252;BA.debugLine="row=sheet.getRow(0)";
_row = (de.donmanfred.XSSFRowwrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new de.donmanfred.XSSFRowwrapper(), (org.apache.poi.xssf.usermodel.XSSFRow)(_sheet.getRow((int) (0))));
 //BA.debugLineNum = 253;BA.debugLine="Cell=row.getCell(2)";
_cell = _row.getCell((int) (2));
 //BA.debugLineNum = 254;BA.debugLine="Texto1 = Cell.StringCellValue";
_texto1 = _cell.getStringCellValue();
 //BA.debugLineNum = 255;BA.debugLine="Datos.text= Texto1";
mostCurrent._datos.setText(BA.ObjectToCharSequence(_texto1));
 //BA.debugLineNum = 257;BA.debugLine="row=sheet.getRow(1)";
_row = (de.donmanfred.XSSFRowwrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new de.donmanfred.XSSFRowwrapper(), (org.apache.poi.xssf.usermodel.XSSFRow)(_sheet.getRow((int) (1))));
 //BA.debugLineNum = 258;BA.debugLine="Cell=row.getCell(2)";
_cell = _row.getCell((int) (2));
 //BA.debugLineNum = 259;BA.debugLine="Texto1 = formatter.Format(Cell.NumericCellValue)";
_texto1 = _formatter._format /*String*/ (_cell.getNumericCellValue());
 //BA.debugLineNum = 260;BA.debugLine="Datos1.text= Texto1";
mostCurrent._datos1.setText(BA.ObjectToCharSequence(_texto1));
 //BA.debugLineNum = 262;BA.debugLine="row=sheet.getRow(2)";
_row = (de.donmanfred.XSSFRowwrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new de.donmanfred.XSSFRowwrapper(), (org.apache.poi.xssf.usermodel.XSSFRow)(_sheet.getRow((int) (2))));
 //BA.debugLineNum = 263;BA.debugLine="Cell=row.getCell(2)";
_cell = _row.getCell((int) (2));
 //BA.debugLineNum = 264;BA.debugLine="Texto1 = formatter.Format(Cell.NumericCellValue)";
_texto1 = _formatter._format /*String*/ (_cell.getNumericCellValue());
 //BA.debugLineNum = 265;BA.debugLine="Datos2.text= Texto1";
mostCurrent._datos2.setText(BA.ObjectToCharSequence(_texto1));
 //BA.debugLineNum = 267;BA.debugLine="row=sheet.getRow(3)";
_row = (de.donmanfred.XSSFRowwrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new de.donmanfred.XSSFRowwrapper(), (org.apache.poi.xssf.usermodel.XSSFRow)(_sheet.getRow((int) (3))));
 //BA.debugLineNum = 268;BA.debugLine="Cell=row.getCell(2)";
_cell = _row.getCell((int) (2));
 //BA.debugLineNum = 269;BA.debugLine="Texto1 = formatter.Format(Cell.NumericCellValue)";
_texto1 = _formatter._format /*String*/ (_cell.getNumericCellValue());
 //BA.debugLineNum = 270;BA.debugLine="Datos3.text= Texto1";
mostCurrent._datos3.setText(BA.ObjectToCharSequence(_texto1));
 //BA.debugLineNum = 272;BA.debugLine="row=sheet.getRow(4)";
_row = (de.donmanfred.XSSFRowwrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new de.donmanfred.XSSFRowwrapper(), (org.apache.poi.xssf.usermodel.XSSFRow)(_sheet.getRow((int) (4))));
 //BA.debugLineNum = 273;BA.debugLine="Cell=row.getCell(2)";
_cell = _row.getCell((int) (2));
 //BA.debugLineNum = 274;BA.debugLine="Texto1 = formatter.Format(Cell.NumericCellValue)";
_texto1 = _formatter._format /*String*/ (_cell.getNumericCellValue());
 //BA.debugLineNum = 275;BA.debugLine="Datos4.text= Texto1";
mostCurrent._datos4.setText(BA.ObjectToCharSequence(_texto1));
 //BA.debugLineNum = 277;BA.debugLine="row=sheet.getRow(5)";
_row = (de.donmanfred.XSSFRowwrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new de.donmanfred.XSSFRowwrapper(), (org.apache.poi.xssf.usermodel.XSSFRow)(_sheet.getRow((int) (5))));
 //BA.debugLineNum = 278;BA.debugLine="Cell=row.getCell(2)";
_cell = _row.getCell((int) (2));
 //BA.debugLineNum = 279;BA.debugLine="Texto1 = formatter.Format(Cell.NumericCellValue)";
_texto1 = _formatter._format /*String*/ (_cell.getNumericCellValue());
 //BA.debugLineNum = 280;BA.debugLine="Datos5.text= Texto1";
mostCurrent._datos5.setText(BA.ObjectToCharSequence(_texto1));
 //BA.debugLineNum = 282;BA.debugLine="row=sheet.getRow(6)";
_row = (de.donmanfred.XSSFRowwrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new de.donmanfred.XSSFRowwrapper(), (org.apache.poi.xssf.usermodel.XSSFRow)(_sheet.getRow((int) (6))));
 //BA.debugLineNum = 283;BA.debugLine="Cell=row.getCell(2)";
_cell = _row.getCell((int) (2));
 //BA.debugLineNum = 284;BA.debugLine="Texto1 = formatter.Format(Cell.NumericCellValue)";
_texto1 = _formatter._format /*String*/ (_cell.getNumericCellValue());
 //BA.debugLineNum = 285;BA.debugLine="Datos6.text= Texto1";
mostCurrent._datos6.setText(BA.ObjectToCharSequence(_texto1));
 //BA.debugLineNum = 287;BA.debugLine="row=sheet.getRow(7)";
_row = (de.donmanfred.XSSFRowwrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new de.donmanfred.XSSFRowwrapper(), (org.apache.poi.xssf.usermodel.XSSFRow)(_sheet.getRow((int) (7))));
 //BA.debugLineNum = 288;BA.debugLine="Cell=row.getCell(2)";
_cell = _row.getCell((int) (2));
 //BA.debugLineNum = 289;BA.debugLine="Texto1 = formatter.Format(Cell.NumericCellValue)";
_texto1 = _formatter._format /*String*/ (_cell.getNumericCellValue());
 //BA.debugLineNum = 290;BA.debugLine="Datos7.text= Texto1";
mostCurrent._datos7.setText(BA.ObjectToCharSequence(_texto1));
 //BA.debugLineNum = 291;BA.debugLine="End Sub";
return "";
}
public static String  _globals() throws Exception{
 //BA.debugLineNum = 31;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 34;BA.debugLine="Private INICIAR As Button";
mostCurrent._iniciar = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 36;BA.debugLine="Private info As Button";
mostCurrent._info = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 37;BA.debugLine="Dim Usuario As String";
mostCurrent._usuario = "";
 //BA.debugLineNum = 38;BA.debugLine="Dim archivo As String";
mostCurrent._archivo = "";
 //BA.debugLineNum = 41;BA.debugLine="Private Nombre As EditText";
mostCurrent._nombre = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 43;BA.debugLine="Usuario = Nombre";
mostCurrent._usuario = BA.ObjectToString(mostCurrent._nombre);
 //BA.debugLineNum = 45;BA.debugLine="Dim Ingresos As Button";
mostCurrent._ingresos = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 46;BA.debugLine="Dim Gadm As Float";
_gadm = 0f;
 //BA.debugLineNum = 47;BA.debugLine="Dim GOp As Float";
_gop = 0f;
 //BA.debugLineNum = 48;BA.debugLine="Dim Ingresos_, UtilidadB, UtilidadOai, Impuestos,";
_ingresos_ = 0f;
_utilidadb = 0f;
_utilidadoai = 0f;
_impuestos = 0f;
_uoperativadesp_imp = 0f;
 //BA.debugLineNum = 52;BA.debugLine="Private HiUsuario As Label";
mostCurrent._hiusuario = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 54;BA.debugLine="Private Boton As Button";
mostCurrent._boton = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 56;BA.debugLine="Private Label1 As Label";
mostCurrent._label1 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 57;BA.debugLine="Private Label2 As Label";
mostCurrent._label2 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 58;BA.debugLine="Private Analisis As Button";
mostCurrent._analisis = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 59;BA.debugLine="Private Concepto As Label";
mostCurrent._concepto = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 60;BA.debugLine="Private Concepto1 As Label";
mostCurrent._concepto1 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 61;BA.debugLine="Private Concepto2 As Label";
mostCurrent._concepto2 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 62;BA.debugLine="Private Concepto3 As Label";
mostCurrent._concepto3 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 63;BA.debugLine="Private Concepto4 As Label";
mostCurrent._concepto4 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 64;BA.debugLine="Private Concepto5 As Label";
mostCurrent._concepto5 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 65;BA.debugLine="Private Concepto6 As Label";
mostCurrent._concepto6 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 66;BA.debugLine="Private Concepto7 As Label";
mostCurrent._concepto7 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 67;BA.debugLine="Private Datos As Label";
mostCurrent._datos = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 68;BA.debugLine="Private Datos1 As Label";
mostCurrent._datos1 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 69;BA.debugLine="Private Datos2 As Label";
mostCurrent._datos2 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 70;BA.debugLine="Private Datos3 As Label";
mostCurrent._datos3 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 71;BA.debugLine="Private Datos4 As Label";
mostCurrent._datos4 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 72;BA.debugLine="Private Datos5 As Label";
mostCurrent._datos5 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 73;BA.debugLine="Private Datos6 As Label";
mostCurrent._datos6 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 74;BA.debugLine="Private Datos7 As Label";
mostCurrent._datos7 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 75;BA.debugLine="Private ER As Button";
mostCurrent._er = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 76;BA.debugLine="Private Panel1 As Panel";
mostCurrent._panel1 = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 77;BA.debugLine="Private Panel2 As Panel";
mostCurrent._panel2 = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 78;BA.debugLine="Private Regresar2 As Button";
mostCurrent._regresar2 = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 79;BA.debugLine="Private infoUB As Button";
mostCurrent._infoub = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 80;BA.debugLine="Private infoUM As Button";
mostCurrent._infoum = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 81;BA.debugLine="Private Panelbarras As Panel";
mostCurrent._panelbarras = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 82;BA.debugLine="Private mbc1 As HorizontalBarChart";
mostCurrent._mbc1 = new mpandroidchartwrapper.horizontalBarChartWrapper();
 //BA.debugLineNum = 83;BA.debugLine="Private Regresar As Button";
mostCurrent._regresar = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 84;BA.debugLine="Private Regresar1 As Button";
mostCurrent._regresar1 = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 85;BA.debugLine="End Sub";
return "";
}
public static String  _info_click() throws Exception{
 //BA.debugLineNum = 126;BA.debugLine="Private Sub info_Click";
 //BA.debugLineNum = 127;BA.debugLine="MsgboxAsync(\"Recuerda verificar que el archivo ele";
anywheresoftware.b4a.keywords.Common.MsgboxAsync(BA.ObjectToCharSequence("Recuerda verificar que el archivo elegido es el correcto"),BA.ObjectToCharSequence("INFORMACIÓN"),processBA);
 //BA.debugLineNum = 130;BA.debugLine="End Sub";
return "";
}
public static void  _infoub_click() throws Exception{
ResumableSub_infoUB_Click rsub = new ResumableSub_infoUB_Click(null);
rsub.resume(processBA, null);
}
public static class ResumableSub_infoUB_Click extends BA.ResumableSub {
public ResumableSub_infoUB_Click(b4a.FinanzasC.main parent) {
this.parent = parent;
}
b4a.FinanzasC.main parent;
Object _sf = null;
int _result = 0;
anywheresoftware.b4a.phone.Phone.PhoneIntents _p = null;
String _url = "";

@Override
public void resume(BA ba, Object[] result) throws Exception{

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
 //BA.debugLineNum = 354;BA.debugLine="Dim sf As Object = xui.Msgbox2Async(\"La utilidad";
_sf = parent._xui.Msgbox2Async(processBA,BA.ObjectToCharSequence("La utilidad bruta, también conocida como utilidad de las ventas o ingresos brutos, es la ganancia que obtiene una compañía después de deducir los costos asociados con la fabricación y venta de sus productos, o los costos asociados con la prestación de sus servicios. "),BA.ObjectToCharSequence("¿Que es la Utilidad Bruta?"),"MAS INFORMACIÓN","","Cerrar",(anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper(), (android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null)));
 //BA.debugLineNum = 355;BA.debugLine="Wait For (sf) Msgbox_Result (Result As Int)";
anywheresoftware.b4a.keywords.Common.WaitFor("msgbox_result", processBA, this, _sf);
this.state = 5;
return;
case 5:
//C
this.state = 1;
_result = (Integer) result[0];
;
 //BA.debugLineNum = 356;BA.debugLine="If Result = xui.DialogResponse_Positive Then";
if (true) break;

case 1:
//if
this.state = 4;
if (_result==parent._xui.DialogResponse_Positive) { 
this.state = 3;
}if (true) break;

case 3:
//C
this.state = 4;
 //BA.debugLineNum = 357;BA.debugLine="Dim p As PhoneIntents";
_p = new anywheresoftware.b4a.phone.Phone.PhoneIntents();
 //BA.debugLineNum = 358;BA.debugLine="Dim url As String";
_url = "";
 //BA.debugLineNum = 359;BA.debugLine="url = \"https://www.lifeder.com/utilidad-bruta/\"";
_url = "https://www.lifeder.com/utilidad-bruta/";
 //BA.debugLineNum = 360;BA.debugLine="StartActivity(p.OpenBrowser(url))";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(_p.OpenBrowser(_url)));
 if (true) break;

case 4:
//C
this.state = -1;
;
 //BA.debugLineNum = 362;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public static void  _msgbox_result(int _result) throws Exception{
}
public static void  _infoum_click() throws Exception{
ResumableSub_infoUM_Click rsub = new ResumableSub_infoUM_Click(null);
rsub.resume(processBA, null);
}
public static class ResumableSub_infoUM_Click extends BA.ResumableSub {
public ResumableSub_infoUM_Click(b4a.FinanzasC.main parent) {
this.parent = parent;
}
b4a.FinanzasC.main parent;
Object _sf = null;
int _result = 0;
anywheresoftware.b4a.phone.Phone.PhoneIntents _p = null;
String _url = "";

@Override
public void resume(BA ba, Object[] result) throws Exception{

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
 //BA.debugLineNum = 366;BA.debugLine="Dim sf As Object = xui.Msgbox2Async(\"La utilidad";
_sf = parent._xui.Msgbox2Async(processBA,BA.ObjectToCharSequence("La utilidad de operación u operacional es un valor contable que mide la ganancia obtenida por una empresa a través de sus principales operaciones comerciales, excluyendo deducciones por los intereses e impuestos "),BA.ObjectToCharSequence("¿Que es la Utilidad de Operación?"),"MAS INFORMACIÓN","","Cerrar",(anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper(), (android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null)));
 //BA.debugLineNum = 367;BA.debugLine="Wait For (sf) Msgbox_Result (Result As Int)";
anywheresoftware.b4a.keywords.Common.WaitFor("msgbox_result", processBA, this, _sf);
this.state = 5;
return;
case 5:
//C
this.state = 1;
_result = (Integer) result[0];
;
 //BA.debugLineNum = 368;BA.debugLine="If Result = xui.DialogResponse_Positive Then";
if (true) break;

case 1:
//if
this.state = 4;
if (_result==parent._xui.DialogResponse_Positive) { 
this.state = 3;
}if (true) break;

case 3:
//C
this.state = 4;
 //BA.debugLineNum = 369;BA.debugLine="Dim p As PhoneIntents";
_p = new anywheresoftware.b4a.phone.Phone.PhoneIntents();
 //BA.debugLineNum = 370;BA.debugLine="Dim url As String";
_url = "";
 //BA.debugLineNum = 371;BA.debugLine="url = \"https://www.lifeder.com/utilidad-operacio";
_url = "https://www.lifeder.com/utilidad-operacional/";
 //BA.debugLineNum = 372;BA.debugLine="StartActivity(p.OpenBrowser(url))";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(_p.OpenBrowser(_url)));
 if (true) break;

case 4:
//C
this.state = -1;
;
 //BA.debugLineNum = 376;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public static String  _ingresos_click() throws Exception{
 //BA.debugLineNum = 299;BA.debugLine="Private Sub Ingresos_Click";
 //BA.debugLineNum = 300;BA.debugLine="Activity.RemoveAllViews";
mostCurrent._activity.RemoveAllViews();
 //BA.debugLineNum = 302;BA.debugLine="Activity.LoadLayout(\"Ingresos_gastos\")";
mostCurrent._activity.LoadLayout("Ingresos_gastos",mostCurrent.activityBA);
 //BA.debugLineNum = 304;BA.debugLine="mbc1.LegendShapeSize = 7.0	    'this line of code";
mostCurrent._mbc1.setLegendShapeSize((float) (7.0));
 //BA.debugLineNum = 305;BA.debugLine="mbc1.setTheLegendPositionAndForm(\"BELOW_CHART_CEN";
mostCurrent._mbc1.setTheLegendPositionAndForm("BELOW_CHART_CENTER","CIRCLE");
 //BA.debugLineNum = 307;BA.debugLine="mbc1.TheLegendColor = Colors.Blue";
mostCurrent._mbc1.setTheLegendColor(anywheresoftware.b4a.keywords.Common.Colors.Blue);
 //BA.debugLineNum = 308;BA.debugLine="mbc1.TheLegendTextSize = 15.0";
mostCurrent._mbc1.setTheLegendTextSize((float) (15.0));
 //BA.debugLineNum = 309;BA.debugLine="mbc1.LegendTitle = \"Datos\"";
mostCurrent._mbc1.setLegendTitle("Datos");
 //BA.debugLineNum = 311;BA.debugLine="mbc1.ChartDescription = \"\"";
mostCurrent._mbc1.setChartDescription("");
 //BA.debugLineNum = 312;BA.debugLine="mbc1.ChartDescriptionColor = Colors.Blue";
mostCurrent._mbc1.setChartDescriptionColor(anywheresoftware.b4a.keywords.Common.Colors.Blue);
 //BA.debugLineNum = 313;BA.debugLine="mbc1.ChartDescriptionTextSize = 15";
mostCurrent._mbc1.setChartDescriptionTextSize((float) (15));
 //BA.debugLineNum = 316;BA.debugLine="mbc1.ValueTextColor = Colors.Black";
mostCurrent._mbc1.setValueTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
 //BA.debugLineNum = 317;BA.debugLine="mbc1.ValueTextSize = 10.0";
mostCurrent._mbc1.setValueTextSize((int) (10.0));
 //BA.debugLineNum = 320;BA.debugLine="mbc1.BarColors = Array As Int(Colors.Blue, Colors";
mostCurrent._mbc1.setBarColors(new int[]{anywheresoftware.b4a.keywords.Common.Colors.Blue,anywheresoftware.b4a.keywords.Common.Colors.Yellow,anywheresoftware.b4a.keywords.Common.Colors.Green,anywheresoftware.b4a.keywords.Common.Colors.Red,anywheresoftware.b4a.keywords.Common.Colors.Magenta,anywheresoftware.b4a.keywords.Common.Colors.Cyan,anywheresoftware.b4a.keywords.Common.Colors.LightGray,anywheresoftware.b4a.keywords.Common.Colors.Yellow,anywheresoftware.b4a.keywords.Common.Colors.Green,anywheresoftware.b4a.keywords.Common.Colors.Red,anywheresoftware.b4a.keywords.Common.Colors.Magenta,anywheresoftware.b4a.keywords.Common.Colors.Cyan});
 //BA.debugLineNum = 321;BA.debugLine="mbc1.LegendText = Array As String(\"Ingresos\", \"G,";
mostCurrent._mbc1.setLegendText(new String[]{"Ingresos","G,Operacionales","Utilidad Bruta","G. Admin.","Utilidad O. AI.","Impuestos","Utilidad O. DI"});
 //BA.debugLineNum = 322;BA.debugLine="mbc1.ChartData = Array As Float(Ingresos_, GOp, U";
mostCurrent._mbc1.setChartData(new float[]{_ingresos_,_gop,_utilidadb,_gadm,_utilidadoai,_impuestos,_uoperativadesp_imp});
 //BA.debugLineNum = 324;BA.debugLine="mbc1.DoubleTapToZoomEnabled = True";
mostCurrent._mbc1.setDoubleTapToZoomEnabled(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 325;BA.debugLine="mbc1.DrawBarShadow = False";
mostCurrent._mbc1.setDrawBarShadow(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 326;BA.debugLine="mbc1.GridBackgroundColor = Colors.white";
mostCurrent._mbc1.setGridBackgroundColor(anywheresoftware.b4a.keywords.Common.Colors.White);
 //BA.debugLineNum = 327;BA.debugLine="mbc1.DrawBorders = True";
mostCurrent._mbc1.setDrawBorders(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 328;BA.debugLine="mbc1.DrawGridBackground = True";
mostCurrent._mbc1.setDrawGridBackground(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 329;BA.debugLine="mbc1.DrawValueAboveBar = False";
mostCurrent._mbc1.setDrawValueAboveBar(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 330;BA.debugLine="mbc1.PinchZoom = True";
mostCurrent._mbc1.setPinchZoom(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 331;BA.debugLine="mbc1.ScaleEnabled = True";
mostCurrent._mbc1.setScaleEnabled(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 332;BA.debugLine="mbc1.BorderColor = Colors.White";
mostCurrent._mbc1.setBorderColor(anywheresoftware.b4a.keywords.Common.Colors.White);
 //BA.debugLineNum = 333;BA.debugLine="mbc1.BorderWidth = 3.0";
mostCurrent._mbc1.setBorderWidth((float) (3.0));
 //BA.debugLineNum = 336;BA.debugLine="mbc1.XaxisLabelPosition = \"TOP\"";
mostCurrent._mbc1.setXaxisLabelPosition("TOP");
 //BA.debugLineNum = 337;BA.debugLine="mbc1.XaxisTextSize = 7.0";
mostCurrent._mbc1.setXaxisTextSize((float) (7.0));
 //BA.debugLineNum = 338;BA.debugLine="mbc1.XaxisTextColor = Colors.Blue";
mostCurrent._mbc1.setXaxisTextColor(anywheresoftware.b4a.keywords.Common.Colors.Blue);
 //BA.debugLineNum = 340;BA.debugLine="mbc1.DrawYaxisGridLines = True";
mostCurrent._mbc1.setDrawYaxisGridLines(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 341;BA.debugLine="mbc1.YaxisTextColor = Colors.DarkGray";
mostCurrent._mbc1.setYaxisTextColor(anywheresoftware.b4a.keywords.Common.Colors.DarkGray);
 //BA.debugLineNum = 342;BA.debugLine="mbc1.YaxisTextSize = 10.0";
mostCurrent._mbc1.setYaxisTextSize((float) (10.0));
 //BA.debugLineNum = 344;BA.debugLine="mbc1.BarData = 7   'this number must be the same";
mostCurrent._mbc1.setBarData((int) (7));
 //BA.debugLineNum = 345;BA.debugLine="End Sub";
return "";
}
public static String  _iniciar_click() throws Exception{
 //BA.debugLineNum = 116;BA.debugLine="Private Sub INICIAR_Click";
 //BA.debugLineNum = 117;BA.debugLine="Usuario = Nombre.Text";
mostCurrent._usuario = mostCurrent._nombre.getText();
 //BA.debugLineNum = 118;BA.debugLine="Activity.RemoveAllViews";
mostCurrent._activity.RemoveAllViews();
 //BA.debugLineNum = 119;BA.debugLine="Activity.LoadLayout(\"Pantalla2\")";
mostCurrent._activity.LoadLayout("Pantalla2",mostCurrent.activityBA);
 //BA.debugLineNum = 120;BA.debugLine="Panel1.Visible=True";
mostCurrent._panel1.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 121;BA.debugLine="HiUsuario.Text= \"Hola \" & Usuario";
mostCurrent._hiusuario.setText(BA.ObjectToCharSequence("Hola "+mostCurrent._usuario));
 //BA.debugLineNum = 124;BA.debugLine="End Sub";
return "";
}

public static void initializeProcessGlobals() {
    
    if (main.processGlobalsRun == false) {
	    main.processGlobalsRun = true;
		try {
		        main._process_globals();
starter._process_globals();
		
        } catch (Exception e) {
			throw new RuntimeException(e);
		}
    }
}public static String  _process_globals() throws Exception{
 //BA.debugLineNum = 20;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 23;BA.debugLine="Private xui As XUI";
_xui = new anywheresoftware.b4a.objects.B4XViewWrapper.XUI();
 //BA.debugLineNum = 24;BA.debugLine="Dim xls As XSSFWorkbook";
_xls = new de.donmanfred.XSSFWorkbookwrapper();
 //BA.debugLineNum = 25;BA.debugLine="Private formatter As B4XFormatter";
_formatter = new b4a.FinanzasC.b4xformatter();
 //BA.debugLineNum = 28;BA.debugLine="End Sub";
return "";
}
public static String  _regresar_click() throws Exception{
 //BA.debugLineNum = 293;BA.debugLine="Private Sub Regresar_Click";
 //BA.debugLineNum = 294;BA.debugLine="Activity.RemoveAllViews";
mostCurrent._activity.RemoveAllViews();
 //BA.debugLineNum = 295;BA.debugLine="Activity.LoadLayout(\"Analisis\")";
mostCurrent._activity.LoadLayout("Analisis",mostCurrent.activityBA);
 //BA.debugLineNum = 296;BA.debugLine="Panel2.Visible=True";
mostCurrent._panel2.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 297;BA.debugLine="End Sub";
return "";
}
public static String  _regresar1_click() throws Exception{
 //BA.debugLineNum = 378;BA.debugLine="Private Sub Regresar1_Click";
 //BA.debugLineNum = 379;BA.debugLine="Activity.RemoveAllViews";
mostCurrent._activity.RemoveAllViews();
 //BA.debugLineNum = 380;BA.debugLine="Activity.LoadLayout(\"Pantalla2\")";
mostCurrent._activity.LoadLayout("Pantalla2",mostCurrent.activityBA);
 //BA.debugLineNum = 382;BA.debugLine="End Sub";
return "";
}
public static String  _regresar2_click() throws Exception{
 //BA.debugLineNum = 347;BA.debugLine="Private Sub Regresar2_Click";
 //BA.debugLineNum = 348;BA.debugLine="Activity.RemoveAllViews";
mostCurrent._activity.RemoveAllViews();
 //BA.debugLineNum = 349;BA.debugLine="Activity.LoadLayout(\"Analisis\")";
mostCurrent._activity.LoadLayout("Analisis",mostCurrent.activityBA);
 //BA.debugLineNum = 350;BA.debugLine="End Sub";
return "";
}
}
