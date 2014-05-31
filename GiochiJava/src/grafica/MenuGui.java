package grafica;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
/**
 * Questa classe ha la reposanbilità di gestire il menu dell'applicazione Tris
 */
@SuppressWarnings("serial")
public class MenuGui extends JMenuBar {
	
	private JMenu giochi = new JMenu("Giochi");
	private JMenuItem tris = new JMenuItem("Tris");
	private JMenuItem forza4 = new JMenuItem("Forza4");
	private JMenu menuOnline = new JMenu("Partita ONLINE");
	private JMenuItem startGiocatori = new JMenuItem("Lista Giocatori");
	private JMenu record = new JMenu("Statistiche");
	private JMenuItem statistiche = new JMenuItem("Statistiche");
	
	public MenuGui(final PannelloPrincipale principale) {
		impostaMenuGiochi(principale);
		menuOnline.add(startGiocatori);
		azioneGiocatori(principale);
		record.add(statistiche);
		azioneStatistiche(principale);
		impostaMenuPrincipale();
		impostaScorciatoie();
	}

	private void azioneStatistiche(final PannelloPrincipale principale) {
		statistiche.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				principale.setPannello(new PannelloStatistica());
				
			}
		});
	}

	private void azioneGiocatori(final PannelloPrincipale principale) {
		startGiocatori.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				principale.setPannello(new PannelloGiocatori(principale));
			}
		});
	}

	private void impostaMenuPrincipale() {
		add(giochi);
		add(menuOnline);
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
			}
		});
	}
	
	private void impostaScorciatoie(){
		startGiocatori.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G,InputEvent.CTRL_MASK ));
		tris.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T,InputEvent.CTRL_MASK ));
		forza4.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F,InputEvent.CTRL_MASK ));
		statistiche.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,InputEvent.CTRL_MASK ));
	}
}


