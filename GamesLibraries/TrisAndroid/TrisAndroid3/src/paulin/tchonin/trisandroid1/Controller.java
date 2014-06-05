package paulin.tchonin.trisandroid1;

import java.util.Observer;

public class Controller {

	private IMatchManager matchManager;
	
	public Controller(IMatchManager matchManager) {
		super();
		this.matchManager = matchManager;
	}
	
	public IMatchManager getMatchManager() {
		return matchManager;
	}
	
	public void setMatchManager(IMatchManager matchManager) {
		this.matchManager = matchManager;
	}
	
	public void addObserverToMatchManager(Observer observer){		//TODO Va veramente bene così?
			getMatchManager().addObserver(observer);
	}
	
}
