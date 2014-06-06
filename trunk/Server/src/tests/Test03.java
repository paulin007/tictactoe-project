package tests;
/**
 * Test sulle funzionalità della classe AlgoritmoForza4
 * @author Dario
 */
import static org.junit.Assert.*;
import forza4.AlgoritmoForza4;
import gioco.GiochiPresenti;
import gioco.Partita;
import gioco.Simbolo;

import org.junit.Test;

public class Test03 {

	Partita partita = new Partita(0, "Dario", "Giacomo", GiochiPresenti.forza4);
	AlgoritmoForza4 algoritmoForza4 = new AlgoritmoForza4();
	
	
	@Test
	public void test1() {
		algoritmoForza4.execute(partita, "G1", "0");
		assertTrue(partita.getTabella().getCaselle().get(35).getSimbolo().equalsIgnoreCase("G1"));
	}
	
	@Test
	public void test2() {
		algoritmoForza4.execute(partita, "G1", "0");
		algoritmoForza4.execute(partita, "G1", "1");
		algoritmoForza4.execute(partita, "G1", "2");
		algoritmoForza4.execute(partita, "G1", "3");
		assertTrue(partita.getRisultato().equalsIgnoreCase(Simbolo.simboloG1));
	}
}
