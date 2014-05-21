package server;

import java.util.StringTokenizer;

public class Eccezioni extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1000L;

	public Eccezioni(String TipoEccezione, StringTokenizer s){
		
		System.err.println("SERVER> "+TipoEccezione+" \n"+s.toString());
		
	}

}
