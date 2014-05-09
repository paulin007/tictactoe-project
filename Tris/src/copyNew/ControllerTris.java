package copyNew;
import tris.TabellaTris;
import vincita.AlgoritmoTris;
import computerIntelligenza.DifficoltàSemplice;
import computerIntelligenza.ProxyDifficoltà;

public class ControllerTris {

	private ProxyDifficoltà proxyDifficolta;
	private ProxyPannelloTris proxyPannelloTris;
	private PannelloCheckBox pannelloCheckBox;
	private TabellaTris tabellaTris;
	private AlgoritmoTris algoritmoTris;
	
	
	public ControllerTris(ProxyDifficoltà proxyDifficolta,
			ProxyPannelloTris proxyPannelloTris, TabellaTris tabellaTris,
			AlgoritmoTris algoritmoTris) {
		super();
		this.proxyDifficolta = proxyDifficolta;
		this.proxyPannelloTris = proxyPannelloTris;
		this.tabellaTris = tabellaTris;
		this.algoritmoTris = algoritmoTris;
	}
	public PannelloCheckBox getPannelloCheckBox() {
		return pannelloCheckBox;
	}

	
	public ProxyPannelloTris getProxyPannelloTris() {
		return proxyPannelloTris;
	}

	public void setProxyPannelloTris(ProxyPannelloTris proxyPannelloTris) {
		this.proxyPannelloTris = proxyPannelloTris;
	}

	public ProxyDifficoltà getProxyDifficolta() {
		return proxyDifficolta;
	}

	public void setProxyDifficolta(ProxyDifficoltà proxyDifficolta) {
		this.proxyDifficolta = proxyDifficolta;
	}

	public TabellaTris getTabellaTris() {
		return tabellaTris;
	}

	public void setTabellaTris(TabellaTris tabellaTris) {
		this.tabellaTris = tabellaTris;
	}

	public AlgoritmoTris getAlgoritmoTris() {
		return algoritmoTris;
	}

	public void setAlgoritmoTris(AlgoritmoTris algoritmoTris) {
		this.algoritmoTris = algoritmoTris;
	}
	
	public void setPannelloCheckBox(){
		pannelloCheckBox = new PannelloCheckBox(this);
		proxyPannelloTris.setPannelloTris(pannelloCheckBox);
	}
	
	public void setPannelloGioco(){
		PannelloGioco pannelloGioco = new PannelloGioco(this);
		proxyPannelloTris.setPannelloTris(pannelloGioco);
	}
	
	public void resetController(){
		setProxyDifficolta(new ProxyDifficoltà(new DifficoltàSemplice()));
		setTabellaTris(new TabellaTris());
		setAlgoritmoTris(new AlgoritmoTris());
	}
}
