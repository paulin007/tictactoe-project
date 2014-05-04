package newGui;

import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class PannelloDiBenvenuto extends JPanel implements PannelloTris {
	
	private String percorsoImmagine = "./src/tris.gif";

	@Override
	public JPanel creaPannello() {
		JPanel scritta = new JPanel();
		JPanel immagine = new JPanel();
		setLayout(new GridLayout(2, 1));
		JTextArea area = new JTextArea();
		area.setText("Benvenuto nel gioco di Tris ! ");
		area.setEditable(false);
		scritta.add(area);
		ImageIcon icon = new ImageIcon(percorsoImmagine);
		add(scritta);
		add(immagine);
		return this;
	}
}
