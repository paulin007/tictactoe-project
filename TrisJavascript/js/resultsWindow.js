
function vittoria(){

	myWindow=window.open("","","left=500,top=250, width=280,height=150");
	myWindow.document.write("<html>"+"<head>"+"<link href=\"./css/result.css\" rel=\"stylesheet\" type=\"text/css\">"+"</head>"+"<h1 id=\"vincitore\">"+"Hai vinto "+getFirstPlayerName()+"</h1>" +"</html>");
	
}

function sconfitta(){
	
	myWindow=window.open("","","left=500,top=250, width=280,height=150");
	myWindow.document.write("<html>"+"<head>"+"<link href=\"./css/result.css\" rel=\"stylesheet\" type=\"text/css\">"+"</head>"+"<h1 id=\"perdente\">"+"Hai perso "+getFirstPlayerName()+"</h1>" +"</html>");
	
}

function pareggio(){
	
	myWindow=window.open("","","left=500,top=250, width=260,height=150");
	myWindow.document.write("<html>"+"<head>"+"<link href=\"./css/result.css\" rel=\"stylesheet\" type=\"text/css\">"+"</head>"+"<h1 id=\"pareggio\">"+"Pareggio"+"</h1>" +"</html>");
	
}