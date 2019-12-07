
public class Coiffeur implements Runnable {
	private int id;
	private static int cpt = 0;
	private final static Object mutex = new Object();
	private Salon salon;
	private Client client = null;

	public Coiffeur(Salon salon) {
		this.salon = salon;
		synchronized (mutex) {
			this.id = cpt++;
		}
	}


	@Override
	public void run() {
		try {
			while (true) {
				salon.attendreClient(this);
				this.client.coiffer(this);

			}
		} catch (InterruptedException e) {
			System.out.println("Fin de " + this);
		}
	}

	public String toString() {
		return "Coiffeur " + id;
	}
	
	public void setClient(Client client) {
		this.client = client;

	}

}
