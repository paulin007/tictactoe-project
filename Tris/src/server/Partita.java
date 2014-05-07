package server;


public class Partita {
	
	private String giocatore1;												// Il primo giocatore, avvia la partita
	private String giocatore2;												// Il secondo giocatore, si aggiunge alla partita
	private char[] celle = {' ',' ',' ',' ',' ',' ',' ',' ',' '};			// Celle disponibili
	boolean conclusa = false;												// Se la partita si è già conclusa
	private int id;
	
	public Partita(int id, String giocatore1, String giocatore2){
		this.giocatore1 = giocatore1;
		this.giocatore2 = giocatore2;
		this.id = id;
		
	}

	public String getGiocatore1() {
		return giocatore1;
	}

	public void setGiocatore1(String giocatore1) {
		this.giocatore1 = giocatore1;
	}

	public String getGiocatore2() {
		return giocatore2;
	}

	public void setGiocatore2(String giocatore2) {
		this.giocatore2 = giocatore2;
	}


	
	
}
