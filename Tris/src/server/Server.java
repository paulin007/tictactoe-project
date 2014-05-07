package server;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Server {

	private static ServerSocket servSock;
	private static final int PORT = 45454;
	private static Scanner input;
	private static int partitaIndex = 0;
	private static ArrayList<Partita> partite = new ArrayList<Partita>();

	public static void main(String[] args) {
		System.out.println("Opening port...\n");
		try {
			servSock = new ServerSocket(PORT); // Step 1.
		} catch (IOException ioEx) {
			System.out.println("Impossibile aprire la porta. Controlla il firewall!");
			System.exit(1);
		}
		do {
			handleClient();
		} while (true);
	}

	private static void handleClient() {
		Socket link = null;

		try {
			link = servSock.accept();

			input = new Scanner(link.getInputStream());
			PrintWriter output = new PrintWriter(link.getOutputStream(), true);

			String message = input.nextLine();

			//TODO Change StringTokenizer in XML format
			StringTokenizer s = new StringTokenizer(message, "	");

			if (s.countTokens() == 3) {

				String operazione = s.nextToken();
				if (operazione.equalsIgnoreCase("nuova partita")) {
					nuovaPartita(output, s);
				}
				else if(operazione.equalsIgnoreCase("collegati a")){
					String giocatore1 = s.nextToken(); 
					String giocatore2 = s.nextToken(); 
					boolean partitaEsistente = false;
					for (int i = 0; i < partite.size(); i++) {
						if(partite.get(i).getGiocatore1().equalsIgnoreCase(giocatore1)&&
								partite.get(i).getGiocatore2().equalsIgnoreCase(giocatore2)&&
									partite.get(i).isConclusa()==false){
							output.println("Sta restituendoti: "+partite.get(i).getId());
							System.out.println("Restituito a "+giocatore2+" l'id della partita con "+giocatore1);
							partitaEsistente = true;
						}
						if(!partitaEsistente){
							output.println("partita non esistente	"+giocatore1+"	"+giocatore2);		//TODO estrai
							System.out.println("Tentata connessione a partita non esistente.");
						}
					} 
				}


				// TODO HashMap

			}
			System.out.println("Message received.");
		} catch (IOException ioEx) {
			ioEx.printStackTrace();
		}

		finally {
			try {
				System.out.println("\n* Closing connection... *");
				link.close(); // Step 5.
			} catch (IOException ioEx) {
				System.out.println("Unable to disconnect!");
				System.exit(1);
			}
		}
	}

	private static void nuovaPartita(PrintWriter output, StringTokenizer s) {
		String giocatore1 = s.nextToken();
		String giocatore2 = s.nextToken();

		partitaIndex++;

		Partita partitaCreata = new Partita(partitaIndex, giocatore1,
				giocatore2);
		partite.add(partitaCreata);

		System.out.println("Iniziato una nuova partita: id=" + partitaIndex
				+ " \n" + "Giocatore1= " + giocatore1 + "\n" + "Giocatore2= "
				+ giocatore2);

		output.println(partitaIndex);
	}
}
