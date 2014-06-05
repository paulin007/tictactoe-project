package forza4;

import gioco.Partita;
/**
 * Questa classe ha la responsabilit�� di contenere delle quaterne vincenti
 * per il gioco forza4
 *
 */
public class QuaterneVincenti {
	
	private static int nRighe = 6;
	private static int nColonne = 7;
	private static int forza4 = 4;
	/**
	 * Questo metodo permette di stabilire se un giocatore ha una combinazione vincente
	 * @param partita
	 * @param giocatore
	 * @return
	 */
	public static boolean quaterneVincenti(Partita partita,String giocatore){
		if(vittoriaOrizzontale(partita,giocatore)||vittoriaVerticale(partita, giocatore)||
				vittoriaDiagonale1(partita, giocatore)||vittoriaDiagonale2(partita, giocatore)){
			return true;
		}
		return false;
	}
	
	private static boolean vittoriaOrizzontale(Partita partita,String giocatore){
		for (int j = 0; j < nRighe ; j++) {
			for (int i = 0; i <= nColonne-forza4; i++) {
				if(partita.getTabella().occupata(giocatore,i+j*nColonne, i+1+j*nColonne, i+2+j*nColonne, i+3+j*nColonne)){
					return true;
				}
			}
		}
		return false;
	}
	private static boolean vittoriaVerticale(Partita partita,String giocatore){
		for (int j = 0; j < nRighe ; j++) {
			for (int i = 0; i < nColonne-forza4; i++) {
				if(partita.getTabella().occupata(giocatore,i*nColonne+j, nColonne*(i+1)+j, nColonne*(i+2)+j, nColonne*(i+3)+j)){
					return true;
				}
			}
		}
		return false;
	}
	
	private static boolean vittoriaDiagonale1(Partita partita,String giocatore){
		for (int j = 0; j < nColonne-forza4 ; j++) {
			for (int i = 0; i <= nColonne-forza4; i++) {
				if(partita.getTabella().occupata(giocatore,i+nColonne*j, i+8+nColonne*j, i+2*8+nColonne*j, i+3*8+nColonne*j)){
					return true;
				}
			}
		}
		return false;
	}
	
	private static boolean vittoriaDiagonale2(Partita partita,String giocatore){
		for (int j = 0; j < nColonne-forza4 ; j++) {
			for (int i = 0; i <= nColonne-forza4; i++) {
				if(partita.getTabella().occupata(giocatore,i+3+nColonne*j, i+3+6+nColonne*j, i+3+2*6+nColonne*j, i+3+3*6+nColonne*j)){
					return true;
				}
			}
		}
		return false;
	}
	
}
