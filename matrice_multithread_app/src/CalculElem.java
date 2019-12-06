
public class CalculElem implements Runnable {

	private int i, j;
	private MatriceEntiere m, m1, m2;
	
	public CalculElem(MatriceEntiere m, MatriceEntiere m1, MatriceEntiere m2,int i, int j) {
		this.i = i;
		this.j = j;
		this.m = m;
		this.m1 = m1;
		this.m2 = m2;
	}
	
	@Override
	public void run() {
		try {
			m.setElem(i, j, MatriceEntiere.produitLigneColonne(m1, i, m2, j));
		} catch (TaillesNonConcordantesException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
