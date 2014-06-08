package tests;

import grafica.WelcomePanel;

import javax.swing.JFrame;

public class Test12 {

	public static void main(String[] args) {
		
		JFrame frame = new JFrame("Test 04");
		frame.setVisible(true);
		frame.getContentPane().add(new WelcomePanel());
		frame.pack();
		frame.setSize(600, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocation(100, 100);
	}
}
