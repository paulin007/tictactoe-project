/**
 * Questa classe ha la reponsabilità di gestire il pannello che contiene le Statistiche del giocatore
 * @author Giacomo
 */
package grafica;


import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import rete.Client;
import rete.InterPreteStatistiche;

@SuppressWarnings("serial")
public class PannelloStatistica extends JPanel{
	
	private InterPreteStatistiche statistiche = new InterPreteStatistiche();
	private String[] giochi = {"Tris","Forza4"};
	private String[] nomiGiocatori = {"Giacomo","Dario","Marco","Santo","Kokou","Paulin","Andrea" };
	private final JComboBox<String> comboBox1 = new JComboBox<String>(nomiGiocatori);
	private final JComboBox<String> comboBox2 = new JComboBox<String>(giochi);
	private final JButton invio = new JButton("Invio");
	private JLabel labelStatistiche = new JLabel();
	private JPanel pannelloRichieste = new JPanel();
	private JPanel pannelloStatistiche = new JPanel();
	private Font font = new Font("Verdana", Font.BOLD, 16);
	
	public PannelloStatistica(){
		impostaPannelloRichieste();
		impostaPannelloStatistiche();
		inviaRichiesta();
		impostaPannelloPrincipale();
	}

	private void impostaPannelloPrincipale() {
		setBackground(new Color(153,203,255));
		setLayout(new GridLayout(2, 1));
		add(pannelloRichieste);
		add(pannelloStatistiche);
	}

	private void impostaPannelloStatistiche() {
		labelStatistiche.setFont(font);
		pannelloStatistiche.add(labelStatistiche);
		pannelloStatistiche.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 20));
		pannelloStatistiche.setBackground(new Color(153,203,255));
	}

	private void impostaPannelloRichieste() {
		pannelloRichieste.setLayout(new GridLayout(2, 1));
		pannelloRichieste.add(comboBox1);
		pannelloRichieste.add(comboBox2);
		pannelloRichieste.add(invio);
		pannelloRichieste.setBackground(new Color(153,203,255));
	}

	private void aggiungiAchievement(){
		for (int i = 0; i < statistiche.getAchievements().size(); i++) {
			JLabel achievement = new JLabel(statistiche.getAchievements().get(i));
			achievement.setFont(font);
			pannelloStatistiche.add(achievement);
		}
	}
	private void inviaRichiesta() {
		invio.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String giocatore = (String) comboBox1.getSelectedItem();
				String gioco = (String) comboBox2.getSelectedItem();
				String messaggio = "statistiche	"+giocatore+"	"+gioco;
//				statistiche.intepreta(Client.send(messaggio));
				aggiornaGrafica();
				}
		});
	}
	private void aggiornaGrafica(){
		pannelloStatistiche.removeAll();
		pannelloStatistiche.setLayout(new GridLayout(statistiche.getAchievements().size()+1, 1));
		aggiungiRecord();
		aggiungiAchievement();
		updateUI();
	}
	private void aggiungiRecord(){
		labelStatistiche.setText("Vittorie: "+statistiche.getVittorie()+" Pareggi: "+statistiche.getPareggi()+" Sconfitte: "+statistiche.getSconfitte());
		pannelloStatistiche.add(labelStatistiche);
	}
}
