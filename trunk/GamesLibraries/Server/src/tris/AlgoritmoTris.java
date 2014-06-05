package tris;

import gioco.Algoritmo;
import gioco.Partita;


/**
 * Questa interfaccia astrae sul concetto di algoritmo, presente in un gioco
 */
public class AlgoritmoTris implements Algoritmo {

	/**
	 * Riceve come parametri le informazioni sulla {@link Partita}, un giocatore
	 * e la sua rispettiva mossa. Ritorna una stringa contenente lo stato della
	 * partita
	 * 
	 * @param giocatore
	 * @param partita
	 * @param mossa
	 */
	public String execute(Partita partita, String giocatore, String mossa) {
		if (partita.getTabella().getCaselle().get(Integer.valueOf(mossa))
				.isVuota()) {
			partita.getTabella().getCaselle().get(Integer.valueOf(mossa)).setSimbolo(giocatore);
			if(TerneVincenti.terneVincenti(partita, giocatore)){
				partita.setRisultato(giocatore);
			}
		}
			
		return partita.toString();
	}

}
