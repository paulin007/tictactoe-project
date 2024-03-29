package utils;

import tris.GraphicManagerTris;
import managers.IMatchManager;
import managers.ITurnManager;
import android.view.View;
import android.view.View.OnClickListener;
import forza4.GraphicManagerForza4;
/**
 * Associa un listener ad ogni bottone o dice cosa deve fare quando un bottone viene schiacciato
 */
public class ButtonClickListener implements OnClickListener{

	private int location;
	private IMatchManager matchManager;
	private GraphicManagerTris graphicManager;
	private ITurnManager turnManager;
	private GraphicManagerForza4 graphicManagerForza4;
	private String gameName;
	
	/*
	 * Questo è il costruttore usato per Tris
	 */
	public ButtonClickListener(int location, IMatchManager matchManager, GraphicManagerTris graphicManager, ITurnManager turnManager) {
		super();
		this.location = location;
		this.matchManager = matchManager;
		this.graphicManager = graphicManager;
		this.turnManager = turnManager;
		this.gameName = "tris";
	}
	
	/*
	 * Questo è il costruttore usato per Forza4
	 */
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
		 connected = graphicManager.getTrisActivity().isConnected();
	          
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
