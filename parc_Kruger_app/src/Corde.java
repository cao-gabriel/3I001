
public class Corde {

	private boolean occupe = false;
	
	public synchronized void acceder(Babouin babouin) throws InterruptedException {
		System.out.println(babouin  + " attend la corde");
		while(this.occupe) {
			this.wait();
		}
		this.occupe = true;
		
	}

	public synchronized void lacher(Babouin babouin) {
		this.occupe = false;
		System.out.println(babouin  + " lache la corde");
		this.notifyAll();
		
	}

}
