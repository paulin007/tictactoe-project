/**
 * Questa classe ha la reponsabilità di gestire il pannello che contiene le Statistiche del giocatore
 * @author Giacomo
 */
package interfacciaGrafica;


import javax.swing.JPanel;
import javax.swing.JTextArea;

import statistiche.CaricamentoFile;
import statistiche.InterpreteStatistiche;

public class PannelloStatistica extends JPanel implements PannelloTris {
	
	private JTextArea area = new JTextArea();
	private CaricamentoFile caricamentoFile;
	private static String percorsoFile = "./src/StatisticaProva.txt";
	private InterpreteStatistiche interpreteStatistiche;

	public PannelloStatistica(InterpreteStatistiche interpreteStatistiche) {
		super();
		this.interpreteStatistiche = interpreteStatistiche;
		
		
	}
	
	@Override
	public JPanel creaPannello() {
		caricamentoFile = new CaricamentoFile();
		caricamentoFile.setNomeFile(percorsoFile);
		interpreteStatistiche.statisticheDaFile(caricamentoFile.getList().get(0));
		area.setText(interpreteStatistiche.getStatistica().toString());
		add(area);
		return this;
	}
}
