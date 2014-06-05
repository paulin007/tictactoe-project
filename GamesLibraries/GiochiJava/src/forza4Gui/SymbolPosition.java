package forza4Gui;

public class SymbolPosition {
public static int VERTICAL_SPACE = 55;
	
	public static int INITIAL_SPACE = 156;
	public static int COLUMNS_NUMBER = 7;
	public static int FIRST_COLUMN = 149;
	public static int OFFSET = 10;
	/**
	 * Questo metodo permette di ottenere il valore di X, dato il nuemro della casella
	 * @param box
	 * @return
	 */
	public static int boxToX(int box){
		return (box%COLUMNS_NUMBER)*VERTICAL_SPACE+FIRST_COLUMN-OFFSET;
	}
	/**
	 * Questo metodo permette di ottenere il valore di Y, dato il numero della casella
	 * @param box
	 * @return
	 */
	public static int boxToY(int box){
		return ((int)box/COLUMNS_NUMBER)*VERTICAL_SPACE+INITIAL_SPACE;
	}
}
