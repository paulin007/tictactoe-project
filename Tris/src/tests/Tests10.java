/**
 * Questa classe testa l'algoritmo di Difficolta Media
 * 
 */
package tests;

import tris.TabellaTris;
import vincita.VerificaVincita;
import computerIntelligenza.DifficoltàNonImplementata;
import computerIntelligenza.ProxyDifficoltà;
public class Tests10 {
	public static void main(String[] args) {
		TabellaTris tabellaTris = new TabellaTris();
		tabellaTris.creaTabella();
		ProxyDifficoltà proxyDifficoltà = new ProxyDifficoltà(new DifficoltàNonImplementata());
		for (int i = 0; i < tabellaTris.getCaselle().size(); i++) {
			if(tabellaTris.getCaselle().get(i).isVuota()){
				tabellaTris.getCaselle().get(i).setSimbolo("g");
				proxyDifficoltà.getDifficoltà().generaMossa(tabellaTris);
			}
		}
		for (int i = 0; i < tabellaTris.getCaselle().size(); i++) {
			System.out.println(tabellaTris.getCaselle().get(i));
		}
		VerificaVincita verificaVincita = new VerificaVincita();
		System.out.println(verificaVincita.stabilisciVincitore(tabellaTris.getCaselle()));
	}
}