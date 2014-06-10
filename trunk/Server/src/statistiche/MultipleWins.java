package statistiche;

public class MultipleWins implements IAchievements{

	@Override
	public boolean gotAchievements(String sequence, int param) {
			int wins = 0;
			
			for (int i = 0; i < sequence.length(); i++) {
				if(sequence.charAt(i)=='V')
					wins++;
				
			}
		
			if(wins>=param)
				return true;
			return false;
			}
		
	}


