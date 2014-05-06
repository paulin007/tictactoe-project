package testsJUnit;

import static org.junit.Assert.*;

import org.junit.Test;

import tris.TabellaTris;
import computerIntelligenza.DifficoltàDifficile;

/**
 * Testo la funzionalità del metodo generaMossa nella classe
 * {@link DifficoltàDifficile}
 * @author Dario
 *
 */
public class Test01 {

	DifficoltàDifficile difficile = new DifficoltàDifficile();
	TabellaTris tabellaTris = new TabellaTris();
	
	@Test
	public void testMossaDifensiva() {
		
		
		tabellaTris.creaTabella();
		
		tabellaTris.getCaselle().get(0).setSimbolo("g");
		tabellaTris.getCaselle().get(1).setSimbolo("g");
		
		assertTrue(difficile.generaMossa(tabellaTris)==2);	
	}
	@Test
	public void testMossaOffensiva() {
		
		
		tabellaTris.creaTabella();
		
		tabellaTris.getCaselle().get(0).setSimbolo("c");
		tabellaTris.getCaselle().get(1).setSimbolo("c");
		tabellaTris.getCaselle().get(3).setSimbolo("g");
		tabellaTris.getCaselle().get(4).setSimbolo("g");
			
		assertTrue(difficile.generaMossa(tabellaTris)==2);	
	}
}
