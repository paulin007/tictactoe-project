package rete;

import java.util.ArrayList;
import java.util.StringTokenizer;
/**
 * questa classe ha la responsabilità di interpretare il messaggio ricevuto dal server
 */
public class InterpreteMessaggio {
	
	private String tipoMessaggio;
	private String statoPartita;
	private String IDpartita;
	private String ultimoGiocatore;
	private ArrayList<String> caselle;
	
	/**
	 * Interpreta il messaggio ricevuto dal server
	 */
	public void interpreta(String messaggio){
		StringTokenizer stringTokenizer = new StringTokenizer(messaggio);
		tipoMessaggio = stringTokenizer.nextToken();
		IDpartita = stringTokenizer.nextToken();
		statoPartita = stringTokenizer.nextToken();
		ultimoGiocatore = stringTokenizer.nextToken();
		caselle = new ArrayList<>();
		while(stringTokenizer.hasMoreTokens()){
			caselle.add(stringTokenizer.nextToken());
		}
	}

	public String getTipoMessaggio() {
		return tipoMessaggio;
	}

	public String getStatoPartita() {
		return statoPartita;
	}

	public String getIDpartita() {
		return IDpartita;
	}

	public String getUltimoGiocatore() {
		return ultimoGiocatore;
	}

	public ArrayList<String> getCaselle() {
		return caselle;
	}
	
}
