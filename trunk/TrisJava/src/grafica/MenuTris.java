/**
 * Questa classe ha la reposanbilità di gestire il menu dell'applicazione Tris
 * @author Giacomo
 */
package grafica;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

import tris.computerIntelligenza.Difficoltà;
import tris.computerIntelligenza.DifficoltàDifficile;
import tris.computerIntelligenza.DifficoltàMedia;
import tris.computerIntelligenza.DifficoltàSemplice;

@SuppressWarnings("serial")
public class MenuTris extends JMenuBar {
	
	
	
	public MenuTris(final ControllerTris controllerTris) {
		
		final JMenuBar bar = new JMenuBar();
		JMenu menuPartita = new JMenu("Partita OFFLINE");
		JMenu menuLivelli = new JMenu("Difficoltà");
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
		JMenuItem semplice = new JMenuItem("Semplice");
		semplice.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,InputEvent.CTRL_MASK ));
		JMenuItem medio = new JMenuItem("Medio");
		medio.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M,InputEvent.CTRL_MASK ));
		JMenuItem difficile = new JMenuItem("Difficile");
		difficile.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D,InputEvent.CTRL_MASK ));

		menuLivelli.add(semplice);
		menuLivelli.add(medio);
		menuLivelli.add(difficile);

		
		JMenuItem nuovaPartita = new JMenuItem("Inizia");
		nuovaPartita.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,InputEvent.CTRL_MASK ));
		nuovaPartita.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				controllerTris.resetController();
				controllerTris.setPannelloCheckBox();
			}
		});
		setMenuDifficoltà(semplice, new DifficoltàSemplice(),controllerTris);
		setMenuDifficoltà(medio, new DifficoltàMedia(),controllerTris);
		setMenuDifficoltà(difficile, new DifficoltàDifficile(),controllerTris);
		menuPartita.add(nuovaPartita);
		menuPartita.add(menuLivelli);
		bar.add(menuPartita);
		add(menuPartita);
		add(menuOnline);
	}
	
	private void setMenuDifficoltà(JMenuItem difficoltà, final Difficoltà livello, final ControllerTris controllerTris) {
		difficoltà.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controllerTris.getProxyDifficolta().setDifficoltà(livello);
			}
		});
	}
}


