/**
 * Questo js implementa tutte le funzioni e gli attributi per gestire il gioco Forza4
 *
 * @author: Marco Vanzulli
 */

function FourInARow(){
	return 'forza4';
}

function setYellowBall(id) {
	document.getElementById(id).src = './img/palla_gialla.png';
}

function setRedBall(id) {
	document.getElementById(id).src = './img/palla_rossa.png';
}

function setFourInARowLogo(){
	document.getElementById("gameLogo").src = './img/Forza4logo.png';
}

function playAudio(){
	var audioElement = document.createElement('audio');
	audioElement.setAttribute('src', './sounds/pop1.wav');
	audioElement.play();
}

function createFourInARowTable(){
	var div = document.getElementById('gameTable');
	div.innerHTML = ("<table class='buttonBar'>"+
				"<tr>"+
					"<td class='indicator'><a href='#'><img onclick='myMove(0)' id='b0' src='./img/indicatore1.png' alt='b0'/></a></td>"+
					"<td class='indicator'><a href='#'><img onclick='myMove(1)' id='b1' src='./img/indicatore1.png' alt='b1'/></a></td>"+
					"<td class='indicator'><a href='#'><img onclick='myMove(2)' id='b2' src='./img/indicatore1.png' alt='b2'/></a></td>"+
					"<td class='indicator'><a href='#'><img onclick='myMove(3)' id='b3' src='./img/indicatore1.png' alt='b3'/></a></td>"+
					"<td class='indicator'><a href='#'><img onclick='myMove(4)' id='b4' src='./img/indicatore1.png' alt='b4'/></a></td>"+
					"<td class='indicator'><a href='#'><img onclick='myMove(5)' id='b5' src='./img/indicatore1.png' alt='b5'/></a></td>"+
					"<td class='indicator'><a href='#'><img onclick='myMove(6)' id='b6' src='./img/indicatore1.png' alt='b6'/></a></td>"+
				"</tr>"+
			"</table>"+
			"<div class='container'>"+
		"<table class='fourInARowGrid'>"+
					"<tr>"+
						"<td class='boxF4'><img src='./img/transparentsquare.png' width='55' height='55'id='0' alt='m0'/></td>"+
						"<td class='boxF4'><img src='./img/transparentsquare.png' width='55' height='55' id='1' alt='m1'/></td>"+
						"<td class='boxF4'><img src='./img/transparentsquare.png' width='55' height='55' id='2' alt='m2'/></td>"+
						"<td class='boxF4'><img src='./img/transparentsquare.png' width='55' height='55' id='3' alt='m3'/></td>"+
						"<td class='boxF4'><img src='./img/transparentsquare.png' width='55' height='55' id='4' alt='m4'/></td>"+
						"<td class='boxF4'><img src='./img/transparentsquare.png' width='55' height='55' id='5' alt='m5'/></td>"+
						"<td class='boxF4'><img src='./img/transparentsquare.png' width='55' height='55' id='6' alt='m6'/></td>"+
					"</tr>"+
					"<tr>"+
						"<td class='boxF4'><img src='./img/transparentsquare.png' width='55' height='55' id='7' alt='m7'/></td>"+
						"<td class='boxF4'><img src='./img/transparentsquare.png' width='55' height='55' id='8' alt='m8'/></td>"+
						"<td class='boxF4'><img src='./img/transparentsquare.png' width='55' height='55' id='9' alt='m9'/></td>"+
						"<td class='boxF4'><img src='./img/transparentsquare.png' width='55' height='55' id='10' alt='m10'/></td>"+
						"<td class='boxF4'><img src='./img/transparentsquare.png' width='55' height='55' id='11' alt='m11'/></td>"+
						"<td class='boxF4'><img src='./img/transparentsquare.png' width='55' height='55' id='12' alt='m12'/></td>"+
						"<td class='boxF4'><img src='./img/transparentsquare.png' width='55' height='55' id='13' alt='m13'></td>"+
					"</tr>"+
					"<tr>"+
						"<td class='boxF4'><img src='./img/transparentsquare.png' width='55' height='55' id='14' alt='m14'/></td>"+
						"<td class='boxF4'><img src='./img/transparentsquare.png' width='55' height='55' id='15' alt='m15'/></td>"+
						"<td class='boxF4'><img src='./img/transparentsquare.png' width='55' height='55' id='16' alt='m16'/></td>"+
						"<td class='boxF4'><img src='./img/transparentsquare.png' width='55' height='55' id='17' alt='m17'/></td>"+
						"<td class='boxF4'><img src='./img/transparentsquare.png' width='55' height='55' id='18' alt='m18'/></td>"+
						"<td class='boxF4'><img src='./img/transparentsquare.png' width='55' height='55' id='19' alt='m19'/></td>"+
						"<td class='boxF4'><img src='./img/transparentsquare.png' width='55' height='55' id='20' alt='m20'/></td>"+
					"</tr>"+
					"<tr>"+
						"<td class='boxF4'><img src='./img/transparentsquare.png' width='55' height='55' id='21' alt='m21'/></td>"+
						"<td class='boxF4'><img src='./img/transparentsquare.png' width='55' height='55' id='22' alt='m22'/></td>"+
						"<td class='boxF4'><img src='./img/transparentsquare.png' width='55' height='55' id='23' alt='m23'/></td>"+
						"<td class='boxF4'><img src='./img/transparentsquare.png' width='55' height='55' id='24' alt='m24'/></td>"+
						"<td class='boxF4'><img src='./img/transparentsquare.png' width='55' height='55' id='25' alt='m25'/></td>"+
						"<td class='boxF4'><img src='./img/transparentsquare.png' width='55' height='55' id='26' alt='m26'/></td>"+
						"<td class='boxF4'><img src='./img/transparentsquare.png' width='55' height='55' id='27' alt='m27'/></td>"+
					"</tr>"+
					"<tr>"+
						"<td class='boxF4'><img src='./img/transparentsquare.png' width='55' height='55' id='28' alt='m28'/></td>"+
						"<td class='boxF4'><img src='./img/transparentsquare.png' width='55' height='55' id='29' alt='m29'/></td>"+
						"<td class='boxF4'><img src='./img/transparentsquare.png' width='55' height='55' id='30' alt='m30'/></td>"+
						"<td class='boxF4'><img src='./img/transparentsquare.png' width='55' height='55' id='31' alt='m31'/></td>"+
						"<td class='boxF4'><img src='./img/transparentsquare.png' width='55' height='55' id='32' alt='m32'/></td>"+
						"<td class='boxF4'><img src='./img/transparentsquare.png' width='55' height='55' id='33' alt='m33'/></td>"+
						"<td class='boxF4'><img src='./img/transparentsquare.png' width='55' height='55' id='34' alt='m34'/></td>"+
					"</tr>"+
					"<tr>"+
						"<td class='boxF4'><img src='./img/transparentsquare.png' width='55' height='55' id='35' alt='m35'/></td>"+
						"<td class='boxF4'><img src='./img/transparentsquare.png' width='55' height='55' id='36' alt='m36'/></td>"+
						"<td class='boxF4'><img src='./img/transparentsquare.png' width='55' height='55' id='37' alt='m37'/></td>"+
						"<td class='boxF4'><img src='./img/transparentsquare.png' width='55' height='55' id='38' alt='m38'/></td>"+
						"<td class='boxF4'><img src='./img/transparentsquare.png' width='55' height='55' id='39' alt='m39'/></td>"+
						"<td class='boxF4'><img src='./img/transparentsquare.png' width='55' height='55' id='40' alt='m40'/></td>"+
						"<td class='boxF4'><img src='./img/transparentsquare.png' width='55' height='55' id='41' alt='m41'/></td>"+
					"</tr>"+
				"</table>"
);
}