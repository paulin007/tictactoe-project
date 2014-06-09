/**
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

function setTurn(match){
	if (match.lastPlayer == match.myPlayer) {
		opponentTurn();
	} else{
		myTurn();
	};
}
