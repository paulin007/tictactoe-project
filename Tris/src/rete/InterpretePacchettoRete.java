package rete;


public interface InterpretePacchettoRete {
	/**
	 * Questo metodo permette di interpretare il testo del pacchetto
	 * @param pacchetto
	 */
	public void interpretaPacchetto(String pacchetto);
	/**
	 * Questo metodo permette di recuperare la lista di mosse, che sono
	 *  contenute nel pacchetto
	 * @return
	 */
	public int getUltimaMossaPacchetto();
	/**
	 * Questo metodo permette di recuperare il risultato che è presente nel pacchetto
	 * @return
	 */
	public String getRisultatoPacchetto();
}
