/**
 * Questa classe astrae sul concetto di simbolo, che viene inserito un Tris
 * 
 */
package grafica;

public class Simbolo {
	
	public static String simboloG1 = "G1";
	public static String simboloG2 = "G2";
	public static String casellaVuota = "V";
	private String simbolo;
	public Simbolo(String simbolo) {
		super();
		this.simbolo = simbolo;
	}

	public String getSimbolo() {
		return simbolo;
	}
	
	@Override
	public String toString(){
		return getSimbolo();
	}
}
