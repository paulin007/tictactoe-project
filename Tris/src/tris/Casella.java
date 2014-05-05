/**
 * Questa classe astrae sul concetto di casella, che rappresenta il luogo che 
 * contiene un simbolo x oppure o
 * @author Giacomo
 */
package tris;

import java.util.Observable;


public class Casella extends Observable{
	
	private String simbolo;
	private Posizione posizione;
	private int IDcasella;
	
	public Casella(Posizione posizione, int numero) {
		this.posizione = posizione;
		this.IDcasella = numero;
	}
	
	public Casella(int IDcasella) {
		this.IDcasella=IDcasella;
	}

	public String getSimbolo() {
		return simbolo;
	}

	public void setSimbolo(String simbolo) {
		this.simbolo = simbolo;
		update();
	}

	public Posizione getPosizione() {
		return posizione;
	}

	public void setPosizione(Posizione posizione) {
		this.posizione = posizione;
	}
	
	public int getIDcasella() {
		return IDcasella;
	}

	public void setIDcasella(int iDcasella) {
		IDcasella = iDcasella;
	}
	
	public boolean isVuota(){
		boolean vuota=false;
		
		if(simbolo==null) vuota=true;
		
		return vuota;
	}
	/**
	 * Questo metodo permette di stabilire se la casella è occupata dal giocatore
	 * @return
	 */
	public boolean occupataDaGiocatore(){
		boolean occupata = !isVuota()&&getSimbolo().equalsIgnoreCase("g");
		return occupata;
	}
	/**
	 * Questo metodo permette di stabilire se la casella è occupata dal computer
	 * @return
	 */
	public boolean occupataDaComputer(){
		boolean occupata = !isVuota()&&getSimbolo().equalsIgnoreCase("c");
		return occupata;
	}
	/**
	 * Questo metodo permette di stabilire se due caselle sono consecutive e occupate dal Giocatore
	 * @param casella2
	 * @return
	 */
	public boolean casellaConsecutivaG(Casella casella2){
		boolean casellaConsecutivaOccupata = getIDcasella()==casella2.getIDcasella()+1&&(occupataDaComputer()&&casella2.occupataDaComputer());
		return casellaConsecutivaOccupata;
	}

	@Override
	public String toString(){
		return "Simbolo: "+getSimbolo()+" "+getPosizione()+" IDcasella: "+getIDcasella();
	}
	
	public void update(){
		setChanged();
		notifyObservers();
	}
	public boolean possibileMossa(Casella casella2,Casella casellaSuccessiva){
		boolean possibileMossa = occupataDaComputer()&&casella2.occupataDaComputer()&&casellaSuccessiva.isVuota();
		return possibileMossa;
	}
}
