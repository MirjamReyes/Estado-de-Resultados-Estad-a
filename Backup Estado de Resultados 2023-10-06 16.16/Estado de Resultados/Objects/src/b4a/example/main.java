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
public b4a.example.starter _starter = null;
public static String  _activity_create(boolean _firsttime) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_create", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_create", new Object[] {_firsttime}));}
RDebugUtils.currentLine=131072;
 //BA.debugLineNum = 131072;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
RDebugUtils.currentLine=131075;
 //BA.debugLineNum = 131075;BA.debugLine="Activity.LoadLayout(\"Pantalla1\")";
mostCurrent._activity.LoadLayout("Pantalla1",mostCurrent.activityBA);
RDebugUtils.currentLine=131078;
 //BA.debugLineNum = 131078;BA.debugLine="End Sub";
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
int _i = 0;
de.donmanfred.XSSFRowwrapper _row = null;
int _firstcell = 0;
int _lastcell = 0;
int _o = 0;
de.donmanfred.XSSFCellwrapper _cell = null;
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
anywheresoftware.b4a.keywords.Common.LogImpl("4524292",("ActiveSheetIndex="+anywheresoftware.b4a.keywords.Common.SmartStringFormatter("",(Object)(_xls.getActiveSheetIndex()))+""),0);
RDebugUtils.currentLine=524293;
 //BA.debugLineNum = 524293;BA.debugLine="Dim sheet As XLSSheet = xls.getSheetAt(xls.Active";
_sheet = new de.donmanfred.XLSSheetwrapper();
_sheet = _xls.getSheetAt(_xls.getActiveSheetIndex());
RDebugUtils.currentLine=524294;
 //BA.debugLineNum = 524294;BA.debugLine="Log($\"ActiveSheet.ActiveCell=${sheet.ActiveCell}\"";
anywheresoftware.b4a.keywords.Common.LogImpl("4524294",("ActiveSheet.ActiveCell="+anywheresoftware.b4a.keywords.Common.SmartStringFormatter("",(Object)(_sheet.getActiveCell()))+""),0);
RDebugUtils.currentLine=524295;
 //BA.debugLineNum = 524295;BA.debugLine="Log($\"ActiveSheet.hasComments=${sheet.hasComments";
anywheresoftware.b4a.keywords.Common.LogImpl("4524295",("ActiveSheet.hasComments="+anywheresoftware.b4a.keywords.Common.SmartStringFormatter("",(Object)(_sheet.hasComments()))+""),0);
RDebugUtils.currentLine=524296;
 //BA.debugLineNum = 524296;BA.debugLine="Dim firstrow As Int = sheet.FirstRowNum";
_firstrow = _sheet.getFirstRowNum();
RDebugUtils.currentLine=524297;
 //BA.debugLineNum = 524297;BA.debugLine="Dim lastrow As Int = sheet.LastRowNum";
_lastrow = _sheet.getLastRowNum();
RDebugUtils.currentLine=524298;
 //BA.debugLineNum = 524298;BA.debugLine="Log($\"Row FirstRow=${firstrow}, LastRow=${lastrow";
anywheresoftware.b4a.keywords.Common.LogImpl("4524298",("Row FirstRow="+anywheresoftware.b4a.keywords.Common.SmartStringFormatter("",(Object)(_firstrow))+", LastRow="+anywheresoftware.b4a.keywords.Common.SmartStringFormatter("",(Object)(_lastrow))+""),0);
RDebugUtils.currentLine=524300;
 //BA.debugLineNum = 524300;BA.debugLine="For i= firstrow To lastrow";
{
final int step10 = 1;
final int limit10 = _lastrow;
_i = _firstrow ;
for (;_i <= limit10 ;_i = _i + step10 ) {
RDebugUtils.currentLine=524301;
 //BA.debugLineNum = 524301;BA.debugLine="Dim row As XSSFRow =sheet.getRow(i)";
_row = new de.donmanfred.XSSFRowwrapper();
_row = (de.donmanfred.XSSFRowwrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new de.donmanfred.XSSFRowwrapper(), (org.apache.poi.xssf.usermodel.XSSFRow)(_sheet.getRow(_i)));
RDebugUtils.currentLine=524303;
 //BA.debugLineNum = 524303;BA.debugLine="Dim firstcell As Int = row.FirstCellNum";
_firstcell = (int) (_row.getFirstCellNum());
RDebugUtils.currentLine=524304;
 //BA.debugLineNum = 524304;BA.debugLine="Dim lastcell As Int = row.LastCellNum";
_lastcell = (int) (_row.getLastCellNum());
RDebugUtils.currentLine=524305;
 //BA.debugLineNum = 524305;BA.debugLine="Log($\"Row #${i} FirstCell=${row.FirstCellNum}, L";
anywheresoftware.b4a.keywords.Common.LogImpl("4524305",("Row #"+anywheresoftware.b4a.keywords.Common.SmartStringFormatter("",(Object)(_i))+" FirstCell="+anywheresoftware.b4a.keywords.Common.SmartStringFormatter("",(Object)(_row.getFirstCellNum()))+", LastCell="+anywheresoftware.b4a.keywords.Common.SmartStringFormatter("",(Object)(_row.getLastCellNum()))+""),0);
RDebugUtils.currentLine=524310;
 //BA.debugLineNum = 524310;BA.debugLine="For o= firstcell To lastcell-1";
{
final int step15 = 1;
final int limit15 = (int) (_lastcell-1);
_o = _firstcell ;
for (;_o <= limit15 ;_o = _o + step15 ) {
RDebugUtils.currentLine=524311;
 //BA.debugLineNum = 524311;BA.debugLine="Dim Cell As XSSFCell =row.getCell(o)";
_cell = new de.donmanfred.XSSFCellwrapper();
_cell = _row.getCell(_o);
RDebugUtils.currentLine=524312;
 //BA.debugLineNum = 524312;BA.debugLine="Log($\"Cell #${o}\"$)";
anywheresoftware.b4a.keywords.Common.LogImpl("4524312",("Cell #"+anywheresoftware.b4a.keywords.Common.SmartStringFormatter("",(Object)(_o))+""),0);
RDebugUtils.currentLine=524314;
 //BA.debugLineNum = 524314;BA.debugLine="If Cell.IsInitialized Then";
if (_cell.IsInitialized()) { 
RDebugUtils.currentLine=524315;
 //BA.debugLineNum = 524315;BA.debugLine="Log($\"CellValueType=${Cell.CellType}\"$)";
anywheresoftware.b4a.keywords.Common.LogImpl("4524315",("CellValueType="+anywheresoftware.b4a.keywords.Common.SmartStringFormatter("",(Object)(_cell.getCellType()))+""),0);
RDebugUtils.currentLine=524316;
 //BA.debugLineNum = 524316;BA.debugLine="Log(\"Raw:\"&Cell.RawValue)";
anywheresoftware.b4a.keywords.Common.LogImpl("4524316","Raw:"+_cell.getRawValue(),0);
RDebugUtils.currentLine=524317;
 //BA.debugLineNum = 524317;BA.debugLine="If Cell.CellType = 1 Then";
if (_cell.getCellType()==1) { 
RDebugUtils.currentLine=524318;
 //BA.debugLineNum = 524318;BA.debugLine="Log(Cell.StringCellValue)";
anywheresoftware.b4a.keywords.Common.LogImpl("4524318",_cell.getStringCellValue(),0);
 }else 
{RDebugUtils.currentLine=524319;
 //BA.debugLineNum = 524319;BA.debugLine="else if Cell.CellType = 0 Then";
if (_cell.getCellType()==0) { 
RDebugUtils.currentLine=524320;
 //BA.debugLineNum = 524320;BA.debugLine="Log(Cell.NumericCellValue)";
anywheresoftware.b4a.keywords.Common.LogImpl("4524320",BA.NumberToString(_cell.getNumericCellValue()),0);
 }}
;
 };
 }
};
 }
};
RDebugUtils.currentLine=524329;
 //BA.debugLineNum = 524329;BA.debugLine="End Sub";
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
 //BA.debugLineNum = 458758;BA.debugLine="Dim sf As Object = fd.ShowAsync(\"Select file\", \"Y";
_sf = _fd.ShowAsync(BA.ObjectToCharSequence("Select file"),"Yes","Cancel","No",mostCurrent.activityBA,(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null),anywheresoftware.b4a.keywords.Common.False);
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
 //BA.debugLineNum = 458762;BA.debugLine="Log(\"File name: \" & fd.ChosenName)";
anywheresoftware.b4a.keywords.Common.LogImpl("4458762","File name: "+_fd.getChosenName(),0);
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