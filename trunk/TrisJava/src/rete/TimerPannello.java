package rete;

import java.util.Observable;
import java.util.Timer;
import java.util.TimerTask;

public class TimerPannello extends Observable {
	
	private static long delayStart = 3000;
	private static long delay = 2000;
	
	public TimerPannello() {
		update();
	}
	
	public void update(){
		TimerTask task = new TimerTask() {
			@Override
			public void run() {
				setChanged();
				notifyObservers();
			}
		};
		Timer timer = new Timer();
		timer.schedule(task, delayStart, delay);
	}
}
