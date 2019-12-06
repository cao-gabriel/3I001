
public class TestConvoyeur {
	static final int TAILLE_STOCK = 10;
	public static void main(String[] args) {
		AleaStock stock = new AleaStock(TAILLE_STOCK);
		Chariot chariot = new Chariot(100, 13);

		Chargeur chargeur = new Chargeur(chariot, stock);
		Dechargeur dechargeur = new Dechargeur(chariot);
		//Chargement du stock
		for (int i = 0; i < TAILLE_STOCK; i++) {
			try {
				stock.put(new AleaObjet(10,50));
			} catch (StockPleinException e) {
				e.printStackTrace();
			}
		}
		Thread tChargeur = new Thread(chargeur);
		Thread tdChargeur = new Thread(dechargeur);
		tdChargeur.start();
		tChargeur.start();

		try {
			tChargeur.join();
			tdChargeur.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Fin du programme");
	}
}
