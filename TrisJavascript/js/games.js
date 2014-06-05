/**
 * @author Marco Vanzulli
 */

var gameName;

function getGameName(){
	return gameName;
}

function setGameName(name){
	this.gameName=name;
}

function createGamePage(){
	if (getGameName()=="tris") {
		setTicTacToeLogo();
		TicTacToe();
		createTrisTable();
	} else if(getGameName()=="forza4"){
		setFourInARowLogo();
		FourInARow();
		createFourInARowTable();
	};
}
