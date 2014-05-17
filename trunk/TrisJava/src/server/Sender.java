package server;

import rete.Client;

public class Sender {
	
	
	public static void main(String[] args) {
		
		Client client = new Client();

		System.err.println(client.send("nuova partita	pippo	pluto"));
	}

}
