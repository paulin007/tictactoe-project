/**
 * Questa classe vuole verificare il corretto funzionamento delle classi
 * {@link ProxyDifficoltà} e {@link DifficoltàCasuale}, per verificare il corretto
 * inserimento dei simboli all'interno dellla {@link TabellaTris}
 * @author Giacomo
 * 
 * UPDATE = Il test viene rimosso in quanto rimosse le classi su cui lavorava.
 */
package tests;

/*
import tris.TabellaTris;
import vincita.VerificaVincita;
import computerIntelligenza.ProxyDifficoltà;
public class Tests03 {
	public static void main(String[] args) {
		TabellaTris tabellaTris = new TabellaTris();
		tabellaTris.creaTabella();
		ProxyDifficoltà proxyDifficoltà = new ProxyDifficoltà(new DifficoltàCasuale());
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
*/