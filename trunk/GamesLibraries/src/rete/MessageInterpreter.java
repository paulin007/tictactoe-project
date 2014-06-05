package rete;

import java.util.ArrayList;
import java.util.StringTokenizer;
/**
 * questa classe ha la responsabilità di interpretare il messaggio ricevuto dal server
 */
public class MessageInterpreter implements IMessageInterpreter {
	
	private String serviceRequest;
	private String matchStatus;
	private String matchID;
	private String lastPlayer;
	private ArrayList<String> boxes;
	
	/* (non-Javadoc)
	 * @see rete.IInterpreteMessaggio#interpreta(java.lang.String)
	 */
	@Override
	public void interpret(String message){
		StringTokenizer stringTokenizer = new StringTokenizer(message);
		serviceRequest = stringTokenizer.nextToken();
		matchID = stringTokenizer.nextToken();
		matchStatus = stringTokenizer.nextToken();
		lastPlayer = stringTokenizer.nextToken();
		boxes = new ArrayList<>();
		while(stringTokenizer.hasMoreTokens()){
			boxes.add(stringTokenizer.nextToken());
		}
	}

	/* (non-Javadoc)
	 * @see rete.IInterpreteMessaggio#getTipoMessaggio()
	 */
	@Override
	public String getServiceRequest() {
		return serviceRequest;
	}

	/* (non-Javadoc)
	 * @see rete.IInterpreteMessaggio#getStatoPartita()
	 */
	@Override
	public String getMatchStatus() {
		return matchStatus;
	}

	/* (non-Javadoc)
	 * @see rete.IInterpreteMessaggio#getIDpartita()
	 */
	@Override
	public String getMatchID() {
		return matchID;
	}

	/* (non-Javadoc)
	 * @see rete.IInterpreteMessaggio#getUltimoGiocatore()
	 */
	@Override
	public String getLastPlayer() {
		return lastPlayer;
	}

	/* (non-Javadoc)
	 * @see rete.IInterpreteMessaggio#getCaselle()
	 */
	@Override
	public ArrayList<String> getBoxes() {
		return boxes;
	}
	
}
