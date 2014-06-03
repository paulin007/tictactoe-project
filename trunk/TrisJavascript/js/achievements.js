/**
 * Questo js si occupa di richiedere ed elaborare gli achievements inviati e ricevuti dal server
 * 
 * @author Marco
 */

function getGameName() {
	var gameName;
	gameName = document.getElementById('gameName').options[document.getElementById('gameName').selectedIndex].text;
	return gameName;
}

function getPlayerName() {
	var playerName;
	playerName = document.getElementById('playerName').options[document.getElementById('playerName').selectedIndex].text;
	return playerName;
}

function tokenizer(message){
	var victories, ties, defeats, string;
	var achievements = new Array(5);
	victories = message.split(" ",8)[0];
	ties = message.split(" ",8)[1];
	defeats = message.split("",8)[2];
	for (var i=0; i < achievements.length; i++) {
	  achievements[i]=message.split("@",8)[i+1];
	};
	string = getPlayerName()+"|Gioco: "+getGameName()+"|V: "+victories+"|P: "+ties+"|S: "+defeats+" - Achievements: "+achievements+"\n";
	writeOnArea(string);
}

function writeOnArea(string){
	document.getElementById("logArea").value += string;
}
