package grafica;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.swing.JButton;
import javax.swing.JPanel;

public class PannelloGiocoOnline extends JPanel implements PannelloTris {
	
	private ArrayList<JButton> griglia = new ArrayList<>();
	private Icona iconaMia = new Croce();
	private Icona iconaAvversario = new Cerchio();
	private ControllerTris controllerTris;
	private static int numeroCaselle = 9;
	private String mioSimbolo =  "G1";
	private String simboloAvversario = "G2";
	private String messaggio = "Mossa	"+mioSimbolo+"	";
	
	public PannelloGiocoOnline() {
		setupInizialeGriglia();
		setLayout(new GridLayout(3, 3));
		setupPanel();
		setupAction();
	}
	
	public PannelloGiocoOnline(ControllerTris controllerTris) {
		super();
		this.controllerTris = controllerTris;
		setupInizialeGriglia();
		setLayout(new GridLayout(3, 3));
		setupPanel();
		setupAction();
	}
	
	public void disegnaTris(String partita){
		// inCorso G1 X G2 G1 G1 G2 G2 X X;
		StringTokenizer stringTokenizer = new StringTokenizer(partita);
		ArrayList<Integer> caselleMie = new ArrayList<>();
		ArrayList<Integer> caselleAvversario = new ArrayList<>();
		String statoPartita = stringTokenizer.nextToken();
		int index = 0;
		while(stringTokenizer.hasMoreTokens()){
			String simbolo = stringTokenizer.nextToken();
			if(simbolo.equalsIgnoreCase(mioSimbolo)){
				caselleMie.add(index);
			}
			if(simbolo.equalsIgnoreCase(simboloAvversario)){
				caselleAvversario.add(index);
			}
			index++;
		}
		for (int i = 0; i < caselleMie.size(); i++) {
			griglia.get(caselleMie.get(i)).setIcon(iconaMia.disegna());
		}
		for (int i = 0; i < caselleAvversario.size(); i++) {
			griglia.get(caselleAvversario.get(i)).setIcon(iconaAvversario.disegna());
		}
		setupPanel();
	}
	
	public void setupPanel(){
		for (int i = 0; i < griglia.size(); i++) {
				add(griglia.get(i));
		}
	}
	
	public void setupInizialeGriglia(){
		for (int i = 0; i < 9; i++) {
			
			final JButton button = new JButton();
			button.setBackground(Color.WHITE);
			griglia.add(button);
		}
	}
	
	
	public void setupAction(){
		for (int i = 0; i <numeroCaselle; i++) {
			final int index = i;
					griglia.get(i).addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							if(griglia.get(index).getIcon()==null){
							griglia.get(index).setIcon(iconaMia.disegna());
							//controllerTris.getClient().send(messaggio+index);
							}	
						}
				});
		}
	}
	@Override
	public JPanel creaPannello() {
		return this;
	}
}
