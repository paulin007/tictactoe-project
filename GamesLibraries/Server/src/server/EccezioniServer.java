package server;

import java.util.StringTokenizer;

public class EccezioniServer extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1000L;

	public EccezioniServer(String TipoEccezione, StringTokenizer s){
		
		System.err.println("SERVER> "+TipoEccezione+" \n"+s.toString());
		
	}

}
