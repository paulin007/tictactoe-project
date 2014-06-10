package servizi;

import gioco.GiochiPresenti;
import gioco.Partita;
import gioco.Simbolo;

import java.util.ArrayList;
import java.util.StringTokenizer;

import server.ServerExceptions;
import statistiche.IXMLManager;
import statistiche.XMLManager;
/**
 * 
 * Questo servizio si occupa di gestire una nuova mossa e di inviarla all'algoritmo che la elabora. </br></br>
 * 
 * Riceve 3 tokens, che rappresentano l'id della partita a cui si sta giocando, il giocatore che la fa e la 
 * mossa intesa come cifra.
 */
public class MoveService implements IService {

	@Override
	public String handleService(StringTokenizer s, ArrayList<Partita> matches) {
		
		try{
			if(s.countTokens()!=3) throw new ServerExceptions("Formato Errato",s);
			
			IXMLManager xmlmgr = new XMLManager();
			
		int idMatch = Integer.parseInt(s.nextToken());
		String player = s.nextToken();
		String move = s.nextToken();
		for (int i = 0; i < matches.size(); i++) {
			if (matches.get(i).getId() == idMatch) {					
				if(!(matches.get(i).getUltimoGiocatore().equalsIgnoreCase(player)))
						GiochiPresenti.mappaAlgoritmi.get(matches.get(i).getGioco().toLowerCase()).execute(matches.get(i), player, move);
					String esito = matches.get(i).getRisultato();
					
					if(esito.equalsIgnoreCase(Simbolo.simboloG1)){
						xmlmgr.newStatistic(matches.get(i).getGiocatore1(), "V", matches.get(i).getGioco());
						xmlmgr.newStatistic(matches.get(i).getGiocatore2(), "S", matches.get(i).getGioco());
					} else if(esito.equalsIgnoreCase(Simbolo.simboloG2)){
						xmlmgr.newStatistic(matches.get(i).getGiocatore1(), "S", matches.get(i).getGioco());
						xmlmgr.newStatistic(matches.get(i).getGiocatore2(), "V", matches.get(i).getGioco());
					} else if(esito.equalsIgnoreCase("Pareggio")){
						xmlmgr.newStatistic(matches.get(i).getGiocatore1(), "P", matches.get(i).getGioco());
						xmlmgr.newStatistic(matches.get(i).getGiocatore2(), "P", matches.get(i).getGioco());
					}
				return matches.get(i).toString();
			}
		}
		}catch(NumberFormatException ex){
			try {
				throw new ServerExceptions("Formato Numerico Errato", s);
			} catch (ServerExceptions e) {
			}
		} catch (ServerExceptions e) {
		}
		return "Errore:PartitaNonEsistente";
	}
	
}
