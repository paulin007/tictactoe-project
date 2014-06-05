package grafica;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

import managers.IMatchManager;
import managers.ITurnManager;
import rete.IClient;
import rete.IStatisticInterpreter;
/**
 * Questa classe ha la reposanbilità di gestire il menu dell'applicazione Tris
 */
@SuppressWarnings("serial")
public class MenuGui extends JMenuBar {
	
	private JMenu games = new JMenu("Giochi");
	private JMenuItem tris = new JMenuItem("Tris");
	private JMenuItem forza4 = new JMenuItem("Forza4");
	private JMenu record = new JMenu("Statistiche");
	private JMenuItem statisticItem = new JMenuItem("Statistiche");
	private IMatchManager matchManager;
	private ITurnManager turnManager;
	
	public MenuGui(final MainPanel mainPanel, IMatchManager matchManager, 
			ITurnManager turnManager, IStatisticInterpreter interpreteStatistiche, IClient client) {
		this.matchManager = matchManager;
		this.turnManager = turnManager;
		setGameMenu(mainPanel);
		record.add(statisticItem);
		statisticItemListener(mainPanel, interpreteStatistiche, client);
		setMainMenu();
		setShortcut();
	}

	private void statisticItemListener(final MainPanel mainPanel, final IStatisticInterpreter interpreteStatistiche, final IClient client) {
		statisticItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				mainPanel.setPanel(new StatisticPanel(interpreteStatistiche, client));
				
			}
		});
	}

	private void setMainMenu() {
		add(games);
		add(record);
	}

	private void setGameMenu(final MainPanel mainPanel) {
		games.add(tris);
		games.add(forza4);
		gameItemListener(tris, mainPanel, "Tris");
		gameItemListener(forza4, mainPanel, "forza4");
	}
	
	private void gameItemListener(JMenuItem gameItem, final MainPanel mainPanel, final String gameName){
		gameItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				mainPanel.setGame(gameName);
				mainPanel.setPanel(new PlayersPanel(mainPanel, matchManager, turnManager));
			}
		});
	}
	
	private void setShortcut(){
		tris.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T,InputEvent.CTRL_MASK ));
		forza4.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F,InputEvent.CTRL_MASK ));
		statisticItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,InputEvent.CTRL_MASK ));
	}
}


