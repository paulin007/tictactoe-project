package servizi;

import gioco.Partita;

import java.util.ArrayList;
import java.util.StringTokenizer;

import server.EccezioniServer;
/**
 *Questa classe ha la responsabilità di effettuare il servizio per collegare un giocatore ad un altro
 */
public class ServizioCollegamento implements IServizio {

	@Override
	public String effettuaServizio(StringTokenizer s, ArrayList<Partita> partite) {
	
		try {
		if(s.countTokens()!=3)	throw new EccezioniServer("Formato errato",s );
		String giocatore1 = s.nextToken();
		String giocatore2 = s.nextToken();
		String gioco = s.nextToken();
		for (int i = 0; i < partite.size(); i++) {
			if (partite.get(i).inCorsoG1G2(giocatore1, giocatore2) && partite.get(i).getGioco().equalsIgnoreCase(gioco)) {

				System.out.println("SERVER> "+partite.get(i).toString());
				return partite.get(i).toString();
				
			}
		
		}		

		} catch (EccezioniServer e) {
		}

		return "Errore:PartitaNonEsistente";

	}
	
}
