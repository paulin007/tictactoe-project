package tests;

import javax.swing.JFrame;

import forza4Gui.Forza4Button;

public class Test05 {

	public static void main(String[] args) {
		
		Forza4Button button = new Forza4Button();
		
		JFrame frame = new JFrame("Test 04");
		frame.setVisible(true);
		frame.getContentPane().add(button);
		frame.pack();
		frame.setSize(600, 600);
		frame.setDefaultCloseOperation(3);
		frame.setLocation(100, 100);
	}
}
