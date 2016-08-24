package game.dev.specter_stalker;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Settings extends Activity {
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.settings_screen);
		
	}
	
	 public void bkButtonClicked(View button) {
	    	// Create an intent to associate button clicked with Popup class
	    	Intent intent = new Intent (this, MainScreen.class);
	    	this.startActivity(intent);	
	    }
	 
	 //difficulties
	 public int easyClicked(View button) {
	    	return 1;
	    }	
	 public int mediumClicked(View button) {
	    	return 2;
	    }	
	 public int hardClicked(View button) {
	    	return 3;
	    }	
}