package statistiche;

import java.io.File;

public class XMLManager implements IXMLManager {

	File file;
	CreatoreXML crea;
	ScriviXML scrittore;
	LeggiXML lettore;

	public XMLManager() {
		file = new File("risultati.xml");
		scrittore = new ScriviXML();
		lettore = new LeggiXML();
		
		if (!file.exists())
			 crea = new CreatoreXML("risultati.xml");

	}

	@Override
	public String richiediStatistica(String giocatore, String gioco) {
		String lettura = lettore.leggi(file, giocatore, gioco);
		return lettura;
	}

	@Override
	public void nuovaStatistica(String giocatore, String esito, String gioco) {
		scrittore.scrivi(file, gioco, giocatore, esito);
	}

}
