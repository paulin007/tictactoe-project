package managers;
/**
 * Un'enumerazione contenente il simbolo dei giocatori
 */
public enum PlayerSymbol {

	PLAYER1_SYMBOL("G1"),
	PLAYER2_SYMBOL("G2");
	
	private String symbol;

	private PlayerSymbol(String symbol) {
		this.symbol = symbol;
	}
	
	public String getSymbol() {
		return symbol;
	}
	
}
