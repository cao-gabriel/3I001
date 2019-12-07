import java.util.ArrayList;
import java.util.Random;

public class Salon {
	private ArrayList<Client> clients;

	private final int NB_MAX;
	int partis = 0;
	public Random gen = new Random();
	final int TIME_MIN_COIFFER = 10;
	final int TIME_MAX_COIFFER = 300;
	
	
	public Salon(int taille) {
		NB_MAX = taille;
		clients = new ArrayList<Client>();
	}

	public synchronized void attendreClient(Coiffeur coiffeur) throws InterruptedException {
		System.out.println(coiffeur + " attend un client");
		while(clients.size() == 0) {
			this.wait();
		}
		Client client = clients.remove(0);
		coiffeur.setClient(client);
		System.out.println(coiffeur + " s'occupe de " + client);
		
	}

	

	public synchronized void entrer(Client client) throws SalonPleinException{
		if(clients.size() == this.NB_MAX) {
			this.partis++;
			throw new SalonPleinException();
		}
		clients.add(client);
		System.out.println(client + " est entree");
		this.notifyAll();
	}

	public int getPartis() {
		return partis;
	}
	

	
	
	
}
