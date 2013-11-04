package com.example.yelperhelper;

import java.util.ArrayList;
import java.util.Map;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

public class ImageAdapter extends BaseAdapter {
	private Context context;
	private ArrayList<Map> restaurantMap;

	public ImageAdapter(Context context, ArrayList<Map> restaurantMap) {
		this.context = context;
		this.restaurantMap = restaurantMap;
	}

	public View getView(int position, View convertView, ViewGroup parent) {

		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

		View gridView;

		if (convertView == null) {

			gridView = new View(context);

			// get layout from arrVal.xml
			gridView = inflater.inflate(R.layout.activity_picture, null);

			// set image based on selected text
			ImageView imageView = (ImageView) gridView
					.findViewById(R.id.grid_item_image);

			String URL = restaurantMap.get(position).get("photo_url")
					.toString();
			imageView.setTag(URL);
			new DownloadImagesTask().execute(imageView);

		} else {
			gridView = (View) convertView;
		}

		return gridView;
	}


	@Override
	public Object getItem(int position) {
		return null;
	}

	@Override
	public long getItemId(int position) {
		return 0;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return this.restaurantMap.size();
	}

}
