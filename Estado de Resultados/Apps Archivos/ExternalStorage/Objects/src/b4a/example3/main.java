package b4a.example3;


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
			processBA = new BA(this.getApplicationContext(), null, null, "b4a.example3", "b4a.example3.main");
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
		activityBA = new BA(this, layout, processBA, "b4a.example3", "b4a.example3.main");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "b4a.example3.main", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
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
public static b4a.example3.externalstorage _storage = null;
public static anywheresoftware.b4a.objects.collections.List _foldersstack = null;
public static b4a.example3.externalstorage._externalfile _upitem = null;
public anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper _chkusepreviouslyselected = null;
public anywheresoftware.b4a.objects.ListViewWrapper _listview1 = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _imageview1 = null;
public anywheresoftware.b4a.objects.LabelWrapper _lblpath = null;
public b4a.example3.starter _starter = null;

public static boolean isAnyActivityVisible() {
    boolean vis = false;
vis = vis | (main.mostCurrent != null);
return vis;}
public static String  _activity_create(boolean _firsttime) throws Exception{
 //BA.debugLineNum = 30;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
 //BA.debugLineNum = 31;BA.debugLine="If FirstTime Then";
if (_firsttime) { 
 //BA.debugLineNum = 32;BA.debugLine="Storage.Initialize (Me, \"Storage\")";
_storage._initialize /*String*/ (processBA,main.getObject(),"Storage");
 //BA.debugLineNum = 33;BA.debugLine="FoldersStack.Initialize";
_foldersstack.Initialize();
 //BA.debugLineNum = 34;BA.debugLine="UpItem.Initialize";
_upitem.Initialize();
 };
 //BA.debugLineNum = 36;BA.debugLine="Activity.LoadLayout(\"1\")";
mostCurrent._activity.LoadLayout("1",mostCurrent.activityBA);
 //BA.debugLineNum = 37;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
 //BA.debugLineNum = 122;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
 //BA.debugLineNum = 124;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
 //BA.debugLineNum = 118;BA.debugLine="Sub Activity_Resume";
 //BA.debugLineNum = 120;BA.debugLine="End Sub";
return "";
}
public static void  _btnpickfolder_click() throws Exception{
ResumableSub_btnPickFolder_Click rsub = new ResumableSub_btnPickFolder_Click(null);
rsub.resume(processBA, null);
}
public static class ResumableSub_btnPickFolder_Click extends BA.ResumableSub {
public ResumableSub_btnPickFolder_Click(b4a.example3.main parent) {
this.parent = parent;
}
b4a.example3.main parent;

@Override
public void resume(BA ba, Object[] result) throws Exception{

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = -1;
 //BA.debugLineNum = 41;BA.debugLine="Storage.SelectDir(chkUsePreviouslySelected.Checke";
parent._storage._selectdir /*String*/ (parent.mostCurrent._chkusepreviouslyselected.getChecked());
 //BA.debugLineNum = 42;BA.debugLine="Wait For Storage_ExternalFolderAvailable";
anywheresoftware.b4a.keywords.Common.WaitFor("storage_externalfolderavailable", processBA, this, null);
this.state = 1;
return;
case 1:
//C
this.state = -1;
;
 //BA.debugLineNum = 43;BA.debugLine="FoldersStack.Clear";
parent._foldersstack.Clear();
 //BA.debugLineNum = 44;BA.debugLine="EnterFolder(Storage.Root)";
_enterfolder(parent._storage._root /*b4a.example3.externalstorage._externalfile*/ );
 //BA.debugLineNum = 45;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public static void  _storage_externalfolderavailable() throws Exception{
}
public static String  _enterfolder(b4a.example3.externalstorage._externalfile _folder) throws Exception{
anywheresoftware.b4a.keywords.StringBuilderWrapper _sb = null;
b4a.example3.externalstorage._externalfile _f = null;
anywheresoftware.b4a.objects.CSBuilder _cs = null;
 //BA.debugLineNum = 48;BA.debugLine="Private Sub EnterFolder (folder As ExternalFile)";
 //BA.debugLineNum = 49;BA.debugLine="FoldersStack.Add(folder)";
_foldersstack.Add((Object)(_folder));
 //BA.debugLineNum = 50;BA.debugLine="Dim sb As StringBuilder";
_sb = new anywheresoftware.b4a.keywords.StringBuilderWrapper();
 //BA.debugLineNum = 51;BA.debugLine="sb.Initialize";
_sb.Initialize();
 //BA.debugLineNum = 52;BA.debugLine="For Each f As ExternalFile In FoldersStack";
{
final anywheresoftware.b4a.BA.IterableList group4 = _foldersstack;
final int groupLen4 = group4.getSize()
;int index4 = 0;
;
for (; index4 < groupLen4;index4++){
_f = (b4a.example3.externalstorage._externalfile)(group4.Get(index4));
 //BA.debugLineNum = 53;BA.debugLine="If f = Storage.Root Then";
if ((_f).equals(_storage._root /*b4a.example3.externalstorage._externalfile*/ )) { 
 //BA.debugLineNum = 54;BA.debugLine="sb.Append(\"Root\")";
_sb.Append("Root");
 }else {
 //BA.debugLineNum = 56;BA.debugLine="sb.Append(\" / \").Append(f.Name)";
_sb.Append(" / ").Append(_f.Name /*String*/ );
 };
 }
};
 //BA.debugLineNum = 59;BA.debugLine="lblPath.Text = sb.ToString";
mostCurrent._lblpath.setText(BA.ObjectToCharSequence(_sb.ToString()));
 //BA.debugLineNum = 60;BA.debugLine="ListView1.Clear";
mostCurrent._listview1.Clear();
 //BA.debugLineNum = 62;BA.debugLine="If FoldersStack.Size > 1 Then";
if (_foldersstack.getSize()>1) { 
 //BA.debugLineNum = 63;BA.debugLine="ListView1.AddSingleLine2(\"..\", UpItem)";
mostCurrent._listview1.AddSingleLine2(BA.ObjectToCharSequence(".."),(Object)(_upitem));
 };
 //BA.debugLineNum = 65;BA.debugLine="For Each f As ExternalFile In Storage.ListFiles(f";
{
final anywheresoftware.b4a.BA.IterableList group16 = _storage._listfiles /*anywheresoftware.b4a.objects.collections.List*/ (_folder);
final int groupLen16 = group16.getSize()
;int index16 = 0;
;
for (; index16 < groupLen16;index16++){
_f = (b4a.example3.externalstorage._externalfile)(group16.Get(index16));
 //BA.debugLineNum = 66;BA.debugLine="If f.IsFolder Then";
if (_f.IsFolder /*boolean*/ ) { 
 //BA.debugLineNum = 67;BA.debugLine="ListView1.AddSingleLine2($\"[${f.Name}]\"$, f)";
mostCurrent._listview1.AddSingleLine2(BA.ObjectToCharSequence(("["+anywheresoftware.b4a.keywords.Common.SmartStringFormatter("",(Object)(_f.Name /*String*/ ))+"]")),(Object)(_f));
 }else if(_isimagefile(_f.Name /*String*/ )) { 
 //BA.debugLineNum = 69;BA.debugLine="Dim cs As CSBuilder";
_cs = new anywheresoftware.b4a.objects.CSBuilder();
 //BA.debugLineNum = 70;BA.debugLine="cs.Initialize.Append(f.Name).Append(\" \").Color(";
_cs.Initialize().Append(BA.ObjectToCharSequence(_f.Name /*String*/ )).Append(BA.ObjectToCharSequence(" ")).Color(((int)0xff00eeff)).Append(BA.ObjectToCharSequence("(click)")).PopAll();
 //BA.debugLineNum = 71;BA.debugLine="ListView1.AddSingleLine2(cs, f)";
mostCurrent._listview1.AddSingleLine2(BA.ObjectToCharSequence(_cs.getObject()),(Object)(_f));
 }else {
 //BA.debugLineNum = 73;BA.debugLine="ListView1.AddSingleLine2(f.Name, f)";
mostCurrent._listview1.AddSingleLine2(BA.ObjectToCharSequence(_f.Name /*String*/ ),(Object)(_f));
 };
 }
};
 //BA.debugLineNum = 76;BA.debugLine="End Sub";
return "";
}
public static b4a.example3.externalstorage._externalfile  _getcurrentfolder() throws Exception{
 //BA.debugLineNum = 104;BA.debugLine="Private Sub GetCurrentFolder As ExternalFile";
 //BA.debugLineNum = 105;BA.debugLine="Return FoldersStack.Get(FoldersStack.Size - 1) 'g";
if (true) return (b4a.example3.externalstorage._externalfile)(_foldersstack.Get((int) (_foldersstack.getSize()-1)));
 //BA.debugLineNum = 106;BA.debugLine="End Sub";
return null;
}
public static String  _globals() throws Exception{
 //BA.debugLineNum = 23;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 24;BA.debugLine="Private chkUsePreviouslySelected As CheckBox";
mostCurrent._chkusepreviouslyselected = new anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper();
 //BA.debugLineNum = 25;BA.debugLine="Private ListView1 As ListView";
mostCurrent._listview1 = new anywheresoftware.b4a.objects.ListViewWrapper();
 //BA.debugLineNum = 26;BA.debugLine="Private ImageView1 As ImageView";
mostCurrent._imageview1 = new anywheresoftware.b4a.objects.ImageViewWrapper();
 //BA.debugLineNum = 27;BA.debugLine="Private lblPath As Label";
mostCurrent._lblpath = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 28;BA.debugLine="End Sub";
return "";
}
public static boolean  _isimagefile(String _name) throws Exception{
String _n = "";
String _extension = "";
 //BA.debugLineNum = 109;BA.debugLine="Private Sub IsImageFile (Name As String) As Boolea";
 //BA.debugLineNum = 110;BA.debugLine="Dim n As String = Name.ToLowerCase";
_n = _name.toLowerCase();
 //BA.debugLineNum = 111;BA.debugLine="For Each extension As String In Array(\".jpg\", \".p";
{
final Object[] group2 = new Object[]{(Object)(".jpg"),(Object)(".png"),(Object)(".gif"),(Object)(".bmp")};
final int groupLen2 = group2.length
;int index2 = 0;
;
for (; index2 < groupLen2;index2++){
_extension = BA.ObjectToString(group2[index2]);
 //BA.debugLineNum = 112;BA.debugLine="If n.EndsWith(extension) Then Return True";
if (_n.endsWith(_extension)) { 
if (true) return anywheresoftware.b4a.keywords.Common.True;};
 }
};
 //BA.debugLineNum = 114;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
 //BA.debugLineNum = 115;BA.debugLine="End Sub";
return false;
}
public static String  _listview1_itemclick(int _position,Object _value) throws Exception{
b4a.example3.externalstorage._externalfile _f = null;
b4a.example3.externalstorage._externalfile _folder = null;
anywheresoftware.b4a.objects.streams.File.InputStreamWrapper _in = null;
anywheresoftware.b4a.objects.streams.File.OutputStreamWrapper _out = null;
 //BA.debugLineNum = 78;BA.debugLine="Private Sub ListView1_ItemClick (Position As Int,";
 //BA.debugLineNum = 79;BA.debugLine="Dim f As ExternalFile = Value";
_f = (b4a.example3.externalstorage._externalfile)(_value);
 //BA.debugLineNum = 80;BA.debugLine="If f = UpItem Then";
if ((_f).equals(_upitem)) { 
 //BA.debugLineNum = 82;BA.debugLine="FoldersStack.RemoveAt(FoldersStack.Size - 1)";
_foldersstack.RemoveAt((int) (_foldersstack.getSize()-1));
 //BA.debugLineNum = 84;BA.debugLine="Dim folder As ExternalFile = GetCurrentFolder";
_folder = _getcurrentfolder();
 //BA.debugLineNum = 86;BA.debugLine="FoldersStack.RemoveAt(FoldersStack.Size - 1)";
_foldersstack.RemoveAt((int) (_foldersstack.getSize()-1));
 //BA.debugLineNum = 87;BA.debugLine="EnterFolder(folder)";
_enterfolder(_folder);
 }else {
 //BA.debugLineNum = 90;BA.debugLine="If f.IsFolder Then";
if (_f.IsFolder /*boolean*/ ) { 
 //BA.debugLineNum = 91;BA.debugLine="EnterFolder(f)";
_enterfolder(_f);
 }else if(_isimagefile(_f.Name /*String*/ )) { 
 //BA.debugLineNum = 93;BA.debugLine="Dim in As InputStream = Storage.OpenInputStream";
_in = new anywheresoftware.b4a.objects.streams.File.InputStreamWrapper();
_in = _storage._openinputstream /*anywheresoftware.b4a.objects.streams.File.InputStreamWrapper*/ (_f);
 //BA.debugLineNum = 96;BA.debugLine="Dim out As OutputStream = File.OpenOutput(File.";
_out = new anywheresoftware.b4a.objects.streams.File.OutputStreamWrapper();
_out = anywheresoftware.b4a.keywords.Common.File.OpenOutput(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"temp",anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 97;BA.debugLine="File.Copy2(in, out)";
anywheresoftware.b4a.keywords.Common.File.Copy2((java.io.InputStream)(_in.getObject()),(java.io.OutputStream)(_out.getObject()));
 //BA.debugLineNum = 98;BA.debugLine="out.Close";
_out.Close();
 //BA.debugLineNum = 99;BA.debugLine="ImageView1.SetBackgroundImage(LoadBitmapResize(";
mostCurrent._imageview1.SetBackgroundImageNew((android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmapResize(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"temp",mostCurrent._imageview1.getWidth(),mostCurrent._imageview1.getHeight(),anywheresoftware.b4a.keywords.Common.True).getObject()));
 };
 };
 //BA.debugLineNum = 102;BA.debugLine="End Sub";
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
 //BA.debugLineNum = 17;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 18;BA.debugLine="Private Storage As ExternalStorage";
_storage = new b4a.example3.externalstorage();
 //BA.debugLineNum = 19;BA.debugLine="Private FoldersStack As List";
_foldersstack = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 20;BA.debugLine="Private UpItem As ExternalFile";
_upitem = new b4a.example3.externalstorage._externalfile();
 //BA.debugLineNum = 21;BA.debugLine="End Sub";
return "";
}
}
