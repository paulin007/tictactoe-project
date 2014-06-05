package gioco;

/**
 * Questa classe astrae sul concetto di casella, che rappresenta il luogo che 
 * contiene un simbolo x oppure o
 * @author Giacomo
 */
public class Casella{
	
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
	
	@Override
	public String toString(){
		return "Simbolo: "+getSimbolo()+" IDcasella: "+getIDcasella();
	}

}
