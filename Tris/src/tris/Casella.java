package tris;
/**
 * Questa classe astrae sul concetto di casella, che rappresenta il luogo che 
 * contiene un simbolo x oppure o
 * @author Giacomo
 */


import java.util.Observable;


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

	public void setIDcasella(int iDcasella) {
		IDcasella = iDcasella;
	}
	/**
	 * Questo metodo permette di stabilire se una casella è vuota
	 * @return
	 */
	public boolean isVuota(){
		boolean vuota=false;
		
		if(simbolo==null) vuota=true;
		
		return vuota;
	}
	/**
	 * Questo metodo permette di stabilire se una casella è occupata da G1
	 * @return
	 */
	public boolean occupataDaG1(){
		if(getSimbolo().equalsIgnoreCase(Simbolo.simboloG1)){
			return true;
		}else{
			return false;
		}
	}
	/**
	 * Questo metodo permette di stabilire se una casella è occupata da G2
	 * @return
	 */
	public boolean occupataDaG2(){
		if(getSimbolo().equalsIgnoreCase(Simbolo.simboloG2)){
			return true;
		}else{
			return false;
		}
	}
	/**
	 * Questo metodo permette di stabilire se una casella è occupata da un generico
	 * {@link Simbolo}
	 * @param simbolo
	 * @return
	 */
	public boolean occupataDaSimbolo(Simbolo simbolo){
		if(getSimbolo().equalsIgnoreCase(simbolo.toString())){
			return true;
		}else{
			return false;
		}
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
		
		if(occupataDaGiocatore() &&casella2.occupataDaGiocatore()){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public String toString(){
		return "Simbolo: "+getSimbolo()+" IDcasella: "+getIDcasella();
	}
	
	public void update(){
		setChanged();
		notifyObservers();
	}
	/**
	 * Questo metod permette di verificare se due caselle sono occupate dal computer e una terza
	 * casella è libera
	 * @param casella2
	 * @param casellaSuccessiva
	 * @return
	 */
	public boolean possibileMossa(Casella casella2,Casella casellaSuccessiva){
		if(occupataDaComputer()&&casella2.occupataDaComputer()&&casellaSuccessiva.isVuota()){
			return true;
		}else{
			return false;
		}
	}
}
