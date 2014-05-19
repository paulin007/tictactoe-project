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
var lastPlayer;
var myPlayer;

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
	document.getElementById("logArea").value += moves[id]+" last:"+lastPlayer+" io:"+myPlayer;
	//if (moves[id] == "null" && myTurn) {
		//if (moves[id] == "null") {
		//myTurn = false;
		//setX(id);
		alert(myPlayer+" -- "+lastPlayer);
		if (myPlayer!=lastPlayer) {
		string = "mossa/" + matchID + "/"+myPlayer+"/" + id;
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
	string = "update/" + matchID;
	//alert(string);
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
	myPlayer="G1";
	webSocket.send("nuova partita/" + getFirstPlayerName() + "/" + getSecondPlayerName());
	document.getElementById("logArea").value += "nuova partita/" + getFirstPlayerName() + "/" + getSecondPlayerName()+"\n";
};

function connectToMatch() {
	myPlayer="G2";
	webSocket.send("collegati a/" + getFirstPlayerName() + "/" + getSecondPlayerName());
	setInterval(function() {
		requestUpdate();
	}, 1000);
};

function processOpen(message) {
	document.getElementById("logArea").value += "** Connessione al server **" + "\n";
};

function processMessage(message) {
	matchID = message.data.split("	",13)[1];
	matchStatus = message.data.split("	",13)[2];
	lastPlayer = message.data.split("	",13)[3];
	//alert(message.data);
	for (var i = 0; i < moves.length; i++) {
		moves[i] = message.data.split(" ",13)[i + 1];
	};
	paint(moves);
	//alert(moves);
	return lastPlayer;
};

function paint(moves){
	for (var i=0; i < moves.length; i++) {
	  if (moves[i]=="G1") {
	  	setX(i);
	  	//myTurn=false;
	  } else if(moves[i]=="G2"){
	  	setO(i);
	  	//myTurn=true;
	  };
	};
}

function processClose(message) {
	webSocket.send("** Client disconnesso **" + "\n");
};

function processError(message) {
	document.getElementById("logArea").value += "** Errore" + "**" + "\n";
};

