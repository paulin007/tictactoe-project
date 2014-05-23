package servizi;

import gioco.Partita;

import java.util.ArrayList;
import java.util.StringTokenizer;

import server.EccezioniServer;
import tris.AlgoritmoTris;
/**
 *Questa classe ha la responsabilit�� di effettuare il servizio per inviare la mossa effettuata
 */
public class ServizioInviaMossa implements IServizio {

	@Override
	public String effettuaServizio(StringTokenizer s, ArrayList<Partita> partite) {
		
		try{
			if(s.countTokens()!=3) throw new EccezioniServer("Formato Errato",s);
			
		int idPartita = Integer.parseInt(s.nextToken());
		String giocatore = s.nextToken();
		String mossa = s.nextToken();
		for (int i = 0; i < partite.size(); i++) {
			if (partite.get(i).getId() == idPartita) {
					AlgoritmoTris algoritmo = new AlgoritmoTris();
					if(!(partite.get(i).getUltimoGiocatore().equalsIgnoreCase(giocatore)))
						algoritmo.execute(partite.get(i), giocatore, mossa);
					String esito = partite.get(i).getRisultato();
					//if(esito.equalsIgnoreCase(Simbolo.simboloG1))
						partite.get(i).setUltimoGiocatore(giocatore);
					return partite.get(i).toString();
			}
		}
		}catch(NumberFormatException ex){
			try {
				throw new EccezioniServer("Formato Numerico Errato", s);
			} catch (EccezioniServer e) {
			}
		} catch (EccezioniServer e) {
		}
		return "Errore:PartitaNonEsistente";
	}
	
}
