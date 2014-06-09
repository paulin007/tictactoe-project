package trisGui;

import managers.DefaultSettings;


/**
 * Disegna una delle due icone usate durante un partita
 * 
 * @author K. ADJIGNON
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
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#clone()
	 */
	@Override
	public Circle clone() {
		return new Circle(drawer);
	}
}
