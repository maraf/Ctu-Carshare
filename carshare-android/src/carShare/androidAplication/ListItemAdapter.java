package carShare.androidAplication;

import com.carshare.domain.dto.TripRow;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

class ListItemAdapter extends ArrayAdapter<Ride>
{      
	private Context context;

	
	public ListItemAdapter(Context context, int textViewResourceId) 
	{             
		super(context, textViewResourceId);        
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
		
		     
		TextView departureTime = (TextView) v.findViewById(R.id.rowDepartureTime);                     
		TextView timeOfArrival = (TextView) v.findViewById(R.id.rowTimeOfArrival);    
		TextView pricePerPerson = (TextView) v.findViewById(R.id.rowPricePerPerson);                     
		TextView totalPrice = (TextView) v.findViewById(R.id.rowTotalPrice);    
		TextView freePlace = (TextView) v.findViewById(R.id.rowFreePlace);                     
		TextView driverEvaluation = (TextView) v.findViewById(R.id.rowDriverEvaluation);    
		TextView detail = (TextView) v.findViewById(R.id.rowDetail);  
	   
			
			
			
			
		
			
			if (position == 0){
				departureTime.setBackgroundColor(Color.parseColor("#AAFFFF99"));                   
				timeOfArrival.setBackgroundColor(Color.parseColor("#AAFFFF99"));   
				pricePerPerson.setBackgroundColor(Color.parseColor("#AAFFFF99"));            
				totalPrice.setBackgroundColor(Color.parseColor("#AAFFFF99"));  
				freePlace.setBackgroundColor(Color.parseColor("#AAFFFF99"));              
				driverEvaluation.setBackgroundColor(Color.parseColor("#AAFFFF99"));   
				detail.setBackgroundColor(Color.parseColor("#AAFFFF99"));  
			}
			
			for (TripRow trip : Resources.getTripRows()){
				if(departureTime != null)                       
					departureTime.setText(trip.getDeparture().toString());                                
				
				if(timeOfArrival != null)                     
					timeOfArrival.setText(trip.getArrival().toString());  
				
				if(pricePerPerson != null)                       
					pricePerPerson.setText(null);                                
				
				if(totalPrice != null)                     
					totalPrice.setText(trip.getTotalPrice()); 
				
				if(freePlace != null)                       
					freePlace.setText(trip.getTotalSeats());                                
				
				if(driverEvaluation != null)                     
					driverEvaluation.setText(trip.getDriverRating());  
				
				if(detail != null)                     
					detail.setText(null);          
				
			}
		

		            
		return v;        
	}            
}