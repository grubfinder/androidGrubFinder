package com.example.yelperhelper;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Details extends FragmentActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_details);

		Button btnWantIt = (Button) findViewById(R.id.wantit);

		btnWantIt.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent i = new Intent(Details.this.getApplicationContext(),
						PictureGridActivity.class);
				i.putExtra("text", "Passed String Extra!");
				startActivity(i);
			}
		});
		
		
		Button btnNah = (Button) findViewById(R.id.nah);

		btnNah.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent i = new Intent(Details.this.getApplicationContext(),
						PictureGridActivity.class);
				i.putExtra("text", "Passed String Extra!");
				startActivity(i);
			}
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.details, menu);
		return true;
	}

}
