/**
 * Questa interfaccia astrae sul concetto di algoritmo, presente in un gioco
 */
package tris;

import java.util.ArrayList;

import server.Partita;
import tris.vincita.Terna;
import tris.vincita.TerneVincite;

public class Algoritmo {
	private ArrayList<Integer> giocatore1; 
	private ArrayList<Integer> giocatore2;
	private ArrayList<Terna> vincitePossibili;
	private String situazione = "inCorso";
	
	public Algoritmo() {
		super();
		TerneVincite terneVincite = new TerneVincite();
		vincitePossibili=terneVincite.getTerneVincenti();
	}

	/**
	 * Questo metodo è in grado di poter inviare un comando e ritornare una stringa,
	 * che permette di ritorno un valore generato dall'algoritmo
	 * @param mossa
	 * @return
	 */
	public String execute(Partita partita,String giocatore,String mossa){
		if(partita.getCelle().getCaselle().get(Integer.valueOf(mossa)).isVuota()){
			partita.getCelle().getCaselle().get(Integer.valueOf(mossa)).setSimbolo(giocatore);
		}else{
			return "MossaNonValida";
		}
		stabilisciSituazione(partita.getCelle().getCaselle());
		partita.setRisultato(situazione);
		return partita.toString();
	}
	
	/**
	 * Questo metodo permette di separare le caselle occupate dal computer,
	 * da quelle occupate dal giocatore
	 * @param caselle
	 */
	private void separaMosse(ArrayList<Casella> caselle){
		giocatore1 = new ArrayList<Integer>();
		giocatore2 = new ArrayList<Integer>();
		for (int i = 0; i < caselle.size(); i++) {
			if(caselle.get(i).getSimbolo()!= null && caselle.get(i).occupataDaG1()){
				giocatore1.add(caselle.get(i).getIDcasella());
			}else if(caselle.get(i).getSimbolo()!= null && caselle.get(i).occupataDaG2()){
				giocatore2.add(caselle.get(i).getIDcasella());
			}
		}
	}
	
	/**
	 * Questo metodo permette di stabilire chi ha vinto
	 * @param terneVincite
	 * @return
	 */
	private void stabilisciSituazione(ArrayList<Casella> caselle){
		separaMosse(caselle);
		if(haVinto(giocatore1)){
			setSituazione("Giocatore1");
		}
		if(haVinto(giocatore2)){
			setSituazione("Giocatore2");
		}
		if(haVinto(giocatore2)== false && haVinto(giocatore1)==false &&(giocatore1.size()+giocatore2.size()==9)){
			setSituazione("Pareggio");
		}
	}
	
	/**
	 * Determina se all'interno di una lista di mosse
	 * vi è una combinazione vincente
	 * @param mosse
	 * @return
	 */
	private boolean haVinto(ArrayList<Integer> mosse){
		for (int i = 0; i < vincitePossibili.size(); i++) {
			int index = 0;
			for (int j = 0; j < mosse.size(); j++) {
				if(vincitePossibili.get(i).getX()==mosse.get(j)){
					index++;
				}
				if(vincitePossibili.get(i).getY()==mosse.get(j)){
					index++;
				}
				if(vincitePossibili.get(i).getZ()==mosse.get(j)){
					index++;
				}
			}
			if(index==3){
				return true;
			}	
		}	
		return false;
	}

	public String getSituazione() {
		return situazione;
	}

	public void setSituazione(String situazione) {
		this.situazione = situazione;
	}
}
	
