package rete;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class InterpretePacchettoDefault implements InterpretePacchettoRete {
	private static String messaggioMosse = "Mosse";
	private static String messaggioRisultato = "Risultato";
	private static String separatore = "  ";
	private ArrayList<Integer> mosse;
	private String risultato;
	
	@Override
	public ArrayList<Integer> getMossePacchetto() {
		return mosse;
	}
	
	@Override
	public String getRisultatoPacchetto() {
		return risultato;
	}
	
	@Override
	public void interpretaPacchetto(String pacchetto) {
		StringTokenizer tokenizer = new StringTokenizer(pacchetto);
		String tipoMessaggio = tokenizer.nextToken(separatore);
		if(tipoMessaggio.equalsIgnoreCase(messaggioMosse)){
			mosse = new ArrayList<>();
			while(tokenizer.hasMoreTokens()){
				mosse.add(Integer.valueOf(tokenizer.nextToken())); 
			}
		}
		if(tipoMessaggio.equalsIgnoreCase(messaggioRisultato)){
			risultato = tokenizer.nextToken("-").replace("  ", "");
		}
	}
}
