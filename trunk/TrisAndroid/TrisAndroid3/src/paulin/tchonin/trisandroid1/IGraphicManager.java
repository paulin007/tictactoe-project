package paulin.tchonin.trisandroid1;

import java.util.ArrayList;
import java.util.Observer;

public interface IGraphicManager extends Observer {

	public void createGraphics();
	
	public void clear();
	
	public void paint(ArrayList<String> caselle);
	
}
