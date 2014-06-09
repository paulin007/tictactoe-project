package tris;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import paulin.tchonin.trisandroid1.R;

import managers.IMatchManager;
import managers.ITurnManager;

import android.graphics.Color;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ToggleButton;

public class GraphicManagerTris implements Observer {

	private static String PLAYER1_SYMBOL = "G1";	//TODO METTERE IN XML
	private static String PLAYER2_SYMBOL = "G2";	//TODO METTERE IN XML
	private final static int BOARD_SIZE = 9;
	private final static char EMPTY_SPACE = ' ';
	private TrisActivity trisActivity;
	private Button boardButtons[];
	private TextView infoTextView;
	private EditText editText1 = null;
	private EditText editText2 = null;
	private ToggleButton connectButton;
	private ToggleButton startButton;
	private IMatchManager matchManager;
	private ITurnManager turnManager;

	
	public GraphicManagerTris(TrisActivity trisActivity, IMatchManager matchManager, ITurnManager turnManager) {
		this.trisActivity = trisActivity;
		this.matchManager = matchManager;
		matchManager.addObserver(this);
		this.turnManager = turnManager;
	}
	
	
	public void clear() {
		for (int i = 0; i < BOARD_SIZE; i++) {
			boardButtons[i].setText(String.valueOf(EMPTY_SPACE));
		}
	}
	

	public void createGraphics() {
		boardButtons = new Button[BOARD_SIZE];
		boardButtons[0] = (Button) trisActivity.findViewById(R.id.one);
		boardButtons[1] = (Button) trisActivity.findViewById(R.id.two);
		boardButtons[2] = (Button) trisActivity.findViewById(R.id.three);
		boardButtons[3] = (Button) trisActivity.findViewById(R.id.four);
		boardButtons[4] = (Button) trisActivity.findViewById(R.id.five);
		boardButtons[5] = (Button) trisActivity.findViewById(R.id.six);
		boardButtons[6] = (Button) trisActivity.findViewById(R.id.seven);
		boardButtons[7] = (Button) trisActivity.findViewById(R.id.eight);
		boardButtons[8] = (Button) trisActivity.findViewById(R.id.nine);
		infoTextView = (TextView) trisActivity.findViewById(R.id.information);
		editText1 = (EditText) trisActivity.findViewById(R.id.name_player1);
		editText2 = (EditText) trisActivity.findViewById(R.id.name_player2);
		connectButton = (ToggleButton) trisActivity
				.findViewById(R.id.toggleButtonConnect);
		startButton = (ToggleButton) trisActivity
				.findViewById(R.id.toggleButtonStart);
	}

	/**
	 * Aggiorna la UI attiva su un altro thread
	 */

	public void paint(final ArrayList<String> caselle) {
		getTrisActivity().runOnUiThread(new Runnable() {
			
			@Override
			public void run() {

				for (int i = 0; i < caselle.size(); i++) {
					if (caselle.get(i).equals(PLAYER1_SYMBOL)) {
						setMove('X', i);
					} else if (caselle.get(i).equals(PLAYER2_SYMBOL)) {
						setMove('0', i);
					}
				}
				handleTurn();
				
				if(gameOver()){
				matchManager.endMatch();
				}
				
			}
		});		
	}
	
	//Si occupa di decidere in base alla situazione, di quale giocatore è il turno
	private void setPlayersTurn() {
//		String ultimoGiocatore = controller.getMatchManager().getInterprete().getUltimoGiocatore();
		String ultimoGiocatore = trisActivity.getMessageInterpreter().getLastPlayer();
		if(ultimoGiocatore.equalsIgnoreCase(PLAYER2_SYMBOL)){
			if(trisActivity.isConnected()){
				turnManager.setMyTurn(false);
			}else{
				turnManager.setMyTurn(true);
			}
		}else if(ultimoGiocatore.equalsIgnoreCase(PLAYER1_SYMBOL)){
			if(trisActivity.isConnected()){
				turnManager.setMyTurn(true);	
			}else{
				turnManager.setMyTurn(false);
			}
		}
	}
	
	//Gestisce la visualizzazione dei turni su UI
	private void handleTurn() {
		if(turnManager.isMyTurn()){
			infoTextView.setText(R.string.turn_player1);
		}else if(!turnManager.isMyTurn()){
			infoTextView.setText(R.string.turn_player2);
		}
	}

	private void setMove(char player, int location) {

		boardButtons[location].setText(String.valueOf(player));
		if (player == 'X') {
			boardButtons[location].setTextColor(Color.GREEN);
		} else if (player == '0') {
			boardButtons[location].setTextColor(Color.RED);
		}
		boardButtons[location].setEnabled(false);
		
	}
	
	//Decide se la partita è finita, e comunica chi è il vincitore
	private boolean gameOver(){
		String statoPartita = trisActivity.getMessageInterpreter().getMatchStatus();
		if(!trisActivity.isConnected()){
			if(statoPartita.equalsIgnoreCase(PLAYER1_SYMBOL)){
				infoTextView.setText("Hai vinto!");
				return true;
			}else if(statoPartita.equalsIgnoreCase(PLAYER2_SYMBOL)){
				infoTextView.setText("Hai perso!");
				return true;
			}
		}else{
			if(statoPartita.equalsIgnoreCase(PLAYER2_SYMBOL)){
				infoTextView.setText("Hai vinto!");
				return true;
			}else if(statoPartita.equalsIgnoreCase(PLAYER1_SYMBOL)){
				infoTextView.setText("Hai perso!");
				return true;
			}
		}
		return false;
	}

	@Override
	public void update(Observable arg0, Object arg1) {

		ArrayList<String> caselle = trisActivity.getMessageInterpreter().getBoxes();
		setPlayersTurn();
		paint(caselle);

	}

	public TrisActivity getTrisActivity() {
		return trisActivity;
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
}
