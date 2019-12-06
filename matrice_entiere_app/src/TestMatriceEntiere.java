import java.io.File;
import java.io.IOException;

public class TestMatriceEntiere {
	
	public static void main(String[] args) {
		try {
			String filePath = "../res/";
			String fichier = "donnees_produit1";
			String fichierS1 = "donnees_somme1";
			String fichierS2 = "donnees_somme2";
			String fichierP1 = "donnees_produit1";
			String fichierP2 = "donnees_produit2";
			
			//Test affichage
			MatriceEntiere m = new MatriceEntiere(new File(filePath + fichier));
			System.out.println("Affichage d'une matrice : ");
			m.affichage();
			
			//test addition
			MatriceEntiere ma1 = new MatriceEntiere(new File(filePath + fichierS1));
			MatriceEntiere ma2 = new MatriceEntiere(new File(filePath + fichierS2));
			
			MatriceEntiere sum = ma1.somme(ma2);
			System.out.println("Test de la somme de deux matrices : ");
			sum.affichage();
			
			
			//Test produit matriciel			
			MatriceEntiere mp1 = new MatriceEntiere(new File(filePath + fichierP1));
			MatriceEntiere mp2 = new MatriceEntiere(new File(filePath + fichierP2));
			
			MatriceEntiere prodm = mp1.prodMat(mp2);
			System.out.println("Test du produit de deux matrices : ");
			prodm.affichage();
			
			//test produit scalaire
			System.out.println("Test du produit scalaire : ");
			MatriceEntiere prods = mp1.prodScal(2);
			prods.affichage();
			
			
			
			
		} catch (NumberFormatException e) {
			System.out.println("Contenu de fichier non respectée");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Problème ouverture/fermeture de fichier");
			e.printStackTrace();
		} catch (TaillesNonConcordantesException e) {
			System.out.println("Matrices de taille non concordantes");
			e.printStackTrace();
		}
		 
	}

}
