/**
 * Questa classe ha la reponsabilità di contenere le terne
 */
package tris.vincita;

import java.util.ArrayList;

public class TerneVincite {
	
	private ArrayList<Terna> terneVincenti;
	
	public TerneVincite() {
		terneVincenti = new ArrayList<>();
		// Vittorie Orizzontali
		terneVincenti.add(new Terna(0, 1, 2));
		terneVincenti.add(new Terna(3, 4, 5));
		terneVincenti.add(new Terna(6, 7, 8));
		// Vittorie Verticali
		terneVincenti.add(new Terna(0, 3, 6));
		terneVincenti.add(new Terna(1, 4, 7));
		terneVincenti.add(new Terna(2, 5, 8));
		// Vittorie Diagonali
		terneVincenti.add(new Terna(0, 4, 8));
		terneVincenti.add(new Terna(2, 4, 6));
	}
	public ArrayList<Terna> getTerneVincenti() {
		return terneVincenti;
	}
}
