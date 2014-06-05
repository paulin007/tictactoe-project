package grafica;

/**
 * Questa classe ha la responsabilità di elaborare un messaggio per fornire l'esito di una partita
 */
public class ResultViewer {
	
	private boolean shown;
	ResultDialog resultDialog;
	/**
	 * Dato l'esito di una partita sceglie il messaggio giusto da mostrare
	 * 
	 * @param interpreteMessaggio
	 * @param mySymbol
	 * @param aggiorna
	 * @param mostrato
	 */
	public void showResult(String result, String mySymbol){
		if(youWin(result, mySymbol) && shown==false){
			result = "Hai vinto !";
			resultDialog = new ResultDialog(result);
			shown = true;
		}
		if(youLose(result, mySymbol) && shown==false){
			result = "Hai perso !";
			resultDialog = new ResultDialog(result);
			shown = true;
		}
		if(tie(result) && shown==false){
			result = "La partita è finita in pareggio";
			resultDialog = new ResultDialog(result);
			shown = true;
			
		}
	}
	
	private boolean youWin(String result, String mySymbol) {
		return result.equalsIgnoreCase(mySymbol);
	}
	
	private boolean youLose(String result, String mySymbol) {
		return !result.equalsIgnoreCase(mySymbol) && !result.equalsIgnoreCase("InCorso");
	}
	
	private boolean tie(String result) {
		return result.equalsIgnoreCase("Pareggio");
	}
	
	
}
