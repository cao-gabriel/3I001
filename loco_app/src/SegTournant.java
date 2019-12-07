public class SegTournant implements Runnable {

	private int position = -1;
	private int appeler = -1;
	private boolean plein = false;
	@Override
	public void run() {
		try {
			while (true) {
				attendreAppel();
				seDeplacer();
				attendreEntree();
				seDeplacer();
				attendreVide();
			}
		} catch (InterruptedException e) {
			System.out.println("Terminaison sur interruption du segment tournant");
		}
	}

	private synchronized void attendreVide() throws InterruptedException {
		System.out.println("Segment Tournant attend la sortie de la loco");
		while(this.plein) this.wait();

	}

	private synchronized void attendreEntree() throws InterruptedException {
		System.out.println("Segment Tournant attend l'entree de la loco");
		
		while(!plein ) this.wait();
		
	}

	private synchronized void seDeplacer() {
		System.out.println("Segment tournant se deplace...");
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			System.out.println("interrupted when loco is moving");
			e.printStackTrace();
		}
		synchronized (this) {
			System.out.println("Segment Tournant a fini son deplacement");
			this.position = appeler;
			this.notifyAll();
		}

	}

	private synchronized void attendreAppel() throws InterruptedException {
		System.out.println("Segment Tournant attend l'appel d'une loco");
		while(appeler == -1) {
			this.wait();
		}
		
	}

	public synchronized void appeler(int i, int id) throws InterruptedException {
		while(this.plein) {
			this.wait();
		}
		System.out.println("Loco " + id + " appelle le segment tournant");
		appeler = i;
		this.notifyAll();
	}

	public synchronized void attendrePositionOK(int id) throws InterruptedException {
		System.out.println("Loco " + id + " attend le segment tournant");
		while(appeler != position) {
			this.wait();
		}
	}

	public int getPosition() {
		// TODO Auto-generated method stub
		return position;
	}

	public synchronized void entrer(int id) {
		System.out.println("Loco " + id + " entre dans le segment tournant");
		this.plein = true;
		this.notifyAll();

	}

	public synchronized void sortir(int id) {
		System.out.println("Loco " + id + " sort du segment tournant");
		this.plein = false;
		this.appeler = -1;
		this.notifyAll();

	}

}
