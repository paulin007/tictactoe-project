package grafica;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import managers.IMatchManager;
import managers.ITurnManager;


public class ButtonListener implements ActionListener {

	private int location;
	private IMatchManager matchManager;
	private PannelloGioco pannelloGioco;
	private ITurnManager turnManager;
	
	public ButtonListener(int location, IMatchManager matchManager, PannelloGioco pannelloGioco, ITurnManager turnManager) {
		super();
		this.location = location;
		this.matchManager = matchManager;
		this.pannelloGioco = pannelloGioco;
		this.turnManager = turnManager;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		if(turnManager.isMyTurn()){
			if(!turnManager.isConnected()){
				if(pannelloGioco.getCaselle().get(location).isEnabled()){
					matchManager.sendMove(location);
					matchManager.requestUpdate();
				}
			}else{
				matchManager.sendMove(location);
			}
		}
	
	}
	
}
