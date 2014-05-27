package statistiche;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class LeggiXML {

	public String leggi(File file, String giocatore, String gioco) {

		String risultato = "";
		String ritorno = "";

		try {

			DocumentBuilderFactory dbFactory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(file);

			int size = doc.getElementsByTagName("giocatore").getLength();
			
			for (int i = 0; i < size; i++) {
				Node giocatore1 = doc.getElementsByTagName("giocatore").item(i);
				
				NodeList nodes = giocatore1.getChildNodes();
				
				String gioc = giocatore1.getAttributes().getNamedItem("nome").getTextContent();
				if(giocatore.equalsIgnoreCase(gioc))
				for (int j = 0; j < nodes.getLength(); j++) {

					Node element = nodes.item(j);
					if ("sequenzaTris".equals(element.getNodeName()) && gioco.equalsIgnoreCase("tris")) 
						risultato = element.getTextContent();
					
					if ("sequenzaForza4".equals(element.getNodeName()) && gioco.equalsIgnoreCase("forza4")) 
						risultato = element.getTextContent();
				}
				
				int vittorie = 0;
				int sconfitte = 0;
				int pareggi = 0;

				
				for (int j = 0; j < risultato.length(); j++) {
					if(risultato.charAt(j)=='V')
						vittorie++;
					
				}

				
				for (int j = 0; j < risultato.length(); j++) {
					if(risultato.charAt(j)=='S')
						sconfitte++;
					
				}				
				
				for (int j = 0; j < risultato.length(); j++) {
					if(risultato.charAt(j)=='P')
						pareggi++;
					
				}
				ritorno = vittorie+" "+sconfitte+" "+pareggi;

			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		VittorieMultiple vittm = new VittorieMultiple();
		VittorieConsecutive vittc = new VittorieConsecutive();
		
		if(vittm.haConquistatoRisultato(risultato, 3))
			ritorno += "@3 Vittorie!";
		if(vittm.haConquistatoRisultato(risultato, 5))
			ritorno += "@5 Vittorie!";
		if(vittm.haConquistatoRisultato(risultato, 10))
			ritorno += "@10 Vittorie!";
		if(vittc.haConquistatoRisultato(risultato, 3))
			ritorno += "@3 Vittorie Consecutive!";
		if(vittc.haConquistatoRisultato(risultato, 5))
			ritorno += "@5 Vittorie Consecutive!";
		
		return ritorno;
	}

}
