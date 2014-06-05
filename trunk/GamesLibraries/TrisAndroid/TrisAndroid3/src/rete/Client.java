package rete;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * Questa classe crea un socket che comunica col server 
 * 
 * @author Andrea Gallo
 *
 */

public class Client implements IClient{

	private String response = "";
	private String host = "10.65.80.113";
	private static final int PORT = 45444;
	
	/**
	 *  Il metodo send prende in input una stringa Messaggio e restituisce la risposta del server
	 *  
	 * @param messaggio Il messaggio da inviare tramite socket al server
	 * @return response Il messaggio di risposta inviato dal server
	 */

	@Override
	public String send(String messaggio) {

		Socket link = null; 

		try {
			link = new Socket(host, PORT); 

			Scanner input = new Scanner(link.getInputStream());
			PrintWriter output = new PrintWriter(link.getOutputStream(), true);	
			output.println(messaggio);
			response = input.nextLine();
			input.close();
		} catch (UnknownHostException exception) {
			exception.printStackTrace();
		} catch (IOException ioEx) {
			ioEx.printStackTrace();
		}

		finally {
			if(link !=null)
				try {
					link.close();
				} catch (IOException ioEx) {

				}

		}
		return response;
	}

}



