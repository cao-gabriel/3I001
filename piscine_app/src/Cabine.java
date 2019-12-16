
public class Cabine extends Ressource {
	private static int cpt = 0;
	private final static Object mutex = new Object();

	public Cabine() {
		synchronized (mutex) {			
			this.id = cpt++;
		}
	}
	
	public String toString() {
		return "Cabine " + this.id;
	}
}
