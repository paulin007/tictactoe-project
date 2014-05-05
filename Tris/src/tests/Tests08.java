package tests;

import computerIntelligenza.DifficoltàNonImplementata;
import computerIntelligenza.ProxyDifficoltà;
import tris.TabellaTris;

public class Tests08 {
	public static void main(String[] args) {
		TabellaTris tabellaTris = new TabellaTris();
		tabellaTris.creaTabella();
		tabellaTris.getCaselle().get(8).setSimbolo("g");
		ProxyDifficoltà difficoltà = new ProxyDifficoltà(new DifficoltàNonImplementata());
		
		System.out.println(difficoltà.getDifficoltà().generaMossa(tabellaTris));
		for (int i = 0; i < tabellaTris.getCaselle().size(); i++) {
			System.out.println(tabellaTris.getCaselle().get(i));
		}
	}
}
