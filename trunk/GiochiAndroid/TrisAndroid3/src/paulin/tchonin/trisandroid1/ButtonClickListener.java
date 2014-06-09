package paulin.tchonin.trisandroid1;

import managers.IMatchManager;
import managers.ITurnManager;
import android.view.View;
import android.view.View.OnClickListener;
import forza4.GraphicManagerForza4;

public class ButtonClickListener implements OnClickListener{

	private int location;
	private IMatchManager matchManager;
	private GraphicManager graphicManager;
	private ITurnManager turnManager;
	private GraphicManagerForza4 graphicManagerForza4;
	private String gameName;
	
	public ButtonClickListener(int location, IMatchManager matchManager, GraphicManager graphicManager, ITurnManager turnManager) {
		super();
		this.location = location;
		this.matchManager = matchManager;
		this.graphicManager = graphicManager;
		this.turnManager = turnManager;
		this.gameName = "tris";
	}
	
	public ButtonClickListener(int location, IMatchManager matchManager, GraphicManagerForza4 graphicManagerForza4, ITurnManager turnManager) {
		super();
		this.location = location;
		this.matchManager = matchManager;
		this.graphicManagerForza4 = graphicManagerForza4;
		this.turnManager = turnManager;
		this.gameName = "forza4";
	}
	
	public void onClick(View view) {
		boolean connected;
		if(gameName.equalsIgnoreCase("tris")){
		 connected = graphicManager.getActivityOnline().isConnected();
	          
			if (graphicManager.getBoardButtons()[location].isEnabled()) {
				
				sendRequest(connected);
			}	
		}else if(gameName.equalsIgnoreCase("forza4")){
			connected = graphicManagerForza4.getForza4Activity().isConnected();
			sendRequest(connected);
			
		}
		
		
	}

	private void sendRequest(boolean connected) {
		if (turnManager.isMyTurn() && !connected) {
			
			matchManager.sendMove(location);
			matchManager.requestUpdate();

		}else if(turnManager.isMyTurn() && connected){
			
			matchManager.sendMove(location);
		
		}
	}

}
