package trisGui;

import grafica.Simbolo;

/**
 * Questa classe ha la reponsabilità di gestire i turni durante la parte e durante la fase iniziale
 * @author Giacomo
 *
 */

public class SituazioneTurno {
	
	private String mioSimbolo;
	private String miaIcona;
	private String IDpartita;
	private String simboloAvversario;
	private boolean isMioTurno = false;
	private Icona[] icone = new Icona[2];
	
	
	public SituazioneTurno(String mioSimbolo, String miaIcona, String iDpartita) {
		super();
		this.mioSimbolo = mioSimbolo;
		this.miaIcona = miaIcona;
		IDpartita = iDpartita;
		setSimboloAvversario();
		setIcona(miaIcona);
	}
	/**
	 * Questo metodo, dato l'ultimo giocatore, è in grado di stabilire se è il mio turno oppure no
	 * @param ultimoGiocatore
	 */
	public void calcolaTurno(String ultimoGiocatore){
		if(!mioSimbolo.equalsIgnoreCase(ultimoGiocatore)){
			isMioTurno = true;
		}else{
			isMioTurno = false;
		}
	}

	public String getMioSimbolo() {
		return mioSimbolo;
	}

	public String getMiaIcona() {
		return miaIcona;
	}

	
	public String getIDpartita() {
		return IDpartita;
	}

	public String getSimboloAvversario() {
		return simboloAvversario;
	}

	public boolean isMioTurno() {
		return isMioTurno;
	}

	private void setSimboloAvversario(){
		if(mioSimbolo.equalsIgnoreCase(Simbolo.simboloG1)){
			simboloAvversario = Simbolo.simboloG2;
		}
		if(mioSimbolo.equalsIgnoreCase(Simbolo.simboloG2)){
			simboloAvversario = Simbolo.simboloG1;
		}
	}
	/**
	 * Questo metodo permette di impostare il tipo di icona che viene mostrata a video
	 * @param iconaMia
	 */
	private void setIcona(String iconaMia){
		if(iconaMia.equalsIgnoreCase("Croce")){
			this.icone[0] = new Croce();
			this.icone[1] = new Cerchio();
		}
		if(iconaMia.equalsIgnoreCase("Cerchio")){
			this.icone[0] = new Cerchio();
			this.icone[1] = new Croce();
		}
	}

	public Icona[] getIcone() {
		return icone;
	}
	/**
	 * Questo metodo permette di stabilire a chi tocca ad iniziare, all'inizio della partita
	 * @return
	 */
	public boolean inizioIO(){
		if(Simbolo.simboloG1.equalsIgnoreCase(mioSimbolo)){
			isMioTurno = true;
			return true;
		}else{
			isMioTurno = false;
			return false;
		}
	}
}
