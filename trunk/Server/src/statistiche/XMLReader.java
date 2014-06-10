package statistiche;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
/**
 * Questa classe ha la responsabilità  di leggere un file XML e fornire gli achievements 
 * di un giocatore in un particolare gioco
 */
public class XMLReader {

	public String read(File file, String player, String game) {

		String results = "";
		String returns = "";

		try {

			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(file);

			int size = doc.getElementsByTagName("giocatore").getLength();
			
			for (int i = 0; i < size; i++) {
				Node player1 = doc.getElementsByTagName("giocatore").item(i);
				
				NodeList nodes = player1.getChildNodes();
				
				String gamer = player1.getAttributes().getNamedItem("nome").getTextContent();
				if(player.equalsIgnoreCase(gamer))
				for (int j = 0; j < nodes.getLength(); j++) {

					Node element = nodes.item(j);
					if ("sequenzaTris".equals(element.getNodeName()) && game.equalsIgnoreCase("tris")) 
						results = element.getTextContent();
					
					if ("sequenzaForza4".equals(element.getNodeName()) && game.equalsIgnoreCase("forza4")) 
						results = element.getTextContent();
				}
				
				int wins = 0;
				int loses = 0;
				int draw = 0;

				
				for (int j = 0; j < results.length(); j++) {
					if(results.charAt(j)=='V')
						wins++;
					
				}

				
				for (int j = 0; j < results.length(); j++) {
					if(results.charAt(j)=='S')
						loses++;
					
				}				
				
				for (int j = 0; j < results.length(); j++) {
					if(results.charAt(j)=='P')
						draw++;
					
				}
				returns = wins+" "+draw+" "+loses+" ";

			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		MultipleWins multipleWins = new MultipleWins();
		ConsecutiveWins consecutiveWins = new ConsecutiveWins();
		
		if(multipleWins.gotAchievements(results, 3))
			returns += "@3 Vittorie!";
		if(multipleWins.gotAchievements(results, 5))
			returns += "@5 Vittorie!";
		if(multipleWins.gotAchievements(results, 10))
			returns += "@10 Vittorie!";
		if(consecutiveWins.gotAchievements(results, 3))
			returns += "@3 Vittorie Consecutive!";
		if(consecutiveWins.gotAchievements(results, 5))
			returns += "@5 Vittorie Consecutive!";
		
		return returns;
	}

}
