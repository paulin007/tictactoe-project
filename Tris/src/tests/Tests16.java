package tests;

import tris.TabellaTris;
import vincita.GestoreVincite;
import vincita.VerificaVincita;

public class Tests16 {
	public static void main(String[] args) {
		TabellaTris caselle = new TabellaTris();
		caselle.creaTabella();
		
		
		for (int i = 0; i < 4; i++) {
			caselle.getCaselle().get(i).setSimbolo("g");
		}
		GestoreVincite gestoreVincite = new GestoreVincite(caselle.getCaselle());
		gestoreVincite.qualcunoHavinto(caselle.getCaselle());
		VerificaVincita verificaVincita = new VerificaVincita();
		verificaVincita.stabilisciVincitore(caselle.getCaselle());
		
	}
}
