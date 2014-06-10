package managers;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
/**
 * Singleton
 * contiene i cammini di default di tutte le immagini, i font e i suoni usati nel progetto
 * @author K. ADJIGNON
 */

public class DefaultSettings {
	
	private static DefaultSettings settings = new DefaultSettings();
	private HashMap<String, String> paths = new HashMap<String, String>();
		
	private DefaultSettings() {
		loadMap();
	}
	
	/**
	 * restituisce l'unica istanza possibile della classe
	 * @return settings
	 */
	public static DefaultSettings getSettings() {
		return settings;
	}
	
	
	/**
	 * Carica la mappa mettendo tutti i percorsi delle immagini, dei font e dei suoni
	 */
	public void loadMap() {
		
		File filexml = new File("percorsi.xml");
		
		try {
			
			DocumentBuilderFactory dbfactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dbuilder = dbfactory.newDocumentBuilder();
			Document document = dbuilder.parse(filexml);
			
			NodeList list = document.getElementsByTagName("object");
			
			for (int i = 0; i < list.getLength(); i++) {
				Element element = (Element)list.item(i);
				String name = element.getAttribute("name");
				String path = element.getElementsByTagName("path").item(0).getTextContent();
				
				put(name, path);
			}
			
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * inserisce il percorso di un'immagine, font o suono nella mappa
	 * @param name Nome del file da inserire
	 * @param path del file associato
	 */
	public void put(String name, String path) {
		paths.put(name, path);
	}
	
	/**
	 * dato il nome di un immagine o suono o font, ritorna il suo percorso
	 * @param key Nome del file da ricercare
	 * @return path del file
	 */
	public String getPath(String key){
		return paths.get(key);
	}
	
}
