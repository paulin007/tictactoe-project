/**
 * Questo test ha lo scopo di verificare la corretta creazione della {@link TabellaTris}
 * che si basa sull'utilizzo delle classi Casella e {@link Posizione}
 * @author Giacomo
 * 
 */
package tests;

import tris.TabellaTris;

public class Tests01 {
	public static void main(String[] args) {
		TabellaTris tabellaTris = new TabellaTris();
		tabellaTris.creaTabella();
		inserisciSimbolo(tabellaTris);
		mostraCaselle(tabellaTris);
	}

	private static void mostraCaselle(TabellaTris tabellaTris) {
		for (int i = 0; i < tabellaTris.getCaselle().size(); i++) {
			System.out.println(tabellaTris.getCaselle().get(i));
		}
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
