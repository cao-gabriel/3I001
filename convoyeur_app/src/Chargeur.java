
public class Chargeur implements Runnable{

	private AleaStock stock;
	private Chariot chariot;
	public Chargeur(Chariot chariot, AleaStock stock) {
		this.chariot = chariot;
		this.stock = stock;
	}
	@Override
	public void run() {
		try {
			AleaObjet object = null;
			while(!this.stock.isEmpty()) {
				object = this.stock.take();
				chariot.put(object);
				
			}
			chariot.sendEndSignal();
		} catch (StockVideException e) {
			System.out.println("Le stock est vide");
			e.printStackTrace();
		} catch(InterruptedException e) {
			System.out.println("interrupted");
		}
		
	}

}
