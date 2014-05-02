/**
 * Questa classe astrae sul concetto di interpreta una stringa e trasformarla in {@link Statistica}
 */
package statistiche;

import java.util.ArrayList;

public interface InterpreteStatistiche {
	/**
	 * Questo metodo permette di interpretare un {@link ArrayList} e trasformarlo in ogetti di tipo
	 * {@link Statistica}
	 * @param list
	 */
	public void statisticheDaFile(String testoStatistica);
	/**
	 * Questo metodo permette di recuperare le statistiche di un giocatore, dal file.
	 * @return
	 */
	public Statistica getStatistica();

}
