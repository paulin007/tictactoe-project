package forza4;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import managers.IMatchManager;
import managers.ITurnManager;
import paulin.tchonin.trisandroid1.R;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ToggleButton;

/**
 * Responsabilità: Recupera gli elementi grafici dal Layout
 */
public class GraphicManagerForza4 implements Observer {

	private static String PLAYER1_SYMBOL = "G1";
	private static String PLAYER2_SYMBOL = "G2";
	private final static int BOARD_SIZE = 42;
	private final static int BOARD_SIZE_LISTENER = 7;
	private Forza4Activity forza4Activity;
	private TextView infoTextView;
	private EditText editText1 = null;
	private EditText editText2 = null;
	private ToggleButton connectButton;
	private ToggleButton startButton;
	private IMatchManager matchManager;
	private ITurnManager turnManager;
	private Button boardButtons[];
	private Button listenerButtons[];

	public GraphicManagerForza4(Forza4Activity forza4Activity,
			IMatchManager matchManager, ITurnManager turnManager) {
		this.forza4Activity = forza4Activity;
		this.matchManager = matchManager;
		this.turnManager = turnManager;
		matchManager.addObserver(this);

	}

	/**
	 * Reinizializza la griglia del gioco
	 */
	public void clear() {
		for (int i = 0; i < BOARD_SIZE; i++) {
			boardButtons[i].setBackgroundResource(R.drawable.decor_0);
		}
	}

	/**
	 * Crea la grafica di forza4Activity
	 */
	public void createGraphics() {

		infoTextView = (TextView) forza4Activity
				.findViewById(R.id.informationforza4);
		listenerButtons = new Button[BOARD_SIZE_LISTENER];
		
		int[] listener = { R.id.c1, R.id.c2, R.id.c3, R.id.c4, R.id.c5,
				R.id.c6, R.id.c7 };
		for (int i = 0; i < listener.length; i++) {
			listenerButtons[i] = (Button) forza4Activity
					.findViewById(listener[i]);
		}
		
		boardButtons = new Button[BOARD_SIZE];
		int[] board = { R.id.c01, R.id.c02, R.id.c03, R.id.c04, R.id.c05,
				R.id.c06, R.id.c07, R.id.c11, R.id.c12, R.id.c13, R.id.c14,
				R.id.c15, R.id.c16, R.id.c17, R.id.c21, R.id.c22, R.id.c23,
				R.id.c24, R.id.c25, R.id.c26, R.id.c27, R.id.c31, R.id.c32,
				R.id.c33, R.id.c34, R.id.c35, R.id.c36, R.id.c37, R.id.c41,
				R.id.c42, R.id.c43, R.id.c44, R.id.c45, R.id.c46, R.id.c47,
				R.id.c51, R.id.c52, R.id.c53, R.id.c54, R.id.c55, R.id.c56,
				R.id.c57 };
		for (int i = 0; i < board.length; i++) {
			boardButtons[i] = (Button) forza4Activity.findViewById(board[i]);
		}

	}

	/**
	 * Aggiorna la UI attiva su un altro thread
	 */

	public void paint(final ArrayList<String> caselle) {
		getForza4Activity().runOnUiThread(new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < caselle.size(); i++) {
					if (caselle.get(i).equals(PLAYER1_SYMBOL)) {
						boardButtons[i].setBackgroundResource(R.drawable.red);
					} else if (caselle.get(i).equals(PLAYER2_SYMBOL)) {
						boardButtons[i].setBackgroundResource(R.drawable.green);
					}
				}
				handleTurn();
				if (gameOver()) {
					matchManager.endMatch();
				}
			}
		});
	}

	// Si occupa di decidere in base alla situazione, di quale giocatore è il
	// turno
	private void setPlayersTurn() {

		String ultimoGiocatore = forza4Activity.getMessageInterpreter()
				.getLastPlayer();
		if (ultimoGiocatore.equalsIgnoreCase(PLAYER2_SYMBOL)) {
			if (forza4Activity.isConnected()) {
				turnManager.setMyTurn(false);
			} else {
				turnManager.setMyTurn(true);
			}
		} else if (ultimoGiocatore.equalsIgnoreCase(PLAYER1_SYMBOL)) {
			if (forza4Activity.isConnected()) {
				turnManager.setMyTurn(true);
			} else {
				turnManager.setMyTurn(false);
			}
		}
	}

	// Gestisce la visualizzazione dei turni su UI
	private void handleTurn() {
		if (turnManager.isMyTurn()) {
			infoTextView.setText(R.string.turn_player1);
		} else if (!turnManager.isMyTurn()) {
			infoTextView.setText(R.string.turn_player2);
		}
	}

	// Decide se la partita è finita, e comunica chi è il vincitore
	private boolean gameOver() {
		String statoPartita = forza4Activity.getMessageInterpreter()
				.getMatchStatus();
		if (!forza4Activity.isConnected()) {
			if (statoPartita.equalsIgnoreCase(PLAYER1_SYMBOL)) {
				infoTextView.setText("Hai vinto!");
				return true;
			} else if (statoPartita.equalsIgnoreCase(PLAYER2_SYMBOL)) {
				infoTextView.setText("Hai perso!");
				return true;
			}
		} else {
			if (statoPartita.equalsIgnoreCase(PLAYER2_SYMBOL)) {
				infoTextView.setText("Hai vinto!");
				return true;
			} else if (statoPartita.equalsIgnoreCase(PLAYER1_SYMBOL)) {
				infoTextView.setText("Hai perso!");
				return true;
			}
		}
		return false;
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		ArrayList<String> caselle = forza4Activity.getMessageInterpreter()
				.getBoxes();
		setPlayersTurn();
		paint(caselle);
	}

	public Button[] getBoardButtons() {
		return boardButtons;
	}

	public TextView getInfoTextView() {
		return infoTextView;
	}

	public EditText getEditText1() {
		return editText1;
	}

	public EditText getEditText2() {
		return editText2;
	}

	public ToggleButton getConnectButton() {
		return connectButton;
	}

	public ToggleButton getStartButton() {
		return startButton;
	}

	public Button[] getListenerButtons() {
		return listenerButtons;
	}

	public Forza4Activity getForza4Activity() {
		return forza4Activity;
	}
}
