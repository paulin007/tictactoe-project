package grafica;

import javax.swing.JOptionPane;
/**
 * Questa classe ha la responsabilità di elaborare un messaggio per fornire l'esito di una partita
 */
public class VisualizzatoreRisultato {
	
	private boolean aggiorna=true;
	private boolean mostrato = false;
	/**
	 * Dato l'esito di una partita sceglie il messaggio giusto da mostrare
	 * 
	 * @param interpreteMessaggio
	 * @param mioSimbolo
	 * @param aggiorna
	 * @param mostrato
	 */
	public void mostraRisultato(String risultato, String mioSimbolo){
		if(hoVinto(risultato, mioSimbolo)&&mostrato==false){
			risultato = "Hai vinto !";
			JOptionPane.showMessageDialog(null, risultato);
			mostrato = true;
			aggiorna = false;
		}
		if(hoPerso(risultato, mioSimbolo)&&mostrato==false){
			risultato = "Hai perso !";
			JOptionPane.showMessageDialog(null, risultato);
			mostrato = true;
			aggiorna = false;
		}
		if(pareggio(risultato)&&mostrato==false){
			risultato = "La partita è finita in pareggio";
			JOptionPane.showMessageDialog(null, risultato);
			mostrato = true;
			aggiorna = false;
			
		}
	}
	
	private boolean hoVinto(String risultato, String mioSimbolo) {
		return risultato.equalsIgnoreCase(Simbolo.simboloG1)&&mioSimbolo.equalsIgnoreCase(Simbolo.simboloG1)||
				risultato.equalsIgnoreCase(Simbolo.simboloG2)&&mioSimbolo.equalsIgnoreCase(Simbolo.simboloG2);
	}
	
	private boolean hoPerso(String risultato, String mioSimbolo) {
		return risultato.equalsIgnoreCase(Simbolo.simboloG1)&&mioSimbolo.equalsIgnoreCase(Simbolo.simboloG2)||
				risultato.equalsIgnoreCase(Simbolo.simboloG2)&&mioSimbolo.equalsIgnoreCase(Simbolo.simboloG1);
	}
	
	private boolean pareggio(String risultato) {
		return risultato.equalsIgnoreCase("Pareggio");
	}
	
	public void setAggiorna(boolean aggiorna) {
		this.aggiorna = aggiorna;
	}
	
	public boolean isAggiorna() {
		return aggiorna;
	}
	
}