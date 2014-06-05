package tests;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import rete.MessageInterpreter;
/**
 *Testa sulle funzionalità della classe {@link MessageInterpreter} 
 *
 */
public class Test02 {

	MessageInterpreter interpreteMessaggio = new MessageInterpreter();
	String partita = "0, Dario, Santo";

	public Test02() {
		
		interpreteMessaggio.interpret(partita);
	}
	
	@Test
	public void test01() {
		assertTrue(interpreteMessaggio.getServiceRequest().contentEquals("Partita"));
	}
	
	@Test
	public void test02(){
		assertTrue(interpreteMessaggio.getMatchID().contentEquals("0"));
	}
	@Test
	public void test03(){
		assertTrue(interpreteMessaggio.getLastPlayer().contentEquals("G2"));
	}

	@Test
	public void test04(){
		assertTrue(interpreteMessaggio.getMatchStatus().contentEquals("inCorso"));
	}

	@Test
	public void test05(){
		assertTrue(interpreteMessaggio.getBoxes().toString().contentEquals("[null, null, null, null, null, null, null, null, null]"));
	}


}
