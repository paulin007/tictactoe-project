package paulin.tchonin.trisandroid1;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import rete.InterpreteMessaggio;
import android.graphics.Color;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ToggleButton;

public class GraphicManager implements IGraphicManager, Observer {

	private static String simboloGiocatore1 = "G1";
	private static String simboloGiocatore2 = "G2";
	private final static int BOARD_SIZE = 9;
	private final static char EMPTY_SPACE = ' ';
	private ActivityOnline activityOnline;
	private Button boardButtons[];
	private TextView infoTextView;
	private EditText editText1 = null;
	private EditText editText2 = null;
	private ToggleButton connectButton;
	private ToggleButton startButton;
	private InterpreteMessaggio interprete;
	private Controller controller;


	public GraphicManager(ActivityOnline activityOnline,
			InterpreteMessaggio interprete, Controller controller) {
		this.activityOnline = activityOnline;
		this.interprete = interprete;
		this.controller = controller;
		controller.getMatchManager().addObserver(this);
		
	}

	@Override
	public void clear() {
		for (int i = 0; i < BOARD_SIZE; i++) {
			boardButtons[i].setText(String.valueOf(EMPTY_SPACE));
		}
	}

	/**
	 * Aggiorna la UI attiva su un altro thread
	 */
	@Override
	public void paint(final ArrayList<String> caselle) {
		getActivityOnline().runOnUiThread(new Runnable() {
			
			@Override
			public void run() {
				for (int i = 0; i < caselle.size(); i++) {
					if (caselle.get(i).equals(simboloGiocatore1)) {
						setMove('X', i);
					} else if (caselle.get(i).equals(simboloGiocatore2)) {
						setMove('0', i);
					}
				}
			}
		});
		
	}
	
	
	
	@Override
	public void createGraphics() {
		boardButtons = new Button[BOARD_SIZE];
		boardButtons[0] = (Button) activityOnline.findViewById(R.id.one);
		boardButtons[1] = (Button) activityOnline.findViewById(R.id.two);
		boardButtons[2] = (Button) activityOnline.findViewById(R.id.three);
		boardButtons[3] = (Button) activityOnline.findViewById(R.id.four);
		boardButtons[4] = (Button) activityOnline.findViewById(R.id.five);
		boardButtons[5] = (Button) activityOnline.findViewById(R.id.six);
		boardButtons[6] = (Button) activityOnline.findViewById(R.id.seven);
		boardButtons[7] = (Button) activityOnline.findViewById(R.id.eight);
		boardButtons[8] = (Button) activityOnline.findViewById(R.id.nine);
		infoTextView = (TextView) activityOnline.findViewById(R.id.information);
		editText1 = (EditText) activityOnline.findViewById(R.id.name_player1);
		editText2 = (EditText) activityOnline.findViewById(R.id.name_player2);
		connectButton = (ToggleButton) activityOnline
				.findViewById(R.id.toggleButtonConnect);
		startButton = (ToggleButton) activityOnline
				.findViewById(R.id.toggleButtonStart);
	}

	private void setMove(char player, int location) {
		Log.e("info", "sei dentro setMove");
		
		boardButtons[location].setText(String.valueOf(player));
		Log.e("info", "hai messo il simbolo");
		if (player == 'X') {
			boardButtons[location].setTextColor(Color.GREEN);
			Log.e("info", "verde");
		} else if (player == '0') {
			boardButtons[location].setTextColor(Color.RED);
			Log.e("info", "rosso");
		}
		boardButtons[location].setEnabled(false);
		
	}

	public ActivityOnline getActivityOnline() {
		return activityOnline;
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

	@Override
	public void update(Observable arg0, Object arg1) {
//		controller.getMatchManager().getTimer().cancel();
		Log.e("info", "update");
//		getActivityOnline().runOnUiThread(new Runnable() {
//			
//			@Override
//			public void run() {
//				getBoardButtons()[0].setText("X");
//			}
//		});
		if (interprete.getUltimoGiocatore().equalsIgnoreCase(simboloGiocatore2)) {
			Log.e("info",interprete.getCaselle()+" "+interprete.getUltimoGiocatore());
			paint(interprete.getCaselle());
		}else if (interprete.getUltimoGiocatore().equalsIgnoreCase(simboloGiocatore1)){
			Log.e("info",interprete.getCaselle()+" "+interprete.getUltimoGiocatore());
			paint(interprete.getCaselle());
		}
		
	}

}
