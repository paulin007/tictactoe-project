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
var nextPlayer;
var moves = new Array(9);
var myTurn = false;

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

// String.prototype.beginsWith = function(string) {
// return (this.indexOf(string) === 0);
// };

function clicCasella(id) {
	if (moves[id] == "null" && myTurn) {
		myTurn = false;
		document.getElementById(id).src = './img/X.png';
		string = "mossa/" + matchID + "/" + getFirstPlayerName() + "/" + id;
		webSocket.send(string);
		setInterval(function() {
			requestUpdate();
		}, 5000);
	};
}

function requestUpdate() {
	string = "update/" + matchID;
	webSocket.send(string);
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
	myTurn = true;
	webSocket.send("nuova partita/" + getFirstPlayerName() + "/" + getSecondPlayerName());
};

function connectToMatch() {
	myTurn = false;
	webSocket.send("collegati a/" + getFirstPlayerName() + "/" + getSecondPlayerName());
	setInterval(function() {
		requestUpdate();
	}, 5000);
};

function processOpen(message) {
	document.getElementById("logArea").value += "** Connessione al server **" + "\n";
};

function processMessage(message) {
	matchID = message.data.split("	",13)[1];
	matchStatus = message.data.split("	",13)[2];
	nextPlayer = message.data.split("	",13)[3];
	for (var i = 0; i < moves.length; i++) {
		moves[i] = message.data.split(" ",13)[i + 1];
	};
	// for (var i = 0; i < moves.length; i++) {
		// document.getElementById("logArea").value += "Mossa: " + moves[i] + "\n";
	// };
};

function processClose(message) {
	webSocket.send("** Client disconnesso **" + "\n");
};

function processError(message) {
	document.getElementById("logArea").value += "** Errore" + "**" + "\n";
};

