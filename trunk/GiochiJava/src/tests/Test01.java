package tests;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import rete.Client;
/**
 * Test dei servizi {@link ServizioAggiornamento} {@link ServizioCollegamento} {@link ServizioInviaMossa} {@link ServizioNuovaPartita}
 * NOTA: Prima di avviare questo test, è necessario lanciare il Server
 * @author Dario
 *
 */
public class Test01 {

	Client client = new Client();
	
	@Test
	public void test01() {
		
		assertTrue(client.send("Nuova partita	Santo	Dario	tris").contentEquals("tris	0	inCorso	G2	 null null null null null null null null null"));
		
	}
	
	@Test
	public void test02(){
		
		
		assertTrue(client.send("Mossa	0	G1	8").contentEquals("tris	0	inCorso	G1	 null null null null null null null null G1"));
	}
	
	@Test
	public void test03(){
		
		assertTrue(client.send("update	0").contentEquals("tris	0	inCorso	G1	 null null null null null null null null G1"));
	
	}
	
	@Test
	public void test04(){

		assertTrue(client.send("collegati a	Santo	Dario").contentEquals("tris	0	inCorso	G1	 null null null null null null null null G1"));
	
	}

}
