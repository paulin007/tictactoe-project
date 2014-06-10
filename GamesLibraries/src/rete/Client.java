package rete;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
/**
 * In questa classe si apre un socket che communica con il server
 *
 * @author Andrea Gallo
 */
public class Client implements IClient {
	private static InetAddress host;
	private static final int PORT = 45444;

	public Client() {
		try {
			host = InetAddress.getLocalHost();
			
		} catch (UnknownHostException uhEx) {
			System.out.println("Host ID not found!");
			System.exit(1);
		}
	}

	/**
	 * Effettua un invio di un messaggio al server.
	 * 
	 * @param messageToSend Messaggio da mandare al server
	 * @return response risposta del server
	 */
	public String send(String messageToSend) {
		Socket link = null; // Step 1.

		try {
			link = new Socket(host, PORT); 

			Scanner input = new Scanner(link.getInputStream());

			PrintWriter output = new PrintWriter(link.getOutputStream(), true);

			String message, response;

			message = messageToSend;
			output.println(message); 
			response = input.nextLine(); 
			input.close();
			return response;

		} catch (IOException ioEx) {
			ioEx.printStackTrace();
		}

		finally {
			try {
				link.close(); 
			} catch (IOException ioEx) {
				System.out.println("Unable to disconnect!");
				System.exit(1);
			}
		}
		return "true";
	}
}
