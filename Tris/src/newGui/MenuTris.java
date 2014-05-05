/**
 * Questa classe ha la reposanbilità di gestire il menu dell'applicazione Tris
 * @author Giacomo
 */
package newGui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import statistiche.InterpreteStatisticheDefault;

import computerIntelligenza.Difficoltà;
import computerIntelligenza.DifficoltàDifficile;
import computerIntelligenza.DifficoltàNonImplementata;
import computerIntelligenza.ProxyDifficoltà;

public class MenuTris extends JMenuBar {
	
	
	
	public MenuTris(final ProxyPannelloTris proxyPannelloTris, ProxyDifficoltà proxyDifficoltà) {
		
		final JMenuBar bar = new JMenuBar();
		
		JMenu menuPartita = new JMenu("Nuova Partita");
		JMenu menuOpzioni = new JMenu("Opzioni");
		JMenu menuLivelli = new JMenu("Difficoltà");
		
		
		JMenuItem semplice = new JMenuItem("Semplice");
		JMenuItem medio = new JMenuItem("Medio");
		JMenuItem difficile = new JMenuItem("Difficile");
		JMenuItem info = new JMenuItem("Info");
		
		
		menuLivelli.add(semplice);
		menuLivelli.add(medio);
		menuLivelli.add(difficile);
		
		
		
		JMenuItem record = new JMenuItem("Record");
		record.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				proxyPannelloTris.setPannelloTris(new PannelloStatistica(new InterpreteStatisticheDefault()));
			}
		});
			
		
		JMenuItem nuovaPartita = new JMenuItem("Inizia");
		nuovaPartita.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
//				setLayout(new GridLayout(2,1));
				proxyPannelloTris.setPannelloTris(new PannelloCheckBox(proxyPannelloTris));
			}
		});
		
		setMenuDifficoltà(semplice, new DifficoltàNonImplementata(),proxyDifficoltà);
		setMenuDifficoltà(medio, new DifficoltàNonImplementata(),proxyDifficoltà);
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


