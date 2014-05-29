package paulin.tchonin.trisandroid1;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
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

	private static Button boardButtons[]; 
	private static boolean connected = false;
	private static TextView infoTextView;
	private EditText editText1 = null;
	private EditText editText2 = null;
	private String namePlayer1;
	private String namePlayer2;
	private UIManager manager;
	private MatchManager matchManager = new MatchManager();

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.screen_online);

		boardButtons = new Button[UIManager.BOARD_SIZE];
		boardButtons[0] = (Button) findViewById(R.id.one);
		boardButtons[1] = (Button) findViewById(R.id.two);
		boardButtons[2] = (Button) findViewById(R.id.three);
		boardButtons[3] = (Button) findViewById(R.id.four);
		boardButtons[4] = (Button) findViewById(R.id.five);
		boardButtons[5] = (Button) findViewById(R.id.six);
		boardButtons[6] = (Button) findViewById(R.id.seven);
		boardButtons[7] = (Button) findViewById(R.id.eight);
		boardButtons[8] = (Button) findViewById(R.id.nine);

		infoTextView = (TextView) findViewById(R.id.information);
		editText1 = (EditText) findViewById(R.id.name_player1);
		editText2 = (EditText) findViewById(R.id.name_player2);

		manager = new UIManager();

		toggleButtonStart();
		toggleButtonConnect();

	}

	public void startNewGame() {
		manager.clearBoard();
		for (int i = 0; i < boardButtons.length; i++) {
			boardButtons[i].setText("");
			boardButtons[i].setEnabled(true);
			boardButtons[i].setOnClickListener(new ButtonClickListener(
					boardButtons, i, infoTextView, matchManager));
		}

	}

	public boolean onCreateOptionsMenu(Menu menu) {

		getMenuInflater().inflate(R.menu.gam_menu_online, menu);
		return true;
	}

	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.newGame:
			onCreate(null);
			break;
		case R.id.exitGame:
			ActivityOnline.this.finish();
			break;
		}

		return true;
	}

	/**
	 * si occupa di fare iniziare una nuova partita
	 */
	private void toggleButtonStart() {

		final ToggleButton button = (ToggleButton) findViewById(R.id.togglebutton);
		button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if (button.isChecked()) {

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
		final ToggleButton button = (ToggleButton) findViewById(R.id.togglebutton2);
		button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if (button.isChecked()) {
					namePlayer1 = editText1.getText().toString();
					namePlayer2 = editText2.getText().toString();
					matchManager.connectToMatch(namePlayer1, namePlayer2);
					matchManager.requestUpdate();
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

	public static Button[] getBoardButtons() {
		return boardButtons;
	}

	public static void setInfoTextView(TextView infoTextView) {
		ActivityOnline.infoTextView = infoTextView;
	}

	public static TextView getInfoTextView() {
		return infoTextView;
	}

	public static boolean isConnected() {
		return connected;
	}

	public static void setConnected(boolean connected) {
		ActivityOnline.connected = connected;
	}

	public EditText getEditText1() {
		return editText1;
	}

	public EditText getEditText2() {
		return editText2;
	}
}
