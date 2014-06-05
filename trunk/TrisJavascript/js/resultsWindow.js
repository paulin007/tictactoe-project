
function vittoria(vincitore){

	myWindow=window.open("","","left=500,top=250, width=260,height=150");
	myWindow.document.write("<html>"+"<head>"+"<link href=\"./css/result.css\" rel=\"stylesheet\" type=\"text/css\">"+"</head>"+"<h1 id=\"vincitore\">"+"Hai vinto "+vincitore+"</h1>" +"</html>");
	myWindow.opener.location.reload();
}

function sconfitta(perdente){
	
	myWindow=window.open("","","left=500,top=250, width=260,height=150");
	myWindow.document.write("<html>"+"<head>"+"<link href=\"./css/result.css\" rel=\"stylesheet\" type=\"text/css\">"+"</head>"+"<h1 id=\"perdente\">"+"Hai perso "+perdente+"</h1>" +"</html>");
	myWindow.opener.location.reload();
}

function pareggio(){
	
	myWindow=window.open("","","left=500,top=250, width=260,height=150");
	myWindow.document.write("<html>"+"<head>"+"<link href=\"./css/result.css\" rel=\"stylesheet\" type=\"text/css\">"+"</head>"+"<h1 id=\"pareggio\">"+"Pareggio"+"</h1>" +"</html>");
	myWindow.opener.location.reload();
}