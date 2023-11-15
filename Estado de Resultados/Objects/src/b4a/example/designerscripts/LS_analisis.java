package b4a.example.designerscripts;
import anywheresoftware.b4a.objects.TextViewWrapper;
import anywheresoftware.b4a.objects.ImageViewWrapper;
import anywheresoftware.b4a.BA;


public class LS_analisis{

public static void LS_general(anywheresoftware.b4a.BA ba, android.view.View parent, anywheresoftware.b4a.keywords.LayoutValues lv, java.util.Map props,
java.util.Map<String, anywheresoftware.b4a.keywords.LayoutBuilder.ViewWrapperAndAnchor> views, int width, int height, float scale) throws Exception {
anywheresoftware.b4a.keywords.LayoutBuilder.setScaleRate(0.3);
//BA.debugLineNum = 2;BA.debugLine="AutoScaleAll"[Analisis/General script]
anywheresoftware.b4a.keywords.LayoutBuilder.scaleAll(views);
//BA.debugLineNum = 3;BA.debugLine="Panel2.Width=100%X"[Analisis/General script]
views.get("panel2").vw.setWidth((int)((100d / 100 * width)));
//BA.debugLineNum = 4;BA.debugLine="Panel2.Height=100%y"[Analisis/General script]
views.get("panel2").vw.setHeight((int)((100d / 100 * height)));
//BA.debugLineNum = 5;BA.debugLine="ER.Width=80%x"[Analisis/General script]
views.get("er").vw.setWidth((int)((80d / 100 * width)));
//BA.debugLineNum = 6;BA.debugLine="ER.Height=22%y"[Analisis/General script]
views.get("er").vw.setHeight((int)((22d / 100 * height)));
//BA.debugLineNum = 7;BA.debugLine="ER.Left=10%x"[Analisis/General script]
views.get("er").vw.setLeft((int)((10d / 100 * width)));
//BA.debugLineNum = 8;BA.debugLine="ER.Top=20%y"[Analisis/General script]
views.get("er").vw.setTop((int)((20d / 100 * height)));
//BA.debugLineNum = 9;BA.debugLine="Ingresos.Width=80%x"[Analisis/General script]
views.get("ingresos").vw.setWidth((int)((80d / 100 * width)));
//BA.debugLineNum = 10;BA.debugLine="Ingresos.Height=22%y"[Analisis/General script]
views.get("ingresos").vw.setHeight((int)((22d / 100 * height)));
//BA.debugLineNum = 11;BA.debugLine="Ingresos.Left=10%x"[Analisis/General script]
views.get("ingresos").vw.setLeft((int)((10d / 100 * width)));
//BA.debugLineNum = 12;BA.debugLine="Ingresos.Top=57%y"[Analisis/General script]
views.get("ingresos").vw.setTop((int)((57d / 100 * height)));

}
}