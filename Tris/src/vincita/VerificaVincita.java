/**
 * Questa classe ha resposanbilitÃ  di stabilire se il giocatore ha vinto
 * @author Giacomo
 */
package vincita;

import java.util.ArrayList;

import tris.Casella;

public class VerificaVincita {
	
	private ArrayList<Integer> x; 
	private ArrayList<Integer> o;
	private ArrayList<Terna> vincitePossibili; // perchè non usare direttamente terneVincite?
	
	public VerificaVincita() {
		TerneVincite terneVincite = new TerneVincite();
		vincitePossibili=terneVincite.getTerneVincenti();
	}
	/**
	 * Questo metodo permette di separare le caselle occupate dal computer,
	 * da quelle occupate dal giocatore
	 * @param caselle
	 */
	
	// corretto l'if: aggiunta la condizione caselle.get(i).getSimbolo()!= null
	public void separaMosse(ArrayList<Casella> caselle){
		x = new ArrayList<Integer>();
		o = new ArrayList<Integer>();
		for (int i = 0; i < caselle.size(); i++) {
			if(caselle.get(i).getSimbolo()!= null && caselle.get(i).getSimbolo().equalsIgnoreCase("g")){
				x.add(caselle.get(i).getIDcasella());
			}else if(caselle.get(i).getSimbolo()!= null && caselle.get(i).getSimbolo().equalsIgnoreCase("c")){
				o.add(caselle.get(i).getIDcasella());
			}
		}
	}
	/**
	 * Questo metodo permette di stabilire chi ha vinto
	 * @param terneVincite
	 * @return
	 */
	public String stabilisciVincitore(ArrayList<Casella> caselle){
		separaMosse(caselle);
		String vincitore = null;
		if(haiVinto(x)){
			vincitore = "Giocatore";
			return "Ha vinto "+vincitore;
			
		}else if(haiVinto(o)==true){
			
			vincitore = "Computer";
			return "Ha vinto "+vincitore;
		}
		else{
			
			vincitore = "Pareggio";
			return vincitore;
		}
	}
	
	
	// cambio in public per verificare che funzioni
	// corretto il ciclo for x.size --> mosse.size
	public boolean haiVinto(ArrayList<Integer> mosse){
		boolean vittoria = false;
		
		for (int i = 0; i < vincitePossibili.size(); i++) {
			// elimino il while, non serve
//			while(!vittoria){
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
					vittoria = true;
					System.out.println(vincitePossibili.get(i));
					break; // aggiunto break, inutile continuare a ciclare se la condizione di vittoria è raggiunta
				}	
//			}
		}	
		return vittoria;
				
	}

	public ArrayList<Integer> getX() {
		return x;
	}

	public void setX(ArrayList<Integer> x) {
		this.x = x;
	}

	public ArrayList<Integer> getO() {
		return o;
	}

	public void setO(ArrayList<Integer> o) {
		this.o = o;
	}
}
