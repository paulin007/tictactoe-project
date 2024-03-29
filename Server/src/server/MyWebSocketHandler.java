package server;

import gioco.Partita;

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

/**
 * Gestore WebSocket per connessioni tramite JavaScript </br>
 * 
 */
@WebSocket(maxTextMessageSize = 64 * 1024)
public class MyWebSocketHandler {

	private static ArrayList<Partita> matches;
	private final CountDownLatch closeLatch;
	private Session session;
	private String risultato = "Operazione inesistente";


	public MyWebSocketHandler() {
		this.closeLatch = new CountDownLatch(1);
		ServicesMap.loadServices();
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

		StringTokenizer s = new StringTokenizer(message, "/");

		String operazione = s.nextToken();
		
		if (!(ServicesMap.getMappa().containsKey(operazione.toLowerCase())))

				throw new ServerExceptions("Operazione non esistente",s);

			risultato = ServicesMap.getMappa().get(operazione.toLowerCase()).handleService(s, matches);



		} catch (ServerExceptions e) {
			
		}
		finally{
			
			Future<Void> fut;
			fut = session.getRemote().sendStringByFuture(risultato);
			fut.get(2, TimeUnit.SECONDS);
			
		}
		
	}
	
	public static void setMatches(ArrayList<Partita> partite) {
		MyWebSocketHandler.matches = partite;
	}
	
}