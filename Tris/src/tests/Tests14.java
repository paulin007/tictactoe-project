/**
 * Questo test verifica la corretta lettura del file contenente le statistiche del giocatore, 
 * le aggiorna e ricrea il file con le statisthce aggiornate
 * @author Giacomo
 */
package tests;

import statistiche.CaricamentoFile;
import statistiche.FileOutput;
import statistiche.InterpreteStatisticheDefault;
import statistiche.Statistica;

public class Tests14 {
	public static void main(String[] args) {
		CaricamentoFile file = new CaricamentoFile();
		file.setNomeFile("./src/StatisticaProva.txt");
		String risultato = file.getList().get(0);
		InterpreteStatisticheDefault statisticheDefault = new InterpreteStatisticheDefault();
		statisticheDefault.statisticheDaFile(risultato);
		System.out.println(statisticheDefault.getStatistica());
		Statistica statistica = statisticheDefault.getStatistica();
		statistica.aggiornaVittorie();
		statistica.aggiornaPareggi();
		statistica.aggiornaSconfitte();
		FileOutput.creaFile(statistica.sintetico(), "./src/StatisticaProva.txt");
	}
}
