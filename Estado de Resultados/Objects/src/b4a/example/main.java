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
	public static final boolean includeTitle = true;
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
public mpandroidchartwrapper.barChartWrapper _mbc1 = null;
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
public anywheresoftware.b4a.objects.ButtonWrapper _nómina = null;
public anywheresoftware.b4a.objects.ButtonWrapper _regresar2 = null;
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
RDebugUtils.currentLine=1179648;
 //BA.debugLineNum = 1179648;BA.debugLine="Private Sub Analisis_Click";
RDebugUtils.currentLine=1179650;
 //BA.debugLineNum = 1179650;BA.debugLine="Activity.RemoveAllViews";
mostCurrent._activity.RemoveAllViews();
RDebugUtils.currentLine=1179651;
 //BA.debugLineNum = 1179651;BA.debugLine="Activity.LoadLayout(\"Analisis\")";
mostCurrent._activity.LoadLayout("Analisis",mostCurrent.activityBA);
RDebugUtils.currentLine=1179653;
 //BA.debugLineNum = 1179653;BA.debugLine="File.Copy(File.DirAssets,archivo,File.DirInternal";
anywheresoftware.b4a.keywords.Common.File.Copy(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),mostCurrent._archivo,anywheresoftware.b4a.keywords.Common.File.getDirInternal(),mostCurrent._archivo);
RDebugUtils.currentLine=1179654;
 //BA.debugLineNum = 1179654;BA.debugLine="xls.Initialize(\"\",File.Combine(File.DirInternal,a";
_xls.Initialize(processBA,"",anywheresoftware.b4a.keywords.Common.File.Combine(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),mostCurrent._archivo));
RDebugUtils.currentLine=1179656;
 //BA.debugLineNum = 1179656;BA.debugLine="Dim sheet As XLSSheet = xls.getSheetAt(xls.Active";
_sheet = new de.donmanfred.XLSSheetwrapper();
_sheet = _xls.getSheetAt(_xls.getActiveSheetIndex());
RDebugUtils.currentLine=1179659;
 //BA.debugLineNum = 1179659;BA.debugLine="Dim row As XSSFRow =sheet.getRow(0)";
_row = new de.donmanfred.XSSFRowwrapper();
_row = (de.donmanfred.XSSFRowwrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new de.donmanfred.XSSFRowwrapper(), (org.apache.poi.xssf.usermodel.XSSFRow)(_sheet.getRow((int) (0))));
RDebugUtils.currentLine=1179660;
 //BA.debugLineNum = 1179660;BA.debugLine="Dim Cell As XSSFCell =row.getCell(0)";
_cell = new de.donmanfred.XSSFCellwrapper();
_cell = _row.getCell((int) (0));
RDebugUtils.currentLine=1179662;
 //BA.debugLineNum = 1179662;BA.debugLine="row=sheet.getRow(1)";
_row = (de.donmanfred.XSSFRowwrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new de.donmanfred.XSSFRowwrapper(), (org.apache.poi.xssf.usermodel.XSSFRow)(_sheet.getRow((int) (1))));
RDebugUtils.currentLine=1179663;
 //BA.debugLineNum = 1179663;BA.debugLine="Cell=row.getCell(2)";
_cell = _row.getCell((int) (2));
RDebugUtils.currentLine=1179664;
 //BA.debugLineNum = 1179664;BA.debugLine="Ingresos_ = Cell.NumericCellValue";
_ingresos_ = (float) (_cell.getNumericCellValue());
RDebugUtils.currentLine=1179666;
 //BA.debugLineNum = 1179666;BA.debugLine="row=sheet.getRow(2)";
_row = (de.donmanfred.XSSFRowwrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new de.donmanfred.XSSFRowwrapper(), (org.apache.poi.xssf.usermodel.XSSFRow)(_sheet.getRow((int) (2))));
RDebugUtils.currentLine=1179667;
 //BA.debugLineNum = 1179667;BA.debugLine="Cell=row.getCell(2)";
_cell = _row.getCell((int) (2));
RDebugUtils.currentLine=1179668;
 //BA.debugLineNum = 1179668;BA.debugLine="Gadm = Cell.NumericCellValue";
_gadm = (float) (_cell.getNumericCellValue());
RDebugUtils.currentLine=1179670;
 //BA.debugLineNum = 1179670;BA.debugLine="row=sheet.getRow(4)";
_row = (de.donmanfred.XSSFRowwrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new de.donmanfred.XSSFRowwrapper(), (org.apache.poi.xssf.usermodel.XSSFRow)(_sheet.getRow((int) (4))));
RDebugUtils.currentLine=1179671;
 //BA.debugLineNum = 1179671;BA.debugLine="Cell=row.getCell(2)";
_cell = _row.getCell((int) (2));
RDebugUtils.currentLine=1179672;
 //BA.debugLineNum = 1179672;BA.debugLine="GOp = Cell.NumericCellValue";
_gop = (float) (_cell.getNumericCellValue());
RDebugUtils.currentLine=1179675;
 //BA.debugLineNum = 1179675;BA.debugLine="End Sub";
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
RDebugUtils.currentLine=1114113;
 //BA.debugLineNum = 1114113;BA.debugLine="Dim fd As FileDialog";
_fd = new anywheresoftware.b4a.agraham.dialogs.InputDialog.FileDialog();
RDebugUtils.currentLine=1114114;
 //BA.debugLineNum = 1114114;BA.debugLine="fd.FastScroll = True";
_fd.setFastScroll(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=1114115;
 //BA.debugLineNum = 1114115;BA.debugLine="fd.ShowOnlyFolders=False";
_fd.setShowOnlyFolders(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=1114116;
 //BA.debugLineNum = 1114116;BA.debugLine="fd.TextColor=Colors.Black";
_fd.TextColor = anywheresoftware.b4a.keywords.Common.Colors.Black;
RDebugUtils.currentLine=1114117;
 //BA.debugLineNum = 1114117;BA.debugLine="fd.FilePath = File.DirInternal";
_fd.setFilePath(anywheresoftware.b4a.keywords.Common.File.getDirInternal());
RDebugUtils.currentLine=1114118;
 //BA.debugLineNum = 1114118;BA.debugLine="Dim sf As Object = fd.ShowAsync(\"Seleccionar Arch";
_sf = _fd.ShowAsync(BA.ObjectToCharSequence("Seleccionar Archivo"),"SELECCIONAR","Cancelar","si",mostCurrent.activityBA,(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=1114119;
 //BA.debugLineNum = 1114119;BA.debugLine="Wait For (sf) Dialog_Result(Result As Int)";
anywheresoftware.b4a.keywords.Common.WaitFor("dialog_result", processBA, new anywheresoftware.b4a.shell.DebugResumableSub.DelegatableResumableSub(this, "main", "boton_click"), _sf);
this.state = 5;
return;
case 5:
//C
this.state = 1;
_result = (Integer) result[0];
;
RDebugUtils.currentLine=1114120;
 //BA.debugLineNum = 1114120;BA.debugLine="If Result = DialogResponse.POSITIVE Then";
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
RDebugUtils.currentLine=1114121;
 //BA.debugLineNum = 1114121;BA.debugLine="Log(\"File path: \" & fd.FilePath)";
anywheresoftware.b4a.keywords.Common.LogImpl("01114121","File path: "+_fd.getFilePath(),0);
RDebugUtils.currentLine=1114122;
 //BA.debugLineNum = 1114122;BA.debugLine="archivo = fd.ChosenName";
parent.mostCurrent._archivo = _fd.getChosenName();
RDebugUtils.currentLine=1114123;
 //BA.debugLineNum = 1114123;BA.debugLine="Log(\"File name: \" & archivo)";
anywheresoftware.b4a.keywords.Common.LogImpl("01114123","File name: "+parent.mostCurrent._archivo,0);
 if (true) break;

case 4:
//C
this.state = -1;
;
RDebugUtils.currentLine=1114125;
 //BA.debugLineNum = 1114125;BA.debugLine="Label1.Text = \"Ruta = \" & fd.FilePath";
parent.mostCurrent._label1.setText(BA.ObjectToCharSequence("Ruta = "+_fd.getFilePath()));
RDebugUtils.currentLine=1114126;
 //BA.debugLineNum = 1114126;BA.debugLine="Label2.Text = \"Archivo = \" & fd.ChosenName";
parent.mostCurrent._label2.setText(BA.ObjectToCharSequence("Archivo = "+_fd.getChosenName()));
RDebugUtils.currentLine=1114128;
 //BA.debugLineNum = 1114128;BA.debugLine="Log(\"File path: \" & archivo)";
anywheresoftware.b4a.keywords.Common.LogImpl("01114128","File path: "+parent.mostCurrent._archivo,0);
RDebugUtils.currentLine=1114130;
 //BA.debugLineNum = 1114130;BA.debugLine="End Sub";
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
RDebugUtils.currentLine=1245184;
 //BA.debugLineNum = 1245184;BA.debugLine="Private Sub ER_Click";
RDebugUtils.currentLine=1245185;
 //BA.debugLineNum = 1245185;BA.debugLine="File.Copy(File.DirAssets,archivo,File.DirInternal";
anywheresoftware.b4a.keywords.Common.File.Copy(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),mostCurrent._archivo,anywheresoftware.b4a.keywords.Common.File.getDirInternal(),mostCurrent._archivo);
RDebugUtils.currentLine=1245186;
 //BA.debugLineNum = 1245186;BA.debugLine="xls.Initialize(\"\",File.Combine(File.DirInternal,a";
_xls.Initialize(processBA,"",anywheresoftware.b4a.keywords.Common.File.Combine(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),mostCurrent._archivo));
RDebugUtils.currentLine=1245188;
 //BA.debugLineNum = 1245188;BA.debugLine="Dim sheet As XLSSheet = xls.getSheetAt(xls.Active";
_sheet = new de.donmanfred.XLSSheetwrapper();
_sheet = _xls.getSheetAt(_xls.getActiveSheetIndex());
RDebugUtils.currentLine=1245192;
 //BA.debugLineNum = 1245192;BA.debugLine="Activity.RemoveAllViews";
mostCurrent._activity.RemoveAllViews();
RDebugUtils.currentLine=1245193;
 //BA.debugLineNum = 1245193;BA.debugLine="Activity.LoadLayout(\"EstadoResultados\")";
mostCurrent._activity.LoadLayout("EstadoResultados",mostCurrent.activityBA);
RDebugUtils.currentLine=1245194;
 //BA.debugLineNum = 1245194;BA.debugLine="Dim row As XSSFRow =sheet.getRow(0)";
_row = new de.donmanfred.XSSFRowwrapper();
_row = (de.donmanfred.XSSFRowwrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new de.donmanfred.XSSFRowwrapper(), (org.apache.poi.xssf.usermodel.XSSFRow)(_sheet.getRow((int) (0))));
RDebugUtils.currentLine=1245195;
 //BA.debugLineNum = 1245195;BA.debugLine="Dim Cell As XSSFCell =row.getCell(0)";
_cell = new de.donmanfred.XSSFCellwrapper();
_cell = _row.getCell((int) (0));
RDebugUtils.currentLine=1245197;
 //BA.debugLineNum = 1245197;BA.debugLine="Dim Texto1 As String = NumberFormat2(0, 1, 2, 2,";
_texto1 = anywheresoftware.b4a.keywords.Common.NumberFormat2(0,(int) (1),(int) (2),(int) (2),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=1245198;
 //BA.debugLineNum = 1245198;BA.debugLine="Texto1 = Cell.StringCellValue";
_texto1 = _cell.getStringCellValue();
RDebugUtils.currentLine=1245199;
 //BA.debugLineNum = 1245199;BA.debugLine="Concepto.text= Texto1";
mostCurrent._concepto.setText(BA.ObjectToCharSequence(_texto1));
RDebugUtils.currentLine=1245201;
 //BA.debugLineNum = 1245201;BA.debugLine="row=sheet.getRow(1)";
_row = (de.donmanfred.XSSFRowwrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new de.donmanfred.XSSFRowwrapper(), (org.apache.poi.xssf.usermodel.XSSFRow)(_sheet.getRow((int) (1))));
RDebugUtils.currentLine=1245202;
 //BA.debugLineNum = 1245202;BA.debugLine="Cell=row.getCell(0)";
_cell = _row.getCell((int) (0));
RDebugUtils.currentLine=1245203;
 //BA.debugLineNum = 1245203;BA.debugLine="Texto1 = Cell.StringCellValue";
_texto1 = _cell.getStringCellValue();
RDebugUtils.currentLine=1245205;
 //BA.debugLineNum = 1245205;BA.debugLine="Concepto1.text= Texto1";
mostCurrent._concepto1.setText(BA.ObjectToCharSequence(_texto1));
RDebugUtils.currentLine=1245207;
 //BA.debugLineNum = 1245207;BA.debugLine="row=sheet.getRow(2)";
_row = (de.donmanfred.XSSFRowwrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new de.donmanfred.XSSFRowwrapper(), (org.apache.poi.xssf.usermodel.XSSFRow)(_sheet.getRow((int) (2))));
RDebugUtils.currentLine=1245208;
 //BA.debugLineNum = 1245208;BA.debugLine="Cell=row.getCell(0)";
_cell = _row.getCell((int) (0));
RDebugUtils.currentLine=1245209;
 //BA.debugLineNum = 1245209;BA.debugLine="Texto1 = Cell.StringCellValue";
_texto1 = _cell.getStringCellValue();
RDebugUtils.currentLine=1245210;
 //BA.debugLineNum = 1245210;BA.debugLine="Concepto2.text= Texto1";
mostCurrent._concepto2.setText(BA.ObjectToCharSequence(_texto1));
RDebugUtils.currentLine=1245212;
 //BA.debugLineNum = 1245212;BA.debugLine="row=sheet.getRow(3)";
_row = (de.donmanfred.XSSFRowwrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new de.donmanfred.XSSFRowwrapper(), (org.apache.poi.xssf.usermodel.XSSFRow)(_sheet.getRow((int) (3))));
RDebugUtils.currentLine=1245213;
 //BA.debugLineNum = 1245213;BA.debugLine="Cell=row.getCell(0)";
_cell = _row.getCell((int) (0));
RDebugUtils.currentLine=1245214;
 //BA.debugLineNum = 1245214;BA.debugLine="Texto1 = Cell.StringCellValue";
_texto1 = _cell.getStringCellValue();
RDebugUtils.currentLine=1245215;
 //BA.debugLineNum = 1245215;BA.debugLine="Concepto3.text= Texto1";
mostCurrent._concepto3.setText(BA.ObjectToCharSequence(_texto1));
RDebugUtils.currentLine=1245217;
 //BA.debugLineNum = 1245217;BA.debugLine="row=sheet.getRow(4)";
_row = (de.donmanfred.XSSFRowwrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new de.donmanfred.XSSFRowwrapper(), (org.apache.poi.xssf.usermodel.XSSFRow)(_sheet.getRow((int) (4))));
RDebugUtils.currentLine=1245218;
 //BA.debugLineNum = 1245218;BA.debugLine="Cell=row.getCell(0)";
_cell = _row.getCell((int) (0));
RDebugUtils.currentLine=1245219;
 //BA.debugLineNum = 1245219;BA.debugLine="Texto1 = Cell.StringCellValue";
_texto1 = _cell.getStringCellValue();
RDebugUtils.currentLine=1245220;
 //BA.debugLineNum = 1245220;BA.debugLine="Concepto4.text= Texto1";
mostCurrent._concepto4.setText(BA.ObjectToCharSequence(_texto1));
RDebugUtils.currentLine=1245222;
 //BA.debugLineNum = 1245222;BA.debugLine="row=sheet.getRow(5)";
_row = (de.donmanfred.XSSFRowwrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new de.donmanfred.XSSFRowwrapper(), (org.apache.poi.xssf.usermodel.XSSFRow)(_sheet.getRow((int) (5))));
RDebugUtils.currentLine=1245223;
 //BA.debugLineNum = 1245223;BA.debugLine="Cell=row.getCell(0)";
_cell = _row.getCell((int) (0));
RDebugUtils.currentLine=1245224;
 //BA.debugLineNum = 1245224;BA.debugLine="Texto1 = Cell.StringCellValue";
_texto1 = _cell.getStringCellValue();
RDebugUtils.currentLine=1245225;
 //BA.debugLineNum = 1245225;BA.debugLine="Concepto5.text= Texto1";
mostCurrent._concepto5.setText(BA.ObjectToCharSequence(_texto1));
RDebugUtils.currentLine=1245227;
 //BA.debugLineNum = 1245227;BA.debugLine="row=sheet.getRow(6)";
_row = (de.donmanfred.XSSFRowwrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new de.donmanfred.XSSFRowwrapper(), (org.apache.poi.xssf.usermodel.XSSFRow)(_sheet.getRow((int) (6))));
RDebugUtils.currentLine=1245228;
 //BA.debugLineNum = 1245228;BA.debugLine="Cell=row.getCell(0)";
_cell = _row.getCell((int) (0));
RDebugUtils.currentLine=1245229;
 //BA.debugLineNum = 1245229;BA.debugLine="Texto1 = Cell.StringCellValue";
_texto1 = _cell.getStringCellValue();
RDebugUtils.currentLine=1245230;
 //BA.debugLineNum = 1245230;BA.debugLine="Concepto6.text= Texto1";
mostCurrent._concepto6.setText(BA.ObjectToCharSequence(_texto1));
RDebugUtils.currentLine=1245232;
 //BA.debugLineNum = 1245232;BA.debugLine="row=sheet.getRow(7)";
_row = (de.donmanfred.XSSFRowwrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new de.donmanfred.XSSFRowwrapper(), (org.apache.poi.xssf.usermodel.XSSFRow)(_sheet.getRow((int) (7))));
RDebugUtils.currentLine=1245233;
 //BA.debugLineNum = 1245233;BA.debugLine="Cell=row.getCell(0)";
_cell = _row.getCell((int) (0));
RDebugUtils.currentLine=1245234;
 //BA.debugLineNum = 1245234;BA.debugLine="Texto1 = Cell.StringCellValue";
_texto1 = _cell.getStringCellValue();
RDebugUtils.currentLine=1245235;
 //BA.debugLineNum = 1245235;BA.debugLine="Concepto7.text= Texto1";
mostCurrent._concepto7.setText(BA.ObjectToCharSequence(_texto1));
RDebugUtils.currentLine=1245237;
 //BA.debugLineNum = 1245237;BA.debugLine="row=sheet.getRow(0)";
_row = (de.donmanfred.XSSFRowwrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new de.donmanfred.XSSFRowwrapper(), (org.apache.poi.xssf.usermodel.XSSFRow)(_sheet.getRow((int) (0))));
RDebugUtils.currentLine=1245238;
 //BA.debugLineNum = 1245238;BA.debugLine="Cell=row.getCell(2)";
_cell = _row.getCell((int) (2));
RDebugUtils.currentLine=1245239;
 //BA.debugLineNum = 1245239;BA.debugLine="Texto1 = Cell.StringCellValue";
_texto1 = _cell.getStringCellValue();
RDebugUtils.currentLine=1245240;
 //BA.debugLineNum = 1245240;BA.debugLine="Datos.text= Texto1";
mostCurrent._datos.setText(BA.ObjectToCharSequence(_texto1));
RDebugUtils.currentLine=1245242;
 //BA.debugLineNum = 1245242;BA.debugLine="row=sheet.getRow(1)";
_row = (de.donmanfred.XSSFRowwrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new de.donmanfred.XSSFRowwrapper(), (org.apache.poi.xssf.usermodel.XSSFRow)(_sheet.getRow((int) (1))));
RDebugUtils.currentLine=1245243;
 //BA.debugLineNum = 1245243;BA.debugLine="Cell=row.getCell(2)";
_cell = _row.getCell((int) (2));
RDebugUtils.currentLine=1245244;
 //BA.debugLineNum = 1245244;BA.debugLine="Texto1 = formatter.Format(Cell.NumericCellValue)";
_texto1 = _formatter._format /*String*/ (null,_cell.getNumericCellValue());
RDebugUtils.currentLine=1245245;
 //BA.debugLineNum = 1245245;BA.debugLine="Datos1.text= Texto1";
mostCurrent._datos1.setText(BA.ObjectToCharSequence(_texto1));
RDebugUtils.currentLine=1245247;
 //BA.debugLineNum = 1245247;BA.debugLine="row=sheet.getRow(2)";
_row = (de.donmanfred.XSSFRowwrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new de.donmanfred.XSSFRowwrapper(), (org.apache.poi.xssf.usermodel.XSSFRow)(_sheet.getRow((int) (2))));
RDebugUtils.currentLine=1245248;
 //BA.debugLineNum = 1245248;BA.debugLine="Cell=row.getCell(2)";
_cell = _row.getCell((int) (2));
RDebugUtils.currentLine=1245249;
 //BA.debugLineNum = 1245249;BA.debugLine="Texto1 = formatter.Format(Cell.NumericCellValue)";
_texto1 = _formatter._format /*String*/ (null,_cell.getNumericCellValue());
RDebugUtils.currentLine=1245250;
 //BA.debugLineNum = 1245250;BA.debugLine="Datos2.text= Texto1";
mostCurrent._datos2.setText(BA.ObjectToCharSequence(_texto1));
RDebugUtils.currentLine=1245252;
 //BA.debugLineNum = 1245252;BA.debugLine="row=sheet.getRow(3)";
_row = (de.donmanfred.XSSFRowwrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new de.donmanfred.XSSFRowwrapper(), (org.apache.poi.xssf.usermodel.XSSFRow)(_sheet.getRow((int) (3))));
RDebugUtils.currentLine=1245253;
 //BA.debugLineNum = 1245253;BA.debugLine="Cell=row.getCell(2)";
_cell = _row.getCell((int) (2));
RDebugUtils.currentLine=1245254;
 //BA.debugLineNum = 1245254;BA.debugLine="Texto1 = formatter.Format(Cell.NumericCellValue)";
_texto1 = _formatter._format /*String*/ (null,_cell.getNumericCellValue());
RDebugUtils.currentLine=1245255;
 //BA.debugLineNum = 1245255;BA.debugLine="Datos3.text= Texto1";
mostCurrent._datos3.setText(BA.ObjectToCharSequence(_texto1));
RDebugUtils.currentLine=1245257;
 //BA.debugLineNum = 1245257;BA.debugLine="row=sheet.getRow(4)";
_row = (de.donmanfred.XSSFRowwrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new de.donmanfred.XSSFRowwrapper(), (org.apache.poi.xssf.usermodel.XSSFRow)(_sheet.getRow((int) (4))));
RDebugUtils.currentLine=1245258;
 //BA.debugLineNum = 1245258;BA.debugLine="Cell=row.getCell(2)";
_cell = _row.getCell((int) (2));
RDebugUtils.currentLine=1245259;
 //BA.debugLineNum = 1245259;BA.debugLine="Texto1 = formatter.Format(Cell.NumericCellValue)";
_texto1 = _formatter._format /*String*/ (null,_cell.getNumericCellValue());
RDebugUtils.currentLine=1245260;
 //BA.debugLineNum = 1245260;BA.debugLine="Datos4.text= Texto1";
mostCurrent._datos4.setText(BA.ObjectToCharSequence(_texto1));
RDebugUtils.currentLine=1245262;
 //BA.debugLineNum = 1245262;BA.debugLine="row=sheet.getRow(5)";
_row = (de.donmanfred.XSSFRowwrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new de.donmanfred.XSSFRowwrapper(), (org.apache.poi.xssf.usermodel.XSSFRow)(_sheet.getRow((int) (5))));
RDebugUtils.currentLine=1245263;
 //BA.debugLineNum = 1245263;BA.debugLine="Cell=row.getCell(2)";
_cell = _row.getCell((int) (2));
RDebugUtils.currentLine=1245264;
 //BA.debugLineNum = 1245264;BA.debugLine="Texto1 = formatter.Format(Cell.NumericCellValue)";
_texto1 = _formatter._format /*String*/ (null,_cell.getNumericCellValue());
RDebugUtils.currentLine=1245265;
 //BA.debugLineNum = 1245265;BA.debugLine="Datos5.text= Texto1";
mostCurrent._datos5.setText(BA.ObjectToCharSequence(_texto1));
RDebugUtils.currentLine=1245267;
 //BA.debugLineNum = 1245267;BA.debugLine="row=sheet.getRow(6)";
_row = (de.donmanfred.XSSFRowwrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new de.donmanfred.XSSFRowwrapper(), (org.apache.poi.xssf.usermodel.XSSFRow)(_sheet.getRow((int) (6))));
RDebugUtils.currentLine=1245268;
 //BA.debugLineNum = 1245268;BA.debugLine="Cell=row.getCell(2)";
_cell = _row.getCell((int) (2));
RDebugUtils.currentLine=1245269;
 //BA.debugLineNum = 1245269;BA.debugLine="Texto1 = formatter.Format(Cell.NumericCellValue)";
_texto1 = _formatter._format /*String*/ (null,_cell.getNumericCellValue());
RDebugUtils.currentLine=1245270;
 //BA.debugLineNum = 1245270;BA.debugLine="Datos6.text= Texto1";
mostCurrent._datos6.setText(BA.ObjectToCharSequence(_texto1));
RDebugUtils.currentLine=1245272;
 //BA.debugLineNum = 1245272;BA.debugLine="row=sheet.getRow(7)";
_row = (de.donmanfred.XSSFRowwrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new de.donmanfred.XSSFRowwrapper(), (org.apache.poi.xssf.usermodel.XSSFRow)(_sheet.getRow((int) (7))));
RDebugUtils.currentLine=1245273;
 //BA.debugLineNum = 1245273;BA.debugLine="Cell=row.getCell(2)";
_cell = _row.getCell((int) (2));
RDebugUtils.currentLine=1245274;
 //BA.debugLineNum = 1245274;BA.debugLine="Texto1 = formatter.Format(Cell.NumericCellValue)";
_texto1 = _formatter._format /*String*/ (null,_cell.getNumericCellValue());
RDebugUtils.currentLine=1245275;
 //BA.debugLineNum = 1245275;BA.debugLine="Datos7.text= Texto1";
mostCurrent._datos7.setText(BA.ObjectToCharSequence(_texto1));
RDebugUtils.currentLine=1245276;
 //BA.debugLineNum = 1245276;BA.debugLine="End Sub";
return "";
}
public static String  _info_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "info_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "info_click", null));}
RDebugUtils.currentLine=1048576;
 //BA.debugLineNum = 1048576;BA.debugLine="Private Sub info_Click";
RDebugUtils.currentLine=1048577;
 //BA.debugLineNum = 1048577;BA.debugLine="MsgboxAsync(\"Recuerda verificar que el archivo ele";
anywheresoftware.b4a.keywords.Common.MsgboxAsync(BA.ObjectToCharSequence("Recuerda verificar que el archivo elegido es el correcto"),BA.ObjectToCharSequence("INFORMACIÓN"),processBA);
RDebugUtils.currentLine=1048580;
 //BA.debugLineNum = 1048580;BA.debugLine="End Sub";
return "";
}
public static String  _ingresos_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "ingresos_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "ingresos_click", null));}
RDebugUtils.currentLine=1376256;
 //BA.debugLineNum = 1376256;BA.debugLine="Private Sub Ingresos_Click";
RDebugUtils.currentLine=1376257;
 //BA.debugLineNum = 1376257;BA.debugLine="Activity.RemoveAllViews";
mostCurrent._activity.RemoveAllViews();
RDebugUtils.currentLine=1376258;
 //BA.debugLineNum = 1376258;BA.debugLine="Activity.LoadLayout(\"Ingresos_gastos\")";
mostCurrent._activity.LoadLayout("Ingresos_gastos",mostCurrent.activityBA);
RDebugUtils.currentLine=1376266;
 //BA.debugLineNum = 1376266;BA.debugLine="mbc1.LegendShapeSize = 7.0	    'this line of code";
mostCurrent._mbc1.setLegendShapeSize((float) (7.0));
RDebugUtils.currentLine=1376267;
 //BA.debugLineNum = 1376267;BA.debugLine="mbc1.setTheLegendPositionAndForm(\"BELOW_CHART_CEN";
mostCurrent._mbc1.setTheLegendPositionAndForm("BELOW_CHART_CENTER","CIRCLE");
RDebugUtils.currentLine=1376269;
 //BA.debugLineNum = 1376269;BA.debugLine="mbc1.TheLegendColor = Colors.Gray";
mostCurrent._mbc1.setTheLegendColor(anywheresoftware.b4a.keywords.Common.Colors.Gray);
RDebugUtils.currentLine=1376270;
 //BA.debugLineNum = 1376270;BA.debugLine="mbc1.TheLegendTextSize = 20.0";
mostCurrent._mbc1.setTheLegendTextSize((float) (20.0));
RDebugUtils.currentLine=1376271;
 //BA.debugLineNum = 1376271;BA.debugLine="mbc1.LegendTitle = \"\"";
mostCurrent._mbc1.setLegendTitle("");
RDebugUtils.currentLine=1376272;
 //BA.debugLineNum = 1376272;BA.debugLine="mbc1.ChartDescription = \"\"";
mostCurrent._mbc1.setChartDescription("");
RDebugUtils.currentLine=1376273;
 //BA.debugLineNum = 1376273;BA.debugLine="mbc1.ChartDescriptionColor = 0XFFFFA500";
mostCurrent._mbc1.setChartDescriptionColor(((int)0xffffa500));
RDebugUtils.currentLine=1376274;
 //BA.debugLineNum = 1376274;BA.debugLine="mbc1.ChartDescriptionTextSize = 19";
mostCurrent._mbc1.setChartDescriptionTextSize((float) (19));
RDebugUtils.currentLine=1376276;
 //BA.debugLineNum = 1376276;BA.debugLine="mbc1.ValueTextColor = Colors.Black";
mostCurrent._mbc1.setValueTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=1376277;
 //BA.debugLineNum = 1376277;BA.debugLine="mbc1.ValueTextSize = 11.0";
mostCurrent._mbc1.setValueTextSize((int) (11.0));
RDebugUtils.currentLine=1376280;
 //BA.debugLineNum = 1376280;BA.debugLine="mbc1.BarColors = Array As Int(Colors.Blue, Colors";
mostCurrent._mbc1.setBarColors(new int[]{anywheresoftware.b4a.keywords.Common.Colors.Blue,anywheresoftware.b4a.keywords.Common.Colors.Green,anywheresoftware.b4a.keywords.Common.Colors.Magenta,anywheresoftware.b4a.keywords.Common.Colors.Cyan});
RDebugUtils.currentLine=1376281;
 //BA.debugLineNum = 1376281;BA.debugLine="mbc1.LegendText = Array As String(\"Ingresos\", \"G,";
mostCurrent._mbc1.setLegendText(new String[]{"Ingresos","G,Operacionales","G. Admin."});
RDebugUtils.currentLine=1376282;
 //BA.debugLineNum = 1376282;BA.debugLine="mbc1.ChartData = Array As Float (Ingresos_, Gadm,";
mostCurrent._mbc1.setChartData(new float[]{_ingresos_,_gadm,_gop});
RDebugUtils.currentLine=1376284;
 //BA.debugLineNum = 1376284;BA.debugLine="mbc1.DoubleTapToZoomEnabled = True";
mostCurrent._mbc1.setDoubleTapToZoomEnabled(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=1376285;
 //BA.debugLineNum = 1376285;BA.debugLine="mbc1.DrawBarShadow = False";
mostCurrent._mbc1.setDrawBarShadow(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=1376286;
 //BA.debugLineNum = 1376286;BA.debugLine="mbc1.GridBackgroundColor = Colors.Black";
mostCurrent._mbc1.setGridBackgroundColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=1376287;
 //BA.debugLineNum = 1376287;BA.debugLine="mbc1.ValueTextColor = 0XFFFFA500";
mostCurrent._mbc1.setValueTextColor(((int)0xffffa500));
RDebugUtils.currentLine=1376288;
 //BA.debugLineNum = 1376288;BA.debugLine="mbc1.DrawBorders = True";
mostCurrent._mbc1.setDrawBorders(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=1376289;
 //BA.debugLineNum = 1376289;BA.debugLine="mbc1.DrawGridBackground = True";
mostCurrent._mbc1.setDrawGridBackground(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=1376290;
 //BA.debugLineNum = 1376290;BA.debugLine="mbc1.DrawHighlightArrow = True";
mostCurrent._mbc1.setDrawHighlightArrow(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=1376291;
 //BA.debugLineNum = 1376291;BA.debugLine="mbc1.DrawValueAboveBar = True";
mostCurrent._mbc1.setDrawValueAboveBar(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=1376292;
 //BA.debugLineNum = 1376292;BA.debugLine="mbc1.PinchZoom = True";
mostCurrent._mbc1.setPinchZoom(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=1376293;
 //BA.debugLineNum = 1376293;BA.debugLine="mbc1.ScaleEnabled = True";
mostCurrent._mbc1.setScaleEnabled(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=1376294;
 //BA.debugLineNum = 1376294;BA.debugLine="mbc1.BorderColor = Colors.Blue";
mostCurrent._mbc1.setBorderColor(anywheresoftware.b4a.keywords.Common.Colors.Blue);
RDebugUtils.currentLine=1376295;
 //BA.debugLineNum = 1376295;BA.debugLine="mbc1.BorderWidth = 3.0";
mostCurrent._mbc1.setBorderWidth((float) (3.0));
RDebugUtils.currentLine=1376297;
 //BA.debugLineNum = 1376297;BA.debugLine="mbc1.BarData = 3   'this number must be the same";
mostCurrent._mbc1.setBarData((int) (3));
RDebugUtils.currentLine=1376299;
 //BA.debugLineNum = 1376299;BA.debugLine="End Sub";
return "";
}
public static String  _iniciar_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "iniciar_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "iniciar_click", null));}
RDebugUtils.currentLine=983040;
 //BA.debugLineNum = 983040;BA.debugLine="Private Sub INICIAR_Click";
RDebugUtils.currentLine=983041;
 //BA.debugLineNum = 983041;BA.debugLine="Usuario = Nombre.Text";
mostCurrent._usuario = mostCurrent._nombre.getText();
RDebugUtils.currentLine=983042;
 //BA.debugLineNum = 983042;BA.debugLine="Activity.RemoveAllViews";
mostCurrent._activity.RemoveAllViews();
RDebugUtils.currentLine=983043;
 //BA.debugLineNum = 983043;BA.debugLine="Activity.LoadLayout(\"Pantalla2\")";
mostCurrent._activity.LoadLayout("Pantalla2",mostCurrent.activityBA);
RDebugUtils.currentLine=983044;
 //BA.debugLineNum = 983044;BA.debugLine="Panel1.Visible=True";
mostCurrent._panel1.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=983045;
 //BA.debugLineNum = 983045;BA.debugLine="HiUsuario.Text= \"Hola \" & Usuario";
mostCurrent._hiusuario.setText(BA.ObjectToCharSequence("Hola "+mostCurrent._usuario));
RDebugUtils.currentLine=983048;
 //BA.debugLineNum = 983048;BA.debugLine="End Sub";
return "";
}
public static String  _regresar_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "regresar_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "regresar_click", null));}
RDebugUtils.currentLine=1310720;
 //BA.debugLineNum = 1310720;BA.debugLine="Private Sub Regresar_Click";
RDebugUtils.currentLine=1310721;
 //BA.debugLineNum = 1310721;BA.debugLine="Activity.RemoveAllViews";
mostCurrent._activity.RemoveAllViews();
RDebugUtils.currentLine=1310722;
 //BA.debugLineNum = 1310722;BA.debugLine="Activity.LoadLayout(\"Analisis\")";
mostCurrent._activity.LoadLayout("Analisis",mostCurrent.activityBA);
RDebugUtils.currentLine=1310723;
 //BA.debugLineNum = 1310723;BA.debugLine="Panel2.Visible=True";
mostCurrent._panel2.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=1310724;
 //BA.debugLineNum = 1310724;BA.debugLine="End Sub";
return "";
}
public static String  _regresar2_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "regresar2_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "regresar2_click", null));}
RDebugUtils.currentLine=1441792;
 //BA.debugLineNum = 1441792;BA.debugLine="Private Sub Regresar2_Click";
RDebugUtils.currentLine=1441793;
 //BA.debugLineNum = 1441793;BA.debugLine="Activity.RemoveAllViews";
mostCurrent._activity.RemoveAllViews();
RDebugUtils.currentLine=1441794;
 //BA.debugLineNum = 1441794;BA.debugLine="Activity.LoadLayout(\"Analisis\")";
mostCurrent._activity.LoadLayout("Analisis",mostCurrent.activityBA);
RDebugUtils.currentLine=1441795;
 //BA.debugLineNum = 1441795;BA.debugLine="End Sub";
return "";
}
}