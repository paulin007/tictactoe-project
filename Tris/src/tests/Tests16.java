package tests;

import tris.TabellaTris;
import vincita.GestoreVincite;

public class Tests16 {
	public static void main(String[] args) {
		TabellaTris caselle = new TabellaTris();
		caselle.creaTabella();
		GestoreVincite gestoreVincite = new GestoreVincite(caselle.getCaselle());
		for (int i = 0; i < 4; i++) {
			caselle.getCaselle().get(i).setSimbolo("g");
		}
	}
}
