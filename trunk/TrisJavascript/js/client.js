/**
 * Questo file js si occupa di inviare un pacchetto al server Java all'indirizzo ws://localhost:45454
 *
 * @author Marco Vanzulli
 */

var webSocket;
var firstPlayerName;
var secondPlayerName;
var idPartita;

function connetti() {
	webSocket = new WebSocket("ws://localhost:45454/");

	webSocket.onopen = function(message) {
		processOpen(message);
	};

	webSocket.onmessage = function(message) {
		processMessage(message);
	};

	webSocket.onclose = function(message) {
		processClose(message);
	};
}

function processMessage(message) {
	idPartita = message.data.split("	",2)[1];
	document.getElementById("logArea").value += "idPartita: " + idPartita + "\n";
}

function processOpen(message) {
	//alert("connessione al server");
};

function processClose(message) {
	webSocket.send("client disconnesso");
};

function sendNewMatch() {
	firstPlayerName = document.getElementById('player1name').options[document.getElementById('player1name').selectedIndex].text;
	secondPlayerName = document.getElementById('player2name').options[document.getElementById('player2name').selectedIndex].text;
	webSocket.send("nuova partita/" + firstPlayerName + "/" + secondPlayerName);
};