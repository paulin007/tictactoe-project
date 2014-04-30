/**
 * Questo test vuole verificare se la classe {@link VerificaVincita} è in grado 
 * di validare la vittoria del giocatore
 * @author Giacomo
 */
package tests;

import tris.TabellaTris;
import vincita.VerificaVincita;

public class Tests02 {
	public static void main(String[] args) {
		TabellaTris tabellaTris = new TabellaTris();
		tabellaTris.creaTabella();
		inserisciSimbolo(tabellaTris);
		VerificaVincita verificaVincita = new VerificaVincita();
		verificaVincita.separaMosse(tabellaTris.getCaselle());
		System.out.println(verificaVincita.stabilisciVincitore(tabellaTris.getCaselle()));
	}
	
	private static void inserisciSimbolo(TabellaTris tabellaTris) {
		for (int i = 0; i <=5; i++) {
			tabellaTris.getCaselle().get(i).setSimbolo("g");
		}
		for (int i = 6; i <9; i++) {
			tabellaTris.getCaselle().get(i).setSimbolo("c");
		}
	}
}
