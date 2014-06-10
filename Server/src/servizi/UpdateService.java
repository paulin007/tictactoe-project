package servizi;

import gioco.Partita;

import java.util.ArrayList;
import java.util.StringTokenizer;

import server.ServerExceptions;

/**
 * Questo servizio viene chiamato quando è necessario richiedere un aggiornamento
 * sullo stato della partita. Solitamente quando si è in attesa della mossa avversaria. </br></br>
 * 
 * Riceve un solo Token che rappresenta l'id della partita di cui si richiede l'aggiornamento.
 * 
 * @author Andrea Gallo
 */
public class UpdateService implements IService {

	@Override
	public String handleService(StringTokenizer s, ArrayList<Partita> matches) {
		try {
			if (s.countTokens()!=1) throw new ServerExceptions("Formato errato",s );
			
			int idMatch = Integer.parseInt(s.nextToken());

			for (int i = 0; i < matches.size(); i++) {
				if (matches.get(i).getId() == idMatch) {
					System.out.println("SERVER> " + matches.get(i).toString());
					return matches.get(i).toString();
				}
			}

		} catch (NumberFormatException e) {
			try {
				throw new ServerExceptions("Formato Numerico errato",s);
			} catch (ServerExceptions e1) {
			}

		} catch (ServerExceptions e) {
		}

		return "Errore:PartitaNonEsistente";

	}

}
