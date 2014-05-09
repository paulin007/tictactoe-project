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
	private GestoreVincite gestoreVincite;
	private CaricamentoFile caricamentoFile = new CaricamentoFile();
	
	public AggiornaStatistica(GestoreVincite gestoreVincite) {
		this.gestoreVincite = gestoreVincite;
		gestoreVincite.addObserver(this);
		
		caricamentoFile.setNomeFile(percorsoFile);
	}
	
	private void caricaStatistica(){
		
		InterpreteStatisticheDefault interpreteStatisticheDefault = new InterpreteStatisticheDefault();
		interpreteStatisticheDefault.statisticheDaFile(caricamentoFile.getList().get(0));
		statistica = interpreteStatisticheDefault.getStatistica();
	}
	
	@Override
	public void update(Observable o, Object arg) {
		caricaStatistica();
		aggiornaStatistiche();
		aggiornaFile();
		
	}
	/**
	 * Questo metodo aggiorna le statistiche, a secondo di come è finita la partita
	 */
	private void aggiornaStatistiche(){
		
		boolean vincitaComputer = gestoreVincite.getVerificaVincita().haVintoG2();
		boolean vincitaGiocatore = gestoreVincite.getVerificaVincita().haVintoG1();
		boolean nessunoHaVinto = gestoreVincite.getVerificaVincita().nessunoHaVinto();
		
		if(vincitaComputer){
			statistica.aggiornaSconfitte();;
		}
		if(vincitaGiocatore){
			statistica.aggiornaVittorie();
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
