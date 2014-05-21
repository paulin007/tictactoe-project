package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import rete.InterpreteMessaggio;
import server.Partita;

public class Test05 {

	InterpreteMessaggio interpreteMessaggio = new InterpreteMessaggio();
	Partita partita = new Partita(0, "Dario", "Santo");

	public Test05() {
		
		interpreteMessaggio.interpreta(partita.toString());
	}
	
	@Test
	public void test01() {
		assertTrue(interpreteMessaggio.getTipoMessaggio().contentEquals("Partita"));
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
