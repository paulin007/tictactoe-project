package statistiche;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
/**
 * Responsabilità: scrive o modifica un file Xml a seconda se esiste o no
 */
public class XMLWriter {

	boolean existed = false;

	public void write(File file, String game, String name, String score) {

		try {

			existed = false;
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
			Document doc = docBuilder.parse(file);

			int size = doc.getElementsByTagName("giocatore").getLength();

			for (int i = 0; i < size; i++) {
				Node player = doc.getElementsByTagName("giocatore").item(i);

				NodeList nodes = player.getChildNodes();

				String gamer = player.getAttributes().getNamedItem("nome").getTextContent();
				if (name.equalsIgnoreCase(gamer))
					for (int j = 0; j < nodes.getLength(); j++) {

						Node element = nodes.item(j);
						if ("sequenzaTris".equals(element.getNodeName()) && game.equalsIgnoreCase("tris"))
							element.setTextContent(element.getTextContent()+ score);

						if ("sequenzaForza4".equals(element.getNodeName())&& game.equalsIgnoreCase("forza4"))
							element.setTextContent(element.getTextContent()+ score);

						existed = true;

					}

			}

			if (!existed) {

				Node root = doc.getElementsByTagName("giocatori").item(0);

				Element player = doc.createElement("giocatore");
				root.appendChild(player);

				Attr attr = doc.createAttribute("nome");
				attr.setValue(name);
				player.setAttributeNode(attr);

				Element trisSequence = doc.createElement("sequenzaTris");
				player.appendChild(trisSequence);
				if (game.equalsIgnoreCase("tris")) {
					trisSequence.appendChild(doc.createTextNode(score));
				} else
					trisSequence.appendChild(doc.createTextNode(""));

				Element forza4Sequence = doc.createElement("sequenzaForza4");
				player.appendChild(forza4Sequence);
				if (game.equalsIgnoreCase("forza4")) {
					forza4Sequence.appendChild(doc.createTextNode(score));
				} else
					trisSequence.appendChild(doc.createTextNode(""));

				existed = true;

			}

			// write the content into xml file
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(file);
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");

			transformer.transform(source, result);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}