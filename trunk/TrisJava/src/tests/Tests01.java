package tests;

import java.util.StringTokenizer;

import rete.Client;
import rete.InterpreteMessaggio;

public class Tests01 {
	public static void main(String[] args) {
		Client client = new Client();
		InterpreteMessaggio interpreteMessaggio = new InterpreteMessaggio();
		interpreteMessaggio.interpreta(client.send("nuova partita	Giacomo	Dario"));
		interpreteMessaggio.interpreta(client.send("Mossa	0	G1	1"));
		System.out.println(interpreteMessaggio.getIDpartita());
		System.out.println(client.send("update	0"));
		
	}
}
