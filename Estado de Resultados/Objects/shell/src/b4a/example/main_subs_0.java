package b4a.example;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class main_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,44);
if (RapidSub.canDelegate("activity_create")) { return b4a.example.main.remoteMe.runUserSub(false, "main","activity_create", _firsttime);}
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 44;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(2048);
 BA.debugLineNum = 47;BA.debugLine="Activity.LoadLayout(\"Pantalla1\")";
Debug.ShouldStop(16384);
main.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("Pantalla1")),main.mostCurrent.activityBA);
 BA.debugLineNum = 49;BA.debugLine="End Sub";
Debug.ShouldStop(65536);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _activity_pause(RemoteObject _userclosed) throws Exception{
try {
		Debug.PushSubsStack("Activity_Pause (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,55);
if (RapidSub.canDelegate("activity_pause")) { return b4a.example.main.remoteMe.runUserSub(false, "main","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 55;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(4194304);
 BA.debugLineNum = 57;BA.debugLine="End Sub";
Debug.ShouldStop(16777216);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _activity_resume() throws Exception{
try {
		Debug.PushSubsStack("Activity_Resume (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,51);
if (RapidSub.canDelegate("activity_resume")) { return b4a.example.main.remoteMe.runUserSub(false, "main","activity_resume");}
 BA.debugLineNum = 51;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(262144);
 BA.debugLineNum = 53;BA.debugLine="End Sub";
Debug.ShouldStop(1048576);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static void  _boton_click() throws Exception{
try {
		Debug.PushSubsStack("Boton_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,87);
if (RapidSub.canDelegate("boton_click")) { b4a.example.main.remoteMe.runUserSub(false, "main","boton_click"); return;}
ResumableSub_Boton_Click rsub = new ResumableSub_Boton_Click(null);
rsub.resume(null, null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static class ResumableSub_Boton_Click extends BA.ResumableSub {
public ResumableSub_Boton_Click(b4a.example.main parent) {
this.parent = parent;
}
java.util.LinkedHashMap<String, Object> rsLocals = new java.util.LinkedHashMap<String, Object>();
b4a.example.main parent;
RemoteObject _fd = RemoteObject.declareNull("anywheresoftware.b4a.agraham.dialogs.InputDialog.FileDialog");
RemoteObject _sf = RemoteObject.declareNull("Object");
RemoteObject _result = RemoteObject.createImmutable(0);

@Override
public void resume(BA ba, RemoteObject result) throws Exception{
try {
		Debug.PushSubsStack("Boton_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,87);
Debug.locals = rsLocals;Debug.currentSubFrame.locals = rsLocals;

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
 BA.debugLineNum = 88;BA.debugLine="Dim fd As FileDialog";
Debug.ShouldStop(8388608);
_fd = RemoteObject.createNew ("anywheresoftware.b4a.agraham.dialogs.InputDialog.FileDialog");Debug.locals.put("fd", _fd);
 BA.debugLineNum = 89;BA.debugLine="fd.FastScroll = True";
Debug.ShouldStop(16777216);
_fd.runMethod(true,"setFastScroll",parent.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 90;BA.debugLine="fd.ShowOnlyFolders=False";
Debug.ShouldStop(33554432);
_fd.runMethod(true,"setShowOnlyFolders",parent.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 91;BA.debugLine="fd.FileFilter= Colors.Cyan";
Debug.ShouldStop(67108864);
_fd.runMethod(true,"setFileFilter",BA.NumberToString(parent.mostCurrent.__c.getField(false,"Colors").getField(true,"Cyan")));
 BA.debugLineNum = 92;BA.debugLine="fd.FilePath = File.DirInternal";
Debug.ShouldStop(134217728);
_fd.runMethod(true,"setFilePath",parent.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal"));
 BA.debugLineNum = 93;BA.debugLine="Dim sf As Object = fd.ShowAsync(\"Select file\", \"Y";
Debug.ShouldStop(268435456);
_sf = _fd.runMethod(false,"ShowAsync",(Object)(BA.ObjectToCharSequence("Select file")),(Object)(BA.ObjectToString("Yes")),(Object)(BA.ObjectToString("Cancel")),(Object)(BA.ObjectToString("No")),main.mostCurrent.activityBA,(Object)((parent.mostCurrent.__c.getField(false,"Null"))),(Object)(parent.mostCurrent.__c.getField(true,"False")));Debug.locals.put("sf", _sf);Debug.locals.put("sf", _sf);
 BA.debugLineNum = 94;BA.debugLine="Wait For (sf) Dialog_Result(Result As Int)";
Debug.ShouldStop(536870912);
parent.mostCurrent.__c.runVoidMethod ("WaitFor","dialog_result", main.processBA, anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this, "main", "boton_click"), _sf);
this.state = 5;
return;
case 5:
//C
this.state = 1;
_result = (RemoteObject) result.getArrayElement(true,RemoteObject.createImmutable(0));Debug.locals.put("Result", _result);
;
 BA.debugLineNum = 95;BA.debugLine="If Result = DialogResponse.POSITIVE Then";
Debug.ShouldStop(1073741824);
if (true) break;

case 1:
//if
this.state = 4;
if (RemoteObject.solveBoolean("=",_result,BA.numberCast(double.class, parent.mostCurrent.__c.getField(false,"DialogResponse").getField(true,"POSITIVE")))) { 
this.state = 3;
}if (true) break;

case 3:
//C
this.state = 4;
 BA.debugLineNum = 96;BA.debugLine="Log(\"File path: \" & fd.FilePath)";
Debug.ShouldStop(-2147483648);
parent.mostCurrent.__c.runVoidMethod ("LogImpl","5917513",RemoteObject.concat(RemoteObject.createImmutable("File path: "),_fd.runMethod(true,"getFilePath")),0);
 BA.debugLineNum = 97;BA.debugLine="Log(\"File name: \" & fd.ChosenName)";
Debug.ShouldStop(1);
parent.mostCurrent.__c.runVoidMethod ("LogImpl","5917514",RemoteObject.concat(RemoteObject.createImmutable("File name: "),_fd.runMethod(true,"getChosenName")),0);
 if (true) break;

case 4:
//C
this.state = -1;
;
 BA.debugLineNum = 99;BA.debugLine="Label1.Text = \"Ruta = \" & fd.FilePath";
Debug.ShouldStop(4);
parent.mostCurrent._label1.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("Ruta = "),_fd.runMethod(true,"getFilePath"))));
 BA.debugLineNum = 100;BA.debugLine="Label2.Text = \"Archivo = \" & fd.ChosenName";
Debug.ShouldStop(8);
parent.mostCurrent._label2.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("Archivo = "),_fd.runMethod(true,"getChosenName"))));
 BA.debugLineNum = 101;BA.debugLine="End Sub";
Debug.ShouldStop(16);
if (true) break;

            }
        }
    }
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}
public static void  _dialog_result(RemoteObject _result) throws Exception{
}
public static RemoteObject  _globals() throws Exception{
 //BA.debugLineNum = 24;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 26;BA.debugLine="Private INICIAR As Button";
main.mostCurrent._iniciar = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 28;BA.debugLine="Private info As Button";
main.mostCurrent._info = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 29;BA.debugLine="Dim Usuario As String";
main.mostCurrent._usuario = RemoteObject.createImmutable("");
 //BA.debugLineNum = 30;BA.debugLine="Dim Label1, Label2 As Label";
main.mostCurrent._label1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
main.mostCurrent._label2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 33;BA.debugLine="Private Nombre As EditText";
main.mostCurrent._nombre = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 35;BA.debugLine="Usuario = Nombre 'Estamos guardando el texto ingr";
main.mostCurrent._usuario = BA.ObjectToString(main.mostCurrent._nombre);
 //BA.debugLineNum = 37;BA.debugLine="Private HiUsuario As Label";
main.mostCurrent._hiusuario = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 39;BA.debugLine="Private Boton As Button";
main.mostCurrent._boton = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 41;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _info_click() throws Exception{
try {
		Debug.PushSubsStack("info_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,81);
if (RapidSub.canDelegate("info_click")) { return b4a.example.main.remoteMe.runUserSub(false, "main","info_click");}
 BA.debugLineNum = 81;BA.debugLine="Private Sub info_Click";
Debug.ShouldStop(65536);
 BA.debugLineNum = 82;BA.debugLine="MsgboxAsync(\"Recuerda verificar que el archivo ele";
Debug.ShouldStop(131072);
main.mostCurrent.__c.runVoidMethod ("MsgboxAsync",(Object)(BA.ObjectToCharSequence("Recuerda verificar que el archivo elegido es el correcto")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("INFORMACIÓN"))),main.processBA);
 BA.debugLineNum = 85;BA.debugLine="End Sub";
Debug.ShouldStop(1048576);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _iniciar_click() throws Exception{
try {
		Debug.PushSubsStack("INICIAR_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,59);
if (RapidSub.canDelegate("iniciar_click")) { return b4a.example.main.remoteMe.runUserSub(false, "main","iniciar_click");}
 BA.debugLineNum = 59;BA.debugLine="Private Sub INICIAR_Click";
Debug.ShouldStop(67108864);
 BA.debugLineNum = 60;BA.debugLine="Usuario = Nombre.Text";
Debug.ShouldStop(134217728);
main.mostCurrent._usuario = main.mostCurrent._nombre.runMethod(true,"getText");
 BA.debugLineNum = 61;BA.debugLine="Activity.RemoveAllViews";
Debug.ShouldStop(268435456);
main.mostCurrent._activity.runVoidMethod ("RemoveAllViews");
 BA.debugLineNum = 62;BA.debugLine="Activity.LoadLayout(\"Pantalla2\")";
Debug.ShouldStop(536870912);
main.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("Pantalla2")),main.mostCurrent.activityBA);
 BA.debugLineNum = 63;BA.debugLine="HiUsuario.Text= \"Hola \" & Usuario";
Debug.ShouldStop(1073741824);
main.mostCurrent._hiusuario.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("Hola "),main.mostCurrent._usuario)));
 BA.debugLineNum = 65;BA.debugLine="Label1.Initialize(\"Label1\")";
Debug.ShouldStop(1);
main.mostCurrent._label1.runVoidMethod ("Initialize",main.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("Label1")));
 BA.debugLineNum = 66;BA.debugLine="Label1.TextColor = Colors.Black";
Debug.ShouldStop(2);
main.mostCurrent._label1.runMethod(true,"setTextColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"Black"));
 BA.debugLineNum = 67;BA.debugLine="Label1.Text = \"Ruta = \"";
Debug.ShouldStop(4);
main.mostCurrent._label1.runMethod(true,"setText",BA.ObjectToCharSequence("Ruta = "));
 BA.debugLineNum = 68;BA.debugLine="Activity.AddView(Label1, 100, 630, 500, 100) ' Po";
Debug.ShouldStop(8);
main.mostCurrent._activity.runVoidMethod ("AddView",(Object)((main.mostCurrent._label1.getObject())),(Object)(BA.numberCast(int.class, 100)),(Object)(BA.numberCast(int.class, 630)),(Object)(BA.numberCast(int.class, 500)),(Object)(BA.numberCast(int.class, 100)));
 BA.debugLineNum = 71;BA.debugLine="Label2.Initialize(\"Label2\")";
Debug.ShouldStop(64);
main.mostCurrent._label2.runVoidMethod ("Initialize",main.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("Label2")));
 BA.debugLineNum = 72;BA.debugLine="Label2.TextColor = Colors.Red";
Debug.ShouldStop(128);
main.mostCurrent._label2.runMethod(true,"setTextColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"Red"));
 BA.debugLineNum = 73;BA.debugLine="Label2.Text = \"Archivo = \"";
Debug.ShouldStop(256);
main.mostCurrent._label2.runMethod(true,"setText",BA.ObjectToCharSequence("Archivo = "));
 BA.debugLineNum = 74;BA.debugLine="Activity.AddView(Label2, 100, 750, 500, 150) ' Po";
Debug.ShouldStop(512);
main.mostCurrent._activity.runVoidMethod ("AddView",(Object)((main.mostCurrent._label2.getObject())),(Object)(BA.numberCast(int.class, 100)),(Object)(BA.numberCast(int.class, 750)),(Object)(BA.numberCast(int.class, 500)),(Object)(BA.numberCast(int.class, 150)));
 BA.debugLineNum = 79;BA.debugLine="End Sub";
Debug.ShouldStop(16384);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}

public static void initializeProcessGlobals() {
    
    if (main.processGlobalsRun == false) {
	    main.processGlobalsRun = true;
		try {
		        main_subs_0._process_globals();
starter_subs_0._process_globals();
main.myClass = BA.getDeviceClass ("b4a.example.main");
starter.myClass = BA.getDeviceClass ("b4a.example.starter");
		
        } catch (Exception e) {
			throw new RuntimeException(e);
		}
    }
}public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 15;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 18;BA.debugLine="Private xui As XUI";
main._xui = RemoteObject.createNew ("anywheresoftware.b4a.objects.B4XViewWrapper.XUI");
 //BA.debugLineNum = 21;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
}