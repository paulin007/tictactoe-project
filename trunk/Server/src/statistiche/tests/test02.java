package statistiche.tests;

import statistiche.StatisticManager;

public class test02 {
	public static void main(String[] args) {

		(new StatisticManager()).nuovaStatistica("Giacomo", "s");
		
		System.out.println((new StatisticManager()).getStatistica("Giacomo"));	
	}

}
