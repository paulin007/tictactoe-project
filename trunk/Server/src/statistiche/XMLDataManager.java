package statistiche;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XMLDataManager implements IXMLManager{

	@Override
	public void writeData(StringWriter writer, Repository repo)
			throws IOException {
		
		writer.writeln("<players>");	
		for (String player : repo.getPlayersName()) {
			writeAchievement(writer, repo.getAchievement(player), player);
		}
		writer.writeln("</players>");
	}

	@Override
	public void loadFile(Repository repo) {

		File fileXml = new File("xmlFile/playersAchievement.xml");
		
		try {
			
			DocumentBuilderFactory dbfactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dbuilder = dbfactory.newDocumentBuilder();
			Document document = dbuilder.parse(fileXml);
			
			NodeList players = document.getElementsByTagName("player");
			
			for (int i = 0; i < players.getLength(); i++) {
				Element element = (Element)players.item(i);
				String player = element.getElementsByTagName("name").item(0).getTextContent();
				String sequence = element.getElementsByTagName("sequence").item(0).getTextContent();
				
				Achievement achievement = new Achievement(sequence);
				repo.addAchievement(player, achievement);
			}
			
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	private void writeAchievement(StringWriter writer, Achievement achievement, String player) throws IOException {
		writer.writeln("\t<player>");
		writer.writeln("\t\t<name>"+player+"</name>");
		writer.writeln("\t\t<sequence>"+achievement.getSequence()+"</sequence>");
		writer.writeln("\t</player>");
	}

}
