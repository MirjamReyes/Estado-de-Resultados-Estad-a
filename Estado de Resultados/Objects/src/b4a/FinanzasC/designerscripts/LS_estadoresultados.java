package b4a.FinanzasC.designerscripts;
import anywheresoftware.b4a.objects.TextViewWrapper;
import anywheresoftware.b4a.objects.ImageViewWrapper;
import anywheresoftware.b4a.BA;


public class LS_estadoresultados{

public static void LS_general(anywheresoftware.b4a.BA ba, android.view.View parent, anywheresoftware.b4a.keywords.LayoutValues lv, java.util.Map props,
java.util.Map<String, anywheresoftware.b4a.keywords.LayoutBuilder.ViewWrapperAndAnchor> views, int width, int height, float scale) throws Exception {
anywheresoftware.b4a.keywords.LayoutBuilder.setScaleRate(0.3);
anywheresoftware.b4a.keywords.LayoutBuilder.scaleAll(views);
views.get("titulo").vw.setWidth((int)((72d / 100 * width)));
views.get("titulo").vw.setLeft((int)((20d / 100 * width)));
views.get("regresar").vw.setLeft((int)((2d / 100 * width)));
views.get("concepto").vw.setWidth((int)((42d / 100 * width)));
views.get("concepto").vw.setHeight((int)((10d / 100 * height)));
views.get("concepto").vw.setLeft((int)((5d / 100 * width)));
views.get("concepto").vw.setTop((int)((9d / 100 * height)));
views.get("datos").vw.setWidth((int)((42d / 100 * width)));
views.get("datos").vw.setHeight((int)((10d / 100 * height)));
//BA.debugLineNum = 14;BA.debugLine="Datos.Right=92%x"[EstadoResultados/General script]
views.get("datos").vw.setLeft((int)((92d / 100 * width) - (views.get("datos").vw.getWidth())));
//BA.debugLineNum = 15;BA.debugLine="Datos.Top=9%y"[EstadoResultados/General script]
views.get("datos").vw.setTop((int)((9d / 100 * height)));
//BA.debugLineNum = 17;BA.debugLine="Concepto1.Width=44%x"[EstadoResultados/General script]
views.get("concepto1").vw.setWidth((int)((44d / 100 * width)));
//BA.debugLineNum = 18;BA.debugLine="Concepto1.Height=9%y"[EstadoResultados/General script]
views.get("concepto1").vw.setHeight((int)((9d / 100 * height)));
//BA.debugLineNum = 19;BA.debugLine="Concepto1.Left=4%x"[EstadoResultados/General script]
views.get("concepto1").vw.setLeft((int)((4d / 100 * width)));
//BA.debugLineNum = 20;BA.debugLine="Concepto1.Top=21%y"[EstadoResultados/General script]
views.get("concepto1").vw.setTop((int)((21d / 100 * height)));
//BA.debugLineNum = 22;BA.debugLine="Datos1.Width=44%x"[EstadoResultados/General script]
views.get("datos1").vw.setWidth((int)((44d / 100 * width)));
//BA.debugLineNum = 23;BA.debugLine="Datos1.Height=9%y"[EstadoResultados/General script]
views.get("datos1").vw.setHeight((int)((9d / 100 * height)));
//BA.debugLineNum = 24;BA.debugLine="Datos1.Right=93%x"[EstadoResultados/General script]
views.get("datos1").vw.setLeft((int)((93d / 100 * width) - (views.get("datos1").vw.getWidth())));
//BA.debugLineNum = 25;BA.debugLine="Datos1.Top=21%y"[EstadoResultados/General script]
views.get("datos1").vw.setTop((int)((21d / 100 * height)));
//BA.debugLineNum = 27;BA.debugLine="Concepto2.Width=44%x"[EstadoResultados/General script]
views.get("concepto2").vw.setWidth((int)((44d / 100 * width)));
//BA.debugLineNum = 28;BA.debugLine="Concepto2.Height=9%y"[EstadoResultados/General script]
views.get("concepto2").vw.setHeight((int)((9d / 100 * height)));
//BA.debugLineNum = 29;BA.debugLine="Concepto2.Left=4%x"[EstadoResultados/General script]
views.get("concepto2").vw.setLeft((int)((4d / 100 * width)));
//BA.debugLineNum = 30;BA.debugLine="Concepto2.Top=30%y"[EstadoResultados/General script]
views.get("concepto2").vw.setTop((int)((30d / 100 * height)));
//BA.debugLineNum = 32;BA.debugLine="Datos2.Width=44%x"[EstadoResultados/General script]
views.get("datos2").vw.setWidth((int)((44d / 100 * width)));
//BA.debugLineNum = 33;BA.debugLine="Datos2.Height=9%y"[EstadoResultados/General script]
views.get("datos2").vw.setHeight((int)((9d / 100 * height)));
//BA.debugLineNum = 34;BA.debugLine="Datos2.Right=93%x"[EstadoResultados/General script]
views.get("datos2").vw.setLeft((int)((93d / 100 * width) - (views.get("datos2").vw.getWidth())));
//BA.debugLineNum = 35;BA.debugLine="Datos2.Top=30%y"[EstadoResultados/General script]
views.get("datos2").vw.setTop((int)((30d / 100 * height)));
//BA.debugLineNum = 37;BA.debugLine="Concepto3.Width=44%x"[EstadoResultados/General script]
views.get("concepto3").vw.setWidth((int)((44d / 100 * width)));
//BA.debugLineNum = 38;BA.debugLine="Concepto3.Height=9%y"[EstadoResultados/General script]
views.get("concepto3").vw.setHeight((int)((9d / 100 * height)));
//BA.debugLineNum = 39;BA.debugLine="Concepto3.Left=4%x"[EstadoResultados/General script]
views.get("concepto3").vw.setLeft((int)((4d / 100 * width)));
//BA.debugLineNum = 40;BA.debugLine="Concepto3.Top=39%y"[EstadoResultados/General script]
views.get("concepto3").vw.setTop((int)((39d / 100 * height)));
//BA.debugLineNum = 42;BA.debugLine="Datos3.Width=44%x"[EstadoResultados/General script]
views.get("datos3").vw.setWidth((int)((44d / 100 * width)));
//BA.debugLineNum = 43;BA.debugLine="Datos3.Height=9%y"[EstadoResultados/General script]
views.get("datos3").vw.setHeight((int)((9d / 100 * height)));
//BA.debugLineNum = 44;BA.debugLine="Datos3.Right=93%x"[EstadoResultados/General script]
views.get("datos3").vw.setLeft((int)((93d / 100 * width) - (views.get("datos3").vw.getWidth())));
//BA.debugLineNum = 45;BA.debugLine="Datos3.Top=39%y"[EstadoResultados/General script]
views.get("datos3").vw.setTop((int)((39d / 100 * height)));
//BA.debugLineNum = 47;BA.debugLine="Concepto4.Width=44%x"[EstadoResultados/General script]
views.get("concepto4").vw.setWidth((int)((44d / 100 * width)));
//BA.debugLineNum = 48;BA.debugLine="Concepto4.Height=9%y"[EstadoResultados/General script]
views.get("concepto4").vw.setHeight((int)((9d / 100 * height)));
//BA.debugLineNum = 49;BA.debugLine="Concepto4.Left=4%x"[EstadoResultados/General script]
views.get("concepto4").vw.setLeft((int)((4d / 100 * width)));
//BA.debugLineNum = 50;BA.debugLine="Concepto4.Top=48%y"[EstadoResultados/General script]
views.get("concepto4").vw.setTop((int)((48d / 100 * height)));
//BA.debugLineNum = 52;BA.debugLine="Datos4.Width=44%x"[EstadoResultados/General script]
views.get("datos4").vw.setWidth((int)((44d / 100 * width)));
//BA.debugLineNum = 53;BA.debugLine="Datos4.Height=9%y"[EstadoResultados/General script]
views.get("datos4").vw.setHeight((int)((9d / 100 * height)));
//BA.debugLineNum = 54;BA.debugLine="Datos4.Right=93%x"[EstadoResultados/General script]
views.get("datos4").vw.setLeft((int)((93d / 100 * width) - (views.get("datos4").vw.getWidth())));
//BA.debugLineNum = 55;BA.debugLine="Datos4.Top=48%y"[EstadoResultados/General script]
views.get("datos4").vw.setTop((int)((48d / 100 * height)));
//BA.debugLineNum = 57;BA.debugLine="Concepto5.Width=44%x"[EstadoResultados/General script]
views.get("concepto5").vw.setWidth((int)((44d / 100 * width)));
//BA.debugLineNum = 58;BA.debugLine="Concepto5.Height=9%y"[EstadoResultados/General script]
views.get("concepto5").vw.setHeight((int)((9d / 100 * height)));
//BA.debugLineNum = 59;BA.debugLine="Concepto5.Left=4%x"[EstadoResultados/General script]
views.get("concepto5").vw.setLeft((int)((4d / 100 * width)));
//BA.debugLineNum = 60;BA.debugLine="Concepto5.Top=57%y"[EstadoResultados/General script]
views.get("concepto5").vw.setTop((int)((57d / 100 * height)));
//BA.debugLineNum = 62;BA.debugLine="Datos5.Width=44%x"[EstadoResultados/General script]
views.get("datos5").vw.setWidth((int)((44d / 100 * width)));
//BA.debugLineNum = 63;BA.debugLine="Datos5.Height=9%y"[EstadoResultados/General script]
views.get("datos5").vw.setHeight((int)((9d / 100 * height)));
//BA.debugLineNum = 64;BA.debugLine="Datos5.Right=93%x"[EstadoResultados/General script]
views.get("datos5").vw.setLeft((int)((93d / 100 * width) - (views.get("datos5").vw.getWidth())));
//BA.debugLineNum = 65;BA.debugLine="Datos5.Top=57%y"[EstadoResultados/General script]
views.get("datos5").vw.setTop((int)((57d / 100 * height)));
//BA.debugLineNum = 67;BA.debugLine="Concepto6.Width=44%x"[EstadoResultados/General script]
views.get("concepto6").vw.setWidth((int)((44d / 100 * width)));
//BA.debugLineNum = 68;BA.debugLine="Concepto6.Height=9%y"[EstadoResultados/General script]
views.get("concepto6").vw.setHeight((int)((9d / 100 * height)));
//BA.debugLineNum = 69;BA.debugLine="Concepto6.Left=4%x"[EstadoResultados/General script]
views.get("concepto6").vw.setLeft((int)((4d / 100 * width)));
//BA.debugLineNum = 70;BA.debugLine="Concepto6.Top=66%y"[EstadoResultados/General script]
views.get("concepto6").vw.setTop((int)((66d / 100 * height)));
//BA.debugLineNum = 72;BA.debugLine="Datos6.Width=44%x"[EstadoResultados/General script]
views.get("datos6").vw.setWidth((int)((44d / 100 * width)));
//BA.debugLineNum = 73;BA.debugLine="Datos6.Height=9%y"[EstadoResultados/General script]
views.get("datos6").vw.setHeight((int)((9d / 100 * height)));
//BA.debugLineNum = 74;BA.debugLine="Datos6.Right=93%x"[EstadoResultados/General script]
views.get("datos6").vw.setLeft((int)((93d / 100 * width) - (views.get("datos6").vw.getWidth())));
//BA.debugLineNum = 75;BA.debugLine="Datos6.Top=66%y"[EstadoResultados/General script]
views.get("datos6").vw.setTop((int)((66d / 100 * height)));
//BA.debugLineNum = 77;BA.debugLine="Concepto7.Width=44%x"[EstadoResultados/General script]
views.get("concepto7").vw.setWidth((int)((44d / 100 * width)));
//BA.debugLineNum = 78;BA.debugLine="Concepto7.Height=9%y"[EstadoResultados/General script]
views.get("concepto7").vw.setHeight((int)((9d / 100 * height)));
//BA.debugLineNum = 79;BA.debugLine="Concepto7.Left=4%x"[EstadoResultados/General script]
views.get("concepto7").vw.setLeft((int)((4d / 100 * width)));
//BA.debugLineNum = 80;BA.debugLine="Concepto7.Top=75%y"[EstadoResultados/General script]
views.get("concepto7").vw.setTop((int)((75d / 100 * height)));
//BA.debugLineNum = 82;BA.debugLine="Datos7.Width=44%x"[EstadoResultados/General script]
views.get("datos7").vw.setWidth((int)((44d / 100 * width)));
//BA.debugLineNum = 83;BA.debugLine="Datos7.Height=9%y"[EstadoResultados/General script]
views.get("datos7").vw.setHeight((int)((9d / 100 * height)));
//BA.debugLineNum = 84;BA.debugLine="Datos7.Right=93%x"[EstadoResultados/General script]
views.get("datos7").vw.setLeft((int)((93d / 100 * width) - (views.get("datos7").vw.getWidth())));
//BA.debugLineNum = 85;BA.debugLine="Datos7.Top=75%y"[EstadoResultados/General script]
views.get("datos7").vw.setTop((int)((75d / 100 * height)));
//BA.debugLineNum = 87;BA.debugLine="infoUB.Width=8%X"[EstadoResultados/General script]
views.get("infoub").vw.setWidth((int)((8d / 100 * width)));
//BA.debugLineNum = 88;BA.debugLine="infoUB.Right=100%x"[EstadoResultados/General script]
views.get("infoub").vw.setLeft((int)((100d / 100 * width) - (views.get("infoub").vw.getWidth())));
//BA.debugLineNum = 89;BA.debugLine="infoUB.Top=39%y"[EstadoResultados/General script]
views.get("infoub").vw.setTop((int)((39d / 100 * height)));
//BA.debugLineNum = 91;BA.debugLine="infoUM.Width=8%x"[EstadoResultados/General script]
views.get("infoum").vw.setWidth((int)((8d / 100 * width)));
//BA.debugLineNum = 92;BA.debugLine="infoUM.Right=100%x"[EstadoResultados/General script]
views.get("infoum").vw.setLeft((int)((100d / 100 * width) - (views.get("infoum").vw.getWidth())));
//BA.debugLineNum = 93;BA.debugLine="infoUM.Top=57%y"[EstadoResultados/General script]
views.get("infoum").vw.setTop((int)((57d / 100 * height)));

}
}