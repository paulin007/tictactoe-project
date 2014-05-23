package forza4;

/**
 * Responsabilit??: astrae sul concetto di una partita Tris
 */
public class Partita {
	
	private String giocatore1;												// Il primo giocatore, avvia la partita
	private String giocatore2;												// Il secondo giocatore, si aggiunge alla partita
	private Tabella celle = new Tabella(6, 7);							// Celle disponibili
	boolean conclusa = false;												// Se la partita si ??? gi??? conclusa
	String risultato = "inCorso";
	private int id;
	private String ultimoGiocatore = "G2";
	
	public Partita(int id, String giocatore1, String giocatore2){
		this.giocatore1 = giocatore1;
		this.giocatore2 = giocatore2;
		//celle.creaTabella();
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

	public boolean isConclusa() {
		if(getRisultato().equalsIgnoreCase("inCorso")){
			return false;
		}else{
			return true;
		}
		//return conclusa;
	}

	public void setConclusa(boolean conclusa) {
		this.conclusa = conclusa;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	

	public Tabella getCelle() {
		return celle;
	}

	public void setCelle(Tabella celle) {
		this.celle = celle;
	}

	public String getRisultato() {
		return risultato;
	}

	public void setRisultato(String risultato) {
		this.risultato = risultato;
	}

	@Override
	public String toString(){
		return "Partita	"+id+"	"+getRisultato()+"	"+getUltimoGiocatore()+"	"+getCelle().toString();
	}

	public String getUltimoGiocatore() {
		return ultimoGiocatore;
	}

	public void setUltimoGiocatore(String ultimoGiocatore) {
		this.ultimoGiocatore = ultimoGiocatore;
	}
}
