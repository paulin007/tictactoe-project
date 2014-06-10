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
/**
 * Creatore di file xml che viene istanziato solamente se l'xml non esiste.
 */
public class XMLCreator {

	public XMLCreator(String file) {
		try {
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

			// root elements
			Document doc = docBuilder.newDocument();
			doc.setXmlStandalone(true);

			Element root = doc.createElement("giocatori");
			doc.appendChild(root);

			Element player = doc.createElement("giocatore");
			root.appendChild(player);

			Attr attr = doc.createAttribute("nome");
			attr.setValue("");
			player.setAttributeNode(attr);

			Element trisSequence = doc.createElement("sequenzaTris");
			trisSequence.appendChild(doc.createTextNode(""));
			player.appendChild(trisSequence);

			Element forza4Sequence = doc.createElement("sequenzaForza4");
			forza4Sequence.appendChild(doc.createTextNode(""));
			player.appendChild(forza4Sequence);

			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();

			doc.getDocumentElement().normalize();

			DOMSource source = new DOMSource(doc);

			StreamResult result = new StreamResult(new File(file));
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
			transformer.transform(source, result);

		} catch (Exception e) {
			System.err.println("Creazione file non riuscita");
		}
	}

}
