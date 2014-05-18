/**
 * Questo file js si occupa di inviare un pacchetto al server Java all'indirizzo ws://localhost:45454
 *
 * @author Marco Vanzulli
 */

var webSocket;
var firstPlayerName;
var secondPlayerName;
var idPartita;

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

String.prototype.beginsWith = function (string) {
    return(this.indexOf(string) === 0);
};

function test(){
	//webSocket.send("mossa/0/Giacomo/1");
	alert(idPartita);
}

function clicCasella(numero){
	string = "mossa/"+idPartita+"/"+getFirstPlayerName()+"/"+numero;
	alert(string);
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
	webSocket.send("nuova partita/" + getFirstPlayerName() + "/" + getSecondPlayerName());
	//alert(idPartita);
};

function connectToMatch() {
	webSocket.send("collegati a/" + getFirstPlayerName() + "/" + getSecondPlayerName());
};

function processOpen(message) {
	document.getElementById("logArea").value += "** Connessione al server **"+"\n";
};

function processMessage(message) {
	//idPartita = parseInt(message.data.split("	",2)[1]);
	// alert(message.data);
	// document.getElementById("logArea").value += "** ID Partita: " + idPartita + "**"+"\n";
	//return idPartita;
	if (message.data.beginsWith("Partita")) {
		idPartita=message.data.split("	",2)[1];
	}else{
		document.getElementById("logArea").value += message.data;
	}
};

function processClose(message) {
	webSocket.send("** Client disconnesso **"+"\n");
};

function processError(message) {
	document.getElementById("logArea").value += "** Errore" + "**"+"\n";
};

