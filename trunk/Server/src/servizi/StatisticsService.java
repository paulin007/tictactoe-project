package servizi;

import gioco.Partita;

import java.util.ArrayList;
import java.util.StringTokenizer;

import server.ServerExceptions;
import statistiche.IXMLManager;
import statistiche.XMLManager;
/**
 * Questo servizio si occupa di richiedere all' {@link XMLManager} l'esecuzione di una query
 * che può essere una richiesta di una statistica o l'inserimento di una nuova. </br>
 * 
 * Riceve 2 token che rappresentano il giocatore di cui si richiede la statistica ed il gioco.
 */
public class StatisticsService implements IService {

	String statistics = "";
	@Override
	public String handleService(StringTokenizer s, ArrayList<Partita> matches) {

		try {
			if (s.countTokens() != 2) throw new ServerExceptions("Formato Errato", s);
		
		IXMLManager xmlmgr = new XMLManager();
		statistics = xmlmgr.getStatistic(s.nextToken(),s.nextToken());
		System.err.println(statistics);

		}catch (ServerExceptions e) {
		}
		
		return statistics;
	}

}
