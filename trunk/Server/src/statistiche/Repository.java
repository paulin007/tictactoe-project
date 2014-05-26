package statistiche;

import java.util.HashMap;
import java.util.Set;

public class Repository {
	
	private HashMap<String, Achievement> achievements = new HashMap<String, Achievement>();
	
	public Set<String> getPlayersName() {		
		return achievements.keySet();
	}
	
	public Achievement getAchievement(String player) {
		Achievement achievement = achievements.get(player);
		if(achievement==null) {
			achievement = new Achievement();
			achievements.put(player, achievement);
		}
		return achievement;
	}
	
	public void EditAchievement(String player, String outcome) {
		Achievement achievement = getAchievement(player);
		String sequence = achievement.getSequence();
		sequence = sequence + outcome;
		achievement.setSequence(sequence);
	}
	
	public void addAchievement(String player, Achievement achievement) {		
		achievements.put(player, achievement);
	}
}
