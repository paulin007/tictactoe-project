package forza4Gui;

public class PosizioneSimbolo {
	
	
	public static int SPAZIO_VERTICALE = 55;
	
	public static int SPAZIO_INIZIALE = 156;
	public static int SETTE = 7;
	public static int PRIMA_COLONNA = 149;
	public static int OFFSET = 10;
	/**
	 * Questo metodo permette di ottenere il valore di X, dato il nuemro della casella
	 * @param casella
	 * @return
	 */
	public static int casellaToX(int casella){
		return (casella%SETTE)*SPAZIO_VERTICALE+PRIMA_COLONNA-OFFSET;
	}
	/**
	 * Questo metodo permette di ottenere il valore di Y, dato il numero della casella
	 * @param casella
	 * @return
	 */
	public static int casellaToY(int casella){
		return ((int)casella/SETTE)*SPAZIO_VERTICALE+SPAZIO_INIZIALE;
	}
}
