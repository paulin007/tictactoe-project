package statistiche;

public interface IAchievements {

	/**
	 * Interfaccia per la gestione di Achievements diversi.
	 * 
	 * @param sequence Sequenza di risultati su cui calcolare l'achievement.
	 * @param param parametri opzionali per il calcolo di un achievement.
	 * @return se è stato conquistato o meno l'achievement.
	 */
	public boolean gotAchievements(String sequence, int param);
	
}
