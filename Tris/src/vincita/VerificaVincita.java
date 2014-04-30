/**
 * Questa classe ha resposanbilità di stabilire se il giocatore ha vinto
 * @author Giacomo
 */
package vincita;

import java.util.ArrayList;

import tris.Casella;

public class VerificaVincita {
	
	private ArrayList<Integer> x; 
	private ArrayList<Integer> o;
	private ArrayList<Terna> vincitePossibili;
	public VerificaVincita() {
		TerneVincite terneVincite = new TerneVincite();
		vincitePossibili=terneVincite.getTerneVincenti();
	}
	/**
	 * Questo metodo permette di separare le caselle occupate dal computer,
	 * da quelle occupate dal giocatore
	 * @param caselle
	 */
	public void separaMosse(ArrayList<Casella> caselle){
		x = new ArrayList<>();
		o = new ArrayList<>();
		for (int i = 0; i < caselle.size(); i++) {
			if(caselle.get(i).getSimbolo().equalsIgnoreCase("g")){
				x.add(caselle.get(i).getIDcasella());
			}else if(caselle.get(i).getSimbolo().equalsIgnoreCase("c")){
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
		}else if(haiVinto(o)){
			vincitore = "Computer";
		}else{
			vincitore = "Pareggio";
		}
		System.out.println("Ha vinto "+vincitore);
		return vincitore;
	}
	
	private boolean haiVinto(ArrayList<Integer> mosse){
		boolean vittoria = false;
		for (int i = 0; i < vincitePossibili.size(); i++) {
			while(!vittoria){
				int index = 0;
				for (int j = 0; j < x.size(); j++) {
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
				}	
			}
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
