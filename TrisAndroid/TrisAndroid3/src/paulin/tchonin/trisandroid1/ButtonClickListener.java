package paulin.tchonin.trisandroid1;

import android.view.View;
import android.view.View.OnClickListener;

public class ButtonClickListener implements OnClickListener{

	private int location;
	private MatchManager matchManager;
	private GraphicManager graphicManager;
	
	public ButtonClickListener(int location, MatchManager matchManager, GraphicManager graphicManager) {
		super();
		this.location = location;
		this.matchManager = matchManager;
		this.graphicManager = graphicManager;
	}
	
	public void onClick(View view) {
		
		boolean connected = graphicManager.getActivityOnline().isConnected();

			if (graphicManager.getBoardButtons()[location].isEnabled()) {
				
				if (TurnManager.isMyTurn() && !connected) {
					
					matchManager.sendMove(location);
					matchManager.requestUpdate();

				}else if(TurnManager.isMyTurn() && connected){
					
					matchManager.sendMove(location);
				
				}
			}
	}

}
