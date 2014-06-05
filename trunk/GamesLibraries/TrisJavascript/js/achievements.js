/**
 * Questo js si occupa di richiedere ed elaborare gli achievements inviati e ricevuti dal server
 *
 * @author Marco Vanzulli
 */

function Achievements(){
	var _victories, _ties, _defeats, _scores;
	var _dimension = 5;
	_scores = new Array(_dimension);
	Object.defineProperty(this, "victories", {
		get : function() {
			return _victories;
		},
		set : function(value) {
			_victories = value;
		}
	});
	Object.defineProperty(this, "ties", {
		get : function() {
			return _ties;
		},
		set : function(value) {
			_ties = value;
		}
	});
	Object.defineProperty(this, "defeats", {
		get : function() {
			return _defeats;
		},
		set : function(value) {
			_defeats = value;
		}
	});
	Object.defineProperty(this, "scores", {
		get : function() {
			return _scores;
		},
		set : function(value) {
			_scores = value;
		}
	});
}

function tokenizeAchievements(message){
	achievements.victories = message.split(" ",8)[0];
	achievements.ties = message.split(" ",8)[1];
	achievements.defeats = message.split("",8)[2];
	for (var i = 0; i < achievements.scores.length; i++) {
		achievements.scores[i] = message.split("@",8)[i + 1];
	};
	string = getPlayerName() + "|Gioco: " + getGameName() + "|V: " + achievements.victories + "|P: " + achievements.ties + "|S: " + achievements.defeats + " - Achievements: " + achievements.scores + "\n";
	writeOnArea(string);
}

function writeOnArea(string) {
	document.getElementById("logArea").value += string;
}
