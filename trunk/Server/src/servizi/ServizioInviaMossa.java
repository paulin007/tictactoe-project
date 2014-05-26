package servizi;

import gioco.GiochiPresenti;
import gioco.Partita;
import gioco.Simbolo;

import java.util.ArrayList;
import java.util.StringTokenizer;

import server.EccezioniServer;
import statistiche.IXMLManager;
import statistiche.XMLDEMO;
/**
 *Questa classe ha la responsabilit�� di effettuare il servizio per inviare la mossa effettuata
 */
public class ServizioInviaMossa implements IServizio {

	@Override
	public String effettuaServizio(StringTokenizer s, ArrayList<Partita> partite) {
		
		try{
			if(s.countTokens()!=3) throw new EccezioniServer("Formato Errato",s);
			
			IXMLManager xmlmgr = new XMLDEMO();
			
		int idPartita = Integer.parseInt(s.nextToken());
		String giocatore = s.nextToken();
		String mossa = s.nextToken();
		for (int i = 0; i < partite.size(); i++) {
			if (partite.get(i).getId() == idPartita) {
					
				
					if(!(partite.get(i).getUltimoGiocatore().equalsIgnoreCase(giocatore)))
						GiochiPresenti.mappaAlgoritmi.get(partite.get(i).getGioco()).execute(partite.get(i), giocatore, mossa);
					String esito = partite.get(i).getRisultato();
					if(esito.equalsIgnoreCase(Simbolo.simboloG1)){
						xmlmgr.nuovaStatistica(partite.get(i).getGiocatore1(), "V");
						xmlmgr.nuovaStatistica(partite.get(i).getGiocatore2(), "S");
					}
						
					if(esito.equalsIgnoreCase(Simbolo.simboloG2)){
						xmlmgr.nuovaStatistica(partite.get(i).getGiocatore1(), "S");
						xmlmgr.nuovaStatistica(partite.get(i).getGiocatore2(), "V");
					}
					if(esito.equalsIgnoreCase("Pareggio")){
						xmlmgr.nuovaStatistica(partite.get(i).getGiocatore1(), "X");
						xmlmgr.nuovaStatistica(partite.get(i).getGiocatore2(), "X");
					}
						
					

					partite.get(i).setUltimoGiocatore(giocatore);
					
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
