/**
 * Questo js implementa tutte le funzioni e gli attributi per gestire il gioco TicTacToe
 *
 * @author: Marco Vanzulli
 */

function myMove(id) {
	if (getPartita().myPlayer != getPartita().lastPlayer && getPartita().ended == false) {
		string = "mossa/" + getPartita().matchID + "/" + getPartita().myPlayer + "/" + id;
		getWebSocket().send(string);
		setInterval(function() {
			requestUpdate();
		}, 5000);
	};
}

function opponentMove(id) {
	setO(id);
	setInterval(function() {
		requestUpdate();
	}, 5000);
}

function setX(id) {
	document.getElementById(id).src = './img/X.png';
}

function setO(id) {
	document.getElementById(id).src = './img/O.png';
}

function paint(moves) {
	for (var i = 0; i < moves.length; i++) {
		if (moves[i] == "G1") {
			setX(i);
		} else if (moves[i] == "G2") {
			setO(i);
		}
	}
}