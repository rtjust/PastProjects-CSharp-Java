package com.robjust.landonswords;

import com.robjust.landonswords.R;


import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.media.MediaPlayer;;

public class MainActivity extends Activity implements OnClickListener{
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
	    ImageButton testButton = (ImageButton)findViewById(R.id.iBtnCar);
	    testButton.setOnClickListener(this);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.carstart);
		mediaPlayer.setVolume(1.0f, 1.0f);
		mediaPlayer.start();
		
	}

}
