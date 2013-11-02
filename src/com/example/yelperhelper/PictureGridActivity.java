package com.example.yelperhelper;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;

public class PictureGridActivity extends Activity {

	GridView gridView;
	 
	static final String[] TEMPARR = new String[] { "A", "D", "B", "C", "D",
			"A", "C", "D", "B", "C", "B", "D", "A", "C", "A", "B", "A", "D",
			"A", "C", "A", "B", "A", "D", "A", "B", "C", "A", "C", "A", "B",
			"A", "D", "D" };

	@Override
	public void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_picture_grid);
 
		gridView = (GridView) findViewById(R.id.pictureGrid);
 
		gridView.setAdapter(new ImageAdapter(this, TEMPARR));
		
		gridView.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View v,
					int position, long id) {
					
					Intent i = new Intent(PictureGridActivity.this.getApplicationContext(), DetailsFragment.class);
					 i.putExtra("text", "Passed ID::"+String.valueOf(id));
					 startActivity(i);
			}
		});
		
		
		
		Button backoption = (Button) findViewById(R.id.backoption);

		backoption.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent i = new Intent(PictureGridActivity.this.getApplicationContext(),
						StartOptionsActivity.class);
				startActivity(i);
			}
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.picture_grid, menu);
		return true;
	}

}
