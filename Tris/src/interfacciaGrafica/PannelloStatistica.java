/**
 * Questa classe ha la reponsabilità di gestire il pannello che contiene le Statistiche del giocatore
 * @author Giacomo
 */
package interfacciaGrafica;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.Spring;
import javax.swing.SpringLayout;

import statistiche.CaricamentoFile;
import statistiche.InterpreteStatistiche;

@SuppressWarnings("serial")
public class PannelloStatistica extends JPanel implements PannelloTris {
	
	private JTextArea area = new JTextArea();
	private CaricamentoFile caricamentoFile;
	private static String percorsoFile = "./src/StatisticaProva.txt";
	private InterpreteStatistiche interpreteStatistiche;

	public PannelloStatistica(InterpreteStatistiche interpreteStatistiche) {
		super();
		this.interpreteStatistiche = interpreteStatistiche;
		caricamentoFile = new CaricamentoFile();
		caricamentoFile.setNomeFile(percorsoFile);
		
	}
	
	@Override
	public JPanel creaPannello() {
		
		Font font = new Font("Verdana", Font.BOLD, 16);
		interpreteStatistiche.statisticheDaFile(caricamentoFile.getList().get(0));
		
		
		JLabel labelVittorie = new JLabel("Vittorie: "+interpreteStatistiche.getStatistica().getVittorie());
		labelVittorie.setFont(font);
		JPanel vittorie = new JPanel();
		SpringLayout layout = new SpringLayout();
		vittorie.setLayout(layout);
		SpringLayout.Constraints  labelCons = layout.getConstraints(labelVittorie);
		vittorie.setBackground(new Color(153,203,255));
		labelCons.setX(Spring.constant(190));
        labelCons.setY(Spring.constant(40));
		vittorie.add(labelVittorie,BorderLayout.CENTER);
		
		
		JLabel labelPareggi = new JLabel("Pareggi: "+interpreteStatistiche.getStatistica().getPareggi());
		labelPareggi.setFont(font);
		JPanel pareggi = new JPanel();
		
		pareggi.setBackground(new Color(153,203,255));
		
		
		pareggi.add(labelPareggi);
		
		
		JLabel labelSconfitte = new JLabel("Sconfitte: "+interpreteStatistiche.getStatistica().getSconfitte());
		labelSconfitte.setFont(font);
		JPanel sconfitte = new JPanel();
		sconfitte.setBackground(new Color(153,203,255));
		sconfitte.setLayout(new FlowLayout());
		sconfitte.add(labelSconfitte);
		
		setLayout(new GridLayout(3, 1));
		add(vittorie);
		add(pareggi);
		add(sconfitte);
		
		return this;
	}
}
