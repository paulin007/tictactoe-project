package interfacciaGrafica;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class PannelloDiBenvenuto extends JPanel implements PannelloTris {

	@Override
	public JPanel creaPannello() {
		
		setBackground(Color.white);
		
		java.net.URL imgUrl = getClass().getResource("tris.png");
		ImageIcon image = new ImageIcon(imgUrl);
		Font font = new Font("Verdana", Font.BOLD, 16);
		JLabel label = new JLabel(image);
		JPanel panel1 = new JPanel();
		panel1.setBackground(Color.white);
		panel1.setLayout(new FlowLayout());
		JLabel label1 = new JLabel("Benvenuto nel gioco del Tris ! ");
		label1.setFont(font);
		panel1.add(label1);
		
		JPanel panel2 = new JPanel();
		panel2.setLayout(new FlowLayout());
		panel2.setBackground(Color.white);
		panel2.add(label);
		
		JPanel contenitore = new JPanel();
		contenitore.setBackground(Color.white);
		contenitore.setLayout(new BoxLayout(contenitore, BoxLayout.Y_AXIS));
		contenitore.add(panel1);
		contenitore.add(panel2);
		add(contenitore);
		return this;
	}
}
