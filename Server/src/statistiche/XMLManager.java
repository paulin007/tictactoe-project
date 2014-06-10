package statistiche;

import java.io.File;
/**
 * Manager di un XML. Si occupa della corretta creazione ed assegnazione di un XML e della 
 * gestione della richiesta delle statistiche e dell'inserimento delle statistiche.
 */
public class XMLManager implements IXMLManager {

	File file;
	XMLCreator creator;
	XMLWriter writer;
	XMLReader reader;

	public XMLManager() {
		file = new File("risultati.xml");
		writer = new XMLWriter();
		reader = new XMLReader();
		
		if (!file.exists())
			 creator = new XMLCreator("risultati.xml");

	}

	@Override
	public String getStatistic(String player, String game) {
		String statistic = reader.read(file, player, game);
		return statistic;
	}

	@Override
	public void newStatistic(String player, String score, String game) {
		writer.write(file, game, player, score);
	}

}
