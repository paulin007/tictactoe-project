package statistiche;

public class StatisticManager implements IStatisticManager{

	private XMLManager xmlManager;

	public StatisticManager() {
		super();
	}
	
	public String getStatistica(String giocatore) {
			
		XMLDataManager dataManager = new XMLDataManager();
		xmlManager = new XMLManager(dataManager);
		
		Repository repo = new Repository();
		xmlManager.loadData(repo);
			
		return repo.getAchievement(giocatore).getSequence();
	}
	
	public void nuovaStatistica(String giocatore, String esito) {
		
		XMLDataManager dataManager = new XMLDataManager();
		xmlManager = new XMLManager(dataManager);
		
		Repository repo = new Repository();
		xmlManager.loadData(repo);
		
		repo.EditAchievement(giocatore, esito);
		xmlManager.storeData(repo);
	}

}
