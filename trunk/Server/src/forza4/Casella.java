package forza4;

import java.util.Observable;
/**
 * Questa classe astrae sul concetto di casella, che rappresenta il luogo che 
 * contiene un simbolo x oppure o
 * @author Giacomo
 */
public class Casella extends Observable{
	
	private String simbolo;
	private int IDcasella;
	
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

	public int getIDcasella() {
		return IDcasella;
	}

	/**
	 * Questo metodo permette di stabilire se una casella �� vuota
	 * @return
	 */
	public boolean isVuota(){
		boolean vuota=false;
		
		if(simbolo==null||Simbolo.casellaVuota.equalsIgnoreCase(simbolo)) vuota=true;
		
		return vuota;
	}
	/**
	 * Questo metodo permette di stabilire se una casella �� occupata da G1
	 * @return
	 */
	public boolean occupataDaG1(){
		boolean occupata = !isVuota()&&getSimbolo().equalsIgnoreCase(Simbolo.simboloG1);
		return occupata;
	}
	/**
	 * Questo metodo permette di stabilire se una casella �� occupata da G2
	 * @return
	 */
	public boolean occupataDaG2(){
		boolean occupata = !isVuota()&&getSimbolo().equalsIgnoreCase(Simbolo.simboloG2);
		return occupata;
	}
	
	public boolean occupataDaSimbolo(String sibolo){
		if(sibolo.equalsIgnoreCase(simbolo)){
			return true;
		}else{
			return false;
		}
	}

	public void update(){
		setChanged();
		notifyObservers();
	}
	
	@Override
	public String toString(){
		return "Simbolo: "+getSimbolo()+" IDcasella: "+getIDcasella();
	}
	/**
	 * Questo metodo stablisce se 4 caselle sono occupate dallo stesso simbolo
	 * @param casella2
	 * @param casella3
	 * @param casella4
	 * @param simbolo
	 * @return
	 */
	public boolean quattroOccupateDaSimbolo(Casella casella2,Casella casella3,Casella casella4,String simbolo){
		if(occupataDaSimbolo(simbolo)&&casella2.occupataDaSimbolo(simbolo)&&casella3.occupataDaSimbolo(simbolo)&&casella4.occupataDaSimbolo(simbolo)){
			return true;
		}else{
		return false;
		}
	}
}
