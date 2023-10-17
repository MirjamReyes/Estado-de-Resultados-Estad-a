package b4a.example;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class main_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,71);
if (RapidSub.canDelegate("activity_create")) { return b4a.example.main.remoteMe.runUserSub(false, "main","activity_create", _firsttime);}
RemoteObject _defaultformat = RemoteObject.declareNull("b4a.example.b4xformatter._b4xformatdata");
RemoteObject _negativeformat = RemoteObject.declareNull("b4a.example.b4xformatter._b4xformatdata");
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 71;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(64);
 BA.debugLineNum = 74;BA.debugLine="Activity.LoadLayout(\"Pantalla1\")";
Debug.ShouldStop(512);
main.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("Pantalla1")),main.mostCurrent.activityBA);
 BA.debugLineNum = 76;BA.debugLine="If FirstTime Then";
Debug.ShouldStop(2048);
if (_firsttime.<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 77;BA.debugLine="formatter.Initialize";
Debug.ShouldStop(4096);
main._formatter.runClassMethod (b4a.example.b4xformatter.class, "_initialize" /*RemoteObject*/ ,main.processBA);
 BA.debugLineNum = 78;BA.debugLine="Dim DefaultFormat As B4XFormatData = formatter.G";
Debug.ShouldStop(8192);
_defaultformat = main._formatter.runClassMethod (b4a.example.b4xformatter.class, "_getdefaultformat" /*RemoteObject*/ );Debug.locals.put("DefaultFormat", _defaultformat);Debug.locals.put("DefaultFormat", _defaultformat);
 BA.debugLineNum = 79;BA.debugLine="DefaultFormat.MaximumFractions = 2";
Debug.ShouldStop(16384);
_defaultformat.setField ("MaximumFractions" /*RemoteObject*/ ,BA.numberCast(int.class, 2));
 BA.debugLineNum = 80;BA.debugLine="DefaultFormat.MinimumFractions = 2";
Debug.ShouldStop(32768);
_defaultformat.setField ("MinimumFractions" /*RemoteObject*/ ,BA.numberCast(int.class, 2));
 BA.debugLineNum = 81;BA.debugLine="DefaultFormat.Prefix = \"$ \"";
Debug.ShouldStop(65536);
_defaultformat.setField ("Prefix" /*RemoteObject*/ ,BA.ObjectToString("$ "));
 BA.debugLineNum = 82;BA.debugLine="Dim NegativeFormat As B4XFormatData = formatter.";
Debug.ShouldStop(131072);
_negativeformat = main._formatter.runClassMethod (b4a.example.b4xformatter.class, "_copyformatdata" /*RemoteObject*/ ,(Object)(_defaultformat));Debug.locals.put("NegativeFormat", _negativeformat);Debug.locals.put("NegativeFormat", _negativeformat);
 BA.debugLineNum = 83;BA.debugLine="NegativeFormat.TextColor = xui.Color_Red";
Debug.ShouldStop(262144);
_negativeformat.setField ("TextColor" /*RemoteObject*/ ,main._xui.getField(true,"Color_Red"));
 BA.debugLineNum = 84;BA.debugLine="NegativeFormat.Prefix = \"$ (\"";
Debug.ShouldStop(524288);
_negativeformat.setField ("Prefix" /*RemoteObject*/ ,BA.ObjectToString("$ ("));
 BA.debugLineNum = 85;BA.debugLine="NegativeFormat.Postfix = \")\"";
Debug.ShouldStop(1048576);
_negativeformat.setField ("Postfix" /*RemoteObject*/ ,BA.ObjectToString(")"));
 BA.debugLineNum = 86;BA.debugLine="NegativeFormat.FormatFont = xui.CreateDefaultBol";
Debug.ShouldStop(2097152);
_negativeformat.setField ("FormatFont" /*RemoteObject*/ ,main._xui.runMethod(false,"CreateDefaultBoldFont",(Object)(BA.numberCast(float.class, 15))));
 BA.debugLineNum = 87;BA.debugLine="formatter.AddFormatData(NegativeFormat, formatte";
Debug.ShouldStop(4194304);
main._formatter.runClassMethod (b4a.example.b4xformatter.class, "_addformatdata" /*RemoteObject*/ ,(Object)(_negativeformat),(Object)(BA.numberCast(double.class, main._formatter.getField(true,"_min_value" /*RemoteObject*/ ))),(Object)(BA.numberCast(double.class, 0)),(Object)(main.mostCurrent.__c.getField(true,"False")));
 };
 BA.debugLineNum = 90;BA.debugLine="End Sub";
Debug.ShouldStop(33554432);
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
		Debug.PushSubsStack("Activity_Pause (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,96);
if (RapidSub.canDelegate("activity_pause")) { return b4a.example.main.remoteMe.runUserSub(false, "main","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 96;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(-2147483648);
 BA.debugLineNum = 98;BA.debugLine="End Sub";
Debug.ShouldStop(2);
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
		Debug.PushSubsStack("Activity_Resume (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,92);
if (RapidSub.canDelegate("activity_resume")) { return b4a.example.main.remoteMe.runUserSub(false, "main","activity_resume");}
 BA.debugLineNum = 92;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(134217728);
 BA.debugLineNum = 94;BA.debugLine="End Sub";
Debug.ShouldStop(536870912);
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
		Debug.PushSubsStack("Analisis_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,133);
if (RapidSub.canDelegate("analisis_click")) { return b4a.example.main.remoteMe.runUserSub(false, "main","analisis_click");}
RemoteObject _sheet = RemoteObject.declareNull("de.donmanfred.XLSSheetwrapper");
RemoteObject _firstrow = RemoteObject.createImmutable(0);
RemoteObject _lastrow = RemoteObject.createImmutable(0);
RemoteObject _row = RemoteObject.declareNull("de.donmanfred.XSSFRowwrapper");
RemoteObject _cell = RemoteObject.declareNull("de.donmanfred.XSSFCellwrapper");
RemoteObject _texto1 = RemoteObject.createImmutable("");
 BA.debugLineNum = 133;BA.debugLine="Private Sub Analisis_Click";
Debug.ShouldStop(16);
 BA.debugLineNum = 135;BA.debugLine="File.Copy(File.DirAssets,archivo,File.DirInternal";
Debug.ShouldStop(64);
main.mostCurrent.__c.getField(false,"File").runVoidMethod ("Copy",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(main.mostCurrent._archivo),(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(main.mostCurrent._archivo));
 BA.debugLineNum = 136;BA.debugLine="xls.Initialize(\"\",File.Combine(File.DirInternal,a";
Debug.ShouldStop(128);
main._xls.runVoidMethod ("Initialize",main.processBA,(Object)(BA.ObjectToString("")),(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"Combine",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(main.mostCurrent._archivo))));
 BA.debugLineNum = 137;BA.debugLine="Log($\"ActiveSheetIndex=${xls.ActiveSheetIndex}\"$)";
Debug.ShouldStop(256);
main.mostCurrent.__c.runVoidMethod ("LogImpl","2524292",(RemoteObject.concat(RemoteObject.createImmutable("ActiveSheetIndex="),main.mostCurrent.__c.runMethod(true,"SmartStringFormatter",(Object)(BA.ObjectToString("")),(Object)((main._xls.runMethod(true,"getActiveSheetIndex")))),RemoteObject.createImmutable(""))),0);
 BA.debugLineNum = 138;BA.debugLine="Dim sheet As XLSSheet = xls.getSheetAt(xls.Active";
Debug.ShouldStop(512);
_sheet = RemoteObject.createNew ("de.donmanfred.XLSSheetwrapper");
_sheet = main._xls.runMethod(false,"getSheetAt",(Object)(main._xls.runMethod(true,"getActiveSheetIndex")));Debug.locals.put("sheet", _sheet);Debug.locals.put("sheet", _sheet);
 BA.debugLineNum = 139;BA.debugLine="Log($\"ActiveSheet.ActiveCell=${sheet.ActiveCell}\"";
Debug.ShouldStop(1024);
main.mostCurrent.__c.runVoidMethod ("LogImpl","2524294",(RemoteObject.concat(RemoteObject.createImmutable("ActiveSheet.ActiveCell="),main.mostCurrent.__c.runMethod(true,"SmartStringFormatter",(Object)(BA.ObjectToString("")),(Object)((_sheet.runMethod(true,"getActiveCell")))),RemoteObject.createImmutable(""))),0);
 BA.debugLineNum = 140;BA.debugLine="Log($\"ActiveSheet.hasComments=${sheet.hasComments";
Debug.ShouldStop(2048);
main.mostCurrent.__c.runVoidMethod ("LogImpl","2524295",(RemoteObject.concat(RemoteObject.createImmutable("ActiveSheet.hasComments="),main.mostCurrent.__c.runMethod(true,"SmartStringFormatter",(Object)(BA.ObjectToString("")),(Object)((_sheet.runMethod(true,"hasComments")))),RemoteObject.createImmutable(""))),0);
 BA.debugLineNum = 141;BA.debugLine="Dim firstrow As Int = sheet.FirstRowNum";
Debug.ShouldStop(4096);
_firstrow = _sheet.runMethod(true,"getFirstRowNum");Debug.locals.put("firstrow", _firstrow);Debug.locals.put("firstrow", _firstrow);
 BA.debugLineNum = 142;BA.debugLine="Dim lastrow As Int = sheet.LastRowNum";
Debug.ShouldStop(8192);
_lastrow = _sheet.runMethod(true,"getLastRowNum");Debug.locals.put("lastrow", _lastrow);Debug.locals.put("lastrow", _lastrow);
 BA.debugLineNum = 143;BA.debugLine="Log($\"Row FirstRow=${firstrow}, LastRow=${lastrow";
Debug.ShouldStop(16384);
main.mostCurrent.__c.runVoidMethod ("LogImpl","2524298",(RemoteObject.concat(RemoteObject.createImmutable("Row FirstRow="),main.mostCurrent.__c.runMethod(true,"SmartStringFormatter",(Object)(BA.ObjectToString("")),(Object)((_firstrow))),RemoteObject.createImmutable(", LastRow="),main.mostCurrent.__c.runMethod(true,"SmartStringFormatter",(Object)(BA.ObjectToString("")),(Object)((_lastrow))),RemoteObject.createImmutable(""))),0);
 BA.debugLineNum = 179;BA.debugLine="Activity.RemoveAllViews";
Debug.ShouldStop(262144);
main.mostCurrent._activity.runVoidMethod ("RemoveAllViews");
 BA.debugLineNum = 180;BA.debugLine="Activity.LoadLayout(\"EstadoResultados\")";
Debug.ShouldStop(524288);
main.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("EstadoResultados")),main.mostCurrent.activityBA);
 BA.debugLineNum = 181;BA.debugLine="Dim row As XSSFRow =sheet.getRow(0)";
Debug.ShouldStop(1048576);
_row = RemoteObject.createNew ("de.donmanfred.XSSFRowwrapper");
_row = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("de.donmanfred.XSSFRowwrapper"), _sheet.runMethod(false,"getRow",(Object)(BA.numberCast(int.class, 0))));Debug.locals.put("row", _row);Debug.locals.put("row", _row);
 BA.debugLineNum = 182;BA.debugLine="Dim Cell As XSSFCell =row.getCell(0)";
Debug.ShouldStop(2097152);
_cell = RemoteObject.createNew ("de.donmanfred.XSSFCellwrapper");
_cell = _row.runMethod(false,"getCell",(Object)(BA.numberCast(int.class, 0)));Debug.locals.put("Cell", _cell);Debug.locals.put("Cell", _cell);
 BA.debugLineNum = 184;BA.debugLine="Log(\"valor pelon:\"&Cell.RawValue)";
Debug.ShouldStop(8388608);
main.mostCurrent.__c.runVoidMethod ("LogImpl","2524339",RemoteObject.concat(RemoteObject.createImmutable("valor pelon:"),_cell.runMethod(true,"getRawValue")),0);
 BA.debugLineNum = 185;BA.debugLine="Dim Texto1 As String = NumberFormat2(0, 1, 2, 2,";
Debug.ShouldStop(16777216);
_texto1 = main.mostCurrent.__c.runMethod(true,"NumberFormat2",(Object)(BA.numberCast(double.class, 0)),(Object)(BA.numberCast(int.class, 1)),(Object)(BA.numberCast(int.class, 2)),(Object)(BA.numberCast(int.class, 2)),(Object)(main.mostCurrent.__c.getField(true,"False")));Debug.locals.put("Texto1", _texto1);Debug.locals.put("Texto1", _texto1);
 BA.debugLineNum = 186;BA.debugLine="Texto1 = Cell.StringCellValue";
Debug.ShouldStop(33554432);
_texto1 = _cell.runMethod(true,"getStringCellValue");Debug.locals.put("Texto1", _texto1);
 BA.debugLineNum = 187;BA.debugLine="Log(Cell.StringCellValue)";
Debug.ShouldStop(67108864);
main.mostCurrent.__c.runVoidMethod ("LogImpl","2524342",_cell.runMethod(true,"getStringCellValue"),0);
 BA.debugLineNum = 188;BA.debugLine="Concepto.text= Texto1";
Debug.ShouldStop(134217728);
main.mostCurrent._concepto.runMethod(true,"setText",BA.ObjectToCharSequence(_texto1));
 BA.debugLineNum = 189;BA.debugLine="Log(Concepto.text)";
Debug.ShouldStop(268435456);
main.mostCurrent.__c.runVoidMethod ("LogImpl","2524344",main.mostCurrent._concepto.runMethod(true,"getText"),0);
 BA.debugLineNum = 191;BA.debugLine="row=sheet.getRow(1)";
Debug.ShouldStop(1073741824);
_row = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("de.donmanfred.XSSFRowwrapper"), _sheet.runMethod(false,"getRow",(Object)(BA.numberCast(int.class, 1))));Debug.locals.put("row", _row);
 BA.debugLineNum = 192;BA.debugLine="Cell=row.getCell(0)";
Debug.ShouldStop(-2147483648);
_cell = _row.runMethod(false,"getCell",(Object)(BA.numberCast(int.class, 0)));Debug.locals.put("Cell", _cell);
 BA.debugLineNum = 193;BA.debugLine="Texto1 = Cell.StringCellValue";
Debug.ShouldStop(1);
_texto1 = _cell.runMethod(true,"getStringCellValue");Debug.locals.put("Texto1", _texto1);
 BA.debugLineNum = 194;BA.debugLine="Log(Cell.StringCellValue)";
Debug.ShouldStop(2);
main.mostCurrent.__c.runVoidMethod ("LogImpl","2524349",_cell.runMethod(true,"getStringCellValue"),0);
 BA.debugLineNum = 195;BA.debugLine="Concepto1.text= Texto1";
Debug.ShouldStop(4);
main.mostCurrent._concepto1.runMethod(true,"setText",BA.ObjectToCharSequence(_texto1));
 BA.debugLineNum = 197;BA.debugLine="row=sheet.getRow(2)";
Debug.ShouldStop(16);
_row = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("de.donmanfred.XSSFRowwrapper"), _sheet.runMethod(false,"getRow",(Object)(BA.numberCast(int.class, 2))));Debug.locals.put("row", _row);
 BA.debugLineNum = 198;BA.debugLine="Cell=row.getCell(0)";
Debug.ShouldStop(32);
_cell = _row.runMethod(false,"getCell",(Object)(BA.numberCast(int.class, 0)));Debug.locals.put("Cell", _cell);
 BA.debugLineNum = 199;BA.debugLine="Texto1 = Cell.StringCellValue";
Debug.ShouldStop(64);
_texto1 = _cell.runMethod(true,"getStringCellValue");Debug.locals.put("Texto1", _texto1);
 BA.debugLineNum = 200;BA.debugLine="Log(Cell.StringCellValue)";
Debug.ShouldStop(128);
main.mostCurrent.__c.runVoidMethod ("LogImpl","2524355",_cell.runMethod(true,"getStringCellValue"),0);
 BA.debugLineNum = 201;BA.debugLine="Concepto2.text= Texto1";
Debug.ShouldStop(256);
main.mostCurrent._concepto2.runMethod(true,"setText",BA.ObjectToCharSequence(_texto1));
 BA.debugLineNum = 203;BA.debugLine="row=sheet.getRow(3)";
Debug.ShouldStop(1024);
_row = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("de.donmanfred.XSSFRowwrapper"), _sheet.runMethod(false,"getRow",(Object)(BA.numberCast(int.class, 3))));Debug.locals.put("row", _row);
 BA.debugLineNum = 204;BA.debugLine="Cell=row.getCell(0)";
Debug.ShouldStop(2048);
_cell = _row.runMethod(false,"getCell",(Object)(BA.numberCast(int.class, 0)));Debug.locals.put("Cell", _cell);
 BA.debugLineNum = 205;BA.debugLine="Texto1 = Cell.StringCellValue";
Debug.ShouldStop(4096);
_texto1 = _cell.runMethod(true,"getStringCellValue");Debug.locals.put("Texto1", _texto1);
 BA.debugLineNum = 206;BA.debugLine="Log(Cell.StringCellValue)";
Debug.ShouldStop(8192);
main.mostCurrent.__c.runVoidMethod ("LogImpl","2524361",_cell.runMethod(true,"getStringCellValue"),0);
 BA.debugLineNum = 207;BA.debugLine="Concepto3.text= Texto1";
Debug.ShouldStop(16384);
main.mostCurrent._concepto3.runMethod(true,"setText",BA.ObjectToCharSequence(_texto1));
 BA.debugLineNum = 209;BA.debugLine="row=sheet.getRow(4)";
Debug.ShouldStop(65536);
_row = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("de.donmanfred.XSSFRowwrapper"), _sheet.runMethod(false,"getRow",(Object)(BA.numberCast(int.class, 4))));Debug.locals.put("row", _row);
 BA.debugLineNum = 210;BA.debugLine="Cell=row.getCell(0)";
Debug.ShouldStop(131072);
_cell = _row.runMethod(false,"getCell",(Object)(BA.numberCast(int.class, 0)));Debug.locals.put("Cell", _cell);
 BA.debugLineNum = 211;BA.debugLine="Texto1 = Cell.StringCellValue";
Debug.ShouldStop(262144);
_texto1 = _cell.runMethod(true,"getStringCellValue");Debug.locals.put("Texto1", _texto1);
 BA.debugLineNum = 212;BA.debugLine="Log(Cell.StringCellValue)";
Debug.ShouldStop(524288);
main.mostCurrent.__c.runVoidMethod ("LogImpl","2524367",_cell.runMethod(true,"getStringCellValue"),0);
 BA.debugLineNum = 213;BA.debugLine="Concepto4.text= Texto1";
Debug.ShouldStop(1048576);
main.mostCurrent._concepto4.runMethod(true,"setText",BA.ObjectToCharSequence(_texto1));
 BA.debugLineNum = 215;BA.debugLine="row=sheet.getRow(5)";
Debug.ShouldStop(4194304);
_row = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("de.donmanfred.XSSFRowwrapper"), _sheet.runMethod(false,"getRow",(Object)(BA.numberCast(int.class, 5))));Debug.locals.put("row", _row);
 BA.debugLineNum = 216;BA.debugLine="Cell=row.getCell(0)";
Debug.ShouldStop(8388608);
_cell = _row.runMethod(false,"getCell",(Object)(BA.numberCast(int.class, 0)));Debug.locals.put("Cell", _cell);
 BA.debugLineNum = 217;BA.debugLine="Texto1 = Cell.StringCellValue";
Debug.ShouldStop(16777216);
_texto1 = _cell.runMethod(true,"getStringCellValue");Debug.locals.put("Texto1", _texto1);
 BA.debugLineNum = 218;BA.debugLine="Log(Cell.StringCellValue)";
Debug.ShouldStop(33554432);
main.mostCurrent.__c.runVoidMethod ("LogImpl","2524373",_cell.runMethod(true,"getStringCellValue"),0);
 BA.debugLineNum = 219;BA.debugLine="Concepto5.text= Texto1";
Debug.ShouldStop(67108864);
main.mostCurrent._concepto5.runMethod(true,"setText",BA.ObjectToCharSequence(_texto1));
 BA.debugLineNum = 221;BA.debugLine="row=sheet.getRow(6)";
Debug.ShouldStop(268435456);
_row = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("de.donmanfred.XSSFRowwrapper"), _sheet.runMethod(false,"getRow",(Object)(BA.numberCast(int.class, 6))));Debug.locals.put("row", _row);
 BA.debugLineNum = 222;BA.debugLine="Cell=row.getCell(0)";
Debug.ShouldStop(536870912);
_cell = _row.runMethod(false,"getCell",(Object)(BA.numberCast(int.class, 0)));Debug.locals.put("Cell", _cell);
 BA.debugLineNum = 223;BA.debugLine="Texto1 = Cell.StringCellValue";
Debug.ShouldStop(1073741824);
_texto1 = _cell.runMethod(true,"getStringCellValue");Debug.locals.put("Texto1", _texto1);
 BA.debugLineNum = 224;BA.debugLine="Log(Cell.StringCellValue)";
Debug.ShouldStop(-2147483648);
main.mostCurrent.__c.runVoidMethod ("LogImpl","2524379",_cell.runMethod(true,"getStringCellValue"),0);
 BA.debugLineNum = 225;BA.debugLine="Concepto6.text= Texto1";
Debug.ShouldStop(1);
main.mostCurrent._concepto6.runMethod(true,"setText",BA.ObjectToCharSequence(_texto1));
 BA.debugLineNum = 227;BA.debugLine="row=sheet.getRow(7)";
Debug.ShouldStop(4);
_row = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("de.donmanfred.XSSFRowwrapper"), _sheet.runMethod(false,"getRow",(Object)(BA.numberCast(int.class, 7))));Debug.locals.put("row", _row);
 BA.debugLineNum = 228;BA.debugLine="Cell=row.getCell(0)";
Debug.ShouldStop(8);
_cell = _row.runMethod(false,"getCell",(Object)(BA.numberCast(int.class, 0)));Debug.locals.put("Cell", _cell);
 BA.debugLineNum = 229;BA.debugLine="Texto1 = Cell.StringCellValue";
Debug.ShouldStop(16);
_texto1 = _cell.runMethod(true,"getStringCellValue");Debug.locals.put("Texto1", _texto1);
 BA.debugLineNum = 230;BA.debugLine="Log(Cell.StringCellValue)";
Debug.ShouldStop(32);
main.mostCurrent.__c.runVoidMethod ("LogImpl","2524385",_cell.runMethod(true,"getStringCellValue"),0);
 BA.debugLineNum = 231;BA.debugLine="Concepto7.text= Texto1";
Debug.ShouldStop(64);
main.mostCurrent._concepto7.runMethod(true,"setText",BA.ObjectToCharSequence(_texto1));
 BA.debugLineNum = 233;BA.debugLine="row=sheet.getRow(0)";
Debug.ShouldStop(256);
_row = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("de.donmanfred.XSSFRowwrapper"), _sheet.runMethod(false,"getRow",(Object)(BA.numberCast(int.class, 0))));Debug.locals.put("row", _row);
 BA.debugLineNum = 234;BA.debugLine="Cell=row.getCell(2)";
Debug.ShouldStop(512);
_cell = _row.runMethod(false,"getCell",(Object)(BA.numberCast(int.class, 2)));Debug.locals.put("Cell", _cell);
 BA.debugLineNum = 235;BA.debugLine="Texto1 = Cell.StringCellValue";
Debug.ShouldStop(1024);
_texto1 = _cell.runMethod(true,"getStringCellValue");Debug.locals.put("Texto1", _texto1);
 BA.debugLineNum = 236;BA.debugLine="Log(Cell.StringCellValue)";
Debug.ShouldStop(2048);
main.mostCurrent.__c.runVoidMethod ("LogImpl","2524391",_cell.runMethod(true,"getStringCellValue"),0);
 BA.debugLineNum = 237;BA.debugLine="Datos.text= Texto1";
Debug.ShouldStop(4096);
main.mostCurrent._datos.runMethod(true,"setText",BA.ObjectToCharSequence(_texto1));
 BA.debugLineNum = 239;BA.debugLine="row=sheet.getRow(1)";
Debug.ShouldStop(16384);
_row = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("de.donmanfred.XSSFRowwrapper"), _sheet.runMethod(false,"getRow",(Object)(BA.numberCast(int.class, 1))));Debug.locals.put("row", _row);
 BA.debugLineNum = 240;BA.debugLine="Cell=row.getCell(2)";
Debug.ShouldStop(32768);
_cell = _row.runMethod(false,"getCell",(Object)(BA.numberCast(int.class, 2)));Debug.locals.put("Cell", _cell);
 BA.debugLineNum = 241;BA.debugLine="Texto1 = formatter.Format(Cell.NumericCellValue)";
Debug.ShouldStop(65536);
_texto1 = main._formatter.runClassMethod (b4a.example.b4xformatter.class, "_format" /*RemoteObject*/ ,(Object)(_cell.runMethod(true,"getNumericCellValue")));Debug.locals.put("Texto1", _texto1);
 BA.debugLineNum = 242;BA.debugLine="Log(Cell.NumericCellValue)";
Debug.ShouldStop(131072);
main.mostCurrent.__c.runVoidMethod ("LogImpl","2524397",BA.NumberToString(_cell.runMethod(true,"getNumericCellValue")),0);
 BA.debugLineNum = 243;BA.debugLine="Datos1.text= Texto1";
Debug.ShouldStop(262144);
main.mostCurrent._datos1.runMethod(true,"setText",BA.ObjectToCharSequence(_texto1));
 BA.debugLineNum = 245;BA.debugLine="row=sheet.getRow(2)";
Debug.ShouldStop(1048576);
_row = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("de.donmanfred.XSSFRowwrapper"), _sheet.runMethod(false,"getRow",(Object)(BA.numberCast(int.class, 2))));Debug.locals.put("row", _row);
 BA.debugLineNum = 246;BA.debugLine="Cell=row.getCell(2)";
Debug.ShouldStop(2097152);
_cell = _row.runMethod(false,"getCell",(Object)(BA.numberCast(int.class, 2)));Debug.locals.put("Cell", _cell);
 BA.debugLineNum = 247;BA.debugLine="Texto1 = formatter.Format(Cell.NumericCellValue)";
Debug.ShouldStop(4194304);
_texto1 = main._formatter.runClassMethod (b4a.example.b4xformatter.class, "_format" /*RemoteObject*/ ,(Object)(_cell.runMethod(true,"getNumericCellValue")));Debug.locals.put("Texto1", _texto1);
 BA.debugLineNum = 248;BA.debugLine="Log(formatter.Format(Cell.NumericCellValue))";
Debug.ShouldStop(8388608);
main.mostCurrent.__c.runVoidMethod ("LogImpl","2524403",main._formatter.runClassMethod (b4a.example.b4xformatter.class, "_format" /*RemoteObject*/ ,(Object)(_cell.runMethod(true,"getNumericCellValue"))),0);
 BA.debugLineNum = 249;BA.debugLine="Datos2.text= Texto1";
Debug.ShouldStop(16777216);
main.mostCurrent._datos2.runMethod(true,"setText",BA.ObjectToCharSequence(_texto1));
 BA.debugLineNum = 251;BA.debugLine="row=sheet.getRow(3)";
Debug.ShouldStop(67108864);
_row = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("de.donmanfred.XSSFRowwrapper"), _sheet.runMethod(false,"getRow",(Object)(BA.numberCast(int.class, 3))));Debug.locals.put("row", _row);
 BA.debugLineNum = 252;BA.debugLine="Cell=row.getCell(2)";
Debug.ShouldStop(134217728);
_cell = _row.runMethod(false,"getCell",(Object)(BA.numberCast(int.class, 2)));Debug.locals.put("Cell", _cell);
 BA.debugLineNum = 253;BA.debugLine="Texto1 = formatter.Format(Cell.NumericCellValue)";
Debug.ShouldStop(268435456);
_texto1 = main._formatter.runClassMethod (b4a.example.b4xformatter.class, "_format" /*RemoteObject*/ ,(Object)(_cell.runMethod(true,"getNumericCellValue")));Debug.locals.put("Texto1", _texto1);
 BA.debugLineNum = 254;BA.debugLine="Log(formatter.Format(Cell.NumericCellValue))";
Debug.ShouldStop(536870912);
main.mostCurrent.__c.runVoidMethod ("LogImpl","2524409",main._formatter.runClassMethod (b4a.example.b4xformatter.class, "_format" /*RemoteObject*/ ,(Object)(_cell.runMethod(true,"getNumericCellValue"))),0);
 BA.debugLineNum = 255;BA.debugLine="Datos3.text= Texto1";
Debug.ShouldStop(1073741824);
main.mostCurrent._datos3.runMethod(true,"setText",BA.ObjectToCharSequence(_texto1));
 BA.debugLineNum = 257;BA.debugLine="row=sheet.getRow(4)";
Debug.ShouldStop(1);
_row = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("de.donmanfred.XSSFRowwrapper"), _sheet.runMethod(false,"getRow",(Object)(BA.numberCast(int.class, 4))));Debug.locals.put("row", _row);
 BA.debugLineNum = 258;BA.debugLine="Cell=row.getCell(2)";
Debug.ShouldStop(2);
_cell = _row.runMethod(false,"getCell",(Object)(BA.numberCast(int.class, 2)));Debug.locals.put("Cell", _cell);
 BA.debugLineNum = 259;BA.debugLine="Texto1 = formatter.Format(Cell.NumericCellValue)";
Debug.ShouldStop(4);
_texto1 = main._formatter.runClassMethod (b4a.example.b4xformatter.class, "_format" /*RemoteObject*/ ,(Object)(_cell.runMethod(true,"getNumericCellValue")));Debug.locals.put("Texto1", _texto1);
 BA.debugLineNum = 260;BA.debugLine="Log(formatter.Format(Cell.NumericCellValue))";
Debug.ShouldStop(8);
main.mostCurrent.__c.runVoidMethod ("LogImpl","2524415",main._formatter.runClassMethod (b4a.example.b4xformatter.class, "_format" /*RemoteObject*/ ,(Object)(_cell.runMethod(true,"getNumericCellValue"))),0);
 BA.debugLineNum = 261;BA.debugLine="Datos4.text= Texto1";
Debug.ShouldStop(16);
main.mostCurrent._datos4.runMethod(true,"setText",BA.ObjectToCharSequence(_texto1));
 BA.debugLineNum = 263;BA.debugLine="row=sheet.getRow(5)";
Debug.ShouldStop(64);
_row = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("de.donmanfred.XSSFRowwrapper"), _sheet.runMethod(false,"getRow",(Object)(BA.numberCast(int.class, 5))));Debug.locals.put("row", _row);
 BA.debugLineNum = 264;BA.debugLine="Cell=row.getCell(2)";
Debug.ShouldStop(128);
_cell = _row.runMethod(false,"getCell",(Object)(BA.numberCast(int.class, 2)));Debug.locals.put("Cell", _cell);
 BA.debugLineNum = 265;BA.debugLine="Texto1 = formatter.Format(Cell.NumericCellValue)";
Debug.ShouldStop(256);
_texto1 = main._formatter.runClassMethod (b4a.example.b4xformatter.class, "_format" /*RemoteObject*/ ,(Object)(_cell.runMethod(true,"getNumericCellValue")));Debug.locals.put("Texto1", _texto1);
 BA.debugLineNum = 266;BA.debugLine="Log(formatter.Format(Cell.NumericCellValue))";
Debug.ShouldStop(512);
main.mostCurrent.__c.runVoidMethod ("LogImpl","2524421",main._formatter.runClassMethod (b4a.example.b4xformatter.class, "_format" /*RemoteObject*/ ,(Object)(_cell.runMethod(true,"getNumericCellValue"))),0);
 BA.debugLineNum = 267;BA.debugLine="Datos5.text= Texto1";
Debug.ShouldStop(1024);
main.mostCurrent._datos5.runMethod(true,"setText",BA.ObjectToCharSequence(_texto1));
 BA.debugLineNum = 269;BA.debugLine="row=sheet.getRow(6)";
Debug.ShouldStop(4096);
_row = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("de.donmanfred.XSSFRowwrapper"), _sheet.runMethod(false,"getRow",(Object)(BA.numberCast(int.class, 6))));Debug.locals.put("row", _row);
 BA.debugLineNum = 270;BA.debugLine="Cell=row.getCell(2)";
Debug.ShouldStop(8192);
_cell = _row.runMethod(false,"getCell",(Object)(BA.numberCast(int.class, 2)));Debug.locals.put("Cell", _cell);
 BA.debugLineNum = 271;BA.debugLine="Texto1 = formatter.Format(Cell.NumericCellValue)";
Debug.ShouldStop(16384);
_texto1 = main._formatter.runClassMethod (b4a.example.b4xformatter.class, "_format" /*RemoteObject*/ ,(Object)(_cell.runMethod(true,"getNumericCellValue")));Debug.locals.put("Texto1", _texto1);
 BA.debugLineNum = 272;BA.debugLine="Log(formatter.Format(Cell.NumericCellValue))";
Debug.ShouldStop(32768);
main.mostCurrent.__c.runVoidMethod ("LogImpl","2524427",main._formatter.runClassMethod (b4a.example.b4xformatter.class, "_format" /*RemoteObject*/ ,(Object)(_cell.runMethod(true,"getNumericCellValue"))),0);
 BA.debugLineNum = 273;BA.debugLine="Datos6.text= Texto1";
Debug.ShouldStop(65536);
main.mostCurrent._datos6.runMethod(true,"setText",BA.ObjectToCharSequence(_texto1));
 BA.debugLineNum = 275;BA.debugLine="row=sheet.getRow(7)";
Debug.ShouldStop(262144);
_row = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("de.donmanfred.XSSFRowwrapper"), _sheet.runMethod(false,"getRow",(Object)(BA.numberCast(int.class, 7))));Debug.locals.put("row", _row);
 BA.debugLineNum = 276;BA.debugLine="Cell=row.getCell(2)";
Debug.ShouldStop(524288);
_cell = _row.runMethod(false,"getCell",(Object)(BA.numberCast(int.class, 2)));Debug.locals.put("Cell", _cell);
 BA.debugLineNum = 277;BA.debugLine="Texto1 = formatter.Format(Cell.NumericCellValue)";
Debug.ShouldStop(1048576);
_texto1 = main._formatter.runClassMethod (b4a.example.b4xformatter.class, "_format" /*RemoteObject*/ ,(Object)(_cell.runMethod(true,"getNumericCellValue")));Debug.locals.put("Texto1", _texto1);
 BA.debugLineNum = 278;BA.debugLine="Log(formatter.Format(Cell.NumericCellValue))";
Debug.ShouldStop(2097152);
main.mostCurrent.__c.runVoidMethod ("LogImpl","2524433",main._formatter.runClassMethod (b4a.example.b4xformatter.class, "_format" /*RemoteObject*/ ,(Object)(_cell.runMethod(true,"getNumericCellValue"))),0);
 BA.debugLineNum = 279;BA.debugLine="Datos7.text= Texto1";
Debug.ShouldStop(4194304);
main.mostCurrent._datos7.runMethod(true,"setText",BA.ObjectToCharSequence(_texto1));
 BA.debugLineNum = 281;BA.debugLine="End Sub";
Debug.ShouldStop(16777216);
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
		Debug.PushSubsStack("Boton_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,115);
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
		Debug.PushSubsStack("Boton_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,115);
Debug.locals = rsLocals;Debug.currentSubFrame.locals = rsLocals;

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
 BA.debugLineNum = 116;BA.debugLine="Dim fd As FileDialog";
Debug.ShouldStop(524288);
_fd = RemoteObject.createNew ("anywheresoftware.b4a.agraham.dialogs.InputDialog.FileDialog");Debug.locals.put("fd", _fd);
 BA.debugLineNum = 117;BA.debugLine="fd.FastScroll = True";
Debug.ShouldStop(1048576);
_fd.runMethod(true,"setFastScroll",parent.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 118;BA.debugLine="fd.ShowOnlyFolders=False";
Debug.ShouldStop(2097152);
_fd.runMethod(true,"setShowOnlyFolders",parent.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 119;BA.debugLine="fd.TextColor=Colors.Black";
Debug.ShouldStop(4194304);
_fd.setField ("TextColor",parent.mostCurrent.__c.getField(false,"Colors").getField(true,"Black"));
 BA.debugLineNum = 120;BA.debugLine="fd.FilePath = File.DirInternal";
Debug.ShouldStop(8388608);
_fd.runMethod(true,"setFilePath",parent.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal"));
 BA.debugLineNum = 121;BA.debugLine="Dim sf As Object = fd.ShowAsync(\"Seleccionar Arch";
Debug.ShouldStop(16777216);
_sf = _fd.runMethod(false,"ShowAsync",(Object)(BA.ObjectToCharSequence("Seleccionar Archivo")),(Object)(BA.ObjectToString("Si")),(Object)(BA.ObjectToString("Cancelar")),(Object)(BA.ObjectToString("No")),main.mostCurrent.activityBA,(Object)((parent.mostCurrent.__c.getField(false,"Null"))),(Object)(parent.mostCurrent.__c.getField(true,"False")));Debug.locals.put("sf", _sf);Debug.locals.put("sf", _sf);
 BA.debugLineNum = 122;BA.debugLine="Wait For (sf) Dialog_Result(Result As Int)";
Debug.ShouldStop(33554432);
parent.mostCurrent.__c.runVoidMethod ("WaitFor","dialog_result", main.processBA, anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this, "main", "boton_click"), _sf);
this.state = 5;
return;
case 5:
//C
this.state = 1;
_result = (RemoteObject) result.getArrayElement(true,RemoteObject.createImmutable(0));Debug.locals.put("Result", _result);
;
 BA.debugLineNum = 123;BA.debugLine="If Result = DialogResponse.POSITIVE Then";
Debug.ShouldStop(67108864);
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
 BA.debugLineNum = 124;BA.debugLine="Log(\"File path: \" & fd.FilePath)";
Debug.ShouldStop(134217728);
parent.mostCurrent.__c.runVoidMethod ("LogImpl","2458761",RemoteObject.concat(RemoteObject.createImmutable("File path: "),_fd.runMethod(true,"getFilePath")),0);
 BA.debugLineNum = 125;BA.debugLine="Log(\"File name: \" & fd.ChosenName)";
Debug.ShouldStop(268435456);
parent.mostCurrent.__c.runVoidMethod ("LogImpl","2458762",RemoteObject.concat(RemoteObject.createImmutable("File name: "),_fd.runMethod(true,"getChosenName")),0);
 if (true) break;

case 4:
//C
this.state = -1;
;
 BA.debugLineNum = 127;BA.debugLine="Label1.Text = \"Ruta = \" & fd.FilePath";
Debug.ShouldStop(1073741824);
parent.mostCurrent._label1.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("Ruta = "),_fd.runMethod(true,"getFilePath"))));
 BA.debugLineNum = 128;BA.debugLine="Label2.Text = \"Archivo = \" & fd.ChosenName";
Debug.ShouldStop(-2147483648);
parent.mostCurrent._label2.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("Archivo = "),_fd.runMethod(true,"getChosenName"))));
 BA.debugLineNum = 129;BA.debugLine="archivo = fd.ChosenName";
Debug.ShouldStop(1);
parent.mostCurrent._archivo = _fd.runMethod(true,"getChosenName");
 BA.debugLineNum = 131;BA.debugLine="End Sub";
Debug.ShouldStop(4);
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
 //BA.debugLineNum = 29;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 32;BA.debugLine="Private INICIAR As Button";
main.mostCurrent._iniciar = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 34;BA.debugLine="Private info As Button";
main.mostCurrent._info = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 35;BA.debugLine="Dim Usuario As String";
main.mostCurrent._usuario = RemoteObject.createImmutable("");
 //BA.debugLineNum = 36;BA.debugLine="Dim archivo As String";
main.mostCurrent._archivo = RemoteObject.createImmutable("");
 //BA.debugLineNum = 37;BA.debugLine="Dim path As String";
main.mostCurrent._path = RemoteObject.createImmutable("");
 //BA.debugLineNum = 40;BA.debugLine="Private Nombre As EditText";
main.mostCurrent._nombre = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 42;BA.debugLine="Usuario = Nombre";
main.mostCurrent._usuario = BA.ObjectToString(main.mostCurrent._nombre);
 //BA.debugLineNum = 45;BA.debugLine="Private HiUsuario As Label";
main.mostCurrent._hiusuario = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 47;BA.debugLine="Private Boton As Button";
main.mostCurrent._boton = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 49;BA.debugLine="Private Label1 As Label";
main.mostCurrent._label1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 50;BA.debugLine="Private Label2 As Label";
main.mostCurrent._label2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 51;BA.debugLine="Private Analisis As Button";
main.mostCurrent._analisis = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 52;BA.debugLine="Private Concepto As Label";
main.mostCurrent._concepto = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 53;BA.debugLine="Private Concepto1 As Label";
main.mostCurrent._concepto1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 54;BA.debugLine="Private Concepto2 As Label";
main.mostCurrent._concepto2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 55;BA.debugLine="Private Concepto3 As Label";
main.mostCurrent._concepto3 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 56;BA.debugLine="Private Concepto4 As Label";
main.mostCurrent._concepto4 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 57;BA.debugLine="Private Concepto5 As Label";
main.mostCurrent._concepto5 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 58;BA.debugLine="Private Concepto6 As Label";
main.mostCurrent._concepto6 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 59;BA.debugLine="Private Concepto7 As Label";
main.mostCurrent._concepto7 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 60;BA.debugLine="Private Datos As Label";
main.mostCurrent._datos = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 61;BA.debugLine="Private Datos1 As Label";
main.mostCurrent._datos1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 62;BA.debugLine="Private Datos2 As Label";
main.mostCurrent._datos2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 63;BA.debugLine="Private Datos3 As Label";
main.mostCurrent._datos3 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 64;BA.debugLine="Private Datos4 As Label";
main.mostCurrent._datos4 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 65;BA.debugLine="Private Datos5 As Label";
main.mostCurrent._datos5 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 66;BA.debugLine="Private Datos6 As Label";
main.mostCurrent._datos6 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 67;BA.debugLine="Private Datos7 As Label";
main.mostCurrent._datos7 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 68;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _info_click() throws Exception{
try {
		Debug.PushSubsStack("info_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,109);
if (RapidSub.canDelegate("info_click")) { return b4a.example.main.remoteMe.runUserSub(false, "main","info_click");}
 BA.debugLineNum = 109;BA.debugLine="Private Sub info_Click";
Debug.ShouldStop(4096);
 BA.debugLineNum = 110;BA.debugLine="MsgboxAsync(\"Recuerda verificar que el archivo ele";
Debug.ShouldStop(8192);
main.mostCurrent.__c.runVoidMethod ("MsgboxAsync",(Object)(BA.ObjectToCharSequence("Recuerda verificar que el archivo elegido es el correcto")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("INFORMACIÓN"))),main.processBA);
 BA.debugLineNum = 113;BA.debugLine="End Sub";
Debug.ShouldStop(65536);
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
		Debug.PushSubsStack("INICIAR_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,100);
if (RapidSub.canDelegate("iniciar_click")) { return b4a.example.main.remoteMe.runUserSub(false, "main","iniciar_click");}
 BA.debugLineNum = 100;BA.debugLine="Private Sub INICIAR_Click";
Debug.ShouldStop(8);
 BA.debugLineNum = 101;BA.debugLine="Usuario = Nombre.Text";
Debug.ShouldStop(16);
main.mostCurrent._usuario = main.mostCurrent._nombre.runMethod(true,"getText");
 BA.debugLineNum = 102;BA.debugLine="Activity.RemoveAllViews";
Debug.ShouldStop(32);
main.mostCurrent._activity.runVoidMethod ("RemoveAllViews");
 BA.debugLineNum = 103;BA.debugLine="Activity.LoadLayout(\"Pantalla2\")";
Debug.ShouldStop(64);
main.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("Pantalla2")),main.mostCurrent.activityBA);
 BA.debugLineNum = 104;BA.debugLine="HiUsuario.Text= \"Hola \" & Usuario";
Debug.ShouldStop(128);
main.mostCurrent._hiusuario.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("Hola "),main.mostCurrent._usuario)));
 BA.debugLineNum = 107;BA.debugLine="End Sub";
Debug.ShouldStop(1024);
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
b4xformatter.myClass = BA.getDeviceClass ("b4a.example.b4xformatter");
		
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
 //BA.debugLineNum = 24;BA.debugLine="Private formatter As B4XFormatter";
main._formatter = RemoteObject.createNew ("b4a.example.b4xformatter");
 //BA.debugLineNum = 26;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
}