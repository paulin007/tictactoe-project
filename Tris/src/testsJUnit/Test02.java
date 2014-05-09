package testsJUnit;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Collections;

import org.junit.Test;

import tris.TabellaTris;
import tris.vincita.AlgoritmoTris;

/**
 * Test sui metodi della classe {@link AlgoritmoTris}
 * @author Dario
 *
 */
public class Test02 {

	AlgoritmoTris algoritmoTris;
	TabellaTris tabella;
	
	@Test
	public void testSeparaMosse(){
		algoritmoTris = new AlgoritmoTris();
		tabella = new TabellaTris();
		tabella.creaTabella();
		tabella.getCaselle().get(0).setSimbolo("G2");
		tabella.getCaselle().get(1).setSimbolo("G1");
		tabella.getCaselle().get(2).setSimbolo("G2");
		tabella.getCaselle().get(3).setSimbolo("G1");
		tabella.getCaselle().get(4).setSimbolo("G2");
		tabella.getCaselle().get(5).setSimbolo("G1");
		
		algoritmoTris.separaMosse(tabella.getCaselle());
		ArrayList<Integer> mossePc = new ArrayList<>();
		Collections.addAll(mossePc, 0,2,4 );
		ArrayList<Integer> mossePlayer = new ArrayList<>();
		Collections.addAll(mossePlayer, 1,3,5 );
		
		assertTrue(mossePc.containsAll(algoritmoTris.getGiocatore2()) && mossePlayer.containsAll(algoritmoTris.getGiocatore1()));
		
	}
	
	@Test
	public void testHaiVinto() {
		algoritmoTris = new AlgoritmoTris();
		tabella = new TabellaTris();
		tabella.creaTabella();
		tabella.getCaselle().get(0).setSimbolo("G2");
		tabella.getCaselle().get(1).setSimbolo("G2");
		tabella.getCaselle().get(2).setSimbolo("G2");
		algoritmoTris.separaMosse(tabella.getCaselle());
		
		assertTrue(algoritmoTris.haiVinto(algoritmoTris.getGiocatore2()));
		
	
	}
	@Test
	public void testStabilisciVincitore(){
		
		algoritmoTris = new AlgoritmoTris();
		tabella = new TabellaTris();
		tabella.creaTabella();
		tabella.getCaselle().get(0).setSimbolo("G2");
		tabella.getCaselle().get(4).setSimbolo("G2");
		tabella.getCaselle().get(8).setSimbolo("G2");
		tabella.getCaselle().get(1).setSimbolo("G1");
		tabella.getCaselle().get(2).setSimbolo("G1");
		tabella.getCaselle().get(3).setSimbolo("G1");
		
		assertTrue(algoritmoTris.stabilisciVincitore(tabella.getCaselle()).contains("Giocatore2"));
		assertTrue(algoritmoTris.haVintoG2());
	}
	

}
