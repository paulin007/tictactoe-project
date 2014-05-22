/**
 * Questo js implementa tutte le funzioni e gli attributi per gestire il gioco TicTacToe
 *
 * @author: Marco Vanzulli
 */

var matchID;
var matchStatus;
var lastPlayer;
var myPlayer;
var otherPlayer;
var firstPlayerName;
var secondPlayerName;
var matchEnded = false;
var moves = new Array(9);

function tokenizer(message) {
	matchID = message.split("	",13)[1];
	matchStatus = message.split("	",13)[2];
	lastPlayer = message.split("	",13)[3];
	for (var i = 0; i < moves.length; i++) {
		moves[i] = message.split(" ",13)[i + 1];
	};
	checkResult();
	paint(moves);
	return matchID, matchStatus, lastPlayer;
}

function checkResult() {
	if (matchStatus != "inCorso") {
		if (matchStatus == "Pareggio") {
			matchEnded = true;
			setInterval(function() {
				alert("Pareggio!");
				window.location.reload();
			}, 3000);
		} else if (matchStatus == myPlayer) {
			matchEnded = true;
			setInterval(function() {
				alert("Hai vinto!");
				window.location.reload();
			}, 3000);
		} else if (matchStatus == otherPlayer) {
			matchEnded = true;
			setInterval(function() {
				alert("Hai perso!");
				window.location.reload();
			}, 3000);
		}
	};
}

function myMove(id) {
	if (myPlayer != lastPlayer && matchEnded == false) {
		string = "mossa/" + matchID + "/" + myPlayer + "/" + id;
		webSocket.send(string);
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

function getFirstPlayerName() {
	firstPlayerName = document.getElementById('player1name').options[document.getElementById('player1name').selectedIndex].text;
	return firstPlayerName;
}

function getSecondPlayerName() {
	secondPlayerName = document.getElementById('player2name').options[document.getElementById('player2name').selectedIndex].text;
	return secondPlayerName;
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