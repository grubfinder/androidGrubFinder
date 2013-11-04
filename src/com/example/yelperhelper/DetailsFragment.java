package com.example.yelperhelper;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.json.JSONObject;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.yelperhelper.models.Restaurant;

public class DetailsFragment extends FragmentActivity {

	JSONObject resultjson;
	// private String result =
	// "{'categories':[['Indian','indpak'],['Pakistani','pakistani']],'deals':[{'currency_code':'USD','image_url':'http://s3-media4.ak.yelpcdn.com/dphoto/ShQGf5qi-52HwPiKyZTZ3w/m.jpg','options':[{'formatted_original_price':'$20','formatted_price':'$10','is_quantity_limited':true,'original_price':2000,'price':1000,'purchase_url':'http://www.yelp.com/deal/cC24ccQGIH8mowfu5Vbe0Q/view','remaining_count':36,'title':'$10 for $20 voucher'}],'url':'http://www.yelp.com/biz/urban-curry-san-francisco?deal=1','is_popular':true,'time_start':1317414369,'title':'$10 for $20 voucher'}],'display_phone':'+1-415-677-9744','gift_certificates':[{'currency_code':'USD','image_url':'http://s3-media4.ak.yelpcdn.com/bphoto/Hv5vsWpqeaUKepr9nffJnw/m.jpg','options':[{'formatted_price':'$25','price':2500},{'formatted_price':'$50','price':5000}],'url':'http://www.yelp.com/gift-certificates/some-donut-place-pasadena','id':'ZZy5EwrI3wyHw8y54jZruA','unused_balances':'CREDIT'}],'id':'urban-curry-san-francisco','image_url':'http://s3-media4.ak.yelpcdn.com/bphoto/Hv5vsWpqeaUKepr9nffJnw/ms.jpg','is_claimed':true,'is_closed':false,'location':{'address':['523 Broadway'],'city':'San Francisco','country_code':'US','cross_streets':'Kearny St & Romolo Pl','display_address':['523 Broadway','(b/t Kearny St & Romolo Pl)','North Beach/Telegraph Hill','San Francisco, CA 94133'],'neighborhoods':['North Beach/Telegraph Hill'],'postal_code':'94133','state_code':'CA'},'mobile_url':'http://m.yelp.com/biz/EFjaNaqg2foSIM--mML49g','name':'Urban Curry','phone':'4156779744','rating':4,'rating_img_url':'http://media2.ak.yelpcdn.com/static/201012164084228337/img/ico/stars/stars_4.png','rating_img_url_large':'http://media4.ak.yelpcdn.com/static/20101216169592178/img/ico/stars/stars_large_4.png','rating_img_url_small':'http://media2.ak.yelpcdn.com/static/20101216418129184/img/ico/stars/stars_small_4.png','review_count':227,'reviews':[{'excerpt':'I gave this restaurant two stars just because of the extremely quick delivery and friendly delivery guy, but the food was nothing I would order again....','id':'-RDZxLTUExM9Q02x4hZmHg','rating':2,'rating_image_large_url':'http://media2.ak.yelpcdn.com/static/20101216220207235/img/ico/stars/stars_large_2.png','rating_image_small_url':'http://media4.ak.yelpcdn.com/static/201012164278297776/img/ico/stars/stars_small_2.png','rating_image_url':'http://media4.ak.yelpcdn.com/static/201012163489049252/img/ico/stars/stars_2.png','time_created':1317939620,'user':{'id':'AUEDVbP9XNlOcgYOAfR8yg','image_url':'http://s3-media2.ak.yelpcdn.com/photo/0CX0RSoz8NkPlOTo7Ckqdg/ms.jpg','name':'Holly E.'}},{'excerpt':'word on the streets!...get the goat!...quick call to check on the goat...goat is available!...pre-drinking before dinner...no alcohol at urban...','id':'Zpfqx8FI8Pdpo-QVi8BCFA','rating':3,'rating_image_large_url':'http://media3.ak.yelpcdn.com/static/201012161053250406/img/ico/stars/stars_large_3.png','rating_image_small_url':'http://media1.ak.yelpcdn.com/static/201012162337205794/img/ico/stars/stars_small_3.png','rating_image_url':'http://media1.ak.yelpcdn.com/static/201012161694360749/img/ico/stars/stars_3.png','time_created':1317918655,'user':{'id':'JnGtgOPpkjyWOvWM0SYEXg','image_url':'http://s3-media4.ak.yelpcdn.com/photo/On-6060NIAqIS_PfAVwDrg/ms.jpg','name':'hen a.'}},{'excerpt':'Urban Curry was okay. Friendly service and quick delivery but the food was very average in my opinion.\n\nThe best part of the meal was the vegetable pakoras...','id':'FPagv5DTlPQ2h_Son5N0UA','rating':3,'rating_image_large_url':'http://media3.ak.yelpcdn.com/static/201012161053250406/img/ico/stars/stars_large_3.png','rating_image_small_url':'http://media1.ak.yelpcdn.com/static/201012162337205794/img/ico/stars/stars_small_3.png','rating_image_url':'http://media1.ak.yelpcdn.com/static/201012161694360749/img/ico/stars/stars_3.png','time_created':1317746299,'user':{'id':'tZA9Uztmj69tgvlHiiMKsg','image_url':'http://s3-media3.ak.yelpcdn.com/photo/I87X9o6NgGrkO1lfBL5-4Q/ms.jpg','name':'Chelsea J.'}}],'snippet_image_url':'http://s3-media1.ak.yelpcdn.com/photo/39c5Vpe0cFCtZ-rmgAr3YQ/ms.jpg','snippet_text':'Shame on me for taking so long to update a review.\n\nI have been there several times now and love it everytime.\n\nDevour:  My fav the Lamb Tikka Masala, my...','url':'http://www.yelp.com/biz/urban-curry-san-francisco','menu_provider':'yelp','menu_date_updated':1317414369}";
	private Restaurant restauarant;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_details);

		// resultjson = new JSONObject(result);
		// Restaurant.fromJson(resultjson);

		Restaurant restaurant = new Restaurant();

		TextView restaurantName = (TextView) findViewById(R.id.details_name);
		restaurantName.setText((CharSequence) restaurant.getName());

		TextView details_phone = (TextView) findViewById(R.id.details_phone);
		details_phone.setText((CharSequence) restaurant.getPhone());

		TextView address1 = (TextView) findViewById(R.id.details_address_line_1);
		address1.setText((CharSequence) restaurant.getAddress1());

		TextView address2 = (TextView) findViewById(R.id.details_address_line_2);
		address2.setText((CharSequence) restaurant.getAddress2());
		
		
		TextView address3 = (TextView) findViewById(R.id.details_address_line_3);
		address3.setText((CharSequence) restaurant.getAddress3());

		List<String> categories = restaurant.getCategories();
		String str = "";
		
		int leng = categories.size();
		
		for (int i = 0; i < leng; i++) {
			 str += (String) categories.get(i);
			 if((leng-1) != i) str+=" / ";
		}
		
		TextView details_Categories = (TextView) findViewById(R.id.details_Categories);
		details_Categories.setText((CharSequence) str);

		RatingBar details_rating = (RatingBar) findViewById(R.id.details_rating);
		details_rating.setRating(restaurant.getAvg_rating());

		Button btnWantIt = (Button) findViewById(R.id.wantit);

		btnWantIt.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent i = new Intent(DetailsFragment.this
						.getApplicationContext(), PictureGridActivity.class);
				i.putExtra("text", "Passed String Extra!");
				startActivity(i);
			}
		});

		Button btnNah = (Button) findViewById(R.id.nah);

		btnNah.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent i = new Intent(DetailsFragment.this
						.getApplicationContext(), PictureGridActivity.class);
				i.putExtra("text", "Passed String Extra!");
				startActivity(i);
			}
		});
		
		
		
//		String image_url = "http://mycodeandlife.files.wordpress.com/2013/01/384088_2317070728022_2086719259_n.jpg";
			String image_url = restaurant.getPhoto_url();
		ImageView imageView = (ImageView) findViewById(R.id.details_img);
		
		imageView.setTag(image_url);
		new DownloadImagesTask().execute(imageView);
		
		//loadImageFromURL(image_url, image);

	}
	
	public boolean loadImageFromURL(String fileUrl, 
			ImageView iv){
			  try {
			 
			    URL myFileUrl = new URL (fileUrl);
			    HttpURLConnection conn =
			      (HttpURLConnection) myFileUrl.openConnection();
			    conn.setDoInput(true);
			    conn.connect();
			 
			    InputStream is = conn.getInputStream();
			    iv.setImageBitmap(BitmapFactory.decodeStream(is));
			 
			    return true;
			 
			  } catch (MalformedURLException e) {
			    e.printStackTrace();
			  } catch (Exception e) {
			    e.printStackTrace();
			  }
			 
			  return false;
			}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.details, menu);
		return true;
	}

}
