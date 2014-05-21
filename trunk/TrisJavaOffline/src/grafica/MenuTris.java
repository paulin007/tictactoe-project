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

import tris.computerIntelligenza.Difficolta;
import tris.computerIntelligenza.DifficoltaDifficile;
import tris.computerIntelligenza.DifficoltaMedia;
import tris.computerIntelligenza.DifficoltaSemplice;

@SuppressWarnings("serial")
public class MenuTris extends JMenuBar {
	
	public MenuTris(final ControllerTris controllerTris) {
		
		final JMenuBar bar = new JMenuBar();
		JMenu menuPartita = new JMenu("Partita OFFLINE");
		JMenu menuLivelli = new JMenu("Difficoltà");
		JMenuItem startGiocatori = new JMenuItem("Lista Giocatori");
		startGiocatori.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G,InputEvent.CTRL_MASK ));
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
		setMenuDifficolta(semplice, new DifficoltaSemplice(),controllerTris);
		setMenuDifficolta(medio, new DifficoltaMedia(),controllerTris);
		setMenuDifficolta(difficile, new DifficoltaDifficile(),controllerTris);
		menuPartita.add(nuovaPartita);
		menuPartita.add(menuLivelli);
		bar.add(menuPartita);
		add(menuPartita);
	}
	
	private void setMenuDifficolta(JMenuItem difficoltà, final Difficolta livello, final ControllerTris controllerTris) {
		difficoltà.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controllerTris.getProxyDifficolta().setDifficoltà(livello);
			}
		});
	}
}


