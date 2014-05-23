package servizi;

import java.util.ArrayList;
import java.util.StringTokenizer;

import server.EccezioniServer;
import server.Partita;

/**
 * Questa classe, quando viene chiamato ha la responsabilità di fornire lo stato
 * della partita
 */
public class ServizioAggiornamento implements IServizio {

	@Override
	public String effettuaServizio(StringTokenizer s, ArrayList<Partita> partite) {
		try {
			if (s.countTokens()!=1) throw new EccezioniServer("Formato errato",s );
			
			int idPartita = Integer.parseInt(s.nextToken());

			for (int i = 0; i < partite.size(); i++) {
				if (partite.get(i).getId() == idPartita) {
					System.out.println("SERVER> " + partite.get(i).toString());
					return partite.get(i).toString();
				}
			}

		} catch (NumberFormatException e) {
			try {
				throw new EccezioniServer("Formato Numerico errato",s);
			} catch (EccezioniServer e1) {
			}

		} catch (EccezioniServer e) {
		}

		return "Errore:PartitaNonEsistente";

	}

}
