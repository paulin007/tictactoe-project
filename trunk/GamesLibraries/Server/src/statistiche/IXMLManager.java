package statistiche;

public interface IXMLManager {
	
	public String richiediStatistica(String giocatore, String gioco);
	
	public void nuovaStatistica(String giocatore, String esito, String gioco);

}
