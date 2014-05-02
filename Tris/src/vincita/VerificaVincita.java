/**
 * Questa classe ha resposanbilità di stabilire se il giocatore ha vinto
 * @author Giacomo
 */
package vincita;

import java.awt.Frame;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import tris.Casella;

public class VerificaVincita {
	
	private ArrayList<Integer> giocatore; 
	private ArrayList<Integer> computer;
	private ArrayList<Terna> vincitePossibili; // perch� non usare direttamente terneVincite?
	
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
		String vincitore = null;
		if(haiVinto(giocatore)){
			vincitore = "Giocatore";
			JOptionPane.showMessageDialog(null, "Ha vinto "+vincitore);
			return "Ha vinto "+vincitore;
			
		}else if(haiVinto(computer)==true){
			
			vincitore = "Computer";
			JOptionPane.showMessageDialog(null, "Ha vinto "+vincitore);
			return "Ha vinto "+vincitore;
		}
		else{
			
			vincitore = "Pareggio";
			JOptionPane.showMessageDialog(null, "Pareggio");
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
					break; // aggiunto break, inutile continuare a ciclare se la condizione di vittoria � raggiunta
				}	
//			}
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
}
