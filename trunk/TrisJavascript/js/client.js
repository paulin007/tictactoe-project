/**
 * Questo file js si occupa di inviare un pacchetto al server Java all'indirizzo ws://localhost:45454
 *
 * @author Marco Vanzulli
 */

var webSocket;
var firstPlayerName;
var secondPlayerName;
var matchID;
var matchStatus;
var moves = new Array(9);
var myTurn = false;
var lastPlayer;
var myPlayer;
var otherPlayer;
var matchEnded = false;

function createConnection() {
	
	webSocket = new WebSocket("ws://localhost:45454");

	webSocket.onopen = function(message) {
		processOpen(message);
	};

	webSocket.onmessage = function(message) {
		processMessage(message);
	};

	webSocket.onclose = function(message) {
		processClose(message);
	};

	webSocket.onerror = function(message) {
		processError(message);
	};
	
};

function clicBox(id) {
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

function requestUpdate() {
	if (matchEnded == false) {
		string = "update/" + matchID;
		webSocket.send(string);
	}
}

function getFirstPlayerName() {
	firstPlayerName = document.getElementById('player1name').options[document.getElementById('player1name').selectedIndex].text;
	return firstPlayerName;
};

function getSecondPlayerName() {
	secondPlayerName = document.getElementById('player2name').options[document.getElementById('player2name').selectedIndex].text;
	return secondPlayerName;
};

function sendNewMatch() {
	resetTable();
	myPlayer = "G1";
	otherPlayer = "G2";
	webSocket.send("nuova partita/" + getFirstPlayerName() + "/" + getSecondPlayerName());
};

function connectToMatch() {
	myPlayer = "G2";
	otherPlayer = "G1";
	webSocket.send("collegati a/" + getSecondPlayerName() + "/" + getFirstPlayerName());
	setInterval(function() {
		requestUpdate();
	}, 1000);
};

function processOpen(message) {
};

function processMessage(message) {
	matchID = message.data.split("	",13)[1];
	matchStatus = message.data.split("	",13)[2];
	lastPlayer = message.data.split("	",13)[3];
	for (var i = 0; i < moves.length; i++) {
		moves[i] = message.data.split(" ",13)[i + 1];
	};
	checkResult();
	paint(moves);
	return lastPlayer, matchStatus;
};

function paint(moves) {
	for (var i = 0; i < moves.length; i++) {
		if (moves[i] == "G1") {
			setX(i);
		} else if (moves[i] == "G2") {
			setO(i);
		}
		;
	};
}

function checkResult() {
	if (matchStatus != "inCorso") {
		if (matchStatus == "Pareggio") {
			alert("Pareggio!");
			matchEnded = true;
		} else if (matchStatus == myPlayer) {
			alert("Hai vinto!");
			matchEnded = true;
		} else if(matchStatus == otherPlayer){
			alert("Hai perso!");
			matchEnded = true;
		}
	};
}

function resetTable(){
	for (var i=0; i < 9; i++) {
	  document.getElementById(i).src = "./img/blankpage.jpg";
	};
}

function processClose(message) {
	webSocket.send("** Client disconnesso **" + "\n");
};

function processError(message) {
};

