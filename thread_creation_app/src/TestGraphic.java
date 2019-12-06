import java.awt.Point;

import graphic.Window;

public class TestGraphic {

	public static void main(String[] args) {
		Window w = new Window(500,500, "Ma fenetre");
		Point pt1 = new Point(10,10);
		Point pt2 = new Point(10,100);
		Point pt3 = new Point(50,50);
		
		
		//Tracer un triangle
		w.plotLine(pt1, pt2);
		w.plotLine(pt1, pt3);
		w.plotLine(pt3, pt2);
		
	}

}
