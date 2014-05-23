/**
 * Questa classe ha responsabilit?? di costruire il luogo geometrico, che contiene
 * le {@link Casella}, dove l'utente inserira le proprie mosse
 * @author Giacomo
 */
package forza4;

import java.util.ArrayList;

public class Tabella  {
	
	private ArrayList<Casella> caselle;
	private int nRighe = 3;
	private int nColonne = 3;
	
	
	
	public Tabella(int nRighe, int nColonne) {
		super();
		this.nRighe = nRighe;
		this.nColonne = nColonne;
		creaTabella();
	}

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
	
	@Override
	public String toString(){
		String partita="";
		for (int i = 0; i < getCaselle().size(); i++) {
			partita+=" "+getCaselle().get(i).getSimbolo();
		}
		return partita;
	}
	
	public boolean occupata(String giocatore, int...indexs){
		int counter = 0;
		for (int i = 0; i < indexs.length; i++) {
			if(getCaselle().get(indexs[i]).occupataDaSimbolo(giocatore)){
				counter++;
			}
		}
		if(counter==indexs.length){
			return true;
		}else{
			return false;
		}
	}
}
