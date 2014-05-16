package paulin.tchonin.trisandroid1;


import rete.Client;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

	private TicTacToeGame mGame;

	private Button mBoardButtons[];


	private TextView mInfoTextView;
	private TextView mHumanCount;
	private TextView mTieCount;
	private TextView mAndroidCount;

	private int mHumanCounter = 0;
	private int mTieCounter = 0;
	private int mAndroidCounter = 0;

	private boolean mHumanFirst = true;
	private boolean mGameOver = false;

	// server
	private Client client = new Client();
	private String answer;

	// online
	private TicTacToeOnline mGameOnline;
	private boolean Player1First = true;
	private boolean online = false;
	
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		/*
		 * findViewById permette di usare qua gli identificatori definiti in xml
		 * dobbiamo fare il cast però, xk quel metodo ritorna una view
		 * sostanzialmente quel metodo permette di trasformare un oggettto che
		 * non è scritto in java(xml) in un oggetto java reale e concretto
		 */
		mBoardButtons = new Button[mGame.getBOARD_SIZE()];
		mBoardButtons[0] = (Button) findViewById(R.id.one);
		mBoardButtons[1] = (Button) findViewById(R.id.two);
		mBoardButtons[2] = (Button) findViewById(R.id.three);
		mBoardButtons[3] = (Button) findViewById(R.id.four);
		mBoardButtons[4] = (Button) findViewById(R.id.five);
		mBoardButtons[5] = (Button) findViewById(R.id.six);
		mBoardButtons[6] = (Button) findViewById(R.id.seven);
		mBoardButtons[7] = (Button) findViewById(R.id.eight);
		mBoardButtons[8] = (Button) findViewById(R.id.nine);

		mInfoTextView = (TextView) findViewById(R.id.information);
		mHumanCount = (TextView) findViewById(R.id.humanCount);
		mTieCount = (TextView) findViewById(R.id.tiesCount);
		mAndroidCount = (TextView) findViewById(R.id.androidCount);

		mHumanCount.setText(Integer.toString(mHumanCounter));
		mTieCount.setText(Integer.toString(mTieCounter));
		mAndroidCount.setText(Integer.toString(mAndroidCounter));

		mGame = new TicTacToeGame();

		startNewGame();

	}

	private void startNewGame() {
		
		mGame.clearBoard();
		
		for (int i = 0; i < mBoardButtons.length; i++) {

			mBoardButtons[i].setText("");
			mBoardButtons[i].setEnabled(true);
			mBoardButtons[i].setOnClickListener(new ButtonClickListener(i));

		}

		if (mHumanFirst) {
			// inizia il giocatore
			mInfoTextView.setText(R.string.first_human);
			// se inizia il giocatore, il prossimo sarà il computer
			mHumanFirst = false;
		} else {
			// inizia android
			mInfoTextView.setText(R.string.turn_computer);

			int move = mGame.getComputerMove();
			setMove(mGame.ANDROID_PLAYER, move);
			// la prossima volta che parte il gioco, toccherà al giocatore di
			// giocare
			mHumanFirst = true;
		}

		mGameOver = false;
	}

	private class ButtonClickListener implements View.OnClickListener {
		int location;

		public ButtonClickListener(int location) {
			this.location = location;
		}

		public void onClick(View view) {
			if (!mGameOver) {
				if (mBoardButtons[location].isEnabled()) {
					// siamo qua se e solo se il gioco non è finito e se il
					// bottone non è disabilitato
						setMove(mGame.HUMAN_PLAYER, location);
						int winner = mGame.checkForWinner();

						if (winner == 0) {
							mInfoTextView.setText(R.string.turn_computer);
							int move = mGame.getComputerMove();
							setMove(mGame.ANDROID_PLAYER, move);
							winner = mGame.checkForWinner();
						}

						if (winner == 0)
							mInfoTextView.setText(R.string.turn_human);
						else if (winner == 1) {
							mInfoTextView.setText(R.string.result_tie);
							mTieCounter++;
							mTieCount.setText(Integer.toString(mTieCounter));
							mGameOver = true;
						} else if (winner == 2) {
							mInfoTextView.setText(R.string.result_human_wins);
							mHumanCounter++;
							mHumanCount
									.setText(Integer.toString(mHumanCounter));
							mGameOver = true;
						} else {
							mInfoTextView.setText(R.string.result_android_wins);
							mAndroidCounter++;
							mAndroidCount.setText(Integer
									.toString(mAndroidCounter));
							mGameOver = true;
						}				
				}

			}
		}
	}

	private void setMove(char player, int location) {
		mGame.setMove(player, location);

		// una volta che è stato giocato una mossa su una casella, facciamo in
		// modo che ne il giocatore ne android possa giocare in quella posizione
		mBoardButtons[location].setEnabled(false);
		mBoardButtons[location].setText(String.valueOf(player));

		// usiamo i colori delle mosse diveri per il giocatore e android
		if (player == mGame.HUMAN_PLAYER)
			mBoardButtons[location].setTextColor(Color.GREEN);
		else
			mBoardButtons[location].setTextColor(Color.RED);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		/*
		 * MenuInflater inflater = getMenuInflater();
		 * inflater.inflate(R.menu.game_menu, menu);
		 */
		getMenuInflater().inflate(R.menu.game_menu, menu);
		return true;
	}

	// questa funzione definisce cosa ci sarà nel menu
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.newGame:
			startNewGame();
			break;
		case R.id.exitGame:
			MainActivity.this.finish();
			break;
		case R.id.easy:
			// TODO
			break;
		case R.id.medium:
			// TODO
			break;
		case R.id.difficult:
			
			break;
		case R.id.online:
			//online = true;
			Intent myIntent = new Intent(MainActivity.this, ActivityOnline.class);
			//myIntent.putExtra("key", value); //Optional parameters
			MainActivity.this.startActivity(myIntent);
			break;

		}

		return true;
	}

	
	private void setMoveOnline(char player, int location) {
		//mGameOnline.setMove(player, location);

		// una volta che è stato giocato una mossa su una casella, facciamo in
		// modo che ne il giocatore ne android possa giocare in quella posizione
		mBoardButtons[location].setEnabled(false);
		mBoardButtons[location].setText(String.valueOf(player));

		// usiamo i colori delle mosse diveri per il giocatore e android
		if (player == mGameOnline.PLAYER1)
			mBoardButtons[location].setTextColor(Color.GREEN);
		else
			mBoardButtons[location].setTextColor(Color.RED);
	}

}
