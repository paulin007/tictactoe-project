package paulin.tchonin.trisandroid1;

import java.util.Observable;
import java.util.StringTokenizer;
import java.util.Timer;
import java.util.TimerTask;

import android.util.Log;
import rete.Client;
import rete.InterpreteMessaggio;

public class MatchManager extends Observable implements IMatchManager {

	private String message;
	private String response;
	private Client client;
	private static final String PLAYER_1 = "G1"; // TODO METTERE IN XML
	private InterpreteMessaggio interprete;
	private Timer timer;

	public MatchManager(InterpreteMessaggio interprete) {
		this.interprete = interprete;
	}

	@Override
	public void connectToMatch(String player1, String player2) {
		client = new Client();
		message = "collegati a	" + player2 + "	" + player1;
		response = client.send(message);
		interprete.interpreta(response);
	}

	@Override
	public void createNewMatch(String player1, String player2) {
		client = new Client();
		message = "nuova partita	" + player1 + "	" + player2 + "\tTris";
		response = client.send(message);
		interprete.interpreta(response);
	}

	public void sendMove(int location) {
		client = new Client();
		message = "Mossa\t" + interprete.getIDpartita() + "\t" + PLAYER_1
				+ "\t" + location;
		response = client.send(message);
		interprete.interpreta(response);
	}

	@Override
	public void requestUpdate() {
		client = new Client();
		timer = new Timer();
		TimerTask timerTask = new TimerTask() {

			@Override
			public void run() {

				message = "update	" + interprete.getIDpartita();
				response = client.send(message);
				interprete.interpreta(response);
				Log.e("info", "Fuori if update");
				if (interprete.getUltimoGiocatore().equalsIgnoreCase(PLAYER_1)) {
					Log.e("info", "Dentro if update");
					updateModel();
				}
			}
		};
		timer.schedule(timerTask, 2000, 5000);
		StringTokenizer stringTokenizer = new StringTokenizer(response, "	");
		stringTokenizer.nextToken();
		stringTokenizer.nextToken();
		if (!(stringTokenizer.nextToken().equalsIgnoreCase("inCorso")))
			timer.cancel();
	}

	public boolean lastPlayer() {
		if (interprete.getUltimoGiocatore().equalsIgnoreCase("G1")) {
			return false;
		} else {
			return true;
		}
	}

	public Timer getTimer() {
		return timer;
	}

	public void updateModel() {
		setChanged();
		notifyObservers();
	}

}
