
public class TestSalleSpectacle {
	public static void main(String[] args) {
		Salle salle = new Salle(4, 10);
		salle.affichage();
		Thread[] threads = new Thread[10];
		for(int i  = 0; i < threads.length; i++) {
			threads[i] = new Thread(new Groupe(i + 1,salle));
			threads[i].start();
		}
				
		try {
			for(int i  = 0; i < threads.length; i++) {
				
				threads[i].join();
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		salle.affichage();
	}
}
