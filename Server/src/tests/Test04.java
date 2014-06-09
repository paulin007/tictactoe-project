package tests;
/**
 * Test sulla classe 
 * @author Dario
 */
import static org.junit.Assert.*;
import forza4.QuaterneVincenti;
import gioco.GiochiPresenti;
import gioco.Partita;
import gioco.Simbolo;

import org.junit.Test;

public class Test04 {

	Partita partita = new Partita(0, Simbolo.simboloG1, Simbolo.simboloG2, GiochiPresenti.forza4);
	int nRighe = 6;
	int nColonne = 7;
	int forza4 = 4;
	
	@Test
	public void testOrizzontale() {
		
		for (int j = 0; j < nRighe ; j++) {
			for (int i = 0; i <= nColonne-forza4; i++) {
				partita.getTabella().getCaselle().get(i+j*nColonne).setSimbolo(Simbolo.simboloG1);
				partita.getTabella().getCaselle().get(i+1+j*nColonne).setSimbolo(Simbolo.simboloG1);
				partita.getTabella().getCaselle().get(i+2+j*nColonne).setSimbolo(Simbolo.simboloG1);
				partita.getTabella().getCaselle().get(i+3+j*nColonne).setSimbolo(Simbolo.simboloG1);
				assertTrue(QuaterneVincenti.vittoriaOrizzontale(partita, Simbolo.simboloG1));
			}
			
		}	
		
		
	}
	
	@Test
	public void testVerticale(){
		for (int j = 0; j < nRighe ; j++) {
			for (int i = 0; i < nColonne-forza4; i++) {
				
				partita.getTabella().getCaselle().get(i*nColonne+j).setSimbolo(Simbolo.simboloG1);
				partita.getTabella().getCaselle().get(nColonne*(i+1)+j).setSimbolo(Simbolo.simboloG1);
				partita.getTabella().getCaselle().get(nColonne*(i+2)+j).setSimbolo(Simbolo.simboloG1);
				partita.getTabella().getCaselle().get(nColonne*(i+3)+j).setSimbolo(Simbolo.simboloG1);
				assertTrue(QuaterneVincenti.vittoriaVerticale(partita, Simbolo.simboloG1));
			}
			
		}
		
	}
	
	@Test
	public void testDiagonale1(){
		for (int j = 0; j < nColonne-forza4 ; j++) {
			for (int i = 0; i <= nColonne-forza4; i++) {
				
				partita.getTabella().getCaselle().get(i+nColonne*j).setSimbolo(Simbolo.simboloG1);
				partita.getTabella().getCaselle().get(i+8+nColonne*j).setSimbolo(Simbolo.simboloG1);
				partita.getTabella().getCaselle().get(i+2*8+nColonne*j).setSimbolo(Simbolo.simboloG1);
				partita.getTabella().getCaselle().get(i+3*8+nColonne*j).setSimbolo(Simbolo.simboloG1);
				assertTrue(QuaterneVincenti.vittoriaDiagonale1(partita, Simbolo.simboloG1));
			}
			
		}
	}
	
	@Test
	public void testDiagonale2(){
		for (int j = 0; j < nColonne-forza4 ; j++) {
			for (int i = 0; i <= nColonne-forza4; i++) {
				
				partita.getTabella().getCaselle().get(i+3+nColonne*j).setSimbolo(Simbolo.simboloG1);
				partita.getTabella().getCaselle().get(i+3+6+nColonne*j).setSimbolo(Simbolo.simboloG1);
				partita.getTabella().getCaselle().get(i+3+2*6+nColonne*j).setSimbolo(Simbolo.simboloG1);
				partita.getTabella().getCaselle().get(i+3+3*6+nColonne*j).setSimbolo(Simbolo.simboloG1);
				assertTrue(QuaterneVincenti.vittoriaDiagonale2(partita, Simbolo.simboloG1));
			}
			
		}
	}
}
