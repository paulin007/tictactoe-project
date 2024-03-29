/**
 * Questa classe ha la reponsabilità di gestire il pannello che contiene le Statistiche del giocatore
 * @author Giacomo
 */
package grafica;


import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import rete.IClient;
import rete.IStatisticInterpreter;

@SuppressWarnings("serial")
public class StatisticPanel extends JPanel{
	
	private IStatisticInterpreter interpreteStatistiche;
	private IClient client;
	private String[] games = {"Tris","Forza4"};
	private String[] playersName = {"Giacomo","Dario","Marco","Santo","Kokou","Paulin","Andrea" };
	private final JComboBox<String> comboBox1 = new JComboBox<String>(playersName);
	private final JComboBox<String> comboBox2 = new JComboBox<String>(games);
	private final JButton enter = new JButton("Invio");
	private JLabel statisticLabel = new JLabel();
	private JPanel backgroundPanel = new JPanel();
	private JPanel achiviementsPanel = new JPanel();
	private JTextArea achievementsArea = new JTextArea();
	private Font font = new Font("Verdana", Font.BOLD, 16);
	
	public StatisticPanel(IStatisticInterpreter interpreteStatistiche, IClient client){
		this.interpreteStatistiche = interpreteStatistiche;
		this.client = client;
		setBackgroundPanel();
		setStatisticPanel();
		requestAchiviements();
		setMainPanel();
	}

	private void setMainPanel() {
		setBackground(new Color(153,203,255));
		setLayout(new GridLayout(2, 1));
		add(backgroundPanel);
		add(achiviementsPanel);
	}

	private void setStatisticPanel() {
		achiviementsPanel.setBackground(new Color(153,203,255));
		achiviementsPanel.setLayout(new GridLayout(2, 1));
		achievementsArea.setFont(font);
		achievementsArea.setBackground(new Color(153,203,255));
		achiviementsPanel.add(achievementsArea);
		statisticLabel.setFont(font);
		achiviementsPanel.add(statisticLabel);
	}

	private void setBackgroundPanel() {
		setLayout(null);
		comboBox1.setBounds(142, 63, 110, 32);
		comboBox2.setBounds(335, 63, 110, 32);
		enter.setBounds(250, 143, 89, 23);
		backgroundPanel.setLayout(null);
		backgroundPanel.add(comboBox1);
		backgroundPanel.add(comboBox2);
		backgroundPanel.add(enter);
		backgroundPanel.setBackground(new Color(153,203,255));
	}
	
	private void requestAchiviements() {
		enter.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String giocatore = (String) comboBox1.getSelectedItem();
				String gioco = (String) comboBox2.getSelectedItem();
				String messaggio = "statistiche	"+giocatore+"	"+gioco;
				interpreteStatistiche.intepret(client.send(messaggio));
				updateGraphic();
				}
		});
	}
	
	private void updateGraphic(){
		addRecord();
		addAchiviement();
		updateUI();
	}
	
	private void addRecord(){
		statisticLabel.setText("Vittorie: "+interpreteStatistiche.getWins()+" Pareggi: "+interpreteStatistiche.getTie()+" Sconfitte: "+interpreteStatistiche.getLose());
		achiviementsPanel.add(statisticLabel);
	}
	
	private void addAchiviement(){
		achievementsArea.setText(interpreteStatistiche.achievementsToString());
	}
}
