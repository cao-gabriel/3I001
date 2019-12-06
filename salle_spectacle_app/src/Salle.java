
public class Salle {
	
	private boolean[][] placesLibres;
	private int nbRangs;
	private int nbPlacesParRang;
	
	public Salle(int nbRangs, int nbPlacesParRang) {
		this.nbPlacesParRang = nbPlacesParRang;
		this.nbRangs = nbRangs;
		this.placesLibres = new boolean[this.nbRangs][this.nbPlacesParRang];
		for (int i = 0; i < placesLibres.length; i++) {
			for (int j = 0; j < placesLibres[0].length; j++) {
				this.placesLibres[i][j] = true;
			}
		}
	}
	
	private boolean capaciteOK(int n) {
		int nb = 0;
		for (int i = 0; i < placesLibres.length; i++) {
			for (int j = 0; j < placesLibres[0].length; j++) {
				if(this.placesLibres[i][j]) nb++;
			}
		}
		
		return nb >= n;
	}
	
	private int nContiguesAuRangI ( int n , int i) {
		int placeContigues = 0;
		int nbContigues = 0;
		for (int j = 0; j < placesLibres[0].length; j++) {
			
			if(this.placesLibres[i][j]) {
				
				nbContigues++;
			}
			else {
				placeContigues = j + 1;
			}
			if(nbContigues >= n) return placeContigues;
		}
		
		return -1;
	}
	
	private boolean reserverContigues(int n) {
		int place = -1;
		int i;
		for (i = 0; i < placesLibres.length && place == -1; i++) {
			place = this.nContiguesAuRangI(n, i);
		}
		
		if(place == -1) return false;
		else {
			
			 for (int j = place; j < place + n; j++) {
				 this.placesLibres[i-1][j] = false;
			 }
			 return true;
		}
	}
	
	public synchronized boolean reserver(int n, int id) {
		if(! this.capaciteOK(n)) {
			System.out.println("Il n y a pas assez de place pour le groupe " + id);
			return false;
		}
		else {
			
			if (this.reserverContigues(n)) {
				System.out.println("La réservation de " + n + " places contigues a été effectué par le groupe " + id );
				return true;
			}
			
			else {
				int placeTrouver = 0;
				for (int i = 0; i < placesLibres.length && placeTrouver < n; i++) {
					for (int j = 0; j < placesLibres[0].length && placeTrouver < n; j++) {
						if(this.placesLibres[i][j]) {
							placeTrouver++;
							this.placesLibres[i][j] = false;
						}
						
					}
				}
				System.out.println("La réservation de " + n + " places  a été effectué par le groupe " + id );
				return true;
			}
		}
			
			
	}
	
	public String toString() {
		String salle = "";
		for (int i = 0; i < placesLibres.length; i++) {
			for (int j = 0; j < placesLibres[0].length; j++) {
				if (this.placesLibres[i][j]) {
					salle += "0 ";
				}
				else {
					salle += "1 ";
				}
			}
			salle += "\n";
		}
		return salle;
	}
	
	public void affichage() {
		System.out.println(this);
	}
}
