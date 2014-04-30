package utils.componenti;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;

import javax.swing.JPanel;

public class JButtonPanel extends JPanel{

	private CheckBoxPanel panel;
	private static final long serialVersionUID = 0;
	private ArrayList<JButton> griglia = new ArrayList<>();
	private Cerchio cerchio = new Cerchio();
	private Croce croce = new Croce();

	public JButtonPanel(CheckBoxPanel panel) {
		this.panel=panel;
		
		
		setLayout(new GridLayout(3, 3));
		setupInizialeGriglia();
		setupActionListenerGriglia();
		setupPanel();
	}
	// intelligenza artificiale stupida
	
	public void ia(int posizione,String scelta){
		
		int x = (int)(Math.random()*9);
			
		if(x!= posizione && scelta=="Cerchio")griglia.get(x).setIcon(croce.disegnaCroce());
		if(x!= posizione && scelta=="Croce")griglia.get(x).setIcon(cerchio.disegnaCerchio());

				
	}
	
	public void setupInizialeGriglia(){
		
		
		for (int i = 0; i < 9; i++) {
			
			final int j = i;
			final JButton button = new JButton();
			button.setBackground(Color.WHITE);
	
			griglia.add(button);
		}
	}
	public void setupActionListenerGriglia(){
		
		
		for (int i = 0; i < griglia.size(); i++) {
		
		final int j = i;
		griglia.get(i).addActionListener(new ActionListener() {
			
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(panel.scelta()=="Cerchio")griglia.get(j).setIcon(cerchio.disegnaCerchio());
				if(panel.scelta()=="Croce")griglia.get(j).setIcon(croce.disegnaCroce());
				
				ia(j,panel.scelta());
				
			}
		});
		}
	}
	
	
	public void setupPanel(){
		
		for (int i = 0; i < griglia.size(); i++) {
				add(griglia.get(i));
		}
	}
		
	public ArrayList<JButton> getGriglia() {
		return griglia;
	}

	public void setGriglia(ArrayList<JButton> griglia) {
		this.griglia = griglia;
	}
}
