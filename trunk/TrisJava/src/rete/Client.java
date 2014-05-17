package rete;

import java.net.URI;
import java.util.concurrent.TimeUnit;

import org.eclipse.jetty.websocket.client.ClientUpgradeRequest;
import org.eclipse.jetty.websocket.client.WebSocketClient;

import server.SimpleEchoSocket;
 
/**
 * Client da utilizzare per collegarsi al socket.
 * 
 * @author Andrea Gallo
 */
public class Client {
 
	String destUri = "ws://localhost:45454";
    WebSocketClient client = new WebSocketClient();
    SimpleEchoSocket socket = new SimpleEchoSocket();


    /**
     * 
     * Metodo per inviare un messaggio generico al server.
     * 
     * @param messaggio Un messaggio di tipo String che viene interpretato all'interno dell'operazione ed eseguito dall'{@link Algoritmo}
     * @return Risultato fornito dall'Algoritmo.
     * 
     *
     */
	public String send(String messaggio) {
		try {
            client.start();
            URI echoUri = new URI(destUri);
            ClientUpgradeRequest request = new ClientUpgradeRequest();
           // client.connect(socket, echoUri, request);
            System.out.printf("Connecting to : %s%n", echoUri);
            socket.onMessage(messaggio);
            socket.awaitClose(5, TimeUnit.SECONDS);
        } catch (Throwable t) {
            t.printStackTrace();
        } finally {
            try {
                client.stop();
                return "fatto";
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
		return "nonfatto";
		
		//TODO fix returns
	}
}