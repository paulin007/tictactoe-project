package rete;

import java.util.ArrayList;

public interface IInterpreteStatistiche {

	/**
	 * Questo metodo permette di intepretare una stringa contentenente le statistiche e gli 
	 * achievement
	 * @param messaggio
	 */
	public abstract void intepreta(String messaggio);

	public abstract String getVittorie();

	public abstract String getPareggi();

	public abstract String getSconfitte();

	public abstract ArrayList<String> getAchievements();

}