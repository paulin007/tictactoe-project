package tests;

import grafica.ChallengeLabel;
import javax.swing.JFrame;
/**
 * Test sulla classe {@link ChallengeLabel}
 * @author Dario
 *
 */
public class Test06 {

public static void main(String[] args) {
		
		ChallengeLabel label = new ChallengeLabel("VS");
		
		JFrame frame = new JFrame("Test 04");
		frame.setVisible(true);
		frame.getContentPane().add(label);
		frame.pack();
		frame.setSize(600, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocation(100, 100);
	}
}
