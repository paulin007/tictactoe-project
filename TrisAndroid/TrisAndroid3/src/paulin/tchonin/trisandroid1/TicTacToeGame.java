package paulin.tchonin.trisandroid1;

import java.util.Random;

public class TicTacToeGame {

	private char mBoard[];
	private final static int BOARD_SIZE = 9;

	public final static char HUMAN_PLAYER = 'X';
	public final static char ANDROID_PLAYER = '0';
	public final static char EMPTY_SPACE = ' ';

	private Random mRand;

	public static int getBOARD_SIZE() {
		return BOARD_SIZE;
	}

	public TicTacToeGame() {

		mBoard = new char[BOARD_SIZE];

		for (int i = 0; i < BOARD_SIZE; i++)
			mBoard[i] = EMPTY_SPACE;

		mRand = new Random();
	}

	/*
	 * per pulire la tabella 
	 */
	public void clearBoard() {
		for (int i = 0; i < BOARD_SIZE; i++) {
			mBoard[i] = EMPTY_SPACE;
		}
	}

	/*
	 * per sapere chi ha giocato e dove ha giocato,
	 * il player sarà o X per HUMAN_PLAYER o 0 per ANDROID_PLAYER
	 */
	public void setMove(char player, int location) {
		mBoard[location] = player;
	}

	 /*
	  * mosse del computer 
	  */
	public int getComputerMove() {
		int move;
         
		// nel caso giocasse android , vincerebbe se giocasse 
		// alla posizione i ? se si ritorniamo i;
		for (int i = 0; i < getBOARD_SIZE(); i++) {
		// verifichiamo che nessuno abbia giocato alla posizione iesima della tabella 
			if (mBoard[i] != HUMAN_PLAYER && mBoard[i] != ANDROID_PLAYER) {
				char curr = mBoard[i];
				mBoard[i] = ANDROID_PLAYER;
		
				if (checkForWinner() == 3) {
					setMove(ANDROID_PLAYER, i);
					return i;
				} else
					mBoard[i] = curr;
			}
		}

		// nel caso giocasse l'umano vincerebbe se giocasse
		// nella posizione i ? se si allora android deve giocare in quella posizione
		for (int i = 0; i < getBOARD_SIZE(); i++) {
			if (mBoard[i] != HUMAN_PLAYER && mBoard[i] != ANDROID_PLAYER) {
				char curr = mBoard[i];
				mBoard[i] = HUMAN_PLAYER;
				if (checkForWinner() == 2) {
					setMove(ANDROID_PLAYER, i);
					return i;
				} else
					mBoard[i] = curr;
			}
		}
		
		/*
		 * nel caso non trovassimo una posizione farevole con i 
		 * 2 for precedenti, generiamo una posizione casuale per android
		 * controllando sempre se quella posizione non è già stata giocata.
		 */

		do {
			move = mRand.nextInt(getBOARD_SIZE());
		} while (mBoard[move] == HUMAN_PLAYER || mBoard[move] == ANDROID_PLAYER);

		setMove(ANDROID_PLAYER, move);
		return move;
	}
	
	/*
	 *  ritorna 3 = vince android
	 *  ritorna 2 = vince l'umano.
	 *  ritorna 1 = pareggio
	 *  ritorna 0 = c'è ancora una casella vuota 
	 */

	public int checkForWinner() {
		//ricerca di un vincitore orizzontale
		for (int i = 0; i <= 6; i += 3) {
			if (mBoard[i] == HUMAN_PLAYER     && 
				mBoard[i + 1] == HUMAN_PLAYER && 
				mBoard[i + 2] == HUMAN_PLAYER)
				return 2;
			if (mBoard[i] == ANDROID_PLAYER     && 
				mBoard[i + 1] == ANDROID_PLAYER && 
				mBoard[i + 2] == ANDROID_PLAYER)
				return 3;
		}
        // ricerca di un vincitore horizzontale
		for (int i = 0; i <= 2; i++) {
			if (mBoard[i] == HUMAN_PLAYER     && 
				mBoard[i + 3] == HUMAN_PLAYER &&
				mBoard[i + 6] == HUMAN_PLAYER)
				return 2;
			if (mBoard[i] == ANDROID_PLAYER     &&
				mBoard[i + 3] == ANDROID_PLAYER &&
				mBoard[i + 6] == ANDROID_PLAYER)
				return 3;
		}
		
		// ricerca di un vincitore diagonale
		if ((mBoard[0] == HUMAN_PLAYER &&
			mBoard[4] == HUMAN_PLAYER  && 
			mBoard[8] == HUMAN_PLAYER) ||
			mBoard[2] == HUMAN_PLAYER  && 
			mBoard[4] == HUMAN_PLAYER  &&
			mBoard[6] == HUMAN_PLAYER)
			return 2;
		if ((mBoard[0] == ANDROID_PLAYER &&
			 mBoard[4] == ANDROID_PLAYER && 
			 mBoard[8] == ANDROID_PLAYER)||
			 mBoard[2] == ANDROID_PLAYER &&
			 mBoard[4] == ANDROID_PLAYER &&
			 mBoard[6] == ANDROID_PLAYER)
			return 3;

		for (int i = 0; i < getBOARD_SIZE(); i++) {
			if (mBoard[i] != HUMAN_PLAYER && 
				mBoard[i] != ANDROID_PLAYER)
				return 0;
		}

		return 1;
	}

}
