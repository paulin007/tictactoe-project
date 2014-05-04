/**
 * Questa classe ha la reposanbilità di gestire il menu dell'applicazione Tris
 * @author Giacomo
 */
package newGui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import statistiche.InterpreteStatisticheDefault;

import computerIntelligenza.Difficoltà;
import computerIntelligenza.DifficoltàCasuale;
import computerIntelligenza.DifficoltàDifficile;
import computerIntelligenza.DifficoltàSemplice;
import computerIntelligenza.ProxyDifficoltà;

public class MenuTris extends JMenuBar {
	
	public MenuTris(final ProxyPannelloTris proxyPannelloTris, ProxyDifficoltà proxyDifficoltà) {
		final JMenuBar bar = new JMenuBar();
		JMenu menuPartita = new JMenu("Nuova Partita");
		JMenu menuOpzioni = new JMenu("Opzioni");
		JMenuItem nuovaPartita = new JMenuItem("Inizia");
		JMenu menuLivelli = new JMenu("Difficoltà");
		JMenuItem semplice = new JMenuItem("Semplice");
		JMenuItem medio = new JMenuItem("Medio");
		JMenuItem difficile = new JMenuItem("Difficile");
		JMenuItem casuale = new JMenuItem("Casuale");
		setMenuDifficoltà(casuale,new DifficoltàCasuale(),proxyDifficoltà);
		setMenuDifficoltà(semplice, new DifficoltàSemplice(),proxyDifficoltà);
		setMenuDifficoltà(medio, new DifficoltàSemplice(),proxyDifficoltà);
		setMenuDifficoltà(difficile, new DifficoltàDifficile(),proxyDifficoltà);
		menuLivelli.add(semplice);
		menuLivelli.add(medio);
		menuLivelli.add(difficile);
		menuLivelli.add(casuale);
		JMenuItem info = new JMenuItem("Info");
		JMenuItem record = new JMenuItem("Record");
		final JButton start = new JButton("Start");
		record.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				proxyPannelloTris.setPannelloTris(new PannelloStatistica(new InterpreteStatisticheDefault()));
			}
		});
		start.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				
			}

			
		});
		
		nuovaPartita.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				setLayout(new GridLayout(2,1));
				//panel = new CheckBoxPanel();
				//add(panel);
				proxyPannelloTris.setPannelloTris(new PannelloCheckBox(proxyPannelloTris));
				}
		});
		menuPartita.add(nuovaPartita);
		menuPartita.add(menuLivelli);
		menuOpzioni.add(info);
		menuOpzioni.add(record);
		setLayout(new GridLayout(1,1));
		bar.add(menuPartita);
		bar.add(menuOpzioni);
		add(menuPartita);
		add(menuOpzioni);
	}
	
	private void setMenuDifficoltà(JMenuItem difficoltà,
			final Difficoltà livello, final ProxyDifficoltà proxyDifficoltà) {
		difficoltà.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				proxyDifficoltà.setDifficoltà(livello);
				}
		});
	}
}


