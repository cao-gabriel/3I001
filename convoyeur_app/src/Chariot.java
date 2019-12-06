import java.util.ArrayList;

public class Chariot {
	private int poidsMax, nbMax;
	private ArrayList<AleaObjet> objects;
	 boolean chargeurFini = false;
	public Chariot(int poidsMax, int nbMax) {
		this.poidsMax = poidsMax;
		this.nbMax = nbMax;
		this.objects = new ArrayList<AleaObjet>();
	}

	public void put(AleaObjet object) throws InterruptedException {
		synchronized (this) {
			while(this.isFull()) {
				this.notify();
				System.out.println("Chargeur : En attente de dechargement");
				this.wait();
			}
			this.objects.add(object);
		}
		
	}

	public void take() throws InterruptedException {
		// TODO Auto-generated method stub
		synchronized (this) {
			while(!this.isFull() && !this.chargeurFini) {
				this.wait();
			}
			this.objects.clear();
			System.out.println("Dechargeur : Le chariot est decharger");
			this.notify();
		}
		
	}
	private int getPoidsChariot() {
		int poidsActuel = 0;
		for(AleaObjet o : objects) {
			poidsActuel += o.getPoids();
		}
		return poidsActuel;
		
	}

	private boolean isFull() {
		
		
		return this.objects.size() >= nbMax || this.poidsMax < this.getPoidsChariot();
	}

	public void sendEndSignal() {
		synchronized (this) {
			this.chargeurFini = true;
			this.notify();
		}
		
	}


}
