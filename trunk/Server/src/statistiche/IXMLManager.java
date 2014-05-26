package statistiche;

import java.io.IOException;

public interface IXMLManager {

	public void writeData(StringWriter writer, Repository repo) throws IOException;
	
	public void loadFile(Repository repo);
}
