/**
 * Questo js si occupa di settare e restituire il nome del gioco selezionato e anche di crearne dinamicamente la pagina
 * 
 * @author Marco Vanzulli
 */

var gameName;

function getGameName() {
	return gameName.toLowerCase();
}

function setGameName(name) {
	this.gameName = name;
}

function createGamePage(gameName) {
	if (getGameName().toLowerCase() == "tris") {
		setTicTacToeLogo();
		createTrisTable();
	} else if (getGameName().toLowerCase() == "forza4") {
		setFourInARowLogo();
		createFourInARowTable();
	};
}

