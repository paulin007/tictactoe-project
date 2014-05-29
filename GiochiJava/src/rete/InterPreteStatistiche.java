package rete;

import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Questa classe ha la responsabilità di interpretare un messaggio, contenente le statistiche dei giochi
 * 
 */

public class InterPreteStatistiche {
	
	private String vittorie;
	private String pareggi;
	private String sconfitte;
	private ArrayList<String> achievements = new ArrayList<>();
	
	/**
	 * Questo metodo permette di intepretare una stringa contentenente le statistiche e gli 
	 * achievement
	 * @param messaggio
	 */
	public void intepreta (String messaggio){
		StringTokenizer stringTokenizer = new StringTokenizer(messaggio);
		vittorie = stringTokenizer.nextToken();
		pareggi = stringTokenizer.nextToken();
		sconfitte = stringTokenizer.nextToken("@").replace(" ", "");
		achievements.clear();
		while(stringTokenizer.hasMoreTokens()){
			achievements.add(stringTokenizer.nextToken("@"));
		}
	}

	public String getVittorie() {
		return vittorie;
	}
	
	public String getPareggi() {
		return pareggi;
	}

	public String getSconfitte() {
		return sconfitte;
	}

	public ArrayList<String> getAchievements() {
		return achievements;
	}
}
