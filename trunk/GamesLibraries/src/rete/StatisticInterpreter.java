package rete;

import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Questa classe ha la responsabilit�� di interpretare un messaggio, contenente
 * le statistiche dei giochi
 * 
 */

public class StatisticInterpreter implements IStatisticInterpreter {

	private String wins;
	private String tie;
	private String lose;
	private ArrayList<String> achievements = new ArrayList<>();

	/*
	 * (non-Javadoc)
	 * 
	 * @see rete.IInterpreteStatistiche#intepreta(java.lang.String)
	 */
	@Override
	public void intepret(String message) {
		StringTokenizer stringTokenizer = new StringTokenizer(message);
		wins = stringTokenizer.nextToken();
		tie = stringTokenizer.nextToken();
		lose = stringTokenizer.nextToken("@").replace(" ", "");
		achievements.clear();
		while (stringTokenizer.hasMoreTokens()) {
			achievements.add(stringTokenizer.nextToken("@"));
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see rete.IInterpreteStatistiche#getVittorie()
	 */
	@Override
	public String getWins() {
		return wins;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see rete.IInterpreteStatistiche#getPareggi()
	 */
	@Override
	public String getTie() {
		return tie;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see rete.IInterpreteStatistiche#getSconfitte()
	 */
	@Override
	public String getLose() {
		return lose;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see rete.IInterpreteStatistiche#getAchievements()
	 */
	

	public String achievementsToString() {
		String achievements = "";
		for (int i = 0; i < this.achievements.size(); i++) {
			achievements += this.achievements.get(i) + " \n";

		}
		return achievements;
	}
}
