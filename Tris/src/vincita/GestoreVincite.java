package vincita;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JOptionPane;

import tris.Casella;

public class GestoreVincite extends Observable  implements Observer {
	
	private VerificaVincita verificaVincita = new VerificaVincita();
	private ArrayList<Casella> caselle;
	boolean mostratoRisultato = false;
	
	
 	public GestoreVincite(ArrayList<Casella> caselle) {
		super();
		this.caselle=caselle;
		impostaObserver(caselle);
	}
	
	private void impostaObserver(ArrayList<Casella> caselle){
		for (int i = 0; i < caselle.size(); i++) {
			caselle.get(i).addObserver(this);
		}
	}
	/**
	 * Questo metodo permette di mostrare una schermata, contenente il risultato
	 * @param caselle
	 */
	public void qualcunoHavinto(ArrayList<Casella> caselle){
		if(verificaVincita.stabilisciVincitore(caselle)!=null){
			verificaVincita.separaMosse(caselle);
			if((verificaVincita.haiVinto(verificaVincita.getComputer())== true || verificaVincita.haiVinto(verificaVincita.getGiocatore())== true) && !mostratoRisultato){
				JOptionPane.showMessageDialog(null, verificaVincita.stabilisciVincitore(caselle));
				mostratoRisultato = true;
			}
		}
	}
	@Override
	public void update(Observable o, Object arg) {
		qualcunoHavinto(caselle);
	}
	
	public void update(){
		setChanged();
		notifyObservers();
	}

	public VerificaVincita getVerificaVincita() {
		return verificaVincita;
	}

	public void setVerificaVincita(VerificaVincita verificaVincita) {
		this.verificaVincita = verificaVincita;
	}
	
	
}
