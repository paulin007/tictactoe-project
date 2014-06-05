package servizi;

import gioco.Partita;

import java.util.ArrayList;
import java.util.StringTokenizer;

import server.EccezioniServer;
import statistiche.IXMLManager;
import statistiche.XMLManager;

public class ServizioStatistiche implements IServizio {

	String statistiche = "";
	@Override
	public String effettuaServizio(StringTokenizer s, ArrayList<Partita> partite) {

		try {
			if (s.countTokens() != 2) throw new EccezioniServer("Formato Errato", s);
		
		IXMLManager xmlmgr = new XMLManager();
		statistiche = xmlmgr.richiediStatistica(s.nextToken(),s.nextToken());
		System.err.println(statistiche);

		}catch (EccezioniServer e) {
		}
		
		return statistiche;
	}

}
