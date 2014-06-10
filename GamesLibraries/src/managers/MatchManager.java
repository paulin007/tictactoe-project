package managers;

import java.util.Observable;
import java.util.Timer;
import java.util.TimerTask;

import rete.IClient;
import rete.IMessageInterpreter;
/**
 * Questa classe ha la responsabilità  di gestire una partita di un gioco
 */
public class MatchManager extends Observable implements IMatchManager {

	private IMessageInterpreter interpreter;
	private String message;
	private String response;
	private IClient client;
	private Timer timer;

	public MatchManager(IClient client, IMessageInterpreter interpreter) {
		this.client = client;
		this.interpreter = interpreter;
	}

	@Override
	public void createNewMatch(String player1, String player2, String gameName) {
		message = "nuova partita	" + player1 + "	" + player2 + "\t"+gameName;
		response = client.send(message);
		interpreter.interpret(response);
		timer = new Timer();
	}
	
	@Override
	public void connectToMatch(String player1, String player2, String gameName) {
		message = "collegati a	" + player2 + "	" + player1+"\t"+gameName;
		response = client.send(message);
		interpreter.interpret(response);
		timer = new Timer();
	}

	public void sendMove(int location) {
		if(interpreter.getLastPlayer().equalsIgnoreCase(PlayerSymbol.PLAYER1_SYMBOL.getSymbol())){
			message = "Mossa\t" + interpreter.getMatchID() + "\t" + PlayerSymbol.PLAYER2_SYMBOL.getSymbol()
					+ "\t" + location;
		}else if(interpreter.getLastPlayer().equalsIgnoreCase(PlayerSymbol.PLAYER2_SYMBOL.getSymbol())){
			message = "Mossa\t" + interpreter.getMatchID() + "\t" + PlayerSymbol.PLAYER1_SYMBOL.getSymbol()
					+ "\t" + location;
		}
		response = client.send(message);
		interpreter.interpret(response);
	}

	@Override
	public void requestUpdate() {
		TimerTask timerTask = new TimerTask() {

			@Override
			public void run() {

				message = "update	" + interpreter.getMatchID();
				response = client.send(message);
				interpreter.interpret(response);
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
		return interpreter;
	}
	public String getResponse() {
		return response;
	}
	
	
	public void updateModel() {
		setChanged();
		notifyObservers();
	}

}
