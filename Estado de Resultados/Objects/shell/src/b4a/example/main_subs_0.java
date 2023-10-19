package b4a.example;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class main_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
<<<<<<< Updated upstream
		Debug.PushSubsStack("Activity_Create (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,61);
=======
		Debug.PushSubsStack("Activity_Create (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,82);
>>>>>>> Stashed changes
if (RapidSub.canDelegate("activity_create")) { return b4a.example.main.remoteMe.runUserSub(false, "main","activity_create", _firsttime);}
Debug.locals.put("FirstTime", _firsttime);
<<<<<<< Updated upstream
 BA.debugLineNum = 61;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(268435456);
 BA.debugLineNum = 64;BA.debugLine="Activity.LoadLayout(\"Pantalla1\")";
Debug.ShouldStop(-2147483648);
main.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("Pantalla1")),main.mostCurrent.activityBA);
 BA.debugLineNum = 67;BA.debugLine="End Sub";
Debug.ShouldStop(4);
=======
 BA.debugLineNum = 82;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(131072);
 BA.debugLineNum = 84;BA.debugLine="Activity.LoadLayout(\"Pantalla1\")";
Debug.ShouldStop(524288);
main.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("Pantalla1")),main.mostCurrent.activityBA);
 BA.debugLineNum = 86;BA.debugLine="If FirstTime Then";
Debug.ShouldStop(2097152);
if (_firsttime.<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 87;BA.debugLine="formatter.Initialize";
Debug.ShouldStop(4194304);
main._formatter.runClassMethod (b4a.example.b4xformatter.class, "_initialize" /*RemoteObject*/ ,main.processBA);
 BA.debugLineNum = 88;BA.debugLine="Dim DefaultFormat As B4XFormatData = formatter.G";
Debug.ShouldStop(8388608);
_defaultformat = main._formatter.runClassMethod (b4a.example.b4xformatter.class, "_getdefaultformat" /*RemoteObject*/ );Debug.locals.put("DefaultFormat", _defaultformat);Debug.locals.put("DefaultFormat", _defaultformat);
 BA.debugLineNum = 89;BA.debugLine="DefaultFormat.MaximumFractions = 2";
Debug.ShouldStop(16777216);
_defaultformat.setField ("MaximumFractions" /*RemoteObject*/ ,BA.numberCast(int.class, 2));
 BA.debugLineNum = 90;BA.debugLine="DefaultFormat.MinimumFractions = 2";
Debug.ShouldStop(33554432);
_defaultformat.setField ("MinimumFractions" /*RemoteObject*/ ,BA.numberCast(int.class, 2));
 BA.debugLineNum = 91;BA.debugLine="DefaultFormat.Prefix = \"$ \"";
Debug.ShouldStop(67108864);
_defaultformat.setField ("Prefix" /*RemoteObject*/ ,BA.ObjectToString("$ "));
 BA.debugLineNum = 92;BA.debugLine="Dim NegativeFormat As B4XFormatData = formatter.";
Debug.ShouldStop(134217728);
_negativeformat = main._formatter.runClassMethod (b4a.example.b4xformatter.class, "_copyformatdata" /*RemoteObject*/ ,(Object)(_defaultformat));Debug.locals.put("NegativeFormat", _negativeformat);Debug.locals.put("NegativeFormat", _negativeformat);
 BA.debugLineNum = 93;BA.debugLine="NegativeFormat.TextColor = xui.Color_Red";
Debug.ShouldStop(268435456);
_negativeformat.setField ("TextColor" /*RemoteObject*/ ,main._xui.getField(true,"Color_Red"));
 BA.debugLineNum = 94;BA.debugLine="NegativeFormat.Prefix = \"$ (\"";
Debug.ShouldStop(536870912);
_negativeformat.setField ("Prefix" /*RemoteObject*/ ,BA.ObjectToString("$ ("));
 BA.debugLineNum = 95;BA.debugLine="NegativeFormat.Postfix = \")\"";
Debug.ShouldStop(1073741824);
_negativeformat.setField ("Postfix" /*RemoteObject*/ ,BA.ObjectToString(")"));
 BA.debugLineNum = 96;BA.debugLine="NegativeFormat.FormatFont = xui.CreateDefaultBol";
Debug.ShouldStop(-2147483648);
_negativeformat.setField ("FormatFont" /*RemoteObject*/ ,main._xui.runMethod(false,"CreateDefaultBoldFont",(Object)(BA.numberCast(float.class, 15))));
 BA.debugLineNum = 97;BA.debugLine="formatter.AddFormatData(NegativeFormat, formatte";
Debug.ShouldStop(1);
main._formatter.runClassMethod (b4a.example.b4xformatter.class, "_addformatdata" /*RemoteObject*/ ,(Object)(_negativeformat),(Object)(BA.numberCast(double.class, main._formatter.getField(true,"_min_value" /*RemoteObject*/ ))),(Object)(BA.numberCast(double.class, 0)),(Object)(main.mostCurrent.__c.getField(true,"False")));
 };
 BA.debugLineNum = 100;BA.debugLine="End Sub";
Debug.ShouldStop(8);
>>>>>>> Stashed changes
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
<<<<<<< Updated upstream
		Debug.PushSubsStack("Activity_Pause (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,73);
if (RapidSub.canDelegate("activity_pause")) { return b4a.example.main.remoteMe.runUserSub(false, "main","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 73;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(256);
 BA.debugLineNum = 75;BA.debugLine="End Sub";
Debug.ShouldStop(1024);
=======
		Debug.PushSubsStack("Activity_Pause (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,106);
if (RapidSub.canDelegate("activity_pause")) { return b4a.example.main.remoteMe.runUserSub(false, "main","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 106;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(512);
 BA.debugLineNum = 108;BA.debugLine="End Sub";
Debug.ShouldStop(2048);
>>>>>>> Stashed changes
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
<<<<<<< Updated upstream
		Debug.PushSubsStack("Activity_Resume (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,69);
if (RapidSub.canDelegate("activity_resume")) { return b4a.example.main.remoteMe.runUserSub(false, "main","activity_resume");}
 BA.debugLineNum = 69;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(16);
 BA.debugLineNum = 71;BA.debugLine="End Sub";
Debug.ShouldStop(64);
=======
		Debug.PushSubsStack("Activity_Resume (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,102);
if (RapidSub.canDelegate("activity_resume")) { return b4a.example.main.remoteMe.runUserSub(false, "main","activity_resume");}
 BA.debugLineNum = 102;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(32);
 BA.debugLineNum = 104;BA.debugLine="End Sub";
Debug.ShouldStop(128);
>>>>>>> Stashed changes
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
<<<<<<< Updated upstream
		Debug.PushSubsStack("Analisis_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,110);
=======
		Debug.PushSubsStack("Analisis_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,144);
>>>>>>> Stashed changes
if (RapidSub.canDelegate("analisis_click")) { return b4a.example.main.remoteMe.runUserSub(false, "main","analisis_click");}
RemoteObject _sheet = RemoteObject.declareNull("de.donmanfred.XLSSheetwrapper");
RemoteObject _row = RemoteObject.declareNull("de.donmanfred.XSSFRowwrapper");
RemoteObject _cell = RemoteObject.declareNull("de.donmanfred.XSSFCellwrapper");
<<<<<<< Updated upstream
<<<<<<< Updated upstream
RemoteObject _texto1 = RemoteObject.createImmutable("");
=======
RemoteObject _texto = RemoteObject.createImmutable("");
>>>>>>> Stashed changes
 BA.debugLineNum = 110;BA.debugLine="Private Sub Analisis_Click";
Debug.ShouldStop(8192);
 BA.debugLineNum = 112;BA.debugLine="File.Copy(File.DirAssets,archivo,File.DirInternal";
Debug.ShouldStop(32768);
main.mostCurrent.__c.getField(false,"File").runVoidMethod ("Copy",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(main.mostCurrent._archivo),(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(main.mostCurrent._archivo));
 BA.debugLineNum = 113;BA.debugLine="xls.Initialize(\"\",File.Combine(File.DirInternal,a";
Debug.ShouldStop(65536);
main._xls.runVoidMethod ("Initialize",main.processBA,(Object)(BA.ObjectToString("")),(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"Combine",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(main.mostCurrent._archivo))));
 BA.debugLineNum = 114;BA.debugLine="Log($\"ActiveSheetIndex=${xls.ActiveSheetIndex}\"$)";
Debug.ShouldStop(131072);
<<<<<<< Updated upstream
main.mostCurrent.__c.runVoidMethod ("LogImpl","2524292",(RemoteObject.concat(RemoteObject.createImmutable("ActiveSheetIndex="),main.mostCurrent.__c.runMethod(true,"SmartStringFormatter",(Object)(BA.ObjectToString("")),(Object)((main._xls.runMethod(true,"getActiveSheetIndex")))),RemoteObject.createImmutable(""))),0);
=======
main.mostCurrent.__c.runVoidMethod ("LogImpl","7524292",(RemoteObject.concat(RemoteObject.createImmutable("ActiveSheetIndex="),main.mostCurrent.__c.runMethod(true,"SmartStringFormatter",(Object)(BA.ObjectToString("")),(Object)((main._xls.runMethod(true,"getActiveSheetIndex")))),RemoteObject.createImmutable(""))),0);
>>>>>>> Stashed changes
 BA.debugLineNum = 115;BA.debugLine="Dim sheet As XLSSheet = xls.getSheetAt(xls.Active";
Debug.ShouldStop(262144);
_sheet = RemoteObject.createNew ("de.donmanfred.XLSSheetwrapper");
_sheet = main._xls.runMethod(false,"getSheetAt",(Object)(main._xls.runMethod(true,"getActiveSheetIndex")));Debug.locals.put("sheet", _sheet);Debug.locals.put("sheet", _sheet);
 BA.debugLineNum = 116;BA.debugLine="Log($\"ActiveSheet.ActiveCell=${sheet.ActiveCell}\"";
Debug.ShouldStop(524288);
<<<<<<< Updated upstream
main.mostCurrent.__c.runVoidMethod ("LogImpl","2524294",(RemoteObject.concat(RemoteObject.createImmutable("ActiveSheet.ActiveCell="),main.mostCurrent.__c.runMethod(true,"SmartStringFormatter",(Object)(BA.ObjectToString("")),(Object)((_sheet.runMethod(true,"getActiveCell")))),RemoteObject.createImmutable(""))),0);
 BA.debugLineNum = 117;BA.debugLine="Log($\"ActiveSheet.hasComments=${sheet.hasComments";
Debug.ShouldStop(1048576);
main.mostCurrent.__c.runVoidMethod ("LogImpl","2524295",(RemoteObject.concat(RemoteObject.createImmutable("ActiveSheet.hasComments="),main.mostCurrent.__c.runMethod(true,"SmartStringFormatter",(Object)(BA.ObjectToString("")),(Object)((_sheet.runMethod(true,"hasComments")))),RemoteObject.createImmutable(""))),0);
=======
main.mostCurrent.__c.runVoidMethod ("LogImpl","7524294",(RemoteObject.concat(RemoteObject.createImmutable("ActiveSheet.ActiveCell="),main.mostCurrent.__c.runMethod(true,"SmartStringFormatter",(Object)(BA.ObjectToString("")),(Object)((_sheet.runMethod(true,"getActiveCell")))),RemoteObject.createImmutable(""))),0);
 BA.debugLineNum = 117;BA.debugLine="Log($\"ActiveSheet.hasComments=${sheet.hasComments";
Debug.ShouldStop(1048576);
main.mostCurrent.__c.runVoidMethod ("LogImpl","7524295",(RemoteObject.concat(RemoteObject.createImmutable("ActiveSheet.hasComments="),main.mostCurrent.__c.runMethod(true,"SmartStringFormatter",(Object)(BA.ObjectToString("")),(Object)((_sheet.runMethod(true,"hasComments")))),RemoteObject.createImmutable(""))),0);
>>>>>>> Stashed changes
 BA.debugLineNum = 118;BA.debugLine="Dim firstrow As Int = sheet.FirstRowNum";
Debug.ShouldStop(2097152);
_firstrow = _sheet.runMethod(true,"getFirstRowNum");Debug.locals.put("firstrow", _firstrow);Debug.locals.put("firstrow", _firstrow);
 BA.debugLineNum = 119;BA.debugLine="Dim lastrow As Int = sheet.LastRowNum";
Debug.ShouldStop(4194304);
_lastrow = _sheet.runMethod(true,"getLastRowNum");Debug.locals.put("lastrow", _lastrow);Debug.locals.put("lastrow", _lastrow);
 BA.debugLineNum = 120;BA.debugLine="Log($\"Row FirstRow=${firstrow}, LastRow=${lastrow";
Debug.ShouldStop(8388608);
<<<<<<< Updated upstream
main.mostCurrent.__c.runVoidMethod ("LogImpl","2524298",(RemoteObject.concat(RemoteObject.createImmutable("Row FirstRow="),main.mostCurrent.__c.runMethod(true,"SmartStringFormatter",(Object)(BA.ObjectToString("")),(Object)((_firstrow))),RemoteObject.createImmutable(", LastRow="),main.mostCurrent.__c.runMethod(true,"SmartStringFormatter",(Object)(BA.ObjectToString("")),(Object)((_lastrow))),RemoteObject.createImmutable(""))),0);
=======
main.mostCurrent.__c.runVoidMethod ("LogImpl","7524298",(RemoteObject.concat(RemoteObject.createImmutable("Row FirstRow="),main.mostCurrent.__c.runMethod(true,"SmartStringFormatter",(Object)(BA.ObjectToString("")),(Object)((_firstrow))),RemoteObject.createImmutable(", LastRow="),main.mostCurrent.__c.runMethod(true,"SmartStringFormatter",(Object)(BA.ObjectToString("")),(Object)((_lastrow))),RemoteObject.createImmutable(""))),0);
 BA.debugLineNum = 122;BA.debugLine="For i= firstrow To lastrow";
Debug.ShouldStop(33554432);
{
final int step10 = 1;
final int limit10 = _lastrow.<Integer>get().intValue();
_i = _firstrow.<Integer>get().intValue() ;
for (;(step10 > 0 && _i <= limit10) || (step10 < 0 && _i >= limit10) ;_i = ((int)(0 + _i + step10))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 123;BA.debugLine="Dim row As XSSFRow =sheet.getRow(i)";
Debug.ShouldStop(67108864);
_row = RemoteObject.createNew ("de.donmanfred.XSSFRowwrapper");
_row = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("de.donmanfred.XSSFRowwrapper"), _sheet.runMethod(false,"getRow",(Object)(BA.numberCast(int.class, _i))));Debug.locals.put("row", _row);Debug.locals.put("row", _row);
 BA.debugLineNum = 125;BA.debugLine="Dim firstcell As Int = row.FirstCellNum";
Debug.ShouldStop(268435456);
_firstcell = BA.numberCast(int.class, _row.runMethod(true,"getFirstCellNum"));Debug.locals.put("firstcell", _firstcell);Debug.locals.put("firstcell", _firstcell);
 BA.debugLineNum = 126;BA.debugLine="Dim lastcell As Int = row.LastCellNum";
Debug.ShouldStop(536870912);
_lastcell = BA.numberCast(int.class, _row.runMethod(true,"getLastCellNum"));Debug.locals.put("lastcell", _lastcell);Debug.locals.put("lastcell", _lastcell);
 BA.debugLineNum = 127;BA.debugLine="Log($\"Row #${i} FirstCell=${row.FirstCellNum}, L";
Debug.ShouldStop(1073741824);
main.mostCurrent.__c.runVoidMethod ("LogImpl","7524305",(RemoteObject.concat(RemoteObject.createImmutable("Row #"),main.mostCurrent.__c.runMethod(true,"SmartStringFormatter",(Object)(BA.ObjectToString("")),(Object)(RemoteObject.createImmutable((_i)))),RemoteObject.createImmutable(" FirstCell="),main.mostCurrent.__c.runMethod(true,"SmartStringFormatter",(Object)(BA.ObjectToString("")),(Object)((_row.runMethod(true,"getFirstCellNum")))),RemoteObject.createImmutable(", LastCell="),main.mostCurrent.__c.runMethod(true,"SmartStringFormatter",(Object)(BA.ObjectToString("")),(Object)((_row.runMethod(true,"getLastCellNum")))),RemoteObject.createImmutable(""))),0);
 BA.debugLineNum = 132;BA.debugLine="For o= firstcell To lastcell-1";
Debug.ShouldStop(8);
{
final int step15 = 1;
final int limit15 = RemoteObject.solve(new RemoteObject[] {_lastcell,RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_o = _firstcell.<Integer>get().intValue() ;
for (;(step15 > 0 && _o <= limit15) || (step15 < 0 && _o >= limit15) ;_o = ((int)(0 + _o + step15))  ) {
Debug.locals.put("o", _o);
 BA.debugLineNum = 133;BA.debugLine="Dim Cell As XSSFCell =row.getCell(o)";
Debug.ShouldStop(16);
_cell = RemoteObject.createNew ("de.donmanfred.XSSFCellwrapper");
_cell = _row.runMethod(false,"getCell",(Object)(BA.numberCast(int.class, _o)));Debug.locals.put("Cell", _cell);Debug.locals.put("Cell", _cell);
 BA.debugLineNum = 134;BA.debugLine="Log($\"Cell #${o}\"$)";
Debug.ShouldStop(32);
main.mostCurrent.__c.runVoidMethod ("LogImpl","7524312",(RemoteObject.concat(RemoteObject.createImmutable("Cell #"),main.mostCurrent.__c.runMethod(true,"SmartStringFormatter",(Object)(BA.ObjectToString("")),(Object)(RemoteObject.createImmutable((_o)))),RemoteObject.createImmutable(""))),0);
 BA.debugLineNum = 136;BA.debugLine="If Cell.IsInitialized Then";
Debug.ShouldStop(128);
if (_cell.runMethod(true,"IsInitialized").<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 137;BA.debugLine="Log($\"CellValueType=${Cell.CellType}\"$)";
Debug.ShouldStop(256);
main.mostCurrent.__c.runVoidMethod ("LogImpl","7524315",(RemoteObject.concat(RemoteObject.createImmutable("CellValueType="),main.mostCurrent.__c.runMethod(true,"SmartStringFormatter",(Object)(BA.ObjectToString("")),(Object)((_cell.runMethod(true,"getCellType")))),RemoteObject.createImmutable(""))),0);
 BA.debugLineNum = 138;BA.debugLine="Log(\"Raw:\"&Cell.RawValue)";
Debug.ShouldStop(512);
main.mostCurrent.__c.runVoidMethod ("LogImpl","7524316",RemoteObject.concat(RemoteObject.createImmutable("Raw:"),_cell.runMethod(true,"getRawValue")),0);
 BA.debugLineNum = 139;BA.debugLine="If Cell.CellType = 1 Then";
Debug.ShouldStop(1024);
if (RemoteObject.solveBoolean("=",_cell.runMethod(true,"getCellType"),BA.numberCast(double.class, 1))) { 
 BA.debugLineNum = 140;BA.debugLine="Log(Cell.StringCellValue)";
Debug.ShouldStop(2048);
main.mostCurrent.__c.runVoidMethod ("LogImpl","7524318",_cell.runMethod(true,"getStringCellValue"),0);
 }else 
{ BA.debugLineNum = 141;BA.debugLine="else if Cell.CellType = 0 Then";
Debug.ShouldStop(4096);
if (RemoteObject.solveBoolean("=",_cell.runMethod(true,"getCellType"),BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 142;BA.debugLine="Log(Cell.NumericCellValue)";
Debug.ShouldStop(8192);
main.mostCurrent.__c.runVoidMethod ("LogImpl","7524320",BA.NumberToString(_cell.runMethod(true,"getNumericCellValue")),0);
 }}
;
 };
 }
}Debug.locals.put("o", _o);
;
 }
}Debug.locals.put("i", _i);
;
>>>>>>> Stashed changes
 BA.debugLineNum = 153;BA.debugLine="Activity.RemoveAllViews";
Debug.ShouldStop(16777216);
main.mostCurrent._activity.runVoidMethod ("RemoveAllViews");
 BA.debugLineNum = 154;BA.debugLine="Activity.LoadLayout(\"EstadoResultados\")";
Debug.ShouldStop(33554432);
main.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("EstadoResultados")),main.mostCurrent.activityBA);
<<<<<<< Updated upstream
=======
 BA.debugLineNum = 144;BA.debugLine="Private Sub Analisis_Click";
Debug.ShouldStop(32768);
 BA.debugLineNum = 146;BA.debugLine="Activity.RemoveAllViews";
Debug.ShouldStop(131072);
main.mostCurrent._activity.runVoidMethod ("RemoveAllViews");
 BA.debugLineNum = 147;BA.debugLine="Activity.LoadLayout(\"Analisis\")";
Debug.ShouldStop(262144);
main.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("Analisis")),main.mostCurrent.activityBA);
 BA.debugLineNum = 149;BA.debugLine="File.Copy(File.DirAssets,archivo,File.DirInternal";
Debug.ShouldStop(1048576);
main.mostCurrent.__c.getField(false,"File").runVoidMethod ("Copy",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(main.mostCurrent._archivo),(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(main.mostCurrent._archivo));
 BA.debugLineNum = 150;BA.debugLine="xls.Initialize(\"\",File.Combine(File.DirInternal,a";
Debug.ShouldStop(2097152);
main._xls.runVoidMethod ("Initialize",main.processBA,(Object)(BA.ObjectToString("")),(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"Combine",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(main.mostCurrent._archivo))));
 BA.debugLineNum = 151;BA.debugLine="Log($\"ActiveSheetIndex=${xls.ActiveSheetIndex}\"$)";
Debug.ShouldStop(4194304);
main.mostCurrent.__c.runVoidMethod ("LogImpl","6524295",(RemoteObject.concat(RemoteObject.createImmutable("ActiveSheetIndex="),main.mostCurrent.__c.runMethod(true,"SmartStringFormatter",(Object)(BA.ObjectToString("")),(Object)((main._xls.runMethod(true,"getActiveSheetIndex")))),RemoteObject.createImmutable(""))),0);
 BA.debugLineNum = 152;BA.debugLine="Dim sheet As XLSSheet = xls.getSheetAt(xls.Active";
Debug.ShouldStop(8388608);
_sheet = RemoteObject.createNew ("de.donmanfred.XLSSheetwrapper");
_sheet = main._xls.runMethod(false,"getSheetAt",(Object)(main._xls.runMethod(true,"getActiveSheetIndex")));Debug.locals.put("sheet", _sheet);Debug.locals.put("sheet", _sheet);
>>>>>>> Stashed changes
 BA.debugLineNum = 155;BA.debugLine="Dim row As XSSFRow =sheet.getRow(0)";
Debug.ShouldStop(67108864);
_row = RemoteObject.createNew ("de.donmanfred.XSSFRowwrapper");
_row = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("de.donmanfred.XSSFRowwrapper"), _sheet.runMethod(false,"getRow",(Object)(BA.numberCast(int.class, 0))));Debug.locals.put("row", _row);Debug.locals.put("row", _row);
 BA.debugLineNum = 156;BA.debugLine="Dim Cell As XSSFCell =row.getCell(0)";
Debug.ShouldStop(134217728);
_cell = RemoteObject.createNew ("de.donmanfred.XSSFCellwrapper");
_cell = _row.runMethod(false,"getCell",(Object)(BA.numberCast(int.class, 0)));Debug.locals.put("Cell", _cell);Debug.locals.put("Cell", _cell);
<<<<<<< Updated upstream
 BA.debugLineNum = 158;BA.debugLine="Log(\"valor pelon:\"&Cell.RawValue)";
Debug.ShouldStop(536870912);
main.mostCurrent.__c.runVoidMethod ("LogImpl","2524336",RemoteObject.concat(RemoteObject.createImmutable("valor pelon:"),_cell.runMethod(true,"getRawValue")),0);
 BA.debugLineNum = 159;BA.debugLine="Dim Texto1 As String = Cell.StringCellValue";
Debug.ShouldStop(1073741824);
_texto1 = _cell.runMethod(true,"getStringCellValue");Debug.locals.put("Texto1", _texto1);Debug.locals.put("Texto1", _texto1);
 BA.debugLineNum = 160;BA.debugLine="Log(Cell.StringCellValue)";
Debug.ShouldStop(-2147483648);
main.mostCurrent.__c.runVoidMethod ("LogImpl","2524338",_cell.runMethod(true,"getStringCellValue"),0);
 BA.debugLineNum = 161;BA.debugLine="Concepto.text= Texto1";
Debug.ShouldStop(1);
main.mostCurrent._concepto.runMethod(true,"setText",BA.ObjectToCharSequence(_texto1));
 BA.debugLineNum = 162;BA.debugLine="Log(Concepto.text)";
Debug.ShouldStop(2);
main.mostCurrent.__c.runVoidMethod ("LogImpl","2524340",main.mostCurrent._concepto.runMethod(true,"getText"),0);
=======
 BA.debugLineNum = 155;BA.debugLine="Dim row As XSSFRow =sheet.getRow(1)";
Debug.ShouldStop(67108864);
_row = RemoteObject.createNew ("de.donmanfred.XSSFRowwrapper");
_row = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("de.donmanfred.XSSFRowwrapper"), _sheet.runMethod(false,"getRow",(Object)(BA.numberCast(int.class, 1))));Debug.locals.put("row", _row);Debug.locals.put("row", _row);
 BA.debugLineNum = 156;BA.debugLine="Dim Cell As XSSFCell =row.getCell(1)";
Debug.ShouldStop(134217728);
_cell = RemoteObject.createNew ("de.donmanfred.XSSFCellwrapper");
_cell = _row.runMethod(false,"getCell",(Object)(BA.numberCast(int.class, 1)));Debug.locals.put("Cell", _cell);Debug.locals.put("Cell", _cell);
 BA.debugLineNum = 157;BA.debugLine="Cell.IsInitialized";
Debug.ShouldStop(268435456);
_cell.runVoidMethod ("IsInitialized");
 BA.debugLineNum = 158;BA.debugLine="Log(Cell.StringCellValue)";
Debug.ShouldStop(536870912);
main.mostCurrent.__c.runVoidMethod ("LogImpl","7524336",_cell.runMethod(true,"getStringCellValue"),0);
 BA.debugLineNum = 159;BA.debugLine="Dim Texto As String = Cell.StringCellValue";
Debug.ShouldStop(1073741824);
_texto = _cell.runMethod(true,"getStringCellValue");Debug.locals.put("Texto", _texto);Debug.locals.put("Texto", _texto);
 BA.debugLineNum = 161;BA.debugLine="Concepto.text= Texto";
Debug.ShouldStop(1);
main.mostCurrent._concepto.runMethod(true,"setText",BA.ObjectToCharSequence(_texto));
>>>>>>> Stashed changes
 BA.debugLineNum = 165;BA.debugLine="End Sub";
Debug.ShouldStop(16);
=======
 BA.debugLineNum = 158;BA.debugLine="row=sheet.getRow(1)";
Debug.ShouldStop(536870912);
_row = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("de.donmanfred.XSSFRowwrapper"), _sheet.runMethod(false,"getRow",(Object)(BA.numberCast(int.class, 1))));Debug.locals.put("row", _row);
 BA.debugLineNum = 159;BA.debugLine="Cell=row.getCell(2)";
Debug.ShouldStop(1073741824);
_cell = _row.runMethod(false,"getCell",(Object)(BA.numberCast(int.class, 2)));Debug.locals.put("Cell", _cell);
 BA.debugLineNum = 160;BA.debugLine="Ingresos_ = Cell.NumericCellValue";
Debug.ShouldStop(-2147483648);
main._ingresos_ = BA.numberCast(float.class, _cell.runMethod(true,"getNumericCellValue"));
 BA.debugLineNum = 162;BA.debugLine="row=sheet.getRow(2)";
Debug.ShouldStop(2);
_row = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("de.donmanfred.XSSFRowwrapper"), _sheet.runMethod(false,"getRow",(Object)(BA.numberCast(int.class, 2))));Debug.locals.put("row", _row);
 BA.debugLineNum = 163;BA.debugLine="Cell=row.getCell(2)";
Debug.ShouldStop(4);
_cell = _row.runMethod(false,"getCell",(Object)(BA.numberCast(int.class, 2)));Debug.locals.put("Cell", _cell);
 BA.debugLineNum = 164;BA.debugLine="Gadm = Cell.NumericCellValue";
Debug.ShouldStop(8);
main._gadm = BA.numberCast(float.class, _cell.runMethod(true,"getNumericCellValue"));
 BA.debugLineNum = 166;BA.debugLine="row=sheet.getRow(4)";
Debug.ShouldStop(32);
_row = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("de.donmanfred.XSSFRowwrapper"), _sheet.runMethod(false,"getRow",(Object)(BA.numberCast(int.class, 4))));Debug.locals.put("row", _row);
 BA.debugLineNum = 167;BA.debugLine="Cell=row.getCell(2)";
Debug.ShouldStop(64);
_cell = _row.runMethod(false,"getCell",(Object)(BA.numberCast(int.class, 2)));Debug.locals.put("Cell", _cell);
 BA.debugLineNum = 168;BA.debugLine="GOp = Cell.NumericCellValue";
Debug.ShouldStop(128);
main._gop = BA.numberCast(float.class, _cell.runMethod(true,"getNumericCellValue"));
 BA.debugLineNum = 171;BA.debugLine="End Sub";
Debug.ShouldStop(1024);
>>>>>>> Stashed changes
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
<<<<<<< Updated upstream
		Debug.PushSubsStack("Boton_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,92);
=======
		Debug.PushSubsStack("Boton_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,126);
>>>>>>> Stashed changes
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
<<<<<<< Updated upstream
		Debug.PushSubsStack("Boton_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,92);
=======
		Debug.PushSubsStack("Boton_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,126);
>>>>>>> Stashed changes
Debug.locals = rsLocals;Debug.currentSubFrame.locals = rsLocals;

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
<<<<<<< Updated upstream
 BA.debugLineNum = 93;BA.debugLine="Dim fd As FileDialog";
Debug.ShouldStop(268435456);
_fd = RemoteObject.createNew ("anywheresoftware.b4a.agraham.dialogs.InputDialog.FileDialog");Debug.locals.put("fd", _fd);
 BA.debugLineNum = 94;BA.debugLine="fd.FastScroll = True";
Debug.ShouldStop(536870912);
_fd.runMethod(true,"setFastScroll",parent.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 95;BA.debugLine="fd.ShowOnlyFolders=False";
Debug.ShouldStop(1073741824);
_fd.runMethod(true,"setShowOnlyFolders",parent.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 96;BA.debugLine="fd.TextColor=Colors.Black";
Debug.ShouldStop(-2147483648);
_fd.setField ("TextColor",parent.mostCurrent.__c.getField(false,"Colors").getField(true,"Black"));
 BA.debugLineNum = 97;BA.debugLine="fd.FilePath = File.DirInternal";
Debug.ShouldStop(1);
_fd.runMethod(true,"setFilePath",parent.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal"));
 BA.debugLineNum = 98;BA.debugLine="Dim sf As Object = fd.ShowAsync(\"Select file\", \"Y";
Debug.ShouldStop(2);
_sf = _fd.runMethod(false,"ShowAsync",(Object)(BA.ObjectToCharSequence("Select file")),(Object)(BA.ObjectToString("Yes")),(Object)(BA.ObjectToString("Cancel")),(Object)(BA.ObjectToString("No")),main.mostCurrent.activityBA,(Object)((parent.mostCurrent.__c.getField(false,"Null"))),(Object)(parent.mostCurrent.__c.getField(true,"False")));Debug.locals.put("sf", _sf);Debug.locals.put("sf", _sf);
 BA.debugLineNum = 99;BA.debugLine="Wait For (sf) Dialog_Result(Result As Int)";
Debug.ShouldStop(4);
=======
 BA.debugLineNum = 127;BA.debugLine="Dim fd As FileDialog";
Debug.ShouldStop(1073741824);
_fd = RemoteObject.createNew ("anywheresoftware.b4a.agraham.dialogs.InputDialog.FileDialog");Debug.locals.put("fd", _fd);
 BA.debugLineNum = 128;BA.debugLine="fd.FastScroll = True";
Debug.ShouldStop(-2147483648);
_fd.runMethod(true,"setFastScroll",parent.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 129;BA.debugLine="fd.ShowOnlyFolders=False";
Debug.ShouldStop(1);
_fd.runMethod(true,"setShowOnlyFolders",parent.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 130;BA.debugLine="fd.TextColor=Colors.Black";
Debug.ShouldStop(2);
_fd.setField ("TextColor",parent.mostCurrent.__c.getField(false,"Colors").getField(true,"Black"));
 BA.debugLineNum = 131;BA.debugLine="fd.FilePath = File.DirInternal";
Debug.ShouldStop(4);
_fd.runMethod(true,"setFilePath",parent.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal"));
 BA.debugLineNum = 132;BA.debugLine="Dim sf As Object = fd.ShowAsync(\"Seleccionar Arch";
Debug.ShouldStop(8);
_sf = _fd.runMethod(false,"ShowAsync",(Object)(BA.ObjectToCharSequence("Seleccionar Archivo")),(Object)(BA.ObjectToString("SELECCIONAR")),(Object)(BA.ObjectToString("Cancelar")),(Object)(BA.ObjectToString("")),main.mostCurrent.activityBA,(Object)((parent.mostCurrent.__c.getField(false,"Null"))),(Object)(parent.mostCurrent.__c.getField(true,"False")));Debug.locals.put("sf", _sf);Debug.locals.put("sf", _sf);
 BA.debugLineNum = 133;BA.debugLine="Wait For (sf) Dialog_Result(Result As Int)";
Debug.ShouldStop(16);
>>>>>>> Stashed changes
parent.mostCurrent.__c.runVoidMethod ("WaitFor","dialog_result", main.processBA, anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this, "main", "boton_click"), _sf);
this.state = 5;
return;
case 5:
//C
this.state = 1;
_result = (RemoteObject) result.getArrayElement(true,RemoteObject.createImmutable(0));Debug.locals.put("Result", _result);
;
<<<<<<< Updated upstream
 BA.debugLineNum = 100;BA.debugLine="If Result = DialogResponse.POSITIVE Then";
Debug.ShouldStop(8);
=======
 BA.debugLineNum = 134;BA.debugLine="If Result = DialogResponse.POSITIVE Then";
Debug.ShouldStop(32);
>>>>>>> Stashed changes
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
<<<<<<< Updated upstream
 BA.debugLineNum = 101;BA.debugLine="Log(\"File path: \" & fd.FilePath)";
Debug.ShouldStop(16);
<<<<<<< Updated upstream
parent.mostCurrent.__c.runVoidMethod ("LogImpl","2458761",RemoteObject.concat(RemoteObject.createImmutable("File path: "),_fd.runMethod(true,"getFilePath")),0);
 BA.debugLineNum = 102;BA.debugLine="Log(\"File name: \" & fd.ChosenName)";
Debug.ShouldStop(32);
parent.mostCurrent.__c.runVoidMethod ("LogImpl","2458762",RemoteObject.concat(RemoteObject.createImmutable("File name: "),_fd.runMethod(true,"getChosenName")),0);
=======
parent.mostCurrent.__c.runVoidMethod ("LogImpl","7458761",RemoteObject.concat(RemoteObject.createImmutable("File path: "),_fd.runMethod(true,"getFilePath")),0);
 BA.debugLineNum = 102;BA.debugLine="Log(\"File name: \" & fd.ChosenName)";
Debug.ShouldStop(32);
parent.mostCurrent.__c.runVoidMethod ("LogImpl","7458762",RemoteObject.concat(RemoteObject.createImmutable("File name: "),_fd.runMethod(true,"getChosenName")),0);
>>>>>>> Stashed changes
=======
 BA.debugLineNum = 135;BA.debugLine="Log(\"File path: \" & fd.FilePath)";
Debug.ShouldStop(64);
parent.mostCurrent.__c.runVoidMethod ("LogImpl","6458761",RemoteObject.concat(RemoteObject.createImmutable("File path: "),_fd.runMethod(true,"getFilePath")),0);
 BA.debugLineNum = 136;BA.debugLine="Log(\"File name: \" & fd.ChosenName)";
Debug.ShouldStop(128);
parent.mostCurrent.__c.runVoidMethod ("LogImpl","6458762",RemoteObject.concat(RemoteObject.createImmutable("File name: "),_fd.runMethod(true,"getChosenName")),0);
>>>>>>> Stashed changes
 if (true) break;

case 4:
//C
this.state = -1;
;
<<<<<<< Updated upstream
 BA.debugLineNum = 104;BA.debugLine="Label1.Text = \"Ruta = \" & fd.FilePath";
Debug.ShouldStop(128);
parent.mostCurrent._label1.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("Ruta = "),_fd.runMethod(true,"getFilePath"))));
 BA.debugLineNum = 105;BA.debugLine="Label2.Text = \"Archivo = \" & fd.ChosenName";
Debug.ShouldStop(256);
parent.mostCurrent._label2.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("Archivo = "),_fd.runMethod(true,"getChosenName"))));
 BA.debugLineNum = 106;BA.debugLine="archivo = fd.ChosenName";
Debug.ShouldStop(512);
parent.mostCurrent._archivo = _fd.runMethod(true,"getChosenName");
 BA.debugLineNum = 108;BA.debugLine="End Sub";
Debug.ShouldStop(2048);
=======
 BA.debugLineNum = 138;BA.debugLine="Label1.Text = \"Ruta = \" & fd.FilePath";
Debug.ShouldStop(512);
parent.mostCurrent._label1.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("Ruta = "),_fd.runMethod(true,"getFilePath"))));
 BA.debugLineNum = 139;BA.debugLine="Label2.Text = \"Archivo = \" & fd.ChosenName";
Debug.ShouldStop(1024);
parent.mostCurrent._label2.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("Archivo = "),_fd.runMethod(true,"getChosenName"))));
 BA.debugLineNum = 140;BA.debugLine="archivo = fd.ChosenName";
Debug.ShouldStop(2048);
parent.mostCurrent._archivo = _fd.runMethod(true,"getChosenName");
 BA.debugLineNum = 142;BA.debugLine="End Sub";
Debug.ShouldStop(8192);
>>>>>>> Stashed changes
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
public static RemoteObject  _er_click() throws Exception{
try {
		Debug.PushSubsStack("ER_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,173);
if (RapidSub.canDelegate("er_click")) { return b4a.example.main.remoteMe.runUserSub(false, "main","er_click");}
RemoteObject _sheet = RemoteObject.declareNull("de.donmanfred.XLSSheetwrapper");
RemoteObject _row = RemoteObject.declareNull("de.donmanfred.XSSFRowwrapper");
RemoteObject _cell = RemoteObject.declareNull("de.donmanfred.XSSFCellwrapper");
RemoteObject _texto1 = RemoteObject.createImmutable("");
 BA.debugLineNum = 173;BA.debugLine="Private Sub ER_Click";
Debug.ShouldStop(4096);
 BA.debugLineNum = 174;BA.debugLine="File.Copy(File.DirAssets,archivo,File.DirInternal";
Debug.ShouldStop(8192);
main.mostCurrent.__c.getField(false,"File").runVoidMethod ("Copy",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(main.mostCurrent._archivo),(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(main.mostCurrent._archivo));
 BA.debugLineNum = 175;BA.debugLine="xls.Initialize(\"\",File.Combine(File.DirInternal,a";
Debug.ShouldStop(16384);
main._xls.runVoidMethod ("Initialize",main.processBA,(Object)(BA.ObjectToString("")),(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"Combine",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(main.mostCurrent._archivo))));
 BA.debugLineNum = 176;BA.debugLine="Log($\"ActiveSheetIndex=${xls.ActiveSheetIndex}\"$)";
Debug.ShouldStop(32768);
main.mostCurrent.__c.runVoidMethod ("LogImpl","6589827",(RemoteObject.concat(RemoteObject.createImmutable("ActiveSheetIndex="),main.mostCurrent.__c.runMethod(true,"SmartStringFormatter",(Object)(BA.ObjectToString("")),(Object)((main._xls.runMethod(true,"getActiveSheetIndex")))),RemoteObject.createImmutable(""))),0);
 BA.debugLineNum = 177;BA.debugLine="Dim sheet As XLSSheet = xls.getSheetAt(xls.Active";
Debug.ShouldStop(65536);
_sheet = RemoteObject.createNew ("de.donmanfred.XLSSheetwrapper");
_sheet = main._xls.runMethod(false,"getSheetAt",(Object)(main._xls.runMethod(true,"getActiveSheetIndex")));Debug.locals.put("sheet", _sheet);Debug.locals.put("sheet", _sheet);
 BA.debugLineNum = 181;BA.debugLine="Activity.RemoveAllViews";
Debug.ShouldStop(1048576);
main.mostCurrent._activity.runVoidMethod ("RemoveAllViews");
 BA.debugLineNum = 182;BA.debugLine="Activity.LoadLayout(\"EstadoResultados\")";
Debug.ShouldStop(2097152);
main.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("EstadoResultados")),main.mostCurrent.activityBA);
 BA.debugLineNum = 183;BA.debugLine="Dim row As XSSFRow =sheet.getRow(0)";
Debug.ShouldStop(4194304);
_row = RemoteObject.createNew ("de.donmanfred.XSSFRowwrapper");
_row = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("de.donmanfred.XSSFRowwrapper"), _sheet.runMethod(false,"getRow",(Object)(BA.numberCast(int.class, 0))));Debug.locals.put("row", _row);Debug.locals.put("row", _row);
 BA.debugLineNum = 184;BA.debugLine="Dim Cell As XSSFCell =row.getCell(0)";
Debug.ShouldStop(8388608);
_cell = RemoteObject.createNew ("de.donmanfred.XSSFCellwrapper");
_cell = _row.runMethod(false,"getCell",(Object)(BA.numberCast(int.class, 0)));Debug.locals.put("Cell", _cell);Debug.locals.put("Cell", _cell);
 BA.debugLineNum = 186;BA.debugLine="Log(\"valor pelon:\"&Cell.RawValue)";
Debug.ShouldStop(33554432);
main.mostCurrent.__c.runVoidMethod ("LogImpl","6589837",RemoteObject.concat(RemoteObject.createImmutable("valor pelon:"),_cell.runMethod(true,"getRawValue")),0);
 BA.debugLineNum = 187;BA.debugLine="Dim Texto1 As String = NumberFormat2(0, 1, 2, 2,";
Debug.ShouldStop(67108864);
_texto1 = main.mostCurrent.__c.runMethod(true,"NumberFormat2",(Object)(BA.numberCast(double.class, 0)),(Object)(BA.numberCast(int.class, 1)),(Object)(BA.numberCast(int.class, 2)),(Object)(BA.numberCast(int.class, 2)),(Object)(main.mostCurrent.__c.getField(true,"False")));Debug.locals.put("Texto1", _texto1);Debug.locals.put("Texto1", _texto1);
 BA.debugLineNum = 188;BA.debugLine="Texto1 = Cell.StringCellValue";
Debug.ShouldStop(134217728);
_texto1 = _cell.runMethod(true,"getStringCellValue");Debug.locals.put("Texto1", _texto1);
 BA.debugLineNum = 189;BA.debugLine="Log(Cell.StringCellValue)";
Debug.ShouldStop(268435456);
main.mostCurrent.__c.runVoidMethod ("LogImpl","6589840",_cell.runMethod(true,"getStringCellValue"),0);
 BA.debugLineNum = 190;BA.debugLine="Concepto.text= Texto1";
Debug.ShouldStop(536870912);
main.mostCurrent._concepto.runMethod(true,"setText",BA.ObjectToCharSequence(_texto1));
 BA.debugLineNum = 191;BA.debugLine="Log(Concepto.text)";
Debug.ShouldStop(1073741824);
main.mostCurrent.__c.runVoidMethod ("LogImpl","6589842",main.mostCurrent._concepto.runMethod(true,"getText"),0);
 BA.debugLineNum = 193;BA.debugLine="row=sheet.getRow(1)";
Debug.ShouldStop(1);
_row = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("de.donmanfred.XSSFRowwrapper"), _sheet.runMethod(false,"getRow",(Object)(BA.numberCast(int.class, 1))));Debug.locals.put("row", _row);
 BA.debugLineNum = 194;BA.debugLine="Cell=row.getCell(0)";
Debug.ShouldStop(2);
_cell = _row.runMethod(false,"getCell",(Object)(BA.numberCast(int.class, 0)));Debug.locals.put("Cell", _cell);
 BA.debugLineNum = 195;BA.debugLine="Texto1 = Cell.StringCellValue";
Debug.ShouldStop(4);
_texto1 = _cell.runMethod(true,"getStringCellValue");Debug.locals.put("Texto1", _texto1);
 BA.debugLineNum = 196;BA.debugLine="Log(Cell.StringCellValue)";
Debug.ShouldStop(8);
main.mostCurrent.__c.runVoidMethod ("LogImpl","6589847",_cell.runMethod(true,"getStringCellValue"),0);
 BA.debugLineNum = 197;BA.debugLine="Concepto1.text= Texto1";
Debug.ShouldStop(16);
main.mostCurrent._concepto1.runMethod(true,"setText",BA.ObjectToCharSequence(_texto1));
 BA.debugLineNum = 199;BA.debugLine="row=sheet.getRow(2)";
Debug.ShouldStop(64);
_row = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("de.donmanfred.XSSFRowwrapper"), _sheet.runMethod(false,"getRow",(Object)(BA.numberCast(int.class, 2))));Debug.locals.put("row", _row);
 BA.debugLineNum = 200;BA.debugLine="Cell=row.getCell(0)";
Debug.ShouldStop(128);
_cell = _row.runMethod(false,"getCell",(Object)(BA.numberCast(int.class, 0)));Debug.locals.put("Cell", _cell);
 BA.debugLineNum = 201;BA.debugLine="Texto1 = Cell.StringCellValue";
Debug.ShouldStop(256);
_texto1 = _cell.runMethod(true,"getStringCellValue");Debug.locals.put("Texto1", _texto1);
 BA.debugLineNum = 202;BA.debugLine="Log(Cell.StringCellValue)";
Debug.ShouldStop(512);
main.mostCurrent.__c.runVoidMethod ("LogImpl","6589853",_cell.runMethod(true,"getStringCellValue"),0);
 BA.debugLineNum = 203;BA.debugLine="Concepto2.text= Texto1";
Debug.ShouldStop(1024);
main.mostCurrent._concepto2.runMethod(true,"setText",BA.ObjectToCharSequence(_texto1));
 BA.debugLineNum = 205;BA.debugLine="row=sheet.getRow(3)";
Debug.ShouldStop(4096);
_row = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("de.donmanfred.XSSFRowwrapper"), _sheet.runMethod(false,"getRow",(Object)(BA.numberCast(int.class, 3))));Debug.locals.put("row", _row);
 BA.debugLineNum = 206;BA.debugLine="Cell=row.getCell(0)";
Debug.ShouldStop(8192);
_cell = _row.runMethod(false,"getCell",(Object)(BA.numberCast(int.class, 0)));Debug.locals.put("Cell", _cell);
 BA.debugLineNum = 207;BA.debugLine="Texto1 = Cell.StringCellValue";
Debug.ShouldStop(16384);
_texto1 = _cell.runMethod(true,"getStringCellValue");Debug.locals.put("Texto1", _texto1);
 BA.debugLineNum = 208;BA.debugLine="Log(Cell.StringCellValue)";
Debug.ShouldStop(32768);
main.mostCurrent.__c.runVoidMethod ("LogImpl","6589859",_cell.runMethod(true,"getStringCellValue"),0);
 BA.debugLineNum = 209;BA.debugLine="Concepto3.text= Texto1";
Debug.ShouldStop(65536);
main.mostCurrent._concepto3.runMethod(true,"setText",BA.ObjectToCharSequence(_texto1));
 BA.debugLineNum = 211;BA.debugLine="row=sheet.getRow(4)";
Debug.ShouldStop(262144);
_row = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("de.donmanfred.XSSFRowwrapper"), _sheet.runMethod(false,"getRow",(Object)(BA.numberCast(int.class, 4))));Debug.locals.put("row", _row);
 BA.debugLineNum = 212;BA.debugLine="Cell=row.getCell(0)";
Debug.ShouldStop(524288);
_cell = _row.runMethod(false,"getCell",(Object)(BA.numberCast(int.class, 0)));Debug.locals.put("Cell", _cell);
 BA.debugLineNum = 213;BA.debugLine="Texto1 = Cell.StringCellValue";
Debug.ShouldStop(1048576);
_texto1 = _cell.runMethod(true,"getStringCellValue");Debug.locals.put("Texto1", _texto1);
 BA.debugLineNum = 214;BA.debugLine="Log(Cell.StringCellValue)";
Debug.ShouldStop(2097152);
main.mostCurrent.__c.runVoidMethod ("LogImpl","6589865",_cell.runMethod(true,"getStringCellValue"),0);
 BA.debugLineNum = 215;BA.debugLine="Concepto4.text= Texto1";
Debug.ShouldStop(4194304);
main.mostCurrent._concepto4.runMethod(true,"setText",BA.ObjectToCharSequence(_texto1));
 BA.debugLineNum = 217;BA.debugLine="row=sheet.getRow(5)";
Debug.ShouldStop(16777216);
_row = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("de.donmanfred.XSSFRowwrapper"), _sheet.runMethod(false,"getRow",(Object)(BA.numberCast(int.class, 5))));Debug.locals.put("row", _row);
 BA.debugLineNum = 218;BA.debugLine="Cell=row.getCell(0)";
Debug.ShouldStop(33554432);
_cell = _row.runMethod(false,"getCell",(Object)(BA.numberCast(int.class, 0)));Debug.locals.put("Cell", _cell);
 BA.debugLineNum = 219;BA.debugLine="Texto1 = Cell.StringCellValue";
Debug.ShouldStop(67108864);
_texto1 = _cell.runMethod(true,"getStringCellValue");Debug.locals.put("Texto1", _texto1);
 BA.debugLineNum = 220;BA.debugLine="Log(Cell.StringCellValue)";
Debug.ShouldStop(134217728);
main.mostCurrent.__c.runVoidMethod ("LogImpl","6589871",_cell.runMethod(true,"getStringCellValue"),0);
 BA.debugLineNum = 221;BA.debugLine="Concepto5.text= Texto1";
Debug.ShouldStop(268435456);
main.mostCurrent._concepto5.runMethod(true,"setText",BA.ObjectToCharSequence(_texto1));
 BA.debugLineNum = 223;BA.debugLine="row=sheet.getRow(6)";
Debug.ShouldStop(1073741824);
_row = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("de.donmanfred.XSSFRowwrapper"), _sheet.runMethod(false,"getRow",(Object)(BA.numberCast(int.class, 6))));Debug.locals.put("row", _row);
 BA.debugLineNum = 224;BA.debugLine="Cell=row.getCell(0)";
Debug.ShouldStop(-2147483648);
_cell = _row.runMethod(false,"getCell",(Object)(BA.numberCast(int.class, 0)));Debug.locals.put("Cell", _cell);
 BA.debugLineNum = 225;BA.debugLine="Texto1 = Cell.StringCellValue";
Debug.ShouldStop(1);
_texto1 = _cell.runMethod(true,"getStringCellValue");Debug.locals.put("Texto1", _texto1);
 BA.debugLineNum = 226;BA.debugLine="Log(Cell.StringCellValue)";
Debug.ShouldStop(2);
main.mostCurrent.__c.runVoidMethod ("LogImpl","6589877",_cell.runMethod(true,"getStringCellValue"),0);
 BA.debugLineNum = 227;BA.debugLine="Concepto6.text= Texto1";
Debug.ShouldStop(4);
main.mostCurrent._concepto6.runMethod(true,"setText",BA.ObjectToCharSequence(_texto1));
 BA.debugLineNum = 229;BA.debugLine="row=sheet.getRow(7)";
Debug.ShouldStop(16);
_row = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("de.donmanfred.XSSFRowwrapper"), _sheet.runMethod(false,"getRow",(Object)(BA.numberCast(int.class, 7))));Debug.locals.put("row", _row);
 BA.debugLineNum = 230;BA.debugLine="Cell=row.getCell(0)";
Debug.ShouldStop(32);
_cell = _row.runMethod(false,"getCell",(Object)(BA.numberCast(int.class, 0)));Debug.locals.put("Cell", _cell);
 BA.debugLineNum = 231;BA.debugLine="Texto1 = Cell.StringCellValue";
Debug.ShouldStop(64);
_texto1 = _cell.runMethod(true,"getStringCellValue");Debug.locals.put("Texto1", _texto1);
 BA.debugLineNum = 232;BA.debugLine="Log(Cell.StringCellValue)";
Debug.ShouldStop(128);
main.mostCurrent.__c.runVoidMethod ("LogImpl","6589883",_cell.runMethod(true,"getStringCellValue"),0);
 BA.debugLineNum = 233;BA.debugLine="Concepto7.text= Texto1";
Debug.ShouldStop(256);
main.mostCurrent._concepto7.runMethod(true,"setText",BA.ObjectToCharSequence(_texto1));
 BA.debugLineNum = 235;BA.debugLine="row=sheet.getRow(0)";
Debug.ShouldStop(1024);
_row = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("de.donmanfred.XSSFRowwrapper"), _sheet.runMethod(false,"getRow",(Object)(BA.numberCast(int.class, 0))));Debug.locals.put("row", _row);
 BA.debugLineNum = 236;BA.debugLine="Cell=row.getCell(2)";
Debug.ShouldStop(2048);
_cell = _row.runMethod(false,"getCell",(Object)(BA.numberCast(int.class, 2)));Debug.locals.put("Cell", _cell);
 BA.debugLineNum = 237;BA.debugLine="Texto1 = Cell.StringCellValue";
Debug.ShouldStop(4096);
_texto1 = _cell.runMethod(true,"getStringCellValue");Debug.locals.put("Texto1", _texto1);
 BA.debugLineNum = 238;BA.debugLine="Log(Cell.StringCellValue)";
Debug.ShouldStop(8192);
main.mostCurrent.__c.runVoidMethod ("LogImpl","6589889",_cell.runMethod(true,"getStringCellValue"),0);
 BA.debugLineNum = 239;BA.debugLine="Datos.text= Texto1";
Debug.ShouldStop(16384);
main.mostCurrent._datos.runMethod(true,"setText",BA.ObjectToCharSequence(_texto1));
 BA.debugLineNum = 241;BA.debugLine="row=sheet.getRow(1)";
Debug.ShouldStop(65536);
_row = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("de.donmanfred.XSSFRowwrapper"), _sheet.runMethod(false,"getRow",(Object)(BA.numberCast(int.class, 1))));Debug.locals.put("row", _row);
 BA.debugLineNum = 242;BA.debugLine="Cell=row.getCell(2)";
Debug.ShouldStop(131072);
_cell = _row.runMethod(false,"getCell",(Object)(BA.numberCast(int.class, 2)));Debug.locals.put("Cell", _cell);
 BA.debugLineNum = 243;BA.debugLine="Texto1 = formatter.Format(Cell.NumericCellValue)";
Debug.ShouldStop(262144);
_texto1 = main._formatter.runClassMethod (b4a.example.b4xformatter.class, "_format" /*RemoteObject*/ ,(Object)(_cell.runMethod(true,"getNumericCellValue")));Debug.locals.put("Texto1", _texto1);
 BA.debugLineNum = 244;BA.debugLine="Log(Cell.NumericCellValue)";
Debug.ShouldStop(524288);
main.mostCurrent.__c.runVoidMethod ("LogImpl","6589895",BA.NumberToString(_cell.runMethod(true,"getNumericCellValue")),0);
 BA.debugLineNum = 245;BA.debugLine="Datos1.text= Texto1";
Debug.ShouldStop(1048576);
main.mostCurrent._datos1.runMethod(true,"setText",BA.ObjectToCharSequence(_texto1));
 BA.debugLineNum = 247;BA.debugLine="row=sheet.getRow(2)";
Debug.ShouldStop(4194304);
_row = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("de.donmanfred.XSSFRowwrapper"), _sheet.runMethod(false,"getRow",(Object)(BA.numberCast(int.class, 2))));Debug.locals.put("row", _row);
 BA.debugLineNum = 248;BA.debugLine="Cell=row.getCell(2)";
Debug.ShouldStop(8388608);
_cell = _row.runMethod(false,"getCell",(Object)(BA.numberCast(int.class, 2)));Debug.locals.put("Cell", _cell);
 BA.debugLineNum = 249;BA.debugLine="Texto1 = formatter.Format(Cell.NumericCellValue)";
Debug.ShouldStop(16777216);
_texto1 = main._formatter.runClassMethod (b4a.example.b4xformatter.class, "_format" /*RemoteObject*/ ,(Object)(_cell.runMethod(true,"getNumericCellValue")));Debug.locals.put("Texto1", _texto1);
 BA.debugLineNum = 250;BA.debugLine="Log(formatter.Format(Cell.NumericCellValue))";
Debug.ShouldStop(33554432);
main.mostCurrent.__c.runVoidMethod ("LogImpl","6589901",main._formatter.runClassMethod (b4a.example.b4xformatter.class, "_format" /*RemoteObject*/ ,(Object)(_cell.runMethod(true,"getNumericCellValue"))),0);
 BA.debugLineNum = 251;BA.debugLine="Datos2.text= Texto1";
Debug.ShouldStop(67108864);
main.mostCurrent._datos2.runMethod(true,"setText",BA.ObjectToCharSequence(_texto1));
 BA.debugLineNum = 253;BA.debugLine="row=sheet.getRow(3)";
Debug.ShouldStop(268435456);
_row = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("de.donmanfred.XSSFRowwrapper"), _sheet.runMethod(false,"getRow",(Object)(BA.numberCast(int.class, 3))));Debug.locals.put("row", _row);
 BA.debugLineNum = 254;BA.debugLine="Cell=row.getCell(2)";
Debug.ShouldStop(536870912);
_cell = _row.runMethod(false,"getCell",(Object)(BA.numberCast(int.class, 2)));Debug.locals.put("Cell", _cell);
 BA.debugLineNum = 255;BA.debugLine="Texto1 = formatter.Format(Cell.NumericCellValue)";
Debug.ShouldStop(1073741824);
_texto1 = main._formatter.runClassMethod (b4a.example.b4xformatter.class, "_format" /*RemoteObject*/ ,(Object)(_cell.runMethod(true,"getNumericCellValue")));Debug.locals.put("Texto1", _texto1);
 BA.debugLineNum = 256;BA.debugLine="Log(formatter.Format(Cell.NumericCellValue))";
Debug.ShouldStop(-2147483648);
main.mostCurrent.__c.runVoidMethod ("LogImpl","6589907",main._formatter.runClassMethod (b4a.example.b4xformatter.class, "_format" /*RemoteObject*/ ,(Object)(_cell.runMethod(true,"getNumericCellValue"))),0);
 BA.debugLineNum = 257;BA.debugLine="Datos3.text= Texto1";
Debug.ShouldStop(1);
main.mostCurrent._datos3.runMethod(true,"setText",BA.ObjectToCharSequence(_texto1));
 BA.debugLineNum = 259;BA.debugLine="row=sheet.getRow(4)";
Debug.ShouldStop(4);
_row = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("de.donmanfred.XSSFRowwrapper"), _sheet.runMethod(false,"getRow",(Object)(BA.numberCast(int.class, 4))));Debug.locals.put("row", _row);
 BA.debugLineNum = 260;BA.debugLine="Cell=row.getCell(2)";
Debug.ShouldStop(8);
_cell = _row.runMethod(false,"getCell",(Object)(BA.numberCast(int.class, 2)));Debug.locals.put("Cell", _cell);
 BA.debugLineNum = 261;BA.debugLine="Texto1 = formatter.Format(Cell.NumericCellValue)";
Debug.ShouldStop(16);
_texto1 = main._formatter.runClassMethod (b4a.example.b4xformatter.class, "_format" /*RemoteObject*/ ,(Object)(_cell.runMethod(true,"getNumericCellValue")));Debug.locals.put("Texto1", _texto1);
 BA.debugLineNum = 262;BA.debugLine="Log(formatter.Format(Cell.NumericCellValue))";
Debug.ShouldStop(32);
main.mostCurrent.__c.runVoidMethod ("LogImpl","6589913",main._formatter.runClassMethod (b4a.example.b4xformatter.class, "_format" /*RemoteObject*/ ,(Object)(_cell.runMethod(true,"getNumericCellValue"))),0);
 BA.debugLineNum = 263;BA.debugLine="Datos4.text= Texto1";
Debug.ShouldStop(64);
main.mostCurrent._datos4.runMethod(true,"setText",BA.ObjectToCharSequence(_texto1));
 BA.debugLineNum = 265;BA.debugLine="row=sheet.getRow(5)";
Debug.ShouldStop(256);
_row = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("de.donmanfred.XSSFRowwrapper"), _sheet.runMethod(false,"getRow",(Object)(BA.numberCast(int.class, 5))));Debug.locals.put("row", _row);
 BA.debugLineNum = 266;BA.debugLine="Cell=row.getCell(2)";
Debug.ShouldStop(512);
_cell = _row.runMethod(false,"getCell",(Object)(BA.numberCast(int.class, 2)));Debug.locals.put("Cell", _cell);
 BA.debugLineNum = 267;BA.debugLine="Texto1 = formatter.Format(Cell.NumericCellValue)";
Debug.ShouldStop(1024);
_texto1 = main._formatter.runClassMethod (b4a.example.b4xformatter.class, "_format" /*RemoteObject*/ ,(Object)(_cell.runMethod(true,"getNumericCellValue")));Debug.locals.put("Texto1", _texto1);
 BA.debugLineNum = 268;BA.debugLine="Log(formatter.Format(Cell.NumericCellValue))";
Debug.ShouldStop(2048);
main.mostCurrent.__c.runVoidMethod ("LogImpl","6589919",main._formatter.runClassMethod (b4a.example.b4xformatter.class, "_format" /*RemoteObject*/ ,(Object)(_cell.runMethod(true,"getNumericCellValue"))),0);
 BA.debugLineNum = 269;BA.debugLine="Datos5.text= Texto1";
Debug.ShouldStop(4096);
main.mostCurrent._datos5.runMethod(true,"setText",BA.ObjectToCharSequence(_texto1));
 BA.debugLineNum = 271;BA.debugLine="row=sheet.getRow(6)";
Debug.ShouldStop(16384);
_row = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("de.donmanfred.XSSFRowwrapper"), _sheet.runMethod(false,"getRow",(Object)(BA.numberCast(int.class, 6))));Debug.locals.put("row", _row);
 BA.debugLineNum = 272;BA.debugLine="Cell=row.getCell(2)";
Debug.ShouldStop(32768);
_cell = _row.runMethod(false,"getCell",(Object)(BA.numberCast(int.class, 2)));Debug.locals.put("Cell", _cell);
 BA.debugLineNum = 273;BA.debugLine="Texto1 = formatter.Format(Cell.NumericCellValue)";
Debug.ShouldStop(65536);
_texto1 = main._formatter.runClassMethod (b4a.example.b4xformatter.class, "_format" /*RemoteObject*/ ,(Object)(_cell.runMethod(true,"getNumericCellValue")));Debug.locals.put("Texto1", _texto1);
 BA.debugLineNum = 274;BA.debugLine="Log(formatter.Format(Cell.NumericCellValue))";
Debug.ShouldStop(131072);
main.mostCurrent.__c.runVoidMethod ("LogImpl","6589925",main._formatter.runClassMethod (b4a.example.b4xformatter.class, "_format" /*RemoteObject*/ ,(Object)(_cell.runMethod(true,"getNumericCellValue"))),0);
 BA.debugLineNum = 275;BA.debugLine="Datos6.text= Texto1";
Debug.ShouldStop(262144);
main.mostCurrent._datos6.runMethod(true,"setText",BA.ObjectToCharSequence(_texto1));
 BA.debugLineNum = 277;BA.debugLine="row=sheet.getRow(7)";
Debug.ShouldStop(1048576);
_row = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("de.donmanfred.XSSFRowwrapper"), _sheet.runMethod(false,"getRow",(Object)(BA.numberCast(int.class, 7))));Debug.locals.put("row", _row);
 BA.debugLineNum = 278;BA.debugLine="Cell=row.getCell(2)";
Debug.ShouldStop(2097152);
_cell = _row.runMethod(false,"getCell",(Object)(BA.numberCast(int.class, 2)));Debug.locals.put("Cell", _cell);
 BA.debugLineNum = 279;BA.debugLine="Texto1 = formatter.Format(Cell.NumericCellValue)";
Debug.ShouldStop(4194304);
_texto1 = main._formatter.runClassMethod (b4a.example.b4xformatter.class, "_format" /*RemoteObject*/ ,(Object)(_cell.runMethod(true,"getNumericCellValue")));Debug.locals.put("Texto1", _texto1);
 BA.debugLineNum = 280;BA.debugLine="Log(formatter.Format(Cell.NumericCellValue))";
Debug.ShouldStop(8388608);
main.mostCurrent.__c.runVoidMethod ("LogImpl","6589931",main._formatter.runClassMethod (b4a.example.b4xformatter.class, "_format" /*RemoteObject*/ ,(Object)(_cell.runMethod(true,"getNumericCellValue"))),0);
 BA.debugLineNum = 281;BA.debugLine="Datos7.text= Texto1";
Debug.ShouldStop(16777216);
main.mostCurrent._datos7.runMethod(true,"setText",BA.ObjectToCharSequence(_texto1));
 BA.debugLineNum = 282;BA.debugLine="End Sub";
Debug.ShouldStop(33554432);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _globals() throws Exception{
<<<<<<< Updated upstream
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
<<<<<<< Updated upstream
=======
 //BA.debugLineNum = 40;BA.debugLine="Usuario = Nombre.Text";
main.mostCurrent._usuario = main.mostCurrent._nombre.runMethod(true,"getText");
>>>>>>> Stashed changes
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
 //BA.debugLineNum = 50;BA.debugLine="Private Concepto As Label";
main.mostCurrent._concepto = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 51;BA.debugLine="Private Concepto1 As Label";
main.mostCurrent._concepto1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 52;BA.debugLine="Private Concepto2 As Label";
main.mostCurrent._concepto2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 53;BA.debugLine="Private Concepto3 As Label";
main.mostCurrent._concepto3 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 54;BA.debugLine="Private Concepto4 As Label";
main.mostCurrent._concepto4 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 55;BA.debugLine="Private Concepto5 As Label";
main.mostCurrent._concepto5 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 56;BA.debugLine="Private Concepto6 As Label";
main.mostCurrent._concepto6 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 57;BA.debugLine="Private Concepto7 As Label";
main.mostCurrent._concepto7 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 58;BA.debugLine="End Sub";
=======
 //BA.debugLineNum = 30;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 33;BA.debugLine="Private INICIAR As Button";
main.mostCurrent._iniciar = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 35;BA.debugLine="Private info As Button";
main.mostCurrent._info = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 36;BA.debugLine="Dim Usuario As String";
main.mostCurrent._usuario = RemoteObject.createImmutable("");
 //BA.debugLineNum = 37;BA.debugLine="Dim archivo As String";
main.mostCurrent._archivo = RemoteObject.createImmutable("");
 //BA.debugLineNum = 38;BA.debugLine="Dim path As String";
main.mostCurrent._path = RemoteObject.createImmutable("");
 //BA.debugLineNum = 41;BA.debugLine="Private Nombre As EditText";
main.mostCurrent._nombre = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 43;BA.debugLine="Usuario = Nombre";
main.mostCurrent._usuario = BA.ObjectToString(main.mostCurrent._nombre);
 //BA.debugLineNum = 45;BA.debugLine="Dim Ingresos As Button";
main.mostCurrent._ingresos = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 46;BA.debugLine="Dim Gadm As Float";
main._gadm = RemoteObject.createImmutable(0f);
 //BA.debugLineNum = 47;BA.debugLine="Dim GOp As Float";
main._gop = RemoteObject.createImmutable(0f);
 //BA.debugLineNum = 48;BA.debugLine="Dim Ingresos_ As Float";
main._ingresos_ = RemoteObject.createImmutable(0f);
 //BA.debugLineNum = 49;BA.debugLine="Private mbc1 As BarChart";
main.mostCurrent._mbc1 = RemoteObject.createNew ("mpandroidchartwrapper.barChartWrapper");
 //BA.debugLineNum = 52;BA.debugLine="Private HiUsuario As Label";
main.mostCurrent._hiusuario = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 54;BA.debugLine="Private Boton As Button";
main.mostCurrent._boton = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 56;BA.debugLine="Private Label1 As Label";
main.mostCurrent._label1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 57;BA.debugLine="Private Label2 As Label";
main.mostCurrent._label2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 58;BA.debugLine="Private Analisis As Button";
main.mostCurrent._analisis = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 59;BA.debugLine="Private Concepto As Label";
main.mostCurrent._concepto = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 60;BA.debugLine="Private Concepto1 As Label";
main.mostCurrent._concepto1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 61;BA.debugLine="Private Concepto2 As Label";
main.mostCurrent._concepto2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 62;BA.debugLine="Private Concepto3 As Label";
main.mostCurrent._concepto3 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 63;BA.debugLine="Private Concepto4 As Label";
main.mostCurrent._concepto4 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 64;BA.debugLine="Private Concepto5 As Label";
main.mostCurrent._concepto5 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 65;BA.debugLine="Private Concepto6 As Label";
main.mostCurrent._concepto6 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 66;BA.debugLine="Private Concepto7 As Label";
main.mostCurrent._concepto7 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 67;BA.debugLine="Private Datos As Label";
main.mostCurrent._datos = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 68;BA.debugLine="Private Datos1 As Label";
main.mostCurrent._datos1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 69;BA.debugLine="Private Datos2 As Label";
main.mostCurrent._datos2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 70;BA.debugLine="Private Datos3 As Label";
main.mostCurrent._datos3 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 71;BA.debugLine="Private Datos4 As Label";
main.mostCurrent._datos4 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 72;BA.debugLine="Private Datos5 As Label";
main.mostCurrent._datos5 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 73;BA.debugLine="Private Datos6 As Label";
main.mostCurrent._datos6 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 74;BA.debugLine="Private Datos7 As Label";
main.mostCurrent._datos7 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 75;BA.debugLine="Private ER As Button";
main.mostCurrent._er = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 76;BA.debugLine="Private Panel1 As Panel";
main.mostCurrent._panel1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 77;BA.debugLine="Private Panel2 As Panel";
main.mostCurrent._panel2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 78;BA.debugLine="Private Nómina As Button";
main.mostCurrent._nómina = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 79;BA.debugLine="End Sub";
>>>>>>> Stashed changes
return RemoteObject.createImmutable("");
}
public static RemoteObject  _info_click() throws Exception{
try {
<<<<<<< Updated upstream
		Debug.PushSubsStack("info_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,86);
if (RapidSub.canDelegate("info_click")) { return b4a.example.main.remoteMe.runUserSub(false, "main","info_click");}
 BA.debugLineNum = 86;BA.debugLine="Private Sub info_Click";
Debug.ShouldStop(2097152);
 BA.debugLineNum = 87;BA.debugLine="MsgboxAsync(\"Recuerda verificar que el archivo ele";
Debug.ShouldStop(4194304);
main.mostCurrent.__c.runVoidMethod ("MsgboxAsync",(Object)(BA.ObjectToCharSequence("Recuerda verificar que el archivo elegido es el correcto")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("INFORMACIÓN"))),main.processBA);
 BA.debugLineNum = 90;BA.debugLine="End Sub";
Debug.ShouldStop(33554432);
=======
		Debug.PushSubsStack("info_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,120);
if (RapidSub.canDelegate("info_click")) { return b4a.example.main.remoteMe.runUserSub(false, "main","info_click");}
 BA.debugLineNum = 120;BA.debugLine="Private Sub info_Click";
Debug.ShouldStop(8388608);
 BA.debugLineNum = 121;BA.debugLine="MsgboxAsync(\"Recuerda verificar que el archivo ele";
Debug.ShouldStop(16777216);
main.mostCurrent.__c.runVoidMethod ("MsgboxAsync",(Object)(BA.ObjectToCharSequence("Recuerda verificar que el archivo elegido es el correcto")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("INFORMACIÓN"))),main.processBA);
 BA.debugLineNum = 124;BA.debugLine="End Sub";
Debug.ShouldStop(134217728);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _ingresos_click() throws Exception{
try {
		Debug.PushSubsStack("Ingresos_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,290);
if (RapidSub.canDelegate("ingresos_click")) { return b4a.example.main.remoteMe.runUserSub(false, "main","ingresos_click");}
 BA.debugLineNum = 290;BA.debugLine="Private Sub Ingresos_Click";
Debug.ShouldStop(2);
 BA.debugLineNum = 291;BA.debugLine="Activity.LoadLayout(\"Ingresos_gastos\")";
Debug.ShouldStop(4);
main.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("Ingresos_gastos")),main.mostCurrent.activityBA);
 BA.debugLineNum = 298;BA.debugLine="mbc1.LegendShapeSize = 7.0	    'this line of code";
Debug.ShouldStop(512);
main.mostCurrent._mbc1.runVoidMethod ("setLegendShapeSize",BA.numberCast(float.class, 7.0));
 BA.debugLineNum = 299;BA.debugLine="mbc1.setTheLegendPositionAndForm(\"BELOW_CHART_CEN";
Debug.ShouldStop(1024);
main.mostCurrent._mbc1.runVoidMethod ("setTheLegendPositionAndForm",(Object)(BA.ObjectToString("BELOW_CHART_CENTER")),(Object)(RemoteObject.createImmutable("CIRCLE")));
 BA.debugLineNum = 301;BA.debugLine="mbc1.TheLegendColor = Colors.Gray";
Debug.ShouldStop(4096);
main.mostCurrent._mbc1.runVoidMethod ("setTheLegendColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"Gray"));
 BA.debugLineNum = 302;BA.debugLine="mbc1.TheLegendTextSize = 20.0";
Debug.ShouldStop(8192);
main.mostCurrent._mbc1.runVoidMethod ("setTheLegendTextSize",BA.numberCast(float.class, 20.0));
 BA.debugLineNum = 303;BA.debugLine="mbc1.LegendTitle = \"\"";
Debug.ShouldStop(16384);
main.mostCurrent._mbc1.runVoidMethod ("setLegendTitle",BA.ObjectToString(""));
 BA.debugLineNum = 305;BA.debugLine="mbc1.ChartDescription = \"TITLE : INGRESOS VS GAST";
Debug.ShouldStop(65536);
main.mostCurrent._mbc1.runVoidMethod ("setChartDescription",BA.ObjectToString("TITLE : INGRESOS VS GASTOS"));
 BA.debugLineNum = 306;BA.debugLine="mbc1.ChartDescriptionColor = 0XFFFFA500";
Debug.ShouldStop(131072);
main.mostCurrent._mbc1.runVoidMethod ("setChartDescriptionColor",BA.numberCast(int.class, ((int)0xffffa500)));
 BA.debugLineNum = 307;BA.debugLine="mbc1.ChartDescriptionTextSize = 19";
Debug.ShouldStop(262144);
main.mostCurrent._mbc1.runVoidMethod ("setChartDescriptionTextSize",BA.numberCast(float.class, 19));
 BA.debugLineNum = 309;BA.debugLine="mbc1.ValueTextColor = Colors.Black";
Debug.ShouldStop(1048576);
main.mostCurrent._mbc1.runVoidMethod ("setValueTextColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"Black"));
 BA.debugLineNum = 310;BA.debugLine="mbc1.ValueTextSize = 10.0";
Debug.ShouldStop(2097152);
main.mostCurrent._mbc1.runVoidMethod ("setValueTextSize",BA.numberCast(int.class, 10.0));
 BA.debugLineNum = 313;BA.debugLine="mbc1.BarColors = Array As Int(Colors.Blue, Colors";
Debug.ShouldStop(16777216);
main.mostCurrent._mbc1.runVoidMethod ("setBarColors",RemoteObject.createNewArray("int",new int[] {12},new Object[] {main.mostCurrent.__c.getField(false,"Colors").getField(true,"Blue"),main.mostCurrent.__c.getField(false,"Colors").getField(true,"Yellow"),main.mostCurrent.__c.getField(false,"Colors").getField(true,"Green"),main.mostCurrent.__c.getField(false,"Colors").getField(true,"Red"),main.mostCurrent.__c.getField(false,"Colors").getField(true,"Magenta"),main.mostCurrent.__c.getField(false,"Colors").getField(true,"Cyan"),main.mostCurrent.__c.getField(false,"Colors").getField(true,"Blue"),main.mostCurrent.__c.getField(false,"Colors").getField(true,"Yellow"),main.mostCurrent.__c.getField(false,"Colors").getField(true,"Green"),main.mostCurrent.__c.getField(false,"Colors").getField(true,"Red"),main.mostCurrent.__c.getField(false,"Colors").getField(true,"Magenta"),main.mostCurrent.__c.getField(false,"Colors").getField(true,"Cyan")}));
 BA.debugLineNum = 314;BA.debugLine="mbc1.LegendText = Array As String(\"Ingresos\", \"G,";
Debug.ShouldStop(33554432);
main.mostCurrent._mbc1.runVoidMethod ("setLegendText",RemoteObject.createNewArray("String",new int[] {3},new Object[] {BA.ObjectToString("Ingresos"),BA.ObjectToString("G,Operacionales"),RemoteObject.createImmutable("G. Administrativos")}));
 BA.debugLineNum = 315;BA.debugLine="mbc1.ChartData = Array As Float (Ingresos_, Gadm,";
Debug.ShouldStop(67108864);
main.mostCurrent._mbc1.runVoidMethod ("setChartData",RemoteObject.createNewArray("float",new int[] {3},new Object[] {main._ingresos_,main._gadm,main._gop}));
 BA.debugLineNum = 317;BA.debugLine="mbc1.DoubleTapToZoomEnabled = True";
Debug.ShouldStop(268435456);
main.mostCurrent._mbc1.runVoidMethod ("setDoubleTapToZoomEnabled",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 318;BA.debugLine="mbc1.DrawBarShadow = False";
Debug.ShouldStop(536870912);
main.mostCurrent._mbc1.runVoidMethod ("setDrawBarShadow",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 319;BA.debugLine="mbc1.GridBackgroundColor = Colors.white";
Debug.ShouldStop(1073741824);
main.mostCurrent._mbc1.runVoidMethod ("setGridBackgroundColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"White"));
 BA.debugLineNum = 320;BA.debugLine="mbc1.ValueTextColor = 0XFFFFA500";
Debug.ShouldStop(-2147483648);
main.mostCurrent._mbc1.runVoidMethod ("setValueTextColor",BA.numberCast(int.class, ((int)0xffffa500)));
 BA.debugLineNum = 321;BA.debugLine="mbc1.DrawBorders = True";
Debug.ShouldStop(1);
main.mostCurrent._mbc1.runVoidMethod ("setDrawBorders",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 322;BA.debugLine="mbc1.DrawGridBackground = True";
Debug.ShouldStop(2);
main.mostCurrent._mbc1.runVoidMethod ("setDrawGridBackground",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 323;BA.debugLine="mbc1.DrawHighlightArrow = True";
Debug.ShouldStop(4);
main.mostCurrent._mbc1.runVoidMethod ("setDrawHighlightArrow",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 324;BA.debugLine="mbc1.DrawValueAboveBar = True";
Debug.ShouldStop(8);
main.mostCurrent._mbc1.runVoidMethod ("setDrawValueAboveBar",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 325;BA.debugLine="mbc1.PinchZoom = True";
Debug.ShouldStop(16);
main.mostCurrent._mbc1.runVoidMethod ("setPinchZoom",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 326;BA.debugLine="mbc1.ScaleEnabled = True";
Debug.ShouldStop(32);
main.mostCurrent._mbc1.runVoidMethod ("setScaleEnabled",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 327;BA.debugLine="mbc1.BorderColor = Colors.Blue";
Debug.ShouldStop(64);
main.mostCurrent._mbc1.runVoidMethod ("setBorderColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"Blue"));
 BA.debugLineNum = 328;BA.debugLine="mbc1.BorderWidth = 3.0";
Debug.ShouldStop(128);
main.mostCurrent._mbc1.runVoidMethod ("setBorderWidth",BA.numberCast(float.class, 3.0));
 BA.debugLineNum = 330;BA.debugLine="mbc1.BarData = 3   'this number must be the same";
Debug.ShouldStop(512);
main.mostCurrent._mbc1.runVoidMethod ("setBarData",BA.numberCast(int.class, 3));
 BA.debugLineNum = 332;BA.debugLine="End Sub";
Debug.ShouldStop(2048);
>>>>>>> Stashed changes
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
<<<<<<< Updated upstream
		Debug.PushSubsStack("INICIAR_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,77);
if (RapidSub.canDelegate("iniciar_click")) { return b4a.example.main.remoteMe.runUserSub(false, "main","iniciar_click");}
 BA.debugLineNum = 77;BA.debugLine="Private Sub INICIAR_Click";
Debug.ShouldStop(4096);
 BA.debugLineNum = 78;BA.debugLine="Usuario = Nombre.Text";
Debug.ShouldStop(8192);
main.mostCurrent._usuario = main.mostCurrent._nombre.runMethod(true,"getText");
 BA.debugLineNum = 79;BA.debugLine="Activity.RemoveAllViews";
Debug.ShouldStop(16384);
main.mostCurrent._activity.runVoidMethod ("RemoveAllViews");
 BA.debugLineNum = 80;BA.debugLine="Activity.LoadLayout(\"Pantalla2\")";
Debug.ShouldStop(32768);
main.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("Pantalla2")),main.mostCurrent.activityBA);
 BA.debugLineNum = 81;BA.debugLine="HiUsuario.Text= \"Hola \" & Usuario";
Debug.ShouldStop(65536);
main.mostCurrent._hiusuario.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("Hola "),main.mostCurrent._usuario)));
 BA.debugLineNum = 84;BA.debugLine="End Sub";
Debug.ShouldStop(524288);
=======
		Debug.PushSubsStack("INICIAR_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,110);
if (RapidSub.canDelegate("iniciar_click")) { return b4a.example.main.remoteMe.runUserSub(false, "main","iniciar_click");}
 BA.debugLineNum = 110;BA.debugLine="Private Sub INICIAR_Click";
Debug.ShouldStop(8192);
 BA.debugLineNum = 111;BA.debugLine="Usuario = Nombre.Text";
Debug.ShouldStop(16384);
main.mostCurrent._usuario = main.mostCurrent._nombre.runMethod(true,"getText");
 BA.debugLineNum = 112;BA.debugLine="Activity.RemoveAllViews";
Debug.ShouldStop(32768);
main.mostCurrent._activity.runVoidMethod ("RemoveAllViews");
 BA.debugLineNum = 113;BA.debugLine="Activity.LoadLayout(\"Pantalla2\")";
Debug.ShouldStop(65536);
main.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("Pantalla2")),main.mostCurrent.activityBA);
 BA.debugLineNum = 114;BA.debugLine="Panel1.Visible=True";
Debug.ShouldStop(131072);
main.mostCurrent._panel1.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 115;BA.debugLine="HiUsuario.Text= \"Hola \" & Usuario";
Debug.ShouldStop(262144);
main.mostCurrent._hiusuario.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("Hola "),main.mostCurrent._usuario)));
 BA.debugLineNum = 118;BA.debugLine="End Sub";
Debug.ShouldStop(2097152);
>>>>>>> Stashed changes
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
<<<<<<< Updated upstream
 //BA.debugLineNum = 25;BA.debugLine="End Sub";
=======
 //BA.debugLineNum = 24;BA.debugLine="Private formatter As B4XFormatter";
main._formatter = RemoteObject.createNew ("b4a.example.b4xformatter");
 //BA.debugLineNum = 27;BA.debugLine="End Sub";
>>>>>>> Stashed changes
return RemoteObject.createImmutable("");
}
public static RemoteObject  _regresar_click() throws Exception{
try {
		Debug.PushSubsStack("Regresar_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,284);
if (RapidSub.canDelegate("regresar_click")) { return b4a.example.main.remoteMe.runUserSub(false, "main","regresar_click");}
 BA.debugLineNum = 284;BA.debugLine="Private Sub Regresar_Click";
Debug.ShouldStop(134217728);
 BA.debugLineNum = 288;BA.debugLine="End Sub";
Debug.ShouldStop(-2147483648);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}