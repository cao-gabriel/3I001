import java.util.ArrayList;
import java.util.Random;

public class Piscine {

	private ArrayList<Panier> paniers;
	private ArrayList<Cabine> cabines;
	private final int DUREE_MIN_BAIN = 100;
	private final int DUREE_MAX_BAIN = 1000;
	final static Random gen = new Random();
	
	
	public Piscine(int nb_cabine, int nb_panier) {
		this.paniers = new ArrayList<Panier>();
		this.cabines = new ArrayList<Cabine>();
		for (int i = 0; i < nb_cabine; i++) {
			cabines.add(new Cabine());
		}
		for (int i = 0; i < nb_panier; i++) {
			paniers.add(new Panier());
		}
	}
	
	public synchronized void reserveCabine(Nageur nageur) throws InterruptedException {
		System.out.println(nageur+ " attend une cabine");
		while(this.cabines.size() == 0) this.wait();
		nageur.setCabine(cabines.remove(0));
		System.out.println(nageur + " a reserver " + nageur.getCabine());
	}

	public synchronized void libereCabine(Nageur nageur) {
		cabines.add(nageur.getCabine());
		System.out.println(nageur + " libere " + nageur.getCabine());
		nageur.setCabine(null);
		this.notifyAll();
	}

	public synchronized void reservePanier(Nageur nageur) throws InterruptedException {
		System.out.println(nageur+ " attend un panier");
		while(this.paniers.size() == 0) this.wait();
		nageur.setPanier(paniers.remove(0));
		System.out.println(nageur + " a reserver " + nageur.getPanier());
	}

	public synchronized void liberePanier(Nageur nageur) {
		paniers.add(nageur.getPanier());
		System.out.println(nageur + " libere " + nageur.getPanier());
		nageur.setPanier(null);
		this.notifyAll();
	}

	public void seBaigner(Nageur nageur) {
		System.out.println(nageur + " est en train de se baigner....");
		int temps_baignade = gen.nextInt(DUREE_MAX_BAIN-DUREE_MIN_BAIN) + DUREE_MIN_BAIN;
		try {
			Thread.sleep(temps_baignade);
		} catch (InterruptedException e) {
			System.out.println(nageur + " a ete interrompu");
		}
		System.out.println(nageur + " a fini de se baigner et s'est baigne pendant " + temps_baignade/60 + " minutes");
		
	}

}
