package server;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.websocket.server.WebSocketHandler;
import org.eclipse.jetty.websocket.servlet.WebSocketServletFactory;

/**
 * Bridge-Server,
 * 
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
	private static HashMap<String, IServizio> mappaServizi = new HashMap<>();

	public static void main(String[] args) throws Exception {

		caricaHashMap("nuova partita", new ServizioNuovaPartita());
		caricaHashMap("collegati a", new ServizioCollegamento());
		caricaHashMap("mossa", new ServizioInviaMossa());
		caricaHashMap("update", new ServizioAggiornamento());

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

			if (mappaServizi.containsKey(operazione))
				throw new Eccezioni("Operazione non esistente", s);
			output.println(mappaServizi.get(operazione.toLowerCase()).effettuaServizio(s, partite));

		} catch (IOException ioEx) {
			ioEx.printStackTrace();
		} catch (Eccezioni e) {
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

	/**
	 * Carica la mappa dei servizi effettuati da parte del server
	 * 
	 * @param nomeServizio
	 * @param servizio
	 */
	public static void caricaHashMap(String nomeServizio, IServizio servizio) {

		mappaServizi.put(nomeServizio, servizio);
	}

}
