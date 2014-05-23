package gioco;

/**
 * Responsabilit��: astrae sul concetto di una partita Tris
 */
public class Partita {
	
	private String giocatore1;												// Il primo giocatore, avvia la partita
	private String giocatore2;												// Il secondo giocatore, si aggiunge alla partita
	private Tabella tabella;							// Celle disponibili
	boolean conclusa = false;												// Se la partita si ��� gi��� conclusa
	String risultato = "inCorso";
	private int id;
	private String ultimoGiocatore = "G2";
	private String gioco;
	
	public Partita(int id, String giocatore1, String giocatore2, String gioco){
		this.giocatore1 = giocatore1;
		this.giocatore2 = giocatore2;
		this.gioco = gioco;
		creaTabellaPartita(gioco);
		this.id = id;
		
	}
	
	private void creaTabellaPartita(String gioco){
		if(gioco.equalsIgnoreCase(GiochiPresenti.tris)){
			tabella = new Tabella(3, 3);
		}
		if(gioco.equalsIgnoreCase(GiochiPresenti.forza4)){
			tabella = new Tabella(6, 7);
		}
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

	public void setTabella(Tabella tabella) {
		this.tabella = tabella;
	}
	
	public Tabella getTabella() {
		return tabella;
	}

	public String getRisultato() {
		return risultato;
	}

	public void setRisultato(String risultato) {
		this.risultato = risultato;
	}

	@Override
	public String toString(){
		return gioco+"	"+id+"	"+getRisultato()+"	"+getUltimoGiocatore()+"	"+getTabella().toString();
	}

	public String getUltimoGiocatore() {
		return ultimoGiocatore;
	}

	public void setUltimoGiocatore(String ultimoGiocatore) {
		this.ultimoGiocatore = ultimoGiocatore;
	}
}
