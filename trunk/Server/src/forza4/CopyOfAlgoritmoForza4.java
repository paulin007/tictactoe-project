package forza4;

public class CopyOfAlgoritmoForza4 {
	
	private static int nRighe = 6;
	private static int nColonne = 7;
	
	public String execute (Partita partita,String giocatore, String mossa){
		int casella = casellaSuccessivaLibera(partita, Integer.valueOf(mossa));
		if(mossaValida(partita, casella)){
			partita.getCelle().getCaselle().get(casella).setSimbolo(giocatore);
			if(QuaterneVincenti.isPresenteVittoria(partita, giocatore)){
				partita.setRisultato(giocatore);
			}
			//stabilisciSituazione(partita, giocatore);
		}
		return partita.toString();
		
	}
	
	public boolean mossaValida(Partita partita, int casella){
		if(casella!=-1&&!partita.isConclusa()){
		return true;
		}else{
			return false;
		}
	}
	
//	private void stabilisciSituazione(Partita partita,String giocatore){
//		vittoriaOrizzontale(partita, giocatore);
//		vittoriaVerticale(partita, giocatore);
//		vittoriaDiagonale1(partita, giocatore);
//		vittoriaDiagonale2(partita, giocatore);
//	}
//	
//	private boolean vittoriaOrizzontale(Partita partita,String giocatore){
//		boolean vittoria = false;
//		for (int j = 0; j < nRighe ; j++) {
//			for (int i = 0; i <= nColonne-forza4; i++) {
//				Casella casella1 = partita.getCelle().getCaselle().get(i+j*nColonne);
//				Casella casella2 = partita.getCelle().getCaselle().get(i+1+j*nColonne);
//				Casella casella3 = partita.getCelle().getCaselle().get(i+2+j*nColonne);
//				Casella casella4 = partita.getCelle().getCaselle().get(i+3+j*nColonne);
//				if(casella1.quattroOccupateDaSimbolo(casella2, casella3, casella4, giocatore)){
//					System.out.println("Ha vinto "+giocatore);
//					partita.setRisultato(giocatore);
//					vittoria = true;
//				}
//			}
//		}
//		return vittoria;
//	}
//	private boolean vittoriaVerticale(Partita partita,String giocatore){
//		boolean vittoria = false;
//		for (int j = 0; j < nColonne; j++) {
//			for (int i = 0; i < nColonne-forza4; i++) {
//				Casella casella1 = partita.getCelle().getCaselle().get(i*nColonne+j);
//				Casella casella2 = partita.getCelle().getCaselle().get(nColonne*(i+1)+j);
//				Casella casella3 = partita.getCelle().getCaselle().get(nColonne*(i+2)+j);
//				Casella casella4 = partita.getCelle().getCaselle().get(nColonne*(i+3)+j);
//				if(casella1.quattroOccupateDaSimbolo(casella2, casella3, casella4, giocatore)){
//					System.out.println("Ha vinto "+giocatore);
//					partita.setRisultato(giocatore);
//					vittoria = true;
//				}
//			}
//		}
//		return vittoria;
//	}
//	private boolean vittoriaDiagonale1(Partita partita,String giocatore){
//		boolean vittoria = false;
//		for (int j = 0; j < 3; j++) {
//			for (int i = 0; i <=nColonne-forza4; i++) {
//				Casella casella1 = partita.getCelle().getCaselle().get(i+nColonne*j);
//				Casella casella2 = partita.getCelle().getCaselle().get(i+8+nColonne*j);
//				Casella casella3 = partita.getCelle().getCaselle().get(i+2*8+nColonne*j);
//				Casella casella4 = partita.getCelle().getCaselle().get(i+3*8+nColonne*j);
//				if(casella1.quattroOccupateDaSimbolo(casella2, casella3, casella4, giocatore)){
//					System.out.println("Ha vinto "+giocatore);
//					partita.setRisultato(giocatore);
//					vittoria = true;
//				}
//			}
//		}
//		return vittoria;
//	}
//	private boolean vittoriaDiagonale2(Partita partita,String giocatore){
//		boolean vittoria = false;
//		for (int j = 0; j < 3; j++) {
//			for (int i = 0; i < nColonne-3; i++) {
//				Casella casella1 = partita.getCelle().getCaselle().get(i+3+nColonne*j);
//				Casella casella2 = partita.getCelle().getCaselle().get(i+3+6+nColonne*j);
//				Casella casella3 = partita.getCelle().getCaselle().get(i+3+2*6+nColonne*j);
//				Casella casella4 = partita.getCelle().getCaselle().get(i+3+3*6+nColonne*j);
//				if(casella1.quattroOccupateDaSimbolo(casella2, casella3, casella4, giocatore)){
//					System.out.println("Ha vinto "+giocatore);
//					partita.setRisultato(giocatore);
//					vittoria = true;
//				}
//			}
//		}
//		return vittoria;
//	}
	private int casellaSuccessivaLibera(Partita partita,int colonna){
		int posizione = 0; 
		for (int i = 0; i < nRighe; i++) {
			posizione = colonna+nColonne*(5-i);
			if(partita.getCelle().getCaselle().get(posizione).isVuota()){
				return posizione;
			}
			else{
				posizione = -1;
			}
		}
		return posizione;
	}
}
