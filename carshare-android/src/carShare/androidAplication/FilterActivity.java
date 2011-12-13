package carShare.androidAplication;
import java.io.InputStream;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.protocol.HTTP;

import com.carshare.domain.dto.TripFilter;
import com.carshare.domain.dto.UserUpdate;
import com.neptuo.service.io.AutoDeserializer;
import com.neptuo.service.io.AutoDeserializerItem;
import com.neptuo.service.io.AutoSerializer;
import com.neptuo.service.io.XmlDeserializer;
import com.neptuo.service.io.XmlSerializer;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class FilterActivity extends Activity{
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);   
        setContentView(R.layout.filter);         
       
        Button searchBtn = (Button) findViewById(R.id.filterSearchBtn);
        Button cencelBtn = (Button) findViewById(R.id.filterCencelBtn);
        
        final EditText from = (EditText) findViewById(R.id.filterFrom);
        final EditText to = (EditText) findViewById(R.id.filterTo);
        final EditText maxPrice = (EditText) findViewById(R.id.filterMaxPrice);
        final EditText seats = (EditText) findViewById(R.id.filterSeats);
        final EditText minRating = (EditText) findViewById(R.id.filterMinRating);
       

        searchBtn.setOnClickListener(new View.OnClickListener() {
        	public void onClick(View v) {
        	
        		if (Resources.getIdUser()==null)
        			FilterActivity.this.startActivity(new Intent(FilterActivity.this,CarShareAndroidAplicationActivity.class));
        		
            	try 
            	{       	
            		TripFilter tripFilter = new TripFilter();
            		
            		tripFilter.setFrom(from.getText().toString());
            		tripFilter.setTo(to.getText().toString());
            		tripFilter.setMaxPrice(Double.parseDouble(maxPrice.getText().toString()));
            		tripFilter.setSeats(Integer.parseInt(seats.getText().toString()));
            		tripFilter.setMinRating(Integer.parseInt(minRating.getText().toString()));
            		
            		XmlSerializer serializer = new XmlSerializer("carshare");
                	AutoSerializer.factory("trip-filter", tripFilter, serializer).serialize();
                	String output = serializer.getResult();
            		
                    DefaultHttpClient httpPostclient = new DefaultHttpClient();
                    HttpConnectionParams.setConnectionTimeout(httpPostclient.getParams(), 10000);
                    HttpPost httpPostRequest = new HttpPost(Resources.getServer()+"/service/trip");
                    httpPostRequest.setHeader("Accept", "application/xml");
                    httpPostRequest.setHeader("Content-type", "application/xml");
                    httpPostRequest.addHeader("AuthToken", Resources.getIdUser());
                    httpPostRequest.setEntity(new StringEntity(output,HTTP.UTF_8));
                    HttpResponse responsePost = (HttpResponse) httpPostclient.execute(httpPostRequest);
                    
                    if (responsePost.getStatusLine().getStatusCode()==HttpStatus.SC_OK)
                    {
                    	 HttpEntity entity = responsePost.getEntity();
                         if (entity != null){
                         	InputStream is = entity.getContent();
                         	XmlDeserializer deserializer = new XmlDeserializer();
                         	AutoDeserializerItem userItem = new AutoDeserializerItem("user-update", null, UserUpdate.class);
                         	AutoDeserializer.factory(deserializer, is, userItem).deserialize();
                         	UserUpdate user = (UserUpdate) userItem.getItem();
                         
                         }       	
                    }
            	} 
            	catch (Exception e)
            	{
            		System.exit(1);
            	}
        	}
        });
        
        cencelBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	FilterActivity.this.startActivity(new Intent(FilterActivity.this,MenuActivity.class));
            }
        });  
	}
}