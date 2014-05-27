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

public class CreatoreXML {

	public CreatoreXML(String file) {
		try {
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

			// root elements
			Document doc = docBuilder.newDocument();
			doc.setXmlStandalone(true);

			Element radice = doc.createElement("giocatori");
			doc.appendChild(radice);

			Element giocatore = doc.createElement("giocatore");
			radice.appendChild(giocatore);

			Attr attr = doc.createAttribute("nome");
			attr.setValue("");
			giocatore.setAttributeNode(attr);

			Element sequenzaTris = doc.createElement("sequenzaTris");
			sequenzaTris.appendChild(doc.createTextNode(""));
			giocatore.appendChild(sequenzaTris);

			Element sequenzaForza4 = doc.createElement("sequenzaForza4");
			sequenzaForza4.appendChild(doc.createTextNode(""));
			giocatore.appendChild(sequenzaForza4);

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
