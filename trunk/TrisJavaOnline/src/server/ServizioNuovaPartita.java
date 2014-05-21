package server;

import java.util.ArrayList;
import java.util.StringTokenizer;
/**
 * Questa classe ha la responsabilità di avviare una nuova partita
 */
public class ServizioNuovaPartita implements IServizio {

	private static int partitaIndex = 0;
	
	@Override
	public String effettuaServizio(StringTokenizer s, ArrayList<Partita> partite) {
		try {
			if(s.countTokens()!=3) throw new Eccezioni("Formato Errato",s);
			
		String giocatore1 = s.nextToken();
		String giocatore2 = s.nextToken();

		Partita partitaCreata = new Partita(partitaIndex, giocatore1,
				giocatore2);
		partite.add(partitaCreata);

		System.out.println("SERVER> "+partite.get(partitaIndex).toString());

		partitaIndex++;
		
		return partite.get(partitaIndex-1).toString();
		
		} catch (Eccezioni e) {
			
		}
		return "Errore:PartitaNonCreata";
	}
	
	
}
