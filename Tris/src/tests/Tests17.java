/**
 * Questo test vuole verificare la corretta lettura di un pacchetto che proviene dalla rete
 * @author Giacomo
 */
package tests;

import rete.InterpretePacchettoDefault;

public class Tests17 {
	public static void main(String[] args) {
		String pacchetto1 = "Mosse  1 2 3 4";
		String pacchetto2 = "Risultato  Hai vinto";
		InterpretePacchettoDefault pacchettoDefault = new InterpretePacchettoDefault();
		pacchettoDefault.interpretaPacchetto(pacchetto1);
		for (int i = 0; i < pacchettoDefault.getMossePacchetto().size(); i++) {
			System.out.println(pacchettoDefault.getMossePacchetto().get(i));
		}
		pacchettoDefault.interpretaPacchetto(pacchetto2);
		System.out.println(pacchettoDefault.getRisultatoPacchetto());
	}
}
