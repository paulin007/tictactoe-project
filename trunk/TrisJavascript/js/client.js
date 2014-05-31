/**
 * Questo js si occupa di scambiare messaggi con il server Java all'indirizzo ws://localhost:45454.
 * Per giocare in rete basta sostituire a "localhost" l'indirizzo ip del Server
 *
 * @author Marco Vanzulli
 */

var webSocket;

function createConnection() {

	webSocket = new WebSocket("ws://localhost:45454");

	webSocket.onopen = function(message) {
		processOpen(message);
	};

	webSocket.onmessage = function(message) {
		processMessage(message);
	};

	webSocket.onerror = function(message) {
		processError(message);
	};

}

function processOpen(message) {
}

function processMessage(message) {
	tokenizer(message.data);
}

function processError(message) {
}

function sendNewMatch() {
	myPlayer = "G1";
	otherPlayer = "G2";
	webSocket.send("nuova partita/" + getFirstPlayerName() + "/" + getSecondPlayerName() + "/tris");
}

function connectToMatch() {
	myPlayer = "G2";
	otherPlayer = "G1";
	webSocket.send("collegati a/" + getSecondPlayerName() + "/" + getFirstPlayerName());
	setInterval(function() {
		requestUpdate();
	}, 5000);

}

function requestUpdate() {
	if (matchEnded == false) {
		string = "update/" + matchID;
		webSocket.send(string);
	}
}
