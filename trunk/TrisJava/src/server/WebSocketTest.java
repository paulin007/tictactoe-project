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

public class WebSocketTest {
	
	private static ServerSocket servSock;
	private static final int PORT = 45444;
	private static Scanner input;
//	private static int partitaIndex = 0;
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
			System.out.println("Impossibile aprire la porta. Controlla il firewall!");
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

			System.out.println("Connessione ricevuta.");
			
			input = new Scanner(link.getInputStream());
			PrintWriter output = new PrintWriter(link.getOutputStream(), true);

			String message = input.nextLine();

			System.out.println(message);	
			
			// TODO Change StringTokenizer in XML format
			StringTokenizer s = new StringTokenizer(message, "/	");

			String operazione = s.nextToken();
//			if (operazione.equalsIgnoreCase("nuova partita")) {
//				nuovaPartita(output, s);
//			} else if (operazione.equalsIgnoreCase("collegati a")) {
//				collegamento(output, s);
//			} else if (operazione.equalsIgnoreCase("mossa")) {
//				inviamossa(output, s);
//			} else if(operazione.equalsIgnoreCase("update")){
//				inviaAggiornamento(output,s);
//			}
			
			if(mappaServizi.containsKey(operazione.toLowerCase())){
				output.println(mappaServizi.get(operazione.toLowerCase()).effettuaServizio(s, partite));

			}
			else
				output.println("Operazione Sconosciuta");

			System.out.println("Messaggio ricevuto");
		} catch (IOException ioEx) {
			ioEx.printStackTrace();
		}

		finally {
			try {
				System.out.println("\n* Chiusura in corso... *");
				link.close(); 
			} catch (IOException ioEx) {
				System.out.println("Impossibile disconnettersi!");
				System.exit(1);
			}
		}
		
	}
    
    public static void caricaHashMap(String nomeServizio, IServizio servizio){
    	
    	mappaServizi.put(nomeServizio, servizio);	
    }
    
}
