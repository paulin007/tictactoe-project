package paulin.tchonin.trisandroid1;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.TimerTask;
import rete.InterpreteMessaggio;
import android.os.AsyncTask;



/**
 * Questa classe crea un socket che comunica col server 
 * 
 * @author Paulin
 *
 */

public class ClientAndroid extends AsyncTask<Void, Void, String> {

	private String message;
	private String response = "";
	private String service;
	private static String matchStatus;
	private String IDmatch;
	private static String lastPlayer;
	private static ArrayList<String> caselle;
	private UIManager manager = new UIManager();
	private InetAddress host;
	private static final int PORT = 45444;

	
	public ClientAndroid() {
		this.execute();
	}
	
	@Override
	protected String doInBackground(Void... params) {
		Socket link = null; 

		try {
			link = new Socket("192.168.0.104", PORT); 
			Scanner input = new Scanner(link.getInputStream());
			PrintWriter output = new PrintWriter(link.getOutputStream(), true);	
			output.println(message);
			response = input.nextLine();
			input.close();
		} catch (UnknownHostException exception) {
			exception.printStackTrace();
		} catch (IOException ioEx) {
			ioEx.printStackTrace();
			//ActivityOnline.getInfoTextView().setText(R.string.server);	
		}

		finally {
			if(link !=null)
			try {
				link.close();
			} catch (IOException ioEx) {
				
			}
		}
		return "true";
	}

	@Override
	protected void onPostExecute(String result) {

		try{
		InterpreteMessaggio interprete = new InterpreteMessaggio();
		interprete.interpreta(response);
		setIDmatch(interprete.getIDpartita());
		matchStatus = interprete.getStatoPartita();
		lastPlayer = interprete.getUltimoGiocatore();
		caselle = interprete.getCaselle();
		}catch(NoSuchElementException ioEx){
			ioEx.printStackTrace();
			
		}

		if (service.equals("mossa")) {
			new ClientAndroid().serviceRequest("update	" + IDmatch, "update");
		} else if (service.equals("update")) {
			startTimer();
			UIManager.setLaunchTimer(false);
			manager.updateTable();
		}
	}

	/**
	 * lancia un timer per richiedere aggiornamenti al server 
	 */
	private void startTimer() {
		// il controllo serve a fare partire il timer solo una volta.
		if (UIManager.isLaunchTimer()) {
			TimerTask timerTask = new TimerTask() {

				@Override
				public void run() {
					new ClientAndroid().serviceRequest("update	" + IDmatch, "update");
				}
			};
			manager.getTimer().schedule(timerTask, 3000, 2000);
		}
	}

	/**
	 * imposta il messaggio da inviare al server in base al servizio richiesto 
	 * @param message
	 * @param service
	 */
	public void serviceRequest(String message,String service) {
		setMessage(message);
		setService(service);
	}
	
	public static String getMatchStatus() {
		return matchStatus;
	}
	
	public String getIDmatch() {
		return IDmatch;
	}
	
	public void setIDmatch(String iDmatch) {
		IDmatch = iDmatch;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	public void setService(String service) {
		this.service = service;
	}
	
	public static ArrayList<String> getCaselle() {
		return caselle;
	}
	
    public static String getLastPlayer() {
		return lastPlayer;
	}

}
