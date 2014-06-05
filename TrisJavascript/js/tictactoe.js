/**
 * Questo js implementa tutte le funzioni e gli attributi per gestire il gioco TicTacToe
 *
 * @author: Marco Vanzulli
 */

function TicTacToe(){
	return 'tris';
}

function setX(id) {
	document.getElementById(id).src = './img/X.png';
}

function setO(id) {
	document.getElementById(id).src = './img/O.png';
}

function setTicTacToeLogo(){
	document.getElementById("gameLogo").src = './img/tictactoe.png';
}

function createTrisTable(){
	var div = document.getElementById('gameTable');
 
	 div.innerHTML = ("<table class='TicTacToeTable'>"+
			"<tr>"+
					"<td class='boxTTT'><a href='#'><img class='box' onclick='myMove(0)' id='0' src='./img/blankpage.jpg' alt='m0'/></a></td>"+
					"<td class='boxTTT'><a href='#'><img class='box' onclick='myMove(1)' id='1' src='./img/blankpage.jpg' alt='m1'/></a></td>"+
					"<td class='boxTTT'><a href='#'><img class='box' onclick='myMove(2)' id='2' src='./img/blankpage.jpg' alt='m2'/></a></td>"+
				"</tr>"+
				"<tr>"+
					"<td class='boxTTT'><a href='#'><img class='box' onclick='myMove(3)' id='3' src='./img/blankpage.jpg' alt='m3'/></a></td>"+
					"<td class='boxTTT'><a href='#'><img class='box' onclick='myMove(4)' id='4' src='./img/blankpage.jpg' alt='m4'/></a></td>"+
					"<td class='boxTTT'><a href='#'><img class='box' onclick='myMove(5)' id='5' src='./img/blankpage.jpg' alt='m5'/></a></td>"+
				"</tr>"+
				"<tr>"+
					"<td class='boxTTT'><a href='#'><img class='box' onclick='myMove(6)' id='6' src='./img/blankpage.jpg' alt='m6'/></a></td>"+
					"<td class='boxTTT'><a href='#'><img class='box' onclick='myMove(7)' id='7' src='./img/blankpage.jpg' alt='m7'/></a></td>"+
					"<td class='boxTTT'><a href='#'><img class='box' onclick='myMove(8)' id='8' src='./img/blankpage.jpg' alt='m8'/></a></td>"+
				"</tr>"+
			"</table>");
}
