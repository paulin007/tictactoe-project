package rete;


public interface IStatisticInterpreter {

	/**
	 * Questo metodo permette di intepretare una stringa contentenente le statistiche e gli 
	 * achievement
	 * @param message
	 */
	public abstract void intepret(String message);

	public abstract String getWins();

	public abstract String getTie();

	public abstract String getLose();

	public abstract String achievementsToString();

}