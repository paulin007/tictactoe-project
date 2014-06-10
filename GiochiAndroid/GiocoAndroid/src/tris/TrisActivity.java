package tris;

import paulin.tchonin.trisandroid1.R;
import managers.IMatchManager;
import managers.MatchManager;
import managers.TurnManager;
import rete.Client;
import rete.IClient;
import rete.IMessageInterpreter;
import rete.MessageInterpreter;
import stats.Statistics;
import utils.ButtonClickListener;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ToggleButton;

/**
 * Questa classe ha la responsabilità di inizializzare e Gestire una nuova
 * partita
 * 
 * @author Paulin
 * 
 */
public class TrisActivity extends Activity {

	private IClient client = new Client();
	private TurnManager turnManager = new TurnManager();
	private IMessageInterpreter messageInterpreter = new MessageInterpreter();
	private IMatchManager matchManager = new MatchManager(client,
			messageInterpreter);
	private GraphicManagerTris graphicManager = new GraphicManagerTris(this,
			matchManager, turnManager);
	private String namePlayer1;
	private String namePlayer2;
	private boolean connected;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_tris);
		graphicManager.createGraphics();
		toggleButtonStart();
		toggleButtonConnect();

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.game_menu, menu);

		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.statistiche:
			Intent intent = new Intent(this, Statistics.class);
			startActivity(intent);
			break;
		case R.id.exitGame:
			matchManager.endMatch();
			TrisActivity.this.finish();
			break;

		}

		return true;
	}

	// Si occupa di fare iniziare una nuova partita dopo aver premuto il
	// pulsante 'Start'
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

					matchManager.createNewMatch(namePlayer1, namePlayer2,
							"tris");

					turnManager.setMyTurn(true);

					infoTextView.setText(R.string.turn_player1);
					startNewGame();

				} else {
					// Si preme sul pulsante stop
					matchManager.endMatch();
					connected = false;

				}
			}
		});

	}

	// Si occupa di collegarsi ad una partita esistente dopo aver premuto il
	// pulsante 'Connect'
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

					turnManager.setMyTurn(false);
					infoTextView.setText(R.string.turn_player2);

					namePlayer1 = editText1.getText().toString();
					namePlayer2 = editText2.getText().toString();

					matchManager.connectToMatch(namePlayer1, namePlayer2,
							"tris");
					matchManager.requestUpdate();

					connected = true;
				} else {
					// Si preme sul pulsante disconnect
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
			boardButtons[i].setOnClickListener(new ButtonClickListener(i,
					matchManager, graphicManager, turnManager));
		}

	}

	public boolean isConnected() {
		return connected;
	}

	public IMessageInterpreter getMessageInterpreter() {
		return messageInterpreter;
	}

}
