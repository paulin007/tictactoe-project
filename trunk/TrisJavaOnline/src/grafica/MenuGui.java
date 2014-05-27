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
	
	public MenuGui(final ControllerGioco controllerTris) {
		JMenu giochi = new JMenu("Giochi");
		JMenuItem tris = new JMenuItem("Tris");
		JMenuItem forza4 = new JMenuItem("Forza4");
		giochi.add(tris);
		giochi.add(forza4);
		impostaGioco(tris, controllerTris, "Tris");
		impostaGioco(forza4, controllerTris, "Forza4");
		JMenu menuOnline = new JMenu("Partita ONLINE");
		JMenuItem startGiocatori = new JMenuItem("Lista Giocatori");
		menuOnline.add(startGiocatori);
		startGiocatori.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controllerTris.setPannelloGiocatori();
				}
		});
		add(giochi);
		add(menuOnline);
		startGiocatori.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G,InputEvent.CTRL_MASK ));
		tris.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T,InputEvent.CTRL_MASK ));
		forza4.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F,InputEvent.CTRL_MASK ));
	}
	
	private void impostaGioco(JMenuItem gioco, final ControllerGioco controllerTris, final String nomeGioco){
		gioco.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				controllerTris.setNomeGioco(nomeGioco);
			}
		});
	}
}


