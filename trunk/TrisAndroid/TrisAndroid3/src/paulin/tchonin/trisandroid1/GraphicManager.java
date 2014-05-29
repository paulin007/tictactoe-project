package paulin.tchonin.trisandroid1;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ToggleButton;

public class GraphicManager implements IGraphicManager {

	public final static int BOARD_SIZE = 9;
	public final static char EMPTY_SPACE = ' ';
	private ActivityOnline activityOnline;
	private Button boardButtons[]; 
	private TextView infoTextView;
	private EditText editText1 = null;
	private EditText editText2 = null;
	private ToggleButton connectButton;
	private ToggleButton startButton;
	
	public GraphicManager(ActivityOnline activityOnline) {
		this.activityOnline = activityOnline;
	}
	
	@Override
	public void clear() {
		for (int i = 0; i < BOARD_SIZE; i++) {
			boardButtons[i].setText(String.valueOf(EMPTY_SPACE));
		}
	}
	
	@Override
	public void paint(String partita) {
		// TODO Auto-generated method stub
		
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
		connectButton = (ToggleButton) activityOnline.findViewById(R.id.toggleButtonConnect);
		startButton = (ToggleButton) activityOnline.findViewById(R.id.toggleButtonStart);
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
	
}
