
package b4a.example;

import java.io.IOException;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.PCBA;
import anywheresoftware.b4a.pc.RDebug;
import anywheresoftware.b4a.pc.RemoteObject;
import anywheresoftware.b4a.pc.RDebug.IRemote;
import anywheresoftware.b4a.pc.Debug;
import anywheresoftware.b4a.pc.B4XTypes.B4XClass;
import anywheresoftware.b4a.pc.B4XTypes.DeviceClass;

public class main implements IRemote{
	public static main mostCurrent;
	public static RemoteObject processBA;
    public static boolean processGlobalsRun;
    public static RemoteObject myClass;
    public static RemoteObject remoteMe;
	public main() {
		mostCurrent = this;
	}
    public RemoteObject getRemoteMe() {
        return remoteMe;    
    }
    
	public static void main (String[] args) throws Exception {
		new RDebug(args[0], Integer.parseInt(args[1]), Integer.parseInt(args[2]), args[3]);
		RDebug.INSTANCE.waitForTask();

	}
    static {
        anywheresoftware.b4a.pc.RapidSub.moduleToObject.put(new B4XClass("main"), "b4a.example.main");
	}

public boolean isSingleton() {
		return true;
	}
     public static RemoteObject getObject() {
		return myClass;
	 }

	public RemoteObject activityBA;
	public RemoteObject _activity;
    private PCBA pcBA;

	public PCBA create(Object[] args) throws ClassNotFoundException{
		processBA = (RemoteObject) args[1];
		activityBA = (RemoteObject) args[2];
		_activity = (RemoteObject) args[3];
        anywheresoftware.b4a.keywords.Common.Density = (Float)args[4];
        remoteMe = (RemoteObject) args[5];
		pcBA = new PCBA(this, main.class);
        main_subs_0.initializeProcessGlobals();
		return pcBA;
	}
public static RemoteObject __c = RemoteObject.declareNull("anywheresoftware.b4a.keywords.Common");
public static RemoteObject _xui = RemoteObject.declareNull("anywheresoftware.b4a.objects.B4XViewWrapper.XUI");
public static RemoteObject _xls = RemoteObject.declareNull("de.donmanfred.XSSFWorkbookwrapper");
public static RemoteObject _formatter = RemoteObject.declareNull("b4a.example.b4xformatter");
public static RemoteObject _iniciar = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _info = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _usuario = RemoteObject.createImmutable("");
public static RemoteObject _archivo = RemoteObject.createImmutable("");
public static RemoteObject _nombre = RemoteObject.declareNull("anywheresoftware.b4a.objects.EditTextWrapper");
public static RemoteObject _ingresos = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _gadm = RemoteObject.createImmutable(0f);
public static RemoteObject _gop = RemoteObject.createImmutable(0f);
public static RemoteObject _ingresos_ = RemoteObject.createImmutable(0f);
public static RemoteObject _utilidadb = RemoteObject.createImmutable(0f);
public static RemoteObject _utilidadoai = RemoteObject.createImmutable(0f);
public static RemoteObject _impuestos = RemoteObject.createImmutable(0f);
public static RemoteObject _uoperativadesp_imp = RemoteObject.createImmutable(0f);
public static RemoteObject _mbc1 = RemoteObject.declareNull("mpandroidchartwrapper.barChartWrapper");
public static RemoteObject _hiusuario = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _boton = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _label1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _label2 = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _analisis = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _concepto = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _concepto1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _concepto2 = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _concepto3 = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _concepto4 = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _concepto5 = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _concepto6 = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _concepto7 = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _datos = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _datos1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _datos2 = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _datos3 = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _datos4 = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _datos5 = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _datos6 = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _datos7 = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _er = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _panel1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _panel2 = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _nómina = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _regresar2 = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _infoub = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _infoum = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _scrollview1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.HorizontalScrollViewWrapper");
public static RemoteObject _panelbarras = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static b4a.example.starter _starter = null;
  public Object[] GetGlobals() {
		return new Object[] {"Activity",main.mostCurrent._activity,"Analisis",main.mostCurrent._analisis,"archivo",main.mostCurrent._archivo,"Boton",main.mostCurrent._boton,"Concepto",main.mostCurrent._concepto,"Concepto1",main.mostCurrent._concepto1,"Concepto2",main.mostCurrent._concepto2,"Concepto3",main.mostCurrent._concepto3,"Concepto4",main.mostCurrent._concepto4,"Concepto5",main.mostCurrent._concepto5,"Concepto6",main.mostCurrent._concepto6,"Concepto7",main.mostCurrent._concepto7,"Datos",main.mostCurrent._datos,"Datos1",main.mostCurrent._datos1,"Datos2",main.mostCurrent._datos2,"Datos3",main.mostCurrent._datos3,"Datos4",main.mostCurrent._datos4,"Datos5",main.mostCurrent._datos5,"Datos6",main.mostCurrent._datos6,"Datos7",main.mostCurrent._datos7,"ER",main.mostCurrent._er,"formatter",main._formatter,"Gadm",main._gadm,"GOp",main._gop,"HiUsuario",main.mostCurrent._hiusuario,"Impuestos",main._impuestos,"info",main.mostCurrent._info,"infoUB",main.mostCurrent._infoub,"infoUM",main.mostCurrent._infoum,"Ingresos",main.mostCurrent._ingresos,"Ingresos_",main._ingresos_,"INICIAR",main.mostCurrent._iniciar,"Label1",main.mostCurrent._label1,"Label2",main.mostCurrent._label2,"mbc1",main.mostCurrent._mbc1,"Nombre",main.mostCurrent._nombre,"Nómina",main.mostCurrent._nómina,"Panel1",main.mostCurrent._panel1,"Panel2",main.mostCurrent._panel2,"Panelbarras",main.mostCurrent._panelbarras,"Regresar2",main.mostCurrent._regresar2,"ScrollView1",main.mostCurrent._scrollview1,"Starter",Debug.moduleToString(b4a.example.starter.class),"UOperativaDesp_Imp",main._uoperativadesp_imp,"Usuario",main.mostCurrent._usuario,"UtilidadB",main._utilidadb,"UtilidadOai",main._utilidadoai,"xls",main._xls,"xui",main._xui};
}
}