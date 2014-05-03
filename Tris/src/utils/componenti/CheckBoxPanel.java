package utils.componenti;

import java.awt.Checkbox;
import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.TitledBorder;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

public class CheckBoxPanel extends JPanel{
	
	private static final long serialVersionUID = 0;
	private Checkbox checkbox1 = new Checkbox("Cerchio");
	private Checkbox checkbox2 = new Checkbox("Croce");
	
	public CheckBoxPanel() {
		
		try {
			UIManager.setLookAndFeel(new NimbusLookAndFeel());
		} catch (UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		TitledBorder border = new TitledBorder("Seleziona la figura desiderata");
		border.setTitleJustification(TitledBorder.CENTER);
		setLayout(new GridLayout(2, 1));
		setBorder(border);
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		JPanel panel3 = new JPanel();
		
		
		panel2.add(checkbox1);
		panel3.add(checkbox2);
		
		add(panel1);
		add(panel2);
		add(panel3);
		
		checkbox1.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent arg0) {
				
				checkbox2.setState(false);
//				checkbox2.setEnabled(false);
			}
		});
		
		checkbox2.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent arg0) {
				checkbox1.setState(false);
//				checkbox1.setEnabled(false);
				
			}
		});
		
		setLayout(new GridLayout(3,1));
	}
	
	public String scelta(){
		
		String scelta=null;
	
		if(checkbox1.getState()==true )scelta="Cerchio";
		if(checkbox2.getState()==true )scelta="Croce";
		
		return scelta;
	}
}