package statistiche;

public class VittorieConsecutive implements IAchievements{

	@Override
	public boolean haConquistatoRisultato(String sequenza, int param) {

		String esito = "";
		
		for (int i = 0; i < param; i++) {
			esito += "V";
			
		}
		
		if(sequenza.contains(esito))
			return true;
		
		return false;
	}
	

}
