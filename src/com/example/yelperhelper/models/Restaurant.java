package com.example.yelperhelper.models;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.text.TextUtils;

public class Restaurant {

	// name
	private String name;

	// avg_rating
	private Double avg_rating;

	// review_count
	private Integer review_count;

	// rating_img_url_small
	private String rating_img_url_small;

	// phone
	private String phone;

	// mobile_url
	private String mobile_url;

	// is_closed
	private boolean is_closed;

	// address1
	private String address1;

	// address2
	private String address2;

	// address3
	private String address3;

	// city
	private String city;

	// id (yelp id)
	private String yelpId;

	// photo_url
	private String photo_url;

	// categories.name
	private List<String> categories;

	public static Restaurant fromJson(JSONObject json) {
		Restaurant restaurant = new Restaurant();
		try {
			// name
			Restaurant r = new Restaurant();
			r.name = json.getString("name");
			r.rating_img_url_small = json.getString("rating_img_url_small");
			r.phone = json.getString("phone");
			r.mobile_url = json.getString("mobile_url");
			r.address1 = json.getString("address1");
			r.address2 = json.getString("address2");
			r.address3 = json.getString("address3");
			r.city = json.getString("city");
			r.yelpId = json.getString("yelpId");
			r.photo_url = json.getString("photo_url");
			r.is_closed = json.getBoolean("is_closed");
			r.avg_rating = json.getDouble("avg_rating");
			r.review_count = json.getInt("review_count");

			// handle categories.name lists
			r.categories = categoryNamesFromJsonArray(json.getJSONArray("categories"));

		} catch (JSONException e) {
			e.printStackTrace();
			return null;
		}
		return restaurant;
	}

	private static ArrayList<String> categoryNamesFromJsonArray(JSONArray jsonArray) {
		ArrayList<String> categories = new ArrayList<String>(jsonArray.length());

		for (int i = 0; i < jsonArray.length(); i++) {
			JSONObject categoryJson = null;
			try {
				categoryJson = jsonArray.getJSONObject(i);
				String category = categoryJson.getString("name");
				if (!TextUtils.isEmpty(category)) {
					categories.add(category);
				}
			} catch (Exception e) {
				e.printStackTrace();
				continue;
			}
		}
		if (categories.isEmpty()) {
			return null;
		}
		return categories;
	}

	public static ArrayList<Restaurant> fromJsonArray(JSONArray jsonArray) {
		ArrayList<Restaurant> restaurants = new ArrayList<Restaurant>(jsonArray.length());

		for (int i = 0; i < jsonArray.length(); i++) {
			JSONObject restaurantJson = null;
			try {
				restaurantJson = jsonArray.getJSONObject(i);
			} catch (Exception e) {
				e.printStackTrace();
				continue;
			}

			Restaurant restaurant = Restaurant.fromJson(restaurantJson);
			if (restaurant != null) {
				restaurants.add(restaurant);
			}
		}

		return restaurants;
	}

	public String getName() {
		return name;
	}

	public Double getAvg_rating() {
		return avg_rating;
	}

	public Integer getReview_count() {
		return review_count;
	}

	public String getRating_img_url_small() {
		return rating_img_url_small;
	}

	public String getPhone() {
		return phone;
	}

	public String getMobile_url() {
		return mobile_url;
	}

	public boolean isIs_closed() {
		return is_closed;
	}

	public String getAddress1() {
		return address1;
	}

	public String getAddress2() {
		return address2;
	}

	public String getAddress3() {
		return address3;
	}

	public String getCity() {
		return city;
	}

	public String getYelpId() {
		return yelpId;
	}

	public String getPhoto_url() {
		return photo_url;
	}

	public List<String> getCategories() {
		return categories;
	}

}
