package b4a.example;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class main_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,49);
if (RapidSub.canDelegate("activity_create")) { return b4a.example.main.remoteMe.runUserSub(false, "main","activity_create", _firsttime);}
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 49;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(65536);
 BA.debugLineNum = 52;BA.debugLine="Activity.LoadLayout(\"Pantalla1\")";
Debug.ShouldStop(524288);
main.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("Pantalla1")),main.mostCurrent.activityBA);
 BA.debugLineNum = 55;BA.debugLine="End Sub";
Debug.ShouldStop(4194304);
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
		Debug.PushSubsStack("Activity_Pause (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,61);
if (RapidSub.canDelegate("activity_pause")) { return b4a.example.main.remoteMe.runUserSub(false, "main","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 61;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(268435456);
 BA.debugLineNum = 63;BA.debugLine="End Sub";
Debug.ShouldStop(1073741824);
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
		Debug.PushSubsStack("Activity_Resume (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,57);
if (RapidSub.canDelegate("activity_resume")) { return b4a.example.main.remoteMe.runUserSub(false, "main","activity_resume");}
 BA.debugLineNum = 57;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(16777216);
 BA.debugLineNum = 59;BA.debugLine="End Sub";
Debug.ShouldStop(67108864);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _analisis_click() throws Exception{
try {
		Debug.PushSubsStack("Analisis_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,98);
if (RapidSub.canDelegate("analisis_click")) { return b4a.example.main.remoteMe.runUserSub(false, "main","analisis_click");}
RemoteObject _sheet = RemoteObject.declareNull("de.donmanfred.XLSSheetwrapper");
RemoteObject _firstrow = RemoteObject.createImmutable(0);
RemoteObject _lastrow = RemoteObject.createImmutable(0);
 BA.debugLineNum = 98;BA.debugLine="Private Sub Analisis_Click";
Debug.ShouldStop(2);
 BA.debugLineNum = 100;BA.debugLine="File.Copy(File.DirAssets,archivo,File.DirInternal";
Debug.ShouldStop(8);
main.mostCurrent.__c.getField(false,"File").runVoidMethod ("Copy",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(main.mostCurrent._archivo),(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(main.mostCurrent._archivo));
 BA.debugLineNum = 101;BA.debugLine="xls.Initialize(\"\",File.Combine(File.DirInternal,a";
Debug.ShouldStop(16);
main._xls.runVoidMethod ("Initialize",main.processBA,(Object)(BA.ObjectToString("")),(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"Combine",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(main.mostCurrent._archivo))));
 BA.debugLineNum = 102;BA.debugLine="Log($\"ActiveSheetIndex=${xls.ActiveSheetIndex}\"$)";
Debug.ShouldStop(32);
main.mostCurrent.__c.runVoidMethod ("LogImpl","6983044",(RemoteObject.concat(RemoteObject.createImmutable("ActiveSheetIndex="),main.mostCurrent.__c.runMethod(true,"SmartStringFormatter",(Object)(BA.ObjectToString("")),(Object)((main._xls.runMethod(true,"getActiveSheetIndex")))),RemoteObject.createImmutable(""))),0);
 BA.debugLineNum = 103;BA.debugLine="Dim sheet As XLSSheet = xls.getSheetAt(xls.Active";
Debug.ShouldStop(64);
_sheet = RemoteObject.createNew ("de.donmanfred.XLSSheetwrapper");
_sheet = main._xls.runMethod(false,"getSheetAt",(Object)(main._xls.runMethod(true,"getActiveSheetIndex")));Debug.locals.put("sheet", _sheet);Debug.locals.put("sheet", _sheet);
 BA.debugLineNum = 104;BA.debugLine="Log($\"ActiveSheet.ActiveCell=${sheet.ActiveCell}\"";
Debug.ShouldStop(128);
main.mostCurrent.__c.runVoidMethod ("LogImpl","6983046",(RemoteObject.concat(RemoteObject.createImmutable("ActiveSheet.ActiveCell="),main.mostCurrent.__c.runMethod(true,"SmartStringFormatter",(Object)(BA.ObjectToString("")),(Object)((_sheet.runMethod(true,"getActiveCell")))),RemoteObject.createImmutable(""))),0);
 BA.debugLineNum = 105;BA.debugLine="Log($\"ActiveSheet.hasComments=${sheet.hasComments";
Debug.ShouldStop(256);
main.mostCurrent.__c.runVoidMethod ("LogImpl","6983047",(RemoteObject.concat(RemoteObject.createImmutable("ActiveSheet.hasComments="),main.mostCurrent.__c.runMethod(true,"SmartStringFormatter",(Object)(BA.ObjectToString("")),(Object)((_sheet.runMethod(true,"hasComments")))),RemoteObject.createImmutable(""))),0);
 BA.debugLineNum = 106;BA.debugLine="Dim firstrow As Int = sheet.FirstRowNum";
Debug.ShouldStop(512);
_firstrow = _sheet.runMethod(true,"getFirstRowNum");Debug.locals.put("firstrow", _firstrow);Debug.locals.put("firstrow", _firstrow);
 BA.debugLineNum = 107;BA.debugLine="Dim lastrow As Int = sheet.LastRowNum";
Debug.ShouldStop(1024);
_lastrow = _sheet.runMethod(true,"getLastRowNum");Debug.locals.put("lastrow", _lastrow);Debug.locals.put("lastrow", _lastrow);
 BA.debugLineNum = 108;BA.debugLine="Log($\"Row FirstRow=${firstrow}, LastRow=${lastrow";
Debug.ShouldStop(2048);
main.mostCurrent.__c.runVoidMethod ("LogImpl","6983050",(RemoteObject.concat(RemoteObject.createImmutable("Row FirstRow="),main.mostCurrent.__c.runMethod(true,"SmartStringFormatter",(Object)(BA.ObjectToString("")),(Object)((_firstrow))),RemoteObject.createImmutable(", LastRow="),main.mostCurrent.__c.runMethod(true,"SmartStringFormatter",(Object)(BA.ObjectToString("")),(Object)((_lastrow))),RemoteObject.createImmutable(""))),0);
 BA.debugLineNum = 110;BA.debugLine="End Sub";
Debug.ShouldStop(8192);
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
		Debug.PushSubsStack("Boton_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,80);
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
		Debug.PushSubsStack("Boton_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,80);
Debug.locals = rsLocals;Debug.currentSubFrame.locals = rsLocals;

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
 BA.debugLineNum = 81;BA.debugLine="Dim fd As FileDialog";
Debug.ShouldStop(65536);
_fd = RemoteObject.createNew ("anywheresoftware.b4a.agraham.dialogs.InputDialog.FileDialog");Debug.locals.put("fd", _fd);
 BA.debugLineNum = 82;BA.debugLine="fd.FastScroll = True";
Debug.ShouldStop(131072);
_fd.runMethod(true,"setFastScroll",parent.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 83;BA.debugLine="fd.ShowOnlyFolders=False";
Debug.ShouldStop(262144);
_fd.runMethod(true,"setShowOnlyFolders",parent.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 84;BA.debugLine="fd.TextColor=Colors.Black";
Debug.ShouldStop(524288);
_fd.setField ("TextColor",parent.mostCurrent.__c.getField(false,"Colors").getField(true,"Black"));
 BA.debugLineNum = 85;BA.debugLine="fd.FilePath = File.DirInternal";
Debug.ShouldStop(1048576);
_fd.runMethod(true,"setFilePath",parent.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal"));
 BA.debugLineNum = 86;BA.debugLine="Dim sf As Object = fd.ShowAsync(\"Select file\", \"Y";
Debug.ShouldStop(2097152);
_sf = _fd.runMethod(false,"ShowAsync",(Object)(BA.ObjectToCharSequence("Select file")),(Object)(BA.ObjectToString("Yes")),(Object)(BA.ObjectToString("Cancel")),(Object)(BA.ObjectToString("No")),main.mostCurrent.activityBA,(Object)((parent.mostCurrent.__c.getField(false,"Null"))),(Object)(parent.mostCurrent.__c.getField(true,"False")));Debug.locals.put("sf", _sf);Debug.locals.put("sf", _sf);
 BA.debugLineNum = 87;BA.debugLine="Wait For (sf) Dialog_Result(Result As Int)";
Debug.ShouldStop(4194304);
parent.mostCurrent.__c.runVoidMethod ("WaitFor","dialog_result", main.processBA, anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this, "main", "boton_click"), _sf);
this.state = 5;
return;
case 5:
//C
this.state = 1;
_result = (RemoteObject) result.getArrayElement(true,RemoteObject.createImmutable(0));Debug.locals.put("Result", _result);
;
 BA.debugLineNum = 88;BA.debugLine="If Result = DialogResponse.POSITIVE Then";
Debug.ShouldStop(8388608);
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
 BA.debugLineNum = 89;BA.debugLine="Log(\"File path: \" & fd.FilePath)";
Debug.ShouldStop(16777216);
parent.mostCurrent.__c.runVoidMethod ("LogImpl","6458761",RemoteObject.concat(RemoteObject.createImmutable("File path: "),_fd.runMethod(true,"getFilePath")),0);
 BA.debugLineNum = 90;BA.debugLine="Log(\"File name: \" & fd.ChosenName)";
Debug.ShouldStop(33554432);
parent.mostCurrent.__c.runVoidMethod ("LogImpl","6458762",RemoteObject.concat(RemoteObject.createImmutable("File name: "),_fd.runMethod(true,"getChosenName")),0);
 if (true) break;

case 4:
//C
this.state = -1;
;
 BA.debugLineNum = 92;BA.debugLine="Label1.Text = \"Ruta = \" & fd.FilePath";
Debug.ShouldStop(134217728);
parent.mostCurrent._label1.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("Ruta = "),_fd.runMethod(true,"getFilePath"))));
 BA.debugLineNum = 93;BA.debugLine="Label2.Text = \"Archivo = \" & fd.ChosenName";
Debug.ShouldStop(268435456);
parent.mostCurrent._label2.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("Archivo = "),_fd.runMethod(true,"getChosenName"))));
 BA.debugLineNum = 94;BA.debugLine="archivo = fd.ChosenName";
Debug.ShouldStop(536870912);
parent.mostCurrent._archivo = _fd.runMethod(true,"getChosenName");
 BA.debugLineNum = 96;BA.debugLine="End Sub";
Debug.ShouldStop(-2147483648);
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
 //BA.debugLineNum = 30;BA.debugLine="Dim archivo As String";
main.mostCurrent._archivo = RemoteObject.createImmutable("");
 //BA.debugLineNum = 31;BA.debugLine="Dim path as String";
main.mostCurrent._path = RemoteObject.createImmutable("");
 //BA.debugLineNum = 34;BA.debugLine="Private Nombre As EditText";
main.mostCurrent._nombre = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 36;BA.debugLine="Usuario = Nombre";
main.mostCurrent._usuario = BA.ObjectToString(main.mostCurrent._nombre);
 //BA.debugLineNum = 39;BA.debugLine="Private HiUsuario As Label";
main.mostCurrent._hiusuario = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 41;BA.debugLine="Private Boton As Button";
main.mostCurrent._boton = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 43;BA.debugLine="Private Label1 As Label";
main.mostCurrent._label1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 44;BA.debugLine="Private Label2 As Label";
main.mostCurrent._label2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 45;BA.debugLine="Private Analisis As Button";
main.mostCurrent._analisis = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 46;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _info_click() throws Exception{
try {
		Debug.PushSubsStack("info_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,74);
if (RapidSub.canDelegate("info_click")) { return b4a.example.main.remoteMe.runUserSub(false, "main","info_click");}
 BA.debugLineNum = 74;BA.debugLine="Private Sub info_Click";
Debug.ShouldStop(512);
 BA.debugLineNum = 75;BA.debugLine="MsgboxAsync(\"Recuerda verificar que el archivo ele";
Debug.ShouldStop(1024);
main.mostCurrent.__c.runVoidMethod ("MsgboxAsync",(Object)(BA.ObjectToCharSequence("Recuerda verificar que el archivo elegido es el correcto")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("INFORMACIÓN"))),main.processBA);
 BA.debugLineNum = 78;BA.debugLine="End Sub";
Debug.ShouldStop(8192);
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
		Debug.PushSubsStack("INICIAR_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,65);
if (RapidSub.canDelegate("iniciar_click")) { return b4a.example.main.remoteMe.runUserSub(false, "main","iniciar_click");}
 BA.debugLineNum = 65;BA.debugLine="Private Sub INICIAR_Click";
Debug.ShouldStop(1);
 BA.debugLineNum = 66;BA.debugLine="Usuario = Nombre.Text";
Debug.ShouldStop(2);
main.mostCurrent._usuario = main.mostCurrent._nombre.runMethod(true,"getText");
 BA.debugLineNum = 67;BA.debugLine="Activity.RemoveAllViews";
Debug.ShouldStop(4);
main.mostCurrent._activity.runVoidMethod ("RemoveAllViews");
 BA.debugLineNum = 68;BA.debugLine="Activity.LoadLayout(\"Pantalla2\")";
Debug.ShouldStop(8);
main.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("Pantalla2")),main.mostCurrent.activityBA);
 BA.debugLineNum = 69;BA.debugLine="HiUsuario.Text= \"Hola \" & Usuario";
Debug.ShouldStop(16);
main.mostCurrent._hiusuario.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("Hola "),main.mostCurrent._usuario)));
 BA.debugLineNum = 72;BA.debugLine="End Sub";
Debug.ShouldStop(128);
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
 //BA.debugLineNum = 19;BA.debugLine="Dim xls As XSSFWorkbook";
main._xls = RemoteObject.createNew ("de.donmanfred.XSSFWorkbookwrapper");
 //BA.debugLineNum = 21;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
}