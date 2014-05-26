package statistiche;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;

/**
 * Bridge
 * Responsabilità: Gestione del fileXML
 * 
 * @author K. Adjignon
 */
public class XMLManager {
	
	private IXMLManager dataManager;
	
	public XMLManager(IXMLManager dataManager) {
		super();
		this.dataManager = dataManager;
	}

	public void loadData(Repository repo) {
		dataManager.loadFile(repo);
	}
	
	public void storeData(Repository repo) {
		
		try {
			
			OutputStreamWriter writer = new OutputStreamWriter(
					new FileOutputStream("xmlFile/playersAchievement.xml"), 
					Charset.forName("UTF-8").newEncoder());
			
			dataManager.writeData(new StringWriter(writer), repo);
			
			writer.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
