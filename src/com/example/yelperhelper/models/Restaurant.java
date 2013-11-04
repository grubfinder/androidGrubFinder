package com.example.yelperhelper.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.text.TextUtils;
import android.util.Log;

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

	//TEMP
	private static String tempList = "[{'id':'tRiDMqAxeBERRvuyYPZ-aw','photo_url':'http://media1.ak.yelpcdn.com/bpthumb/qlwURdu2xqXhw2My86mAzA/ms'},{'id':'1vMgajRAI3lYwuCeGX58oQ','photo_url':'http://media1.ak.yelpcdn.com/bpthumb/Iq1AZCSmoOqjhh5lwnRjfg/ms'},{'id':'ZV2zL3V24AxKsKIvlMPtEQ','photo_url':'http://media2.ak.yelpcdn.com/bpthumb/l_OtVlibHuL9my-BMsIXhg/ms'},{'id':'MGEuV75BBmwb9y4Nk8uUQw','photo_url':'http://media3.ak.yelpcdn.com/bpthumb/yHjXoPMe76EOrg5y4mKgyg/ms'},{'id':'UPjhJoqpbJr0u8mvTOxneQ','photo_url':'http://media4.ak.yelpcdn.com/bpthumb/iIhbjy6DBi9h0FuUy-O1dA/ms'},{'id':'LRLkFtnJvNjmcV_G-dgqmA','photo_url':'http://media1.ak.yelpcdn.com/bpthumb/CUPghD2RKXmnkG0kAs6vpw/ms'},{'id':'AQG8enVJnGepbVow2Jp7SA','photo_url':'http://media1.ak.yelpcdn.com/bpthumb/T456yeGycDkLsuOjyUcSLQ/ms'},{'id':'ZimdCe2xCAOOZjt1aQAMvg','photo_url':'http://media1.ak.yelpcdn.com/bpthumb/vLUxhNuQyO2nmKXl-jMLmA/ms'},{'id':'m5D-kljBl7q_xiI02r6EcQ','photo_url':'http://media1.ak.yelpcdn.com/bpthumb/benIjfVLbsTsdRD6PIbMvw/ms'},{'id':'VkR8UKEuUNnERao2NDYyJg','photo_url':'http://media1.ak.yelpcdn.com/bpthumb/ho9VdlL8bGPXZfs51ZfPbg/ms'},{'id':'vRhk8dBqWuGPG03E-Ev2nQ','photo_url':'http://media1.ak.yelpcdn.com/bpthumb/i3SVn5moCgij7NS13BCowQ/ms'},{'id':'E7kHPV2jKP9KVkGi6XnYJQ','photo_url':'http://media3.ak.yelpcdn.com/bpthumb/fiwsQXgdaKevJQO1yd00hw/ms'},{'id':'tRiDMqAxeBERRvuyYPZ-aw','photo_url':'http://media1.ak.yelpcdn.com/bpthumb/qlwURdu2xqXhw2My86mAzA/ms'},{'id':'1vMgajRAI3lYwuCeGX58oQ','photo_url':'http://media1.ak.yelpcdn.com/bpthumb/Iq1AZCSmoOqjhh5lwnRjfg/ms'},{'id':'ZV2zL3V24AxKsKIvlMPtEQ','photo_url':'http://media2.ak.yelpcdn.com/bpthumb/l_OtVlibHuL9my-BMsIXhg/ms'},{'id':'MGEuV75BBmwb9y4Nk8uUQw','photo_url':'http://media3.ak.yelpcdn.com/bpthumb/yHjXoPMe76EOrg5y4mKgyg/ms'},{'id':'UPjhJoqpbJr0u8mvTOxneQ','photo_url':'http://media4.ak.yelpcdn.com/bpthumb/iIhbjy6DBi9h0FuUy-O1dA/ms'},{'id':'LRLkFtnJvNjmcV_G-dgqmA','photo_url':'http://media1.ak.yelpcdn.com/bpthumb/CUPghD2RKXmnkG0kAs6vpw/ms'},{'id':'AQG8enVJnGepbVow2Jp7SA','photo_url':'http://media1.ak.yelpcdn.com/bpthumb/T456yeGycDkLsuOjyUcSLQ/ms'},{'id':'ZimdCe2xCAOOZjt1aQAMvg','photo_url':'http://media1.ak.yelpcdn.com/bpthumb/vLUxhNuQyO2nmKXl-jMLmA/ms'},{'id':'m5D-kljBl7q_xiI02r6EcQ','photo_url':'http://media1.ak.yelpcdn.com/bpthumb/benIjfVLbsTsdRD6PIbMvw/ms'},{'id':'VkR8UKEuUNnERao2NDYyJg','photo_url':'http://media1.ak.yelpcdn.com/bpthumb/ho9VdlL8bGPXZfs51ZfPbg/ms'},{'id':'vRhk8dBqWuGPG03E-Ev2nQ','photo_url':'http://media1.ak.yelpcdn.com/bpthumb/i3SVn5moCgij7NS13BCowQ/ms'},{'id':'E7kHPV2jKP9KVkGi6XnYJQ','photo_url':'http://media3.ak.yelpcdn.com/bpthumb/fiwsQXgdaKevJQO1yd00hw/ms'}]";
	
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
	
	

	public static ArrayList<Map> getRestaurantLists() {
		Map<String,String> out = new HashMap<String, String>();
		ArrayList<Map> list = new ArrayList<Map>();    
		try {
			JSONArray jsonObject = new JSONArray(tempList);
			for (int i = 0; i < jsonObject.length(); i++) {
				jsonObject.getJSONObject(i);
				Map<String, String> map = new HashMap<String, String>();
				map.put("id",  jsonObject.getJSONObject(i).get("id").toString());
				map.put("photo_url",  jsonObject.getJSONObject(i).get("photo_url").toString());
				list.add(map);
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
		
	
	


	public String getName() {
//		return name;
		return "Urban Curry";
	}

	public float getAvg_rating() {
//		return avg_rating;
		return (float) 4.0;
	}

	public Integer getReview_count() {
//		return review_count;
		return 227;
	}

	public String getRating_img_url_small() {
//		return rating_img_url_small;
		return "http://media2.ak.yelpcdn.com/static/20101216418129184/img/ico/stars/stars_small_4.png";
	}

	public String getPhone() {
//		return phone;
		return "(415)677-9744";
	}

	public String getMobile_url() {
//		return mobile_url;
		return "http://m.yelp.com/biz/EFjaNaqg2foSIM--mML49g";
	}

	public boolean isIs_closed() {
//		return is_closed;
		return false;
	}

	public String getAddress1() {
//		return address1;
		return "523 Broadway";
	}

	public String getAddress2() {
//		return address2;
		return  "North Beach/Telegraph Hill";
	}

	public String getAddress3() {
//		return address3;
		return "San Francisco, CA 94133";
	}

	public String getCity() {
//		return city;
		return "San Francisco";
	}

	public String getYelpId() {
//		return yelpId;
		return "urban-curry-san-francisco";
	}

	public String getPhoto_url() {
//		return photo_url;
		return "http://s3-media4.ak.yelpcdn.com/bphoto/Hv5vsWpqeaUKepr9nffJnw/l.jpg";
	}

	public List<String> getCategories() {
//		return categories;
		return new ArrayList<String>() {{
		    add("Indian");
		    add("Pakistani");
		}};
	}

}
