/**
 * @author Marco Vanzulli
 */

function Partita() {
	var _matchID;
	var _matchStatus;
	var _lastPlayer;
	var _myPlayer;
	var _otherPlayer;
	var _matchEnded=false;
	Object.defineProperty(this, "matchID", {
		get : function() {
			return _matchID;
		},
		set : function(value) {
			_matchID = value;
		}
	});
	Object.defineProperty(this, "matchStatus", {
		get : function() {
			return _matchStatus;
		},
		set : function(value) {
			_matchStatus = value;
		}
	});
	Object.defineProperty(this, "lastPlayer", {
		get : function() {
			return _lastPlayer;
		},
		set : function(value) {
			_lastPlayer = value;
		}
	});
	Object.defineProperty(this, "myPlayer", {
		get : function() {
			return _myPlayer;
		},
		set : function(value) {
			_myPlayer = value;
		}
	});
	Object.defineProperty(this, "otherPlayer", {
		get : function() {
			return _otherPlayer;
		},
		set : function(value) {
			_otherPlayer = value;
		}
	});
	Object.defineProperty(this, "ended", {
		get : function() {
			return _matchEnded;
		},
		set : function(value) {
			_matchEnded = value;
		}
	});
}

function tokenizer(message, partita) {
	var moves = new Array(9);
	partita.matchID = message.split("\t")[1];
	partita.matchStatus = message.split("\t")[2];
	partita.lastPlayer = message.split("\t")[3];
	for (var i = 0; i < moves.length; i++) {
		moves[i] = message.split(" ")[i + 1];
	};
	checkResult(partita);
	paint(moves);
}

function checkResult(partita) {
	if (partita.matchStatus != "inCorso") {
		if (partita.matchStatus == "Pareggio") {
			setInterval(function() {
				partita.ended = true;
				alert("Pareggio!");
				window.location.reload();
			}, 3000);
		} else if (partita.matchStatus == partita.myPlayer) {
			setInterval(function() {
				partita.ended = true;
				alert("Hai vinto!");
				window.location.reload();
			}, 3000);
		} else if (partita.matchStatus == partita.otherPlayer) {
			setInterval(function() {
				partita.ended = true;
				alert("Hai perso!");
				window.location.reload();
			}, 3000);
		}
	}
}

function writeOnArea(string) {
	document.getElementById("logArea").value += string;
}

function getFirstPlayerName() {
	firstPlayerName = document.getElementById('player1name').options[document.getElementById('player1name').selectedIndex].text;
	return firstPlayerName;
}

function getSecondPlayerName() {
	secondPlayerName = document.getElementById('player2name').options[document.getElementById('player2name').selectedIndex].text;
	return secondPlayerName;
}