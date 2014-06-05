/**
 * Questo js si occupa di analizzare e richiamare i tokenizer per ogni messaggio ricevuto sul client, dal server
 * 
 * @author Marco Vanzulli
 */

function analyzeMessage(message) {
	if (message.startsWith("tris") || message.startsWith("forza4")) {
		tokenizeMatch(message, getMatch());
	} else if (message.startsWith(/^[0-9]/)) {
		tokenizeAchievements(message);
	}
}

/**
 * Creo una funzione "startsWith" sul prototype String per verificare se una parola inizia con determinati caratteri
 */

if ( typeof String.prototype.startsWith != 'function') {
	String.prototype.startsWith = function(str) {
		return this.slice(0, str.length) == str;
	};
}