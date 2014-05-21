package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import tris.Casella;
import tris.Simbolo;

/**
 * Test sulle funzionalità della classe {@link Casella}
 * @author Dario
 *
 */
public class Test02 {

	Casella casella0 = new Casella(0);
	Casella casella1 = new Casella(1);
	Casella casella2 = new Casella(2);
	
	public Test02() {
	
		casella0.setSimbolo(Simbolo.simboloG1);
	}
	
	/**
	 * Test sui metodi occupataDaG1, occupataDaG2, isVuota, casellaConsecutivaG1
	 */
	@Test
	public void testCasellaConsecutiva() {
		
		
		casella1.setSimbolo(Simbolo.simboloG1);
		assertTrue(casella0.occupataDaG1());
		assertTrue(!casella0.occupataDaG2());
		assertTrue(!casella0.isVuota());
		assertTrue(casella0.casellaConsecutivaG1(casella1));	
	}
	/**
	 * Test sul metodo possibileMossaG2
	 */
	@Test
	public void testPossibileMossaG2(){
		casella0.setSimbolo(Simbolo.simboloG2);
		Casella casella1 = new Casella(1);
		casella1.setSimbolo(Simbolo.simboloG2);
		
		assertTrue(casella0.possibileMossaG2(casella1, casella2));
	}

}
