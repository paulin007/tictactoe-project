/**
 * Questa classe ha responsabilità di costruire il luogo geometrico, che contiene
 * le {@link Casella}, dove l'utente inserira le proprie mosse
 * @author Giacomo
 */
package tris;

import java.util.ArrayList;

public class TabellaTris  {
	
	private ArrayList<Casella> caselle;
	private static int nRighe = 3;
	private static int nColonne = 3;

	//TODO SI PUO INSERIRE IL METODO creaTabella nel costruttore
	
	/**
	 * Questo metodo permette di creare una tabella per il tris,
	 * formata da un certo numero di {@link Casella}
	 */
	public void creaTabella(){
		caselle = new ArrayList<>();
		int k=0;
		for (int i = 1; i <= nRighe; i++) {
			for (int j = 1; j <= nColonne; j++) {
				Casella casella = new Casella(k);
				caselle.add(casella);
				k++;
			}
		}
	}

	public ArrayList<Casella> getCaselle() {
		return caselle;
	}

	public void setCaselle(ArrayList<Casella> caselle) {
		this.caselle = caselle;
	}
	
	@Override
	public String toString(){
		String partita="";
		for (int i = 0; i < getCaselle().size(); i++) {
			partita+=" "+getCaselle().get(i).getSimbolo();
		}
		return partita;
	}
}
