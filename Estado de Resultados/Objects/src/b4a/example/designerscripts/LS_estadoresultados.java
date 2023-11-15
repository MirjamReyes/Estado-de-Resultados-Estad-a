package b4a.example.designerscripts;
import anywheresoftware.b4a.objects.TextViewWrapper;
import anywheresoftware.b4a.objects.ImageViewWrapper;
import anywheresoftware.b4a.BA;


public class LS_estadoresultados{

public static void LS_general(anywheresoftware.b4a.BA ba, android.view.View parent, anywheresoftware.b4a.keywords.LayoutValues lv, java.util.Map props,
java.util.Map<String, anywheresoftware.b4a.keywords.LayoutBuilder.ViewWrapperAndAnchor> views, int width, int height, float scale) throws Exception {
anywheresoftware.b4a.keywords.LayoutBuilder.setScaleRate(0.3);
anywheresoftware.b4a.keywords.LayoutBuilder.scaleAll(views);
views.get("concepto").vw.setWidth((int)((42d / 100 * width)));
views.get("concepto").vw.setHeight((int)((10d / 100 * height)));
views.get("concepto").vw.setLeft((int)((5d / 100 * width)));
views.get("datos").vw.setWidth((int)((42d / 100 * width)));
views.get("datos").vw.setHeight((int)((10d / 100 * height)));
views.get("datos").vw.setLeft((int)((92d / 100 * width) - (views.get("datos").vw.getWidth())));
views.get("concepto1").vw.setWidth((int)((44d / 100 * width)));
views.get("concepto1").vw.setHeight((int)((9d / 100 * height)));
views.get("concepto1").vw.setLeft((int)((4d / 100 * width)));
//BA.debugLineNum = 14;BA.debugLine="Concepto1.Top=19%y"[EstadoResultados/General script]
views.get("concepto1").vw.setTop((int)((19d / 100 * height)));
//BA.debugLineNum = 16;BA.debugLine="Datos1.Width=44%x"[EstadoResultados/General script]
views.get("datos1").vw.setWidth((int)((44d / 100 * width)));
//BA.debugLineNum = 17;BA.debugLine="Datos1.Height=9%y"[EstadoResultados/General script]
views.get("datos1").vw.setHeight((int)((9d / 100 * height)));
//BA.debugLineNum = 18;BA.debugLine="Datos1.Right=93%x"[EstadoResultados/General script]
views.get("datos1").vw.setLeft((int)((93d / 100 * width) - (views.get("datos1").vw.getWidth())));
//BA.debugLineNum = 19;BA.debugLine="Datos1.Top=19%y"[EstadoResultados/General script]
views.get("datos1").vw.setTop((int)((19d / 100 * height)));
//BA.debugLineNum = 21;BA.debugLine="Concepto2.Width=44%x"[EstadoResultados/General script]
views.get("concepto2").vw.setWidth((int)((44d / 100 * width)));
//BA.debugLineNum = 22;BA.debugLine="Concepto2.Height=9%y"[EstadoResultados/General script]
views.get("concepto2").vw.setHeight((int)((9d / 100 * height)));
//BA.debugLineNum = 23;BA.debugLine="Concepto2.Left=4%x"[EstadoResultados/General script]
views.get("concepto2").vw.setLeft((int)((4d / 100 * width)));
//BA.debugLineNum = 24;BA.debugLine="Concepto2.Top=28%y"[EstadoResultados/General script]
views.get("concepto2").vw.setTop((int)((28d / 100 * height)));
//BA.debugLineNum = 26;BA.debugLine="Datos2.Width=44%x"[EstadoResultados/General script]
views.get("datos2").vw.setWidth((int)((44d / 100 * width)));
//BA.debugLineNum = 27;BA.debugLine="Datos2.Height=9%y"[EstadoResultados/General script]
views.get("datos2").vw.setHeight((int)((9d / 100 * height)));
//BA.debugLineNum = 28;BA.debugLine="Datos2.Right=93%x"[EstadoResultados/General script]
views.get("datos2").vw.setLeft((int)((93d / 100 * width) - (views.get("datos2").vw.getWidth())));
//BA.debugLineNum = 29;BA.debugLine="Datos2.Top=28%y"[EstadoResultados/General script]
views.get("datos2").vw.setTop((int)((28d / 100 * height)));
//BA.debugLineNum = 31;BA.debugLine="Concepto3.Width=44%x"[EstadoResultados/General script]
views.get("concepto3").vw.setWidth((int)((44d / 100 * width)));
//BA.debugLineNum = 32;BA.debugLine="Concepto3.Height=9%y"[EstadoResultados/General script]
views.get("concepto3").vw.setHeight((int)((9d / 100 * height)));
//BA.debugLineNum = 33;BA.debugLine="Concepto3.Left=4%x"[EstadoResultados/General script]
views.get("concepto3").vw.setLeft((int)((4d / 100 * width)));
//BA.debugLineNum = 34;BA.debugLine="Concepto3.Top=37%y"[EstadoResultados/General script]
views.get("concepto3").vw.setTop((int)((37d / 100 * height)));
//BA.debugLineNum = 36;BA.debugLine="Datos3.Width=44%x"[EstadoResultados/General script]
views.get("datos3").vw.setWidth((int)((44d / 100 * width)));
//BA.debugLineNum = 37;BA.debugLine="Datos3.Height=9%y"[EstadoResultados/General script]
views.get("datos3").vw.setHeight((int)((9d / 100 * height)));
//BA.debugLineNum = 38;BA.debugLine="Datos3.Right=93%x"[EstadoResultados/General script]
views.get("datos3").vw.setLeft((int)((93d / 100 * width) - (views.get("datos3").vw.getWidth())));
//BA.debugLineNum = 39;BA.debugLine="Datos3.Top=37%y"[EstadoResultados/General script]
views.get("datos3").vw.setTop((int)((37d / 100 * height)));
//BA.debugLineNum = 41;BA.debugLine="Concepto4.Width=44%x"[EstadoResultados/General script]
views.get("concepto4").vw.setWidth((int)((44d / 100 * width)));
//BA.debugLineNum = 42;BA.debugLine="Concepto4.Height=9%y"[EstadoResultados/General script]
views.get("concepto4").vw.setHeight((int)((9d / 100 * height)));
//BA.debugLineNum = 43;BA.debugLine="Concepto4.Left=4%x"[EstadoResultados/General script]
views.get("concepto4").vw.setLeft((int)((4d / 100 * width)));
//BA.debugLineNum = 44;BA.debugLine="Concepto4.Top=46%y"[EstadoResultados/General script]
views.get("concepto4").vw.setTop((int)((46d / 100 * height)));
//BA.debugLineNum = 46;BA.debugLine="Datos4.Width=44%x"[EstadoResultados/General script]
views.get("datos4").vw.setWidth((int)((44d / 100 * width)));
//BA.debugLineNum = 47;BA.debugLine="Datos4.Height=9%y"[EstadoResultados/General script]
views.get("datos4").vw.setHeight((int)((9d / 100 * height)));
//BA.debugLineNum = 48;BA.debugLine="Datos4.Right=93%x"[EstadoResultados/General script]
views.get("datos4").vw.setLeft((int)((93d / 100 * width) - (views.get("datos4").vw.getWidth())));
//BA.debugLineNum = 49;BA.debugLine="Datos4.Top=46%y"[EstadoResultados/General script]
views.get("datos4").vw.setTop((int)((46d / 100 * height)));
//BA.debugLineNum = 51;BA.debugLine="Concepto5.Width=44%x"[EstadoResultados/General script]
views.get("concepto5").vw.setWidth((int)((44d / 100 * width)));
//BA.debugLineNum = 52;BA.debugLine="Concepto5.Height=9%y"[EstadoResultados/General script]
views.get("concepto5").vw.setHeight((int)((9d / 100 * height)));
//BA.debugLineNum = 53;BA.debugLine="Concepto5.Left=4%x"[EstadoResultados/General script]
views.get("concepto5").vw.setLeft((int)((4d / 100 * width)));
//BA.debugLineNum = 54;BA.debugLine="Concepto5.Top=55%y"[EstadoResultados/General script]
views.get("concepto5").vw.setTop((int)((55d / 100 * height)));
//BA.debugLineNum = 56;BA.debugLine="Datos5.Width=44%x"[EstadoResultados/General script]
views.get("datos5").vw.setWidth((int)((44d / 100 * width)));
//BA.debugLineNum = 57;BA.debugLine="Datos5.Height=9%y"[EstadoResultados/General script]
views.get("datos5").vw.setHeight((int)((9d / 100 * height)));
//BA.debugLineNum = 58;BA.debugLine="Datos5.Right=93%x"[EstadoResultados/General script]
views.get("datos5").vw.setLeft((int)((93d / 100 * width) - (views.get("datos5").vw.getWidth())));
//BA.debugLineNum = 59;BA.debugLine="Datos5.Top=55%y"[EstadoResultados/General script]
views.get("datos5").vw.setTop((int)((55d / 100 * height)));
//BA.debugLineNum = 61;BA.debugLine="Concepto6.Width=44%x"[EstadoResultados/General script]
views.get("concepto6").vw.setWidth((int)((44d / 100 * width)));
//BA.debugLineNum = 62;BA.debugLine="Concepto6.Height=9%y"[EstadoResultados/General script]
views.get("concepto6").vw.setHeight((int)((9d / 100 * height)));
//BA.debugLineNum = 63;BA.debugLine="Concepto6.Left=4%x"[EstadoResultados/General script]
views.get("concepto6").vw.setLeft((int)((4d / 100 * width)));
//BA.debugLineNum = 64;BA.debugLine="Concepto6.Top=64%y"[EstadoResultados/General script]
views.get("concepto6").vw.setTop((int)((64d / 100 * height)));
//BA.debugLineNum = 66;BA.debugLine="Datos6.Width=44%x"[EstadoResultados/General script]
views.get("datos6").vw.setWidth((int)((44d / 100 * width)));
//BA.debugLineNum = 67;BA.debugLine="Datos6.Height=9%y"[EstadoResultados/General script]
views.get("datos6").vw.setHeight((int)((9d / 100 * height)));
//BA.debugLineNum = 68;BA.debugLine="Datos6.Right=93%x"[EstadoResultados/General script]
views.get("datos6").vw.setLeft((int)((93d / 100 * width) - (views.get("datos6").vw.getWidth())));
//BA.debugLineNum = 69;BA.debugLine="Datos6.Top=64%y"[EstadoResultados/General script]
views.get("datos6").vw.setTop((int)((64d / 100 * height)));
//BA.debugLineNum = 71;BA.debugLine="Concepto7.Width=44%x"[EstadoResultados/General script]
views.get("concepto7").vw.setWidth((int)((44d / 100 * width)));
//BA.debugLineNum = 72;BA.debugLine="Concepto7.Height=9%y"[EstadoResultados/General script]
views.get("concepto7").vw.setHeight((int)((9d / 100 * height)));
//BA.debugLineNum = 73;BA.debugLine="Concepto7.Left=4%x"[EstadoResultados/General script]
views.get("concepto7").vw.setLeft((int)((4d / 100 * width)));
//BA.debugLineNum = 74;BA.debugLine="Concepto7.Top=73%y"[EstadoResultados/General script]
views.get("concepto7").vw.setTop((int)((73d / 100 * height)));
//BA.debugLineNum = 76;BA.debugLine="Datos7.Width=44%x"[EstadoResultados/General script]
views.get("datos7").vw.setWidth((int)((44d / 100 * width)));
//BA.debugLineNum = 77;BA.debugLine="Datos7.Height=9%y"[EstadoResultados/General script]
views.get("datos7").vw.setHeight((int)((9d / 100 * height)));
//BA.debugLineNum = 78;BA.debugLine="Datos7.Right=93%x"[EstadoResultados/General script]
views.get("datos7").vw.setLeft((int)((93d / 100 * width) - (views.get("datos7").vw.getWidth())));
//BA.debugLineNum = 79;BA.debugLine="Datos7.Top=73%y"[EstadoResultados/General script]
views.get("datos7").vw.setTop((int)((73d / 100 * height)));
//BA.debugLineNum = 81;BA.debugLine="infoUB.Width=8%X"[EstadoResultados/General script]
views.get("infoub").vw.setWidth((int)((8d / 100 * width)));
//BA.debugLineNum = 82;BA.debugLine="infoUB.Right=100%x"[EstadoResultados/General script]
views.get("infoub").vw.setLeft((int)((100d / 100 * width) - (views.get("infoub").vw.getWidth())));
//BA.debugLineNum = 83;BA.debugLine="infoUB.Top=37%y"[EstadoResultados/General script]
views.get("infoub").vw.setTop((int)((37d / 100 * height)));
//BA.debugLineNum = 85;BA.debugLine="infoUM.Width=8%x"[EstadoResultados/General script]
views.get("infoum").vw.setWidth((int)((8d / 100 * width)));
//BA.debugLineNum = 86;BA.debugLine="infoUM.Right=100%x"[EstadoResultados/General script]
views.get("infoum").vw.setLeft((int)((100d / 100 * width) - (views.get("infoum").vw.getWidth())));
//BA.debugLineNum = 87;BA.debugLine="infoUM.Top=55%y"[EstadoResultados/General script]
views.get("infoum").vw.setTop((int)((55d / 100 * height)));

}
}