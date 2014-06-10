package servizi;

import gioco.Partita;

import java.util.ArrayList;
import java.util.StringTokenizer;

import server.ServerExceptions;
/**
 * Questo servizio restituisce quando viene chiamato le informazioni sulla partita qualora
 * il giocatore non sia quello che ha direttamente creato la partita stessa, ma ci si debba
 * collegare. </br></br>
 * 
 * Riceve in ingresso 3 Token, che rappresentano il giocatore1, il giocatore2 e quale sia
 * il gioco a cui stanno giocando.
 */
public class ConnectService implements IService {

	@Override
	public String handleService(StringTokenizer s, ArrayList<Partita> matches) {
	
		try {
		if(s.countTokens()!=3)	throw new ServerExceptions("Formato errato",s );
		String player1 = s.nextToken();
		String player2 = s.nextToken();
		String game = s.nextToken();
		for (int i = 0; i < matches.size(); i++) {
			if (matches.get(i).inCorsoG1G2(player1, player2) && matches.get(i).getGioco().equalsIgnoreCase(game)) {

				System.out.println("SERVER> "+matches.get(i).toString());
				return matches.get(i).toString();
				
			}
		
		}		

		} catch (ServerExceptions e) {
		}

		return "Errore:PartitaNonEsistente";

	}
	
}
