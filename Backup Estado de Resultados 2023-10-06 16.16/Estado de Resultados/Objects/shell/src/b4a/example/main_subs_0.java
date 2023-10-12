package b4a.example;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class main_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,53);
if (RapidSub.canDelegate("activity_create")) { return b4a.example.main.remoteMe.runUserSub(false, "main","activity_create", _firsttime);}
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 53;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(1048576);
 BA.debugLineNum = 56;BA.debugLine="Activity.LoadLayout(\"Pantalla1\")";
Debug.ShouldStop(8388608);
main.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("Pantalla1")),main.mostCurrent.activityBA);
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
public static RemoteObject  _activity_pause(RemoteObject _userclosed) throws Exception{
try {
		Debug.PushSubsStack("Activity_Pause (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,65);
if (RapidSub.canDelegate("activity_pause")) { return b4a.example.main.remoteMe.runUserSub(false, "main","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 65;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(1);
 BA.debugLineNum = 67;BA.debugLine="End Sub";
Debug.ShouldStop(4);
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
		Debug.PushSubsStack("Activity_Resume (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,61);
if (RapidSub.canDelegate("activity_resume")) { return b4a.example.main.remoteMe.runUserSub(false, "main","activity_resume");}
 BA.debugLineNum = 61;BA.debugLine="Sub Activity_Resume";
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
public static RemoteObject  _analisis_click() throws Exception{
try {
		Debug.PushSubsStack("Analisis_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,102);
if (RapidSub.canDelegate("analisis_click")) { return b4a.example.main.remoteMe.runUserSub(false, "main","analisis_click");}
RemoteObject _sheet = RemoteObject.declareNull("de.donmanfred.XLSSheetwrapper");
RemoteObject _firstrow = RemoteObject.createImmutable(0);
RemoteObject _lastrow = RemoteObject.createImmutable(0);
int _i = 0;
RemoteObject _row = RemoteObject.declareNull("de.donmanfred.XSSFRowwrapper");
RemoteObject _firstcell = RemoteObject.createImmutable(0);
RemoteObject _lastcell = RemoteObject.createImmutable(0);
int _o = 0;
RemoteObject _cell = RemoteObject.declareNull("de.donmanfred.XSSFCellwrapper");
 BA.debugLineNum = 102;BA.debugLine="Private Sub Analisis_Click";
Debug.ShouldStop(32);
 BA.debugLineNum = 104;BA.debugLine="File.Copy(File.DirAssets,archivo,File.DirInternal";
Debug.ShouldStop(128);
main.mostCurrent.__c.getField(false,"File").runVoidMethod ("Copy",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(main.mostCurrent._archivo),(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(main.mostCurrent._archivo));
 BA.debugLineNum = 105;BA.debugLine="xls.Initialize(\"\",File.Combine(File.DirInternal,a";
Debug.ShouldStop(256);
main._xls.runVoidMethod ("Initialize",main.processBA,(Object)(BA.ObjectToString("")),(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"Combine",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(main.mostCurrent._archivo))));
 BA.debugLineNum = 106;BA.debugLine="Log($\"ActiveSheetIndex=${xls.ActiveSheetIndex}\"$)";
Debug.ShouldStop(512);
main.mostCurrent.__c.runVoidMethod ("LogImpl","4524292",(RemoteObject.concat(RemoteObject.createImmutable("ActiveSheetIndex="),main.mostCurrent.__c.runMethod(true,"SmartStringFormatter",(Object)(BA.ObjectToString("")),(Object)((main._xls.runMethod(true,"getActiveSheetIndex")))),RemoteObject.createImmutable(""))),0);
 BA.debugLineNum = 107;BA.debugLine="Dim sheet As XLSSheet = xls.getSheetAt(xls.Active";
Debug.ShouldStop(1024);
_sheet = RemoteObject.createNew ("de.donmanfred.XLSSheetwrapper");
_sheet = main._xls.runMethod(false,"getSheetAt",(Object)(main._xls.runMethod(true,"getActiveSheetIndex")));Debug.locals.put("sheet", _sheet);Debug.locals.put("sheet", _sheet);
 BA.debugLineNum = 108;BA.debugLine="Log($\"ActiveSheet.ActiveCell=${sheet.ActiveCell}\"";
Debug.ShouldStop(2048);
main.mostCurrent.__c.runVoidMethod ("LogImpl","4524294",(RemoteObject.concat(RemoteObject.createImmutable("ActiveSheet.ActiveCell="),main.mostCurrent.__c.runMethod(true,"SmartStringFormatter",(Object)(BA.ObjectToString("")),(Object)((_sheet.runMethod(true,"getActiveCell")))),RemoteObject.createImmutable(""))),0);
 BA.debugLineNum = 109;BA.debugLine="Log($\"ActiveSheet.hasComments=${sheet.hasComments";
Debug.ShouldStop(4096);
main.mostCurrent.__c.runVoidMethod ("LogImpl","4524295",(RemoteObject.concat(RemoteObject.createImmutable("ActiveSheet.hasComments="),main.mostCurrent.__c.runMethod(true,"SmartStringFormatter",(Object)(BA.ObjectToString("")),(Object)((_sheet.runMethod(true,"hasComments")))),RemoteObject.createImmutable(""))),0);
 BA.debugLineNum = 110;BA.debugLine="Dim firstrow As Int = sheet.FirstRowNum";
Debug.ShouldStop(8192);
_firstrow = _sheet.runMethod(true,"getFirstRowNum");Debug.locals.put("firstrow", _firstrow);Debug.locals.put("firstrow", _firstrow);
 BA.debugLineNum = 111;BA.debugLine="Dim lastrow As Int = sheet.LastRowNum";
Debug.ShouldStop(16384);
_lastrow = _sheet.runMethod(true,"getLastRowNum");Debug.locals.put("lastrow", _lastrow);Debug.locals.put("lastrow", _lastrow);
 BA.debugLineNum = 112;BA.debugLine="Log($\"Row FirstRow=${firstrow}, LastRow=${lastrow";
Debug.ShouldStop(32768);
main.mostCurrent.__c.runVoidMethod ("LogImpl","4524298",(RemoteObject.concat(RemoteObject.createImmutable("Row FirstRow="),main.mostCurrent.__c.runMethod(true,"SmartStringFormatter",(Object)(BA.ObjectToString("")),(Object)((_firstrow))),RemoteObject.createImmutable(", LastRow="),main.mostCurrent.__c.runMethod(true,"SmartStringFormatter",(Object)(BA.ObjectToString("")),(Object)((_lastrow))),RemoteObject.createImmutable(""))),0);
 BA.debugLineNum = 114;BA.debugLine="For i= firstrow To lastrow";
Debug.ShouldStop(131072);
{
final int step10 = 1;
final int limit10 = _lastrow.<Integer>get().intValue();
_i = _firstrow.<Integer>get().intValue() ;
for (;(step10 > 0 && _i <= limit10) || (step10 < 0 && _i >= limit10) ;_i = ((int)(0 + _i + step10))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 115;BA.debugLine="Dim row As XSSFRow =sheet.getRow(i)";
Debug.ShouldStop(262144);
_row = RemoteObject.createNew ("de.donmanfred.XSSFRowwrapper");
_row = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("de.donmanfred.XSSFRowwrapper"), _sheet.runMethod(false,"getRow",(Object)(BA.numberCast(int.class, _i))));Debug.locals.put("row", _row);Debug.locals.put("row", _row);
 BA.debugLineNum = 117;BA.debugLine="Dim firstcell As Int = row.FirstCellNum";
Debug.ShouldStop(1048576);
_firstcell = BA.numberCast(int.class, _row.runMethod(true,"getFirstCellNum"));Debug.locals.put("firstcell", _firstcell);Debug.locals.put("firstcell", _firstcell);
 BA.debugLineNum = 118;BA.debugLine="Dim lastcell As Int = row.LastCellNum";
Debug.ShouldStop(2097152);
_lastcell = BA.numberCast(int.class, _row.runMethod(true,"getLastCellNum"));Debug.locals.put("lastcell", _lastcell);Debug.locals.put("lastcell", _lastcell);
 BA.debugLineNum = 119;BA.debugLine="Log($\"Row #${i} FirstCell=${row.FirstCellNum}, L";
Debug.ShouldStop(4194304);
main.mostCurrent.__c.runVoidMethod ("LogImpl","4524305",(RemoteObject.concat(RemoteObject.createImmutable("Row #"),main.mostCurrent.__c.runMethod(true,"SmartStringFormatter",(Object)(BA.ObjectToString("")),(Object)(RemoteObject.createImmutable((_i)))),RemoteObject.createImmutable(" FirstCell="),main.mostCurrent.__c.runMethod(true,"SmartStringFormatter",(Object)(BA.ObjectToString("")),(Object)((_row.runMethod(true,"getFirstCellNum")))),RemoteObject.createImmutable(", LastCell="),main.mostCurrent.__c.runMethod(true,"SmartStringFormatter",(Object)(BA.ObjectToString("")),(Object)((_row.runMethod(true,"getLastCellNum")))),RemoteObject.createImmutable(""))),0);
 BA.debugLineNum = 124;BA.debugLine="For o= firstcell To lastcell-1";
Debug.ShouldStop(134217728);
{
final int step15 = 1;
final int limit15 = RemoteObject.solve(new RemoteObject[] {_lastcell,RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_o = _firstcell.<Integer>get().intValue() ;
for (;(step15 > 0 && _o <= limit15) || (step15 < 0 && _o >= limit15) ;_o = ((int)(0 + _o + step15))  ) {
Debug.locals.put("o", _o);
 BA.debugLineNum = 125;BA.debugLine="Dim Cell As XSSFCell =row.getCell(o)";
Debug.ShouldStop(268435456);
_cell = RemoteObject.createNew ("de.donmanfred.XSSFCellwrapper");
_cell = _row.runMethod(false,"getCell",(Object)(BA.numberCast(int.class, _o)));Debug.locals.put("Cell", _cell);Debug.locals.put("Cell", _cell);
 BA.debugLineNum = 126;BA.debugLine="Log($\"Cell #${o}\"$)";
Debug.ShouldStop(536870912);
main.mostCurrent.__c.runVoidMethod ("LogImpl","4524312",(RemoteObject.concat(RemoteObject.createImmutable("Cell #"),main.mostCurrent.__c.runMethod(true,"SmartStringFormatter",(Object)(BA.ObjectToString("")),(Object)(RemoteObject.createImmutable((_o)))),RemoteObject.createImmutable(""))),0);
 BA.debugLineNum = 128;BA.debugLine="If Cell.IsInitialized Then";
Debug.ShouldStop(-2147483648);
if (_cell.runMethod(true,"IsInitialized").<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 129;BA.debugLine="Log($\"CellValueType=${Cell.CellType}\"$)";
Debug.ShouldStop(1);
main.mostCurrent.__c.runVoidMethod ("LogImpl","4524315",(RemoteObject.concat(RemoteObject.createImmutable("CellValueType="),main.mostCurrent.__c.runMethod(true,"SmartStringFormatter",(Object)(BA.ObjectToString("")),(Object)((_cell.runMethod(true,"getCellType")))),RemoteObject.createImmutable(""))),0);
 BA.debugLineNum = 130;BA.debugLine="Log(\"Raw:\"&Cell.RawValue)";
Debug.ShouldStop(2);
main.mostCurrent.__c.runVoidMethod ("LogImpl","4524316",RemoteObject.concat(RemoteObject.createImmutable("Raw:"),_cell.runMethod(true,"getRawValue")),0);
 BA.debugLineNum = 131;BA.debugLine="If Cell.CellType = 1 Then";
Debug.ShouldStop(4);
if (RemoteObject.solveBoolean("=",_cell.runMethod(true,"getCellType"),BA.numberCast(double.class, 1))) { 
 BA.debugLineNum = 132;BA.debugLine="Log(Cell.StringCellValue)";
Debug.ShouldStop(8);
main.mostCurrent.__c.runVoidMethod ("LogImpl","4524318",_cell.runMethod(true,"getStringCellValue"),0);
 }else 
{ BA.debugLineNum = 133;BA.debugLine="else if Cell.CellType = 0 Then";
Debug.ShouldStop(16);
if (RemoteObject.solveBoolean("=",_cell.runMethod(true,"getCellType"),BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 134;BA.debugLine="Log(Cell.NumericCellValue)";
Debug.ShouldStop(32);
main.mostCurrent.__c.runVoidMethod ("LogImpl","4524320",BA.NumberToString(_cell.runMethod(true,"getNumericCellValue")),0);
 }}
;
 };
 }
}Debug.locals.put("o", _o);
;
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 143;BA.debugLine="End Sub";
Debug.ShouldStop(16384);
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
		Debug.PushSubsStack("Boton_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,84);
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
		Debug.PushSubsStack("Boton_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,84);
Debug.locals = rsLocals;Debug.currentSubFrame.locals = rsLocals;

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
 BA.debugLineNum = 85;BA.debugLine="Dim fd As FileDialog";
Debug.ShouldStop(1048576);
_fd = RemoteObject.createNew ("anywheresoftware.b4a.agraham.dialogs.InputDialog.FileDialog");Debug.locals.put("fd", _fd);
 BA.debugLineNum = 86;BA.debugLine="fd.FastScroll = True";
Debug.ShouldStop(2097152);
_fd.runMethod(true,"setFastScroll",parent.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 87;BA.debugLine="fd.ShowOnlyFolders=False";
Debug.ShouldStop(4194304);
_fd.runMethod(true,"setShowOnlyFolders",parent.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 88;BA.debugLine="fd.TextColor=Colors.Black";
Debug.ShouldStop(8388608);
_fd.setField ("TextColor",parent.mostCurrent.__c.getField(false,"Colors").getField(true,"Black"));
 BA.debugLineNum = 89;BA.debugLine="fd.FilePath = File.DirInternal";
Debug.ShouldStop(16777216);
_fd.runMethod(true,"setFilePath",parent.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal"));
 BA.debugLineNum = 90;BA.debugLine="Dim sf As Object = fd.ShowAsync(\"Select file\", \"Y";
Debug.ShouldStop(33554432);
_sf = _fd.runMethod(false,"ShowAsync",(Object)(BA.ObjectToCharSequence("Select file")),(Object)(BA.ObjectToString("Yes")),(Object)(BA.ObjectToString("Cancel")),(Object)(BA.ObjectToString("No")),main.mostCurrent.activityBA,(Object)((parent.mostCurrent.__c.getField(false,"Null"))),(Object)(parent.mostCurrent.__c.getField(true,"False")));Debug.locals.put("sf", _sf);Debug.locals.put("sf", _sf);
 BA.debugLineNum = 91;BA.debugLine="Wait For (sf) Dialog_Result(Result As Int)";
Debug.ShouldStop(67108864);
parent.mostCurrent.__c.runVoidMethod ("WaitFor","dialog_result", main.processBA, anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this, "main", "boton_click"), _sf);
this.state = 5;
return;
case 5:
//C
this.state = 1;
_result = (RemoteObject) result.getArrayElement(true,RemoteObject.createImmutable(0));Debug.locals.put("Result", _result);
;
 BA.debugLineNum = 92;BA.debugLine="If Result = DialogResponse.POSITIVE Then";
Debug.ShouldStop(134217728);
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
 BA.debugLineNum = 93;BA.debugLine="Log(\"File path: \" & fd.FilePath)";
Debug.ShouldStop(268435456);
parent.mostCurrent.__c.runVoidMethod ("LogImpl","4458761",RemoteObject.concat(RemoteObject.createImmutable("File path: "),_fd.runMethod(true,"getFilePath")),0);
 BA.debugLineNum = 94;BA.debugLine="Log(\"File name: \" & fd.ChosenName)";
Debug.ShouldStop(536870912);
parent.mostCurrent.__c.runVoidMethod ("LogImpl","4458762",RemoteObject.concat(RemoteObject.createImmutable("File name: "),_fd.runMethod(true,"getChosenName")),0);
 if (true) break;

case 4:
//C
this.state = -1;
;
 BA.debugLineNum = 96;BA.debugLine="Label1.Text = \"Ruta = \" & fd.FilePath";
Debug.ShouldStop(-2147483648);
parent.mostCurrent._label1.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("Ruta = "),_fd.runMethod(true,"getFilePath"))));
 BA.debugLineNum = 97;BA.debugLine="Label2.Text = \"Archivo = \" & fd.ChosenName";
Debug.ShouldStop(1);
parent.mostCurrent._label2.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("Archivo = "),_fd.runMethod(true,"getChosenName"))));
 BA.debugLineNum = 98;BA.debugLine="archivo = fd.ChosenName";
Debug.ShouldStop(2);
parent.mostCurrent._archivo = _fd.runMethod(true,"getChosenName");
 BA.debugLineNum = 100;BA.debugLine="End Sub";
Debug.ShouldStop(8);
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
 //BA.debugLineNum = 28;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 30;BA.debugLine="Private INICIAR As Button";
main.mostCurrent._iniciar = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 32;BA.debugLine="Private info As Button";
main.mostCurrent._info = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 33;BA.debugLine="Dim Usuario As String";
main.mostCurrent._usuario = RemoteObject.createImmutable("");
 //BA.debugLineNum = 34;BA.debugLine="Dim archivo As String";
main.mostCurrent._archivo = RemoteObject.createImmutable("");
 //BA.debugLineNum = 35;BA.debugLine="Dim path As String";
main.mostCurrent._path = RemoteObject.createImmutable("");
 //BA.debugLineNum = 38;BA.debugLine="Private Nombre As EditText";
main.mostCurrent._nombre = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 40;BA.debugLine="Usuario = Nombre";
main.mostCurrent._usuario = BA.ObjectToString(main.mostCurrent._nombre);
 //BA.debugLineNum = 43;BA.debugLine="Private HiUsuario As Label";
main.mostCurrent._hiusuario = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 45;BA.debugLine="Private Boton As Button";
main.mostCurrent._boton = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 47;BA.debugLine="Private Label1 As Label";
main.mostCurrent._label1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 48;BA.debugLine="Private Label2 As Label";
main.mostCurrent._label2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 49;BA.debugLine="Private Analisis As Button";
main.mostCurrent._analisis = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 50;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _info_click() throws Exception{
try {
		Debug.PushSubsStack("info_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,78);
if (RapidSub.canDelegate("info_click")) { return b4a.example.main.remoteMe.runUserSub(false, "main","info_click");}
 BA.debugLineNum = 78;BA.debugLine="Private Sub info_Click";
Debug.ShouldStop(8192);
 BA.debugLineNum = 79;BA.debugLine="MsgboxAsync(\"Recuerda verificar que el archivo ele";
Debug.ShouldStop(16384);
main.mostCurrent.__c.runVoidMethod ("MsgboxAsync",(Object)(BA.ObjectToCharSequence("Recuerda verificar que el archivo elegido es el correcto")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("INFORMACIÓN"))),main.processBA);
 BA.debugLineNum = 82;BA.debugLine="End Sub";
Debug.ShouldStop(131072);
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
		Debug.PushSubsStack("INICIAR_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,69);
if (RapidSub.canDelegate("iniciar_click")) { return b4a.example.main.remoteMe.runUserSub(false, "main","iniciar_click");}
 BA.debugLineNum = 69;BA.debugLine="Private Sub INICIAR_Click";
Debug.ShouldStop(16);
 BA.debugLineNum = 70;BA.debugLine="Usuario = Nombre.Text";
Debug.ShouldStop(32);
main.mostCurrent._usuario = main.mostCurrent._nombre.runMethod(true,"getText");
 BA.debugLineNum = 71;BA.debugLine="Activity.RemoveAllViews";
Debug.ShouldStop(64);
main.mostCurrent._activity.runVoidMethod ("RemoveAllViews");
 BA.debugLineNum = 72;BA.debugLine="Activity.LoadLayout(\"Pantalla2\")";
Debug.ShouldStop(128);
main.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("Pantalla2")),main.mostCurrent.activityBA);
 BA.debugLineNum = 73;BA.debugLine="HiUsuario.Text= \"Hola \" & Usuario";
Debug.ShouldStop(256);
main.mostCurrent._hiusuario.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("Hola "),main.mostCurrent._usuario)));
 BA.debugLineNum = 76;BA.debugLine="End Sub";
Debug.ShouldStop(2048);
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
 //BA.debugLineNum = 19;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 22;BA.debugLine="Private xui As XUI";
main._xui = RemoteObject.createNew ("anywheresoftware.b4a.objects.B4XViewWrapper.XUI");
 //BA.debugLineNum = 23;BA.debugLine="Dim xls As XSSFWorkbook";
main._xls = RemoteObject.createNew ("de.donmanfred.XSSFWorkbookwrapper");
 //BA.debugLineNum = 25;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
}