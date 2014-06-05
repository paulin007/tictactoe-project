/**
 * Questo js si occupa di gestire interamente lo svolgimento della match
 * 
 * @author Marco Vanzulli
 */


function Match(_gameName,_connection) {
	var _gameName, _matchID, _matchStatus, _lastPlayer, _myPlayer, _otherPlayer, _movesDimension, _moves, _connection;
	var _matchEnded = false;
	this._connection = _connection;
	this._gameName = _gameName;

	if (_gameName == "tris") {
		_movesDimension = 9;
	} else if (_gameName == "forza4") {
		_movesDimension = 42;
	};
	if (_connection=="nuova") {
		_myPlayer="G1";
		_otherPlayer="G2";
	} else if(_connection=="esistente"){
		_myPlayer="G2";
		_otherPlayer="G1";
	};
	_moves = new Array(_movesDimension);
	Object.defineProperty(this, "gameName", {
		get : function() {
			return _gameName;
		},
		set : function(value) {
			_gameName = value;
		}
	});
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
	Object.defineProperty(this, "movesDimension", {
		get : function() {
			return _movesDimension;
		},
		set : function(value) {
			_movesDimension = value;
		}
	});
	Object.defineProperty(this, "moves", {
		get : function() {
			return _moves;
		},
		set : function(value) {
			_moves = value;
		}
	});
}

function tokenizeMatch(message, match) {
	match.matchID = message.split("\t")[1];
	match.matchStatus = message.split("\t")[2];
	match.lastPlayer = message.split("\t")[3];
	for (var i = 0; i < match.moves.length; i++) {
		match.moves[i] = message.split(" ")[i + 1];
	};
	checkResult(match);
	paint(match.moves);
}

function checkResult(match) {
	if (match.matchStatus != "inCorso") {
		if (match.matchStatus == "Pareggio") {
			setInterval(function() {
				match.ended = true;
				alert("Pareggio!");
				window.location.reload();
			}, 3000);
		} else if (match.matchStatus == match.myPlayer) {
			setInterval(function() {
				match.ended = true;
				alert("Hai vinto!");
				window.location.reload();
			}, 3000);
		} else if (match.matchStatus == match.otherPlayer) {
			setInterval(function() {
				match.ended = true;
				alert("Hai perso!");
				window.location.reload();
			}, 3000);
		}
	}
}

function myMove(id) {
	if (getMatch().myPlayer != getMatch().lastPlayer && getMatch().ended == false) {
		string = "mossa/" + getMatch().matchID + "/" + getMatch().myPlayer + "/" + id;
		getWebSocket().send(string);
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