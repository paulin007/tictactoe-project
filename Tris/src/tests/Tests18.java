/**
 * Questo test vuole verificare il corretto funzionamento di disegnare un {@link PannelloGiocoOnline},
 * data un {@link TabellaTris}
 */
package tests;

import interfacciaGrafica.PannelloGiocoOnline;

import javax.swing.JFrame;

import rete.InterpretePacchettoDefault;
import tris.TabellaTris;

public class Tests18 {
	public static void main(String[] args) {
		String pacchetto1 = "Mosse  1 2 3 4";
		InterpretePacchettoDefault pacchettoDefault = new InterpretePacchettoDefault();
		TabellaTris tabellaTris = new TabellaTris();
		tabellaTris.creaTabella();
		String scelta = "croce";
		pacchettoDefault.interpretaPacchetto(pacchetto1);
		for (int i = 0; i < pacchettoDefault.getMossePacchetto().size(); i++) {
			tabellaTris.getCaselle().get(pacchettoDefault.getMossePacchetto().get(i)).setSimbolo("c");
		}
		PannelloGiocoOnline giocoOnline = new PannelloGiocoOnline(tabellaTris, scelta);
		
		for (int i = 0; i < tabellaTris.getCaselle().size() ; i++) {
			System.out.println(tabellaTris.getCaselle().get(i));
		}
		JFrame frame = new  JFrame("Tic Tac Toe");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400, 400);
		frame.getContentPane().add(giocoOnline.creaPannello());
		frame.setVisible(true);
	}

}
