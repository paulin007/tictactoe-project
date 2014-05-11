package tests;

import server.Partita;
import tris.Algoritmo;
import tris.Simbolo;

public class TestsAlgoritmo {
	public static void main(String[] args) {
		Partita partita = new Partita(1, "Giacomo", "Dario");
		Algoritmo algoritmo = new Algoritmo();
		System.out.println(algoritmo.execute(partita, Simbolo.simboloG1, "2"));
		System.out.println(algoritmo.execute(partita, Simbolo.simboloG2, "1"));
		System.out.println(algoritmo.execute(partita, Simbolo.simboloG1, "2"));//verifico errore
		System.out.println(algoritmo.execute(partita, Simbolo.simboloG1, "5"));
		System.out.println(algoritmo.execute(partita, Simbolo.simboloG2, "3"));
		System.out.println(algoritmo.execute(partita, Simbolo.simboloG1, "8"));
		System.out.println(partita);
	}

}
