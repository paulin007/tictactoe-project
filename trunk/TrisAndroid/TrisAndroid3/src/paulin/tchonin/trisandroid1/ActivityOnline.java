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

	private static boolean connected = false;
	private String namePlayer1;
	private String namePlayer2;
	private InterpreteMessaggio interpreteMessaggio = new InterpreteMessaggio();
	private MatchManager matchManager = new MatchManager(interpreteMessaggio);
	private Controller controller = new Controller(matchManager);
	private GraphicManager graphicManager = new GraphicManager(this,interpreteMessaggio, controller);
	
	
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.screen_online);
		
		graphicManager.createGraphics();

		toggleButtonStart();
		toggleButtonConnect();

		
	}

	public void startNewGame() {
		Button[] boardButtons = graphicManager.getBoardButtons();
//		TextView infoTextView = graphicManager.getInfoTextView();
		graphicManager.clear();
		for (int i = 0; i < boardButtons.length; i++) {
			boardButtons[i].setText("");
			boardButtons[i].setEnabled(true);
			boardButtons[i].setOnClickListener(new ButtonClickListener(i, matchManager, graphicManager/*, interpreteMessaggio*/));
		}

	}

//	public boolean onCreateOptionsMenu(Menu menu) {
//
//		getMenuInflater().inflate(R.menu.gam_menu_online, menu);
//		return true;
//	}
//
//	public boolean onOptionsItemSelected(MenuItem item) {
//		switch (item.getItemId()) {
//		case R.id.newGame:
//			onCreate(null);
//			break;
//		case R.id.exitGame:
//			ActivityOnline.this.finish();
//			break;
//		}
//
//		return true;
//	}

	/**
	 * si occupa di fare iniziare una nuova partita
	 */
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
					
					UIManager.setMyTurn(true);
					infoTextView.setText(R.string.player1);
					startNewGame();

				} else {
					// ha premuto il buttone stop
					UIManager.setMyTurn(false);
					matchManager.getTimer().cancel();
					connected = false;
					UIManager.setLaunchTimer(true);

				}
			}
		});

	}

	/**
	 * si occupa di reiprendere un partita esistente
	 */
	private void toggleButtonConnect() {
		final ToggleButton connectButton = graphicManager.getConnectButton();
		final EditText editText1 = graphicManager.getEditText1();
		final EditText editText2 = graphicManager.getEditText2();
		final TextView infoTextView = graphicManager.getInfoTextView();
		connectButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if (connectButton.isChecked()) {
					namePlayer1 = editText1.getText().toString();
					namePlayer2 = editText2.getText().toString();
					matchManager.connectToMatch(namePlayer1, namePlayer2);
					UIManager.setMyTurn(true);
					infoTextView.setText(R.string.player1);
					startNewGame();
					connected = true;
				} else {
					// disconnect
					UIManager.setMyTurn(false);
					matchManager.getTimer().cancel();
					connected = false;
					UIManager.setLaunchTimer(true);
				}
			}
		});

	}

	private boolean checkPlayersName() {
		if (namePlayer1.equals("") || namePlayer2.equals("")) {
			return false;
		} else {
			return true;
		}
	}

	public static boolean isConnected() {
		return connected;
	}

	public static void setConnected(boolean connected) {
		ActivityOnline.connected = connected;
	}

}
