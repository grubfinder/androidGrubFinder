package com.example.yelperhelper;

import java.io.InputStream;
import java.net.URL;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

public class ImageAdapter extends BaseAdapter {
	private Context context;
	private final String[] arrValValues;

	public ImageAdapter(Context context, String[] arrValValues) {
		this.context = context;
		this.arrValValues = arrValValues;
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

			String arrVal = arrValValues[position];

			if (arrVal.equals("A")) {

				String URL = "http://s3-media1.ak.yelpcdn.com/bphoto/88YvMoR40hh8Bue59gXtMA/l.jpg";
				imageView.setTag(URL);
				new DownloadImagesTask().execute(imageView);

			} else if (arrVal.equals("B")) {
				// imageView.setImageResource(R.drawable.ios_logo);
				String URL = "http://s3-media4.ak.yelpcdn.com/bphoto/AGBs6zmUDJDqrUYop0QwrQ/sl.jpg";
				imageView.setTag(URL);
				new DownloadImagesTask().execute(imageView);

			} else if (arrVal.equals("C")) {

				String URL = "http://s3-media2.ak.yelpcdn.com/bphoto/SQ40hYm3XcuBPp2iwqjj9g/sl.jpg";
				imageView.setTag(URL);
				new DownloadImagesTask().execute(imageView);

			} else {
				String URL = "http://s3-media4.ak.yelpcdn.com/bphoto/mr13QTyoIVt2SfIUike_bA/ms.jpg";
				imageView.setTag(URL);
				new DownloadImagesTask().execute(imageView);
			}

		} else {
			gridView = (View) convertView;
		}

		return gridView;
	}

	private Drawable LoadImageFromURL(String url) {
		try {
			InputStream is = (InputStream) new URL(url).getContent();

			Drawable d = Drawable.createFromStream(is, "src");
			return d;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	@Override
	public int getCount() {
		return arrValValues.length;
	}

	@Override
	public Object getItem(int position) {
		return null;
	}

	@Override
	public long getItemId(int position) {
		return 0;
	}

}
