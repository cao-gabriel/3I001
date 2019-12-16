
public class TestPiscine {
	final static int NB__NAGEUR = 10;
	final static int NB_PANIER = 5;
	final static int NB_CABINE = 3;

	public static void main(String[] args) {
		Piscine piscine = new Piscine(NB_CABINE, NB_PANIER);
		Nageur[] nageurs = new Nageur[NB__NAGEUR];
		Thread[] tNageurs = new Thread[NB__NAGEUR];
		for (int i = 0; i < nageurs.length; i++) {
			nageurs[i] = new Nageur(piscine);
			tNageurs[i] = new Thread(nageurs[i]);
			tNageurs[i].start();
		}

		try {
			for (int i = 0; i < tNageurs.length; i++) {
				tNageurs[i].join();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Fin du programme");

	}
}
