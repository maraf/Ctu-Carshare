package carShare.androidAplication;

import java.text.SimpleDateFormat;

import com.carshare.domain.dto.TripRow;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

class ListItemAdapter extends ArrayAdapter<TripRow>
{      
	private Context context;
	private SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");

	public ListItemAdapter(Context context, int textViewResourceId, TripRow[] object) 
	{             
		super(context, textViewResourceId, object);        
		this.context = context;	
	}         
	
	public View getView(int position, View convertView, ViewGroup parent) 
	{             
		View v = convertView;             
		if (v == null)
		{                  
			LayoutInflater vi = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);  
			v = vi.inflate(R.layout.row, null);             
		}             

		TripRow trip =  Resources.getTripRowsArray()[position];
		
		if (trip != null){
			TextView arrival = (TextView) v.findViewById(R.id.rowArrival);                     
			TextView availableSeats = (TextView) v.findViewById(R.id.rowAvailableSeats);    
			TextView departure = (TextView) v.findViewById(R.id.rowDeparture);                     
			TextView driverRating = (TextView) v.findViewById(R.id.rowDriverRating);    
			TextView from = (TextView) v.findViewById(R.id.rowFrom);                     
			TextView to = (TextView) v.findViewById(R.id.rowTo);    
			TextView totalPrice = (TextView) v.findViewById(R.id.rowTotalPrice);  
			TextView totalSeats = (TextView) v.findViewById(R.id.rowTotalSeats); 
			
			
			if (from!=null)
				if (trip.getFrom()!=null)
					from.setText(trip.getFrom());            
			if (to!=null)
				if (trip.getTo()!=null)
					to.setText(trip.getTo());    
			if (arrival!=null)
				if (trip.getArrival()!=null)
					arrival.setText(format.format(trip.getArrival()));
			if (departure!=null)
				if (trip.getDeparture()!=null)
					departure.setText(format.format(trip.getDeparture()));
			if (availableSeats!=null)
				availableSeats.setText(Integer.toString(trip.getAvailableSeats()));  	
			if (driverRating!=null)
				driverRating.setText(Integer.toString(trip.getDriverRating())); 	
			if (totalPrice!=null)
				totalPrice.setText(Integer.toString(trip.getTotalPrice())); 
			if (totalSeats!=null)
				totalSeats.setText(Integer.toString(trip.getTotalSeats())); 
		}
		return v;        
	}            
}