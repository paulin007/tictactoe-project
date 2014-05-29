package paulin.tchonin.trisandroid1;

import java.util.Timer;
import java.util.TimerTask;

import rete.Client;
import rete.InterpreteMessaggio;

public class MatchManager implements IMatchManager {

	private String message;
	private String response;
	private Client client;
	private static final String PLAYER_1 = "G1"; // TODO METTERE IN XML
	private InterpreteMessaggio interprete = new InterpreteMessaggio();
	private Timer timer;

	public MatchManager() {
	}

	@Override
	public void connectToMatch(String player1, String player2) {
		client = new Client();
		setMessage("collegati a	" + player2 + "	" + player1);
		setResponse(client.send(message));
		interprete.interpreta(response);
	}

	@Override
	public void createNewMatch(String player1, String player2) {
		client = new Client();
		setMessage("nuova partita	" + player1 + "	" + player2 + "\tTris");
		setResponse(client.send(message));
		interprete.interpreta(response);
	}

	public void sendMove(int location) {
		client = new Client();
		setMessage("Mossa\t" + interprete.getIDpartita() + "\t" + PLAYER_1
				+ "\t" + location);
		setResponse(client.send(message));

	}

	@Override
	public void requestUpdate() {
		client = new Client();
		TimerTask timerTask = new TimerTask() {

			@Override
			public void run() {
				setMessage("update	" + interprete.getIDpartita());
				setResponse(client.send(message));
			}
		};
		timer = new Timer();
		timer.schedule(timerTask, 3000, 2000);
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setResponse(String response) {
		this.response = response;
	}

	public String getResponse() {
		return response;
	}

	public Timer getTimer() {
		return timer;
	}

}
