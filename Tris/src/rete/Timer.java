package rete;

import java.util.Observable;
import java.util.Observer;
import java.util.TimerTask;

import tris.Simbolo;
import tris.TabellaTris;

public class Timer implements Observer {
	
	private TabellaTris tabellaTris;
	private InterpretePacchettoRete pacchettoRete;
	int index;
	int delay = 5000;
	
	public Timer(TabellaTris tabellaTris,InterpretePacchettoDefault pacchettoDefault) {
		this.tabellaTris=tabellaTris;;
		this.pacchettoRete = pacchettoDefault;
		for (int i = 0; i < tabellaTris.getCaselle().size(); i++) {
			tabellaTris.getCaselle().get(i).addObserver(this);
		}
	}
	
	public void timerMossa(){
		java.util.Timer timer = new java.util.Timer();
		TimerTask task = new TimerTask() {
			@Override
			public void run() {
				index++;
				String pacchetto = "Mossa	1	";
				pacchetto+=index;
				pacchettoRete.interpretaPacchetto(pacchetto);
				tabellaTris.getCaselle().get(pacchettoRete.getUltimaMossaPacchetto()).setSimbolo(Simbolo.simboloG2);
			}
		};
		timer.schedule(task, delay);
	}
	
	@Override
	public void update(Observable o, Object arg) {
		timerMossa();
	}
}
