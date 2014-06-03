package paulin.tchonin.trisandroid1;

import java.util.Observable;
import java.util.StringTokenizer;
import java.util.Timer;
import java.util.TimerTask;

import rete.Client;
import rete.IClient;
import rete.InterpreteMessaggio;

public class MatchManager extends Observable implements IMatchManager {

	private static final String PLAYER1_SYMBOL = "G1"; // TODO METTERE IN XML
	private static final String PLAYER2_SYMBOL = "G2"; // TODO METTERE IN XML
	private InterpreteMessaggio interprete;
	private String message;
	private String response;
	private IClient client;		//TODO ha senso passare un IClient al costruttore di MatchManager anzichè averlo come attributo?
	private Timer timer;


	public MatchManager(InterpreteMessaggio interprete) {
		this.interprete = interprete;
	}

	@Override
	public void createNewMatch(String player1, String player2) {
		client = new Client();
		message = "nuova partita	" + player1 + "	" + player2 + "\ttris";
		response = client.send(message);
		interprete.interpreta(response);
	}
	
	@Override
	public void connectToMatch(String player1, String player2) {
		client = new Client();
		message = "collegati a	" + player2 + "	" + player1;
		response = client.send(message);
		interprete.interpreta(response);
	}

	public void sendMove(int location) {
		client = new Client();
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
		client = new Client();
		timer = new Timer();
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
		StringTokenizer stringTokenizer = new StringTokenizer(response, "	");
		stringTokenizer.nextToken();
		stringTokenizer.nextToken();
		if (!(stringTokenizer.nextToken().equalsIgnoreCase("inCorso")))
			timer.cancel();
	}
	
	@Override
	public void endMatch(){
		timer.cancel();
	}

	public void updateModel() {
		setChanged();
		notifyObservers();

	}
	
	public InterpreteMessaggio getInterprete() {
		return interprete;
	}

}
