public class TestGarage {
	final static int NB_LOCO = 10;
	
	public static void main(String[] args) {
		Loco[] locos = new Loco[NB_LOCO];
		PoolHangars pool = new PoolHangars(NB_LOCO);
		SegAccueil sAccueil = new SegAccueil();
		SegTournant sTournant = new SegTournant();
		
		Thread[] tLocos = new Thread[NB_LOCO];
		Thread tSTournant = new Thread(sTournant);
		tSTournant.start();
		for (int i = 0; i < NB_LOCO; i++) {
			locos[i] = new Loco(sAccueil, sTournant, pool);
			tLocos[i] = new Thread(locos[i]);
			tLocos[i].start();
		}
		
		try {
			for (int i = 0; i < tLocos.length; i++) {
				tLocos[i].join();
			}
		} catch (InterruptedException e) {
			System.out.println("join interrupted, shouldn't happen");
		}
		
		tSTournant.interrupt();
		System.out.println("Fin du programme");
	}
}
