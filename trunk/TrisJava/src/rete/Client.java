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
 * @author Kokou Adjignon
 */
public class Client {
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
	 * data una richiesta elabora la risposta.
	 * 
	 * @param messaggio
	 * @return response
	 */
	public String send(String messaggio) {
		Socket link = null; // Step 1.

		try {
			link = new Socket("192.168.0.100", PORT); // Step 1.

			Scanner input = new Scanner(link.getInputStream());// Step 2.

			PrintWriter output = new PrintWriter(link.getOutputStream(), true);// Step

			String message, response;

			message = messaggio;
			output.println(message); // Step 3.
			response = input.nextLine(); // Step 3.
			input.close();
			return response;

		} catch (IOException ioEx) {
			ioEx.printStackTrace();
		}

		finally {
			try {
				System.out.println("\n* Closing connection... *");
				link.close(); // Step 4.
			} catch (IOException ioEx) {
				System.out.println("Unable to disconnect!");
				System.exit(1);
			}
		}
		return "true";
	}
}
