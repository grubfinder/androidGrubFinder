package com.example.yelperhelper;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

public class Startpage extends Activity {
	ImageView image_view;
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {

		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_startpage);
		
		Button btnLaunchSecond = (Button) findViewById(R.id.findit);
		
		btnLaunchSecond.setOnClickListener(new OnClickListener() {
			@Override

			public void onClick(View v) {
				 Intent i = new Intent(Startpage.this.getApplicationContext(), PictureGridActivity.class);
				 i.putExtra("text", "Passed String Extra!");
				 startActivity(i);
			}
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.startpage, menu);
		return true;
	}

}
