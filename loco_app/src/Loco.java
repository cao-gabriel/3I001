public class Loco implements Runnable {

	private int id;
	private static int cpt;
	private final static Object mutex = new Object();

	private SegAccueil sAccueil;
	private SegTournant sTournant;
	private PoolHangars pHangars;

	public Loco(SegAccueil sAccueil, SegTournant sTournant, PoolHangars pHangars) {
		this.sAccueil = sAccueil;
		this.sTournant = sTournant;
		this.pHangars = pHangars;
		synchronized (mutex) {
			this.id = cpt++;
		}
	}

	@Override
	public void run() {
		try {
			sAccueil.reserver(id);
			sTournant.appeler(0, id);
			sTournant.attendrePositionOK(id);
			sTournant.appeler(pHangars.getPositionHangarLibre(), id);
			sTournant.entrer(id);
			sAccueil.liberer(id);
			sTournant.attendrePositionOK(id);
			pHangars.getHangar(sTournant.getPosition()).entrer(id);
			sTournant.sortir(id);
		} catch (InterruptedException e) {
			System.out.println("Loco " + id + " interrompue (ne devrait pas arriver)");
		} catch (HangarTropPetitException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
