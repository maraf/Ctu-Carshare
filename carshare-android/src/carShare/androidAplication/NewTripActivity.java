package carShare.androidAplication;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.protocol.HTTP;

import com.carshare.domain.dto.NewTrip;
import com.carshare.domain.dto.TripStop;
import com.neptuo.service.io.AutoSerializer;
import com.neptuo.service.io.XmlSerializer;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NewTripActivity extends Activity{
	
	private TripStop stop = new TripStop();
	private ArrayList<TripStop> stops = new ArrayList<TripStop>();
	private EditText from;
	private EditText to;
	private EditText departure;
	private EditText arrival;
	private EditText totalPrice;
	private EditText availableSeats;
	private EditText totalSeats;
	private NewTrip newTrip = new NewTrip();
	private SimpleDateFormat format = new SimpleDateFormat("ddMMyyyy");
	private EditText placeBox;
	private EditText arrivalBox;
    
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);   
        setContentView(R.layout.new_trip);         
        
        if (Resources.getIdUser()==null)
        	NewTripActivity.this.startActivity(new Intent(NewTripActivity.this,CarShareAndroidAplicationActivity.class));

        Button createBtn = (Button) findViewById(R.id.tripCreateBtn);
        Button cencelBtn = (Button) findViewById(R.id.tripCencelBtn);
        Button stopsBtn = (Button) findViewById(R.id.tripStopsBtn);
        
        from = (EditText) findViewById(R.id.tripFrom);
        to = (EditText) findViewById(R.id.tripTo);
        departure = (EditText) findViewById(R.id.tripDeparture);
        arrival = (EditText) findViewById(R.id.tripArrival);
        totalPrice = (EditText) findViewById(R.id.tripTotalPrice);
        availableSeats= (EditText) findViewById(R.id.tripAvailableSeats);
        totalSeats = (EditText) findViewById(R.id.tripTotalSeats);

        createBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	try {
            		if (from.getText().toString().equals("")||to.getText().toString().equals("")||totalPrice.getText().toString().equals("")||availableSeats.getText().toString().equals("")||totalSeats.getText().toString().equals("")||arrival.getText().toString().equals("")){
            			msbox("Fill in all fields");
            		}
            		else
            		{	
            			newTrip.setFrom(from.getText().toString());	
            			newTrip.setTo(to.getText().toString());	
            			newTrip.setTotalPrice(Integer.parseInt(totalPrice.getText().toString()));
            			newTrip.setAvailableSeats(Integer.parseInt(availableSeats.getText().toString()));
            			newTrip.setTotalSeats(Integer.parseInt(totalSeats.getText().toString()));
            			newTrip.setDeparture(format.parse(departure.getText().toString()));  	
            			newTrip.setArrival(format.parse(arrival.getText().toString()));
            			newTrip.setStops(stops);
            		
            			XmlSerializer serializer = new XmlSerializer("carshare");
            			AutoSerializer.factory("new-trip", newTrip, serializer).serialize();
            			String output = serializer.getResult();

            			DefaultHttpClient httpPostclient = new DefaultHttpClient();
            			HttpConnectionParams.setConnectionTimeout(httpPostclient.getParams(), 10000);
            			HttpPost httpPostRequest = new HttpPost(Resources.getServer()+"/service/trip/create");
            			httpPostRequest.setHeader("Accept", "application/xml");
                    	httpPostRequest.setHeader("Content-type", "application/xml");
                    	httpPostRequest.addHeader("AuthToken", Resources.getIdUser());
                    	httpPostRequest.setEntity(new StringEntity(output,HTTP.UTF_8));
            			HttpResponse responsePost = (HttpResponse) httpPostclient.execute(httpPostRequest);

            			if (responsePost.getStatusLine().getStatusCode()==HttpStatus.SC_OK)
            			{
            				msbox("Trip is created");
            				NewTripActivity.this.startActivity(new Intent(NewTripActivity.this,MenuActivity.class));
            			}   
            		}
            	} 
            	catch (Exception e) 
            	{
            		ExitMsbox("Fatal Error!");
				}
            }
        });  
        
        stopsBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	box();
            }
        });  
        
        cencelBtn.setOnClickListener(new View.OnClickListener() {
        	public void onClick(View v) {
        		NewTripActivity.this.startActivity(new Intent(NewTripActivity.this,MenuActivity.class));
        	}
        });
	}
	
    public void msbox(String message)
    {
        AlertDialog.Builder dlgAlert  = new AlertDialog.Builder(this);  
        dlgAlert.setTitle("Info"); 
        dlgAlert.setMessage(message);
        dlgAlert.setPositiveButton("OK",new DialogInterface.OnClickListener() {
        public void onClick(DialogInterface dialog, int whichButton) {}});
        dlgAlert.create().show();
    }
	
    public void box()
    {
        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.box);
        dialog.setTitle("New stop"); 
        dialog.setCancelable(true);
        placeBox = (EditText) dialog.findViewById(R.id.boxPlace);  	
        arrivalBox = (EditText) dialog.findViewById(R.id.boxArrival);
        Button addBtn = (Button) dialog.findViewById(R.id.boxAddBtn);
        Button cencelBtn = (Button) dialog.findViewById(R.id.boxCencelBtn);
        
        addBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	try {
            		if (placeBox.getText().toString().equals("")||arrivalBox.getText().toString().equals("")){
            			msbox("Fill in all fields");
            		}
            		else{
            			stop.setPlace(placeBox.getText().toString());      		
						stop.setArrival(format.parse(arrivalBox.getText().toString()));
						stops.add(stop);
						dialog.cancel();
            		}
				} 
            	catch (ParseException e) 
				{
            		ExitMsbox("Fatal Error!");
				}
            }
        });  
        
        cencelBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	dialog.cancel();
            }
        });  
        dialog.show();
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