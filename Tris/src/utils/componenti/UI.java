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


public class UI extends JFrame{

	private static final int DEFAULT_WIDTH=400;
	private static final int DEFAULT_HEIGHT=400;
	
	private static final long serialVersionUID = 0;
	private CheckBoxPanel panel = new CheckBoxPanel();
	private JButtonPanel button = new JButtonPanel(panel);
	
	public UI() {
		
		
//		setResizable(false);
	
		final JMenuBar bar = new JMenuBar();
		JMenu menuPartita = new JMenu("Nuova Partita");
		JMenu menuOpzioni = new JMenu("Opzioni");
		
		JMenuItem nuovaPartita = new JMenuItem("Inizia");
		
		JMenu menuLivelli = new JMenu("Difficoltà");
		
		JMenuItem item1 = new JMenuItem("Semplice");
		JMenuItem item2 = new JMenuItem("Medio");
		JMenuItem item3 = new JMenuItem("Difficile");
		menuLivelli.add(item1);
		menuLivelli.add(item2);
		menuLivelli.add(item3);
		
		JMenuItem item4 = new JMenuItem("Info");
		JMenuItem item5 = new JMenuItem("Record");
		
		final JButton start = new JButton("Start");
		start.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				setLayout(new BorderLayout());
				remove(panel);
				remove(start);
				
				button = new JButtonPanel(panel);
				add(button);
				updateFrame(bar);
				
			}

			
		});
		
		nuovaPartita.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				setLayout(new GridLayout(2,1));
				
				remove(panel);
				remove(start);
				remove(button);
				
				panel = new CheckBoxPanel();
				
				add(panel);
				add(start);
				
				updateFrame(bar);
				}
		});
		menuPartita.add(nuovaPartita);
		menuPartita.add(menuLivelli);
		
		
		menuOpzioni.add(item4);
		menuOpzioni.add(item5);
		
		
		
		setLayout(new GridLayout(1,1));
//		add(button);

		
		bar.add(menuPartita);
		bar.add(menuOpzioni);
		
		setJMenuBar(bar);
		

		setTitle("Tic Tac Toe");
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	private void updateFrame(final JMenuBar bar) {
		pack();
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT-bar.getHeight());
	}
	public static void main(String[] args) {
		UI ui = new UI();
		
	}
}
