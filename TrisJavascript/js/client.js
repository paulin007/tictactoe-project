/**
 * Questo js si occupa di scambiare messaggi con il server Java all'indirizzo ws://localhost:45454.
 * Per giocare in rete basta sostituire a "localhost" l'indirizzo ip del Server
 *
 * @author Marco Vanzulli
 */

var client_match;

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

	getWebSocket = function() {
		return webSocket;
	};
}

function processOpen(message) {
}

function processMessage(message) {
	analyzeMessage(message.data);	
}

function processError(message) {
}

function sendNewMatch() {
	client_match = new Match(getGameName(),"nuova");
	getWebSocket().send("nuova partita/" + getFirstPlayerName() + "/" + getSecondPlayerName() + "/tris");
}

function connectToMatch() {
	client_match = new Match("tris","esistente");
	getWebSocket().send("collegati a/" + getSecondPlayerName() + "/" + getFirstPlayerName());
	setInterval(function() {
		requestUpdate();
	}, 5000);

}

function requestUpdate() {
	if (getMatch().matchStatus == "inCorso") {
		string = "update/" + getMatch().matchID;
		getWebSocket().send(string);
	}
}

function requestAchievements() {
	var string;
	string = "statistiche/" + getPlayerName() + "/" + getGameName();
	getWebSocket().send(string);
}

function getMatch(){
	return client_match;
}