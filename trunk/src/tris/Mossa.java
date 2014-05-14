package tris;

import java.util.Random;

/**
 * Questa classe ha la responsabilità
 * di verificare certe situazioni di gioco
 * e generare una contro-mossa all'utente
 * @author santo
 *
 */
public class Mossa {

	private static int mossa;
	
	/**
	 * Questo metodo ha lo scopo di verificare se è presente un possibile scacco all'interno
	 * della {@link TabellaTris}
	 * @return
	 */
	public static boolean possibileScacco(TabellaTris tabellaTris){
		  boolean possibileScacco = false;
		  //scacco Orizzontale primi due
		  for (int i = 0; i < 3; i++) {
		   Casella casellaA = tabellaTris.getCaselle().get(0+3*i);
		   Casella casellaB = tabellaTris.getCaselle().get(1+3*i);
		   if(casellaA.casellaConsecutivaG1(casellaB)){
		    possibileScacco = true;
		    if(tabellaTris.getCaselle().get((2+3*i)).isVuota()){
		    	mossa = 2+3*i; //riempie le caselle 2-5-8
		    	System.out.println("scacco Orizzontale primi due"+mossa);
		    }
		   
		    
		    break;
		   }
		  }
		  // scacco Orizzontale ultimi due
		  for (int i = 0; i < 3; i++) {
		   Casella casellaA = tabellaTris.getCaselle().get(1+3*i);
		   Casella casellaB = tabellaTris.getCaselle().get(2+3*i);
		   if(casellaA.casellaConsecutivaG1(casellaB)){
		    possibileScacco = true;
		    if(tabellaTris.getCaselle().get((3*i)).isVuota()){
		    	mossa = 3*i; //riempie le caselle 0-3-6 
		    	System.out.println("scacco Orizzontale ultimi due"+mossa);
		    }
		    break;
		   }
		  }
		  // scacco Verticale primi due
		  for (int i = 0; i < 3; i++) {
		   Casella casellaA = tabellaTris.getCaselle().get(i);
		   Casella casellaB = tabellaTris.getCaselle().get(i+3);
		   if(casellaA.casellaConsecutivaG1(casellaB)){
		    possibileScacco = true;
		    if(tabellaTris.getCaselle().get((i+6)).isVuota()){
		    	 mossa = i+6; //riempie le caselle 6-7-8
		    	 System.out.println("scacco Verticale primi due"+mossa);
		    }
		   
		    
		    break;
		   }
		  }
		  // scacco Verticale ultimi due
		  for (int i = 3; i < 6; i++) {
		   Casella casellaA = tabellaTris.getCaselle().get(i);
		   Casella casellaB = tabellaTris.getCaselle().get(i+3);
		   if(casellaA.occupataDaG1()&&casellaB.occupataDaG1()){
		    possibileScacco = true;
		    
		    if(tabellaTris.getCaselle().get((i-3)).isVuota()){
		    	 mossa = i-3; //riempie le caselle 0-1-2
		    	 System.out.println("scacco Verticale ultimi due"+mossa);
		    }
		   
		   
		    break;
		   }
		  }
		  // scacco orizzontale in mezzo
		  for (int i = 0; i < 3; i++) {
		   Casella casellaA = tabellaTris.getCaselle().get(3*i);
		   Casella casellaB = tabellaTris.getCaselle().get(3*i+2);
		   if(casellaA.occupataDaG1()&&casellaB.occupataDaG1()){
		    possibileScacco = true;
		    if(tabellaTris.getCaselle().get((3*i+1)).isVuota()){
		    	mossa = 3*i+1; //riempie le caselle 1-4-7
		    	System.out.println("scacco orizzontale in mezzo"+mossa);
		    }
		    
		   
		    break;
		   }
		  }
		  // scacco verticale in mezzo
		  for (int i = 0; i < 3; i++) {
		   Casella casellaA = tabellaTris.getCaselle().get(i);
		   Casella casellaB = tabellaTris.getCaselle().get(6+i);
		   if(casellaA.occupataDaG1()&&casellaB.occupataDaG1()){
		    possibileScacco = true;
		    if(tabellaTris.getCaselle().get((3+i)).isVuota()){
		    	mossa = 3+i; //riempie le caselle 3-4-5
		    	 System.out.println("scacco verticale in mezzo"+mossa);
		    }
		    
		   
		    break;
		   }
		  }
		  // scacco in diagonale
		  Casella casella0 = tabellaTris.getCaselle().get(0);
		  Casella casella2 = tabellaTris.getCaselle().get(2);
		  Casella casella4 = tabellaTris.getCaselle().get(4);
		  Casella casella6 = tabellaTris.getCaselle().get(6);
		  Casella casella8 = tabellaTris.getCaselle().get(8);
		  if(casella0.occupataDaG1()&&casella4.occupataDaG1()){
		    possibileScacco = true;
		  
		    if(tabellaTris.getCaselle().get(8).isVuota()){
		    	 mossa = 8;
		    	 System.out.println("scacco in diagonale"+mossa);
		    }
		   
		    
		  }
		  if(casella2.occupataDaG1()&&casella4.occupataDaG1()){
		   possibileScacco = true;
		   if(tabellaTris.getCaselle().get(6).isVuota()){
		    	 mossa = 6;
		    	 System.out.println("scacco in diagonale"+mossa);
		    }
		
		  
		  }
		  if(casella4.occupataDaG1()&&casella8.occupataDaG1()){
		   possibileScacco = true;
		   if(tabellaTris.getCaselle().get(0).isVuota()){
		    	 mossa = 0;
		    	 System.out.println("scacco in diagonale"+mossa);
		    }
		  
		   
		  }
		  if(casella6.occupataDaG1()&&casella4.occupataDaG1()){
		   possibileScacco = true;
		   if(tabellaTris.getCaselle().get(2).isVuota()){
		    	 mossa = 2;
		    	 System.out.println("scacco in diagonale"+mossa);
		    }
		   
		  
		  }
		  if(casella0.occupataDaG1()&&casella8.occupataDaG1()){
		   possibileScacco = true;
		   if(tabellaTris.getCaselle().get(4).isVuota()){
		    	 mossa = 4;
		    	 System.out.println("scacco in diagonale"+mossa);
		    }
		  
		  
		  }
		 if(casella2.occupataDaG1()&&casella6.occupataDaG1()){
		   possibileScacco = true;
		   if(tabellaTris.getCaselle().get(4).isVuota()){
		    	 mossa = 4;
		    	 System.out.println("scacco in diagonale"+mossa);
		    }
		  }
		 return possibileScacco;
	}
	
	public static void mosseDiagonali(TabellaTris tabellaTris){
		Casella casella0 = tabellaTris.getCaselle().get(0);
		Casella casella2 = tabellaTris.getCaselle().get(2);
		Casella casella4 = tabellaTris.getCaselle().get(4);
		Casella casella6 = tabellaTris.getCaselle().get(6);
		Casella casella8 = tabellaTris.getCaselle().get(8);
		
		if(casella0.possibileMossaG2(casella4, casella8)){
			mossa = 8;
			System.out.println("Attacco diagonale"+mossa);
		}
		if(casella4.possibileMossaG2(casella8, casella0)){
			mossa = 0;
			System.out.println("Attacco diagonale"+mossa);
		}
		if(casella2.possibileMossaG2(casella4, casella6)){
			mossa = 6;
			System.out.println("Attacco diagonale"+mossa);
		}
		if(casella4.possibileMossaG2(casella6, casella2)){
			mossa = 2;
			System.out.println("Attacco diagonale"+mossa);
		}
		if(casella0.possibileMossaG2(casella8, casella4)){
			mossa = 4;
			System.out.println("Attacco diagonale"+mossa);
		}
		if(casella2.possibileMossaG2(casella6, casella4)){
			mossa = 4;
			System.out.println("Attacco diagonale"+mossa);
		}
		
	}
	
	public static void mosseOrizzontali(TabellaTris tabellaTris){
		for (int i = 0; i < 3; i++) {
			Casella casella1 = tabellaTris.getCaselle().get(0+3*i);
			Casella casella2 = tabellaTris.getCaselle().get(1+3*i);
			Casella casella3 = tabellaTris.getCaselle().get(2+3*i);
			if(casella1.possibileMossaG2(casella2, casella3)){
				mossa = 2+3*i;
				System.out.println("Attacco orizzontale" +mossa);
				break;
			}
		}
		for (int i = 0; i < 3; i++) {
			Casella casella1 = tabellaTris.getCaselle().get(1+3*i);
			Casella casella2 = tabellaTris.getCaselle().get(2+3*i);
			Casella casella3 = tabellaTris.getCaselle().get(3*i);
			if(casella1.possibileMossaG2(casella2, casella3)){
				mossa = 3*i;
				System.out.println("Attacco orizzontale" +mossa);
				break;
			}
		}
		for (int i = 0; i < 3; i++) {
			Casella casella1 = tabellaTris.getCaselle().get(3*i);
			Casella casella2 = tabellaTris.getCaselle().get(2+3*i);
			Casella casella3 = tabellaTris.getCaselle().get(1+3*i);
			if(casella1.possibileMossaG2(casella2, casella3)){
				mossa = 1+3*i;
				System.out.println("Attacco orizzontale" +mossa);
				break;
			}
		}
		
	}
	
	public static void mosseVerticali(TabellaTris tabellaTris){
		for (int i = 0; i < 3; i++) {
			Casella casella1 = tabellaTris.getCaselle().get(i);
			Casella casella2 = tabellaTris.getCaselle().get(i+3);
			Casella casella3 = tabellaTris.getCaselle().get(i+6);
			if(casella1.possibileMossaG2(casella2, casella3)){
				mossa = i+6;
				System.out.println("Attacco verticale"+mossa);
				break;
			}
		}
		for (int i = 3; i < 6; i++) {
			Casella casella1 = tabellaTris.getCaselle().get(i);
			Casella casella2 = tabellaTris.getCaselle().get(i+3);
			Casella casella3 = tabellaTris.getCaselle().get(i-3);
			if(casella1.possibileMossaG2(casella2, casella3)){
				mossa =  i-3;
				System.out.println("Attacco verticale"+mossa);
				break;
			}
		}
		
	}
	
	public static int mossaCasuale(TabellaTris tabellaTris){
		Random random = new Random();
		boolean finito = false;
		int k = 0;
		while(!finito&& k<9){
			k++;
			mossa = random.nextInt(9);
			if(tabellaTris.getCaselle().get(mossa).isVuota()){
				finito = true;
				System.out.println("Attacco casuale"+mossa);
			}
		}
		return mossa;
	}
	
	public static int getMossa() {
		return mossa;
	}
	
}
