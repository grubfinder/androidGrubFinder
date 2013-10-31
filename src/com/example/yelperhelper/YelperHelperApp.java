package com.example.yelperhelper;

import android.app.Application;
import android.content.Context;

public class YelperHelperApp extends Application {

	private static Context context;
	private static YelpClient yelpClient;

	@Override
	public void onCreate() {
		super.onCreate();
		YelperHelperApp.context = this;

	}

	public static YelpClient getYelpClient() {
		if (yelpClient == null) {
			try {
				yelpClient = YelpClient.class.getConstructor(Context.class).newInstance(context);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return yelpClient;
	}

}
