/**
 * Questa classe permette di realizzare il DP Proxy, per rendere facile
 * la gestione a runtime del tipo di difficoltà che l'utente vuole
 * @author Giacomo
 */
package computerIntelligenza;

public class ProxyDifficoltà {
	
	private Difficoltà difficoltà;

	public ProxyDifficoltà(Difficoltà difficoltà) {
		super();
		this.difficoltà = difficoltà;
	}

	public Difficoltà getDifficoltà() {
		return difficoltà;
	}

	public void setDifficoltà(Difficoltà difficoltà) {
		this.difficoltà = difficoltà;
	}
}
