/*package carShare.androidAplication;

import com.carshare.domain.Trip;
import com.carshare.domain.dto.TripRow;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

class ListItemAdapter extends ArrayAdapter<Ride>
{      
	private Context context;
	private TripRow [] rides;
	
	public ListItemAdapter(Context context, int textViewResourceId, TripRow[] objects) 
	{             
		super(context, textViewResourceId,objects);        
		this.context = context;
		rides = objects;
	}         
	
	public View getView(int position, View convertView, ViewGroup parent) 
	{             
		View v = convertView;             
		if (v == null)
		{                  
			LayoutInflater vi = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);  
			v = vi.inflate(R.layout.row, null);             
		}             
		
		TripRow item = rides[position];             
		if (item != null) 
		{                     	
			
			TextView departureTime = (TextView) v.findViewById(R.id.departureTime);                     
			TextView timeOfArrival = (TextView) v.findViewById(R.id.timeOfArrival);    
			TextView pricePerPerson = (TextView) v.findViewById(R.id.pricePerPerson);                     
			TextView totalPrice = (TextView) v.findViewById(R.id.totalPrice);    
			TextView freePlace = (TextView) v.findViewById(R.id.freePlace);                     
			TextView driverEvaluation = (TextView) v.findViewById(R.id.driverEvaluation);    
			TextView detail = (TextView) v.findViewById(R.id.detail);  
			
			if (position == 0){
				departureTime.setBackgroundColor(Color.parseColor("#AAFFFF99"));                   
				timeOfArrival.setBackgroundColor(Color.parseColor("#AAFFFF99"));   
				pricePerPerson.setBackgroundColor(Color.parseColor("#AAFFFF99"));            
				totalPrice.setBackgroundColor(Color.parseColor("#AAFFFF99"));  
				freePlace.setBackgroundColor(Color.parseColor("#AAFFFF99"));              
				driverEvaluation.setBackgroundColor(Color.parseColor("#AAFFFF99"));   
				detail.setBackgroundColor(Color.parseColor("#AAFFFF99"));  
			}
			
		
			if(departureTime != null)                       
				departureTime.setText(item.getDepartureTime());                                
			
			if(timeOfArrival != null)                     
				timeOfArrival.setText(item.getTimeOfArrival());  
			
			if(pricePerPerson != null)                       
				pricePerPerson.setText(item.getPricePerPerson());                                
			
			if(totalPrice != null)                     
				totalPrice.setText(item.getTotalPrice()); 
			
			if(freePlace != null)                       
				freePlace.setText(item.getFreePlace());                                
			
			if(driverEvaluation != null)                     
				driverEvaluation.setText(item.getDriverEvaluation());  
			
			if(detail != null)                     
				detail.setText(item.getDetail());          
		}             
		return v;        
	}            
} */