package server;

import java.util.ArrayList;
import java.util.StringTokenizer;

public interface IServizio {

	public abstract String effettuaServizio(StringTokenizer s, ArrayList<Partita> partite);
	
}
