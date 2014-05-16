package paulin.tchonin.trisandroid1;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;



import rete.InterpreteMessaggio;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ActivityOnline extends Activity{
	
	private String message="nuova partita	Paulin	Andrea";
	private String response;
	private Button mBoardButtons[];
	private TicTacToeOnline mGameOnline;
	private boolean Player1First = true;
	private boolean mGameOver = false;
	
	

	private TextView mInfoTextView;
	private TextView mHumanCount;
	private TextView mTieCount;
	private TextView mAndroidCount;
	
	private int mHumanCounter = 0;
	private int mTieCounter = 0;
	private int mAndroidCounter = 0;

	

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.screen_online);
		//new send().execute();
		
		
		mBoardButtons = new Button[mGameOnline.getBOARD_SIZE()];
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

		mGameOnline = new TicTacToeOnline();

		startNewGameOnline();
		
		
	}
	
	
	private class send extends AsyncTask<Void, Void, String > {
		
		private  InetAddress host;
		private static final int PORT = 45454;
		
		//String messaggio="nuova partita	Paulin	Andrea" ;

		@Override
		protected String doInBackground(Void... params) {
		
			Socket link = null; // Step 1.

			try {
				link = new Socket("10.65.254.101", PORT); // Step 1.

				Scanner input = new Scanner(link.getInputStream());// Step 2.

				PrintWriter output = new PrintWriter(link.getOutputStream(), true);// Step

				//String message, response;

				// message = messaggio;
				output.println(message); // Step 3.
				response = input.nextLine(); // Step 3.
				//System.err.println("\nSERVER> " + response);
				input.close();
				Log.e("Paulin", response);
				
				
				InterpreteMessaggio interprete = new InterpreteMessaggio();
				interprete.interpreta(response);
				Log.e("Paulin", interprete.getStatoPartita());
				return response;
				

			} catch (IOException ioEx) {
				ioEx.printStackTrace();
			}

			finally {
				try {
					//Log.e("Paulin", "\n* Closing connection... *");
					//System.out.println("\n* Closing connection... *");
					link.close(); // Step 4.
				} catch (IOException ioEx) {
					//Log.e("Paulin","Unable to disconnect!");
					//System.out.println("Unable to disconnect!");
					//System.exit(1);
				}
			}
			Log.e("Paulin", "true");
			return "true";
		}

		@Override
		protected void onPostExecute(String result) {
			//mTextView.setText(result);
		}
	
	}


private void startNewGameOnline() {
	
	mGameOnline.clearBoard();
	
	
	
	for (int i = 0; i < mBoardButtons.length; i++) {

		mBoardButtons[i].setText("");
		mBoardButtons[i].setEnabled(true);
		mBoardButtons[i].setOnClickListener(new ButtonClickListener(i));

	}

	if (Player1First) {
		// inizia il giocatore 1
		//TODO al posto di player1 stampare il nome del giocatore
		mInfoTextView.setText(R.string.player1);
		// se inizia il giocatore 1, il prossimo sarà il player 2
	//	Player1First = false;
	} else {
		// inizia player 2
		//TODO al posto di player1 stampare il nome del giocatore2
		mInfoTextView.setText(R.string.turn_player2);
		// mossa del player 2
		int move = mGameOnline.getPlayer2Move();
		// move è la location
		setMoveOnline(mGameOnline.PLAYER2, move);
		// la prossima volta che parte il gioco, toccherà al giocatore di
		// giocare
		Player1First = true;
	}

	mGameOver = false;

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

public boolean onCreateOptionsMenu(Menu menu) {

	/*
	 * MenuInflater inflater = getMenuInflater();
	 * inflater.inflate(R.menu.game_menu, menu);
	 */
	getMenuInflater().inflate(R.menu.gam_menu_online, menu);
	return true;
}

public boolean onOptionsItemSelected(MenuItem item) {
	switch (item.getItemId()) {
	case R.id.newGame:
		startNewGameOnline();
		break;
	case R.id.exitGame:
		ActivityOnline.this.finish();
		break;
	}

	return true;
}

private class ButtonClickListener implements View.OnClickListener {
	int location;

	public ButtonClickListener(int location) {
		this.location = location;
		Log.e("Paulin", "1");
	}

	public void onClick(View view) {
		if (!mGameOver) {
			
			if (mBoardButtons[location].isEnabled()) {
				
					
				  if(Player1First){
					setMoveOnline(mGameOnline.PLAYER1, location);
					Player1First=false;
				  }
					int winner = mGameOnline.checkForWinner();

					if (winner == 0) {
						mInfoTextView.setText(R.string.turn_player2);
						// TODO inviare la mossa al server e ricevere quella del server2
						int move = mGameOnline.getPlayer2Move();
						// finché non gioca il player2 il player1 non può piu giocare
						if(false){
							setMoveOnline(mGameOnline.PLAYER2, move);
							Player1First = true;
						}
						
						winner = mGameOnline.checkForWinner();
					}
					
					if(winner==0){
						
					}
					else if (winner == 1) {
						mInfoTextView.setText(R.string.result_tie);
						mTieCounter++;
						mTieCount.setText(Integer.toString(mTieCounter));
						mGameOver = true;
					} else if (winner == 2) {
						mInfoTextView.setText(R.string.result_player1_wins);
						mHumanCounter++;
						mHumanCount
								.setText(Integer.toString(mHumanCounter));
						mGameOver = true;
					} else {
						mInfoTextView.setText(R.string.result_player2_wins);
						mAndroidCounter++;
						mAndroidCount.setText(Integer
								.toString(mAndroidCounter));
						mGameOver = true;
					}

					// fine online
				
			}

		}
	}
}


}
