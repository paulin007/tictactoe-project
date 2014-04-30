package tests;

import tris.TabellaTris;
import vincita.VerificaVincita;
/**
 * Questo test verifica la vittoria da parte del Computer
 * @author Dario
 *
 */
public class Tests04 {

	public static void main(String[] args) {
		
		
		TabellaTris tabellaTris = new TabellaTris();
		tabellaTris.creaTabella();
		tabellaTris.getCaselle().get(0).setSimbolo("c");
		tabellaTris.getCaselle().get(1).setSimbolo("c");
		tabellaTris.getCaselle().get(2).setSimbolo("c");
		
		tabellaTris.getCaselle().get(3).setSimbolo("g");
		tabellaTris.getCaselle().get(4).setSimbolo("g");
		tabellaTris.getCaselle().get(8).setSimbolo("g");
		
		
		VerificaVincita verificaVincita = new VerificaVincita();
		
		System.out.println(verificaVincita.stabilisciVincitore(tabellaTris.getCaselle()));
	}
}
