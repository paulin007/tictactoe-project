/**
 * Questa classe astrae sul concetto di casella, che rappresenta il luogo che 
 * contiene un simbolo x oppure o
 * @author Giacomo
 */
package tris;

import java.util.Observable;


public class Casella extends Observable{
	
	private String simbolo;
	Posizione posizione;
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
		if(getSimbolo()==null){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public String toString(){
		return "Simbolo: "+getSimbolo()+" "+getPosizione()+" IDcasella: "+getIDcasella();
	}
	
	public void update(){
		setChanged();
		notifyObservers();
	}
}
