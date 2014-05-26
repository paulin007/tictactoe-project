package statistiche.tests;

import java.util.Collections;
import java.util.TreeSet;

import statistiche.Achievement;
import statistiche.Repository;
import statistiche.StatisticManager;
import statistiche.XMLDataManager;
import statistiche.XMLManager;

public class test01 {

	public static void main(String[] args) {
		
		XMLDataManager dataManager = new XMLDataManager();
		XMLManager xmlManager = new XMLManager(dataManager);
		
		TreeSet<String> players = new TreeSet<>();
		
		Collections.addAll(players, "Kokou","Giacomo","Andrea","Dario","Santo",
								"Paulin","Marco");
		
		Repository repo = new Repository();
		
		for(String player : players){
			repo.addAchievement(player, new Achievement());		
		}
		xmlManager.storeData(repo);
	}
	
}
