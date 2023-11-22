package b4a.example3;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.debug.*;

public class externalstorage extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    private static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new BA(_ba, this, htSubs, "b4a.example3.externalstorage");
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            
        }
        if (BA.isShellModeRuntimeCheck(ba)) 
			   this.getClass().getMethod("_class_globals", b4a.example3.externalstorage.class).invoke(this, new Object[] {null});
        else
            ba.raiseEvent2(null, true, "class_globals", false);
    }

 public anywheresoftware.b4a.keywords.Common __c = null;
public Object _ion = null;
public String _persistanturi = "";
public String _previousurifilename = "";
public anywheresoftware.b4j.object.JavaObject _ctxt = null;
public Object _mcallback = null;
public String _meventname = "";
public b4a.example3.externalstorage._externalfile _root = null;
public b4a.example3.main _main = null;
public b4a.example3.starter _starter = null;
public static class _externalfile{
public boolean IsInitialized;
public String Name;
public long Length;
public long LastModified;
public boolean IsFolder;
public anywheresoftware.b4j.object.JavaObject Native;
public void Initialize() {
IsInitialized = true;
Name = "";
Length = 0L;
LastModified = 0L;
IsFolder = false;
Native = new anywheresoftware.b4j.object.JavaObject();
}
@Override
		public String toString() {
			return BA.TypeToString(this, false);
		}}
public String  _class_globals() throws Exception{
 //BA.debugLineNum = 2;BA.debugLine="Sub Class_Globals";
 //BA.debugLineNum = 3;BA.debugLine="Private ion As Object";
_ion = new Object();
 //BA.debugLineNum = 4;BA.debugLine="Private PersistantUri As String";
_persistanturi = "";
 //BA.debugLineNum = 5;BA.debugLine="Public PreviousUriFileName As String = \"Persistan";
_previousurifilename = "PersistantUri";
 //BA.debugLineNum = 6;BA.debugLine="Private ctxt As JavaObject";
_ctxt = new anywheresoftware.b4j.object.JavaObject();
 //BA.debugLineNum = 7;BA.debugLine="Private mCallback As Object";
_mcallback = new Object();
 //BA.debugLineNum = 8;BA.debugLine="Private mEventName As String";
_meventname = "";
 //BA.debugLineNum = 9;BA.debugLine="Public Root As ExternalFile";
_root = new b4a.example3.externalstorage._externalfile();
 //BA.debugLineNum = 10;BA.debugLine="Type ExternalFile (Name As String, Length As Long";
;
 //BA.debugLineNum = 11;BA.debugLine="End Sub";
return "";
}
public b4a.example3.externalstorage._externalfile  _createnewdir(b4a.example3.externalstorage._externalfile _parent,String _name) throws Exception{
 //BA.debugLineNum = 68;BA.debugLine="Public Sub CreateNewDir (Parent As ExternalFile, N";
 //BA.debugLineNum = 69;BA.debugLine="Return DocumentFileToExternalFile(Parent.Native.R";
if (true) return _documentfiletoexternalfile((anywheresoftware.b4j.object.JavaObject) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4j.object.JavaObject(), (java.lang.Object)(_parent.Native /*anywheresoftware.b4j.object.JavaObject*/ .RunMethod("createDirectory",new Object[]{(Object)(_name)}))));
 //BA.debugLineNum = 70;BA.debugLine="End Sub";
return null;
}
public b4a.example3.externalstorage._externalfile  _createnewfile(b4a.example3.externalstorage._externalfile _parent,String _name) throws Exception{
 //BA.debugLineNum = 63;BA.debugLine="Public Sub CreateNewFile (Parent As ExternalFile,";
 //BA.debugLineNum = 64;BA.debugLine="Return DocumentFileToExternalFile(Parent.Native.R";
if (true) return _documentfiletoexternalfile((anywheresoftware.b4j.object.JavaObject) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4j.object.JavaObject(), (java.lang.Object)(_parent.Native /*anywheresoftware.b4j.object.JavaObject*/ .RunMethod("createFile",new Object[]{(Object)(""),(Object)(_name)}))));
 //BA.debugLineNum = 65;BA.debugLine="End Sub";
return null;
}
public boolean  _deletefile(b4a.example3.externalstorage._externalfile _ef) throws Exception{
 //BA.debugLineNum = 73;BA.debugLine="Public Sub DeleteFile (EF As ExternalFile) As Bool";
 //BA.debugLineNum = 74;BA.debugLine="If EF.IsInitialized = False Then Return False";
if (_ef.IsInitialized /*boolean*/ ==__c.False) { 
if (true) return __c.False;};
 //BA.debugLineNum = 75;BA.debugLine="Return EF.Native.RunMethod(\"delete\", Null)";
if (true) return BA.ObjectToBoolean(_ef.Native /*anywheresoftware.b4j.object.JavaObject*/ .RunMethod("delete",(Object[])(__c.Null)));
 //BA.debugLineNum = 76;BA.debugLine="End Sub";
return false;
}
public b4a.example3.externalstorage._externalfile  _documentfiletoexternalfile(anywheresoftware.b4j.object.JavaObject _documentfile) throws Exception{
b4a.example3.externalstorage._externalfile _ef = null;
 //BA.debugLineNum = 108;BA.debugLine="Private Sub DocumentFileToExternalFile (DocumentFi";
 //BA.debugLineNum = 109;BA.debugLine="Dim ef As ExternalFile";
_ef = new b4a.example3.externalstorage._externalfile();
 //BA.debugLineNum = 110;BA.debugLine="If DocumentFile.IsInitialized = False Then";
if (_documentfile.IsInitialized()==__c.False) { 
 //BA.debugLineNum = 111;BA.debugLine="Return ef";
if (true) return _ef;
 };
 //BA.debugLineNum = 113;BA.debugLine="ef.Initialize";
_ef.Initialize();
 //BA.debugLineNum = 114;BA.debugLine="ef.Name = DocumentFile.RunMethod(\"getName\", Null)";
_ef.Name /*String*/  = BA.ObjectToString(_documentfile.RunMethod("getName",(Object[])(__c.Null)));
 //BA.debugLineNum = 115;BA.debugLine="ef.Length = DocumentFile.RunMethod(\"length\", Null";
_ef.Length /*long*/  = BA.ObjectToLongNumber(_documentfile.RunMethod("length",(Object[])(__c.Null)));
 //BA.debugLineNum = 116;BA.debugLine="ef.IsFolder = DocumentFile.RunMethod(\"isDirectory";
_ef.IsFolder /*boolean*/  = BA.ObjectToBoolean(_documentfile.RunMethod("isDirectory",(Object[])(__c.Null)));
 //BA.debugLineNum = 117;BA.debugLine="ef.Native = DocumentFile";
_ef.Native /*anywheresoftware.b4j.object.JavaObject*/  = _documentfile;
 //BA.debugLineNum = 118;BA.debugLine="ef.LastModified = DocumentFile.RunMethod(\"lastMod";
_ef.LastModified /*long*/  = BA.ObjectToLongNumber(_documentfile.RunMethod("lastModified",(Object[])(__c.Null)));
 //BA.debugLineNum = 119;BA.debugLine="Return ef";
if (true) return _ef;
 //BA.debugLineNum = 120;BA.debugLine="End Sub";
return null;
}
public b4a.example3.externalstorage._externalfile  _finddirorcreate(b4a.example3.externalstorage._externalfile _parent,String _name) throws Exception{
b4a.example3.externalstorage._externalfile _f = null;
 //BA.debugLineNum = 98;BA.debugLine="Public Sub FindDirOrCreate(Parent As ExternalFile,";
 //BA.debugLineNum = 99;BA.debugLine="Dim f As ExternalFile = FindFile(Parent, Name)";
_f = _findfile(_parent,_name);
 //BA.debugLineNum = 100;BA.debugLine="If f.IsInitialized = False Then";
if (_f.IsInitialized /*boolean*/ ==__c.False) { 
 //BA.debugLineNum = 101;BA.debugLine="Return CreateNewDir(Parent, Name)";
if (true) return _createnewdir(_parent,_name);
 }else {
 //BA.debugLineNum = 103;BA.debugLine="Return f";
if (true) return _f;
 };
 //BA.debugLineNum = 105;BA.debugLine="End Sub";
return null;
}
public b4a.example3.externalstorage._externalfile  _findfile(b4a.example3.externalstorage._externalfile _parent,String _name) throws Exception{
anywheresoftware.b4j.object.JavaObject _f = null;
 //BA.debugLineNum = 57;BA.debugLine="Public Sub FindFile (Parent As ExternalFile, Name";
 //BA.debugLineNum = 58;BA.debugLine="Dim f As JavaObject = Parent.Native.RunMethod(\"fi";
_f = new anywheresoftware.b4j.object.JavaObject();
_f = (anywheresoftware.b4j.object.JavaObject) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4j.object.JavaObject(), (java.lang.Object)(_parent.Native /*anywheresoftware.b4j.object.JavaObject*/ .RunMethod("findFile",new Object[]{(Object)(_name)})));
 //BA.debugLineNum = 59;BA.debugLine="Return DocumentFileToExternalFile(f)";
if (true) return _documentfiletoexternalfile(_f);
 //BA.debugLineNum = 60;BA.debugLine="End Sub";
return null;
}
public b4a.example3.externalstorage._externalfile  _findfileorcreate(b4a.example3.externalstorage._externalfile _parent,String _name) throws Exception{
b4a.example3.externalstorage._externalfile _f = null;
 //BA.debugLineNum = 88;BA.debugLine="Public Sub FindFileOrCreate (Parent As ExternalFil";
 //BA.debugLineNum = 89;BA.debugLine="Dim f As ExternalFile = FindFile(Parent, Name)";
_f = _findfile(_parent,_name);
 //BA.debugLineNum = 90;BA.debugLine="If f.IsInitialized = False Then";
if (_f.IsInitialized /*boolean*/ ==__c.False) { 
 //BA.debugLineNum = 91;BA.debugLine="Return CreateNewFile(Parent, Name)";
if (true) return _createnewfile(_parent,_name);
 }else {
 //BA.debugLineNum = 93;BA.debugLine="Return f";
if (true) return _f;
 };
 //BA.debugLineNum = 95;BA.debugLine="End Sub";
return null;
}
public Object  _getba() throws Exception{
anywheresoftware.b4j.object.JavaObject _jo = null;
 //BA.debugLineNum = 159;BA.debugLine="Private Sub GetBA As Object";
 //BA.debugLineNum = 160;BA.debugLine="Dim jo As JavaObject = Me";
_jo = new anywheresoftware.b4j.object.JavaObject();
_jo = (anywheresoftware.b4j.object.JavaObject) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4j.object.JavaObject(), (java.lang.Object)(this));
 //BA.debugLineNum = 161;BA.debugLine="Return jo.RunMethod(\"getBA\", Null)";
if (true) return _jo.RunMethod("getBA",(Object[])(__c.Null));
 //BA.debugLineNum = 162;BA.debugLine="End Sub";
return null;
}
public anywheresoftware.b4j.object.JavaObject  _getpickeddir(String _uri) throws Exception{
anywheresoftware.b4j.object.JavaObject _documentfilestatic = null;
anywheresoftware.b4a.objects.ContentResolverWrapper.UriWrapper _treeuri = null;
anywheresoftware.b4j.object.JavaObject _pickeddir = null;
 //BA.debugLineNum = 145;BA.debugLine="Private Sub GetPickedDir (uri As String) As JavaOb";
 //BA.debugLineNum = 146;BA.debugLine="Dim DocumentFileStatic As JavaObject";
_documentfilestatic = new anywheresoftware.b4j.object.JavaObject();
 //BA.debugLineNum = 147;BA.debugLine="Dim treeUri As Uri";
_treeuri = new anywheresoftware.b4a.objects.ContentResolverWrapper.UriWrapper();
 //BA.debugLineNum = 148;BA.debugLine="treeUri.Parse(uri)";
_treeuri.Parse(_uri);
 //BA.debugLineNum = 149;BA.debugLine="Dim PickedDir As JavaObject = DocumentFileStatic.";
_pickeddir = new anywheresoftware.b4j.object.JavaObject();
_pickeddir = (anywheresoftware.b4j.object.JavaObject) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4j.object.JavaObject(), (java.lang.Object)(_documentfilestatic.InitializeStatic("androidx.documentfile.provider.DocumentFile").RunMethod("fromTreeUri",new Object[]{(Object)(_ctxt.getObject()),(Object)(_treeuri.getObject())})));
 //BA.debugLineNum = 150;BA.debugLine="Return PickedDir";
if (true) return _pickeddir;
 //BA.debugLineNum = 151;BA.debugLine="End Sub";
return null;
}
public String  _initialize(anywheresoftware.b4a.BA _ba,Object _callback,String _eventname) throws Exception{
innerInitialize(_ba);
 //BA.debugLineNum = 13;BA.debugLine="Public Sub Initialize (Callback As Object, EventNa";
 //BA.debugLineNum = 14;BA.debugLine="mCallback = Callback";
_mcallback = _callback;
 //BA.debugLineNum = 15;BA.debugLine="mEventName = EventName";
_meventname = _eventname;
 //BA.debugLineNum = 16;BA.debugLine="ctxt.InitializeContext";
_ctxt.InitializeContext(ba);
 //BA.debugLineNum = 17;BA.debugLine="End Sub";
return "";
}
public Object  _ion_event(String _methodname,Object[] _args) throws Exception{
anywheresoftware.b4a.objects.IntentWrapper _i = null;
anywheresoftware.b4j.object.JavaObject _jo = null;
anywheresoftware.b4a.objects.ContentResolverWrapper.UriWrapper _treeuri = null;
int _takeflags = 0;
Object _temp = null;
 //BA.debugLineNum = 127;BA.debugLine="Private Sub ion_Event (MethodName As String, Args(";
 //BA.debugLineNum = 128;BA.debugLine="If -1 = Args(0) Then 'resultCode = RESULT_OK";
if (-1==(double)(BA.ObjectToNumber(_args[(int) (0)]))) { 
 //BA.debugLineNum = 129;BA.debugLine="Dim i As Intent = Args(1)";
_i = new anywheresoftware.b4a.objects.IntentWrapper();
_i = (anywheresoftware.b4a.objects.IntentWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.IntentWrapper(), (android.content.Intent)(_args[(int) (1)]));
 //BA.debugLineNum = 130;BA.debugLine="Dim jo As JavaObject = i";
_jo = new anywheresoftware.b4j.object.JavaObject();
_jo = (anywheresoftware.b4j.object.JavaObject) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4j.object.JavaObject(), (java.lang.Object)(_i.getObject()));
 //BA.debugLineNum = 131;BA.debugLine="Dim treeUri As Uri = jo.RunMethod(\"getData\", Nul";
_treeuri = new anywheresoftware.b4a.objects.ContentResolverWrapper.UriWrapper();
_treeuri = (anywheresoftware.b4a.objects.ContentResolverWrapper.UriWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ContentResolverWrapper.UriWrapper(), (android.net.Uri)(_jo.RunMethod("getData",(Object[])(__c.Null))));
 //BA.debugLineNum = 132;BA.debugLine="Dim takeFlags As Int = Bit.And(i.Flags, 3)";
_takeflags = __c.Bit.And(_i.getFlags(),(int) (3));
 //BA.debugLineNum = 133;BA.debugLine="ctxt.RunMethodJO(\"getContentResolver\", Null).Run";
_ctxt.RunMethodJO("getContentResolver",(Object[])(__c.Null)).RunMethod("takePersistableUriPermission",new Object[]{(Object)(_treeuri.getObject()),(Object)(_takeflags)});
 //BA.debugLineNum = 134;BA.debugLine="Dim temp As Object = treeUri";
_temp = (Object)(_treeuri.getObject());
 //BA.debugLineNum = 135;BA.debugLine="PersistantUri = temp";
_persistanturi = BA.ObjectToString(_temp);
 //BA.debugLineNum = 136;BA.debugLine="File.WriteString(File.DirInternal, PreviousUriFi";
__c.File.WriteString(__c.File.getDirInternal(),_previousurifilename,_persistanturi);
 //BA.debugLineNum = 137;BA.debugLine="Log(PersistantUri)";
__c.LogImpl("91966090",_persistanturi,0);
 //BA.debugLineNum = 138;BA.debugLine="SetPickedDir";
_setpickeddir();
 };
 //BA.debugLineNum = 140;BA.debugLine="Return Null";
if (true) return __c.Null;
 //BA.debugLineNum = 141;BA.debugLine="End Sub";
return null;
}
public anywheresoftware.b4a.objects.collections.List  _listfiles(b4a.example3.externalstorage._externalfile _folder) throws Exception{
Object[] _files = null;
anywheresoftware.b4a.objects.collections.List _res = null;
Object _o = null;
anywheresoftware.b4j.object.JavaObject _f = null;
 //BA.debugLineNum = 45;BA.debugLine="Public Sub ListFiles (Folder As ExternalFile) As L";
 //BA.debugLineNum = 46;BA.debugLine="Dim files() As Object = Folder.Native.RunMethod(\"";
_files = (Object[])(_folder.Native /*anywheresoftware.b4j.object.JavaObject*/ .RunMethod("listFiles",(Object[])(__c.Null)));
 //BA.debugLineNum = 47;BA.debugLine="Dim res As List";
_res = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 48;BA.debugLine="res.Initialize";
_res.Initialize();
 //BA.debugLineNum = 49;BA.debugLine="For Each o As Object In files";
{
final Object[] group4 = _files;
final int groupLen4 = group4.length
;int index4 = 0;
;
for (; index4 < groupLen4;index4++){
_o = group4[index4];
 //BA.debugLineNum = 50;BA.debugLine="Dim f As JavaObject = o";
_f = new anywheresoftware.b4j.object.JavaObject();
_f = (anywheresoftware.b4j.object.JavaObject) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4j.object.JavaObject(), (java.lang.Object)(_o));
 //BA.debugLineNum = 51;BA.debugLine="res.Add(DocumentFileToExternalFile(f))";
_res.Add((Object)(_documentfiletoexternalfile(_f)));
 }
};
 //BA.debugLineNum = 53;BA.debugLine="Return res";
if (true) return _res;
 //BA.debugLineNum = 54;BA.debugLine="End Sub";
return null;
}
public anywheresoftware.b4a.objects.streams.File.InputStreamWrapper  _openinputstream(b4a.example3.externalstorage._externalfile _ef) throws Exception{
 //BA.debugLineNum = 83;BA.debugLine="Public Sub OpenInputStream(EF As ExternalFile) As";
 //BA.debugLineNum = 84;BA.debugLine="Return ctxt.RunMethodJO(\"getContentResolver\", Nul";
if (true) return (anywheresoftware.b4a.objects.streams.File.InputStreamWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.streams.File.InputStreamWrapper(), (java.io.InputStream)(_ctxt.RunMethodJO("getContentResolver",(Object[])(__c.Null)).RunMethod("openInputStream",new Object[]{_ef.Native /*anywheresoftware.b4j.object.JavaObject*/ .RunMethod("getUri",(Object[])(__c.Null))})));
 //BA.debugLineNum = 85;BA.debugLine="End Sub";
return null;
}
public anywheresoftware.b4a.objects.streams.File.OutputStreamWrapper  _openoutputstream(b4a.example3.externalstorage._externalfile _ef) throws Exception{
 //BA.debugLineNum = 79;BA.debugLine="Public Sub OpenOutputStream(EF As ExternalFile) As";
 //BA.debugLineNum = 80;BA.debugLine="Return ctxt.RunMethodJO(\"getContentResolver\", Nul";
if (true) return (anywheresoftware.b4a.objects.streams.File.OutputStreamWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.streams.File.OutputStreamWrapper(), (java.io.OutputStream)(_ctxt.RunMethodJO("getContentResolver",(Object[])(__c.Null)).RunMethod("openOutputStream",new Object[]{_ef.Native /*anywheresoftware.b4j.object.JavaObject*/ .RunMethod("getUri",(Object[])(__c.Null))})));
 //BA.debugLineNum = 81;BA.debugLine="End Sub";
return null;
}
public String  _selectdir(boolean _usepreviouslyselectedifavailable) throws Exception{
anywheresoftware.b4a.objects.collections.List _list = null;
anywheresoftware.b4j.object.JavaObject _uripermission = null;
anywheresoftware.b4a.objects.ContentResolverWrapper.UriWrapper _u = null;
Object _temp = null;
String _s = "";
anywheresoftware.b4a.objects.IntentWrapper _i = null;
 //BA.debugLineNum = 21;BA.debugLine="Public Sub SelectDir (UsePreviouslySelectedIfAvail";
 //BA.debugLineNum = 22;BA.debugLine="If UsePreviouslySelectedIfAvailable And File.Exis";
if (_usepreviouslyselectedifavailable && __c.File.Exists(__c.File.getDirInternal(),_previousurifilename)) { 
 //BA.debugLineNum = 23;BA.debugLine="PersistantUri = File.ReadString(File.DirInternal";
_persistanturi = __c.File.ReadString(__c.File.getDirInternal(),_previousurifilename);
 //BA.debugLineNum = 24;BA.debugLine="Dim list As List = ctxt.RunMethodJO(\"getContentR";
_list = new anywheresoftware.b4a.objects.collections.List();
_list = (anywheresoftware.b4a.objects.collections.List) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.List(), (java.util.List)(_ctxt.RunMethodJO("getContentResolver",(Object[])(__c.Null)).RunMethod("getPersistedUriPermissions",(Object[])(__c.Null))));
 //BA.debugLineNum = 25;BA.debugLine="If list.IsInitialized Then";
if (_list.IsInitialized()) { 
 //BA.debugLineNum = 26;BA.debugLine="For Each uripermission As JavaObject In list";
_uripermission = new anywheresoftware.b4j.object.JavaObject();
{
final anywheresoftware.b4a.BA.IterableList group5 = _list;
final int groupLen5 = group5.getSize()
;int index5 = 0;
;
for (; index5 < groupLen5;index5++){
_uripermission = (anywheresoftware.b4j.object.JavaObject) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4j.object.JavaObject(), (java.lang.Object)(group5.Get(index5)));
 //BA.debugLineNum = 27;BA.debugLine="Dim u As Uri = uripermission.RunMethod(\"getUri";
_u = new anywheresoftware.b4a.objects.ContentResolverWrapper.UriWrapper();
_u = (anywheresoftware.b4a.objects.ContentResolverWrapper.UriWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ContentResolverWrapper.UriWrapper(), (android.net.Uri)(_uripermission.RunMethod("getUri",(Object[])(__c.Null))));
 //BA.debugLineNum = 28;BA.debugLine="Dim temp As Object = u";
_temp = (Object)(_u.getObject());
 //BA.debugLineNum = 29;BA.debugLine="Dim s As String = temp";
_s = BA.ObjectToString(_temp);
 //BA.debugLineNum = 30;BA.debugLine="If s = PersistantUri And uripermission.RunMeth";
if ((_s).equals(_persistanturi) && (_uripermission.RunMethod("isWritePermission",(Object[])(__c.Null))).equals((Object)(__c.True))) { 
 //BA.debugLineNum = 31;BA.debugLine="Log(\"Can use persistant uri!\")";
__c.LogImpl("91179658","Can use persistant uri!",0);
 //BA.debugLineNum = 32;BA.debugLine="SetPickedDir";
_setpickeddir();
 //BA.debugLineNum = 33;BA.debugLine="Return";
if (true) return "";
 };
 }
};
 };
 };
 //BA.debugLineNum = 38;BA.debugLine="Dim i As Intent";
_i = new anywheresoftware.b4a.objects.IntentWrapper();
 //BA.debugLineNum = 39;BA.debugLine="i.Initialize(\"android.intent.action.OPEN_DOCUMENT";
_i.Initialize("android.intent.action.OPEN_DOCUMENT_TREE","");
 //BA.debugLineNum = 40;BA.debugLine="i.PutExtra(\"android.content.extra.SHOW_ADVANCED\",";
_i.PutExtra("android.content.extra.SHOW_ADVANCED",(Object)(__c.True));
 //BA.debugLineNum = 41;BA.debugLine="StartActivityForResult(i)";
_startactivityforresult(_i);
 //BA.debugLineNum = 42;BA.debugLine="End Sub";
return "";
}
public String  _setpickeddir() throws Exception{
 //BA.debugLineNum = 122;BA.debugLine="Private Sub SetPickedDir";
 //BA.debugLineNum = 123;BA.debugLine="Root = DocumentFileToExternalFile(GetPickedDir(Pe";
_root = _documentfiletoexternalfile(_getpickeddir(_persistanturi));
 //BA.debugLineNum = 124;BA.debugLine="CallSubDelayed(mCallback, mEventName & \"_External";
__c.CallSubDelayed(ba,_mcallback,_meventname+"_ExternalFolderAvailable");
 //BA.debugLineNum = 125;BA.debugLine="End Sub";
return "";
}
public String  _startactivityforresult(anywheresoftware.b4a.objects.IntentWrapper _i) throws Exception{
anywheresoftware.b4j.object.JavaObject _jo = null;
 //BA.debugLineNum = 153;BA.debugLine="Private Sub StartActivityForResult(i As Intent)";
 //BA.debugLineNum = 154;BA.debugLine="Dim jo As JavaObject = GetBA";
_jo = new anywheresoftware.b4j.object.JavaObject();
_jo = (anywheresoftware.b4j.object.JavaObject) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4j.object.JavaObject(), (java.lang.Object)(_getba()));
 //BA.debugLineNum = 155;BA.debugLine="ion = jo.CreateEvent(\"anywheresoftware.b4a.IOnAct";
_ion = _jo.CreateEvent(ba,"anywheresoftware.b4a.IOnActivityResult","ion",__c.Null);
 //BA.debugLineNum = 156;BA.debugLine="jo.RunMethod(\"startActivityForResult\", Array As O";
_jo.RunMethod("startActivityForResult",new Object[]{_ion,(Object)(_i.getObject())});
 //BA.debugLineNum = 157;BA.debugLine="End Sub";
return "";
}
public Object callSub(String sub, Object sender, Object[] args) throws Exception {
BA.senderHolder.set(sender);
return BA.SubDelegator.SubNotFound;
}
}
