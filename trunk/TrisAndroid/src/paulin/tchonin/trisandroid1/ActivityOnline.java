package paulin.tchonin.trisandroid1;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

import rete.InterpreteMessaggio;
import android.app.Activity;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class ActivityOnline extends Activity{
	
	private String message;
	private String response;
	private Button mBoardButtons[];
	private TicTacToeOnline mGameOnline;
	private boolean turnPlayer1 = true;
	private boolean turnPlayer2 = false;

	private boolean mGameOver = false;
	
	

	private TextView mInfoTextView;
	
	EditText editText1 = null;
	EditText editText2 = null;
	String namePlayer1;
	String namePlayer2;
	
	


	
	

public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.screen_online);
		
		
		
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
		editText1 = (EditText)findViewById(R.id.name_player1);
		editText2 = (EditText)findViewById(R.id.name_player2);
		
		editText1.addTextChangedListener(textWatcher);
		editText2.addTextChangedListener(textWatcher);
		
		mGameOnline = new TicTacToeOnline();
		
		ToggleButton();
		
		
		
		
	}
	
	
private class send extends AsyncTask<Void, Void, String > {
		
		private  InetAddress host;
		private static final int PORT = 45454;
		
		@Override
		protected String doInBackground(Void... params) {
		
			Socket link = null; // Step 1.

			try {
				link = new Socket("10.65.254.101", PORT); // Step 1.

				Scanner input = new Scanner(link.getInputStream());// Step 2.

				PrintWriter output = new PrintWriter(link.getOutputStream(), true);// Step

		
				output.println(message); // Step 3.
				response = input.nextLine(); // Step 3.
				//System.err.println("\nSERVER> " + response);
				input.close();
				Log.e("Paulin 104", response);
				
				/*
				InterpreteMessaggio interprete = new InterpreteMessaggio();
				interprete.interpreta(response);
				Log.e("Paulin", interprete.getStatoPartita());
				*/
				return response;
				

			} catch (IOException ioEx) {
				ioEx.printStackTrace();
			}

			finally {
				try {

					link.close(); // Step 4.
				} catch (IOException ioEx) {
					
				}
			}
			Log.e("Paulin", "true");
			return "true";
		}

		@Override
		protected void onPostExecute(String result) {
			
		}
	
	}


private void startNewGameOnline() {
	
	mGameOnline.clearBoard();
	
	
	
	for (int i = 0; i < mBoardButtons.length; i++) {

		mBoardButtons[i].setText("");
		mBoardButtons[i].setEnabled(true);
		mBoardButtons[i].setOnClickListener(new ButtonClickListener(i));

	}
	mInfoTextView.setText(R.string.player1);

/*
	if (turnPlayer1) {
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
		turnPlayer1 = true;
	}
*/
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
		
	}

	public void onClick(View view) {
		if (!mGameOver) {
			
			if (mBoardButtons[location].isEnabled()) {
						
				  if(turnPlayer1){
					setMoveOnline(mGameOnline.PLAYER1, location);
					//TODO mandare la mossa al server
					turnPlayer1=false;
					
				  }
				   // TODO da eliminare
					int winner = mGameOnline.checkForWinner();

					if (winner == 0) {
						mInfoTextView.setText(R.string.turn_player2);
						// TODO  ricevere la mossa del server2
						int move = mGameOnline.getPlayer2Move();
						// finché non gioca il player2 il player1 non può piu giocare
						if(turnPlayer2){
							setMoveOnline(mGameOnline.PLAYER2, move);
							turnPlayer1 = true;
						}
						
						winner = mGameOnline.checkForWinner();
					}
					
					if(winner==0){
						
					}
					else if (winner == 1) {
						mInfoTextView.setText(R.string.result_tie);
						//mTieCounter++;
						//mTieCount.setText(Integer.toString(mTieCounter));
						mGameOver = true;
					} else if (winner == 2) {
						mInfoTextView.setText(R.string.result_player1_wins);
						//mHumanCounter++;
						//mHumanCount.setText(Integer.toString(mHumanCounter));
						mGameOver = true;
					} else {
						mInfoTextView.setText(R.string.result_player2_wins);
						//mAndroidCounter++;
						//mAndroidCount.setText(Integer.toString(mAndroidCounter));
						mGameOver = true;
					}

					
				
			}

		}
	}
}


     // for ToggleButton

private void ToggleButton(){
	
	
	final ToggleButton button = (ToggleButton) findViewById(R.id.togglebutton);
	button.setOnClickListener(new OnClickListener() {
		@Override
		public void onClick(View v) {
			if (button.isChecked()) {
				// recuperiamo il nome del giocatore 1
				namePlayer1 = editText1.getText().toString();
				// recuperiamo quello del giocatore 2
				namePlayer2 = editText2.getText().toString();
				
				
				//controlli sui nomi
				if(namePlayer1.equals("") || namePlayer2.equals("")){
					Toast.makeText(ActivityOnline.this, R.string.verify, Toast.LENGTH_SHORT).show();
				 
				}else{
					// invio il messaggio al server
					message = "nuova partita	";
					message +=namePlayer1;
					message +="	";
					message +=namePlayer2;
					new send().execute();
					
					
					Log.e("Paulin 294", namePlayer1);
					Log.e("Paulin 295", namePlayer2);

					
					//mettre le toast ici 
					
					
                    
					turnPlayer1 = true;
					startNewGameOnline();										
				}
				
				
                
				
			} else {
				// on n'a pas encore appuyer : stop
				
				turnPlayer1=false;
				
				
				
				
			}
		}
	});
	
}

             //for edittext per vedere quando l'utilisatore scrive nell'edittext
	private TextWatcher textWatcher = new TextWatcher() {
		@Override
		public void onTextChanged(CharSequence s, int start, int before,
		int count) {
		//result.setText(defaut);
		}
		@Override
		public void beforeTextChanged(CharSequence s, int start, int count, int after) {
		}
		@Override
		public void afterTextChanged(Editable s) {
		}
		};

	
}
