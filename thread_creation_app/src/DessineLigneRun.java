import java.awt.Point;

import graphic.Window;

public class DessineLigneRun implements Runnable{
	private Window w;
	private Point pt1, pt2;
	
	public DessineLigneRun(Window w, Point pt1, Point pt2) {
		this.w = w;
		this.pt1 = pt1;
		this.pt2 = pt2;
	}
	
	public void run() {
		w.plotLine(pt1, pt2);
	}
}
