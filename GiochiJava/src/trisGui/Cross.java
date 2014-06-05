package trisGui;

import managers.DefaultSettings;
/**
 * Disegna una delle due icone usate durante un partita
 * 
 * @author Kokou Adjignon
 */
public class Cross implements Icon {

	
	private IconDrawer drawer;
	
	public Cross() {
		drawer = new IconDrawer(DefaultSettings.getSettings().getPath("croce"));
	}
	
	private Cross(IconDrawer drawer) {
		this.drawer=drawer;
	}

	@Override
	public IconDrawer getDrawer() {		
		return drawer;
	}
	
	@Override
	public Cross clone() {		
		return new Cross(drawer);
	}
}
