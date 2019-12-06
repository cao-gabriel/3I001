
public class Groupe implements Runnable{
	
	private int id;
	private static int cpt = 1;
	private int nb;
	private Salle salle;
	
	public Groupe(int nb, Salle salle) {
		this.id = cpt++;
		this.nb = nb;
		this.salle = salle;
	}
	
	public void run() {
		salle.reserver(this.nb, this.id);
	}
}
