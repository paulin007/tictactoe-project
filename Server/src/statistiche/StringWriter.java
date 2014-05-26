package statistiche;

import java.io.IOException;
import java.io.Writer;

public class StringWriter {

	private Writer writer;
	
	public StringWriter(Writer writer) {
		super();
		this.writer = writer;
	}

	public void writeln(String message) throws IOException {
		writer.write(message+"\n");
	}
}
