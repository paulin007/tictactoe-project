package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import server.Partita;
import tris.Algoritmo;
import tris.Simbolo;
/**
 * 
 * Test sulle funzionalità della classe {@link Algoritmo}
 * @author Dario
 *
 */
public class Test02 {

	Algoritmo algoritmo = new Algoritmo();
	Partita partita = new Partita(0, "G1", "G2");
	
	
	@Test
	public void test() {
		
		partita.getCelle().getCaselle().get(0).setSimbolo(Simbolo.simboloG1);
		assertTrue(algoritmo.execute(partita, "G1", "0").equalsIgnoreCase("MossaNonValida"));
		assertTrue(algoritmo.execute(partita, "G2", "3").contentEquals(partita.toString()));
		
	}

}
