package server;

import gioco.GiochiPresenti;
import gioco.Partita;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.websocket.server.WebSocketHandler;
import org.eclipse.jetty.websocket.servlet.WebSocketServletFactory;

/**
 * Server di base. Apre un {@Socket} su cui elabora le richieste di
 * Java e Android ed un {@WebSocket} su cui elabora le richieste di
 * Javascript.
 * 
 * @author Andrea Gallo
 *
 */
public class ServerWeb {

	private static ServerSocket servSock;
	private static final int PORT = 45444;
	private static Scanner input;
	private static ArrayList<Partita> partite = new ArrayList<Partita>();
	private static MyWebSocketHandler handler = new MyWebSocketHandler();

	public static void main(String[] args) throws Exception {

		MappaServizi.caricaServizi();		//Carica i possibili servizi che il server puo effettuare
		GiochiPresenti.caricaAlgoritmi();	//Carica i possibili algoritmi che il server può eseguire
		
		Server server = new Server(45454);
		WebSocketHandler wsHandler = new WebSocketHandler() {
			@Override
			public void configure(WebSocketServletFactory factory) {
				factory.register(MyWebSocketHandler.class);
			}
		};

		server.setHandler(wsHandler);
		handler.setPartite(partite);
		server.start();

		System.out.println("Apertura porta: " + PORT + "\n");
		try {
			servSock = new ServerSocket(PORT);
		} catch (IOException ioEx) {
			System.out
					.println("Impossibile aprire la porta. Controlla il firewall!");
			System.exit(1);
		}
		do {
			gestoreClient();
		} while (true);

	}

	private static void gestoreClient() {

		Socket link = null;
		try {
			link = servSock.accept();

			input = new Scanner(link.getInputStream());
			PrintWriter output = new PrintWriter(link.getOutputStream(), true);

			String message = input.nextLine();

			System.err.println("CLIENT< " + message);

			// TODO Change StringTokenizer in XML format
			StringTokenizer s = new StringTokenizer(message, "/	");

			String operazione = s.nextToken();

			if (!(MappaServizi.getMappa().containsKey(operazione.toLowerCase())))
				throw new EccezioniServer("Operazione non esistente", s);
			output.println(MappaServizi.getMappa().get(operazione.toLowerCase()).effettuaServizio(s, partite));

		} catch (IOException ioEx) {
			ioEx.printStackTrace();
		} catch (EccezioniServer e) {
			e.printStackTrace();
		}

		finally {
			try {
				link.close();
			} catch (IOException ioEx) {
				System.out.println("Impossibile disconnettersi!");
				System.exit(1);
			}
		}

	}

}
