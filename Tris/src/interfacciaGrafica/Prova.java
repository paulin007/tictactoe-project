package interfacciaGrafica;

import javax.swing.JFrame;

import interfacciaGrafica.rete.Client;

public class Prova {
	public static void main(String[] args) {
		PannelloGiocoOnline giocoOnline = new PannelloGiocoOnline(new Client());
		String partita = "inCorso G1 X G2 G1 G1 G2 G2 X X";
		giocoOnline.disegnaTris(partita);
		JFrame frame = new JFrame("Tris");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400, 400);
		frame.getContentPane().add(giocoOnline);
		frame.setVisible(true);
	}

}
