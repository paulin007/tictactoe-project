package statistiche;

public class ConsecutiveWins implements IAchievements{

	@Override
	public boolean gotAchievements(String sequence, int param) {

		String score = "";
		
		for (int i = 0; i < param; i++) {
			score += "V";
			
		}
		
		if(sequence.contains(score))
			return true;
		
		return false;
	}
	

}
