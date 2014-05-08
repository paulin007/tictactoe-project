package tests;

import tris.Simbolo;
import tris.TabellaTris;

import computerIntelligenza.DifficoltàNonImplementata;
import computerIntelligenza.ProxyDifficoltà;

public class Tests08 {
	public static void main(String[] args) {
		TabellaTris tabellaTris = new TabellaTris();
		tabellaTris.creaTabella();
		tabellaTris.getCaselle().get(8).setSimbolo(Simbolo.simboloG1);
		ProxyDifficoltà difficoltà = new ProxyDifficoltà(new DifficoltàNonImplementata());
		
		System.out.println(difficoltà.getDifficoltà().generaMossa(tabellaTris));
		for (int i = 0; i < tabellaTris.getCaselle().size(); i++) {
			System.out.println(tabellaTris.getCaselle().get(i));
		}
	}
}
