package tests;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import rete.Client;
import server.ServizioAggiornamento;
import server.ServizioCollegamento;
import server.ServizioInviaMossa;
import server.ServizioNuovaPartita;
/**
 * Test dei servizi {@link ServizioAggiornamento} {@link ServizioCollegamento} {@link ServizioInviaMossa} {@link ServizioNuovaPartita}
 * @author Dario
 *
 */
public class Test04 {

	Client client = new Client();
	
	
	@Test
	public void test01() {
		
		assertTrue(client.send("Nuova partita	Santo	Dario").contentEquals("Partita	0	inCorso	G2	 null null null null null null null null null"));

	}
	
	@Test
	public void test02(){
	
		assertTrue(client.send("Mossa	0	Dario	8").contentEquals("Partita	0	inCorso	Dario	 null null null null null null null null Dario"));
	}
	
	@Test
	public void test03(){
		
		assertTrue(client.send("update	0").contentEquals("Partita	0	inCorso	Dario	 null null null null null null null null Dario"));
	
	}
	
	@Test
	public void test04(){

		assertTrue(client.send("collegati a	Santo	Dario").contentEquals("Partita	0	inCorso	Dario	 null null null null null null null null Dario"));
	
	}

}
