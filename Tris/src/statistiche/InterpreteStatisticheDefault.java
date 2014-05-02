/**
 * Questa classe ha la responsabilità di interpretare una stringa di testo in una {@link Statistica}
 * Qualora dovesse cambiare il formato, occorre modificare questa classe.
 * @author Giacomo
 */
package statistiche;

import java.util.StringTokenizer;

public class InterpreteStatisticheDefault implements InterpreteStatistiche {
	
	private Statistica statistica;
	
	@Override
	public void statisticheDaFile(String testoStatistica) {
		StringTokenizer stringTokenizer = new StringTokenizer(testoStatistica);
		int vittorie = Integer.valueOf(stringTokenizer.nextToken());
		int pareggi = Integer.valueOf(stringTokenizer.nextToken());
		int sconfitte = Integer.valueOf(stringTokenizer.nextToken());
		statistica = new Statistica(vittorie, pareggi, sconfitte);
		
	}
	
	@Override
	public Statistica getStatistica() {
		return statistica;
	}

}
