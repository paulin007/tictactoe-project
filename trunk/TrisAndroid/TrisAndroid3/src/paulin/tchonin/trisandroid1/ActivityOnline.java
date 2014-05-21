package paulin.tchonin.trisandroid1;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
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
	private String response="";
	private Button mBoardButtons[];
	private TicTacToeOnline mGameOnline;
	private String tipo;
	private boolean aspetto = true;
	private Timer timer = new Timer();
	private int winner;
	private boolean collega = false;
	private boolean mioturno = false;

	private boolean mGameOver = false;

	private String tipoMessaggio;
	private String statoPartita;
	private String IDpartita;
	private String ultimoGiocatore;
	private ArrayList<String> caselle;

	private TextView mInfoTextView;

	private EditText editText1 = null;
	private EditText editText2 = null;
	private String namePlayer1;
	private String namePlayer2;
	private static String simboloGiocatore1 = "G1";
	private static String simboloGiocatore2 = "G2";

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.screen_online);
		

		mBoardButtons = new Button[mGameOnline.getBOARD_SIZE()];
		
		/*
		 * findViewById permette di usare qua gli identificatori definiti in xml.
		 * dobbiamo fare il cast però, xk quel metodo ritorna una view.
		 * sostanzialmente quel metodo permette di trasformare un oggettto che
		 * non è scritto in java(xml) in un oggetto java reale e concretto
		 */
		
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

		
		mGameOnline = new TicTacToeOnline();

		toggleButtonStar();
		toggleButtonCollega();

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

			} catch (UnknownHostException exception) {
				exception.printStackTrace();
				Log.e("Paulin", "unKnownHos 1");
			}catch (IOException ioEx) {
				ioEx.printStackTrace();
				Log.e("Paulin", "unKnownHos 2");
			}

			finally {
				
				try {

					link.close(); // Step 4.
				} catch (IOException ioEx) {
					Log.e("Paulin", "unKnownHos 3");
				}
			}
			Log.e("Paulin", "true");
			Log.e("Paulin", response);
			return "true";
		}

		@Override
		protected void onPostExecute(String result) {

			InterpreteMessaggio interprete = new InterpreteMessaggio();
			//Log.e("Paulin", "interprete");
			interprete.interpreta(response);
			//Log.e("Paulin", "interprete 3");
			tipoMessaggio = interprete.getTipoMessaggio();
			IDpartita = interprete.getIDpartita();
			statoPartita = interprete.getStatoPartita();
			ultimoGiocatore = interprete.getUltimoGiocatore();
			caselle = interprete.getCaselle();

			if (tipo.equals("mossa")) {
				message = "update	" + IDpartita;
				tipo = "update";
				new send().execute();

			} else if (tipo.equals("collegamento")) {
				message = "update	" + IDpartita;
				tipo = "update";
				new send().execute();
				Log.e("Paulin collegamento", response);
				// aggiornaTabella();

			} else if (tipo.equals("update")) {

				starTimer();
				aspetto = false;

				aggiornaTabella();

				// turnPlayer1 = true;
			} else if (tipo.equals("update2")) {

			}

			Log.e("ultimo giocato", ultimoGiocatore);

		}

	}

	private void startNewGameOnline() {

		mGameOnline.clearBoard();

		for (int i = 0; i < mBoardButtons.length; i++) {
			mBoardButtons[i].setText("");
			mBoardButtons[i].setEnabled(true);
			mBoardButtons[i].setOnClickListener(new ButtonClickListener(i));
		}

		mGameOver = false;

	}

	private void setMoveOnline(char player, int location) {
		mGameOnline.setMove(player, location);

		mBoardButtons[location].setEnabled(false);
		mBoardButtons[location].setText(String.valueOf(player));

		
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
			onCreate(null);
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

					if (mioturno && !collega) {
						message = "mossa	" + IDpartita + "	G1" + "	" + location;
						new send().execute();
						tipo = "mossa";
						mInfoTextView.setText(R.string.turn_player2);
						mioturno = false;
					}

					if (mioturno && collega) {
						message = "mossa	" + IDpartita + "	G2" + "	" + location;
						new send().execute();
						setMoveOnline(mGameOnline.PLAYER2, location);
						tipo = "mossa";
						mInfoTextView.setText(R.string.turn_player1);
						mioturno = false;
					}
				}
			}
		}
	}

	private void toggleButtonStar() {

		final ToggleButton button = (ToggleButton) findViewById(R.id.togglebutton);
		button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if (button.isChecked()) {
					// recuperiamo i nomi degli giocatori
					namePlayer1 = editText1.getText().toString();
					namePlayer2 = editText2.getText().toString();

					// controlli sui nomi
					if (namePlayer1.equals("") || namePlayer2.equals("")) {
						Toast.makeText(ActivityOnline.this, R.string.verify,
								Toast.LENGTH_SHORT).show();
					} else {
						message = "nuova partita	" + namePlayer1 + "	"
								+ namePlayer2;
						tipo = "nuova";
						new send().execute();
						mInfoTextView.setText(R.string.player1);
						mioturno = true;
						startNewGameOnline();
					}

				} else {
					// ha premuto il buttone stop

					mioturno = false;
					collega = false;

					aspetto = true;
					timer.cancel();
					

				}
			}
		});

	}

	private void toggleButtonCollega() {
		final ToggleButton button2 = (ToggleButton) findViewById(R.id.togglebutton2);
		button2.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if (button2.isChecked()) {
					// recuperiamo i nomi dei giocatori
					namePlayer1 = editText1.getText().toString();
					namePlayer2 = editText2.getText().toString();

					// invio il messaggio al server
					message = "collegati a	" + namePlayer2 + "	" + namePlayer1;
					Log.e("pualin collegati a", message);
					tipo = "mossa";
					new send().execute();
					startNewGameOnline();
					collega = true;

				} else {
					// scollega
					mioturno = false;
					timer.cancel();
					collega = false;
					aspetto = true;
				}
			}
		});

	}

	private void aggiornaTabella() {
		

		for (int i = 0; i < caselle.size(); i++) {
			if (caselle.get(i).equals("G1")) {
				setMoveOnline(mGameOnline.PLAYER1, i);
			} else if (caselle.get(i).equals("G2")) {
				setMoveOnline(mGameOnline.PLAYER2, i);
			}

		}

	

		if (ultimoGiocatore.equals(simboloGiocatore2)) {
			mioturno = true;
			mInfoTextView.setText(R.string.turn_player1);

		}

		if (ultimoGiocatore.equals(simboloGiocatore1)) {
			mioturno = false;
			mInfoTextView.setText(R.string.turn_player2);

		}

		if (collega && ultimoGiocatore.equals(simboloGiocatore2)) {
			mInfoTextView.setText(R.string.turn_player2);
			mioturno = false;
		}

		if (collega && ultimoGiocatore.equals(simboloGiocatore1)) {
			mInfoTextView.setText(R.string.turn_player1);
			mioturno = true;
		}

		winner = mGameOnline.checkForWinner();

		if (winner == 0) {
		} else if (winner == 1) {
			mInfoTextView.setText(R.string.result_tie);
			mGameOver = true;
			mioturno = false;
		} else if (winner == 2) {
			mInfoTextView.setText(R.string.result_player1_wins);
			mioturno = false;
			mGameOver = true;
		} else {
			mInfoTextView.setText(R.string.result_player2_wins);
			mioturno = false;
			mGameOver = true;
		}

	}

	

	
	private void starTimer() {
		if (aspetto) {
			TimerTask timerTask = new TimerTask() {

				@Override
				public void run() {
					new send().execute();
					Log.e("Paulin timer", "timer");
				}
			};

			timer.schedule(timerTask, 3000, 2000);
		}

		if (winner == 1 || winner == 2 || winner == 3) {
			timer.cancel();
		}

	}

}
