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
public class MenuTris extends JMenuBar {
	
	public MenuTris(final ControllerTris controllerTris) {
		
		JMenu menuOnline = new JMenu("Partita ONLINE");
		JMenuItem startGiocatori = new JMenuItem("Lista Giocatori");
		startGiocatori.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G,InputEvent.CTRL_MASK ));
		menuOnline.add(startGiocatori);
		startGiocatori.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controllerTris.setPannelloGiocatori();
				}
		});
		
		add(menuOnline);
	}
	

}


