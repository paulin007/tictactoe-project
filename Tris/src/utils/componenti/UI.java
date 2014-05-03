package utils.componenti;


import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.metal.MetalLookAndFeel;

import statistiche.InterpreteStatisticheDefault;
import computerIntelligenza.Difficoltà;
import computerIntelligenza.DifficoltàCasuale;
import computerIntelligenza.DifficoltàDifficile;
import computerIntelligenza.DifficoltàSemplice;
import computerIntelligenza.ProxyDifficoltà;


public class UI extends JFrame{

	private static final int DEFAULT_WIDTH=400;
	private static final int DEFAULT_HEIGHT=400;
	
	private static final long serialVersionUID = 0;
	private CheckBoxPanel panel = new CheckBoxPanel();
	private JButtonPanel button = new JButtonPanel(panel);
	private ProxyDifficoltà proxyDifficoltà;
	
	public UI() {
		
		final JMenuBar bar = new JMenuBar();
		JMenu menuPartita = new JMenu("Nuova Partita");
		JMenu menuOpzioni = new JMenu("Opzioni");
		JMenuItem nuovaPartita = new JMenuItem("Inizia");
		JMenu menuLivelli = new JMenu("Difficolt�");
		
		JMenuItem semplice = new JMenuItem("Semplice");
		JMenuItem medio = new JMenuItem("Medio");
		JMenuItem difficile = new JMenuItem("Difficile");
		JMenuItem casuale = new JMenuItem("Casuale");
		setMenuDifficoltà(casuale,new DifficoltàCasuale());
		setMenuDifficoltà(semplice, new DifficoltàSemplice());
		setMenuDifficoltà(medio, new DifficoltàSemplice());
		setMenuDifficoltà(difficile, new DifficoltàDifficile());
		menuLivelli.add(semplice);
		menuLivelli.add(medio);
		menuLivelli.add(difficile);
		menuLivelli.add(casuale);
		JMenuItem item4 = new JMenuItem("Info");
		JMenuItem record = new JMenuItem("Record");
		final PannelloStatistica pannelloStatistica = new PannelloStatistica(new InterpreteStatisticheDefault());
		final JButton start = new JButton("Start");
		record.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				add(pannelloStatistica);
				remove(panel);
				remove(panel);
				remove(start);
				updateFrame(bar);
			}
		});
		start.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				setLayout(new BorderLayout());
				remove(panel);
				remove(start);
				remove(pannelloStatistica);
				button = new JButtonPanel(panel);
				add(button);
				updateFrame(bar);
				try {
					UIManager.setLookAndFeel(new MetalLookAndFeel());
				} catch (UnsupportedLookAndFeelException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}

			
		});
		
		nuovaPartita.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				setLayout(new GridLayout(2,1));
				remove(panel);
				remove(start);
				remove(button);
				remove(pannelloStatistica);
				panel = new CheckBoxPanel();
				add(panel);
				add(start);
				updateFrame(bar);
				}
		});
		menuPartita.add(nuovaPartita);
		menuPartita.add(menuLivelli);
		menuOpzioni.add(item4);
		menuOpzioni.add(record);
		setLayout(new GridLayout(1,1));
		bar.add(menuPartita);
		bar.add(menuOpzioni);
		setJMenuBar(bar);
		setTitle("Tic Tac Toe");
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	private void setMenuDifficoltà(JMenuItem difficoltà,
			final Difficoltà livello) {
		difficoltà.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				proxyDifficoltà.setDifficoltà(livello);
				}
		});
	}
	private void updateFrame(final JMenuBar bar) {
		pack();
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT-bar.getHeight());
	}
	
}
