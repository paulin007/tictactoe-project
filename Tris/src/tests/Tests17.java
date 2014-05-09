/**
 * Questo test vuole verificare la corretta lettura di un pacchetto che proviene dalla rete
 * @author Giacomo
 */
package tests;

import interfacciaGrafica.rete.InterpretePacchettoDefault;

public class Tests17 {
	public static void main(String[] args) {
		String pacchetto1 = "Mosse	1	2";
		String pacchetto2 = "Risultato  Hai vinto";
		InterpretePacchettoDefault pacchettoDefault = new InterpretePacchettoDefault();
		pacchettoDefault.interpretaPacchetto(pacchetto1);
		System.out.println(pacchettoDefault.getUltimaMossaPacchetto());
		pacchettoDefault.interpretaPacchetto(pacchetto2);
		System.out.println(pacchettoDefault.getRisultatoPacchetto());
	}
}
