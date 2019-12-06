import java.awt.Point;

import graphic.Window;

public class TestDessineLigne {

	public static void main(String[] args) {
		Window w = new Window(1500,900, "Mon dessin", "green");
		Point pt1 = new Point(300,300);
		Point pt2 = new Point(500,100);
		Point pt3 = new Point(1000,500);
		
		//extends Thread
		
		DessineLigne dl1 = new DessineLigne(w, pt1, pt2);
		DessineLigne dl2 = new DessineLigne(w, pt2, pt3);
		DessineLigne dl3 = new DessineLigne(w, pt1, pt3);
		
		dl1.start();
		dl2.start();
		dl3.start();
		
		
		//implements Runnable
		Thread[] threads = new Thread[3];
		threads[0] =  new Thread(new DessineLigne(w, pt1, pt2));
		threads[1] =  new Thread(new DessineLigne(w, pt3, pt2));
		threads[2] =  new Thread(new DessineLigne(w, pt1, pt3));
		for (int i = 0; i < threads.length; i++) {
			threads[i].start();
		}
		
		

	}

}
