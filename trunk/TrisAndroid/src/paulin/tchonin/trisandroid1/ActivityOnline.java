package paulin.tchonin.trisandroid1;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

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

public class ActivityOnline extends Activity {

	private String message;
	private String response;
	private Button mBoardButtons[];
	private TicTacToeOnline mGameOnline;
	private boolean turnPlayer1 = false;
	private boolean turnPlayer2 = false;
	private String tipo;
	Timer timer = new Timer();

	private boolean mGameOver = false;

	private String tipoMessaggio;
	private String statoPartita;
	private String IDpartita;
	private String ultimoGiocatore;
	private ArrayList<String> caselle;

	private InterpreteMessaggio interpreteMessaggio = new InterpreteMessaggio();

	private TextView mInfoTextView;

	EditText editText1 = null;
	EditText editText2 = null;
	String namePlayer1;
	String namePlayer2;
	String realUltimo1="G1";
	String realUltimo2="G2";
	private int i;

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
		editText1 = (EditText) findViewById(R.id.name_player1);
		editText2 = (EditText) findViewById(R.id.name_player2);

		editText1.addTextChangedListener(textWatcher);
		editText2.addTextChangedListener(textWatcher);
		

		mGameOnline = new TicTacToeOnline();

		ToggleButton();
		ToggleButton2();

	}

	private class send extends AsyncTask<Void, Void, String> {

		private InetAddress host;
		private static final int PORT = 45444;
	

		@Override
		protected String doInBackground(Void... params) {

			Socket link = null; // Step 1.

			try {
				link = new Socket("10.65.254.101", PORT); // Step 1.

				Scanner input = new Scanner(link.getInputStream());// Step 2.

				PrintWriter output = new PrintWriter(link.getOutputStream(),
						true);// Step
                Log.e("Paulin send message", message);
				output.println(message);// Step 3.
				
				response = input.nextLine(); // Step 3.
				// System.err.println("\nSERVER> " + response);
				input.close();
				Log.e("Paulin send response", response);


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

			InterpreteMessaggio interprete = new InterpreteMessaggio();
			interprete.interpreta(response);
			tipoMessaggio = interprete.getTipoMessaggio();
			IDpartita = interprete.getIDpartita();
			statoPartita = interprete.getStatoPartita();
			ultimoGiocatore = interprete.getUltimoGiocatore();

			if (tipo.equals("nuova")) {

			} else if (tipo.equals("mossa")) {
				message = "update	" + IDpartita;
				tipo = "update";
				new send().execute();

			}else if(tipo.equals("mossa2")){
				
			} else if (tipo.equals("collegamento")) {
				message = "update	" + IDpartita;
				tipo = "update2";
				new send().execute();

			} else if (tipo.equals("update")) {
				
				
//				do{
//					new send().execute();
//				}while(ultimoGiocatore == "G1");
				//new send().execute();
				
				TimerTask  timerTask = new TimerTask() {
					
					@Override
					public void run() {
						new  send().execute();
					   Log.e("Paulin timer", "timer");	
					}
				};
				
				timer.schedule(timerTask, 3000, 2000);
				
				//aggiornaTabella();
				// TODO mettere un timer di giacomo 
				/*
				try {
					Log.e("Paulin prima", "dentro wait");
					wait(3000);
					Log.e("Paulin dopo", "dentro wait");
					new send().execute();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				*/
				aggiornaTabella();
				
				/*
				do {
                    
					new send().execute();
				} while (ultimoGiocatore == realUltimo1);
              */
				//aggiornaTabella();
				turnPlayer1 = true;
			} else if (tipo.equals("update2")) {
				aggiornaTabella();
				// TODO mettere un timer
				if(ultimoGiocatore == namePlayer1){
					turnPlayer2 = true;
					mInfoTextView.setText(R.string.turn_player2);
				}else{
					do {

						new send().execute();
					} while (ultimoGiocatore == namePlayer2);
					
				}
				
				aggiornaTabella();
				//turnPlayer2 = true;

			}

			Log.e("ultimo giocato", ultimoGiocatore);
			caselle = interprete.getCaselle();
			for (int i = 0; i < caselle.size(); i++) {
				// Log.e("Paulin", caselle.get(i));

			}

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

		mGameOver = false;

	}

	private void setMoveOnline(char player, int location) {
		mGameOnline.setMove(player, location);

		// una volta che � stato giocato una mossa su una casella, facciamo in
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

					if (turnPlayer1) {
                    //i= location;
						setMoveOnline(mGameOnline.PLAYER1, location);
						// TODO mandare la mossa al server
						message = "mossa	" + IDpartita + "	G1"+"	"+location;
						new send().execute();
						Log.e("Paulin onclick", message);
						
						tipo = "mossa";
						mInfoTextView.setText(R.string.turn_player2);

						// Log.e("Paulin message mossa", message);
						
						// Log.e("Paulin onclick", "mossa envoyer");
						// aggiornaTabella();

						turnPlayer1 = true;
						//turnPlayer2 = true;

					} else {

						// message="mossa	"+IDpartita+"	"+namePlayer2+"	"+location;
						// new send().execute();

						// aggiornaTabella();
						// turnPlayer1=true;
						// turnPlayer2=false;
					}
					// TODO da eliminare

					if (turnPlayer2) {
						message = "mossa	" + IDpartita + "	G2" + location;
						//tipo = "mossa";
						mInfoTextView.setText(R.string.turn_player1);

						// Log.e("Paulin message mossa", message);
						//new send().execute();
						// Log.e("Paulin onclick", "mossa envoyer");
						// aggiornaTabella();

						turnPlayer1 = true;
						turnPlayer2 = false;

					}

				}

			}
		}
	}

	// for ToggleButton 1

	private void ToggleButton() {

		final ToggleButton button = (ToggleButton) findViewById(R.id.togglebutton);
		button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if (button.isChecked()) {
					// recuperiamo il nome del giocatore 1
					namePlayer1 = editText1.getText().toString();
					// recuperiamo quello del giocatore 2
					namePlayer2 = editText2.getText().toString();

					// controlli sui nomi
					if (namePlayer1.equals("") || namePlayer2.equals("")) {
						Toast.makeText(ActivityOnline.this, R.string.verify,
								Toast.LENGTH_SHORT).show();

					} else {
						// invio il messaggio al server
						message = "nuova partita	" + namePlayer1 + "	"
								+ namePlayer2;
						tipo = "nuova";
						
						// i=0;
						new send().execute();

						// aspettiamo che finisce il metodo send

						turnPlayer1 = true;
						//turnPlayer2 = false;
						startNewGameOnline();
					}

				} else {
					// on n'a pas encore appuyer : stop
					// TODO fermare il gioco
					//turnPlayer1 = false;
					//turnPlayer2 = false;
					//ultimoGiocatore = "G2";

				}
			}
		});

	}

	private void ToggleButton2() {
		final ToggleButton button2 = (ToggleButton) findViewById(R.id.togglebutton2);
		button2.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if (button2.isChecked()) {
					// recuperiamo il nome del giocatore 1
					namePlayer1 = editText1.getText().toString();
					// recuperiamo quello del giocatore 2
					namePlayer2 = editText2.getText().toString();

					// invio il messaggio al server
					message = "collegati a	" + namePlayer1 + "	" + namePlayer2;
					tipo = "collegamento";
					new send().execute();
					// startNewGameOnline();

					// aggiornaTabella();

					// turnPlayer2=true;

				} else {
					turnPlayer2 = false;
				}
			}
		});

	}

	private void aggiornaTabella() {

		for (int i = 0; i < caselle.size(); i++) {
			
			//TODO 
			if (caselle.get(i).equals("G1")) {

				setMoveOnline(mGameOnline.PLAYER1, i);
			} else if (caselle.get(i).equals("G2")) {
				setMoveOnline(mGameOnline.PLAYER2, i);
			}

		}

		int winner = mGameOnline.checkForWinner();

		if (winner == 0) {
			// mInfoTextView.setText(R.string.turn_player2);

			if (turnPlayer2) {
				// setMoveOnline(mGameOnline.PLAYER2, move);
				// turnPlayer1 = true;
				// turnPlayer2=false;
			}

			// winner = mGameOnline.checkForWinner();
		}

		if (winner == 0) {
			// mInfoTextView.setText(R.string.turn_player1);
			// turnPlayer1=true;
		} else if (winner == 1) {
			mInfoTextView.setText(R.string.result_tie);
			mGameOver = true;
			turnPlayer1 = false;
			turnPlayer2 = false;
		} else if (winner == 2) {
			mInfoTextView.setText(R.string.result_player1_wins);
			turnPlayer1 = false;
			turnPlayer2 = false;
			mGameOver = true;
		} else {
			mInfoTextView.setText(R.string.result_player2_wins);
			turnPlayer1 = false;
			turnPlayer2 = false;
			mGameOver = true;
		}

	}

	// for edittext per vedere quando l'utilisatore scrive nell'edittext
	private TextWatcher textWatcher = new TextWatcher() {
		@Override
		public void onTextChanged(CharSequence s, int start, int before,
				int count) {
			// result.setText(defaut);
		}

		@Override
		public void beforeTextChanged(CharSequence s, int start, int count,
				int after) {
		}

		@Override
		public void afterTextChanged(Editable s) {
		}
	};

	// aspettiamo che finisce il metodo send

}
