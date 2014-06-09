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
/**
 * Crea il pannello dove si può scegliere i nomi dei giocatore con la quale si gioca e avviare una partita
 */
@SuppressWarnings("serial")
public class PlayersPanel extends JPanel{

	private String G1;
	private String G2;
	private String[] playersName = {"Giacomo","Dario","Marco","Santo","Kokou","Paulin","Andrea" };
	private MainPanel mainPanel;
	private final JComboBox<String> comboBox1 = new JComboBox<String>(playersName);
	private final JComboBox<String> comboBox2 = new JComboBox<String>(playersName);
	private IMatchManager matchManager;
	private ITurnManager turnManager;

	public PlayersPanel(final MainPanel mainPanel, IMatchManager matchManager, ITurnManager turnManager) {
		super();
		this.mainPanel = mainPanel;
		this.matchManager = matchManager;
		this.turnManager = turnManager;
		setGraphic();
	}
	
	private void setGraphic() {
		setLayout(null);

		setBackground(new Color(153,203,255));

		Font font = new Font("Verdana", Font.BOLD, 16);

		JLabel challengeLabel = new JLabel("Selezionare Il Proprio Nickname");
		challengeLabel.setBounds(166, 32, 280, 24);
		challengeLabel.setFont(font);
		add(challengeLabel);

		comboBox1.setBounds(267, 127, 93, 24);
		add(comboBox1);

		comboBox2.setBounds(267, 298, 93, 24);
		add(comboBox2);

		JLabel opponentLabel = new JLabel("Selezionare Il Giocatore Da Sfidare");
		opponentLabel.setFont(font);
		opponentLabel.setBounds(148, 218, 314, 24);
		add(opponentLabel);

		JButton startButton = new JButton("Inizia");
		pressStartButton(font, startButton);
		add(startButton);

		JButton connectButton = new JButton("Collegati");
		pressConnectButton(font, connectButton);
		add(connectButton);
	}
	
	private void pressStartButton(Font font, JButton startButton) {
		startButton.setBounds(76, 368, 93, 24);
		startButton.setBackground(Color.white);
		startButton.setFont(font);
		startButton.setPreferredSize(new Dimension(130, 50));
		startButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				selectPlayers();
				matchManager.createNewMatch(G1, G2, mainPanel.getGame());
				matchManager.requestUpdate();
				turnManager.setMyTurn(true);
				setMatch("G1");
			}

		});
	}

	private void pressConnectButton(Font font, JButton connectButton) {
		connectButton.setBounds(424, 368, 109, 24);
		connectButton.setBackground(Color.white);
		connectButton.setFont(font);
		connectButton.setPreferredSize(new Dimension(130, 50));
		connectButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				selectPlayers();
				turnManager.setConnected(true);
				matchManager.connectToMatch(G1, G2, mainPanel.getGame());
				matchManager.requestUpdate();
				setMatch("G2");
			}
		});
	}

	private void setMatch(String symbol) {
		if(((String)comboBox1.getSelectedItem()).contentEquals(((String) comboBox2.getSelectedItem()))){
			JOptionPane.showMessageDialog(null, "Selezionare Nomi Diversi !!");
		}
		else {
			selectPlayers();
			mainPanel.setGamePanel(symbol);
		}
	}

	//Si occupa di assegnare dal comboBox ad un stringa il nome del giocatore
	private void selectPlayers() {
		G1 = (String) comboBox1.getSelectedItem();
		G2 = (String) comboBox2.getSelectedItem();
	}
	
	
}
