package server;

import java.util.ArrayList;
import java.util.StringTokenizer;

import tris.Algoritmo;
/**
 *Questa classe ha la responsabilità di inviare la mossa effettuata
 */
public class ServizioInviaMossa implements IServizio {

	@Override
	public String effettuaServizio(StringTokenizer s, ArrayList<Partita> partite) {
		
		int idPartita = Integer.parseInt(s.nextToken());
		String giocatore = s.nextToken();
		String mossa = s.nextToken();
		for (int i = 0; i < partite.size(); i++) {
			if (partite.get(i).getId() == idPartita) {
					Algoritmo algoritmo = new Algoritmo();

					if(!(partite.get(i).getUltimoGiocatore().equalsIgnoreCase(giocatore)))
						algoritmo.execute(partite.get(i), giocatore, mossa);

//					output.println(partite.get(i));

					partite.get(i).setUltimoGiocatore(giocatore);
					
					return partite.get(i).toString();
			}

		}
		return "-1";
	}
	
}
