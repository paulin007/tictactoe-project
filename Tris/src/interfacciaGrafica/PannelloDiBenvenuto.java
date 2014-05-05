package interfacciaGrafica;

import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PannelloDiBenvenuto extends JPanel implements PannelloTris {

	@Override
	public JPanel creaPannello() {
		
	
		java.net.URL imgUrl = getClass().getResource("tris.gif");
		ImageIcon image = new ImageIcon(imgUrl);
		
		JLabel label = new JLabel(image);
		JPanel panel1 = new JPanel();
		panel1.setLayout(new FlowLayout());
		panel1.add(new JLabel("Benvenuto nel gioco di Tris ! "));
		
		JPanel panel2 = new JPanel();
		panel2.setLayout(new FlowLayout());
		panel2.add(label);
		
		JPanel contenitore = new JPanel();
		contenitore.setLayout(new BoxLayout(contenitore, BoxLayout.Y_AXIS));
		contenitore.add(panel1);
		contenitore.add(panel2);
		add(contenitore);
		return this;
	}
}
