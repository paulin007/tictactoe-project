/**
 * Questa classe ha resposanbilità di stabilire chi è il vincitore
 * @author Giacomo
 */
package vincita;

import java.util.ArrayList;

import tris.Casella;

public class VerificaVincita {
	
	private ArrayList<Integer> giocatore; 
	private ArrayList<Integer> computer;
	private ArrayList<Terna> vincitePossibili; // perchè non usare direttamente terneVincite?
	private String vincitore = null;
	
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
		giocatore = new ArrayList<Integer>();
		computer = new ArrayList<Integer>();
		for (int i = 0; i < caselle.size(); i++) {
			if(caselle.get(i).getSimbolo()!= null && caselle.get(i).getSimbolo().equalsIgnoreCase("g")){
				giocatore.add(caselle.get(i).getIDcasella());
			}else if(caselle.get(i).getSimbolo()!= null && caselle.get(i).getSimbolo().equalsIgnoreCase("c")){
				computer.add(caselle.get(i).getIDcasella());
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
		if(haiVinto(giocatore)){
			vincitore = "Giocatore";
			
			return "Ha vinto "+vincitore;
			
		}
		if(haiVinto(computer)){
			
			vincitore = "Computer";
		
			return "Ha vinto "+vincitore;
		}
		if(haiVinto(computer)== false && haiVinto(giocatore)==false){
			
			vincitore = "Pareggio";
			
			return vincitore;
		}
		return vincitore;
	}
	
	
	public boolean haiVinto(ArrayList<Integer> mosse){
		boolean vittoria = false;
		
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
					vittoria = true;
					
					break; 
				}	
		}	
		return vittoria;
				
	}
	
	public ArrayList<Integer> getGiocatore() {
		return giocatore;
	}
	public void setGiocatore(ArrayList<Integer> giocatore) {
		this.giocatore = giocatore;
	}
	public ArrayList<Integer> getComputer() {
		return computer;
	}
	public void setComputer(ArrayList<Integer> computer) {
		this.computer = computer;
	}
	/**
	 * Questo metodo stabilisce se ha vinto il giocatore
	 * @return
	 */
	public boolean haVintoGiocatore(){
		if(vincitore.equalsIgnoreCase("Giocatore")){
			return true;
		}else{
			return false;
		}
	}
	/**
	 * Questo metodo stabilisce se ha vinto il computer
	 * @return
	 */
	public boolean haVintoComputer(){
		if(vincitore.equalsIgnoreCase("Computer")){
			return true;
		}else{
			return false;
		}
	}
	/**
	 * Questo metodo stabilisce se la partita è finita in pareggio
	 * @return
	 */
	public boolean nessunoHaVinto(){
		if(vincitore.equalsIgnoreCase("Pareggio")){
			return true;
		}else{
			return false;
		}
	}
}
