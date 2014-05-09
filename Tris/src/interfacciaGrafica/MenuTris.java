/**
 * Questa classe ha la reposanbilità di gestire il menu dell'applicazione Tris
 * @author Giacomo
 */
package interfacciaGrafica;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

import statistiche.InterpreteStatisticheDefault;
import tris.computerIntelligenza.Difficoltà;
import tris.computerIntelligenza.DifficoltàDifficile;
import tris.computerIntelligenza.DifficoltàMedia;
import tris.computerIntelligenza.DifficoltàSemplice;
import tris.computerIntelligenza.ProxyDifficoltà;


@SuppressWarnings("serial")
public class MenuTris extends JMenuBar {
	
	
	
	public MenuTris(final ProxyPannelloTris proxyPannelloTris, ProxyDifficoltà proxyDifficoltà) {
		
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
				proxyPannelloTris.setPannelloTris(new PannelloStatistica(new InterpreteStatisticheDefault()));
			}
		});
		JMenuItem nuovaPartita = new JMenuItem("Inizia");
		nuovaPartita.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,InputEvent.CTRL_MASK ));
		nuovaPartita.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
//				setLayout(new GridLayout(2,1));
				proxyPannelloTris.setPannelloTris(new PannelloCheckBox(proxyPannelloTris));
			}
		});
		setMenuDifficoltà(semplice, new DifficoltàSemplice(),proxyDifficoltà);
		setMenuDifficoltà(medio, new DifficoltàMedia(),proxyDifficoltà);
		setMenuDifficoltà(difficile, new DifficoltàDifficile(),proxyDifficoltà);
		menuPartita.add(nuovaPartita);
		menuPartita.add(menuLivelli);
		menuOpzioni.add(info);
		menuOpzioni.add(record);
//		setLayout(new GridLayout(1,1));
		bar.add(menuPartita);
		bar.add(menuOpzioni);
		add(menuPartita);
		add(menuOpzioni);
	}
	
	private void setMenuDifficoltà(JMenuItem difficoltà, final Difficoltà livello, final ProxyDifficoltà proxyDifficoltà) {
		difficoltà.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				proxyDifficoltà.setDifficoltà(livello);
			}
		});
	}
}


