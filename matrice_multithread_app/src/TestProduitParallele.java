import java.io.File;
import java.io.IOException;

public class TestProduitParallele {
	public static void main(String[] args) {
		//definition des fichiers

		File f1 = new File("res/donnees_produit1");
		File f2 = new File("res/donnees_produit2");
		
		//Definition des matrices
		
		try {
			MatriceEntiere m1= new MatriceEntiere(f1);
			MatriceEntiere m2= new MatriceEntiere(f2);
			
			MatriceEntiere prodm = new MatriceEntiere(m1.getNbLignes(), m2.getNbColonnes());
			Thread[][] threads = new Thread[prodm.getNbLignes()][prodm.getNbColonnes()];
			m1.affichage();
			System.out.println("x");
			m2.affichage();
			//produit matriciel avec parallelisme
			for (int i = 0; i < prodm.getNbLignes(); i++) {
				for (int j = 0; j < prodm.getNbColonnes(); j++) {
					threads[i][j] = new Thread(new CalculElem(prodm, m1, m2, i, j));
					threads[i][j].start();
				}
			}
			prodm.affichage();
			
		} catch (NumberFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
}
