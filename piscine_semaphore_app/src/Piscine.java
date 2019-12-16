import java.util.Random;
import java.util.concurrent.Semaphore;

public class Piscine {

	private Semaphore cabines;
	private Semaphore paniers;
	
	private final int DUREE_MIN_BAIN = 100;
	private final int DUREE_MAX_BAIN = 1000;
	final static Random gen = new Random();
	
	
	public Piscine(int nb_cabine, int nb_panier) {
		paniers = new Semaphore(nb_panier);
		cabines = new Semaphore(nb_cabine);
	}
	
	public  void reserveCabine(Nageur nageur) throws InterruptedException {
		System.out.println(nageur+ " attend une cabine");
		cabines.acquire();
		System.out.println(nageur + " a reserver une cabine");
	}

	public  void libereCabine(Nageur nageur) {
		cabines.release();
		System.out.println(nageur+ " libere une cabine");
	}

	public  void reservePanier(Nageur nageur) throws InterruptedException {
		System.out.println(nageur+ " attend un panier");
		paniers.acquire();
		System.out.println(nageur + " a reserver un panier");
	}

	public  void liberePanier(Nageur nageur) {
		paniers.release();
		System.out.println(nageur+ " libere un panier");
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
