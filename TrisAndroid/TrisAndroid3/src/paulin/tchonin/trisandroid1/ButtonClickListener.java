package paulin.tchonin.trisandroid1;

import managers.IMatchManager;
import managers.ITurnManager;
import managers.TurnManager;
import android.view.View;
import android.view.View.OnClickListener;

public class ButtonClickListener implements OnClickListener{

	private int location;
	private IMatchManager matchManager;
	private GraphicManager graphicManager;
	private ITurnManager turnManager;
	
	public ButtonClickListener(int location, IMatchManager matchManager, GraphicManager graphicManager, ITurnManager turnManager) {
		super();
		this.location = location;
		this.matchManager = matchManager;
		this.graphicManager = graphicManager;
		this.turnManager = turnManager;
	}
	
	public void onClick(View view) {
		
		boolean connected = graphicManager.getActivityOnline().isConnected();

			if (graphicManager.getBoardButtons()[location].isEnabled()) {
				
				if (turnManager.isMyTurn() && !connected) {
					
					matchManager.sendMove(location);
					matchManager.requestUpdate();

				}else if(turnManager.isMyTurn() && connected){
					
					matchManager.sendMove(location);
				
				}
			}
	}

}
