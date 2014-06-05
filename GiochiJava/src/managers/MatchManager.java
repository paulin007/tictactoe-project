package managers;

import java.util.Observable;
import java.util.Timer;
import java.util.TimerTask;

import rete.IClient;
import rete.InterpreteMessaggio;

public class MatchManager extends Observable implements IMatchManager {

	private static final String PLAYER1_SYMBOL = "G1"; // TODO METTERE IN XML
	private static final String PLAYER2_SYMBOL = "G2"; // TODO METTERE IN XML
	private InterpreteMessaggio interprete;
	private String message;
	private String response;
	private IClient client;
	private Timer timer = new Timer();

	public MatchManager(IClient client, InterpreteMessaggio interprete) {
		this.client = client;
		this.interprete = interprete;
	}

	@Override
	public void createNewMatch(String player1, String player2) {
		message = "nuova partita	" + player1 + "	" + player2 + "\ttris";
		response = client.send(message);
		interprete.interpreta(response);
	}
	
	@Override
	public void connectToMatch(String player1, String player2) {
		message = "collegati a	" + player2 + "	" + player1;
		response = client.send(message);
		interprete.interpreta(response);
	}

	public void sendMove(int location) {
		if(interprete.getUltimoGiocatore().equalsIgnoreCase(PLAYER1_SYMBOL)){
			message = "Mossa\t" + interprete.getIDpartita() + "\t" + PLAYER2_SYMBOL
					+ "\t" + location;
		}else if(interprete.getUltimoGiocatore().equalsIgnoreCase(PLAYER2_SYMBOL)){
			message = "Mossa\t" + interprete.getIDpartita() + "\t" + PLAYER1_SYMBOL
					+ "\t" + location;
		}
		response = client.send(message);
		interprete.interpreta(response);
	}

	@Override
	public void requestUpdate() {
		TimerTask timerTask = new TimerTask() {

			@Override
			public void run() {

				message = "update	" + interprete.getIDpartita();
				response = client.send(message);
				interprete.interpreta(response);
				updateModel();
			}
			
		};
		timer.schedule(timerTask, 2000, 5000);
	}
	
	@Override
	public void endMatch(){
		timer.cancel();
	}

	@Override
	public InterpreteMessaggio getInterprete() {
		return interprete;
	}
	
	public void updateModel() {
		setChanged();
		notifyObservers();
	}
	
	

}
