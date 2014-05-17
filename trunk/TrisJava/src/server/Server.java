package server;

import java.net.URI;
import java.util.concurrent.TimeUnit;

import org.eclipse.jetty.websocket.client.ClientUpgradeRequest;
import org.eclipse.jetty.websocket.client.WebSocketClient;

import server.MyWebSocketHandler;
 
/**
 * Client da utilizzare per collegarsi al socket.
 * 
 * @author Andrea Gallo
 */
public class Server {
 
	static WebSocketClient client; 
	static MyWebSocketHandler socket;
	
	public Server(){	
		String destUri = "ws://localhost:45454";
	    WebSocketClient client = new WebSocketClient();
	    MyWebSocketHandler socket = new MyWebSocketHandler();
    	
    }

    	public static void main(String[] args) {
	

		try {
            client.start();

        } catch (Throwable t) {
            t.printStackTrace();
        } finally {
            try {
                client.stop();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
		
		//TODO fix returns
	}
}