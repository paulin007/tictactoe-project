package forza4;


import managers.ITurnManager;
import managers.MatchManager;
import managers.TurnManager;
import paulin.tchonin.trisandroid1.ButtonClickListener;
import paulin.tchonin.trisandroid1.R;
import rete.Client;
import rete.IClient;
import rete.IMessageInterpreter;
import rete.MessageInterpreter;
import statistiche.Statistiche;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;




public class Forza4Activity extends Activity{
    
	
    private String namePlayer1;
	private String namePlayer2;
	private String message;
	
	private boolean connected ;
	private IClient client = new Client();
	private ITurnManager turnManager = new TurnManager();
	private IMessageInterpreter messageInterpreter = new MessageInterpreter();
	private MatchManager matchManager = new MatchManager(client, messageInterpreter);
	private GraphicManagerForza4 graphicManagerForza4 = new GraphicManagerForza4(this, matchManager, turnManager);
	
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_forza4);
        
        //recuperiamo alcuni variabile dell'activiy precedente  
        
        Bundle intent = getIntent().getExtras();
        namePlayer1 = intent.getString("namePlayer1");
        namePlayer2 = intent.getString("namePlayer2");
        message = intent.getString("message");
        
        graphicManagerForza4.createGraphics();
        
        final TextView infoTextView = graphicManagerForza4.getInfoTextView();
        
        
        if(message.equals("start")){
        	matchManager.createNewMatch(namePlayer1, namePlayer2,"forza4");
			turnManager.setMyTurn(true);
			infoTextView.setText(R.string.turn_player1);
        	connected=false;
			startNewGame();
        	
        	
        	
        }else if(message.equals("connect")){
        	infoTextView.setText(R.string.turn_player2);
        	connectToAGame();
        	
        }
       
    }
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
    	inflater.inflate(R.menu.game_menu, menu);
    	
    	return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch(item.getItemId())
    	{	
    	case R.id.statistiche:
    		Intent intent = new Intent(this, Statistiche.class);
	        startActivity(intent);
    		break;
    	
    	case R.id.exitGame:
    		Forza4Activity.this.finish();
    		break;
    	}
 
    	return true;
	}
	
	
	private void startNewGame(){
		
		Button[] listenerButtons = graphicManagerForza4.getListenerButtons();
		graphicManagerForza4.clear();
		for (int i = 0; i < listenerButtons.length; i++) {
			listenerButtons[i].setOnClickListener(new ButtonClickListener(i, matchManager, graphicManagerForza4,turnManager));
		}	
			
	}
	
	private void connectToAGame(){
		
		turnManager.setMyTurn(false);
       startNewGame();
		matchManager.connectToMatch(namePlayer1, namePlayer2,"forza4");
		matchManager.requestUpdate();
		connected = true;
	}
	
	public boolean isConnected() {
		return connected;
	}
	
	public IMessageInterpreter getMessageInterpreter() {
		return messageInterpreter;
	}
}
