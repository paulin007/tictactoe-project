package tests;

import managers.PlayerSymbol;
import grafica.ResultViewer;

public class Test09 {
	
	public static void main(String[] args) {
		
		ResultViewer viewer = new ResultViewer();
		viewer.showResult(PlayerSymbol.PLAYER1_SYMBOL.getSymbol(), PlayerSymbol.PLAYER1_SYMBOL.getSymbol());
		
	}
}
