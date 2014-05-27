package statistiche;

public class VittorieMultiple implements IAchievements{

	@Override
	public boolean haConquistatoRisultato(String sequenza, int param) {
			int vittorie = 0;
			
			for (int i = 0; i < sequenza.length(); i++) {
				if(sequenza.charAt(i)=='V')
					vittorie++;
				
			}
		
			if(vittorie>=param)
				return true;
			return false;
			}
		
	}


