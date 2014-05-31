package paulin.tchonin.trisandroid1;

import rete.InterpreteMessaggio;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ToggleButton;

/**
 * Questa classe ha la responsabilità di inizializzare una nuova partita
 * 
 * @author Paulin
 * 
 */

public class ActivityOnline extends Activity {

	private InterpreteMessaggio interpreteMessaggio = new InterpreteMessaggio();
	private MatchManager matchManager = new MatchManager(interpreteMessaggio);
	private Controller controller = new Controller(matchManager);
	private GraphicManager graphicManager = new GraphicManager(this,interpreteMessaggio, controller);
	private String namePlayer1;
	private String namePlayer2;
	private boolean connected;
	
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.screen_online);
		
		graphicManager.createGraphics();
		
		toggleButtonStart();
		toggleButtonConnect();
	
	}

	// Si occupa di fare iniziare una nuova partita dopo aver premuto il pulsante 'Start'
	private void toggleButtonStart() {

		final ToggleButton startButton = graphicManager.getStartButton();
		final EditText editText1 = graphicManager.getEditText1();
		final EditText editText2 = graphicManager.getEditText2();
		final TextView infoTextView = graphicManager.getInfoTextView();

		startButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if (startButton.isChecked()) {

					namePlayer1 = editText1.getText().toString();
					namePlayer2 = editText2.getText().toString();

					matchManager.createNewMatch(namePlayer1, namePlayer2);
					
					TurnManager.setMyTurn(true);

					infoTextView.setText(R.string.turn_player1);
					startNewGame();

				} else {
					//Si preme sul pulsante stop
					matchManager.endMatch();
					connected = false;

				}
			}
		});

	}

	// Si occupa di collegarsi ad una partita esistente dopo aver premuto il pulsante 'Connect'
	private void toggleButtonConnect() {
		final ToggleButton connectButton = graphicManager.getConnectButton();
		final EditText editText1 = graphicManager.getEditText1();
		final EditText editText2 = graphicManager.getEditText2();
		final TextView infoTextView = graphicManager.getInfoTextView();

		
		connectButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if (connectButton.isChecked()) {
					
					startNewGame();
					
					TurnManager.setMyTurn(false);
					infoTextView.setText(R.string.turn_player2);
					
					namePlayer1 = editText1.getText().toString();
					namePlayer2 = editText2.getText().toString();
					
					matchManager.connectToMatch(namePlayer1, namePlayer2);
					matchManager.requestUpdate();
					
					connected = true;
				} else {
					//Si preme sul pulsante disconnect
					matchManager.endMatch();
					connected = false;
				}
			}
		});

	}
	
	/**
	 * Si occupa di inizializzare un nuovo match
	 */
	private void startNewGame() {
		Button[] boardButtons = graphicManager.getBoardButtons();
		graphicManager.clear();
		for (int i = 0; i < boardButtons.length; i++) {
			boardButtons[i].setText("");
			boardButtons[i].setEnabled(true);
			boardButtons[i].setOnClickListener(new ButtonClickListener(i, matchManager, graphicManager));
		}

	}
	
	public boolean isConnected() {
		return connected;
	}

}
