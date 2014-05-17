package rete;

import java.net.URI;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import org.eclipse.jetty.websocket.client.ClientUpgradeRequest;
import org.eclipse.jetty.websocket.client.WebSocketClient;

import server.MyWebSocketHandler;
import tris.Algoritmo;
 
/**
 * Client da utilizzare per collegarsi al socket.
 * 
 * @author Andrea Gallo
 */
public class Client2 {
 
	String destUri = "ws://localhost:45454";
    WebSocketClient client = new WebSocketClient();
    MyWebSocketHandler socket = new MyWebSocketHandler();

    public Client2(){
    	
    }

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
            client.connect(socket, echoUri, request);
            socket.onMessage(messaggio);
          
            
            
            socket.awaitClose(5, TimeUnit.SECONDS);
        } catch (Throwable t) {
            t.printStackTrace();
        } finally {
            try {
                client.stop();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
		return "1";
		
		//TODO fix returns
	}
}