/**
 * Questo js implementa i vari messaggi da inviare al server e si occupa di gestire interamente lo svolgimento della partita
 * 
 * @author Marco Vanzulli
 */

var client_match;

function createNewMatch() {
	client_match = new Match(getGameName(), "nuova");
	myTurn();
	getWebSocket().send("nuova partita/" + getFirstPlayerName() + "/" + getSecondPlayerName() + "/" + getGameName());
}

function connectToMatch() {
	client_match = new Match(getGameName(), "esistente");
	opponentTurn();
	getWebSocket().send("collegati a/" + getSecondPlayerName() + "/" + getFirstPlayerName()+"/"+getGameName());
	setInterval(function() {
		requestUpdate();
	}, 5000);

}

/**
 * E' il metodo fondamentale per gestire la partita sul client
 * @param {Object} message
 * @param {Object} match
 */

function handleMatch(message, match) {
	tokenizeMatch(message, match);
	setTurn(match);
	checkResult(match);
	paint(match.moves);
}

function requestUpdate() {
	if (getMatch().matchStatus == "inCorso") {
		string = "update/" + getMatch().matchID;
		getWebSocket().send(string);
	}
}

function getMatch() {
	return client_match;
}