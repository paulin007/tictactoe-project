package forza4;

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
	public static boolean isPresenteVittoria(Partita partita,String giocatore){
		if(vittoriaOrizzontale(partita,giocatore)||vittoriaVerticale(partita, giocatore)||
				vittoriaDiagonale1(partita, giocatore)||vittoriaDiagonale2(partita, giocatore)){
			return true;
		}
		return false;
	}
	
	private static boolean vittoriaOrizzontale(Partita partita,String giocatore){
		for (int j = 0; j < nRighe ; j++) {
			for (int i = 0; i <= nColonne-forza4; i++) {
				if(partita.getCelle().occupata(giocatore,i+j*nColonne, i+1+j*nColonne, i+2+j*nColonne, i+3+j*nColonne)){
					return true;
				}
			}
		}
		return false;
	}
	private static boolean vittoriaVerticale(Partita partita,String giocatore){
		boolean vittoria = false;
		for (int j = 0; j < nColonne; j++) {
			for (int i = 0; i < nColonne-forza4; i++) {
				Casella casella1 = partita.getCelle().getCaselle().get(i*nColonne+j);
				Casella casella2 = partita.getCelle().getCaselle().get(nColonne*(i+1)+j);
				Casella casella3 = partita.getCelle().getCaselle().get(nColonne*(i+2)+j);
				Casella casella4 = partita.getCelle().getCaselle().get(nColonne*(i+3)+j);
				if(casella1.quattroOccupateDaSimbolo(casella2, casella3, casella4, giocatore)){
					vittoria = true;
				}
			}
		}
		return vittoria;
	}
	private static boolean vittoriaDiagonale1(Partita partita,String giocatore){
		boolean vittoria = false;
		for (int j = 0; j < 3; j++) {
			for (int i = 0; i <=nColonne-forza4; i++) {
				Casella casella1 = partita.getCelle().getCaselle().get(i+nColonne*j);
				Casella casella2 = partita.getCelle().getCaselle().get(i+8+nColonne*j);
				Casella casella3 = partita.getCelle().getCaselle().get(i+2*8+nColonne*j);
				Casella casella4 = partita.getCelle().getCaselle().get(i+3*8+nColonne*j);
				if(casella1.quattroOccupateDaSimbolo(casella2, casella3, casella4, giocatore)){
					vittoria = true;
				}
			}
		}
		return vittoria;
	}
	private static boolean vittoriaDiagonale2(Partita partita,String giocatore){
		boolean vittoria = false;
		for (int j = 0; j < 3; j++) {
			for (int i = 0; i < nColonne-3; i++) {
				Casella casella1 = partita.getCelle().getCaselle().get(i+3+nColonne*j);
				Casella casella2 = partita.getCelle().getCaselle().get(i+3+6+nColonne*j);
				Casella casella3 = partita.getCelle().getCaselle().get(i+3+2*6+nColonne*j);
				Casella casella4 = partita.getCelle().getCaselle().get(i+3+3*6+nColonne*j);
				if(casella1.quattroOccupateDaSimbolo(casella2, casella3, casella4, giocatore)){
					vittoria = true;
				}
			}
		}
		return vittoria;
	}
}
