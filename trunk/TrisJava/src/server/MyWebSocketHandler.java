package server;

import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketClose;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketConnect;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketMessage;
import org.eclipse.jetty.websocket.api.annotations.WebSocket;

import tris.Algoritmo;

/**
 * Basic Echo Client Socket
 */
@WebSocket(maxTextMessageSize = 64 * 1024)
public class MyWebSocketHandler {

	private static int partitaIndex = 0;
	private static ArrayList<Partita> partite = new ArrayList<Partita>();
	private final CountDownLatch closeLatch;

	private Session session;

	public MyWebSocketHandler() {
		this.closeLatch = new CountDownLatch(1);
	}

	public boolean awaitClose(int duration, TimeUnit unit)
			throws InterruptedException {
		return this.closeLatch.await(duration, unit);
	}

	@OnWebSocketClose
	public void onClose(int statusCode, String reason) {
		System.out.printf("Connection closed: %d - %s%n", statusCode, reason);
		this.session = null;
		this.closeLatch.countDown();
	}

	@OnWebSocketConnect
	public void onConnect(Session session) {
		this.session = session;
		System.out.println("OUT: "+session.getUpgradeRequest().getHeaders().keySet());
		System.out.println("OUT2: "+session.getUpgradeRequest().getHeader("Origin"));
	
	}

	@OnWebSocketMessage
	public void onMessage(String msg) throws InterruptedException,
			ExecutionException, TimeoutException {

		System.err.println("<------------ " + msg + " -------------->");
		String message = msg;

		// TODO Change StringTokenizer in XML format
		StringTokenizer s = new StringTokenizer(message, "/");

		String operazione = s.nextToken();
		String risultato = "Operazione inesistente";

		if (operazione.equalsIgnoreCase("nuova partita")) {
			risultato = nuovaPartita(s);
		} else if (operazione.equalsIgnoreCase("collegati a")) {
			risultato = collegamento(s);
		} else if (operazione.equalsIgnoreCase("mossa")) {
			risultato = inviamossa(s);
		} else if (operazione.equalsIgnoreCase("update")) {
			risultato = inviaAggiornamento(s);
		}

		Future<Void> fut;
		fut = session.getRemote().sendStringByFuture(risultato);
		fut.get(2, TimeUnit.SECONDS);

	}

	private static String inviamossa(StringTokenizer s) {
		int idPartita = Integer.parseInt(s.nextToken());
		String giocatore = s.nextToken();
		String mossa = s.nextToken();
		for (int i = 0; i < partite.size(); i++) {
			if (partite.get(i).getId() == idPartita) {
				Algoritmo algoritmo = new Algoritmo();

				if (!(partite.get(i).getUltimoGiocatore()
						.equalsIgnoreCase(giocatore)))
					algoritmo.execute(partite.get(i), giocatore, mossa);

				partite.get(i).setUltimoGiocatore(giocatore);
				return partite.get(i).toString();

			}

		}
		return "-1";
	}

	private static String collegamento(StringTokenizer s) {
		String giocatore1 = s.nextToken();
		System.out.println(giocatore1);
		String giocatore2 = s.nextToken();
		System.out.println(giocatore2);
		for (int i = 0; i < partite.size(); i++) {
			System.out.println("GIOCATORE1: "+partite.get(i).getGiocatore1());
			System.out.println("GIOCATORE2: "+partite.get(i).getGiocatore2());
			if (partite.get(i).getGiocatore1().equalsIgnoreCase(giocatore1)
					&& partite.get(i).getGiocatore2()
							.equalsIgnoreCase(giocatore2)
					&& partite.get(i).getRisultato()
							.equalsIgnoreCase("inCorso")) {

				System.out.println("Restituito a " + giocatore2
						+ " l'id della partita con " + giocatore1 + ": "
						+ partite.get(i).getId());
				return partite.get(i).toString();
			}
		}
		System.out.println("Tentata connessione a partita non esistente.");
		return "PARTITANONESISTENTE";
	}

	private static String nuovaPartita(StringTokenizer s) {
		String giocatore1 = s.nextToken();
		String giocatore2 = s.nextToken();

		Partita partitaCreata = new Partita(partitaIndex, giocatore1,
				giocatore2);
		partite.add(partitaCreata);

		System.out.println("Iniziato una nuova partita: id=" + partitaIndex
				+ " \n" + "Giocatore1= " + giocatore1 + "\n" + "Giocatore2= "
				+ giocatore2);

		partitaIndex++;
		return (partite.get(partitaIndex - 1)).toString();

	}

	private static String inviaAggiornamento(StringTokenizer s) {
		int idPartita = Integer.parseInt(s.nextToken());
		for (int i = 0; i < partite.size(); i++) {
			if (partite.get(i).getId() == idPartita) {
				return (partite.get(i).toString());
			}
		}
		return "-1";
	}

}