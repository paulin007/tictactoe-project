package stats;

import paulin.tchonin.trisandroid1.R;
import rete.Client;
import rete.IClient;
import rete.StatisticInterpreter;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Responsabilità: Gestisce gli achievements dei giocatori
 */
public class Statistics extends Activity {

	private Button buttonSend;
	private EditText editTextName = null;
	private EditText editTextGame = null;
	private String namePlayer;
	private String nameGame;
	private TextView infoTextViewSta;
	private TextView achievment;
	private IClient client = new Client();
	private StatisticInterpreter statisticInterpreter = new StatisticInterpreter();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.layout_statistiche);
		editTextName = (EditText) findViewById(R.id.name_player);
		editTextGame = (EditText) findViewById(R.id.name_game);
		infoTextViewSta = (TextView) findViewById(R.id.result_stat);
		achievment = (TextView) findViewById(R.id.achievment);
		buttonSend = (Button) (this.findViewById(R.id.buttonSend));
		
		buttonSend.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				namePlayer = editTextName.getText().toString();
				nameGame = editTextGame.getText().toString();
				String response = client.send("statistiche	" + namePlayer + "	"
						+ nameGame);
				statisticInterpreter.intepret(response);
				String wins = statisticInterpreter.getWins();
				String tie = statisticInterpreter.getTie();
				String lose = statisticInterpreter.getLose();
				infoTextViewSta.append("Vittorie: " + wins + " Pareggi: " + tie
						+ " Sconfitte: " + lose);
				achievment.append(statisticInterpreter.achievementsToString());
			}
		});

	}
}
