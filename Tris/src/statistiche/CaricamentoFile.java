package statistiche;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CaricamentoFile {
	
	private ArrayList<String> list;
	private BufferedReader reader;
	/**
	 * Questo metodo permette di impostare il nome e il percorso da file e trasformarlo in un {@link ArrayList}
	 * @param percorsoFile
	 */
	public void setNomeFile(String percorsoFile){
		list = new ArrayList<>();
		try{
			reader = new BufferedReader(new FileReader(new File(percorsoFile)));
			String line = reader.readLine();
			while(line!=null){
				list.add(line);
				line = reader.readLine();
			}
			reader.close();
		}catch (FileNotFoundException exception){
			exception.printStackTrace();
		}catch (IOException exception) {
			exception.printStackTrace();
		}
	}
	/**
	 * Questo funzione permette di recuperare la lista di stringhe, che è stata generata attraverso il metodo @see setNomeFile
	 * @return
	 */
	public ArrayList<String> getList() {
		return list;
	}
	public void setList(ArrayList<String> list) {
		this.list = list;
	}
	

}
