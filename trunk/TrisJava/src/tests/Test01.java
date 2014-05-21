package tests;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import tris.Simbolo;
import tris.TabellaTris;
import tris.vincita.AlgoritmoTris;

/**
 * Tests sulle funzionalità della classe {@link AlgoritmoTris}
 * @author Dario
 *
 */
public class Test01 {

	TabellaTris tabellaTris = new TabellaTris();
	AlgoritmoTris algoritmoTris = new AlgoritmoTris();
	
	public Test01() {
	
		tabellaTris.creaTabella();
		tabellaTris.getCaselle().get(0).setSimbolo(Simbolo.simboloG1);
		tabellaTris.getCaselle().get(3).setSimbolo(Simbolo.simboloG2);
		tabellaTris.getCaselle().get(1).setSimbolo(Simbolo.simboloG1);
		tabellaTris.getCaselle().get(4).setSimbolo(Simbolo.simboloG2);
		tabellaTris.getCaselle().get(2).setSimbolo(Simbolo.simboloG1);
		tabellaTris.getCaselle().get(8).setSimbolo(Simbolo.simboloG2);
		
	}
	/**
	 * Test sui metodi stabilisciVincitore, haVintoG1, haVintoG2, haiVinto,nessunoHaVinto
	 */
	@Test
	public void testVittoria() {
		
		assertTrue(algoritmoTris.stabilisciVincitore(tabellaTris.getCaselle()).equalsIgnoreCase("ha vinto Giocatore1"));
		assertTrue(algoritmoTris.haVintoG1());
		assertTrue(algoritmoTris.haiVinto(algoritmoTris.getGiocatore1()));
		assertTrue(!algoritmoTris.haVintoG2());
		assertTrue(!algoritmoTris.nessunoHaVinto());
	}
}
