import java.util.Random;

public class AleaObjet {
	private int poids;
	private Random gen = new Random();
	
	public AleaObjet(int min, int max) {
		this.poids = gen.nextInt(max-min)+min;
	}
	
	public int getPoids() {
		return this.poids;
	}
	
	public String toString() {
		return "Objet pesant "+this.poids + " kg";
	}
	
	public void affichage() {
		System.out.println(this);
	}
}
