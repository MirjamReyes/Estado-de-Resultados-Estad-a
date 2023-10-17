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
public static String _path = "";
public anywheresoftware.b4a.objects.EditTextWrapper _nombre = null;
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
public b4a.example.starter _starter = null;
public static String  _activity_create(boolean _firsttime) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_create", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_create", new Object[] {_firsttime}));}
b4a.example.b4xformatter._b4xformatdata _defaultformat = null;
b4a.example.b4xformatter._b4xformatdata _negativeformat = null;
RDebugUtils.currentLine=131072;
 //BA.debugLineNum = 131072;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
RDebugUtils.currentLine=131075;
 //BA.debugLineNum = 131075;BA.debugLine="Activity.LoadLayout(\"Pantalla1\")";
mostCurrent._activity.LoadLayout("Pantalla1",mostCurrent.activityBA);
RDebugUtils.currentLine=131077;
 //BA.debugLineNum = 131077;BA.debugLine="If FirstTime Then";
if (_firsttime) { 
RDebugUtils.currentLine=131078;
 //BA.debugLineNum = 131078;BA.debugLine="formatter.Initialize";
_formatter._initialize /*String*/ (null,processBA);
RDebugUtils.currentLine=131079;
 //BA.debugLineNum = 131079;BA.debugLine="Dim DefaultFormat As B4XFormatData = formatter.G";
_defaultformat = _formatter._getdefaultformat /*b4a.example.b4xformatter._b4xformatdata*/ (null);
RDebugUtils.currentLine=131080;
 //BA.debugLineNum = 131080;BA.debugLine="DefaultFormat.MaximumFractions = 2";
_defaultformat.MaximumFractions /*int*/  = (int) (2);
RDebugUtils.currentLine=131081;
 //BA.debugLineNum = 131081;BA.debugLine="DefaultFormat.MinimumFractions = 2";
_defaultformat.MinimumFractions /*int*/  = (int) (2);
RDebugUtils.currentLine=131082;
 //BA.debugLineNum = 131082;BA.debugLine="DefaultFormat.Prefix = \"$ \"";
_defaultformat.Prefix /*String*/  = "$ ";
RDebugUtils.currentLine=131083;
 //BA.debugLineNum = 131083;BA.debugLine="Dim NegativeFormat As B4XFormatData = formatter.";
_negativeformat = _formatter._copyformatdata /*b4a.example.b4xformatter._b4xformatdata*/ (null,_defaultformat);
RDebugUtils.currentLine=131084;
 //BA.debugLineNum = 131084;BA.debugLine="NegativeFormat.TextColor = xui.Color_Red";
_negativeformat.TextColor /*int*/  = _xui.Color_Red;
RDebugUtils.currentLine=131085;
 //BA.debugLineNum = 131085;BA.debugLine="NegativeFormat.Prefix = \"$ (\"";
_negativeformat.Prefix /*String*/  = "$ (";
RDebugUtils.currentLine=131086;
 //BA.debugLineNum = 131086;BA.debugLine="NegativeFormat.Postfix = \")\"";
_negativeformat.Postfix /*String*/  = ")";
RDebugUtils.currentLine=131087;
 //BA.debugLineNum = 131087;BA.debugLine="NegativeFormat.FormatFont = xui.CreateDefaultBol";
_negativeformat.FormatFont /*anywheresoftware.b4a.objects.B4XViewWrapper.B4XFont*/  = _xui.CreateDefaultBoldFont((float) (15));
RDebugUtils.currentLine=131088;
 //BA.debugLineNum = 131088;BA.debugLine="formatter.AddFormatData(NegativeFormat, formatte";
_formatter._addformatdata /*String*/ (null,_negativeformat,_formatter._min_value /*int*/ ,0,anywheresoftware.b4a.keywords.Common.False);
 };
RDebugUtils.currentLine=131091;
 //BA.debugLineNum = 131091;BA.debugLine="End Sub";
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
int _firstrow = 0;
int _lastrow = 0;
de.donmanfred.XSSFRowwrapper _row = null;
de.donmanfred.XSSFCellwrapper _cell = null;
String _texto1 = "";
RDebugUtils.currentLine=524288;
 //BA.debugLineNum = 524288;BA.debugLine="Private Sub Analisis_Click";
RDebugUtils.currentLine=524290;
 //BA.debugLineNum = 524290;BA.debugLine="File.Copy(File.DirAssets,archivo,File.DirInternal";
anywheresoftware.b4a.keywords.Common.File.Copy(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),mostCurrent._archivo,anywheresoftware.b4a.keywords.Common.File.getDirInternal(),mostCurrent._archivo);
RDebugUtils.currentLine=524291;
 //BA.debugLineNum = 524291;BA.debugLine="xls.Initialize(\"\",File.Combine(File.DirInternal,a";
_xls.Initialize(processBA,"",anywheresoftware.b4a.keywords.Common.File.Combine(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),mostCurrent._archivo));
RDebugUtils.currentLine=524292;
 //BA.debugLineNum = 524292;BA.debugLine="Log($\"ActiveSheetIndex=${xls.ActiveSheetIndex}\"$)";
anywheresoftware.b4a.keywords.Common.LogImpl("2524292",("ActiveSheetIndex="+anywheresoftware.b4a.keywords.Common.SmartStringFormatter("",(Object)(_xls.getActiveSheetIndex()))+""),0);
RDebugUtils.currentLine=524293;
 //BA.debugLineNum = 524293;BA.debugLine="Dim sheet As XLSSheet = xls.getSheetAt(xls.Active";
_sheet = new de.donmanfred.XLSSheetwrapper();
_sheet = _xls.getSheetAt(_xls.getActiveSheetIndex());
RDebugUtils.currentLine=524294;
 //BA.debugLineNum = 524294;BA.debugLine="Log($\"ActiveSheet.ActiveCell=${sheet.ActiveCell}\"";
anywheresoftware.b4a.keywords.Common.LogImpl("2524294",("ActiveSheet.ActiveCell="+anywheresoftware.b4a.keywords.Common.SmartStringFormatter("",(Object)(_sheet.getActiveCell()))+""),0);
RDebugUtils.currentLine=524295;
 //BA.debugLineNum = 524295;BA.debugLine="Log($\"ActiveSheet.hasComments=${sheet.hasComments";
anywheresoftware.b4a.keywords.Common.LogImpl("2524295",("ActiveSheet.hasComments="+anywheresoftware.b4a.keywords.Common.SmartStringFormatter("",(Object)(_sheet.hasComments()))+""),0);
RDebugUtils.currentLine=524296;
 //BA.debugLineNum = 524296;BA.debugLine="Dim firstrow As Int = sheet.FirstRowNum";
_firstrow = _sheet.getFirstRowNum();
RDebugUtils.currentLine=524297;
 //BA.debugLineNum = 524297;BA.debugLine="Dim lastrow As Int = sheet.LastRowNum";
_lastrow = _sheet.getLastRowNum();
RDebugUtils.currentLine=524298;
 //BA.debugLineNum = 524298;BA.debugLine="Log($\"Row FirstRow=${firstrow}, LastRow=${lastrow";
anywheresoftware.b4a.keywords.Common.LogImpl("2524298",("Row FirstRow="+anywheresoftware.b4a.keywords.Common.SmartStringFormatter("",(Object)(_firstrow))+", LastRow="+anywheresoftware.b4a.keywords.Common.SmartStringFormatter("",(Object)(_lastrow))+""),0);
RDebugUtils.currentLine=524334;
 //BA.debugLineNum = 524334;BA.debugLine="Activity.RemoveAllViews";
mostCurrent._activity.RemoveAllViews();
RDebugUtils.currentLine=524335;
 //BA.debugLineNum = 524335;BA.debugLine="Activity.LoadLayout(\"EstadoResultados\")";
mostCurrent._activity.LoadLayout("EstadoResultados",mostCurrent.activityBA);
RDebugUtils.currentLine=524336;
 //BA.debugLineNum = 524336;BA.debugLine="Dim row As XSSFRow =sheet.getRow(0)";
_row = new de.donmanfred.XSSFRowwrapper();
_row = (de.donmanfred.XSSFRowwrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new de.donmanfred.XSSFRowwrapper(), (org.apache.poi.xssf.usermodel.XSSFRow)(_sheet.getRow((int) (0))));
RDebugUtils.currentLine=524337;
 //BA.debugLineNum = 524337;BA.debugLine="Dim Cell As XSSFCell =row.getCell(0)";
_cell = new de.donmanfred.XSSFCellwrapper();
_cell = _row.getCell((int) (0));
RDebugUtils.currentLine=524339;
 //BA.debugLineNum = 524339;BA.debugLine="Log(\"valor pelon:\"&Cell.RawValue)";
anywheresoftware.b4a.keywords.Common.LogImpl("2524339","valor pelon:"+_cell.getRawValue(),0);
RDebugUtils.currentLine=524340;
 //BA.debugLineNum = 524340;BA.debugLine="Dim Texto1 As String = NumberFormat2(0, 1, 2, 2,";
_texto1 = anywheresoftware.b4a.keywords.Common.NumberFormat2(0,(int) (1),(int) (2),(int) (2),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=524341;
 //BA.debugLineNum = 524341;BA.debugLine="Texto1 = Cell.StringCellValue";
_texto1 = _cell.getStringCellValue();
RDebugUtils.currentLine=524342;
 //BA.debugLineNum = 524342;BA.debugLine="Log(Cell.StringCellValue)";
anywheresoftware.b4a.keywords.Common.LogImpl("2524342",_cell.getStringCellValue(),0);
RDebugUtils.currentLine=524343;
 //BA.debugLineNum = 524343;BA.debugLine="Concepto.text= Texto1";
mostCurrent._concepto.setText(BA.ObjectToCharSequence(_texto1));
RDebugUtils.currentLine=524344;
 //BA.debugLineNum = 524344;BA.debugLine="Log(Concepto.text)";
anywheresoftware.b4a.keywords.Common.LogImpl("2524344",mostCurrent._concepto.getText(),0);
RDebugUtils.currentLine=524346;
 //BA.debugLineNum = 524346;BA.debugLine="row=sheet.getRow(1)";
_row = (de.donmanfred.XSSFRowwrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new de.donmanfred.XSSFRowwrapper(), (org.apache.poi.xssf.usermodel.XSSFRow)(_sheet.getRow((int) (1))));
RDebugUtils.currentLine=524347;
 //BA.debugLineNum = 524347;BA.debugLine="Cell=row.getCell(0)";
_cell = _row.getCell((int) (0));
RDebugUtils.currentLine=524348;
 //BA.debugLineNum = 524348;BA.debugLine="Texto1 = Cell.StringCellValue";
_texto1 = _cell.getStringCellValue();
RDebugUtils.currentLine=524349;
 //BA.debugLineNum = 524349;BA.debugLine="Log(Cell.StringCellValue)";
anywheresoftware.b4a.keywords.Common.LogImpl("2524349",_cell.getStringCellValue(),0);
RDebugUtils.currentLine=524350;
 //BA.debugLineNum = 524350;BA.debugLine="Concepto1.text= Texto1";
mostCurrent._concepto1.setText(BA.ObjectToCharSequence(_texto1));
RDebugUtils.currentLine=524352;
 //BA.debugLineNum = 524352;BA.debugLine="row=sheet.getRow(2)";
_row = (de.donmanfred.XSSFRowwrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new de.donmanfred.XSSFRowwrapper(), (org.apache.poi.xssf.usermodel.XSSFRow)(_sheet.getRow((int) (2))));
RDebugUtils.currentLine=524353;
 //BA.debugLineNum = 524353;BA.debugLine="Cell=row.getCell(0)";
_cell = _row.getCell((int) (0));
RDebugUtils.currentLine=524354;
 //BA.debugLineNum = 524354;BA.debugLine="Texto1 = Cell.StringCellValue";
_texto1 = _cell.getStringCellValue();
RDebugUtils.currentLine=524355;
 //BA.debugLineNum = 524355;BA.debugLine="Log(Cell.StringCellValue)";
anywheresoftware.b4a.keywords.Common.LogImpl("2524355",_cell.getStringCellValue(),0);
RDebugUtils.currentLine=524356;
 //BA.debugLineNum = 524356;BA.debugLine="Concepto2.text= Texto1";
mostCurrent._concepto2.setText(BA.ObjectToCharSequence(_texto1));
RDebugUtils.currentLine=524358;
 //BA.debugLineNum = 524358;BA.debugLine="row=sheet.getRow(3)";
_row = (de.donmanfred.XSSFRowwrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new de.donmanfred.XSSFRowwrapper(), (org.apache.poi.xssf.usermodel.XSSFRow)(_sheet.getRow((int) (3))));
RDebugUtils.currentLine=524359;
 //BA.debugLineNum = 524359;BA.debugLine="Cell=row.getCell(0)";
_cell = _row.getCell((int) (0));
RDebugUtils.currentLine=524360;
 //BA.debugLineNum = 524360;BA.debugLine="Texto1 = Cell.StringCellValue";
_texto1 = _cell.getStringCellValue();
RDebugUtils.currentLine=524361;
 //BA.debugLineNum = 524361;BA.debugLine="Log(Cell.StringCellValue)";
anywheresoftware.b4a.keywords.Common.LogImpl("2524361",_cell.getStringCellValue(),0);
RDebugUtils.currentLine=524362;
 //BA.debugLineNum = 524362;BA.debugLine="Concepto3.text= Texto1";
mostCurrent._concepto3.setText(BA.ObjectToCharSequence(_texto1));
RDebugUtils.currentLine=524364;
 //BA.debugLineNum = 524364;BA.debugLine="row=sheet.getRow(4)";
_row = (de.donmanfred.XSSFRowwrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new de.donmanfred.XSSFRowwrapper(), (org.apache.poi.xssf.usermodel.XSSFRow)(_sheet.getRow((int) (4))));
RDebugUtils.currentLine=524365;
 //BA.debugLineNum = 524365;BA.debugLine="Cell=row.getCell(0)";
_cell = _row.getCell((int) (0));
RDebugUtils.currentLine=524366;
 //BA.debugLineNum = 524366;BA.debugLine="Texto1 = Cell.StringCellValue";
_texto1 = _cell.getStringCellValue();
RDebugUtils.currentLine=524367;
 //BA.debugLineNum = 524367;BA.debugLine="Log(Cell.StringCellValue)";
anywheresoftware.b4a.keywords.Common.LogImpl("2524367",_cell.getStringCellValue(),0);
RDebugUtils.currentLine=524368;
 //BA.debugLineNum = 524368;BA.debugLine="Concepto4.text= Texto1";
mostCurrent._concepto4.setText(BA.ObjectToCharSequence(_texto1));
RDebugUtils.currentLine=524370;
 //BA.debugLineNum = 524370;BA.debugLine="row=sheet.getRow(5)";
_row = (de.donmanfred.XSSFRowwrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new de.donmanfred.XSSFRowwrapper(), (org.apache.poi.xssf.usermodel.XSSFRow)(_sheet.getRow((int) (5))));
RDebugUtils.currentLine=524371;
 //BA.debugLineNum = 524371;BA.debugLine="Cell=row.getCell(0)";
_cell = _row.getCell((int) (0));
RDebugUtils.currentLine=524372;
 //BA.debugLineNum = 524372;BA.debugLine="Texto1 = Cell.StringCellValue";
_texto1 = _cell.getStringCellValue();
RDebugUtils.currentLine=524373;
 //BA.debugLineNum = 524373;BA.debugLine="Log(Cell.StringCellValue)";
anywheresoftware.b4a.keywords.Common.LogImpl("2524373",_cell.getStringCellValue(),0);
RDebugUtils.currentLine=524374;
 //BA.debugLineNum = 524374;BA.debugLine="Concepto5.text= Texto1";
mostCurrent._concepto5.setText(BA.ObjectToCharSequence(_texto1));
RDebugUtils.currentLine=524376;
 //BA.debugLineNum = 524376;BA.debugLine="row=sheet.getRow(6)";
_row = (de.donmanfred.XSSFRowwrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new de.donmanfred.XSSFRowwrapper(), (org.apache.poi.xssf.usermodel.XSSFRow)(_sheet.getRow((int) (6))));
RDebugUtils.currentLine=524377;
 //BA.debugLineNum = 524377;BA.debugLine="Cell=row.getCell(0)";
_cell = _row.getCell((int) (0));
RDebugUtils.currentLine=524378;
 //BA.debugLineNum = 524378;BA.debugLine="Texto1 = Cell.StringCellValue";
_texto1 = _cell.getStringCellValue();
RDebugUtils.currentLine=524379;
 //BA.debugLineNum = 524379;BA.debugLine="Log(Cell.StringCellValue)";
anywheresoftware.b4a.keywords.Common.LogImpl("2524379",_cell.getStringCellValue(),0);
RDebugUtils.currentLine=524380;
 //BA.debugLineNum = 524380;BA.debugLine="Concepto6.text= Texto1";
mostCurrent._concepto6.setText(BA.ObjectToCharSequence(_texto1));
RDebugUtils.currentLine=524382;
 //BA.debugLineNum = 524382;BA.debugLine="row=sheet.getRow(7)";
_row = (de.donmanfred.XSSFRowwrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new de.donmanfred.XSSFRowwrapper(), (org.apache.poi.xssf.usermodel.XSSFRow)(_sheet.getRow((int) (7))));
RDebugUtils.currentLine=524383;
 //BA.debugLineNum = 524383;BA.debugLine="Cell=row.getCell(0)";
_cell = _row.getCell((int) (0));
RDebugUtils.currentLine=524384;
 //BA.debugLineNum = 524384;BA.debugLine="Texto1 = Cell.StringCellValue";
_texto1 = _cell.getStringCellValue();
RDebugUtils.currentLine=524385;
 //BA.debugLineNum = 524385;BA.debugLine="Log(Cell.StringCellValue)";
anywheresoftware.b4a.keywords.Common.LogImpl("2524385",_cell.getStringCellValue(),0);
RDebugUtils.currentLine=524386;
 //BA.debugLineNum = 524386;BA.debugLine="Concepto7.text= Texto1";
mostCurrent._concepto7.setText(BA.ObjectToCharSequence(_texto1));
RDebugUtils.currentLine=524388;
 //BA.debugLineNum = 524388;BA.debugLine="row=sheet.getRow(0)";
_row = (de.donmanfred.XSSFRowwrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new de.donmanfred.XSSFRowwrapper(), (org.apache.poi.xssf.usermodel.XSSFRow)(_sheet.getRow((int) (0))));
RDebugUtils.currentLine=524389;
 //BA.debugLineNum = 524389;BA.debugLine="Cell=row.getCell(2)";
_cell = _row.getCell((int) (2));
RDebugUtils.currentLine=524390;
 //BA.debugLineNum = 524390;BA.debugLine="Texto1 = Cell.StringCellValue";
_texto1 = _cell.getStringCellValue();
RDebugUtils.currentLine=524391;
 //BA.debugLineNum = 524391;BA.debugLine="Log(Cell.StringCellValue)";
anywheresoftware.b4a.keywords.Common.LogImpl("2524391",_cell.getStringCellValue(),0);
RDebugUtils.currentLine=524392;
 //BA.debugLineNum = 524392;BA.debugLine="Datos.text= Texto1";
mostCurrent._datos.setText(BA.ObjectToCharSequence(_texto1));
RDebugUtils.currentLine=524394;
 //BA.debugLineNum = 524394;BA.debugLine="row=sheet.getRow(1)";
_row = (de.donmanfred.XSSFRowwrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new de.donmanfred.XSSFRowwrapper(), (org.apache.poi.xssf.usermodel.XSSFRow)(_sheet.getRow((int) (1))));
RDebugUtils.currentLine=524395;
 //BA.debugLineNum = 524395;BA.debugLine="Cell=row.getCell(2)";
_cell = _row.getCell((int) (2));
RDebugUtils.currentLine=524396;
 //BA.debugLineNum = 524396;BA.debugLine="Texto1 = formatter.Format(Cell.NumericCellValue)";
_texto1 = _formatter._format /*String*/ (null,_cell.getNumericCellValue());
RDebugUtils.currentLine=524397;
 //BA.debugLineNum = 524397;BA.debugLine="Log(Cell.NumericCellValue)";
anywheresoftware.b4a.keywords.Common.LogImpl("2524397",BA.NumberToString(_cell.getNumericCellValue()),0);
RDebugUtils.currentLine=524398;
 //BA.debugLineNum = 524398;BA.debugLine="Datos1.text= Texto1";
mostCurrent._datos1.setText(BA.ObjectToCharSequence(_texto1));
RDebugUtils.currentLine=524400;
 //BA.debugLineNum = 524400;BA.debugLine="row=sheet.getRow(2)";
_row = (de.donmanfred.XSSFRowwrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new de.donmanfred.XSSFRowwrapper(), (org.apache.poi.xssf.usermodel.XSSFRow)(_sheet.getRow((int) (2))));
RDebugUtils.currentLine=524401;
 //BA.debugLineNum = 524401;BA.debugLine="Cell=row.getCell(2)";
_cell = _row.getCell((int) (2));
RDebugUtils.currentLine=524402;
 //BA.debugLineNum = 524402;BA.debugLine="Texto1 = formatter.Format(Cell.NumericCellValue)";
_texto1 = _formatter._format /*String*/ (null,_cell.getNumericCellValue());
RDebugUtils.currentLine=524403;
 //BA.debugLineNum = 524403;BA.debugLine="Log(formatter.Format(Cell.NumericCellValue))";
anywheresoftware.b4a.keywords.Common.LogImpl("2524403",_formatter._format /*String*/ (null,_cell.getNumericCellValue()),0);
RDebugUtils.currentLine=524404;
 //BA.debugLineNum = 524404;BA.debugLine="Datos2.text= Texto1";
mostCurrent._datos2.setText(BA.ObjectToCharSequence(_texto1));
RDebugUtils.currentLine=524406;
 //BA.debugLineNum = 524406;BA.debugLine="row=sheet.getRow(3)";
_row = (de.donmanfred.XSSFRowwrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new de.donmanfred.XSSFRowwrapper(), (org.apache.poi.xssf.usermodel.XSSFRow)(_sheet.getRow((int) (3))));
RDebugUtils.currentLine=524407;
 //BA.debugLineNum = 524407;BA.debugLine="Cell=row.getCell(2)";
_cell = _row.getCell((int) (2));
RDebugUtils.currentLine=524408;
 //BA.debugLineNum = 524408;BA.debugLine="Texto1 = formatter.Format(Cell.NumericCellValue)";
_texto1 = _formatter._format /*String*/ (null,_cell.getNumericCellValue());
RDebugUtils.currentLine=524409;
 //BA.debugLineNum = 524409;BA.debugLine="Log(formatter.Format(Cell.NumericCellValue))";
anywheresoftware.b4a.keywords.Common.LogImpl("2524409",_formatter._format /*String*/ (null,_cell.getNumericCellValue()),0);
RDebugUtils.currentLine=524410;
 //BA.debugLineNum = 524410;BA.debugLine="Datos3.text= Texto1";
mostCurrent._datos3.setText(BA.ObjectToCharSequence(_texto1));
RDebugUtils.currentLine=524412;
 //BA.debugLineNum = 524412;BA.debugLine="row=sheet.getRow(4)";
_row = (de.donmanfred.XSSFRowwrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new de.donmanfred.XSSFRowwrapper(), (org.apache.poi.xssf.usermodel.XSSFRow)(_sheet.getRow((int) (4))));
RDebugUtils.currentLine=524413;
 //BA.debugLineNum = 524413;BA.debugLine="Cell=row.getCell(2)";
_cell = _row.getCell((int) (2));
RDebugUtils.currentLine=524414;
 //BA.debugLineNum = 524414;BA.debugLine="Texto1 = formatter.Format(Cell.NumericCellValue)";
_texto1 = _formatter._format /*String*/ (null,_cell.getNumericCellValue());
RDebugUtils.currentLine=524415;
 //BA.debugLineNum = 524415;BA.debugLine="Log(formatter.Format(Cell.NumericCellValue))";
anywheresoftware.b4a.keywords.Common.LogImpl("2524415",_formatter._format /*String*/ (null,_cell.getNumericCellValue()),0);
RDebugUtils.currentLine=524416;
 //BA.debugLineNum = 524416;BA.debugLine="Datos4.text= Texto1";
mostCurrent._datos4.setText(BA.ObjectToCharSequence(_texto1));
RDebugUtils.currentLine=524418;
 //BA.debugLineNum = 524418;BA.debugLine="row=sheet.getRow(5)";
_row = (de.donmanfred.XSSFRowwrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new de.donmanfred.XSSFRowwrapper(), (org.apache.poi.xssf.usermodel.XSSFRow)(_sheet.getRow((int) (5))));
RDebugUtils.currentLine=524419;
 //BA.debugLineNum = 524419;BA.debugLine="Cell=row.getCell(2)";
_cell = _row.getCell((int) (2));
RDebugUtils.currentLine=524420;
 //BA.debugLineNum = 524420;BA.debugLine="Texto1 = formatter.Format(Cell.NumericCellValue)";
_texto1 = _formatter._format /*String*/ (null,_cell.getNumericCellValue());
RDebugUtils.currentLine=524421;
 //BA.debugLineNum = 524421;BA.debugLine="Log(formatter.Format(Cell.NumericCellValue))";
anywheresoftware.b4a.keywords.Common.LogImpl("2524421",_formatter._format /*String*/ (null,_cell.getNumericCellValue()),0);
RDebugUtils.currentLine=524422;
 //BA.debugLineNum = 524422;BA.debugLine="Datos5.text= Texto1";
mostCurrent._datos5.setText(BA.ObjectToCharSequence(_texto1));
RDebugUtils.currentLine=524424;
 //BA.debugLineNum = 524424;BA.debugLine="row=sheet.getRow(6)";
_row = (de.donmanfred.XSSFRowwrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new de.donmanfred.XSSFRowwrapper(), (org.apache.poi.xssf.usermodel.XSSFRow)(_sheet.getRow((int) (6))));
RDebugUtils.currentLine=524425;
 //BA.debugLineNum = 524425;BA.debugLine="Cell=row.getCell(2)";
_cell = _row.getCell((int) (2));
RDebugUtils.currentLine=524426;
 //BA.debugLineNum = 524426;BA.debugLine="Texto1 = formatter.Format(Cell.NumericCellValue)";
_texto1 = _formatter._format /*String*/ (null,_cell.getNumericCellValue());
RDebugUtils.currentLine=524427;
 //BA.debugLineNum = 524427;BA.debugLine="Log(formatter.Format(Cell.NumericCellValue))";
anywheresoftware.b4a.keywords.Common.LogImpl("2524427",_formatter._format /*String*/ (null,_cell.getNumericCellValue()),0);
RDebugUtils.currentLine=524428;
 //BA.debugLineNum = 524428;BA.debugLine="Datos6.text= Texto1";
mostCurrent._datos6.setText(BA.ObjectToCharSequence(_texto1));
RDebugUtils.currentLine=524430;
 //BA.debugLineNum = 524430;BA.debugLine="row=sheet.getRow(7)";
_row = (de.donmanfred.XSSFRowwrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new de.donmanfred.XSSFRowwrapper(), (org.apache.poi.xssf.usermodel.XSSFRow)(_sheet.getRow((int) (7))));
RDebugUtils.currentLine=524431;
 //BA.debugLineNum = 524431;BA.debugLine="Cell=row.getCell(2)";
_cell = _row.getCell((int) (2));
RDebugUtils.currentLine=524432;
 //BA.debugLineNum = 524432;BA.debugLine="Texto1 = formatter.Format(Cell.NumericCellValue)";
_texto1 = _formatter._format /*String*/ (null,_cell.getNumericCellValue());
RDebugUtils.currentLine=524433;
 //BA.debugLineNum = 524433;BA.debugLine="Log(formatter.Format(Cell.NumericCellValue))";
anywheresoftware.b4a.keywords.Common.LogImpl("2524433",_formatter._format /*String*/ (null,_cell.getNumericCellValue()),0);
RDebugUtils.currentLine=524434;
 //BA.debugLineNum = 524434;BA.debugLine="Datos7.text= Texto1";
mostCurrent._datos7.setText(BA.ObjectToCharSequence(_texto1));
RDebugUtils.currentLine=524436;
 //BA.debugLineNum = 524436;BA.debugLine="End Sub";
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
_sf = _fd.ShowAsync(BA.ObjectToCharSequence("Seleccionar Archivo"),"Si","Cancelar","No",mostCurrent.activityBA,(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null),anywheresoftware.b4a.keywords.Common.False);
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
anywheresoftware.b4a.keywords.Common.LogImpl("2458761","File path: "+_fd.getFilePath(),0);
RDebugUtils.currentLine=458762;
 //BA.debugLineNum = 458762;BA.debugLine="Log(\"File name: \" & fd.ChosenName)";
anywheresoftware.b4a.keywords.Common.LogImpl("2458762","File name: "+_fd.getChosenName(),0);
 if (true) break;

case 4:
//C
this.state = -1;
;
RDebugUtils.currentLine=458764;
 //BA.debugLineNum = 458764;BA.debugLine="Label1.Text = \"Ruta = \" & fd.FilePath";
parent.mostCurrent._label1.setText(BA.ObjectToCharSequence("Ruta = "+_fd.getFilePath()));
RDebugUtils.currentLine=458765;
 //BA.debugLineNum = 458765;BA.debugLine="Label2.Text = \"Archivo = \" & fd.ChosenName";
parent.mostCurrent._label2.setText(BA.ObjectToCharSequence("Archivo = "+_fd.getChosenName()));
RDebugUtils.currentLine=458766;
 //BA.debugLineNum = 458766;BA.debugLine="archivo = fd.ChosenName";
parent.mostCurrent._archivo = _fd.getChosenName();
RDebugUtils.currentLine=458768;
 //BA.debugLineNum = 458768;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
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
 //BA.debugLineNum = 327684;BA.debugLine="HiUsuario.Text= \"Hola \" & Usuario";
mostCurrent._hiusuario.setText(BA.ObjectToCharSequence("Hola "+mostCurrent._usuario));
RDebugUtils.currentLine=327687;
 //BA.debugLineNum = 327687;BA.debugLine="End Sub";
return "";
}
}