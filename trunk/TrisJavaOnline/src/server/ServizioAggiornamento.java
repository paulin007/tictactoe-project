package server;

import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Questa classe, quando viene chiamato ha la responsabilità di fornire lo stato
 * della partita
 */
public class ServizioAggiornamento implements IServizio {

	@Override
	public String effettuaServizio(StringTokenizer s, ArrayList<Partita> partite) {
		try {
			if (s.countTokens()!=2) throw new Eccezioni("Formato errato",s );
			
			int idPartita = Integer.parseInt(s.nextToken());

			for (int i = 0; i < partite.size(); i++) {
				if (partite.get(i).getId() == idPartita) {
					System.out.println("SERVER> " + partite.get(i).toString());
					return partite.get(i).toString();
				}
			}

		} catch (NumberFormatException e) {
			try {
				throw new Eccezioni("Formato Numerico errato",s);
			} catch (Eccezioni e1) {
			}

		} catch (Eccezioni e) {
		}

		return "Errore:PartitaNonEsistente";

	}

}
