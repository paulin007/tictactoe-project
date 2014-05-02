/**
 * Questa classe ha la responsabilità di creare un file con una sola riga di testo
 * @author Giacomo
 */
package statistiche;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class FileOutput {
	/**
	 * Questo metodo permette di creare un File, contentente una riga di testo
	 * @param testo
	 * @param nomeFile
	 */
	public static void creaFile(
			String testo, String nomeFile) {
		try {
				Writer writer=new FileWriter(new File(nomeFile));
				writer.write(testo);
				writer.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
	}

}
