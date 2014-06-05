package managers;

import java.util.HashMap;
/**
 * contiene i cammini di default di tutti gli immagini, i font e i suoni usati nel progetto
 * @author K. ADJIGNON
 */

public class DefaultSettings {
	
	private static DefaultSettings settings = new DefaultSettings();
	private HashMap<String, String> pathImmagini = new HashMap<String, String>();
		
	private DefaultSettings() {
	
	}
	
	public static DefaultSettings getSettings() {
		return settings;
	}
	
	public void caricaMappa() {
		
		pathImmagini.put("griglia", "/forza4Gui/Immagini/griglia.png");
		pathImmagini.put("forza4verticale", "/forza4Gui/Immagini/Forza4verticale.png");
		pathImmagini.put("pallaGialla", "/forza4Gui/Immagini/palla_gialla.png");
		pathImmagini.put("pallaRossa", "/forza4Gui/Immagini/palla_rossa.png");
		pathImmagini.put("croce", "/trisGui/Immagini/X.png");
		pathImmagini.put("cerchio", "/trisGui/Immagini/O.png");
		pathImmagini.put("logo", "/trisGui/Immagini/Logo.png");
		pathImmagini.put("indicatore1", "Immagini/indicatore1.png");
		pathImmagini.put("indicatore2", "Immagini/indicatore2.png");
		pathImmagini.put("sfondo2", "Immagini/Sfondo2.png");
		pathImmagini.put("akhenaton", "/grafica/Akhenaton.ttf");
		pathImmagini.put("applausi", "/suoni/applausi.wav");
		pathImmagini.put("nur", "/suoni/nur.wav");
	}
	
	public String getPath(String key){
		return pathImmagini.get(key);
	}
	
}
