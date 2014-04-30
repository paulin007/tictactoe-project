//TO refactor !!!
package vincita;

import java.util.Observable;
import java.util.Observer;

public class VisualizzatoreRisultato implements Observer {
	
	public VisualizzatoreRisultato(GestoreVincite gestoreVincite) {
		gestoreVincite.addObserver(this);
	}
	
	@Override
	public void update(Observable o, Object arg) {
		System.out.println("Qualcuno ha vinto");
	}
}
