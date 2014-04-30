/**
 * Questa classe astrae sul concetto di posizione, che viene rappresentato da una
 * riga e da una colonna
 * @author Giacomo
 */
package tris;

public class Posizione {
	
	private int riga;
	private int colonna;
	
	public Posizione(int riga, int colonna) {
		super();
		this.riga = riga;
		this.colonna = colonna;
	}
	public int getRiga() {
		return riga;
	}
	public void setRiga(int riga) {
		this.riga = riga;
	}
	public int getColonna() {
		return colonna;
	}
	public void setColonna(int colonna) {
		this.colonna = colonna;
	}
	@Override
	public String toString(){
		return "posizione: "+getRiga()+" "+getColonna();
	}
}
