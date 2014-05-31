package trisGui;

import forza4Gui.DisegnaPannello;
import grafica.PannelloGioco;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JPanel;

import rete.TimerPannello;

public class PannelloGiocoTris extends JPanel implements Observer,PannelloGioco {
	
	private ArrayList<JButton> griglia = new ArrayList<>();
	private SituazioneTurno turno;
	private DisegnaPannello disegnaPannello = new DisegnaPannello();
	private TimerPannello timerPannello = new TimerPannello();
	
	
	@Override
	public void setTurno(SituazioneTurno turno) {
		this.turno = turno;
	}
	@Override
	public void update(Observable o, Object arg) {
		disegnaPannello.disegnaSimboli(this,griglia,turno);
	}
	@Override
	public JPanel creaPannello() {
		setupInziale();
		return this;
	}
	public void setupInziale() {
		removeAll();
		setLayout(null);
		timerPannello.addObserver(this);
		setBackground(new Color(153,203,255));
		disegnaPannello.pannelloGiocatori(this, turno.getMioSimbolo(), turno.getSimboloAvversario());
		disegnaPannello.disegnaCaselleIniziali(griglia,9, this);
		disegnaPannello.setupAction(griglia, turno.getIDpartita(), turno.getMioSimbolo(), turno.getIcone()[0]);
	}
}
