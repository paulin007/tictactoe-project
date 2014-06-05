package grafica;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

import managers.IMatchManager;
import managers.ITurnManager;

/**
 * Questa classe ha la reposanbilitÃ  di gestire il menu dell'applicazione Tris
 */
@SuppressWarnings("serial")
public class MenuGui extends JMenuBar {
	
	private JMenu giochi = new JMenu("Giochi");
	private JMenuItem tris = new JMenuItem("Tris");
	private JMenuItem forza4 = new JMenuItem("Forza4");
	private JMenu record = new JMenu("Statistiche");
	private JMenuItem statistiche = new JMenuItem("Statistiche");
	private IMatchManager matchManager;
	private ITurnManager turnManager;
	
	public MenuGui(final PannelloPrincipale principale, IMatchManager matchManager, ITurnManager turnManager) {
		this.matchManager = matchManager;
		this.turnManager = turnManager;
		impostaMenuGiochi(principale);
		record.add(statistiche);
//		azioneStatistiche(principale);
		impostaMenuPrincipale();
		impostaScorciatoie();
	}

	//TODO non fa praticamente nulla
//	private void azioneStatistiche(final PannelloPrincipale principale) {
//		statistiche.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
////				principale.setPannello(new PannelloStatistica());
//				
//			}
//		});
//	}

	private void impostaMenuPrincipale() {
		add(giochi);
		add(record);
	}

	private void impostaMenuGiochi(final PannelloPrincipale principale) {
		giochi.add(tris);
		giochi.add(forza4);
		impostaGioco(tris, principale, "Tris");
		impostaGioco(forza4, principale, "Forza4");
	}
	
	private void impostaGioco(JMenuItem gioco, final PannelloPrincipale principale, final String nomeGioco){
		gioco.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				principale.setGioco(nomeGioco);
				principale.setPannello(new PannelloGiocatori(principale, matchManager, turnManager));
			}
		});
	}
	
	private void impostaScorciatoie(){
		tris.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T,InputEvent.CTRL_MASK ));
		forza4.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F,InputEvent.CTRL_MASK ));
		statistiche.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,InputEvent.CTRL_MASK ));
	}
}


