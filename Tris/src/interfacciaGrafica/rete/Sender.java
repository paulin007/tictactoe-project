package interfacciaGrafica.rete;

public class Sender {
	
	
	public static void main(String[] args) {
	
		Client clients = new Client();
		
		clients.send("nuova partita	pippo	pluto");
		
		clients.send("collegati a	pippo	pluto");
		
//		System.out.println(clients.nuovaPartita("1", "2"));
		
	}

}
