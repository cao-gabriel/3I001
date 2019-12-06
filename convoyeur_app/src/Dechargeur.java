
public class Dechargeur implements Runnable{
	private Chariot chariot;
	public Dechargeur(Chariot chariot) {
		this.chariot = chariot;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(!chariot.chargeurFini) {
			try {
				chariot.take();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
