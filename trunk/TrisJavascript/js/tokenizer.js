function tokenizeMatch(message, match) {
	match.matchID = message.split("\t")[1];
	match.matchStatus = message.split("\t")[2];
	match.lastPlayer = message.split("\t")[3];
	for (var i = 0; i < match.moves.length; i++) {
		match.moves[i] = message.split(" ")[i + 1];
	};
}

function tokenizeAchievements(message, achievements){
	achievements.victories = message.split(" ",8)[0];
	achievements.ties = message.split(" ",8)[1];
	achievements.defeats = message.split("",8)[2];
	for (var i = 0; i < achievements.scores.length; i++) {
		achievements.scores[i] = message.split("@",8)[i + 1];
	};
	string = " "+getFirstPlayerName() + "|Gioco: " + getSelectedGameName() + "|V: " + achievements.victories + "|P: " + achievements.ties + "|S: " + achievements.defeats + " - Achievements: " + achievements.scores + "\n";
	writeAchievements(string);
}