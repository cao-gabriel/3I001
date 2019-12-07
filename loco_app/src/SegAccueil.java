public class SegAccueil {

	private boolean occupe = false;
	public synchronized void reserver(int id) throws InterruptedException {
		while(occupe) {
			this.wait();
		}
		occupe = true;
		System.out.println("Loco " + id + " reserve le segment d'accueil");
		
	}

	public synchronized void liberer(int id) {
		occupe = false;
		this.notifyAll();
		System.out.println("Loco " + id + " libere le segment d'accueil");
		
	}

}
