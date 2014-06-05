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

public class ScriviXML {

	boolean existed = false;

	public void scrivi(File file, String gioco, String nome, String esito) {

		try {

			existed = false;
			DocumentBuilderFactory docFactory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
			Document doc = docBuilder.parse(file);

			int size = doc.getElementsByTagName("giocatore").getLength();

			for (int i = 0; i < size; i++) {
				Node giocatore = doc.getElementsByTagName("giocatore").item(i);

				NodeList nodes = giocatore.getChildNodes();

				String gioc = giocatore.getAttributes().getNamedItem("nome")
						.getTextContent();
				if (nome.equalsIgnoreCase(gioc))
					for (int j = 0; j < nodes.getLength(); j++) {

						Node element = nodes.item(j);
						if ("sequenzaTris".equals(element.getNodeName())
								&& gioco.equalsIgnoreCase("tris"))
							element.setTextContent(element.getTextContent()
									+ esito);

						if ("sequenzaForza4".equals(element.getNodeName())
								&& gioco.equalsIgnoreCase("forza4"))
							element.setTextContent(element.getTextContent()
									+ esito);

						existed = true;

					}

			}

			if (!existed) {

				Node radice = doc.getElementsByTagName("giocatori").item(0);

				Element giocatore = doc.createElement("giocatore");
				radice.appendChild(giocatore);

				Attr attr = doc.createAttribute("nome");
				attr.setValue(nome);
				giocatore.setAttributeNode(attr);

				Element sequenzaTris = doc.createElement("sequenzaTris");
				giocatore.appendChild(sequenzaTris);
				if (gioco.equalsIgnoreCase("tris")) {
					sequenzaTris.appendChild(doc.createTextNode(esito));
				} else
					sequenzaTris.appendChild(doc.createTextNode(""));

				Element sequenzaForza4 = doc.createElement("sequenzaForza4");
				giocatore.appendChild(sequenzaForza4);
				if (gioco.equalsIgnoreCase("forza4")) {
					sequenzaForza4.appendChild(doc.createTextNode(esito));
				} else
					sequenzaTris.appendChild(doc.createTextNode(""));

				existed = true;

			}

			// write the content into xml file
			TransformerFactory transformerFactory = TransformerFactory
					.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(file);
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.setOutputProperty(
					"{http://xml.apache.org/xslt}indent-amount", "2");

			transformer.transform(source, result);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}