package tests;

import tris.Simbolo;
import tris.TabellaTris;
import tris.vincita.AlgoritmoTris;
import tris.vincita.GestoreVincite;

public class Tests16 {
	public static void main(String[] args) {
		TabellaTris caselle = new TabellaTris();
		caselle.creaTabella();
		
		
		for (int i = 0; i < 4; i++) {
			caselle.getCaselle().get(i).setSimbolo(Simbolo.simboloG1);
		}
		GestoreVincite gestoreVincite = new GestoreVincite(caselle.getCaselle());
		gestoreVincite.qualcunoHavinto(caselle.getCaselle());
		AlgoritmoTris verificaVincita = new AlgoritmoTris();
		verificaVincita.stabilisciVincitore(caselle.getCaselle());
		
	}
}
