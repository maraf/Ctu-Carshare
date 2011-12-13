package carShare.androidAplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

public class ResultActivity extends Activity {

	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);   
        setContentView(R.layout.result_list); 
        
        if (Resources.getIdUser()==null)
    		ResultActivity.this.startActivity(new Intent(ResultActivity.this,CarShareAndroidAplicationActivity.class));
        
      //  ListView listView =(ListView) findViewById(R.id.listView);  
     //   ListItemAdapter adapter = new ListItemAdapter(this,R.layout.row,Resources.getRows());
      //  listView.setAdapter(adapter);
	}
}
