package b4a.FinanzasC.designerscripts;
import anywheresoftware.b4a.objects.TextViewWrapper;
import anywheresoftware.b4a.objects.ImageViewWrapper;
import anywheresoftware.b4a.BA;


public class LS_pantalla2{

public static void LS_general(anywheresoftware.b4a.BA ba, android.view.View parent, anywheresoftware.b4a.keywords.LayoutValues lv, java.util.Map props,
java.util.Map<String, anywheresoftware.b4a.keywords.LayoutBuilder.ViewWrapperAndAnchor> views, int width, int height, float scale) throws Exception {
anywheresoftware.b4a.keywords.LayoutBuilder.setScaleRate(0.3);
anywheresoftware.b4a.keywords.LayoutBuilder.scaleAll(views);
views.get("panel1").vw.setWidth((int)((100d / 100 * width)));
views.get("panel1").vw.setHeight((int)((100d / 100 * height)));
views.get("panel1").vw.setLeft((int)(0d));
views.get("hiusuario").vw.setWidth((int)((75d / 100 * width)));
views.get("hiusuario").vw.setHeight((int)((14d / 100 * height)));
views.get("hiusuario").vw.setLeft((int)((12.5d / 100 * width)));
views.get("hiusuario").vw.setTop((int)((7d / 100 * height)));
views.get("info").vw.setWidth((int)((25d / 100 * width)));
views.get("info").vw.setLeft((int)((37.5d / 100 * width)));
views.get("info").vw.setTop((int)((27d / 100 * height)));
views.get("boton").vw.setWidth((int)((90d / 100 * width)));
views.get("boton").vw.setLeft((int)((5d / 100 * width)));
views.get("boton").vw.setTop((int)((35d / 100 * height)));
views.get("label1").vw.setWidth((int)((100d / 100 * width)));
views.get("label1").vw.setHeight((int)((10d / 100 * height)));
views.get("label1").vw.setLeft((int)((0d / 100 * width)));
views.get("label1").vw.setTop((int)((53d / 100 * height)));
views.get("label2").vw.setWidth((int)((100d / 100 * width)));
views.get("label2").vw.setHeight((int)((10d / 100 * height)));
views.get("label2").vw.setLeft((int)((0d / 100 * width)));
views.get("label2").vw.setTop((int)((63d / 100 * height)));
views.get("analisis").vw.setHeight((int)((15d / 100 * height)));
views.get("analisis").vw.setWidth((int)((60d / 100 * width)));
views.get("analisis").vw.setTop((int)((77d / 100 * height)));
views.get("analisis").vw.setLeft((int)((20d / 100 * width)));

}
}