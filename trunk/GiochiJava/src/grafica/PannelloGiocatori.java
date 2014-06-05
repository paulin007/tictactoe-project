package grafica;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import managers.IMatchManager;
import managers.ITurnManager;


@SuppressWarnings("serial")
public class PannelloGiocatori extends JPanel{

	private String G1;
	private String G2;
	private String[] nomiGiocatori = {"Giacomo","Dario","Marco","Santo","Kokou","Paulin","Andrea" };
	private PannelloPrincipale principale;
	private final JComboBox<String> comboBox1 = new JComboBox<String>(nomiGiocatori);
	private final JComboBox<String> comboBox2 = new JComboBox<String>(nomiGiocatori);
	private IMatchManager matchManager;
	private ITurnManager turnManager;

	public PannelloGiocatori(final PannelloPrincipale principale, IMatchManager matchManager, ITurnManager turnManager) {
		super();
		this.principale = principale;
		this.matchManager = matchManager;
		this.turnManager = turnManager;
		impostaGrafica();
	}
	
	private void impostaGrafica() {
		setLayout(null);

		setBackground(new Color(153,203,255));

		Font font = new Font("Verdana", Font.BOLD, 16);

		JLabel labelSfidante = new JLabel("Selezionare Il Proprio Nickname");
		labelSfidante.setBounds(166, 32, 280, 24);
		labelSfidante.setFont(font);
		add(labelSfidante);

		comboBox1.setBounds(267, 127, 93, 24);
		add(comboBox1);

		comboBox2.setBounds(267, 298, 93, 24);
		add(comboBox2);

		JLabel labelAvversario = new JLabel("Selezionare Il Giocatore Da Sfidare");
		labelAvversario.setFont(font);
		labelAvversario.setBounds(148, 218, 314, 24);
		add(labelAvversario);

		JButton nuovaPartita = new JButton("Inizia");
		pressStartButton(font, nuovaPartita);
		add(nuovaPartita);

		JButton riprendiPartita = new JButton("Collegati");
		pressConnectButton(font, riprendiPartita);
		add(riprendiPartita);
	}
	
	private void pressStartButton(Font font, JButton nuovaPartita) {
		nuovaPartita.setBounds(76, 368, 93, 24);
		nuovaPartita.setBackground(Color.white);
		nuovaPartita.setFont(font);
		nuovaPartita.setPreferredSize(new Dimension(130, 50));
		nuovaPartita.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				selezioneGiocatori();
				matchManager.createNewMatch(G1, G2);
				matchManager.requestUpdate();
				turnManager.setMyTurn(true);
				impostaPartitaOnline("G1");
			}

		});
	}

	private void pressConnectButton(Font font, JButton riprendiPartita) {
		riprendiPartita.setBounds(424, 368, 109, 24);
		riprendiPartita.setBackground(Color.white);
		riprendiPartita.setFont(font);
		riprendiPartita.setPreferredSize(new Dimension(130, 50));
		riprendiPartita.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				selezioneGiocatori();
				turnManager.setConnected(true);
				matchManager.connectToMatch(G1, G2);
				matchManager.requestUpdate();
				impostaPartitaOnline("G2");
			}
		});
	}

	private void impostaPartitaOnline(String mioSimbolo) {
		if(((String)comboBox1.getSelectedItem()).contentEquals(((String) comboBox2.getSelectedItem()))){
			JOptionPane.showMessageDialog(null, "Selezionare Nomi Diversi !!");
		}
		else {
			selezioneGiocatori();
			principale.setPannelloGioco(mioSimbolo);
		}
	}

	//Si occupa di assegnare dal comboBox ad un stringa il nome del giocatore
	private void selezioneGiocatori() {
		G1 = (String) comboBox1.getSelectedItem();
		G2 = (String) comboBox2.getSelectedItem();
	}
	
}
