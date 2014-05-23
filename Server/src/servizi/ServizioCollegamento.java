package servizi;

import java.util.ArrayList;
import java.util.StringTokenizer;

import server.EccezioniServer;
import server.Partita;
/**
 *Questa classe ha la responsabilità di effettuare il servizio per collegare un giocatore ad un altro
 */
public class ServizioCollegamento implements IServizio {

	@Override
	public String effettuaServizio(StringTokenizer s, ArrayList<Partita> partite) {
	
		try {
		if(s.countTokens()!=2)	throw new EccezioniServer("Formato errato",s );
		String giocatore1 = s.nextToken();
		String giocatore2 = s.nextToken();
		for (int i = 0; i < partite.size(); i++) {
			if (partite.get(i).getGiocatore1().equalsIgnoreCase(giocatore1)
					&& partite.get(i).getGiocatore2().equalsIgnoreCase(giocatore2)
						&& partite.get(i).getRisultato().equalsIgnoreCase("inCorso")) {

				System.out.println("SERVER> "+partite.get(i).toString());
				return partite.get(i).toString();
				
			}
		
		}		

		} catch (EccezioniServer e) {
		}

		return "Errore:PartitaNonEsistente";

	}
	
}
