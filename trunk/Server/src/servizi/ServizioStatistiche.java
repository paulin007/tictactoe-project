package servizi;

import java.util.ArrayList;
import java.util.StringTokenizer;

import server.EccezioniServer;
import gioco.Partita;
import statistiche.IStatisticManager;
import statistiche.StatisticManager;

public class ServizioStatistiche implements IServizio {

	String statistiche = "";
	@Override
	public String effettuaServizio(StringTokenizer s, ArrayList<Partita> partite) {

		try {
			if (s.countTokens() != 1) throw new EccezioniServer("Formato Errato", s);
		
		IStatisticManager xmlmgr = new StatisticManager();
		statistiche = xmlmgr.getStatistica(s.nextToken());

		}catch (EccezioniServer e) {
		}
		
		return statistiche;
	}

}
