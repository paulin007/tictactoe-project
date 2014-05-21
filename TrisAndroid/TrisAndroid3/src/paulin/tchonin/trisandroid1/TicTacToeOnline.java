package paulin.tchonin.trisandroid1;


public class TicTacToeOnline {

	private char mBoard[];
	private final static int BOARD_SIZE = 9;

	public final static char PLAYER1 = 'X';
	public final static char PLAYER2 = '0';
	public final static char EMPTY_SPACE = ' ';



	
	
	
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

	public void setMove(char player, int location) {
		mBoard[location] = player;
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
	 *  ritorna 0 = c'� ancora una casella vuota 
	 */

	// non mi server 
	public int checkForWinner() {
		//ricerca di un vincitore orizzontale
		//ricerca di un vincitore orizzontale
		for (int i = 0; i <= 6; i += 3) {
			if (mBoard[i] == PLAYER1     && 
				mBoard[i + 1] == PLAYER1 && 
				mBoard[i + 2] == PLAYER1)
				return 2;
			if (mBoard[i] == PLAYER2     && 
				mBoard[i + 1] == PLAYER2 && 
				mBoard[i + 2] == PLAYER2)
				return 3;
		}
        // ricerca di un vincitore horizzontale
		for (int i = 0; i <= 2; i++) {
			if (mBoard[i] == PLAYER1     && 
				mBoard[i + 3] == PLAYER1 &&
				mBoard[i + 6] == PLAYER1)
				return 2;
			if (mBoard[i] == PLAYER2     &&
				mBoard[i + 3] == PLAYER2 &&
				mBoard[i + 6] == PLAYER2)
				return 3;
		}
		
		// ricerca di un vincitore diagonale
		if ((mBoard[0] == PLAYER1 &&
			mBoard[4] == PLAYER1  && 
			mBoard[8] == PLAYER1) ||
			mBoard[2] == PLAYER1  && 
			mBoard[4] == PLAYER1  &&
			mBoard[6] == PLAYER1)
			return 2;
		if ((mBoard[0] == PLAYER2 &&
			 mBoard[4] == PLAYER2 && 
			 mBoard[8] == PLAYER2)||
			 mBoard[2] == PLAYER2 &&
			 mBoard[4] == PLAYER2 &&
			 mBoard[6] == PLAYER2)
			return 3;

		for (int i = 0; i < getBOARD_SIZE(); i++) {
			if (mBoard[i] != PLAYER1 && 
				mBoard[i] != PLAYER2)
				return 0;
		}

		return 1;		

	}

}
