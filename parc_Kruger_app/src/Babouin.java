import java.util.Random;

public class Babouin implements Runnable {

	private int id;
	private static int cpt = 0;
	private final static Object mutex = new Object();
	private Position position;
	private Corde laCorde;
	private final int DUREE_MIN_TRAVERSE = 100;
	private final int DUREE_MAX_TRAVERSE = 1000;
	final static Random gen = new Random(); 
	
	public Babouin(Corde laCorde, Position position) {
		this.laCorde = laCorde;
		this.position = position;
		synchronized (mutex) {
			this.id = cpt++;
		}
	}
	@Override
	public void run() {
		try {
			laCorde.acceder(this);
			System.out.println(this.toString() + " a pris la corde.");
			traverser();
			System.out.println(this.toString() + " est arriver.");
			laCorde.lacher(this);
		} catch (InterruptedException e) {
			System.out.println("Pb babouin !");
		}
	}
	
	private void traverser() throws InterruptedException {
		System.out.println(this + " traverse la corde");
		int temp_traverser = gen.nextInt(DUREE_MAX_TRAVERSE - DUREE_MIN_TRAVERSE) + DUREE_MIN_TRAVERSE;
		Thread.sleep(temp_traverser);
		if(this.position == Position.NORD) {
			this.position = Position.SUD;
		} else {
			this.position = Position.NORD;
		}
		System.out.println(this + " a traverser la corde en " + temp_traverser/60 + " minutes");
		
	}
	
	public String toString() {
		return "Babouin " + this.id + ", " +position;
	}

}
