/**
 * Questa classe ha la reposanbilità di gestire il menu dell'applicazione Tris
 * @author Giacomo
 */
package copyNew;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

import tris.TabellaTris;
import vincita.AlgoritmoTris;
import computerIntelligenza.Difficoltà;
import computerIntelligenza.DifficoltàDifficile;
import computerIntelligenza.DifficoltàMedia;
import computerIntelligenza.DifficoltàSemplice;
import computerIntelligenza.ProxyDifficoltà;

@SuppressWarnings("serial")
public class MenuTris extends JMenuBar {
	
	
	
	public MenuTris(final ControllerTris controllerTris) {
		
		final JMenuBar bar = new JMenuBar();
		JMenu menuPartita = new JMenu("Nuova Partita");
		JMenu menuOpzioni = new JMenu("Opzioni");
		JMenu menuLivelli = new JMenu("Difficoltà");
		JMenuItem semplice = new JMenuItem("Semplice");
		semplice.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,InputEvent.CTRL_MASK ));
		JMenuItem medio = new JMenuItem("Medio");
		medio.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M,InputEvent.CTRL_MASK ));
		JMenuItem difficile = new JMenuItem("Difficile");
		difficile.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D,InputEvent.CTRL_MASK ));
		JMenuItem info = new JMenuItem("Info");
		menuLivelli.add(semplice);
		menuLivelli.add(medio);
		menuLivelli.add(difficile);
		JMenuItem record = new JMenuItem("Record");
		record.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R,InputEvent.CTRL_MASK ));
		record.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
//				proxyPannelloTris.setPannelloTris(new PannelloStatistica(new InterpreteStatisticheDefault()));
//				controllerTris.setPannelloStatistica();
			}
		});
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
		menuOpzioni.add(info);
		menuOpzioni.add(record);
		bar.add(menuPartita);
		bar.add(menuOpzioni);
		add(menuPartita);
		add(menuOpzioni);
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


