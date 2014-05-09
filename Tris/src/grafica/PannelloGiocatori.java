package grafica;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import tris.Simbolo;

public class PannelloGiocatori extends JPanel implements PannelloTris{

	private static final long serialVersionUID = 0;
	private String G1;
	private String G2;
	private String[] simboli = {"Cerchio","Croce"};
	private String[] nomiGiocatori = {"Giacomo","Dario","Marco","Santo","Koukou","Paulin","Andrea" };
	private ControllerTris controllerTris;
	private String iconaScelta;
	
	public PannelloGiocatori(ControllerTris controllerTris) {
		super();
		this.controllerTris = controllerTris;
	}

	@Override
	public JPanel creaPannello() {
		
		Font font = new Font("Verdana", Font.BOLD, 16);
		
		JLabel labelSfidante = new JLabel("Selezionare Il Proprio Nickname");
		labelSfidante.setFont(font);
		
		JLabel labelAvversario = new JLabel("Selezionare Il Giocatore Da Sfidare");
		labelAvversario.setFont(font);
		
		JPanel panel1 = new JPanel();
		setPanel(panel1, labelSfidante);
	
		JPanel panel2 = new JPanel();
		setPanel(panel2, labelAvversario);

		final JComboBox<String> comboBox1 = new JComboBox<>(nomiGiocatori);
		comboBox1.setSelectedIndex(6);
		
		final JComboBox<String> comboBox2 = new JComboBox<>(nomiGiocatori);
        comboBox2.setSelectedIndex(6);

        final JComboBox<String> comboBox3 = new JComboBox<>(simboli);
		comboBox2.setSelectedIndex(1);

		JPanel pannelloGiocatore = new JPanel();
		pannelloGiocatore.setLayout(new GridLayout(1, 2));
		JPanel panelA = new JPanel();
		JPanel panelB = new JPanel();
		
		setPanel(panelA, comboBox1);
		setPanel(panelB, comboBox3);
		pannelloGiocatore.add(panelA);
		pannelloGiocatore.add(panelB);
		
		JPanel panel4 = new JPanel();
		setPanel(panel4, comboBox2);
	
		JButton nuovaPartita = new JButton("Inizia");
		nuovaPartita.setBackground(Color.white);
		nuovaPartita.setFont(font);
		nuovaPartita.setPreferredSize(new Dimension(130, 50));
		nuovaPartita.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(((String)comboBox1.getSelectedItem()).contentEquals(((String) comboBox2.getSelectedItem()))){
					JOptionPane.showMessageDialog(null, "Selezionare Nomi Diversi !!");
				}
				else {
					G1=(String)comboBox1.getSelectedItem();
					G2=(String)comboBox2.getSelectedItem();
					setIconaScelta(comboBox3.getSelectedItem().toString());
					controllerTris.setPannelloGiocoOnline(Simbolo.simboloG1, iconaScelta);
				}
				System.out.println(G1+" "+(String) comboBox3.getSelectedItem()+"\n"+G2);
			}
		});
		
		JButton riprendiPartita = new JButton("Riprendi");
		riprendiPartita.setBackground(Color.white);
		riprendiPartita.setFont(font);
		riprendiPartita.setPreferredSize(new Dimension(130, 50));
		riprendiPartita.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				setIconaScelta(comboBox3.getSelectedItem().toString());
				controllerTris.setPannelloGiocoOnline(Simbolo.simboloG2, iconaScelta);
				System.out.println("Implementare metodi");
			}
		});
		
		JPanel buttons = new JPanel();
		buttons.setLayout(new GridLayout(1,2));

		JPanel jPanel5 = new JPanel();
		setPanel(jPanel5, nuovaPartita);
		JPanel jPanel6 = new JPanel();
		setPanel(jPanel6, riprendiPartita);
		buttons.add(jPanel5);
		buttons.add(jPanel6);
		
		setLayout(new GridLayout(5,1));
		add(panel1);
		add(pannelloGiocatore);
		add(panel2);
		add(panel4);
		add(buttons);
		
		
		return this;
	}

	private void setPanel(JPanel panel, Component component){
		
		panel.setLayout(new FlowLayout(FlowLayout.CENTER,0,15));
		panel.setBackground(new Color(153,203,255));
		panel.add(component);
	}
	
	
	public void setIconaScelta(String iconaScelta) {
		this.iconaScelta = iconaScelta;
	}

	public String getG1() {
		return G1;
	}

	public void setG1(String g1) {
		G1 = g1;
	}

	public String getG2() {
		return G2;
	}

	public void setG2(String g2) {
		G2 = g2;
	}
}
