package tests;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import rete.InterpreteMessaggio;
/**
 *Testa sulle funzionalità della classe {@link InterpreteMessaggio} 
 *
 */
public class Test02 {

	InterpreteMessaggio interpreteMessaggio = new InterpreteMessaggio();
	
	String partita = "tris	0	inCorso	G2	null null null null null null null null null";

	public Test02() {
		
		interpreteMessaggio.interpreta(partita);
	}
	
	@Test
	public void test01() {
		assertTrue(interpreteMessaggio.getTipoMessaggio().contentEquals("tris"));
	}
	
	@Test
	public void test02(){
		assertTrue(interpreteMessaggio.getIDpartita().contentEquals("0"));
	}
	@Test
	public void test03(){
		assertTrue(interpreteMessaggio.getUltimoGiocatore().contentEquals("G2"));
	}

	@Test
	public void test04(){
		assertTrue(interpreteMessaggio.getStatoPartita().contentEquals("inCorso"));
	}

	@Test
	public void test05(){
		assertTrue(interpreteMessaggio.getCaselle().toString().contentEquals("[null, null, null, null, null, null, null, null, null]"));
	}


}
