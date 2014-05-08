/**
 * Questa classe testa l'algoritmo di Difficolta Media
 * 
 */
package tests;

import tris.Simbolo;
import tris.TabellaTris;
import vincita.AlgoritmoTris;

import computerIntelligenza.DifficoltàNonImplementata;
import computerIntelligenza.ProxyDifficoltà;
public class Tests10 {
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