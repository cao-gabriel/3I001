
public class Client implements Runnable{

	private int id;
	private static int cpt = 0;
	private final static Object mutex = new Object();
	private final int TIME_MIN_ENTREE = 100;
	private final int TIME_MAX_ENTREE = 2000;
	private boolean coiffer = false;
	
	private Salon salon;
	public Client(Salon salon) {
			this.salon = salon;
			synchronized (mutex) {
				this.id  = cpt++;
			}
			
	}
	
	@Override
	public void run() {
		try {
			Thread.sleep(salon.gen.nextInt(TIME_MAX_ENTREE + TIME_MIN_ENTREE) + TIME_MIN_ENTREE);
			salon.entrer(this);
			sortir();
		} catch (InterruptedException e) {
			System.out.println("client " + this.id + " interrupted");
		} catch (SalonPleinException e) {
			System.out.println(this + " est mecontent et sort du salon");
		}
		
	}
	
	private synchronized void sortir() throws InterruptedException {
		while(!this.coiffer) {
			this.wait();
		}
		System.out.println(this + " est content et sort du salon");
		
	}

	public void coiffer(Coiffeur coiffeur) throws InterruptedException {
		System.out.println(coiffeur + " est en train de coiffer " + this);
		
		Thread.sleep(salon.gen.nextInt(salon.TIME_MAX_COIFFER - salon.TIME_MIN_COIFFER ) + salon.TIME_MIN_COIFFER);
		
		synchronized (this) {
			this.coiffer = true;
			System.out.println(this + " a ete coiffer");
			this.notifyAll();
		}
		
	}



	public String toString() {
		return "Client " + this.id ;
	}
}
