package rete;

public class Sender {
	
	
	public static void main(String[] args) {
	
		Client clients = new Client();
		
		clients.send("nuova partita	pippo	pluto");
		
		clients.send("test");
		
//		System.out.println(clients.nuovaPartita("1", "2"));
		
	}

}
