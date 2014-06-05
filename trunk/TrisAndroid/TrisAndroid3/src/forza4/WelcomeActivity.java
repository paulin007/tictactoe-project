package forza4;

//import paulin.tchonin.trisandroid1.TrisActivity;
import paulin.tchonin.trisandroid1.ActivityOnline;
import paulin.tchonin.trisandroid1.GraphicManager;
import paulin.tchonin.trisandroid1.R;
//import paulin.tchonin.trisandroid1.UIManager;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class WelcomeActivity extends Activity implements View.OnClickListener{

	private Button playTris;
	private Button playforza4;
	
	 public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.layout_welcome);
	       init(); 
	    }
	 
	 private void init(){
		 playTris = (Button)(this.findViewById(R.id.open_tris));
	    	playTris.setOnClickListener(this);
	    	playforza4 = (Button)(this.findViewById(R.id.open_forza4));
	    	playforza4.setOnClickListener(this);
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
		}
		
	}
}
