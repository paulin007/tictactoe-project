/**
 * Questo js si occupa di analizzare e richiamare i tokenizer per ogni messaggio ricevuto sul client, dal server
 *
 * @author Marco Vanzulli
 */

function analyzeMessage(message) {
	if (message.startsWith("Tris") || message.startsWith("Forza4") || message.startsWith("tris") || message.startsWith("forza4")) {
		tokenizeMatch(message, getMatch());
	}
		else{
		tokenizeAchievements(message,getAchievements());
	}
	//if(message.startsWith("0"||"1"||"2"||"3"||"4"||"5"||"6"||"7"||"8"||"9"))
}

function processGET() {
	var parameters = location.search.substring(1).split("&");
	var temp = parameters[0].split("=");
	var name = unescape(temp[1]);
	return name;
}

/**
 * Creo una funzione "startsWith" sul prototype String per verificare se una parola inizia con determinati caratteri
 */

if ( typeof String.prototype.startsWith != 'function') {
	String.prototype.startsWith = function(str) {
		return this.slice(0, str.length) == str;
	};
}