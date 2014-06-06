package tests;
/**
 * Test sulla classe TerneVincenti
 */
import static org.junit.Assert.*;
import gioco.GiochiPresenti;
import gioco.Partita;
import gioco.Simbolo;

import org.junit.Test;

import tris.TerneVincenti;

public class Test05 {

	Partita partita = new Partita(0, Simbolo.simboloG1, Simbolo.simboloG2, GiochiPresenti.tris);
	TerneVincenti terneVincenti = new TerneVincenti();
	int N_RIGHE = 3;
	int N_COLONNE = 3;
	
	@Test
	public void testOrizzontale() {
		for (int i = 0; i < N_RIGHE; i++) {

			partita.getTabella().getCaselle().get(N_RIGHE*i).setSimbolo(Simbolo.simboloG1);
			partita.getTabella().getCaselle().get( N_RIGHE*i + 1).setSimbolo(Simbolo.simboloG1);
			partita.getTabella().getCaselle().get( N_RIGHE*i + 2).setSimbolo(Simbolo.simboloG1);
			assertTrue(terneVincenti.vittoriaOrizzontale(partita, Simbolo.simboloG1));
		}
	}
	@Test
	public void testVerticale() {
		for (int i = 0; i < N_COLONNE; i++) {
			
			partita.getTabella().getCaselle().get(i).setSimbolo(Simbolo.simboloG1);
			partita.getTabella().getCaselle().get(i+N_COLONNE).setSimbolo(Simbolo.simboloG1);
			partita.getTabella().getCaselle().get(i+2*N_COLONNE).setSimbolo(Simbolo.simboloG1);
			assertTrue(terneVincenti.vittoriaVerticale(partita, Simbolo.simboloG1));
		}
		
	}
	@Test
	public void testDiagonale1() {
		partita.getTabella().getCaselle().get(0).setSimbolo(Simbolo.simboloG1);
		partita.getTabella().getCaselle().get(4).setSimbolo(Simbolo.simboloG1);
		partita.getTabella().getCaselle().get(8).setSimbolo(Simbolo.simboloG1);
		assertTrue(terneVincenti.vittoriaDiagonale(partita, Simbolo.simboloG1));
				
			
	}
	@Test
	public void testDiagonale2() {
		partita.getTabella().getCaselle().get(2).setSimbolo(Simbolo.simboloG1);
		partita.getTabella().getCaselle().get(4).setSimbolo(Simbolo.simboloG1);
		partita.getTabella().getCaselle().get(6).setSimbolo(Simbolo.simboloG1);
		assertTrue(terneVincenti.vittoriaDiagonale(partita, Simbolo.simboloG1));
			
	}	

}
