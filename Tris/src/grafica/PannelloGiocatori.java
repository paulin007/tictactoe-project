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

public class PannelloGiocatori extends JPanel implements PannelloTris{

	private static final long serialVersionUID = 0;
	private String G1;
	private String G2;
	private ControllerTris controllerTris;
	
	
	

	public PannelloGiocatori(ControllerTris controllerTris) {
		super();
		this.controllerTris = controllerTris;
	}

	public ControllerTris getControllerTris() {
		return controllerTris;
	}

	public void setControllerTris(ControllerTris controllerTris) {
		this.controllerTris = controllerTris;
	}

	private String[] nomiGiocatori = {"Giacomo","Dario","Marco","Santo","Koukou","Paulin","Andrea" };

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


		JPanel panel3 = new JPanel();
		setPanel(panel3, comboBox1);
		
		
		JPanel panel4 = new JPanel();
		setPanel(panel4, comboBox2);
		
	
		JButton button = new JButton("Conferma");
		button.setBackground(Color.white);
		button.setFont(font);
		button.setPreferredSize(new Dimension(130, 50));
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(((String)comboBox1.getSelectedItem()).contentEquals(((String) comboBox2.getSelectedItem()))){
					JOptionPane.showMessageDialog(null, "Selezionare Nomi Diversi!!");
				}
				else {
					controllerTris.setPannelloGiocoOnline();
					G1=(String) comboBox1.getSelectedItem();
					G2=(String) comboBox2.getSelectedItem();
				}
				System.out.println(G1+"\n"+G2);
			}
		});
		
		JPanel panel5 = new JPanel();
		setPanel(panel5, button);
		
		setLayout(new GridLayout(5,1));
		add(panel1);
		add(panel3);
		add(panel2);
		add(panel4);
		add(panel5);
		
		
		return this;
	}

	private void setPanel(JPanel panel, Component component){
		
		panel.setLayout(new FlowLayout(FlowLayout.CENTER,0,20));
		panel.setBackground(new Color(153,203,255));
		panel.add(component);
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
