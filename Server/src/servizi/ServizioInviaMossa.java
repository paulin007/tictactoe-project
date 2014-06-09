package servizi;

import gioco.GiochiPresenti;
import gioco.Partita;
import gioco.Simbolo;

import java.util.ArrayList;
import java.util.StringTokenizer;

import server.EccezioniServer;
import statistiche.IXMLManager;
import statistiche.XMLManager;
/**
 *Questa classe ha la responsabilit�� di effettuare il servizio per inviare la mossa effettuata
 */
public class ServizioInviaMossa implements IServizio {

	@Override
	public String effettuaServizio(StringTokenizer s, ArrayList<Partita> partite) {
		
		try{
			if(s.countTokens()!=3) throw new EccezioniServer("Formato Errato",s);
			
			IXMLManager xmlmgr = new XMLManager();
			
		int idPartita = Integer.parseInt(s.nextToken());
		String giocatore = s.nextToken();
		String mossa = s.nextToken();
		for (int i = 0; i < partite.size(); i++) {
			if (partite.get(i).getId() == idPartita) {					
				if(!(partite.get(i).getUltimoGiocatore().equalsIgnoreCase(giocatore)))
						GiochiPresenti.mappaAlgoritmi.get(partite.get(i).getGioco().toLowerCase()).execute(partite.get(i), giocatore, mossa);
					String esito = partite.get(i).getRisultato();
					if(esito.equalsIgnoreCase(Simbolo.simboloG1)){
						xmlmgr.nuovaStatistica(partite.get(i).getGiocatore1(), "V", partite.get(i).getGioco());
						xmlmgr.nuovaStatistica(partite.get(i).getGiocatore2(), "S", partite.get(i).getGioco());
					}
						
					if(esito.equalsIgnoreCase(Simbolo.simboloG2)){
						xmlmgr.nuovaStatistica(partite.get(i).getGiocatore1(), "S", partite.get(i).getGioco());
						xmlmgr.nuovaStatistica(partite.get(i).getGiocatore2(), "V", partite.get(i).getGioco());
					}
					if(esito.equalsIgnoreCase("Pareggio")){
						xmlmgr.nuovaStatistica(partite.get(i).getGiocatore1(), "P", partite.get(i).getGioco());
						xmlmgr.nuovaStatistica(partite.get(i).getGiocatore2(), "P", partite.get(i).getGioco());
					}
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
