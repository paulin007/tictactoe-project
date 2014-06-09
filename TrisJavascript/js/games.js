/**
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

