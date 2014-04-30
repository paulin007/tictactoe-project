package tests;

import tris.TabellaTris;
import vincita.GestoreVincite;
import vincita.VerificaVincita;
import vincita.VisualizzatoreRisultato;

public class Tests07 {
	public static void main(String[] args) {
		TabellaTris tabellaTris = new TabellaTris();
		tabellaTris.creaTabella();
		tabellaTris.getCaselle().get(2).setSimbolo("c");
		tabellaTris.getCaselle().get(3).setSimbolo("c");
		tabellaTris.getCaselle().get(0).setSimbolo("g");
		tabellaTris.getCaselle().get(4).setSimbolo("g");
		tabellaTris.getCaselle().get(8).setSimbolo("g");
		//Non mi piace, domani lo sistemo :)
		VisualizzatoreRisultato risultato = new VisualizzatoreRisultato(new GestoreVincite(new VerificaVincita(), tabellaTris.getCaselle()));
		tabellaTris.getCaselle().get(1).setSimbolo("c");
		}
}
