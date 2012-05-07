package carShare.androidAplication;

import java.io.InputStream;
import java.util.Collection;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpPost;

import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpConnectionParams;



import com.carshare.domain.dto.UserMessage;
import com.neptuo.service.io.AutoDeserializer;
import com.neptuo.service.io.AutoDeserializerItem;

import com.neptuo.service.io.XmlDeserializer;


import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuActivity extends Activity{
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);   
        setContentView(R.layout.menu);         
        
     	try 
    	{       	
    		
            DefaultHttpClient httpPostclient = new DefaultHttpClient();
            HttpConnectionParams.setConnectionTimeout(httpPostclient.getParams(), 10000);
            HttpPost httpPostRequest = new HttpPost(Resources.getServer()+"/service/message");
            httpPostRequest.setHeader("Accept", "application/xml");
            httpPostRequest.setHeader("Content-type", "application/xml");
            httpPostRequest.addHeader("AuthToken", Resources.getIdUser());
            HttpResponse responsePost = (HttpResponse) httpPostclient.execute(httpPostRequest);
            
            if (responsePost.getStatusLine().getStatusCode()==HttpStatus.SC_OK)
            {
            	 HttpEntity entity = responsePost.getEntity();
                 if (entity != null){
                 	InputStream is = entity.getContent();
                 	XmlDeserializer deserializer = new XmlDeserializer();
                 	AutoDeserializerItem messageItem = new AutoDeserializerItem("user-messages", Collection.class, UserMessage.class);
                 	AutoDeserializer.factory(deserializer, is, messageItem).deserialize();
                 	Resources.messages = (Collection<UserMessage>) messageItem.getCollection();
                 	UserMessage [] m = Resources.getMessageArray();
                 	
                 	for (int i= 0 ; i<Resources.messages.size();i++){
                 		UserMessage me = m[i];
                 		if (!me.isIsRead()){
                 			Resources.NotificationMessage(getApplicationContext(), "You have new message!");
                 			break;
                 		}
                 	}
                 }       	
            }
    	}
    	catch (Exception e)
    	{
    		ExitMsbox("Fatal Error!");
    	}
        
        
        if (Resources.getIdUser()==null)
    		MenuActivity.this.startActivity(new Intent(MenuActivity.this,CarShareAndroidAplicationActivity.class));
       
        Button searchBtn = (Button) findViewById(R.id.menuSearchBtn);
        Button createBtn = (Button) findViewById(R.id.menuCreateBtn);
        Button updateBtn = (Button) findViewById(R.id.menuUpdateBtn);
        Button messageBtn = (Button) findViewById(R.id.menuMessageBtn); 
        Button logoutBtn = (Button) findViewById(R.id.menuLogoutBtn);
        
        
        searchBtn.setOnClickListener(new View.OnClickListener() {
        	public void onClick(View v) {
        		MenuActivity.this.startActivity(new Intent(MenuActivity.this,FilterActivity.class));
        	}
        });
        

        messageBtn.setOnClickListener(new View.OnClickListener() {
        	public void onClick(View v) {
        		MenuActivity.this.startActivity(new Intent(MenuActivity.this,MyMessagesActivity.class));
        	}
        });
        
        
        createBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	MenuActivity.this.startActivity(new Intent(MenuActivity.this,NewTripActivity.class));
            }
        });  
        
        updateBtn.setOnClickListener(new View.OnClickListener() {
        	public void onClick(View v) {
        		MenuActivity.this.startActivity(new Intent(MenuActivity.this,EditProfileActivity.class));
        	}
        });
        
        logoutBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
              	try 
            	{       	
                    DefaultHttpClient httpPostclient = new DefaultHttpClient();
                    HttpConnectionParams.setConnectionTimeout(httpPostclient.getParams(), 10000);
                    HttpPost httpPostRequest = new HttpPost(Resources.getServer()+"/service/account/logout");
                    httpPostRequest.setHeader("Accept", "application/xml");
                    httpPostRequest.setHeader("Content-type", "application/xml");
                    httpPostRequest.addHeader("AuthToken", Resources.getIdUser());		
                    HttpResponse responsePost = (HttpResponse) httpPostclient.execute(httpPostRequest);
                    if (responsePost.getStatusLine().getStatusCode()==HttpStatus.SC_OK)
                    {
                    	Resources.setIdUser(null);
                    	MenuActivity.this.startActivity(new Intent(MenuActivity.this,CarShareAndroidAplicationActivity.class));
                    }
            	} 
            	catch (Exception e)
            	{
            		ExitMsbox("Fatal Error!");
            	}
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