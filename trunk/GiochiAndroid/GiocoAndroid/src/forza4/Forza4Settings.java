package forza4;

import paulin.tchonin.trisandroid1.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Crea un layout dove si può scegliere i nomi dei giocatore con la quale si
 * gioca e avviare una partita
 */
public class Forza4Settings extends Activity implements View.OnClickListener {

	private Button startButton;
	private Button connectButton;
	private EditText editText1 = null;
	private EditText editText2 = null;
	private String namePlayer1;
	private String namePlayer2;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_name);
		init();
	}

	private void init() {
		startButton = (Button) (this.findViewById(R.id.buttonStart));
		startButton.setOnClickListener(this);
		connectButton = (Button) (this.findViewById(R.id.buttonConnect));
		connectButton.setOnClickListener(this);
		editText1 = (EditText) findViewById(R.id.name_player1);
		editText2 = (EditText) findViewById(R.id.name_player2);
	}

	@Override
	public void onClick(View v) {

		if (v.getId() == R.id.buttonStart) {
			namePlayer1 = editText1.getText().toString();
			namePlayer2 = editText2.getText().toString();
			Intent intent = new Intent(this, Forza4Activity.class);
			intent.putExtra("namePlayer1", namePlayer1);
			intent.putExtra("namePlayer2", namePlayer2);
			intent.putExtra("message", "start");
			startActivity(intent);
		} else if (v.getId() == R.id.buttonConnect) {

			namePlayer1 = editText1.getText().toString();
			namePlayer2 = editText2.getText().toString();
			Intent intent = new Intent(this, Forza4Activity.class);
			intent.putExtra("namePlayer1", namePlayer1);
			intent.putExtra("namePlayer2", namePlayer2);
			intent.putExtra("message", "connect");
			this.startActivity(intent);
		}
	}

}
