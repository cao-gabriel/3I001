import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class MatriceEntiere {

	private int lignes, colonnes;
	int[][] tableau;
	
	public MatriceEntiere(int lignes, int colonnes) {
		this.colonnes = colonnes;
		this.lignes = lignes;
		this.tableau = new int[this.lignes][this.colonnes];
	}
	
	public MatriceEntiere(File fichier) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new FileReader(fichier));
		this.lignes = Integer.parseInt(in.readLine());
		this.colonnes = Integer.parseInt(in.readLine());
		
		this.tableau = new int[this.lignes][this.colonnes];
		
		String[] valeurs;
		for (int i = 0; i < this.lignes; i++) {
			valeurs = in.readLine().split(" ");	
			for(int j = 0; j < this.colonnes; j++) {
				tableau[i][j] = Integer.parseInt(valeurs[j]);
			}
		}
		in.close();
	}
	
	public void initZero() {
		for (int i = 0; i < tableau.length; i++) {
			for (int j = 0; j < tableau[0].length; j++) {
				this.tableau[i][j] = 0;
			}
		}
	}
	
	public MatriceEntiere transposer(){
		MatriceEntiere transpose = new MatriceEntiere(this.colonnes,this.lignes);
		transpose.initZero();
		for (int i = 0; i < lignes; i++) {
			for (int j = 0; j < colonnes; j++) {
				transpose.setElem(j, i, this.getElem(i, j));
			}
		}
		return transpose;
		
	}
	
	public MatriceEntiere somme(MatriceEntiere m) {
		MatriceEntiere sum = new MatriceEntiere(m.lignes, m.colonnes);
		sum.initZero();
		
		for (int i = 0; i < tableau.length; i++) {
			for (int j = 0; j < tableau[0].length; j++) {
				sum.setElem(i, j, this.getElem(i, j) + m.getElem(i, j));
			}
		}
		
		return sum;
	}
	
	public MatriceEntiere prodScal(int lambda) {
		MatriceEntiere prods = new MatriceEntiere(this.lignes, this.colonnes);
		prods.initZero();
		for (int i = 0; i < tableau.length; i++) {
			for (int j = 0; j < tableau[0].length; j++) {
				prods.setElem(i, j, lambda * this.getElem(i, j));
			}
		}
		return prods;
	}
	
	public MatriceEntiere prodMat(MatriceEntiere m) throws TaillesNonConcordantesException {
		if(this.colonnes != m.lignes)
			throw (new TaillesNonConcordantesException());
		MatriceEntiere prodm =new MatriceEntiere(this.lignes, m.colonnes);
		int localSum = 0;
		for (int i = 0; i < prodm.lignes; i++) {
			for (int j = 0; j < prodm.colonnes; j++) {
				localSum = 0;
				for (int k = 0; k < this.colonnes; k++) {
					localSum += this.getElem(i, k)*m.getElem(k, j); 
				}
				prodm.setElem(i, j, localSum);
			}
			
		}
		
		return prodm;
	}
	
	public static int produitLigneColonne(MatriceEntiere m1, int i, MatriceEntiere m2, int j) throws TaillesNonConcordantesException {
		if (m1.colonnes != m2.lignes)
			throw (new TaillesNonConcordantesException());
		int prod = 0;
		for (int k = 0; k < m1.getNbColonnes(); k++) {
			prod += m1.getElem(i, k) * m2.getElem(k, j);
		}
		return prod;
	}
	public int getElem(int i, int j) {
		return tableau[i][ j];
	}
	
	public void setElem(int i, int j, int val) {
		tableau[i][j] = val;
	}
	
	public int getNbLignes() {
		return lignes;
	}
	
	public int getNbColonnes() {
		return colonnes;
	}
	
	
	public String toString() {
		String output = "";
		for (int i = 0; i < tableau.length; i++) {
			for (int j = 0; j < tableau[0].length; j++) {
				output += String.format("%3d", tableau[i][j]) + " ";
			
			}
			output += "\n";
		}
		return output;
	}
	
	public void affichage() {
		System.out.println(this);
	}
	
}
