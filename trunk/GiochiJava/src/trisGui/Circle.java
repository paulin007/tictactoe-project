package trisGui;

import managers.DefaultSettings;


/**
 * Disegna una delle due icone usate durante un partita
 */
public class Circle implements Icon{

	private IconDrawer drawer;
	
	public Circle (){
		drawer = new IconDrawer(DefaultSettings.getSettings().getPath("cerchio"));
	}
	
	@Override
	public IconDrawer getDrawer() {
		return drawer;
	}
	
	private Circle(IconDrawer drawer) {
		this.drawer=drawer;
	}
	
	/**
	 * 
	 */
	@Override
	public Circle clone() {
		return new Circle(drawer);
	}
}
