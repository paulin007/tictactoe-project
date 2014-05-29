package grafica;

import javax.swing.JDialog;

import rete.InterpreteMessaggio;
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
	public void mostraRisultato(InterpreteMessaggio interpreteMessaggio, String mioSimbolo){
		String risultato = interpreteMessaggio.getStatoPartita();
		System.out.println("Debug: "+interpreteMessaggio.getStatoPartita());
		
		if(hoVinto(risultato, mioSimbolo)&&mostrato==false){
			risultato = "Hai vinto !";
		
			FinestraRisultato vittoria = new FinestraRisultato(risultato);
			vittoria.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			vittoria.setVisible(true);
			mostrato = true;
			aggiorna = false;
		}
		if(hoPerso(risultato, mioSimbolo)&&mostrato==false){
			risultato = "Hai perso !";
			
			FinestraRisultato sconfitta = new FinestraRisultato(risultato);
			sconfitta.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			sconfitta.setVisible(true);
			mostrato = true;
			aggiorna = false;
		}
		if(pareggio(risultato)&&mostrato==false){
			
			risultato = "Pareggio";
			FinestraRisultato pareggio = new FinestraRisultato(risultato);
			pareggio.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			pareggio.setVisible(true);
			
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
