/**
 * Questa classe contiene l'astrazione sul concetto di Statistica, che è utile per mostare 
 * lo storico dellle partite del Giocatore
 * @author Giacomo
 */
package statistiche;

public class Statistica {
	
	private int vittorie;
	private int pareggi;
	private int sconfitte;
	public Statistica() {
		
	}
	public Statistica(int vittorie, int pareggi, int sconfitte) {
		super();
		this.vittorie = vittorie;
		this.pareggi = pareggi;
		this.sconfitte = sconfitte;
	}
	public int getVittorie() {
		return vittorie;
	}
	public void setVittorie(int vittorie) {
		this.vittorie = vittorie;
	}
	public int getPareggi() {
		return pareggi;
	}
	public void setPareggi(int pareggi) {
		this.pareggi = pareggi;
	}
	public int getSconfitte() {
		return sconfitte;
	}
	public void setSconfitte(int sconfitte) {
		this.sconfitte = sconfitte;
	}
	/**
	 * Questo metodo permette di aggionrare il numero di vittorie facilmente
	 */
	public void aggiornaVittorie(){
		setVittorie(getVittorie()+1);
	}
	/**
	 * Questo metodo permette di aggionrare il numero di pareggi facilmente
	 */
	public void aggiornaPareggi(){
		setPareggi(getPareggi()+1);
	}
	/**
	 * Questo metodo permette di aggionrare il numero di sconfitte facilmente
	 */
	public void aggiornaSconfitte(){
		setSconfitte(getSconfitte()+1);
	}
	/**
	 * Questo meto permette di calcolare il numero totale di partite che sono state fatte dal giocatore
	 * @return
	 */
	public int getNumeroPartite(){
		return getVittorie()+getPareggi()+getSconfitte();
	}
	@Override
	public String toString(){
		return "Partite totali: "+getNumeroPartite()+" Numero vittorie: "+getVittorie()+" Numero pareggi: "+getPareggi()+" Numero sconfitte: "+getSconfitte();
	}
	/**
	 * Statistiche sintetiche del giocatore
	 * @return
	 */
	public String sintetico(){
		return getVittorie()+" "+getPareggi()+" "+getSconfitte();
	}
}
