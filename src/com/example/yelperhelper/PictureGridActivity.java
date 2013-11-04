package com.example.yelperhelper;

import java.util.ArrayList;
import java.util.Map;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.GridView;

import com.example.yelperhelper.models.Restaurant;

public class PictureGridActivity extends Activity {

	GridView gridView;
	ArrayList<Map> rstrList;

	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_picture_grid);

		rstrList = Restaurant.getRestaurantLists();

		gridView = (GridView) findViewById(R.id.pictureGrid);
		gridView.setAdapter(new ImageAdapter(this, rstrList));
		gridView.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View v,
					int position, long id) {

				Intent i = new Intent(PictureGridActivity.this
						.getApplicationContext(), DetailsFragment.class);
				i.putExtra("id", rstrList.get(position).get("id").toString());
				startActivity(i);
			}
		});

		Button backoption = (Button) findViewById(R.id.backoption);

		backoption.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent i = new Intent(PictureGridActivity.this
						.getApplicationContext(), StartOptionsActivity.class);
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
