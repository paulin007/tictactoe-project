package tests;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import managers.MatchManager;
import managers.PlayerSymbol;

import org.junit.Test;

import rete.Client;
import rete.MessageInterpreter;

public class Test01 {
	Client client = new Client();
	MessageInterpreter interpreter = new MessageInterpreter();
	MatchManager manager = new MatchManager(client, interpreter);

	@Test
	public void test01() {
		
		manager.createNewMatch(PlayerSymbol.PLAYER1_SYMBOL.getSymbol(), PlayerSymbol.PLAYER2_SYMBOL.getSymbol(), "tris");
		assertTrue(manager.getResponse().equalsIgnoreCase("tris	0	inCorso	G2	 null null null null null null null null null"));
	}
	
	@Test
	public void test02() {
		
		manager.connectToMatch(PlayerSymbol.PLAYER2_SYMBOL.getSymbol(), PlayerSymbol.PLAYER1_SYMBOL.getSymbol(), "tris");
		assertTrue(manager.getResponse().equalsIgnoreCase("tris	0	inCorso	G2	 null null null null null null null null null"));
	}
}
