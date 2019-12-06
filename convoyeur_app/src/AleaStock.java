
public class AleaStock {
	private AleaObjet[] stock;
	private int dId = 0, rId = 0;
	private int nbObject = 0;
	
	public AleaStock(int taille) {
		this.stock = new AleaObjet[taille];
	}
	
	public void put(AleaObjet object) throws StockPleinException {
		if(this.nbObject == this.stock.length) {
			throw new StockPleinException();
		}
		this.stock[dId] = object;
		System.out.println("Main : " + object + " is in the stock at the case " + dId);
		this.nbObject++;
		this.dId = (this.dId + 1)%this.stock.length;
	}
	
	public boolean isEmpty() {
		return nbObject == 0;
	}
	
	public AleaObjet take() throws StockVideException {
		if(this.isEmpty()) {
			throw new StockVideException();
		}
		AleaObjet object = this.stock[rId];
		this.stock[rId] = null;
		System.out.println("Chargeur : " + object + " has been taken from the stock at the case " + rId);
		this.nbObject--;
		this.rId = (this.rId + 1)%this.stock.length;
		return object;
	}
	
	
}
