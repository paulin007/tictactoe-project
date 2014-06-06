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
	if (gameName.toLowerCase() == "tris") {
		setTicTacToeLogo();
		TicTacToe();
		createTrisTable();
	} else if (gameName.toLowerCase() == "forza4") {
		setFourInARowLogo();
		FourInARow();
		createFourInARowTable();
	};
}

