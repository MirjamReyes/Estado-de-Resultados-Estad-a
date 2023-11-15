package b4a.example;


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
			processBA = new anywheresoftware.b4a.ShellBA(this.getApplicationContext(), null, null, "b4a.example", "b4a.example.main");
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
		activityBA = new BA(this, layout, processBA, "b4a.example", "b4a.example.main");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "b4a.example.main", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
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



public static void initializeProcessGlobals() {
    
    if (main.processGlobalsRun == false) {
	    main.processGlobalsRun = true;
		try {
		        		
        } catch (Exception e) {
			throw new RuntimeException(e);
		}
    }
}
public static boolean isAnyActivityVisible() {
    boolean vis = false;
vis = vis | (main.mostCurrent != null);
return vis;}

private static BA killProgramHelper(BA ba) {
    if (ba == null)
        return null;
    anywheresoftware.b4a.BA.SharedProcessBA sharedProcessBA = ba.sharedProcessBA;
    if (sharedProcessBA == null || sharedProcessBA.activityBA == null)
        return null;
    return sharedProcessBA.activityBA.get();
}
public static void killProgram() {
     {
            Activity __a = null;
            if (main.previousOne != null) {
				__a = main.previousOne.get();
			}
            else {
                BA ba = killProgramHelper(main.mostCurrent == null ? null : main.mostCurrent.processBA);
                if (ba != null) __a = ba.activity;
            }
            if (__a != null)
				__a.finish();}

BA.applicationContext.stopService(new android.content.Intent(BA.applicationContext, starter.class));
}
public anywheresoftware.b4a.keywords.Common __c = null;
public static anywheresoftware.b4a.objects.B4XViewWrapper.XUI _xui = null;
public static de.donmanfred.XSSFWorkbookwrapper _xls = null;
public static b4a.example.b4xformatter _formatter = null;
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
public b4a.example.starter _starter = null;
public static String  _activity_create(boolean _firsttime) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_create", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_create", new Object[] {_firsttime}));}
b4a.example.b4xformatter._b4xformatdata _defaultformat = null;
b4a.example.b4xformatter._b4xformatdata _negativeformat = null;
RDebugUtils.currentLine=131072;
 //BA.debugLineNum = 131072;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
RDebugUtils.currentLine=131074;
 //BA.debugLineNum = 131074;BA.debugLine="Activity.LoadLayout(\"Pantalla1\")";
mostCurrent._activity.LoadLayout("Pantalla1",mostCurrent.activityBA);
RDebugUtils.currentLine=131076;
 //BA.debugLineNum = 131076;BA.debugLine="If FirstTime Then";
if (_firsttime) { 
RDebugUtils.currentLine=131077;
 //BA.debugLineNum = 131077;BA.debugLine="formatter.Initialize";
_formatter._initialize /*String*/ (null,processBA);
RDebugUtils.currentLine=131078;
 //BA.debugLineNum = 131078;BA.debugLine="Dim DefaultFormat As B4XFormatData = formatter.G";
_defaultformat = _formatter._getdefaultformat /*b4a.example.b4xformatter._b4xformatdata*/ (null);
RDebugUtils.currentLine=131079;
 //BA.debugLineNum = 131079;BA.debugLine="DefaultFormat.MaximumFractions = 2";
_defaultformat.MaximumFractions /*int*/  = (int) (2);
RDebugUtils.currentLine=131080;
 //BA.debugLineNum = 131080;BA.debugLine="DefaultFormat.MinimumFractions = 2";
_defaultformat.MinimumFractions /*int*/  = (int) (2);
RDebugUtils.currentLine=131081;
 //BA.debugLineNum = 131081;BA.debugLine="DefaultFormat.Prefix = \"$ \"";
_defaultformat.Prefix /*String*/  = "$ ";
RDebugUtils.currentLine=131082;
 //BA.debugLineNum = 131082;BA.debugLine="Dim NegativeFormat As B4XFormatData = formatter.";
_negativeformat = _formatter._copyformatdata /*b4a.example.b4xformatter._b4xformatdata*/ (null,_defaultformat);
RDebugUtils.currentLine=131083;
 //BA.debugLineNum = 131083;BA.debugLine="NegativeFormat.TextColor = xui.Color_Red";
_negativeformat.TextColor /*int*/  = _xui.Color_Red;
RDebugUtils.currentLine=131084;
 //BA.debugLineNum = 131084;BA.debugLine="NegativeFormat.Prefix = \"$ (\"";
_negativeformat.Prefix /*String*/  = "$ (";
RDebugUtils.currentLine=131085;
 //BA.debugLineNum = 131085;BA.debugLine="NegativeFormat.Postfix = \")\"";
_negativeformat.Postfix /*String*/  = ")";
RDebugUtils.currentLine=131086;
 //BA.debugLineNum = 131086;BA.debugLine="NegativeFormat.FormatFont = xui.CreateDefaultBol";
_negativeformat.FormatFont /*anywheresoftware.b4a.objects.B4XViewWrapper.B4XFont*/  = _xui.CreateDefaultBoldFont((float) (15));
RDebugUtils.currentLine=131087;
 //BA.debugLineNum = 131087;BA.debugLine="formatter.AddFormatData(NegativeFormat, formatte";
_formatter._addformatdata /*String*/ (null,_negativeformat,_formatter._min_value /*int*/ ,0,anywheresoftware.b4a.keywords.Common.False);
 };
RDebugUtils.currentLine=131090;
 //BA.debugLineNum = 131090;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
RDebugUtils.currentModule="main";
RDebugUtils.currentLine=262144;
 //BA.debugLineNum = 262144;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
RDebugUtils.currentLine=262146;
 //BA.debugLineNum = 262146;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_resume", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_resume", null));}
RDebugUtils.currentLine=196608;
 //BA.debugLineNum = 196608;BA.debugLine="Sub Activity_Resume";
RDebugUtils.currentLine=196610;
 //BA.debugLineNum = 196610;BA.debugLine="End Sub";
return "";
}
public static String  _analisis_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "analisis_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "analisis_click", null));}
de.donmanfred.XLSSheetwrapper _sheet = null;
de.donmanfred.XSSFRowwrapper _row = null;
de.donmanfred.XSSFCellwrapper _cell = null;
RDebugUtils.currentLine=524288;
 //BA.debugLineNum = 524288;BA.debugLine="Private Sub Analisis_Click";
RDebugUtils.currentLine=524290;
 //BA.debugLineNum = 524290;BA.debugLine="Activity.RemoveAllViews";
mostCurrent._activity.RemoveAllViews();
RDebugUtils.currentLine=524291;
 //BA.debugLineNum = 524291;BA.debugLine="Activity.LoadLayout(\"Analisis\")";
mostCurrent._activity.LoadLayout("Analisis",mostCurrent.activityBA);
RDebugUtils.currentLine=524293;
 //BA.debugLineNum = 524293;BA.debugLine="File.Copy(File.DirAssets,archivo,File.DirInternal";
anywheresoftware.b4a.keywords.Common.File.Copy(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),mostCurrent._archivo,anywheresoftware.b4a.keywords.Common.File.getDirInternal(),mostCurrent._archivo);
RDebugUtils.currentLine=524294;
 //BA.debugLineNum = 524294;BA.debugLine="xls.Initialize(\"\",File.Combine(File.DirInternal,a";
_xls.Initialize(processBA,"",anywheresoftware.b4a.keywords.Common.File.Combine(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),mostCurrent._archivo));
RDebugUtils.currentLine=524296;
 //BA.debugLineNum = 524296;BA.debugLine="Dim sheet As XLSSheet = xls.getSheetAt(xls.Active";
_sheet = new de.donmanfred.XLSSheetwrapper();
_sheet = _xls.getSheetAt(_xls.getActiveSheetIndex());
RDebugUtils.currentLine=524299;
 //BA.debugLineNum = 524299;BA.debugLine="Dim row As XSSFRow =sheet.getRow(0)";
_row = new de.donmanfred.XSSFRowwrapper();
_row = (de.donmanfred.XSSFRowwrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new de.donmanfred.XSSFRowwrapper(), (org.apache.poi.xssf.usermodel.XSSFRow)(_sheet.getRow((int) (0))));
RDebugUtils.currentLine=524300;
 //BA.debugLineNum = 524300;BA.debugLine="Dim Cell As XSSFCell =row.getCell(0)";
_cell = new de.donmanfred.XSSFCellwrapper();
_cell = _row.getCell((int) (0));
RDebugUtils.currentLine=524302;
 //BA.debugLineNum = 524302;BA.debugLine="row=sheet.getRow(1)";
_row = (de.donmanfred.XSSFRowwrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new de.donmanfred.XSSFRowwrapper(), (org.apache.poi.xssf.usermodel.XSSFRow)(_sheet.getRow((int) (1))));
RDebugUtils.currentLine=524303;
 //BA.debugLineNum = 524303;BA.debugLine="Cell=row.getCell(2)";
_cell = _row.getCell((int) (2));
RDebugUtils.currentLine=524304;
 //BA.debugLineNum = 524304;BA.debugLine="Ingresos_ = Cell.NumericCellValue";
_ingresos_ = (float) (_cell.getNumericCellValue());
RDebugUtils.currentLine=524306;
 //BA.debugLineNum = 524306;BA.debugLine="row=sheet.getRow(2)";
_row = (de.donmanfred.XSSFRowwrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new de.donmanfred.XSSFRowwrapper(), (org.apache.poi.xssf.usermodel.XSSFRow)(_sheet.getRow((int) (2))));
RDebugUtils.currentLine=524307;
 //BA.debugLineNum = 524307;BA.debugLine="Cell=row.getCell(2)";
_cell = _row.getCell((int) (2));
RDebugUtils.currentLine=524308;
 //BA.debugLineNum = 524308;BA.debugLine="GOp = Cell.NumericCellValue";
_gop = (float) (_cell.getNumericCellValue());
RDebugUtils.currentLine=524310;
 //BA.debugLineNum = 524310;BA.debugLine="row=sheet.getRow(3)";
_row = (de.donmanfred.XSSFRowwrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new de.donmanfred.XSSFRowwrapper(), (org.apache.poi.xssf.usermodel.XSSFRow)(_sheet.getRow((int) (3))));
RDebugUtils.currentLine=524311;
 //BA.debugLineNum = 524311;BA.debugLine="Cell=row.getCell(2)";
_cell = _row.getCell((int) (2));
RDebugUtils.currentLine=524312;
 //BA.debugLineNum = 524312;BA.debugLine="UtilidadB = Cell.NumericCellValue";
_utilidadb = (float) (_cell.getNumericCellValue());
RDebugUtils.currentLine=524314;
 //BA.debugLineNum = 524314;BA.debugLine="row=sheet.getRow(4)";
_row = (de.donmanfred.XSSFRowwrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new de.donmanfred.XSSFRowwrapper(), (org.apache.poi.xssf.usermodel.XSSFRow)(_sheet.getRow((int) (4))));
RDebugUtils.currentLine=524315;
 //BA.debugLineNum = 524315;BA.debugLine="Cell=row.getCell(2)";
_cell = _row.getCell((int) (2));
RDebugUtils.currentLine=524316;
 //BA.debugLineNum = 524316;BA.debugLine="Gadm = Cell.NumericCellValue";
_gadm = (float) (_cell.getNumericCellValue());
RDebugUtils.currentLine=524318;
 //BA.debugLineNum = 524318;BA.debugLine="row=sheet.getRow(5)";
_row = (de.donmanfred.XSSFRowwrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new de.donmanfred.XSSFRowwrapper(), (org.apache.poi.xssf.usermodel.XSSFRow)(_sheet.getRow((int) (5))));
RDebugUtils.currentLine=524319;
 //BA.debugLineNum = 524319;BA.debugLine="Cell=row.getCell(2)";
_cell = _row.getCell((int) (2));
RDebugUtils.currentLine=524320;
 //BA.debugLineNum = 524320;BA.debugLine="UtilidadOai = Cell.NumericCellValue";
_utilidadoai = (float) (_cell.getNumericCellValue());
RDebugUtils.currentLine=524322;
 //BA.debugLineNum = 524322;BA.debugLine="row=sheet.getRow(6)";
_row = (de.donmanfred.XSSFRowwrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new de.donmanfred.XSSFRowwrapper(), (org.apache.poi.xssf.usermodel.XSSFRow)(_sheet.getRow((int) (6))));
RDebugUtils.currentLine=524323;
 //BA.debugLineNum = 524323;BA.debugLine="Cell=row.getCell(2)";
_cell = _row.getCell((int) (2));
RDebugUtils.currentLine=524324;
 //BA.debugLineNum = 524324;BA.debugLine="Impuestos = Cell.NumericCellValue";
_impuestos = (float) (_cell.getNumericCellValue());
RDebugUtils.currentLine=524326;
 //BA.debugLineNum = 524326;BA.debugLine="row=sheet.getRow(7)";
_row = (de.donmanfred.XSSFRowwrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new de.donmanfred.XSSFRowwrapper(), (org.apache.poi.xssf.usermodel.XSSFRow)(_sheet.getRow((int) (7))));
RDebugUtils.currentLine=524327;
 //BA.debugLineNum = 524327;BA.debugLine="Cell=row.getCell(2)";
_cell = _row.getCell((int) (2));
RDebugUtils.currentLine=524328;
 //BA.debugLineNum = 524328;BA.debugLine="UOperativaDesp_Imp = Cell.NumericCellValue";
_uoperativadesp_imp = (float) (_cell.getNumericCellValue());
RDebugUtils.currentLine=524331;
 //BA.debugLineNum = 524331;BA.debugLine="End Sub";
return "";
}
public static void  _boton_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "boton_click", false))
	 {Debug.delegate(mostCurrent.activityBA, "boton_click", null); return;}
ResumableSub_Boton_Click rsub = new ResumableSub_Boton_Click(null);
rsub.resume(processBA, null);
}
public static class ResumableSub_Boton_Click extends BA.ResumableSub {
public ResumableSub_Boton_Click(b4a.example.main parent) {
this.parent = parent;
}
b4a.example.main parent;
anywheresoftware.b4a.agraham.dialogs.InputDialog.FileDialog _fd = null;
Object _sf = null;
int _result = 0;

@Override
public void resume(BA ba, Object[] result) throws Exception{
RDebugUtils.currentModule="main";

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
RDebugUtils.currentLine=458753;
 //BA.debugLineNum = 458753;BA.debugLine="Dim fd As FileDialog";
_fd = new anywheresoftware.b4a.agraham.dialogs.InputDialog.FileDialog();
RDebugUtils.currentLine=458754;
 //BA.debugLineNum = 458754;BA.debugLine="fd.FastScroll = True";
_fd.setFastScroll(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=458755;
 //BA.debugLineNum = 458755;BA.debugLine="fd.ShowOnlyFolders=False";
_fd.setShowOnlyFolders(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=458756;
 //BA.debugLineNum = 458756;BA.debugLine="fd.TextColor=Colors.Black";
_fd.TextColor = anywheresoftware.b4a.keywords.Common.Colors.Black;
RDebugUtils.currentLine=458757;
 //BA.debugLineNum = 458757;BA.debugLine="fd.FilePath = File.DirInternal";
_fd.setFilePath(anywheresoftware.b4a.keywords.Common.File.getDirInternal());
RDebugUtils.currentLine=458758;
 //BA.debugLineNum = 458758;BA.debugLine="Dim sf As Object = fd.ShowAsync(\"Seleccionar Arch";
_sf = _fd.ShowAsync(BA.ObjectToCharSequence("Seleccionar Archivo"),"SELECCIONAR","Cancelar","",mostCurrent.activityBA,(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=458759;
 //BA.debugLineNum = 458759;BA.debugLine="Wait For (sf) Dialog_Result(Result As Int)";
anywheresoftware.b4a.keywords.Common.WaitFor("dialog_result", processBA, new anywheresoftware.b4a.shell.DebugResumableSub.DelegatableResumableSub(this, "main", "boton_click"), _sf);
this.state = 5;
return;
case 5:
//C
this.state = 1;
_result = (Integer) result[0];
;
RDebugUtils.currentLine=458760;
 //BA.debugLineNum = 458760;BA.debugLine="If Result = DialogResponse.POSITIVE Then";
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
RDebugUtils.currentLine=458761;
 //BA.debugLineNum = 458761;BA.debugLine="Log(\"File path: \" & fd.FilePath)";
anywheresoftware.b4a.keywords.Common.LogImpl("4458761","File path: "+_fd.getFilePath(),0);
RDebugUtils.currentLine=458762;
 //BA.debugLineNum = 458762;BA.debugLine="archivo = fd.ChosenName";
parent.mostCurrent._archivo = _fd.getChosenName();
RDebugUtils.currentLine=458763;
 //BA.debugLineNum = 458763;BA.debugLine="Log(\"File name: \" & archivo)";
anywheresoftware.b4a.keywords.Common.LogImpl("4458763","File name: "+parent.mostCurrent._archivo,0);
 if (true) break;

case 4:
//C
this.state = -1;
;
RDebugUtils.currentLine=458765;
 //BA.debugLineNum = 458765;BA.debugLine="Label1.Text = \"Ruta = \" & fd.FilePath";
parent.mostCurrent._label1.setText(BA.ObjectToCharSequence("Ruta = "+_fd.getFilePath()));
RDebugUtils.currentLine=458766;
 //BA.debugLineNum = 458766;BA.debugLine="Label2.Text = \"Nombre del Archivo = \" & fd.Chosen";
parent.mostCurrent._label2.setText(BA.ObjectToCharSequence("Nombre del Archivo = "+_fd.getChosenName()));
RDebugUtils.currentLine=458768;
 //BA.debugLineNum = 458768;BA.debugLine="Log(\"File path: \" & archivo)";
anywheresoftware.b4a.keywords.Common.LogImpl("4458768","File path: "+parent.mostCurrent._archivo,0);
RDebugUtils.currentLine=458770;
 //BA.debugLineNum = 458770;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public static String  _er_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "er_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "er_click", null));}
de.donmanfred.XLSSheetwrapper _sheet = null;
de.donmanfred.XSSFRowwrapper _row = null;
de.donmanfred.XSSFCellwrapper _cell = null;
String _texto1 = "";
RDebugUtils.currentLine=589824;
 //BA.debugLineNum = 589824;BA.debugLine="Private Sub ER_Click";
RDebugUtils.currentLine=589825;
 //BA.debugLineNum = 589825;BA.debugLine="File.Copy(File.DirAssets,archivo,File.DirInternal";
anywheresoftware.b4a.keywords.Common.File.Copy(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),mostCurrent._archivo,anywheresoftware.b4a.keywords.Common.File.getDirInternal(),mostCurrent._archivo);
RDebugUtils.currentLine=589826;
 //BA.debugLineNum = 589826;BA.debugLine="xls.Initialize(\"\",File.Combine(File.DirInternal,a";
_xls.Initialize(processBA,"",anywheresoftware.b4a.keywords.Common.File.Combine(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),mostCurrent._archivo));
RDebugUtils.currentLine=589828;
 //BA.debugLineNum = 589828;BA.debugLine="Dim sheet As XLSSheet = xls.getSheetAt(xls.Active";
_sheet = new de.donmanfred.XLSSheetwrapper();
_sheet = _xls.getSheetAt(_xls.getActiveSheetIndex());
RDebugUtils.currentLine=589832;
 //BA.debugLineNum = 589832;BA.debugLine="Activity.RemoveAllViews";
mostCurrent._activity.RemoveAllViews();
RDebugUtils.currentLine=589833;
 //BA.debugLineNum = 589833;BA.debugLine="Activity.LoadLayout(\"EstadoResultados\")";
mostCurrent._activity.LoadLayout("EstadoResultados",mostCurrent.activityBA);
RDebugUtils.currentLine=589834;
 //BA.debugLineNum = 589834;BA.debugLine="Dim row As XSSFRow =sheet.getRow(0)";
_row = new de.donmanfred.XSSFRowwrapper();
_row = (de.donmanfred.XSSFRowwrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new de.donmanfred.XSSFRowwrapper(), (org.apache.poi.xssf.usermodel.XSSFRow)(_sheet.getRow((int) (0))));
RDebugUtils.currentLine=589835;
 //BA.debugLineNum = 589835;BA.debugLine="Dim Cell As XSSFCell =row.getCell(0)";
_cell = new de.donmanfred.XSSFCellwrapper();
_cell = _row.getCell((int) (0));
RDebugUtils.currentLine=589837;
 //BA.debugLineNum = 589837;BA.debugLine="Dim Texto1 As String = NumberFormat2(0, 1, 2, 2,";
_texto1 = anywheresoftware.b4a.keywords.Common.NumberFormat2(0,(int) (1),(int) (2),(int) (2),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=589838;
 //BA.debugLineNum = 589838;BA.debugLine="Texto1 = Cell.StringCellValue";
_texto1 = _cell.getStringCellValue();
RDebugUtils.currentLine=589839;
 //BA.debugLineNum = 589839;BA.debugLine="Concepto.text= Texto1";
mostCurrent._concepto.setText(BA.ObjectToCharSequence(_texto1));
RDebugUtils.currentLine=589841;
 //BA.debugLineNum = 589841;BA.debugLine="row=sheet.getRow(1)";
_row = (de.donmanfred.XSSFRowwrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new de.donmanfred.XSSFRowwrapper(), (org.apache.poi.xssf.usermodel.XSSFRow)(_sheet.getRow((int) (1))));
RDebugUtils.currentLine=589842;
 //BA.debugLineNum = 589842;BA.debugLine="Cell=row.getCell(0)";
_cell = _row.getCell((int) (0));
RDebugUtils.currentLine=589843;
 //BA.debugLineNum = 589843;BA.debugLine="Texto1 = Cell.StringCellValue";
_texto1 = _cell.getStringCellValue();
RDebugUtils.currentLine=589845;
 //BA.debugLineNum = 589845;BA.debugLine="Concepto1.text= Texto1";
mostCurrent._concepto1.setText(BA.ObjectToCharSequence(_texto1));
RDebugUtils.currentLine=589847;
 //BA.debugLineNum = 589847;BA.debugLine="row=sheet.getRow(2)";
_row = (de.donmanfred.XSSFRowwrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new de.donmanfred.XSSFRowwrapper(), (org.apache.poi.xssf.usermodel.XSSFRow)(_sheet.getRow((int) (2))));
RDebugUtils.currentLine=589848;
 //BA.debugLineNum = 589848;BA.debugLine="Cell=row.getCell(0)";
_cell = _row.getCell((int) (0));
RDebugUtils.currentLine=589849;
 //BA.debugLineNum = 589849;BA.debugLine="Texto1 = Cell.StringCellValue";
_texto1 = _cell.getStringCellValue();
RDebugUtils.currentLine=589850;
 //BA.debugLineNum = 589850;BA.debugLine="Concepto2.text= Texto1";
mostCurrent._concepto2.setText(BA.ObjectToCharSequence(_texto1));
RDebugUtils.currentLine=589852;
 //BA.debugLineNum = 589852;BA.debugLine="row=sheet.getRow(3)";
_row = (de.donmanfred.XSSFRowwrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new de.donmanfred.XSSFRowwrapper(), (org.apache.poi.xssf.usermodel.XSSFRow)(_sheet.getRow((int) (3))));
RDebugUtils.currentLine=589853;
 //BA.debugLineNum = 589853;BA.debugLine="Cell=row.getCell(0)";
_cell = _row.getCell((int) (0));
RDebugUtils.currentLine=589854;
 //BA.debugLineNum = 589854;BA.debugLine="Texto1 = Cell.StringCellValue";
_texto1 = _cell.getStringCellValue();
RDebugUtils.currentLine=589855;
 //BA.debugLineNum = 589855;BA.debugLine="Concepto3.text= Texto1";
mostCurrent._concepto3.setText(BA.ObjectToCharSequence(_texto1));
RDebugUtils.currentLine=589857;
 //BA.debugLineNum = 589857;BA.debugLine="row=sheet.getRow(4)";
_row = (de.donmanfred.XSSFRowwrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new de.donmanfred.XSSFRowwrapper(), (org.apache.poi.xssf.usermodel.XSSFRow)(_sheet.getRow((int) (4))));
RDebugUtils.currentLine=589858;
 //BA.debugLineNum = 589858;BA.debugLine="Cell=row.getCell(0)";
_cell = _row.getCell((int) (0));
RDebugUtils.currentLine=589859;
 //BA.debugLineNum = 589859;BA.debugLine="Texto1 = Cell.StringCellValue";
_texto1 = _cell.getStringCellValue();
RDebugUtils.currentLine=589860;
 //BA.debugLineNum = 589860;BA.debugLine="Concepto4.text= Texto1";
mostCurrent._concepto4.setText(BA.ObjectToCharSequence(_texto1));
RDebugUtils.currentLine=589862;
 //BA.debugLineNum = 589862;BA.debugLine="row=sheet.getRow(5)";
_row = (de.donmanfred.XSSFRowwrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new de.donmanfred.XSSFRowwrapper(), (org.apache.poi.xssf.usermodel.XSSFRow)(_sheet.getRow((int) (5))));
RDebugUtils.currentLine=589863;
 //BA.debugLineNum = 589863;BA.debugLine="Cell=row.getCell(0)";
_cell = _row.getCell((int) (0));
RDebugUtils.currentLine=589864;
 //BA.debugLineNum = 589864;BA.debugLine="Texto1 = Cell.StringCellValue";
_texto1 = _cell.getStringCellValue();
RDebugUtils.currentLine=589865;
 //BA.debugLineNum = 589865;BA.debugLine="Concepto5.text= Texto1";
mostCurrent._concepto5.setText(BA.ObjectToCharSequence(_texto1));
RDebugUtils.currentLine=589867;
 //BA.debugLineNum = 589867;BA.debugLine="row=sheet.getRow(6)";
_row = (de.donmanfred.XSSFRowwrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new de.donmanfred.XSSFRowwrapper(), (org.apache.poi.xssf.usermodel.XSSFRow)(_sheet.getRow((int) (6))));
RDebugUtils.currentLine=589868;
 //BA.debugLineNum = 589868;BA.debugLine="Cell=row.getCell(0)";
_cell = _row.getCell((int) (0));
RDebugUtils.currentLine=589869;
 //BA.debugLineNum = 589869;BA.debugLine="Texto1 = Cell.StringCellValue";
_texto1 = _cell.getStringCellValue();
RDebugUtils.currentLine=589870;
 //BA.debugLineNum = 589870;BA.debugLine="Concepto6.text= Texto1";
mostCurrent._concepto6.setText(BA.ObjectToCharSequence(_texto1));
RDebugUtils.currentLine=589872;
 //BA.debugLineNum = 589872;BA.debugLine="row=sheet.getRow(7)";
_row = (de.donmanfred.XSSFRowwrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new de.donmanfred.XSSFRowwrapper(), (org.apache.poi.xssf.usermodel.XSSFRow)(_sheet.getRow((int) (7))));
RDebugUtils.currentLine=589873;
 //BA.debugLineNum = 589873;BA.debugLine="Cell=row.getCell(0)";
_cell = _row.getCell((int) (0));
RDebugUtils.currentLine=589874;
 //BA.debugLineNum = 589874;BA.debugLine="Texto1 = Cell.StringCellValue";
_texto1 = _cell.getStringCellValue();
RDebugUtils.currentLine=589875;
 //BA.debugLineNum = 589875;BA.debugLine="Concepto7.text= Texto1";
mostCurrent._concepto7.setText(BA.ObjectToCharSequence(_texto1));
RDebugUtils.currentLine=589877;
 //BA.debugLineNum = 589877;BA.debugLine="row=sheet.getRow(0)";
_row = (de.donmanfred.XSSFRowwrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new de.donmanfred.XSSFRowwrapper(), (org.apache.poi.xssf.usermodel.XSSFRow)(_sheet.getRow((int) (0))));
RDebugUtils.currentLine=589878;
 //BA.debugLineNum = 589878;BA.debugLine="Cell=row.getCell(2)";
_cell = _row.getCell((int) (2));
RDebugUtils.currentLine=589879;
 //BA.debugLineNum = 589879;BA.debugLine="Texto1 = Cell.StringCellValue";
_texto1 = _cell.getStringCellValue();
RDebugUtils.currentLine=589880;
 //BA.debugLineNum = 589880;BA.debugLine="Datos.text= Texto1";
mostCurrent._datos.setText(BA.ObjectToCharSequence(_texto1));
RDebugUtils.currentLine=589882;
 //BA.debugLineNum = 589882;BA.debugLine="row=sheet.getRow(1)";
_row = (de.donmanfred.XSSFRowwrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new de.donmanfred.XSSFRowwrapper(), (org.apache.poi.xssf.usermodel.XSSFRow)(_sheet.getRow((int) (1))));
RDebugUtils.currentLine=589883;
 //BA.debugLineNum = 589883;BA.debugLine="Cell=row.getCell(2)";
_cell = _row.getCell((int) (2));
RDebugUtils.currentLine=589884;
 //BA.debugLineNum = 589884;BA.debugLine="Texto1 = formatter.Format(Cell.NumericCellValue)";
_texto1 = _formatter._format /*String*/ (null,_cell.getNumericCellValue());
RDebugUtils.currentLine=589885;
 //BA.debugLineNum = 589885;BA.debugLine="Datos1.text= Texto1";
mostCurrent._datos1.setText(BA.ObjectToCharSequence(_texto1));
RDebugUtils.currentLine=589887;
 //BA.debugLineNum = 589887;BA.debugLine="row=sheet.getRow(2)";
_row = (de.donmanfred.XSSFRowwrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new de.donmanfred.XSSFRowwrapper(), (org.apache.poi.xssf.usermodel.XSSFRow)(_sheet.getRow((int) (2))));
RDebugUtils.currentLine=589888;
 //BA.debugLineNum = 589888;BA.debugLine="Cell=row.getCell(2)";
_cell = _row.getCell((int) (2));
RDebugUtils.currentLine=589889;
 //BA.debugLineNum = 589889;BA.debugLine="Texto1 = formatter.Format(Cell.NumericCellValue)";
_texto1 = _formatter._format /*String*/ (null,_cell.getNumericCellValue());
RDebugUtils.currentLine=589890;
 //BA.debugLineNum = 589890;BA.debugLine="Datos2.text= Texto1";
mostCurrent._datos2.setText(BA.ObjectToCharSequence(_texto1));
RDebugUtils.currentLine=589892;
 //BA.debugLineNum = 589892;BA.debugLine="row=sheet.getRow(3)";
_row = (de.donmanfred.XSSFRowwrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new de.donmanfred.XSSFRowwrapper(), (org.apache.poi.xssf.usermodel.XSSFRow)(_sheet.getRow((int) (3))));
RDebugUtils.currentLine=589893;
 //BA.debugLineNum = 589893;BA.debugLine="Cell=row.getCell(2)";
_cell = _row.getCell((int) (2));
RDebugUtils.currentLine=589894;
 //BA.debugLineNum = 589894;BA.debugLine="Texto1 = formatter.Format(Cell.NumericCellValue)";
_texto1 = _formatter._format /*String*/ (null,_cell.getNumericCellValue());
RDebugUtils.currentLine=589895;
 //BA.debugLineNum = 589895;BA.debugLine="Datos3.text= Texto1";
mostCurrent._datos3.setText(BA.ObjectToCharSequence(_texto1));
RDebugUtils.currentLine=589897;
 //BA.debugLineNum = 589897;BA.debugLine="row=sheet.getRow(4)";
_row = (de.donmanfred.XSSFRowwrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new de.donmanfred.XSSFRowwrapper(), (org.apache.poi.xssf.usermodel.XSSFRow)(_sheet.getRow((int) (4))));
RDebugUtils.currentLine=589898;
 //BA.debugLineNum = 589898;BA.debugLine="Cell=row.getCell(2)";
_cell = _row.getCell((int) (2));
RDebugUtils.currentLine=589899;
 //BA.debugLineNum = 589899;BA.debugLine="Texto1 = formatter.Format(Cell.NumericCellValue)";
_texto1 = _formatter._format /*String*/ (null,_cell.getNumericCellValue());
RDebugUtils.currentLine=589900;
 //BA.debugLineNum = 589900;BA.debugLine="Datos4.text= Texto1";
mostCurrent._datos4.setText(BA.ObjectToCharSequence(_texto1));
RDebugUtils.currentLine=589902;
 //BA.debugLineNum = 589902;BA.debugLine="row=sheet.getRow(5)";
_row = (de.donmanfred.XSSFRowwrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new de.donmanfred.XSSFRowwrapper(), (org.apache.poi.xssf.usermodel.XSSFRow)(_sheet.getRow((int) (5))));
RDebugUtils.currentLine=589903;
 //BA.debugLineNum = 589903;BA.debugLine="Cell=row.getCell(2)";
_cell = _row.getCell((int) (2));
RDebugUtils.currentLine=589904;
 //BA.debugLineNum = 589904;BA.debugLine="Texto1 = formatter.Format(Cell.NumericCellValue)";
_texto1 = _formatter._format /*String*/ (null,_cell.getNumericCellValue());
RDebugUtils.currentLine=589905;
 //BA.debugLineNum = 589905;BA.debugLine="Datos5.text= Texto1";
mostCurrent._datos5.setText(BA.ObjectToCharSequence(_texto1));
RDebugUtils.currentLine=589907;
 //BA.debugLineNum = 589907;BA.debugLine="row=sheet.getRow(6)";
_row = (de.donmanfred.XSSFRowwrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new de.donmanfred.XSSFRowwrapper(), (org.apache.poi.xssf.usermodel.XSSFRow)(_sheet.getRow((int) (6))));
RDebugUtils.currentLine=589908;
 //BA.debugLineNum = 589908;BA.debugLine="Cell=row.getCell(2)";
_cell = _row.getCell((int) (2));
RDebugUtils.currentLine=589909;
 //BA.debugLineNum = 589909;BA.debugLine="Texto1 = formatter.Format(Cell.NumericCellValue)";
_texto1 = _formatter._format /*String*/ (null,_cell.getNumericCellValue());
RDebugUtils.currentLine=589910;
 //BA.debugLineNum = 589910;BA.debugLine="Datos6.text= Texto1";
mostCurrent._datos6.setText(BA.ObjectToCharSequence(_texto1));
RDebugUtils.currentLine=589912;
 //BA.debugLineNum = 589912;BA.debugLine="row=sheet.getRow(7)";
_row = (de.donmanfred.XSSFRowwrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new de.donmanfred.XSSFRowwrapper(), (org.apache.poi.xssf.usermodel.XSSFRow)(_sheet.getRow((int) (7))));
RDebugUtils.currentLine=589913;
 //BA.debugLineNum = 589913;BA.debugLine="Cell=row.getCell(2)";
_cell = _row.getCell((int) (2));
RDebugUtils.currentLine=589914;
 //BA.debugLineNum = 589914;BA.debugLine="Texto1 = formatter.Format(Cell.NumericCellValue)";
_texto1 = _formatter._format /*String*/ (null,_cell.getNumericCellValue());
RDebugUtils.currentLine=589915;
 //BA.debugLineNum = 589915;BA.debugLine="Datos7.text= Texto1";
mostCurrent._datos7.setText(BA.ObjectToCharSequence(_texto1));
RDebugUtils.currentLine=589916;
 //BA.debugLineNum = 589916;BA.debugLine="End Sub";
return "";
}
public static String  _info_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "info_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "info_click", null));}
RDebugUtils.currentLine=393216;
 //BA.debugLineNum = 393216;BA.debugLine="Private Sub info_Click";
RDebugUtils.currentLine=393217;
 //BA.debugLineNum = 393217;BA.debugLine="MsgboxAsync(\"Recuerda verificar que el archivo ele";
anywheresoftware.b4a.keywords.Common.MsgboxAsync(BA.ObjectToCharSequence("Recuerda verificar que el archivo elegido es el correcto"),BA.ObjectToCharSequence("INFORMACIÓN"),processBA);
RDebugUtils.currentLine=393220;
 //BA.debugLineNum = 393220;BA.debugLine="End Sub";
return "";
}
public static String  _infoub_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "infoub_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "infoub_click", null));}
RDebugUtils.currentLine=851968;
 //BA.debugLineNum = 851968;BA.debugLine="Private Sub infoUB_Click";
RDebugUtils.currentLine=851969;
 //BA.debugLineNum = 851969;BA.debugLine="MsgboxAsync(\"La utilidad bruta, también conocida";
anywheresoftware.b4a.keywords.Common.MsgboxAsync(BA.ObjectToCharSequence("La utilidad bruta, también conocida como utilidad de las ventas o ingresos brutos, es la ganancia que obtiene una compañía después de deducir los costos asociados con la fabricación y venta de sus productos, o los costos asociados con la prestación de sus servicios. "),BA.ObjectToCharSequence("¿Que es la Utilidad Bruta?"),processBA);
RDebugUtils.currentLine=851970;
 //BA.debugLineNum = 851970;BA.debugLine="End Sub";
return "";
}
public static String  _infoum_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "infoum_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "infoum_click", null));}
RDebugUtils.currentLine=917504;
 //BA.debugLineNum = 917504;BA.debugLine="Private Sub infoUM_Click";
RDebugUtils.currentLine=917505;
 //BA.debugLineNum = 917505;BA.debugLine="MsgboxAsync(\"La utilidad de operación u operacion";
anywheresoftware.b4a.keywords.Common.MsgboxAsync(BA.ObjectToCharSequence("La utilidad de operación u operacional es un valor contable que mide la ganancia obtenida por una empresa a través de sus principales operaciones comerciales, excluyendo deducciones por los intereses e impuestos "),BA.ObjectToCharSequence("¿Que es la Utilidad de Operación?"),processBA);
RDebugUtils.currentLine=917506;
 //BA.debugLineNum = 917506;BA.debugLine="End Sub";
return "";
}
public static String  _ingresos_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "ingresos_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "ingresos_click", null));}
RDebugUtils.currentLine=720896;
 //BA.debugLineNum = 720896;BA.debugLine="Private Sub Ingresos_Click";
RDebugUtils.currentLine=720897;
 //BA.debugLineNum = 720897;BA.debugLine="Activity.RemoveAllViews";
mostCurrent._activity.RemoveAllViews();
RDebugUtils.currentLine=720904;
 //BA.debugLineNum = 720904;BA.debugLine="Activity.LoadLayout(\"Ingresos_gastos\")";
mostCurrent._activity.LoadLayout("Ingresos_gastos",mostCurrent.activityBA);
RDebugUtils.currentLine=720955;
 //BA.debugLineNum = 720955;BA.debugLine="mbc1.LegendShapeSize = 7.0	    'this line of code";
mostCurrent._mbc1.setLegendShapeSize((float) (7.0));
RDebugUtils.currentLine=720956;
 //BA.debugLineNum = 720956;BA.debugLine="mbc1.setTheLegendPositionAndForm(\"BELOW_CHART_CEN";
mostCurrent._mbc1.setTheLegendPositionAndForm("BELOW_CHART_CENTER","CIRCLE");
RDebugUtils.currentLine=720958;
 //BA.debugLineNum = 720958;BA.debugLine="mbc1.TheLegendColor = Colors.Blue";
mostCurrent._mbc1.setTheLegendColor(anywheresoftware.b4a.keywords.Common.Colors.Blue);
RDebugUtils.currentLine=720959;
 //BA.debugLineNum = 720959;BA.debugLine="mbc1.TheLegendTextSize = 15.0";
mostCurrent._mbc1.setTheLegendTextSize((float) (15.0));
RDebugUtils.currentLine=720960;
 //BA.debugLineNum = 720960;BA.debugLine="mbc1.LegendTitle = \"Datos\"";
mostCurrent._mbc1.setLegendTitle("Datos");
RDebugUtils.currentLine=720962;
 //BA.debugLineNum = 720962;BA.debugLine="mbc1.ChartDescription = \"\"";
mostCurrent._mbc1.setChartDescription("");
RDebugUtils.currentLine=720963;
 //BA.debugLineNum = 720963;BA.debugLine="mbc1.ChartDescriptionColor = Colors.Blue";
mostCurrent._mbc1.setChartDescriptionColor(anywheresoftware.b4a.keywords.Common.Colors.Blue);
RDebugUtils.currentLine=720964;
 //BA.debugLineNum = 720964;BA.debugLine="mbc1.ChartDescriptionTextSize = 15";
mostCurrent._mbc1.setChartDescriptionTextSize((float) (15));
RDebugUtils.currentLine=720967;
 //BA.debugLineNum = 720967;BA.debugLine="mbc1.ValueTextColor = Colors.Black";
mostCurrent._mbc1.setValueTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=720968;
 //BA.debugLineNum = 720968;BA.debugLine="mbc1.ValueTextSize = 10.0";
mostCurrent._mbc1.setValueTextSize((int) (10.0));
RDebugUtils.currentLine=720971;
 //BA.debugLineNum = 720971;BA.debugLine="mbc1.BarColors = Array As Int(Colors.Blue, Colors";
mostCurrent._mbc1.setBarColors(new int[]{anywheresoftware.b4a.keywords.Common.Colors.Blue,anywheresoftware.b4a.keywords.Common.Colors.Yellow,anywheresoftware.b4a.keywords.Common.Colors.Green,anywheresoftware.b4a.keywords.Common.Colors.Red,anywheresoftware.b4a.keywords.Common.Colors.Magenta,anywheresoftware.b4a.keywords.Common.Colors.Cyan,anywheresoftware.b4a.keywords.Common.Colors.Blue,anywheresoftware.b4a.keywords.Common.Colors.Yellow,anywheresoftware.b4a.keywords.Common.Colors.Green,anywheresoftware.b4a.keywords.Common.Colors.Red,anywheresoftware.b4a.keywords.Common.Colors.Magenta,anywheresoftware.b4a.keywords.Common.Colors.Cyan});
RDebugUtils.currentLine=720972;
 //BA.debugLineNum = 720972;BA.debugLine="mbc1.LegendText = Array As String(\"Ingresos\", \"G,";
mostCurrent._mbc1.setLegendText(new String[]{"Ingresos","G,Operacionales","Utilidad Bruta","G. Admin.","Utilidad O. AI.","Impuestos","Utilidad O. DI"});
RDebugUtils.currentLine=720973;
 //BA.debugLineNum = 720973;BA.debugLine="mbc1.ChartData = Array As Float(Ingresos_, GOp, U";
mostCurrent._mbc1.setChartData(new float[]{_ingresos_,_gop,_utilidadb,_gadm,_utilidadoai,_impuestos,_uoperativadesp_imp});
RDebugUtils.currentLine=720975;
 //BA.debugLineNum = 720975;BA.debugLine="mbc1.DoubleTapToZoomEnabled = True";
mostCurrent._mbc1.setDoubleTapToZoomEnabled(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=720976;
 //BA.debugLineNum = 720976;BA.debugLine="mbc1.DrawBarShadow = False";
mostCurrent._mbc1.setDrawBarShadow(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=720977;
 //BA.debugLineNum = 720977;BA.debugLine="mbc1.GridBackgroundColor = Colors.white";
mostCurrent._mbc1.setGridBackgroundColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=720978;
 //BA.debugLineNum = 720978;BA.debugLine="mbc1.DrawBorders = True";
mostCurrent._mbc1.setDrawBorders(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=720979;
 //BA.debugLineNum = 720979;BA.debugLine="mbc1.DrawGridBackground = True";
mostCurrent._mbc1.setDrawGridBackground(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=720980;
 //BA.debugLineNum = 720980;BA.debugLine="mbc1.DrawValueAboveBar = False";
mostCurrent._mbc1.setDrawValueAboveBar(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=720981;
 //BA.debugLineNum = 720981;BA.debugLine="mbc1.PinchZoom = True";
mostCurrent._mbc1.setPinchZoom(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=720982;
 //BA.debugLineNum = 720982;BA.debugLine="mbc1.ScaleEnabled = True";
mostCurrent._mbc1.setScaleEnabled(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=720983;
 //BA.debugLineNum = 720983;BA.debugLine="mbc1.BorderColor = Colors.White";
mostCurrent._mbc1.setBorderColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=720984;
 //BA.debugLineNum = 720984;BA.debugLine="mbc1.BorderWidth = 3.0";
mostCurrent._mbc1.setBorderWidth((float) (3.0));
RDebugUtils.currentLine=720987;
 //BA.debugLineNum = 720987;BA.debugLine="mbc1.XaxisLabelPosition = \"TOP\"";
mostCurrent._mbc1.setXaxisLabelPosition("TOP");
RDebugUtils.currentLine=720988;
 //BA.debugLineNum = 720988;BA.debugLine="mbc1.XaxisTextSize = 7.0";
mostCurrent._mbc1.setXaxisTextSize((float) (7.0));
RDebugUtils.currentLine=720989;
 //BA.debugLineNum = 720989;BA.debugLine="mbc1.XaxisTextColor = Colors.Blue";
mostCurrent._mbc1.setXaxisTextColor(anywheresoftware.b4a.keywords.Common.Colors.Blue);
RDebugUtils.currentLine=720991;
 //BA.debugLineNum = 720991;BA.debugLine="mbc1.DrawYaxisGridLines = True";
mostCurrent._mbc1.setDrawYaxisGridLines(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=720992;
 //BA.debugLineNum = 720992;BA.debugLine="mbc1.YaxisTextColor = Colors.DarkGray";
mostCurrent._mbc1.setYaxisTextColor(anywheresoftware.b4a.keywords.Common.Colors.DarkGray);
RDebugUtils.currentLine=720993;
 //BA.debugLineNum = 720993;BA.debugLine="mbc1.YaxisTextSize = 10.0";
mostCurrent._mbc1.setYaxisTextSize((float) (10.0));
RDebugUtils.currentLine=720995;
 //BA.debugLineNum = 720995;BA.debugLine="mbc1.BarData = 7   'this number must be the same";
mostCurrent._mbc1.setBarData((int) (7));
RDebugUtils.currentLine=720996;
 //BA.debugLineNum = 720996;BA.debugLine="End Sub";
return "";
}
public static String  _iniciar_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "iniciar_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "iniciar_click", null));}
RDebugUtils.currentLine=327680;
 //BA.debugLineNum = 327680;BA.debugLine="Private Sub INICIAR_Click";
RDebugUtils.currentLine=327681;
 //BA.debugLineNum = 327681;BA.debugLine="Usuario = Nombre.Text";
mostCurrent._usuario = mostCurrent._nombre.getText();
RDebugUtils.currentLine=327682;
 //BA.debugLineNum = 327682;BA.debugLine="Activity.RemoveAllViews";
mostCurrent._activity.RemoveAllViews();
RDebugUtils.currentLine=327683;
 //BA.debugLineNum = 327683;BA.debugLine="Activity.LoadLayout(\"Pantalla2\")";
mostCurrent._activity.LoadLayout("Pantalla2",mostCurrent.activityBA);
RDebugUtils.currentLine=327684;
 //BA.debugLineNum = 327684;BA.debugLine="Panel1.Visible=True";
mostCurrent._panel1.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=327685;
 //BA.debugLineNum = 327685;BA.debugLine="HiUsuario.Text= \"Hola \" & Usuario";
mostCurrent._hiusuario.setText(BA.ObjectToCharSequence("Hola "+mostCurrent._usuario));
RDebugUtils.currentLine=327688;
 //BA.debugLineNum = 327688;BA.debugLine="End Sub";
return "";
}
public static String  _regresar_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "regresar_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "regresar_click", null));}
RDebugUtils.currentLine=655360;
 //BA.debugLineNum = 655360;BA.debugLine="Private Sub Regresar_Click";
RDebugUtils.currentLine=655361;
 //BA.debugLineNum = 655361;BA.debugLine="Activity.RemoveAllViews";
mostCurrent._activity.RemoveAllViews();
RDebugUtils.currentLine=655362;
 //BA.debugLineNum = 655362;BA.debugLine="Activity.LoadLayout(\"Analisis\")";
mostCurrent._activity.LoadLayout("Analisis",mostCurrent.activityBA);
RDebugUtils.currentLine=655363;
 //BA.debugLineNum = 655363;BA.debugLine="Panel2.Visible=True";
mostCurrent._panel2.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=655364;
 //BA.debugLineNum = 655364;BA.debugLine="End Sub";
return "";
}
public static String  _regresar2_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "regresar2_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "regresar2_click", null));}
RDebugUtils.currentLine=786432;
 //BA.debugLineNum = 786432;BA.debugLine="Private Sub Regresar2_Click";
RDebugUtils.currentLine=786433;
 //BA.debugLineNum = 786433;BA.debugLine="Activity.RemoveAllViews";
mostCurrent._activity.RemoveAllViews();
RDebugUtils.currentLine=786434;
 //BA.debugLineNum = 786434;BA.debugLine="Activity.LoadLayout(\"Analisis\")";
mostCurrent._activity.LoadLayout("Analisis",mostCurrent.activityBA);
RDebugUtils.currentLine=786435;
 //BA.debugLineNum = 786435;BA.debugLine="End Sub";
return "";
}
}