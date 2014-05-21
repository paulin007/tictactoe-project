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
		
		if(simbolo==null||Simbolo.casellaVuota.equalsIgnoreCase(simbolo)) vuota=true;
		
		return vuota;
	}
	/**
	 * Questo metodo permette di stabilire se una casella è occupata da G1
	 * @return
	 */
	public boolean occupataDaG1(){
		boolean occupata = !isVuota()&&getSimbolo().equalsIgnoreCase(Simbolo.simboloG1);
		return occupata;
	}
	/**
	 * Questo metodo permette di stabilire se una casella è occupata da G2
	 * @return
	 */
	public boolean occupataDaG2(){
		boolean occupata = !isVuota()&&getSimbolo().equalsIgnoreCase(Simbolo.simboloG2);
		return occupata;
	}
	/**
	 * Questo metodo permette di stabilire se una casella è occupata da un generico
	 * {@link Simbolo}
	 * @param simbolo
	 * @return
	 */
	//TODO QUESTO METODO NON E' USATO DA ALCUNA PARTE!!!
//	public boolean occupataDaSimbolo(Simbolo simbolo){
//		if(getSimbolo().equalsIgnoreCase(simbolo.toString())){
//			return true;
//		}else{
//			return false;
//		}
//	}
	/**
	 * Questo metodo permette di stabilire se due caselle sono consecutive e occupate dal Giocatore
	 * @param casella2
	 * @return
	 */
	public boolean casellaConsecutivaG1(Casella casella2){
		if(occupataDaG1() &&casella2.occupataDaG1()){
			return true;
		}else{
			return false;
		}
	}
	/**
	 * Questo metodo permette di verificare se due caselle sono occupate da G2 e una terza
	 * casella è libera
	 * @param casella2
	 * @param casellaSuccessiva
	 * @return
	 */
	public boolean possibileMossaG2(Casella casella2,Casella casellaSuccessiva){
		if(occupataDaG2()&&casella2.occupataDaG2()&&casellaSuccessiva.isVuota()){
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
}
