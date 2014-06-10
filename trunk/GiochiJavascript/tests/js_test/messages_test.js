/**
 * @author Marco Vanzulli
 */

function createNewMatch() {
	document.getElementById("messagesTextArea").value = '';
	document.getElementById("messagesTextArea").value = 'Richiesta new match '+'\n';
	getWebSocket().send("nuova partita/Marco/Dario/Tris");
	processMessage('prova');
}

function connectToMatch() {
	document.getElementById("messagesTextArea").value = '';
	document.getElementById("messagesTextArea").value = 'Richiesta connect to match ' +'\n';
	getWebSocket().send("collegati a/Marco/Dario/Tris");
}

function requestUpdate() {
	document.getElementById("messagesTextArea").value = '';
	document.getElementById("messagesTextArea").value = 'Richiesta Update '+'\n';
	getWebSocket().send("update/0");
}

function requestAchievements() {
	document.getElementById("messagesTextArea").value = '';
	document.getElementById("messagesTextArea").value = 'Richiesta achievements '+'\n';
	getWebSocket().send("statistiche/Marco/Dario");
}