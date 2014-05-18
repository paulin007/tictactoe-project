package server;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class ServizioCollegamento implements IServizio {

	@Override
	public String effettuaServizio(StringTokenizer s, ArrayList<Partita> partite) {
	
		String giocatore1 = s.nextToken();
		System.out.println(giocatore1);
		String giocatore2 = s.nextToken();
		System.out.println();
		for (int i = 0; i < partite.size(); i++) {
			if (partite.get(i).getGiocatore1().equalsIgnoreCase(giocatore1)
					&& partite.get(i).getGiocatore2()
					.equalsIgnoreCase(giocatore2)
					&& partite.get(i).getRisultato().equalsIgnoreCase("inCorso")) {

				System.out.println("Restituito a " + giocatore2
						+ " l'id della partita con " + giocatore1 + ": "
						+ partite.get(i).getId());
				return partite.get(i).toString();
				
			}
		
		}
		
		System.out.println("Tentata connessione a partita non esistente.");
		System.out.println(s.toString());
		
		return "partita non esistente	" + giocatore1 + "	" + giocatore2;
		
	}
	
}
