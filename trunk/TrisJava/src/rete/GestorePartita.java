package rete;
/**
 * gestisce i turni durante una partita
 * 
 * @author Kokou Adjignon
 */
public class GestorePartita {
	
	private boolean turnoG1;
	private boolean turnoG2;
	
	public GestorePartita() {
		turnoG1=true;
	}
	
	public boolean toccaGiocatore1(){
		return turnoG1;
	}
	
	public boolean toccaGiocatore2(){
		return turnoG2;
	}
	/**
	 * aggiorna i turni durante una partita.
	 */
	public void aggiornaTurno(){
		if(toccaGiocatore1()){
			turnoG1=false;
			turnoG2=true;
		}
		if(toccaGiocatore2()){
			turnoG1=true;
			turnoG2=false;
		}
	}
}
