package server;

import java.util.ArrayList;
import java.util.HashMap;
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

/**
 * Basic Echo Client Socket
 */
@WebSocket(maxTextMessageSize = 64 * 1024)
public class MyWebSocketHandler {

//	private static int partitaIndex = 0;
	private static ArrayList<Partita> partite;
	private final CountDownLatch closeLatch;
	private static HashMap<String, IServizio> mappaServizi = new HashMap<>();
	private Session session;
	private String risultato = "Operazione inesistente";


	public MyWebSocketHandler() {
		this.closeLatch = new CountDownLatch(1);
		caricaHashMap("nuova partita".toLowerCase(), new ServizioNuovaPartita());
		caricaHashMap("collegati a".toLowerCase(), new ServizioCollegamento());
		caricaHashMap("mossa".toLowerCase(), new ServizioInviaMossa());
		caricaHashMap("update".toLowerCase(), new ServizioAggiornamento());
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
	
	}

	@OnWebSocketMessage
	public void onMessage(String msg) throws InterruptedException,
			ExecutionException, TimeoutException {

		try {
		String message = msg;
		System.err.println("CLIENT< "+msg);

		// TODO Change StringTokenizer in XML format
		StringTokenizer s = new StringTokenizer(message, "/");

		String operazione = s.nextToken();
		
		if (mappaServizi.containsKey(operazione))

				throw new Eccezioni("Operazione non esistente",s);

			risultato = mappaServizi.get(operazione.toLowerCase()).effettuaServizio(s, partite);



		} catch (Eccezioni e) {
			
		}
		finally{
			
			Future<Void> fut;
			fut = session.getRemote().sendStringByFuture(risultato);
			fut.get(2, TimeUnit.SECONDS);
			
		}
		
	}
	
	@SuppressWarnings("static-access")
	public void setPartite(ArrayList<Partita> partite){
		this.partite = partite;
	}

    public static void caricaHashMap(String nomeServizio, IServizio servizio){
    	
    	mappaServizi.put(nomeServizio, servizio);	
    }
	
}