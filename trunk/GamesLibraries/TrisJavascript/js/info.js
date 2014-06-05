/**
 * Questo js mi recupera le informazioni dalle pagine HTML, fornendomi nomi dei giocatori e dei giochi
 * 
 * @author Marco Vanzulli
 */

function getFirstPlayerName() {
	firstPlayerName = document.getElementById('player1name').options[document.getElementById('player1name').selectedIndex].text;
	return firstPlayerName;
}

function getSecondPlayerName() {
	secondPlayerName = document.getElementById('player2name').options[document.getElementById('player2name').selectedIndex].text;
	return secondPlayerName;
}

function getGameName() {
	var gameName;
	gameName = document.getElementById('gameName').options[document.getElementById('gameName').selectedIndex].text;
	return gameName;
}