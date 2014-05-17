package server;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

import rete.Client;

public class Sender {
	
	
	public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
		
		Client client = new Client();

		System.err.println(client.send("nuova partita	pippo	pluto"));
		System.err.println(client.send("collegati a	pippo	pluto"));
		System.err.println(client.send("mossa	0	pippo	0"));
	}

}
