package statistiche;

public interface IStatisticManager {
	
	public String getStatistica(String giocatore);
	
	public void nuovaStatistica(String giocatore, String esito);
}
