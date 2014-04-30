package vincita;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import tris.Casella;

public class GestoreVincite extends Observable implements Observer {
	
	private VerificaVincita verificaVincita;
	private ArrayList<Casella> caselle;
 	
	public GestoreVincite(VerificaVincita verificaVincita,ArrayList<Casella> caselle) {
		super();
		this.verificaVincita = verificaVincita;
		this.caselle=caselle;
		impostaObserver(caselle);
		
	}
	
	public void impostaObserver(ArrayList<Casella> caselle){
		for (int i = 0; i < caselle.size(); i++) {
			caselle.get(i).addObserver(this);
		}
	}
	
	public void qualcunoHavinto(ArrayList<Casella> caselle){
		if(verificaVincita.stabilisciVincitore(caselle)!=null){
			setChanged();
			notifyObservers();
		}
	}
	@Override
	public void update(Observable o, Object arg) {
		qualcunoHavinto(caselle);
		
	}
}
