package server;

import java.util.ArrayList;
import java.util.StringTokenizer;
/**
 * Questa classe, quando viene chiamato ha la responsabilità di fornire lo stato della partita
 */
public class ServizioAggiornamento implements IServizio {

	@Override
	public String effettuaServizio(StringTokenizer s, ArrayList<Partita> partite) {
		int idPartita = Integer.parseInt(s.nextToken());
		for (int i = 0; i < partite.size(); i++) {
			if (partite.get(i).getId() == idPartita) {
				System.out.println("SERVER> "+partite.get(i).toString());
				return partite.get(i).toString();
			}
		}
		return "-1";
	}
	
}
