
package forza4;
/**
 *Responsabiltà: implementa l'algoritmo del gioco Forza4
 */
import gioco.Algoritmo;
import gioco.Partita;

public class AlgoritmoForza4 implements Algoritmo {
	
	private static int nRighe = 6;
	private static int nColonne = 7;
	private static int mossaNonvalida = -1;
	
	public String execute (Partita partita,String giocatore, String mossa){
		int casella = casellaSuccessivaLibera(partita, Integer.valueOf(mossa));
		if(mossaValida(partita, casella)){
			partita.getTabella().getCaselle().get(casella).setSimbolo(giocatore);
				partita.setUltimoGiocatore(giocatore);
			if(QuaterneVincenti.quaterneVincenti(partita, giocatore)){
				partita.setRisultato(giocatore);
			}
		}
		return partita.toString();
	}
	
	/*
	 * Questo metodo permette di stabilire se una mossa Ã¨ valida
	 */
	private boolean mossaValida(Partita partita, int casella){
		if(casella!=mossaNonvalida && !partita.isConclusa()){
		return true;
		}else{
			return false;
		}
	}
	
	/*
	 * Questo metodo serve per capire qual'Ã¨ la casella libera successiva, presente
	 * nella colonna
	 */
	private int casellaSuccessivaLibera(Partita partita,int colonna){
		int posizione = 0; 
		for (int i = 0; i < nRighe; i++) {
			posizione = colonna+nColonne*(5-i);
			if(partita.getTabella().getCaselle().get(posizione).isVuota()){
				return posizione;
			}
			else{
				posizione = mossaNonvalida;
			}
		}
		return posizione;
	}
}
