/**
 * Questo test ha lo scopro di verificare la corretta lettura del file contenente
 * le statistiche del gicoatore
 * @author Giacomo
 */
package tests;

import statistiche.CaricamentoFile;
import statistiche.InterpreteStatisticheDefault;

public class Tests13 {
	public static void main(String[] args) {
		CaricamentoFile file = new CaricamentoFile();
		file.setNomeFile("./src/StatisticaProva.txt");
		String risultato = file.getList().get(0);
		InterpreteStatisticheDefault statisticheDefault = new InterpreteStatisticheDefault();
		statisticheDefault.statisticheDaFile(risultato);
		System.out.println(statisticheDefault.getStatistica());
	}
}
