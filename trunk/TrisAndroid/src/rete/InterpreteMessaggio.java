package rete;

import java.util.ArrayList;
import java.util.StringTokenizer;
//TODO responsabilit di interpretare un messaggio e restituire i dati della partita
public class InterpreteMessaggio {
	
	private String tipoMessaggio;
	private String statoPartita;
	private String IDpartita;
	private String ultimoGiocatore;
	private ArrayList<String> caselle;
	
	//TODO javadoc
	public void interpreta(String messaggio){
		StringTokenizer stringTokenizer = new StringTokenizer(messaggio);
		tipoMessaggio = stringTokenizer.nextToken();
		IDpartita = stringTokenizer.nextToken();
		statoPartita = stringTokenizer.nextToken();
		ultimoGiocatore = stringTokenizer.nextToken();
		caselle = new ArrayList();
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
