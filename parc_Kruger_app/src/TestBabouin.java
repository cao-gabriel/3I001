
public class TestBabouin {
	final static int NB_BABOUIN_NORD = 5;
	final static int NB_BABOUIN_SUD = 5;
	
	public static void main(String[] args) {
		Corde laCorde = new Corde();
		Babouin[] babouins_nord = new Babouin[NB_BABOUIN_NORD];
		Thread[] tBabouins_nord = new Thread[NB_BABOUIN_NORD];
		for (int i = 0; i < tBabouins_nord.length; i++) {
			babouins_nord[i] = new Babouin(laCorde, Position.NORD);
			tBabouins_nord[i] = new Thread(babouins_nord[i]);
			tBabouins_nord[i].start();
		}
		
		Babouin[] babouins_sud = new Babouin[NB_BABOUIN_SUD];
		Thread[] tBabouins_sud = new Thread[NB_BABOUIN_SUD];
		for (int i = 0; i < tBabouins_sud.length; i++) {
			babouins_sud[i] = new Babouin(laCorde, Position.SUD);
			tBabouins_sud[i] = new Thread(babouins_sud[i]);
			tBabouins_sud[i].start();
		}
		
		try {
			for (int i = 0; i < tBabouins_nord.length; i++) {
				tBabouins_nord[i].join();
			}
			for (int i = 0; i < tBabouins_sud.length; i++) {
				tBabouins_sud[i].join();
			}
		} catch (InterruptedException e) {
			System.out.println("join interrupted");
		}
		
		System.out.println("Fin du programme");
	}
}
