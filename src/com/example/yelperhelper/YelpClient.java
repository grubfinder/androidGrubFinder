package com.example.yelperhelper;

import java.util.HashMap;
import java.util.Map;

import com.loopj.android.http.AsyncHttpClient;

public class YelpClient {

	private Map<String, String> paramMap = new HashMap<String, String>();

	private static final String BASE_URL = "http://api.yelp.com/business_review_search?term=yelp&";
	private static final String API_KEY = "_5p2jg6AvgU3FL9vKQtnGw";
	private static final String API_PARAM_KEY = "YWSID";
	private static AsyncHttpClient client = new AsyncHttpClient();
	
	// 37.41536,-122.024644
	// http://api.yelp.com/business_review_search?term=restaurants&lat=37.41536&long=-122.024644&radius=10&limit=12&ywsid=_5p2jg6AvgU3FL9vKQtnGw
	// http://api.yelp.com/business_review_search?term=yelp&lat=37.788022&long=-122.399797&radius=10&limit=5&ywsid=XXXXXXXXXXXXXXXXXX

}
