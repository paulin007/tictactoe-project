/**
 * Questo js setta graficamente le label per la gestione del turno e dello svolgimento della partita
 *
 * @author Marco Vanzulli
 */

function myTurn() {
	var turn = document.getElementById("turn");
	var newText = "<span style='color:#00CC00'>" + "E' il tuo turno" + "</span>";
	turn.innerHTML = newText;
}

function opponentTurn() {
	var turn = document.getElementById("turn");
	var newText = "<span style='color:#CC3300'>" + "E' il turno avversario" + "</span>";
	turn.innerHTML = newText;
}

function setEndedLabel() {
	var turn = document.getElementById("turn");
	var newText = "<span style='color:#CC3300'>" + "Partita terminata" + "</span>";
	turn.innerHTML = newText;
}

function setTurn(match) {
	if (match.lastPlayer == match.myPlayer) {
		opponentTurn();
	} else if (match.lastPlayer == match.otherPlayer) {
		myTurn();
	}
}
