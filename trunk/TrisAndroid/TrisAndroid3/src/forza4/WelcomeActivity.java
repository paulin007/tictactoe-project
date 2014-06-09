package forza4;


import paulin.tchonin.trisandroid1.ActivityOnline;
import paulin.tchonin.trisandroid1.R;
import statistiche.Statistiche;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class WelcomeActivity extends Activity implements View.OnClickListener{

	private Button playTris;
	private Button playforza4;
	private Button statistiche;
	
	 public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.layout_welcome);
	       init(); 
	    }
	 
	 private void init(){
		 playTris    = (Button)(this.findViewById(R.id.open_tris));
		 playforza4  = (Button)(this.findViewById(R.id.open_forza4));
		 statistiche = (Button)(this.findViewById(R.id.open_statistiche));
	    	playTris.setOnClickListener(this);	
	    	playforza4.setOnClickListener(this);
	    	statistiche.setOnClickListener(this);
	 }

	@Override
	public void onClick(View v) {
		if(v.getId()==R.id.open_tris){
        
		Intent intent = new Intent(this, ActivityOnline.class);
	        startActivity(intent);
		}
		else if(v.getId()==R.id.open_forza4){
			
			Intent intent = new Intent(this, Forza4Settings.class);
	        this.startActivity(intent);
		}else if (v.getId()==R.id.open_statistiche){
			Intent intent = new Intent(this, Statistiche.class);
	        startActivity(intent);
		}
		
	}
}
