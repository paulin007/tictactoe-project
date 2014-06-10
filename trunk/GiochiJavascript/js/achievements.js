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

function writeAchievements(string) {
	document.getElementById("logArea").value += string;
}

function requestAchievements() {
	var achievements = new Achievements();
	var string = "statistiche/" + getFirstPlayerName() + "/" + getSelectedGameName();
	getWebSocket().send(string);
	
	getAchievements = function() {
		return achievements;
	};
}