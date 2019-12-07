
public class TestCoiffeur {
	static final int NB_CLIENT = 1000;
	static final int NB_COIFFEUR = 20;
	
	static final int TAILLE_SALON = 300;
	public static void main(String[] args) {
		
		Client[] clients = new Client[NB_CLIENT];
		Coiffeur[] coiffeurs = new Coiffeur[NB_COIFFEUR];
		
		Salon salon = new Salon(TAILLE_SALON);
		Thread[] tClients = new Thread[NB_CLIENT];
		Thread[] tCoiffeurs = new Thread[NB_COIFFEUR];
		

		for (int i = 0; i < tCoiffeurs.length; i++) {
			coiffeurs[i] = new Coiffeur(salon);
			tCoiffeurs[i] = new Thread(coiffeurs[i]);
			tCoiffeurs[i].start();
		}
		
		for (int i = 0; i < tClients.length; i++) {
			clients[i] = new Client(salon);
			tClients[i] = new Thread(clients[i]);
			tClients[i].start();
		}
		
		try {
			for (int i = 0; i < tClients.length; i++) {
				tClients[i].join();
			}
			for (int i = 0; i < tCoiffeurs.length; i++) {
				tCoiffeurs[i].interrupt();
			}
			for (int i = 0; i < tCoiffeurs.length; i++) {
				tCoiffeurs[i].join();
			}
		} catch (InterruptedException e) {
			System.out.println("join was interrupted, shouldn't happen");
		}
		
		System.out.println("Resultat du salon : " + salon.getPartis() + " clients partis sur " + NB_CLIENT + " clients" );
		
		System.out.println("Fermeture du salon");
		
	}
}
