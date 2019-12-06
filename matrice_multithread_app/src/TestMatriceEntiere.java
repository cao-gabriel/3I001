import java.io.File;
import java.io.IOException;

public class TestMatriceEntiere {
	
	public static void main(String[] args) {
		try {
			String fichier = "res/donnees_produit1";
			String fichierS1 = "res/donnees_somme1";
			String fichierS2 = "res/donnees_somme2";
			String fichierP1 = "res/donnees_produit1";
			String fichierP2 = "res/donnees_produit2";
			
			//Test affichage
			MatriceEntiere m = new MatriceEntiere(new File(fichier));
			m.affichage();
			
			//test addition
			MatriceEntiere ma1 = new MatriceEntiere(new File(fichierS1));
			MatriceEntiere ma2 = new MatriceEntiere(new File(fichierS2));
			
			MatriceEntiere sum = ma1.somme(ma2);
			sum.affichage();
			
			
			//Test produit matriciel			
			MatriceEntiere mp1 = new MatriceEntiere(new File(fichierP1));
			MatriceEntiere mp2 = new MatriceEntiere(new File(fichierP2));
			
			MatriceEntiere prodm = mp1.prodMat(mp2);
			
			prodm.affichage();
			
			//test produit scalaire
			
			MatriceEntiere prods = mp1.prodScal(2);
			prods.affichage();
			
			
			
			
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TaillesNonConcordantesException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	}

}
