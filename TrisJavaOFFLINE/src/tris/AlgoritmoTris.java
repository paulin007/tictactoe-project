/**
 * Questa classe ha resposanbilità di stabilire chi è il vincitore
 * @author Giacomo Bellazzi
 */
package tris;

import java.util.ArrayList;
import java.util.Observable;

import javax.swing.JOptionPane;

public class AlgoritmoTris extends Observable {
	
	private ArrayList<Integer> giocatore1; 
	private ArrayList<Integer> giocatore2;
	private ArrayList<Terna> vincitePossibili; //TODO perchè non usare direttamente terneVincite?
	private String risultato = null;
	
	public AlgoritmoTris() {
		TerneVincite terneVincite = new TerneVincite();
		vincitePossibili=terneVincite.getTerneVincenti();
	}
	/**
	 * Questo metodo permette di separare le caselle occupate dal computer,
	 * da quelle occupate dal giocatore
	 * @param caselle
	 */
	public void separaMosse(ArrayList<Casella> caselle){
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
	public void stabilisciVincitore(ArrayList<Casella> caselle){
		separaMosse(caselle);
		if(haiVinto(giocatore1)){
			setRisultato("Hai vinto");
		}
		if(haiVinto(giocatore2)){
			setRisultato("Hai perso");
		}
		if(haiVinto(giocatore2)== false && haiVinto(giocatore1)==false &&(giocatore1.size()+giocatore2.size()==9)){
			setRisultato("Pareggio");
			
		}
	}
	
	/**
	 * Determina se all'interno di una lista di mosse
	 * vi è una combinazione vincente
	 * @param mosse
	 * @return
	 */
	public boolean haiVinto(ArrayList<Integer> mosse){
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
	
	public ArrayList<Integer> getGiocatore1() {
		return giocatore1;
	}
	
	public ArrayList<Integer> getGiocatore2() {
		return giocatore2;
	}

	/**
	 * Questo metodo stabilisce se la partita è finita in pareggio
	 * @return
	 */
	public boolean nessunoHaVinto(){
		if(risultato.equalsIgnoreCase("Pareggio")){
			return true;
		}else{
			return false;
		}
	}
	/**
	 * Questo metodo permette di stabilire se la partita è finita;
	 * @return
	 */
	public boolean partitaFinita(){
		if(risultato!=null && !nessunoHaVinto()){
			return true;
		}else{
			return false;
		}
	}
	/**
	 * Questo metodo permette di restuire il risultato generato dall'algoritmo.
	 */
	public String getRisultato() {
		System.out.println(risultato);
		JOptionPane.showMessageDialog(null, risultato);
		return risultato;
	}
	public void setRisultato(String risultato){
		this.risultato=risultato;
		update();
	}
	public void update(){
		setChanged();
		notifyObservers();
	}
}
