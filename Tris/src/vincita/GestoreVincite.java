package vincita;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JOptionPane;

import tris.Casella;

public class GestoreVincite extends Observable  implements Observer {
	
	private VerificaVincita verificaVincita = new VerificaVincita();
	private ArrayList<Casella> caselle;
	private AggiornaStatistica aggiornaStatistica;
	boolean mostratoRisultato = false;
	
	
 	public GestoreVincite(ArrayList<Casella> caselle) {
		super();
		this.caselle=caselle;
		aggiornaStatistica = new AggiornaStatistica(this);
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
				update();
				System.out.println(verificaVincita.getComputer().size()+" "+verificaVincita.getComputer().size());
			}
			if((verificaVincita.getComputer().size()==4) && (verificaVincita.getGiocatore().size()==5) && (verificaVincita.haiVinto(verificaVincita.getComputer())== false && verificaVincita.haiVinto(verificaVincita.getGiocatore())== false)){
				JOptionPane.showMessageDialog(null, verificaVincita.stabilisciVincitore(caselle));
				mostratoRisultato = true;
				update();
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
