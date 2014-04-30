package utils.componenti;

import computerIntelligenza.DifficoltàCasuale;
import computerIntelligenza.ProxyDifficoltà;

public class GuiMain {
	public static void main(String[] args) {
		ProxyDifficoltà difficoltà = new ProxyDifficoltà(new DifficoltàCasuale());
		UI ui = new UI(difficoltà);
	}
}
