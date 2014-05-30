package paulin.tchonin.trisandroid1;


public class Controller {

	private MatchManager matchManager;
	
	public Controller(MatchManager matchManager) {
		super();
		this.matchManager = matchManager;
	}
	
	public MatchManager getMatchManager() {
		return matchManager;
	}
	
	public void setMatchManager(MatchManager matchManager) {
		this.matchManager = matchManager;
	}
	
}
