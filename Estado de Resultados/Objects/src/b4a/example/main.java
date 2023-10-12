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
			processBA = new BA(this.getApplicationContext(), null, null, "b4a.example", "b4a.example.main");
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
public anywheresoftware.b4a.objects.LabelWrapper _concepto = null;
public anywheresoftware.b4a.objects.LabelWrapper _concepto1 = null;
public anywheresoftware.b4a.objects.LabelWrapper _concepto2 = null;
public anywheresoftware.b4a.objects.LabelWrapper _concepto3 = null;
public anywheresoftware.b4a.objects.LabelWrapper _concepto4 = null;
public anywheresoftware.b4a.objects.LabelWrapper _concepto5 = null;
public anywheresoftware.b4a.objects.LabelWrapper _concepto6 = null;
public anywheresoftware.b4a.objects.LabelWrapper _concepto7 = null;
public b4a.example.starter _starter = null;

public static boolean isAnyActivityVisible() {
    boolean vis = false;
vis = vis | (main.mostCurrent != null);
return vis;}
public static String  _activity_create(boolean _firsttime) throws Exception{
 //BA.debugLineNum = 61;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
 //BA.debugLineNum = 64;BA.debugLine="Activity.LoadLayout(\"Pantalla1\")";
mostCurrent._activity.LoadLayout("Pantalla1",mostCurrent.activityBA);
 //BA.debugLineNum = 67;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
 //BA.debugLineNum = 73;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
 //BA.debugLineNum = 75;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
 //BA.debugLineNum = 69;BA.debugLine="Sub Activity_Resume";
 //BA.debugLineNum = 71;BA.debugLine="End Sub";
return "";
}
public static String  _analisis_click() throws Exception{
de.donmanfred.XLSSheetwrapper _sheet = null;
int _firstrow = 0;
int _lastrow = 0;
int _i = 0;
de.donmanfred.XSSFRowwrapper _row = null;
int _firstcell = 0;
int _lastcell = 0;
int _o = 0;
de.donmanfred.XSSFCellwrapper _cell = null;
String _texto = "";
 //BA.debugLineNum = 110;BA.debugLine="Private Sub Analisis_Click";
 //BA.debugLineNum = 112;BA.debugLine="File.Copy(File.DirAssets,archivo,File.DirInternal";
anywheresoftware.b4a.keywords.Common.File.Copy(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),mostCurrent._archivo,anywheresoftware.b4a.keywords.Common.File.getDirInternal(),mostCurrent._archivo);
 //BA.debugLineNum = 113;BA.debugLine="xls.Initialize(\"\",File.Combine(File.DirInternal,a";
_xls.Initialize(processBA,"",anywheresoftware.b4a.keywords.Common.File.Combine(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),mostCurrent._archivo));
 //BA.debugLineNum = 114;BA.debugLine="Log($\"ActiveSheetIndex=${xls.ActiveSheetIndex}\"$)";
anywheresoftware.b4a.keywords.Common.LogImpl("1524292",("ActiveSheetIndex="+anywheresoftware.b4a.keywords.Common.SmartStringFormatter("",(Object)(_xls.getActiveSheetIndex()))+""),0);
 //BA.debugLineNum = 115;BA.debugLine="Dim sheet As XLSSheet = xls.getSheetAt(xls.Active";
_sheet = new de.donmanfred.XLSSheetwrapper();
_sheet = _xls.getSheetAt(_xls.getActiveSheetIndex());
 //BA.debugLineNum = 116;BA.debugLine="Log($\"ActiveSheet.ActiveCell=${sheet.ActiveCell}\"";
anywheresoftware.b4a.keywords.Common.LogImpl("1524294",("ActiveSheet.ActiveCell="+anywheresoftware.b4a.keywords.Common.SmartStringFormatter("",(Object)(_sheet.getActiveCell()))+""),0);
 //BA.debugLineNum = 117;BA.debugLine="Log($\"ActiveSheet.hasComments=${sheet.hasComments";
anywheresoftware.b4a.keywords.Common.LogImpl("1524295",("ActiveSheet.hasComments="+anywheresoftware.b4a.keywords.Common.SmartStringFormatter("",(Object)(_sheet.hasComments()))+""),0);
 //BA.debugLineNum = 118;BA.debugLine="Dim firstrow As Int = sheet.FirstRowNum";
_firstrow = _sheet.getFirstRowNum();
 //BA.debugLineNum = 119;BA.debugLine="Dim lastrow As Int = sheet.LastRowNum";
_lastrow = _sheet.getLastRowNum();
 //BA.debugLineNum = 120;BA.debugLine="Log($\"Row FirstRow=${firstrow}, LastRow=${lastrow";
anywheresoftware.b4a.keywords.Common.LogImpl("1524298",("Row FirstRow="+anywheresoftware.b4a.keywords.Common.SmartStringFormatter("",(Object)(_firstrow))+", LastRow="+anywheresoftware.b4a.keywords.Common.SmartStringFormatter("",(Object)(_lastrow))+""),0);
 //BA.debugLineNum = 122;BA.debugLine="For i= firstrow To lastrow";
{
final int step10 = 1;
final int limit10 = _lastrow;
_i = _firstrow ;
for (;_i <= limit10 ;_i = _i + step10 ) {
 //BA.debugLineNum = 123;BA.debugLine="Dim row As XSSFRow =sheet.getRow(i)";
_row = new de.donmanfred.XSSFRowwrapper();
_row = (de.donmanfred.XSSFRowwrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new de.donmanfred.XSSFRowwrapper(), (org.apache.poi.xssf.usermodel.XSSFRow)(_sheet.getRow(_i)));
 //BA.debugLineNum = 125;BA.debugLine="Dim firstcell As Int = row.FirstCellNum";
_firstcell = (int) (_row.getFirstCellNum());
 //BA.debugLineNum = 126;BA.debugLine="Dim lastcell As Int = row.LastCellNum";
_lastcell = (int) (_row.getLastCellNum());
 //BA.debugLineNum = 127;BA.debugLine="Log($\"Row #${i} FirstCell=${row.FirstCellNum}, L";
anywheresoftware.b4a.keywords.Common.LogImpl("1524305",("Row #"+anywheresoftware.b4a.keywords.Common.SmartStringFormatter("",(Object)(_i))+" FirstCell="+anywheresoftware.b4a.keywords.Common.SmartStringFormatter("",(Object)(_row.getFirstCellNum()))+", LastCell="+anywheresoftware.b4a.keywords.Common.SmartStringFormatter("",(Object)(_row.getLastCellNum()))+""),0);
 //BA.debugLineNum = 132;BA.debugLine="For o= firstcell To lastcell-1";
{
final int step15 = 1;
final int limit15 = (int) (_lastcell-1);
_o = _firstcell ;
for (;_o <= limit15 ;_o = _o + step15 ) {
 //BA.debugLineNum = 133;BA.debugLine="Dim Cell As XSSFCell =row.getCell(o)";
_cell = new de.donmanfred.XSSFCellwrapper();
_cell = _row.getCell(_o);
 //BA.debugLineNum = 134;BA.debugLine="Log($\"Cell #${o}\"$)";
anywheresoftware.b4a.keywords.Common.LogImpl("1524312",("Cell #"+anywheresoftware.b4a.keywords.Common.SmartStringFormatter("",(Object)(_o))+""),0);
 //BA.debugLineNum = 136;BA.debugLine="If Cell.IsInitialized Then";
if (_cell.IsInitialized()) { 
 //BA.debugLineNum = 137;BA.debugLine="Log($\"CellValueType=${Cell.CellType}\"$)";
anywheresoftware.b4a.keywords.Common.LogImpl("1524315",("CellValueType="+anywheresoftware.b4a.keywords.Common.SmartStringFormatter("",(Object)(_cell.getCellType()))+""),0);
 //BA.debugLineNum = 138;BA.debugLine="Log(\"Raw:\"&Cell.RawValue)";
anywheresoftware.b4a.keywords.Common.LogImpl("1524316","Raw:"+_cell.getRawValue(),0);
 //BA.debugLineNum = 139;BA.debugLine="If Cell.CellType = 1 Then";
if (_cell.getCellType()==1) { 
 //BA.debugLineNum = 140;BA.debugLine="Log(Cell.StringCellValue)";
anywheresoftware.b4a.keywords.Common.LogImpl("1524318",_cell.getStringCellValue(),0);
 }else if(_cell.getCellType()==0) { 
 //BA.debugLineNum = 142;BA.debugLine="Log(Cell.NumericCellValue)";
anywheresoftware.b4a.keywords.Common.LogImpl("1524320",BA.NumberToString(_cell.getNumericCellValue()),0);
 };
 };
 }
};
 }
};
 //BA.debugLineNum = 153;BA.debugLine="Activity.RemoveAllViews";
mostCurrent._activity.RemoveAllViews();
 //BA.debugLineNum = 154;BA.debugLine="Activity.LoadLayout(\"EstadoResultados\")";
mostCurrent._activity.LoadLayout("EstadoResultados",mostCurrent.activityBA);
 //BA.debugLineNum = 155;BA.debugLine="Dim row As XSSFRow =sheet.getRow(1)";
_row = new de.donmanfred.XSSFRowwrapper();
_row = (de.donmanfred.XSSFRowwrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new de.donmanfred.XSSFRowwrapper(), (org.apache.poi.xssf.usermodel.XSSFRow)(_sheet.getRow((int) (1))));
 //BA.debugLineNum = 156;BA.debugLine="Dim Cell As XSSFCell =row.getCell(1)";
_cell = new de.donmanfred.XSSFCellwrapper();
_cell = _row.getCell((int) (1));
 //BA.debugLineNum = 157;BA.debugLine="Cell.IsInitialized";
_cell.IsInitialized();
 //BA.debugLineNum = 158;BA.debugLine="Log(Cell.StringCellValue)";
anywheresoftware.b4a.keywords.Common.LogImpl("1524336",_cell.getStringCellValue(),0);
 //BA.debugLineNum = 159;BA.debugLine="Dim Texto As String = Cell.StringCellValue";
_texto = _cell.getStringCellValue();
 //BA.debugLineNum = 161;BA.debugLine="Concepto.text= Texto";
mostCurrent._concepto.setText(BA.ObjectToCharSequence(_texto));
 //BA.debugLineNum = 165;BA.debugLine="End Sub";
return "";
}
public static void  _boton_click() throws Exception{
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

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
 //BA.debugLineNum = 93;BA.debugLine="Dim fd As FileDialog";
_fd = new anywheresoftware.b4a.agraham.dialogs.InputDialog.FileDialog();
 //BA.debugLineNum = 94;BA.debugLine="fd.FastScroll = True";
_fd.setFastScroll(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 95;BA.debugLine="fd.ShowOnlyFolders=False";
_fd.setShowOnlyFolders(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 96;BA.debugLine="fd.TextColor=Colors.Black";
_fd.TextColor = anywheresoftware.b4a.keywords.Common.Colors.Black;
 //BA.debugLineNum = 97;BA.debugLine="fd.FilePath = File.DirInternal";
_fd.setFilePath(anywheresoftware.b4a.keywords.Common.File.getDirInternal());
 //BA.debugLineNum = 98;BA.debugLine="Dim sf As Object = fd.ShowAsync(\"Select file\", \"Y";
_sf = _fd.ShowAsync(BA.ObjectToCharSequence("Select file"),"Yes","Cancel","No",mostCurrent.activityBA,(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null),anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 99;BA.debugLine="Wait For (sf) Dialog_Result(Result As Int)";
anywheresoftware.b4a.keywords.Common.WaitFor("dialog_result", processBA, this, _sf);
this.state = 5;
return;
case 5:
//C
this.state = 1;
_result = (Integer) result[0];
;
 //BA.debugLineNum = 100;BA.debugLine="If Result = DialogResponse.POSITIVE Then";
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
 //BA.debugLineNum = 101;BA.debugLine="Log(\"File path: \" & fd.FilePath)";
anywheresoftware.b4a.keywords.Common.LogImpl("1458761","File path: "+_fd.getFilePath(),0);
 //BA.debugLineNum = 102;BA.debugLine="Log(\"File name: \" & fd.ChosenName)";
anywheresoftware.b4a.keywords.Common.LogImpl("1458762","File name: "+_fd.getChosenName(),0);
 if (true) break;

case 4:
//C
this.state = -1;
;
 //BA.debugLineNum = 104;BA.debugLine="Label1.Text = \"Ruta = \" & fd.FilePath";
parent.mostCurrent._label1.setText(BA.ObjectToCharSequence("Ruta = "+_fd.getFilePath()));
 //BA.debugLineNum = 105;BA.debugLine="Label2.Text = \"Archivo = \" & fd.ChosenName";
parent.mostCurrent._label2.setText(BA.ObjectToCharSequence("Archivo = "+_fd.getChosenName()));
 //BA.debugLineNum = 106;BA.debugLine="archivo = fd.ChosenName";
parent.mostCurrent._archivo = _fd.getChosenName();
 //BA.debugLineNum = 108;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public static void  _dialog_result(int _result) throws Exception{
}
public static String  _globals() throws Exception{
 //BA.debugLineNum = 28;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 30;BA.debugLine="Private INICIAR As Button";
mostCurrent._iniciar = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 32;BA.debugLine="Private info As Button";
mostCurrent._info = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 33;BA.debugLine="Dim Usuario As String";
mostCurrent._usuario = "";
 //BA.debugLineNum = 34;BA.debugLine="Dim archivo As String";
mostCurrent._archivo = "";
 //BA.debugLineNum = 35;BA.debugLine="Dim path As String";
mostCurrent._path = "";
 //BA.debugLineNum = 38;BA.debugLine="Private Nombre As EditText";
mostCurrent._nombre = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 40;BA.debugLine="Usuario = Nombre.Text";
mostCurrent._usuario = mostCurrent._nombre.getText();
 //BA.debugLineNum = 43;BA.debugLine="Private HiUsuario As Label";
mostCurrent._hiusuario = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 45;BA.debugLine="Private Boton As Button";
mostCurrent._boton = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 47;BA.debugLine="Private Label1 As Label";
mostCurrent._label1 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 48;BA.debugLine="Private Label2 As Label";
mostCurrent._label2 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 49;BA.debugLine="Private Analisis As Button";
mostCurrent._analisis = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 50;BA.debugLine="Private Concepto As Label";
mostCurrent._concepto = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 51;BA.debugLine="Private Concepto1 As Label";
mostCurrent._concepto1 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 52;BA.debugLine="Private Concepto2 As Label";
mostCurrent._concepto2 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 53;BA.debugLine="Private Concepto3 As Label";
mostCurrent._concepto3 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 54;BA.debugLine="Private Concepto4 As Label";
mostCurrent._concepto4 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 55;BA.debugLine="Private Concepto5 As Label";
mostCurrent._concepto5 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 56;BA.debugLine="Private Concepto6 As Label";
mostCurrent._concepto6 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 57;BA.debugLine="Private Concepto7 As Label";
mostCurrent._concepto7 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 58;BA.debugLine="End Sub";
return "";
}
public static String  _info_click() throws Exception{
 //BA.debugLineNum = 86;BA.debugLine="Private Sub info_Click";
 //BA.debugLineNum = 87;BA.debugLine="MsgboxAsync(\"Recuerda verificar que el archivo ele";
anywheresoftware.b4a.keywords.Common.MsgboxAsync(BA.ObjectToCharSequence("Recuerda verificar que el archivo elegido es el correcto"),BA.ObjectToCharSequence("INFORMACIÓN"),processBA);
 //BA.debugLineNum = 90;BA.debugLine="End Sub";
return "";
}
public static String  _iniciar_click() throws Exception{
 //BA.debugLineNum = 77;BA.debugLine="Private Sub INICIAR_Click";
 //BA.debugLineNum = 78;BA.debugLine="Usuario = Nombre.Text";
mostCurrent._usuario = mostCurrent._nombre.getText();
 //BA.debugLineNum = 79;BA.debugLine="Activity.RemoveAllViews";
mostCurrent._activity.RemoveAllViews();
 //BA.debugLineNum = 80;BA.debugLine="Activity.LoadLayout(\"Pantalla2\")";
mostCurrent._activity.LoadLayout("Pantalla2",mostCurrent.activityBA);
 //BA.debugLineNum = 81;BA.debugLine="HiUsuario.Text= \"Hola \" & Usuario";
mostCurrent._hiusuario.setText(BA.ObjectToCharSequence("Hola "+mostCurrent._usuario));
 //BA.debugLineNum = 84;BA.debugLine="End Sub";
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
 //BA.debugLineNum = 19;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 22;BA.debugLine="Private xui As XUI";
_xui = new anywheresoftware.b4a.objects.B4XViewWrapper.XUI();
 //BA.debugLineNum = 23;BA.debugLine="Dim xls As XSSFWorkbook";
_xls = new de.donmanfred.XSSFWorkbookwrapper();
 //BA.debugLineNum = 25;BA.debugLine="End Sub";
return "";
}
}
