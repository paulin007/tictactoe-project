package tris;

import gioco.Partita;
/**
 * Questa classe ha la reponsabilità di contenere le terne vincenti,
 * per il gioco del tris
 */
public class TerneVincenti {
	
	private static final int N_RIGHE = 3;
	private static final int N_COLONNE = 3;

	/**
	 * Dice se all'interno della partita e' stata trovata una terna vincente
	 * @param partita
	 * @param giocatore
	 * @return
	 */
	public static boolean terneVincenti(Partita partita, String giocatore){
		if(vittoriaOrizzontale(partita, giocatore)
				|| vittoriaVerticale(partita, giocatore)
				|| vittoriaDiagonale(partita, giocatore)){
			return true;
		}
		return false;
	}
	
	
	public static boolean vittoriaOrizzontale(Partita partita, String giocatore){
		for (int i = 0; i < N_RIGHE; i++) {
			if(partita.getTabella().occupata(giocatore,  N_RIGHE*i, N_RIGHE*i + 1, N_RIGHE*i + 2)){
				return true;
			}
		}
		return false;
	}
	
	public static boolean vittoriaVerticale(Partita partita, String giocatore){
		for (int i = 0; i < N_COLONNE; i++) {
			if(partita.getTabella().occupata(giocatore,  i, i+N_COLONNE, i+2*N_COLONNE)){
				return true;
			}
		}
		return false;
	}
	
	public static boolean vittoriaDiagonale(Partita partita, String giocatore){
		if(partita.getTabella().occupata(giocatore, 0, 4, 8)
				|| partita.getTabella().occupata(giocatore, 2, 4, 6)){
			return true;
		}
		return false;
	}
}
