/**
 * Questa classe permette di realizzare il DP Proxy, per rendere facile
 * la gestione a runtime del tipo di difficoltà che l'utente vuole
 * @author Giacomo
 */
package tris.computerIntelligenza;

public class ProxyDifficolta {
	
	private Difficolta difficolta;

	public ProxyDifficolta(Difficolta difficolta) {
		super();
		this.difficolta = difficolta;
	}

	public Difficolta getDifficoltà() {
		return difficolta;
	}

	public void setDifficoltà(Difficolta difficoltà) {
		this.difficolta = difficoltà;
	}
	
}
