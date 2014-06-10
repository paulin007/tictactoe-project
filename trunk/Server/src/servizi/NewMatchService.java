package servizi;

import gioco.Partita;

import java.util.ArrayList;
import java.util.StringTokenizer;

import server.ServerExceptions;
/**
 * Questo servizio genera una nuova partita, associando i due giocatori. </br>
 * 
 * Riceve 3 token, che sono il giocatore1, il giocatore2 e il gioco a cui stanno giocando.
 */
public class NewMatchService implements IService {

	private static int matchIndex = 0;
	
	@Override
	public String handleService(StringTokenizer s, ArrayList<Partita> matches) {
		try {
			if(s.countTokens()!=3) throw new ServerExceptions("Formato Errato",s);
			
		String player1 = s.nextToken();
		String player2 = s.nextToken();

		String game = s.nextToken();
		
		Partita createdMatch = new Partita(matchIndex, player1,player2, game);
		matches.add(createdMatch);

		System.out.println("SERVER> "+matches.get(matchIndex).toString());

		matchIndex++;
		
		return matches.get(matchIndex-1).toString();
		
		} catch (ServerExceptions e) {
			
		}
		return "Errore:PartitaNonCreata";
	}
	
	
}
