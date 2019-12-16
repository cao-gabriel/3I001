
public class Nageur implements Runnable{

	private int id;
	private static int cpt =0;
	private static Object mutex = new Object();
	private Cabine cabine;
	private Panier panier;
	
	private Piscine piscine;
	public Nageur(Piscine piscine) {
		synchronized (mutex) {
			this.id = cpt++;
		}
		this.piscine = piscine;
	}
	@Override
	public void run() {
		try {
			
			this.piscine.reservePanier(this);
			this.piscine.reserveCabine(this);
			this.piscine.libereCabine(this);
			this.piscine.seBaigner(this);
			this.piscine.reserveCabine(this);
			this.piscine.libereCabine(this);
			this.piscine.liberePanier(this);
			System.out.println("Nageur " + id +  " est sorti de la piscine");
		} catch(InterruptedException e) {
			System.out.println("Nageur interrompu, ne devrait pas arriver");
		}
	}
	
	public String toString() {
		return "Nageur " + this.id;
	}
	public Panier getPanier() {
		return panier;
	}
	public void setPanier(Panier panier) {
		this.panier = panier;
	}
	public Cabine getCabine() {
		return cabine;
	}
	public void setCabine(Cabine cabine) {
		this.cabine = cabine;
	}

}
