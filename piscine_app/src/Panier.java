
public class Panier extends Ressource {
	private static int cpt = 0;
	private final static Object mutex = new Object();
	public Panier() {
		synchronized (mutex) {
			this.id = cpt++;
		}
		
	}
	
	public String toString() {
		return "Panier " + this.id;
	}
}
