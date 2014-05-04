/**
 * Questa classe ha la responsbilità di gestire il pannello di decisione del simbolo che usa 
 * l'utente
 * @author Giacomo
 */
package newGui;

import java.awt.BorderLayout;
import java.awt.Checkbox;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import newGui.PannelloGioco;
import newGui.PannelloTris;
import newGui.ProxyPannelloTris;
import tris.TabellaTris;

public class PannelloCheckBox extends JPanel implements PannelloTris{
	
	private static final long serialVersionUID = 0;
	private JLabel label = new JLabel("Seleziona la figura desiderata");
	private Checkbox checkbox1 = new Checkbox("Cerchio");
	private Checkbox checkbox2 = new Checkbox("Croce");
	private final JButton start = new JButton("Start");
	private ProxyPannelloTris pannelloTris;
	
	
	public PannelloCheckBox(ProxyPannelloTris pannelloTris) {
		this.pannelloTris = pannelloTris;
		
	}
	/**
	 * Questo metodo permette di stabilire la scelta fatta dall'utente, sul simbolo da usare
	 * @return
	 */
	public String scelta(){
		
		String scelta=null;
	
		if(checkbox1.getState()==true )scelta="Cerchio";
		if(checkbox2.getState()==true )scelta="Croce";
		
		return scelta;
	}
	
	@Override
	public JPanel creaPannello() {
		setLayout(new GridLayout(4, 1));
		
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		JPanel panel3 = new JPanel();
		JPanel panel4 = new JPanel();
		
		panel1.add(label);
		panel2.add(checkbox1);
		panel3.add(checkbox2);
		panel4.add(start);
		
		add(panel1);
		add(panel2);
		add(panel3);
		add(panel4);
		
		checkbox1.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent arg0) {
				
				checkbox2.setState(false);
			}
		});
		
		checkbox2.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent arg0) {
				checkbox1.setState(false);	
			}
		});
	
		start.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				setLayout(new BorderLayout());
				pannelloTris.setPannelloTris(new PannelloGioco(new TabellaTris(),scelta()));
				
			}
		});
		
		setLayout(new GridLayout(3,1));
		return this;
	}
}