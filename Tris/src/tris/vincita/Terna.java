/**
 * Questa classe astrae sul concetto di terna, la quale contiene 3 numeri
 * @author Giacomo
 */
package tris.vincita;

public class Terna {
	
	private int x;
	private int y;
	private int z;
	
	public Terna(int x, int y, int z) {
		super();
		this.x = x;
		this.y = y;
		this.z = z;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getZ() {
		return z;
	}
	public void setZ(int z) {
		this.z = z;
	}
	@Override
	public String toString(){
		return getX()+" "+getY()+" "+getZ();
	}
}
