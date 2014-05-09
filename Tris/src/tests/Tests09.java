/**
 * Questa classe testa l'algoritmo di {@link DifficoltàNonImplementata}
 * 
 */
package tests;

import tris.Simbolo;
import tris.TabellaTris;
import tris.computerIntelligenza.DifficoltàNonImplementata;
import tris.computerIntelligenza.ProxyDifficoltà;
import tris.vincita.AlgoritmoTris;
public class Tests09 {
	public static void main(String[] args) {
		TabellaTris tabellaTris = new TabellaTris();
		tabellaTris.creaTabella();
		ProxyDifficoltà proxyDifficoltà = new ProxyDifficoltà(new DifficoltàNonImplementata());
		for (int i = 0; i < tabellaTris.getCaselle().size(); i++) {
			if(tabellaTris.getCaselle().get(i).isVuota()){
				tabellaTris.getCaselle().get(i).setSimbolo(Simbolo.simboloG1);
				proxyDifficoltà.getDifficoltà().generaMossa(tabellaTris);
			}
		}
		for (int i = 0; i < tabellaTris.getCaselle().size(); i++) {
			System.out.println(tabellaTris.getCaselle().get(i));
		}
		AlgoritmoTris verificaVincita = new AlgoritmoTris();
		System.out.println(verificaVincita.stabilisciVincitore(tabellaTris.getCaselle()));
	}
}