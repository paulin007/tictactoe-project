package tests;

import static org.junit.Assert.assertTrue;
import gioco.GiochiPresenti;
import gioco.Partita;
import gioco.Simbolo;

import org.junit.Test;

import tris.AlgoritmoTris;
/**
 * 
 * Test sulle funzionalita della classe {@link AlgoritmoTris}
 * @author Dario
 *
 */
public class Test02 {

	AlgoritmoTris algoritmo = new AlgoritmoTris();
	Partita partita = new Partita(0, Simbolo.simboloG1, Simbolo.simboloG2, GiochiPresenti.tris);
	
	
	@Test
	public void test() {
		
		partita.getTabella().getCaselle().get(0).setSimbolo(Simbolo.simboloG1);
		
		assertTrue(algoritmo.execute(partita, Simbolo.simboloG1, "0").equalsIgnoreCase("tris	0	inCorso	G2	 G1 null null null null null null null null"));
		
		
	}
	
	@Test
	public void test02(){
		
		assertTrue(algoritmo.execute(partita, Simbolo.simboloG2, "3").equalsIgnoreCase("tris	0	inCorso	G2	 null null null G2 null null null null null"));
	}

}
