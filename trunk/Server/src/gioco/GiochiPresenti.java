package gioco;

import java.util.HashMap;

import forza4.AlgoritmoForza4;

import tris.AlgoritmoTris;

/**
 * Questa classe contiene la lista di tutti giochi che sono stati creati nel progetto
 * @author Giacomo
 */
public class GiochiPresenti {
	
	public static String tris = "tris";
	public static String forza4 = "Forza4";
	public static HashMap<String,  Algoritmo> mappaAlgoritmi;
	
	public static void caricaAlgoritmi(){
		mappaAlgoritmi = new HashMap<>();		
		mappaAlgoritmi.put(tris, new AlgoritmoTris());
		mappaAlgoritmi.put(forza4, new AlgoritmoForza4());
		
	}
	
	
	
}
