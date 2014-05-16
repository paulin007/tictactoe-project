package paulin.tchonin.trisandroid1;

import java.util.Random;

import rete.Client;

public class TicTacToeOnline {

	private char mBoard[];
	private final static int BOARD_SIZE = 9;

	public final static char PLAYER1 = 'X';
	public final static char PLAYER2 = '0';
	public final static char EMPTY_SPACE = ' ';



	// private Client client = new Client() ;
	
	
	
	public static int getBOARD_SIZE() {
		return BOARD_SIZE;
	}

	public TicTacToeOnline() {

		mBoard = new char[BOARD_SIZE];

		for (int i = 0; i < BOARD_SIZE; i++)
			mBoard[i] = EMPTY_SPACE;

		
	}

	/*
	 * per pulire la tabella 
	 */
	public void clearBoard() {
		//ok
		for (int i = 0; i < BOARD_SIZE; i++) {
			mBoard[i] = EMPTY_SPACE;
		}
	}


	

	 /*
	  * Non mi serve 
	  */
	public int getPlayer2Move() {
		//ok
		int move=1;
         
		// nel caso giocasse android , vincerebbe se giocasse 
		// alla posizione i ? se si ritorniamo i;
		for (int i = 0; i < getBOARD_SIZE(); i++) {
		// verifichiamo che nessuno abbia giocato alla posizione iesima della tabella 
			if (mBoard[i] != PLAYER1 && mBoard[i] != PLAYER2) {
				char curr = mBoard[i];
				mBoard[i] = PLAYER2;
		
				if (checkForWinner() == 3) {
				//	setMove(PLAYER2, i);
					return i;
				} else
					mBoard[i] = curr;
			}
		}

		
        
		//setMove(PLAYER2, move);
		return move;
	}
	
	/*
	 *  ritorna 3 = vince android
	 *  ritorna 2 = vince l'umano.
	 *  ritorna 1 = pareggio
	 *  ritorna 0 = c'è ancora una casella vuota 
	 */

	// non mi server 
	public int checkForWinner() {
		//ricerca di un vincitore orizzontale
		

		return 0;
	}

}
