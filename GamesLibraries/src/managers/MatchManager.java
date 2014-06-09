package managers;

import java.util.Observable;
import java.util.Timer;
import java.util.TimerTask;

import rete.IClient;
import rete.IMessageInterpreter;

public class MatchManager extends Observable implements IMatchManager {

	private IMessageInterpreter interprete;
	private String message;
	private String response;
	private IClient client;
	private Timer timer = new Timer();

	public MatchManager(IClient client, IMessageInterpreter interprete) {
		this.client = client;
		this.interprete = interprete;
	}

	@Override
	public void createNewMatch(String player1, String player2, String gameName) {
		message = "nuova partita	" + player1 + "	" + player2 + "\t"+gameName;
		response = client.send(message);
		interprete.interpret(response);
	}
	
	@Override
	public void connectToMatch(String player1, String player2, String gameName) {
		message = "collegati a	" + player2 + "	" + player1+"\t"+gameName;
		response = client.send(message);
		interprete.interpret(response);
	}

	public void sendMove(int location) {
		if(interprete.getLastPlayer().equalsIgnoreCase(PlayerSymbol.PLAYER1_SYMBOL.getSymbol())){
			message = "Mossa\t" + interprete.getMatchID() + "\t" + PlayerSymbol.PLAYER2_SYMBOL.getSymbol()
					+ "\t" + location;
		}else if(interprete.getLastPlayer().equalsIgnoreCase(PlayerSymbol.PLAYER2_SYMBOL.getSymbol())){
			message = "Mossa\t" + interprete.getMatchID() + "\t" + PlayerSymbol.PLAYER1_SYMBOL.getSymbol()
					+ "\t" + location;
		}
		response = client.send(message);
		interprete.interpret(response);
	}

	@Override
	public void requestUpdate() {
		TimerTask timerTask = new TimerTask() {

			@Override
			public void run() {

				message = "update	" + interprete.getMatchID();
				response = client.send(message);
				interprete.interpret(response);
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
	public IMessageInterpreter getInterprete() {
		return interprete;
	}
	
	public void updateModel() {
		setChanged();
		notifyObservers();
	}

}
