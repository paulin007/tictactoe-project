/**
 * Questo js si occupa di scambiare messaggi con il server Java all'indirizzo ws://localhost:45454.
 * Per giocare in rete basta sostituire a "localhost" l'indirizzo ip del Server
 *
 * @author Marco Vanzulli
 */

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
	tokenizer(message.data,getPartita());
}

function processError(message) {
}

function sendNewMatch() {
	nuovaPartita = new Partita();
	nuovaPartita.myPlayer = "G1";
	nuovaPartita.otherPlayer = "G2";
	getPartita = function(){
		return nuovaPartita;
	};
	getWebSocket().send("nuova partita/" + getFirstPlayerName() + "/" + getSecondPlayerName() + "/tris");
}

function connectToMatch() {
	connettiPartita = new Partita();
	connettiPartita.myPlayer = "G2";
	connettiPartita.otherPlayer = "G1"; 
	getPartita = function(){
		return connettiPartita;
	};
	getWebSocket().send("collegati a/" + getSecondPlayerName() + "/" + getFirstPlayerName());
	setInterval(function() {
		requestUpdate();
	}, 5000);

}

function requestUpdate() {
	if (getPartita()["matchStatus"] == "inCorso") {
		string = "update/" + getPartita()["matchID"];
		getWebSocket().send(string);
	}
}

function requestAchievements() {
	var string;
	string = "statistiche/" + getPlayerName() + "/" + getGameName();
	getWebSocket().send(string);
}