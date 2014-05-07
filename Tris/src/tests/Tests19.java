/**
 * Questo test verifica le classi {@link InterpretePacchettoDefault}, {@link PannelloGiocoOnline}
 * Si vuole verificare una piccola simulazione del gioco online, sfruttando la classe Timer
 */
package tests;

import interfacciaGrafica.PannelloGiocoOnline;

import javax.swing.JFrame;

import rete.InterpretePacchettoDefault;
import tris.TabellaTris;

public class Tests19 {
	public static void main(String[] args) {
		TabellaTris tabellaTris = new TabellaTris();
		tabellaTris.creaTabella();
		InterpretePacchettoDefault pacchettoDefault = new InterpretePacchettoDefault();
		rete.Timer timer = new rete.Timer(tabellaTris,pacchettoDefault);
		//timer.timerMossa();
		String scelta = "croce";
		PannelloGiocoOnline giocoOnline = new PannelloGiocoOnline(tabellaTris, scelta);
		JFrame frame = new  JFrame("Tic Tac Toe");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400, 400);
		frame.getContentPane().add(giocoOnline.creaPannello());
		frame.setVisible(true);
	}
}
