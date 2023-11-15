package b4a.example.designerscripts;
import anywheresoftware.b4a.objects.TextViewWrapper;
import anywheresoftware.b4a.objects.ImageViewWrapper;
import anywheresoftware.b4a.BA;


public class LS_ingresos_gastos{

public static void LS_general(anywheresoftware.b4a.BA ba, android.view.View parent, anywheresoftware.b4a.keywords.LayoutValues lv, java.util.Map props,
java.util.Map<String, anywheresoftware.b4a.keywords.LayoutBuilder.ViewWrapperAndAnchor> views, int width, int height, float scale) throws Exception {
anywheresoftware.b4a.keywords.LayoutBuilder.setScaleRate(0.3);
anywheresoftware.b4a.keywords.LayoutBuilder.scaleAll(views);
views.get("panelbarras").vw.setWidth((int)((100d / 100 * width)));
views.get("panelbarras").vw.setHeight((int)((100d / 100 * height)));
views.get("panelbarras").vw.setTop((int)(0d));
views.get("panelbarras").vw.setLeft((int)(0d));
views.get("regresar2").vw.setLeft((int)(0d));
views.get("titulo").vw.setLeft((int)(0d));
views.get("titulo").vw.setWidth((int)((100d / 100 * width)));
views.get("mbc1").vw.setWidth((int)((100d / 100 * width)));
views.get("mbc1").vw.setHeight((int)((70d / 100 * height)));
views.get("mbc1").vw.setLeft((int)(0d));

}
}