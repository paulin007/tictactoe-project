package rete;

public class Sender {
	
	
	public static void main(String[] args) {
	
		Client clients = new Client();
		
		System.out.println(clients.send("nuova partita	pippo	pluto"));
		
		System.out.println(clients.send("collegati a	pippo	pluto"));
		
		System.out.println(clients.send("mossa	0	G1	7"));
				
	}

}
