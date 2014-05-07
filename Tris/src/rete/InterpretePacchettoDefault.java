package rete;

import java.util.StringTokenizer;

public class InterpretePacchettoDefault implements InterpretePacchettoRete {
	private static String messaggioMossa = "Mossa";
	private static String messaggioRisultato = "Risultato";
	private static String separatore = " 	";
	private int ultimaMossa;
	private String risultato;
	
	@Override
	public int getUltimaMossaPacchetto() {
		return ultimaMossa;
	}
	
	@Override
	public String getRisultatoPacchetto() {
		return risultato;
	}
	
	@Override
	public void interpretaPacchetto(String pacchetto) {
		StringTokenizer tokenizer = new StringTokenizer(pacchetto);
		String tipoMessaggio = tokenizer.nextToken(separatore);
		if(tipoMessaggio.equalsIgnoreCase(messaggioMossa)){
			tokenizer.nextToken("	"); //sarebbe l'ID della partita, che per ora non serve
			ultimaMossa = Integer.valueOf(tokenizer.nextToken());
		}
		if(tipoMessaggio.equalsIgnoreCase(messaggioRisultato)){
			risultato = tokenizer.nextToken("-").replace("  ", "");
		}
	}
}
