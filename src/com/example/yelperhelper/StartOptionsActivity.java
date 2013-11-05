package com.example.yelperhelper;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.ToggleButton;

public class StartOptionsActivity extends Activity {
	ImageView image_view;

	ToggleButton wakeBtn;
	ToggleButton bikeBtn;
	ToggleButton driveBtn;
	ToggleButton anyBtn;
	
	String selected;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_start_options);
		
		
		wakeBtn = (ToggleButton) findViewById(R.id.distance_walk);
		bikeBtn = (ToggleButton) findViewById(R.id.distance_bike);
		driveBtn = (ToggleButton) findViewById(R.id.distance_drive);
		anyBtn = (ToggleButton) findViewById(R.id.distance_any);

		wakeBtn.setOnCheckedChangeListener(changeChecker);
		bikeBtn.setOnCheckedChangeListener(changeChecker);
		driveBtn.setOnCheckedChangeListener(changeChecker);
		anyBtn.setOnCheckedChangeListener(changeChecker);

		Button btnLaunchSecond = (Button) findViewById(R.id.findit);
		btnLaunchSecond.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent i = new Intent(StartOptionsActivity.this
						.getApplicationContext(), PictureGridActivity.class);
				i.putExtra("selected", selected);
				startActivity(i);
			}
		});

	}

	OnCheckedChangeListener changeChecker = new OnCheckedChangeListener() {

		@Override
		public void onCheckedChanged(CompoundButton buttonView,
				boolean isChecked) {

			if (isChecked) {
				if (buttonView == wakeBtn) {
					bikeBtn.setChecked(false);
					driveBtn.setChecked(false);
					anyBtn.setChecked(false);
					wakeBtn.setChecked(true);
				}
				if (buttonView == bikeBtn) {
					wakeBtn.setChecked(false);
					driveBtn.setChecked(false);
					anyBtn.setChecked(false);
					bikeBtn.setChecked(true);
				}
				if (buttonView == driveBtn) {
					bikeBtn.setChecked(false);
					wakeBtn.setChecked(false);
					anyBtn.setChecked(false);
					driveBtn.setChecked(true);
				}
				if (buttonView == anyBtn) {
					bikeBtn.setChecked(false);
					driveBtn.setChecked(false);
					wakeBtn.setChecked(false);
					anyBtn.setChecked(true);
				}
				
				selected = buttonView.getTag().toString();
			}

		}

	};

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.startpage, menu);
		return true;
	}

}
