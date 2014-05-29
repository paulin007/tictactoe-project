package paulin.tchonin.trisandroid1;

import java.util.ArrayList;
import java.util.Timer;

/**
 * si occupa della gestione dell'interfaccia grafica
 * @author Paulin
 *
 */
public class UIManager {

	public final static char PLAYER1 = 'X';
	public final static char PLAYER2 = '0';
	private String lastPlayer;
	private static boolean myTurn = false;
	private ArrayList<String> caselle;
	private static Timer timer = new Timer();
	private static boolean launchTimer = true;
	private static String simboloGiocatore1 = "G1";
	private static String simboloGiocatore2 = "G2";

	public UIManager() {
		super();
	}
	
//	public void updateTable() {
////		this.caselle = ClientAndroid.getCaselle();
//		for (int i = 0; i < caselle.size(); i++) {
//			if (caselle.get(i).equals("G1")) {
//				setMove(PLAYER1, i);
//			} else if (caselle.get(i).equals("G2")) {
//				setMove(PLAYER2, i);
//			}
//		}

//		lastPlayer = ClientAndroid.getLastPlayer();

//		handleTurn();
//
//	}

   /**
    * si occupa della gestione dei turni
    */
	private void handleTurn() {
		if (lastPlayer.equals(simboloGiocatore2)) {
			setMyTurn(true);
//			ActivityOnline.getInfoTextView().setText(R.string.turn_player1);
		}

		if (lastPlayer.equals(simboloGiocatore1)) {
			setMyTurn(false);
//			ActivityOnline.getInfoTextView().setText(R.string.turn_player2);

		}

		if (ActivityOnline.isConnected()
				&& lastPlayer.equals(simboloGiocatore2)) {
//			ActivityOnline.getInfoTextView().setText(R.string.turn_player2);
			setMyTurn(false);
		}

		if (ActivityOnline.isConnected()
				&& lastPlayer.equals(simboloGiocatore1)) {
//			ActivityOnline.getInfoTextView().setText(R.string.turn_player1);
			setMyTurn(true);
		}

//		checkForWinner();
	}

	//TODO estrarre controllo
//	public void checkForWinner() {
//		if (ClientAndroid.getMatchStatus().equalsIgnoreCase(
//				UIManager.getSimboloGiocatore1())) {
//			ActivityOnline.getInfoTextView().setText(
//					R.string.result_player1_wins);
//			if (ActivityOnline.isConnected()) {
//				ActivityOnline.getInfoTextView().setText(
//						R.string.result_player2_wins);
//			}
//			getTimer().cancel();
//		} else if (ClientAndroid.getMatchStatus().equalsIgnoreCase(
//				UIManager.getSimboloGiocatore2())) {
//			ActivityOnline.getInfoTextView().setText(
//					R.string.result_player2_wins);
//			if (ActivityOnline.isConnected()) {
//				ActivityOnline.getInfoTextView().setText(
//						R.string.result_player1_wins);
//			}
//			getTimer().cancel();
//		} else if (ClientAndroid.getMatchStatus().equalsIgnoreCase("Pareggio")) {Ø
//			ActivityOnline.getInfoTextView().setText(R.string.result_tie);
//			getTimer().cancel();
//		}
//	}
//	
	//TODO estrarre controllo
//	private void setMove(char player, int location) {
//
//		boardButtons[location].setEnabled(false);
//		boardButtons[location].setText(String.valueOf(player));
//
//		if (player == PLAYER1)
//			boardButtons[location].setTextColor(Color.GREEN);
//		else
//			boardButtons[location].setTextColor(Color.RED);
//	}

	//TODO estrarre controllo
	public static void setMyTurn(boolean myTurn) {
		UIManager.myTurn = myTurn;
	}

	//TODO estrarre controllo
	public static boolean isMyTurn() {
		return myTurn;
	}

	//TODO estrarre controllo
	public Timer getTimer() {
		return timer;
	}

	//TODO estrarre controllo
	public static void setLaunchTimer(boolean launchTimer) {
		UIManager.launchTimer = launchTimer;
	}

	//TODO estrarre controllo
	public static boolean isLaunchTimer() {
		return launchTimer;
	}

	public static String getSimboloGiocatore1() {
		return simboloGiocatore1;
	}

	public static String getSimboloGiocatore2() {
		return simboloGiocatore2;
	}

}
