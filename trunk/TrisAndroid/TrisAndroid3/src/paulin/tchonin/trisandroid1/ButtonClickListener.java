package paulin.tchonin.trisandroid1;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ButtonClickListener implements View.OnClickListener {
	int location;
	private boolean gameOver;
	private Button boardButtons[];
	private boolean connected;
	private String message;
	private String service;
	private TextView infoTextView;
	private  MatchManager matchManager;
	
	public ButtonClickListener(Button boardButtons[], int location, TextView infoTextView, MatchManager matchManager) {
		this.boardButtons = boardButtons;
		this.location = location;
		this.infoTextView = infoTextView;
		this.matchManager = matchManager;
	}

	public void onClick(View view) {
		if (!gameOver) {

			if (boardButtons[location].isEnabled()) {

				if (UIManager.isMyTurn() && !connected) {

//					message = "mossa	" + client.getIDmatch() + "	G1" + "	"
//							+ location;
//					service = "mossa";
//					client = new ClientAndroid();
//					client.serviceRequest(message, service);
					
					matchManager.sendMove(location);
					
					
					infoTextView.setText(R.string.turn_player2);
					UIManager.setMyTurn(false);
				}

//				if (UIManager.isMyTurn() && connected) {
//				
//					message = "mossa	" + client.getIDmatch() + "	G2" + "	"
//							+ location;
//
//					service = "mossa";
//					client = new ClientAndroid();
//					client.serviceRequest(message, service);
//					infoTextView.setText(R.string.turn_player1);
//					UIManager.setMyTurn(false);
//				}
			}
		}
	}
}
