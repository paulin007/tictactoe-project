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

import rete.Client;
import rete.InterpreteMessaggio;

public class PannelloGiocatori extends JPanel implements PannelloGioco{

	private static final long serialVersionUID = 0;
	private String G1;
	private String G2;
	private String[] simboli = {"Cerchio","Croce"};
	private String[] nomiGiocatori = {"Giacomo","Dario","Marco","Santo","Kokou","Paulin","Andrea" };
	private ControllerGioco controllerTris;
	private String iconaScelta;
	private final JComboBox<String> comboBox1 = new JComboBox<String>(nomiGiocatori);
	private final JComboBox<String> comboBox2 = new JComboBox<String>(nomiGiocatori);
	private final JComboBox<String> comboBox3 = new JComboBox<String>(simboli);
	
	private InterpreteMessaggio interpreteMessaggio = new InterpreteMessaggio();
	
	public PannelloGiocatori(final ControllerGioco controllerTris) {
		super();
		this.controllerTris = controllerTris;
		
		setLayout(null);
	}
	
	
	@Override
	public JPanel creaPannello() {
	
		setLayout(null);
		
		setBackground(new Color(153,203,255));
		
		Font font = new Font("Verdana", Font.BOLD, 16);
		
		JLabel labelSfidante = new JLabel("Selezionare Il Proprio Nickname");
		labelSfidante.setBounds(166, 32, 280, 24);
		labelSfidante.setFont(font);
		add(labelSfidante);
		
		
		comboBox1.setBounds(76, 127, 93, 24);
		add(comboBox1);
		
		comboBox2.setBounds(267, 298, 93, 24);
		add(comboBox2);
		
		comboBox3.setBounds(424, 127, 109, 24);
		add(comboBox3);
		
		JLabel labelAvversario = new JLabel("Selezionare Il Giocatore Da Sfidare");
		labelAvversario.setFont(font);
		labelAvversario.setBounds(148, 218, 314, 24);
		add(labelAvversario);
		
		JButton nuovaPartita = new JButton("Inizia");
		nuovaPartita.setBounds(76, 368, 93, 24);
		nuovaPartita.setBackground(Color.white);
		nuovaPartita.setFont(font);
		nuovaPartita.setPreferredSize(new Dimension(130, 50));
		nuovaPartita.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				selezioneGiocatori();
				interpreteMessaggio.interpreta(Client.send("nuova partita	"+G1+"	"+G2+"	"+controllerTris.getNomeGioco()));
				impostaPartitaOnline(Simbolo.simboloG1);
			}

		});
		add(nuovaPartita);
		
		JButton riprendiPartita = new JButton("Riprendi");
		riprendiPartita.setBounds(424, 368, 109, 24);
		riprendiPartita.setBackground(Color.white);
		riprendiPartita.setFont(font);
		riprendiPartita.setPreferredSize(new Dimension(130, 50));
		riprendiPartita.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				selezioneGiocatori();
				interpreteMessaggio.interpreta(Client.send("collegati a	"+G2+"	"+G1));
				impostaPartitaOnline(Simbolo.simboloG2);
			}
		});
		add(riprendiPartita);
	
	
		return this;
	}
	private void impostaPartitaOnline(String simbolo) {
		if(((String)comboBox1.getSelectedItem()).contentEquals(((String) comboBox2.getSelectedItem()))){
			JOptionPane.showMessageDialog(null, "Selezionare Nomi Diversi !!");
		}
		else {
			selezioneGiocatori();
			setIconaScelta(comboBox3.getSelectedItem().toString());
			controllerTris.setPannelloGiocoOnline(simbolo, iconaScelta,interpreteMessaggio.getIDpartita());
			
		}
	}
	private void selezioneGiocatori() {
		G1 = (String) comboBox1.getSelectedItem();
		G2 = (String) comboBox2.getSelectedItem();
	}
	public void setIconaScelta(String iconaScelta) {
		this.iconaScelta = iconaScelta;
	}
}
