package carShare.androidAplication;
import com.carshare.domain.dto.TripRow;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;

public class ResultActivity extends Activity {

	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);   
        setContentView(R.layout.result_list); 
        
        Button newSearchBtn = (Button) findViewById(R.id.resultListNewSearchBtn);
        Button cencelBtn = (Button) findViewById(R.id.resultListCencelBtn);
        
        if (Resources.getIdUser()==null)
    		ResultActivity.this.startActivity(new Intent(ResultActivity.this,CarShareAndroidAplicationActivity.class));
        
        
        TripRow [] rows = Resources.getTripRowsArray();
        
        ListView listView =(ListView) findViewById(R.id.resultListListView);  
        ListItemAdapter adapter = new ListItemAdapter(this,R.layout.row,rows);
        listView.setAdapter(adapter);
 
        listView.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            	Resources.selectedRow = position;
    	        startActivity(new Intent(ResultActivity.this, TripDetailActivity.class));	
        }});
        
        cencelBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	ResultActivity.this.startActivity(new Intent(ResultActivity.this,MenuActivity.class));
            }
        });  
        
        newSearchBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	ResultActivity.this.startActivity(new Intent(ResultActivity.this,FilterActivity.class));
            }
        });  
	}
}
