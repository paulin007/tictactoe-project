/**
 * Questa classe ha la reponsabilità di gestire il pannello che contiene le Statistiche del giocatore
 * @author Giacomo
 */
package utils.componenti;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;
import javax.swing.JTextArea;

import statistiche.CaricamentoFile;
import statistiche.InterpreteStatistiche;

public class PannelloStatistica extends JPanel implements Observer {
	
	private JTextArea area = new JTextArea();
	private CaricamentoFile caricamentoFile;
	private static String percorsoFile = "./src/StatisticaProva.txt";

	public PannelloStatistica(InterpreteStatistiche interpreteStatistiche) {
		super();
		caricamentoFile = new CaricamentoFile();
		caricamentoFile.setNomeFile(percorsoFile);
		interpreteStatistiche.statisticheDaFile(caricamentoFile.getList().get(0));
		area.setText(interpreteStatistiche.getStatistica().toString());
		add(area);
		
	}
	
	@Override
	public void update(Observable o, Object arg) {
		
	}
}
