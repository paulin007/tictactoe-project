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
	analyzeMessage(message.data);
}

function processError(message) {
}

