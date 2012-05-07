package carShare.androidAplication;
import java.io.InputStream;
import java.util.Collection;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.protocol.HTTP;
import com.carshare.domain.dto.TripFilter;
import com.carshare.domain.dto.TripRow;
import com.neptuo.service.io.AutoDeserializer;
import com.neptuo.service.io.AutoDeserializerItem;
import com.neptuo.service.io.AutoSerializer;
import com.neptuo.service.io.XmlDeserializer;
import com.neptuo.service.io.XmlSerializer;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class FilterActivity extends Activity{
	
    EditText from;
    EditText to;
    EditText maxPrice;
    EditText seats;
    EditText minRating;
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);   
        setContentView(R.layout.filter);         
       
    	if (Resources.getIdUser()==null)
			FilterActivity.this.startActivity(new Intent(FilterActivity.this,CarShareAndroidAplicationActivity.class));
        
        Button searchBtn = (Button) findViewById(R.id.filterSearchBtn);
        Button cencelBtn = (Button) findViewById(R.id.filterCencelBtn);
        
        from = (EditText) findViewById(R.id.filterFrom);
        to = (EditText) findViewById(R.id.filterTo);
        maxPrice = (EditText) findViewById(R.id.filterMaxPrice);
        seats = (EditText) findViewById(R.id.filterSeats);
        minRating = (EditText) findViewById(R.id.filterMinRating);

       
        searchBtn.setOnClickListener(new View.OnClickListener() {
        	public void onClick(View v) {
            	try 
            	{       	
            		TripFilter tripFilter = new TripFilter();
            		
            		tripFilter.setFrom(from.getText().toString());
            		tripFilter.setTo(to.getText().toString());
            		if (maxPrice.getText().toString().equals("")) 
            			tripFilter.setMaxPrice(0); 	
            		else	
            			tripFilter.setMaxPrice(Double.parseDouble(maxPrice.getText().toString()));
            		
            		if (seats.getText().toString().equals("")) 
            			tripFilter.setSeats(0); 	
            		else	
            			tripFilter.setSeats(Integer.parseInt(seats.getText().toString()));
            		
            		if (minRating.getText().toString().equals("")) 
            			tripFilter.setMinRating(0); 	
            		else	
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
                         	AutoDeserializerItem tripItem = new AutoDeserializerItem("trips", Collection.class, TripRow.class);
                         	AutoDeserializer.factory(deserializer, is, tripItem).deserialize();
                         	Resources.setTripRows((Collection<TripRow>)tripItem.getCollection());
                         	FilterActivity.this.startActivity(new Intent(FilterActivity.this,ResultActivity.class));
                         }       	
                    }
            	} 
            	catch (Exception e)
            	{
            		ExitMsbox("Fatal Error!");
            	}
        	}
        });
        
        cencelBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	FilterActivity.this.startActivity(new Intent(FilterActivity.this,MenuActivity.class));
            }
        });
	}
	
	public void ExitMsbox(String message)
    {
        AlertDialog.Builder dlgAlert  = new AlertDialog.Builder(this);  
        dlgAlert.setTitle("Info"); 
        dlgAlert.setMessage(message);
        dlgAlert.setPositiveButton("OK",new DialogInterface.OnClickListener() {
        public void onClick(DialogInterface dialog, int whichButton) {
        	System.exit(1);	
        }});
        dlgAlert.create().show();
    }
}