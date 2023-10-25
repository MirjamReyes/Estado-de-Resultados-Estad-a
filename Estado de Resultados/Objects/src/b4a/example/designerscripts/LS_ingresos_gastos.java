package b4a.example.designerscripts;
import anywheresoftware.b4a.objects.TextViewWrapper;
import anywheresoftware.b4a.objects.ImageViewWrapper;
import anywheresoftware.b4a.BA;


public class LS_ingresos_gastos{

public static void LS_general(anywheresoftware.b4a.BA ba, android.view.View parent, anywheresoftware.b4a.keywords.LayoutValues lv, java.util.Map props,
java.util.Map<String, anywheresoftware.b4a.keywords.LayoutBuilder.ViewWrapperAndAnchor> views, int width, int height, float scale) throws Exception {
anywheresoftware.b4a.keywords.LayoutBuilder.setScaleRate(0.3);
//BA.debugLineNum = 2;BA.debugLine="AutoScaleAll"[Ingresos_gastos/General script]
anywheresoftware.b4a.keywords.LayoutBuilder.scaleAll(views);
//BA.debugLineNum = 3;BA.debugLine="Panelbarras.Width=150%x"[Ingresos_gastos/General script]
views.get("panelbarras").vw.setWidth((int)((150d / 100 * width)));
//BA.debugLineNum = 4;BA.debugLine="Panelbarras.Height=100%y"[Ingresos_gastos/General script]
views.get("panelbarras").vw.setHeight((int)((100d / 100 * height)));
//BA.debugLineNum = 5;BA.debugLine="Panelbarras.Top=0"[Ingresos_gastos/General script]
views.get("panelbarras").vw.setTop((int)(0d));
//BA.debugLineNum = 6;BA.debugLine="Panelbarras.Left=0"[Ingresos_gastos/General script]
views.get("panelbarras").vw.setLeft((int)(0d));
//BA.debugLineNum = 8;BA.debugLine="Regresar2.Left=0"[Ingresos_gastos/General script]
views.get("regresar2").vw.setLeft((int)(0d));
//BA.debugLineNum = 9;BA.debugLine="titulo.Left=0"[Ingresos_gastos/General script]
views.get("titulo").vw.setLeft((int)(0d));
//BA.debugLineNum = 10;BA.debugLine="titulo.Width=100%x"[Ingresos_gastos/General script]
views.get("titulo").vw.setWidth((int)((100d / 100 * width)));
//BA.debugLineNum = 12;BA.debugLine="mbc1.Width=100%x"[Ingresos_gastos/General script]
views.get("mbc1").vw.setWidth((int)((100d / 100 * width)));
//BA.debugLineNum = 13;BA.debugLine="mbc1.Height=70%y"[Ingresos_gastos/General script]
views.get("mbc1").vw.setHeight((int)((70d / 100 * height)));
//BA.debugLineNum = 14;BA.debugLine="mbc1.Left=0"[Ingresos_gastos/General script]
views.get("mbc1").vw.setLeft((int)(0d));

}
}