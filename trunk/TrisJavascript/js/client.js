/**
 * Questo file js si occupa di inviare un pacchetto al server Java all'indirizzo ws://localhost:45454
 * 
 * @author Marco Vanzulli
 */


var webSocket;


function connetti(){
	webSocket = new WebSocket("ws://localhost:45454/");
}


webSocket.onopen = function(message) {
	processOpen(message);
};

function sendMessage() {
	webSocket.send("prova");
};

webSocket.onclose = function(message) {
	processClose(message);
};

function processOpen(message) {
	//alert("connessione al server");
};

function processClose(message) {
	webSocket.send("client disconnesso");
	alert("connessione al server");
};
