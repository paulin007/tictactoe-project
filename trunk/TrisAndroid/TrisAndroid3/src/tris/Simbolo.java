/**
 * Questa classe astrae sul concetto di simbolo, che viene inserito un Tris
 * 
 */
package tris;

public class Simbolo {
	
	public static String simboloG1 = "G1";
	public static String simboloG2 = "G2";
	private String simbolo;
	public Simbolo(String simbolo) {
		super();
		this.simbolo = simbolo;
	}

	public String getSimbolo() {
		return simbolo;
	}

	public void setSimbolo(String simbolo) {
		this.simbolo = simbolo;
	}
	
	@Override
	public String toString(){
		return getSimbolo();
	}
}
