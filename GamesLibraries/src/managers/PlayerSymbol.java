package managers;

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
