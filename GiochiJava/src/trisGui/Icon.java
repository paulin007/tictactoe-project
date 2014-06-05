package trisGui;
/**
 * Prototype
 * Un'astrazione sul concetto di Icona
 */
public interface Icon {
	
	public Icon clone();
	
	public IconDrawer getDrawer();	
}
