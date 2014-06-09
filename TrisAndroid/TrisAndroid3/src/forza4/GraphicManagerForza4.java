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

public class GraphicManagerForza4 implements Observer {

	private static String PLAYER1_SYMBOL = "G1";	//TODO METTERE IN XML
	private static String PLAYER2_SYMBOL = "G2";	//TODO METTERE IN XML
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

	
	public GraphicManagerForza4(Forza4Activity forza4Activity, IMatchManager matchManager, ITurnManager turnManager) {
		this.forza4Activity = forza4Activity;
		this.matchManager = matchManager;
		this.turnManager = turnManager;
		matchManager.addObserver(this);
		
	}
	
	
	public void clear() {
		for (int i = 0; i < BOARD_SIZE; i++) {
			boardButtons[i].setBackgroundResource(R.drawable.decor_0);
		}	
	}
	

	public void createGraphics() {
		
		  infoTextView = (TextView) forza4Activity.findViewById(R.id.informationforza4);

			
			listenerButtons = new Button[BOARD_SIZE_LISTENER];
			listenerButtons[0] = (Button) forza4Activity.findViewById(R.id.c1);
			listenerButtons[1] = (Button) forza4Activity.findViewById(R.id.c2);
			listenerButtons[2] = (Button) forza4Activity.findViewById(R.id.c3);
			listenerButtons[3] = (Button) forza4Activity.findViewById(R.id.c4);
			listenerButtons[4] = (Button) forza4Activity.findViewById(R.id.c5);
			listenerButtons[5] = (Button) forza4Activity.findViewById(R.id.c6);
			listenerButtons[6] = (Button) forza4Activity.findViewById(R.id.c7);		

			boardButtons = new Button[BOARD_SIZE];
			boardButtons[0] = (Button) forza4Activity.findViewById(R.id.c01);
			boardButtons[1] = (Button) forza4Activity.findViewById(R.id.c02);
			boardButtons[2] = (Button) forza4Activity.findViewById(R.id.c03);
			boardButtons[3] = (Button) forza4Activity.findViewById(R.id.c04);
			boardButtons[4] = (Button) forza4Activity.findViewById(R.id.c05);
			boardButtons[5] = (Button) forza4Activity.findViewById(R.id.c06);
			boardButtons[6] = (Button) forza4Activity.findViewById(R.id.c07);
			
			boardButtons[7] = (Button) forza4Activity.findViewById(R.id.c11);
			boardButtons[8] = (Button) forza4Activity.findViewById(R.id.c12);
			boardButtons[9] = (Button) forza4Activity.findViewById(R.id.c13);
			boardButtons[10] = (Button) forza4Activity.findViewById(R.id.c14);
			boardButtons[11] = (Button) forza4Activity.findViewById(R.id.c15);
			boardButtons[12] = (Button) forza4Activity.findViewById(R.id.c16);
			boardButtons[13] = (Button) forza4Activity.findViewById(R.id.c17);
			
			boardButtons[14] = (Button) forza4Activity.findViewById(R.id.c21);
			boardButtons[15] = (Button) forza4Activity.findViewById(R.id.c22);
			boardButtons[16] = (Button) forza4Activity.findViewById(R.id.c23);
			boardButtons[17] = (Button) forza4Activity.findViewById(R.id.c24);
			boardButtons[18] = (Button) forza4Activity.findViewById(R.id.c25);
			boardButtons[19] = (Button) forza4Activity.findViewById(R.id.c26);
			boardButtons[20] = (Button) forza4Activity.findViewById(R.id.c27);
			
			boardButtons[21] = (Button) forza4Activity.findViewById(R.id.c31);
			boardButtons[22] = (Button) forza4Activity.findViewById(R.id.c32);
			boardButtons[23] = (Button) forza4Activity.findViewById(R.id.c33);
			boardButtons[24] = (Button) forza4Activity.findViewById(R.id.c34);
			boardButtons[25] = (Button) forza4Activity.findViewById(R.id.c35);
			boardButtons[26] = (Button) forza4Activity.findViewById(R.id.c36);
			boardButtons[27] = (Button) forza4Activity.findViewById(R.id.c37);
			
			boardButtons[28] = (Button) forza4Activity.findViewById(R.id.c41);
			boardButtons[29] = (Button) forza4Activity.findViewById(R.id.c42);
			boardButtons[30] = (Button) forza4Activity.findViewById(R.id.c43);
			boardButtons[31] = (Button) forza4Activity.findViewById(R.id.c44);
			boardButtons[32] = (Button) forza4Activity.findViewById(R.id.c45);
			boardButtons[33] = (Button) forza4Activity.findViewById(R.id.c46);
			boardButtons[34] = (Button) forza4Activity.findViewById(R.id.c47);
			
			boardButtons[35] = (Button) forza4Activity.findViewById(R.id.c51);
			boardButtons[36] = (Button) forza4Activity.findViewById(R.id.c52);
			boardButtons[37] = (Button) forza4Activity.findViewById(R.id.c53);
			boardButtons[38] = (Button) forza4Activity.findViewById(R.id.c54);
			boardButtons[39] = (Button) forza4Activity.findViewById(R.id.c55);
			boardButtons[40] = (Button) forza4Activity.findViewById(R.id.c56);
			boardButtons[41] = (Button) forza4Activity.findViewById(R.id.c57);
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
				
				if(gameOver()){
					matchManager.endMatch();
				}
				
			}
		});		
	}
	
	//Si occupa di decidere in base alla situazione, di quale giocatore è il turno
	private void setPlayersTurn() {

		String ultimoGiocatore = forza4Activity.getMessageInterpreter().getLastPlayer();
		if(ultimoGiocatore.equalsIgnoreCase(PLAYER2_SYMBOL)){
			if(forza4Activity.isConnected()){
				turnManager.setMyTurn(false);
			}else{
				turnManager.setMyTurn(true);
			}
		}else if(ultimoGiocatore.equalsIgnoreCase(PLAYER1_SYMBOL)){
			if(forza4Activity.isConnected()){
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

	
	//Decide se la partita è finita, e comunica chi è il vincitore
	private boolean gameOver(){

		String statoPartita = forza4Activity.getMessageInterpreter().getMatchStatus();
		if(!forza4Activity.isConnected()){
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

		ArrayList<String> caselle = forza4Activity.getMessageInterpreter().getBoxes();
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
