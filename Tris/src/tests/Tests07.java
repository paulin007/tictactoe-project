package tests;

import tris.TabellaTris;

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
		tabellaTris.getCaselle().get(1).setSimbolo("c");
		}
}
