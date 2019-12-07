public class PoolHangars {

	private Hangar[] hangars;
	
	public PoolHangars(int taille) {
		this.hangars = new Hangar[taille];
		for (int i = 0; i < hangars.length; i++) {
			hangars[i] = new Hangar();
		}
	}
	
	public int getPositionHangarLibre() throws HangarTropPetitException{
		for (int i = 0; i < hangars.length; i++) {
			if(!hangars[i].isPlein()) return i+1;
		}
		throw new HangarTropPetitException();
		
	}
	public Hangar getHangar(int position) {
		
		return hangars[position-1];
	}

}
