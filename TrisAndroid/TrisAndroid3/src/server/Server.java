package server;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

import tris.Algoritmo;

public class Server {

	private static ServerSocket servSock;
	private static final int PORT = 45454;
	private static Scanner input;
	private static int partitaIndex = 0;
	private static ArrayList<Partita> partite = new ArrayList<Partita>();
	

	public static void main(String[] args) {

		System.out.println("Apertura porta: " + PORT + "\n");
		try {
			servSock = new ServerSocket(PORT);
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
			
			System.out.println("Connessione ricevuta.");

			input = new Scanner(link.getInputStream());
			PrintWriter output = new PrintWriter(link.getOutputStream(), true);

			String message = input.nextLine();

			// TODO Change StringTokenizer in XML format
			StringTokenizer s = new StringTokenizer(message, "	");

			String operazione = s.nextToken();
			if (operazione.equalsIgnoreCase("nuova partita")) {
				nuovaPartita(output, s);
			} else if (operazione.equalsIgnoreCase("collegati a")) {
				collegamento(output, s);
			} else if (operazione.equalsIgnoreCase("mossa")) {
				inviamossa(output, s);
			}

			// TODO HashMap

			System.out.println("Message received.");
		} catch (IOException ioEx) {
			ioEx.printStackTrace();
		}

		finally {
			try {
				System.out.println("\n* Closing connection... *");
				link.close(); 
			} catch (IOException ioEx) {
				System.out.println("Unable to disconnect!");
				System.exit(1);
			}
		}
	}

	private static void inviamossa(PrintWriter output, StringTokenizer s) {
		int idPartita = Integer.parseInt(s.nextToken());
		String giocatore = s.nextToken();
		String mossa = s.nextToken();
		for (int i = 0; i < partite.size(); i++) {
			if (partite.get(i).getId() == idPartita) {
					Algoritmo algoritmo = new Algoritmo();

					if(!(partite.get(i).getUltimoGiocatore().equalsIgnoreCase(giocatore)))
						algoritmo.execute(partite.get(i), giocatore, mossa);

					output.println(partite.get(i));

					partite.get(i).setUltimoGiocatore(giocatore);

			}

		}
	}

	private static void collegamento(PrintWriter output, StringTokenizer s) {
		String giocatore1 = s.nextToken();
		String giocatore2 = s.nextToken();
		boolean partitaEsistente = false;
		for (int i = 0; i < partite.size(); i++) {
			if (partite.get(i).getGiocatore1().equalsIgnoreCase(giocatore1)
					&& partite.get(i).getGiocatore2()
					.equalsIgnoreCase(giocatore2)
					&& partite.get(i).isConclusa() == false) {
					output.println(partite.get(i));

				System.out.println("Restituito a " + giocatore2
						+ " l'id della partita con " + giocatore1 + ": "
						+ partite.get(i).getId());
				partitaEsistente = true;
			}
			if (!partitaEsistente) {
				output.println("partita non esistente	" + giocatore1 + "	"
						+ giocatore2); // TODO estrai
				System.out.println("Tentata connessione a partita non esistente.");
			}
		}
	}

	private static void nuovaPartita(PrintWriter output, StringTokenizer s) {
		String giocatore1 = s.nextToken();
		String giocatore2 = s.nextToken();

		Partita partitaCreata = new Partita(partitaIndex, giocatore1,
				giocatore2);
		partite.add(partitaCreata);

		System.out.println("Iniziato una nuova partita: id=" + partitaIndex
				+ " \n" + "Giocatore1= " + giocatore1 + "\n" + "Giocatore2= "
				+ giocatore2);

		output.println(partite.get(partitaIndex));
		partitaIndex++;

	}
}
