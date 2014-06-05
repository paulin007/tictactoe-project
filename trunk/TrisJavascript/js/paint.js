/**
 * @author Marco Vanzulli
 */

function paint(moves) {
	for (var i = 0; i < moves.length; i++) {
		if (moves[i] == "G1") {
			setIconA(i);
		} else if (moves[i] == "G2") {
			setIconB(i);
		}
	}
}

function setIconA(id) {
	if (getGameName().toLowerCase() == TicTacToe().toLowerCase()) {
		setX(id);
		// }else if (getGameName == FourInARow()) {
		// setIconA =
		// };
	}
}

function setIconB(id) {
	if (getGameName().toLowerCase() == TicTacToe().toLowerCase()) {
		setO(id);
		// }else if (getGameName == FourInARow()) {
		// setIconA =
		// };
	}
}