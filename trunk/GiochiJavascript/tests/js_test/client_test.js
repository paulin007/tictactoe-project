/**
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
	
	document.getElementById("messagesTextArea").value += 'Server Connect...' + '\n';
}

function processMessage(message) {
	document.getElementById("messagesTextArea").value +='Ricevuto dal server > ' + message.data + '\n';
	
}

function processClose(message) {
	webSocket.send("client disconnesso");
	document.getElementById("messagesTextArea").value += 'server disconnesso' + '\n';
}

function processError(message) {
	document.getElementById("messagesTextArea").value += 'errore' + '\n';
}