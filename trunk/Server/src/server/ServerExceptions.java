package server;

import java.util.StringTokenizer;

public class ServerExceptions extends Exception{
	
	/**
	 * 	Gestore eccezioni del server. </br>
	 * 
	 */
	private static final long serialVersionUID = 1000L;

	public ServerExceptions(String TipoEccezione, StringTokenizer s){
		
		System.err.println("SERVER> "+TipoEccezione+" \n"+s.toString());
		
	}

}
