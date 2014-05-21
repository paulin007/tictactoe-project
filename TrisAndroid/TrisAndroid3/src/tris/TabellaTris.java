/**
 * Questa classe ha responsabilità di costruire il luogo geometrico, che contiene
 * le {@link Casella}, dove l'utente inserira le proprie mosse
 * @author Giacomo
 */
package tris;

import java.util.ArrayList;

public class TabellaTris  {
	
	private ArrayList<Casella> caselle;
	private static int nRighe = 3;
	private static int nColonne = 3;
	private int mossa;
	/**
	 * Questo metodo permette di creare una tabella per il tris,
	 * formata da un certo numero di {@link Casella}
	 */
	public void creaTabella(){
		caselle = new ArrayList();
		int k=0;
		for (int i = 1; i <= nRighe; i++) {
			for (int j = 1; j <= nColonne; j++) {
				Casella casella = new Casella(k);
				caselle.add(casella);
				k++;
			}
		}
	}

	public ArrayList<Casella> getCaselle() {
		return caselle;
	}

	public void setCaselle(ArrayList<Casella> caselle) {
		this.caselle = caselle;
	}
	/**
	 * Questo metodo ha lo scopo di verificare se è presente un possibile scacco all'interno
	 * della {@link TabellaTris}
	 * @return
	 */
	public boolean possibileScacco(){
		  boolean possibileScacco = false;
		  //scacco Orizzontale primi due
		  for (int i = 0; i < 3; i++) {
		   Casella casellaA = getCaselle().get(0+3*i);
		   Casella casellaB = getCaselle().get(1+3*i);
		   if(casellaA.casellaConsecutivaG1(casellaB)){
		    possibileScacco = true;
		    if(getCaselle().get((2+3*i)).isVuota()){
		    	mossa = 2+3*i; //riempie le caselle 2-5-8
		    	System.out.println("scacco Orizzontale primi due"+mossa);
		    }
		   
		    
		    break;
		   }
		  }
		  // scacco Orizzontale ultimi due
		  for (int i = 0; i < 3; i++) {
		   Casella casellaA = getCaselle().get(1+3*i);
		   Casella casellaB = getCaselle().get(2+3*i);
		   if(casellaA.casellaConsecutivaG1(casellaB)){
		    possibileScacco = true;
		    if(getCaselle().get((3*i)).isVuota()){
		    	mossa = 3*i; //riempie le caselle 0-3-6 
		    	System.out.println("scacco Orizzontale ultimi due"+mossa);
		    }
		    break;
		   }
		  }
		  // scacco Verticale primi due
		  for (int i = 0; i < 3; i++) {
		   Casella casellaA = getCaselle().get(i);
		   Casella casellaB = getCaselle().get(i+3);
		   if(casellaA.casellaConsecutivaG1(casellaB)){
		    possibileScacco = true;
		    if(getCaselle().get((i+6)).isVuota()){
		    	 mossa = i+6; //riempie le caselle 6-7-8
		    	 System.out.println("scacco Verticale primi due"+mossa);
		    }
		   
		    
		    break;
		   }
		  }
		  // scacco Verticale ultimi due
		  for (int i = 3; i < 6; i++) {
		   Casella casellaA = getCaselle().get(i);
		   Casella casellaB = getCaselle().get(i+3);
		   if(casellaA.occupataDaG1()&&casellaB.occupataDaG1()){
		    possibileScacco = true;
		    
		    if(getCaselle().get((i-3)).isVuota()){
		    	 mossa = i-3; //riempie le caselle 0-1-2
		    	 System.out.println("scacco Verticale ultimi due"+mossa);
		    }
		   
		   
		    break;
		   }
		  }
		  // scacco orizzontale in mezzo
		  for (int i = 0; i < 3; i++) {
		   Casella casellaA = getCaselle().get(3*i);
		   Casella casellaB = getCaselle().get(3*i+2);
		   if(casellaA.occupataDaG1()&&casellaB.occupataDaG1()){
		    possibileScacco = true;
		    if(getCaselle().get((3*i+1)).isVuota()){
		    	mossa = 3*i+1; //riempie le caselle 1-4-7
		    	System.out.println("scacco orizzontale in mezzo"+mossa);
		    }
		    
		   
		    break;
		   }
		  }
		  // scacco verticale in mezzo
		  for (int i = 0; i < 3; i++) {
		   Casella casellaA = getCaselle().get(i);
		   Casella casellaB = getCaselle().get(6+i);
		   if(casellaA.occupataDaG1()&&casellaB.occupataDaG1()){
		    possibileScacco = true;
		    if(getCaselle().get((3+i)).isVuota()){
		    	mossa = 3+i; //riempie le caselle 3-4-5
		    	 System.out.println("scacco verticale in mezzo"+mossa);
		    }
		    
		   
		    break;
		   }
		  }
		  // scacco in diagonale
		  Casella casella0 = getCaselle().get(0);
		  Casella casella2 = getCaselle().get(2);
		  Casella casella4 = getCaselle().get(4);
		  Casella casella6 = getCaselle().get(6);
		  Casella casella8 = getCaselle().get(8);
		  if(casella0.occupataDaG1()&&casella4.occupataDaG1()){
		    possibileScacco = true;
		  
		    if(getCaselle().get(8).isVuota()){
		    	 mossa = 8;
		    	 System.out.println("scacco in diagonale"+mossa);
		    }
		   
		    
		  }
		  if(casella2.occupataDaG1()&&casella4.occupataDaG1()){
		   possibileScacco = true;
		   if(getCaselle().get(6).isVuota()){
		    	 mossa = 6;
		    	 System.out.println("scacco in diagonale"+mossa);
		    }
		
		  
		  }
		  if(casella4.occupataDaG1()&&casella8.occupataDaG1()){
		   possibileScacco = true;
		   if(getCaselle().get(0).isVuota()){
		    	 mossa = 0;
		    	 System.out.println("scacco in diagonale"+mossa);
		    }
		  
		   
		  }
		  if(casella6.occupataDaG1()&&casella4.occupataDaG1()){
		   possibileScacco = true;
		   if(getCaselle().get(2).isVuota()){
		    	 mossa = 2;
		    	 System.out.println("scacco in diagonale"+mossa);
		    }
		   
		  
		  }
		  if(casella0.occupataDaG1()&&casella8.occupataDaG1()){
		   possibileScacco = true;
		   if(getCaselle().get(4).isVuota()){
		    	 mossa = 4;
		    	 System.out.println("scacco in diagonale"+mossa);
		    }
		  
		  
		  }
		 if(casella2.occupataDaG1()&&casella6.occupataDaG1()){
		   possibileScacco = true;
		   if(getCaselle().get(4).isVuota()){
		    	 mossa = 4;
		    	 System.out.println("scacco in diagonale"+mossa);
		    }
		  }
		 return possibileScacco;
		 }

	public int getMossa() {
		return mossa;
	}

	public void setMossa(int mossa) {
		this.mossa = mossa;
	}
}
