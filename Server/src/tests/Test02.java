package tests;

import static org.junit.Assert.*;
import gioco.Partita;

import org.junit.Test;

import tris.AlgoritmoTris;
import tris.Simbolo;
/**
 * 
 * Test sulle funzionalità della classe {@link AlgoritmoTris}
 * @author Dario
 *
 */
public class Test02 {

	AlgoritmoTris algoritmo = new AlgoritmoTris();
	Partita partita = new Partita(0, "G1", "G2", "tris");
	
	
	@Test
	public void test() {
		
		partita.getTabella().getCaselle().get(0).setSimbolo(Simbolo.simboloG1);
		assertTrue(algoritmo.execute(partita, "G1", "0").equalsIgnoreCase("MossaNonValida"));
		assertTrue(algoritmo.execute(partita, "G2", "3").contentEquals(partita.toString()));
		
	}

}
