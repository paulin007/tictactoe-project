package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import managers.PlayerSymbol;

import org.junit.Test;

import rete.Client;
import rete.MessageInterpreter;

public class Test02 {

	Client client = new Client();
	MessageInterpreter interpreter = new MessageInterpreter();
	
	public Test02() {
		interpreter.interpret(client.send("nuova partita	" + PlayerSymbol.PLAYER1_SYMBOL.getSymbol() + "	" + PlayerSymbol.PLAYER2_SYMBOL.getSymbol() + "\t"+"tris"));
	}
	
	@Test
	public void test1() {
		assertTrue(interpreter.getMatchID().equalsIgnoreCase("0"));
	}
	@Test
	public void test2() {
		assertTrue(interpreter.getLastPlayer().equalsIgnoreCase("G2"));
	}
	@Test
	public void test3() {
		assertTrue(interpreter.getServiceRequest().equalsIgnoreCase("tris"));
	}
	@Test
	public void test4() {
		System.out.println(interpreter.getServiceRequest());
		ArrayList<String> boxes = new ArrayList<>();
		for (int i = 0; i < 9; i++) {
			boxes.add("null");
		}
		assertTrue(interpreter.getBoxes().containsAll(boxes));
	}
	@Test
	public void test5() {
		assertTrue(interpreter.getMatchStatus().equalsIgnoreCase("inCorso"));
	}

}
