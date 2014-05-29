package paulin.tchonin.trisandroid1;

import rete.Client;
import rete.InterpreteMessaggio;

public class MatchManager implements IMatchManager {

	private String message;					//TODO usato solo nei metodi toggleButtonStart() e toggleButtonConnect(). Estrarre classe
	private String response;
	private Client client;
	private static final String PLAYER_1="G1";	//TODO METTERE IN XML
	private InterpreteMessaggio interprete = new InterpreteMessaggio();
	
	public MatchManager() {
	}
	
	@Override
	public String connectToMatch(String player1, String player2) {
		
		setMessage("collegati a	" + player2 + "	" + player1);
//		activity.startNewGame();
//		Client client = new ClientAndroid(message);
		return null;
	}
	
	@Override
	public void createNewMatch(String player1, String player2) {
		
		setMessage("nuova partita	" +player1 + "	"+ player2+"\tTris");
		client = new Client();
		setResponse(client.send(message));
		interprete.interpreta(response);
	}
	
	public void sendMove(int location){
		client = new Client();
		setMessage("Mossa\t"+interprete.getIDpartita()+"\t"+PLAYER_1+"\t"+location);
		setResponse(client.send(message));
		
	}
	
	@Override
	public String requestUpdate(int matchId) {
		
		setMessage("update	" + matchId);
//		Client client = new ClientAndroid(message);
		return null;
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
	
}
