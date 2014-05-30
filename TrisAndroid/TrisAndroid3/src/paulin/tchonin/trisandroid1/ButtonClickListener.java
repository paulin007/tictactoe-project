package paulin.tchonin.trisandroid1;

import android.view.View;
import android.view.View.OnClickListener;

public class ButtonClickListener implements OnClickListener{

	private int location;
	private MatchManager matchManager;
	private GraphicManager graphicManager;
//	private InterpreteMessaggio interpreteMessaggio;
	private boolean gameOver=false;
	private boolean connected=false;
	
	public ButtonClickListener(int location,
			MatchManager matchManager, GraphicManager graphicManager /*,InterpreteMessaggio interpreteMessaggio*/) {
		super();
		this.location = location;
		this.matchManager = matchManager;
		this.graphicManager = graphicManager;
//		this.interpreteMessaggio = interpreteMessaggio;
	}
	
	public void onClick(View view) {
		if (!gameOver) {

			if (graphicManager.getBoardButtons()[location].isEnabled()) {

				if (UIManager.isMyTurn() && !connected) {
					
					matchManager.sendMove(location);
					matchManager.requestUpdate();
//					graphicManager.paint(interpreteMessaggio.getCaselle());
					graphicManager.getInfoTextView().setText(R.string.turn_player2);
					UIManager.setMyTurn(false);
				}

			}
		}
	}
	
	
	
}
