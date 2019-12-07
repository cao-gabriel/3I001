public class Hangar {
	private int id;
	private static int cpt = 0;
	private final static Object mutex = new Object();
	private boolean plein = false;
	
	public Hangar() {
		synchronized (mutex) {
			this.id = cpt++;
		}
	}
	
	public boolean isPlein() {
		return plein;
	}
	
	public void entrer(int id) {
		System.out.println("Loco " + id + " est entrer dans le hangar " + this.id);
	}
	
}
