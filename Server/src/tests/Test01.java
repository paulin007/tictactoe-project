package tests;

import static org.junit.Assert.assertTrue;
import gioco.Casella;

import org.junit.Test;

import tris.Simbolo;

/**
 * Test sulle funzionalità della classe {@link Casella}
 * @author Dario
 *
 */
public class Test01 {

	Casella casella0 = new Casella(0);
	Casella casella1 = new Casella(1);
	Casella casella2 = new Casella(2);
	
	public Test01() {
	
		casella0.setSimbolo(Simbolo.simboloG1);
	}
	
	/**
	 * Test sui metodi occupataDaG1, occupataDaG2, isVuota,
	 */
	@Test
	public void testCasellaOccupata() {
		
		casella1.setSimbolo(Simbolo.simboloG1);
		assertTrue(casella0.occupataDaG1());
		assertTrue(!casella0.occupataDaG2());
		assertTrue(!casella0.isVuota());
	}
	

}
