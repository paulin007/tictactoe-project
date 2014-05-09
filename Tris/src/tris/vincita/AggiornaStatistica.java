/**
 * Questa classe ha la responsabilità di aggiornare le statistiche del Tris, qualora 
 * una partita sia stata conclusa
 * @author Giacomo
 */
package tris.vincita;

import java.util.Observable;
import java.util.Observer;

import statistiche.CaricamentoFile;
import statistiche.FileOutput;
import statistiche.InterpreteStatisticheDefault;
import statistiche.Statistica;

public class AggiornaStatistica implements Observer {
	
	private static String percorsoFile = "./src/StatisticaProva.txt";
	private Statistica statistica;
	private AlgoritmoTris algoritmoTris;
	private CaricamentoFile caricamentoFile = new CaricamentoFile();
	
	public AggiornaStatistica(AlgoritmoTris algoritmoTris){
		this.algoritmoTris = algoritmoTris;
		algoritmoTris.addObserver(this);
		caricamentoFile.setNomeFile(percorsoFile);
	}
	
	private void caricaStatistica(){
		
		InterpreteStatisticheDefault interpreteStatisticheDefault = new InterpreteStatisticheDefault();
		interpreteStatisticheDefault.statisticheDaFile(caricamentoFile.getList().get(0));
		statistica = interpreteStatisticheDefault.getStatistica();
	}
	
	@Override
	public void update(Observable o, Object arg) {
		System.out.println("Sono stato notificato");
		caricaStatistica();
		aggiornaStatistiche();
		aggiornaFile();
		
	}
	/**
	 * Questo metodo aggiorna le statistiche, a secondo di come è finita la partita
	 */
	private void aggiornaStatistiche(){
		
		boolean vincitaG1 = algoritmoTris.haVintoG1();
		System.out.println(algoritmoTris.haVintoG1());
		boolean vincitaG2 = algoritmoTris.haVintoG1();
		System.out.println(algoritmoTris.haVintoG2());
		System.out.println(algoritmoTris.nessunoHaVinto());
		boolean nessunoHaVinto = algoritmoTris.nessunoHaVinto();
		
		if(vincitaG1){
			statistica.aggiornaVittorie();
		}
		if(vincitaG2){
			statistica.aggiornaSconfitte();
		}
		
		if(nessunoHaVinto){
			statistica.aggiornaPareggi();
		}
	}
	/**
	 * Questo metodo aggiorna il file delle statistiche
	 */
	private void aggiornaFile(){
		FileOutput.creaFile(statistica.sintetico(), percorsoFile);
	}
}
