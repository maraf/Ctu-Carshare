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

import com.carshare.domain.dto.User;
import com.carshare.domain.dto.UserUpdate;
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
import android.widget.TextView;

public class EditProfileActivity extends Activity{
	
	private EditText phone;     		
   	private EditText password;
   	private EditText passwordConfirm;  
	private EditText email;
	private EditText firstName;  
	private EditText lastName;
	private EditText address;  
	private EditText car;
	private TextView validity;
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);   
        setContentView(R.layout.edit_profile);         
        
        validity = (TextView) findViewById(R.id.editProfileValidity);
    	validity.setHeight(0);
    	
        
        if (Resources.getIdUser()==null)
    		EditProfileActivity.this.startActivity(new Intent(EditProfileActivity.this,CarShareAndroidAplicationActivity.class));
        
        
        Button saveBtn = (Button) findViewById(R.id.editProfileSaveBtn);
        Button cencelBtn = (Button) findViewById(R.id.editProfileCencelBtn);
        
        phone = (EditText) findViewById(R.id.editProfilePhone);     		
       	password = (EditText) findViewById(R.id.editProfilePassword);
       	passwordConfirm = (EditText) findViewById(R.id.editProfilePasswordConfirm);  
    	email = (EditText) findViewById(R.id.editProfileEmail);
    	firstName = (EditText) findViewById(R.id.editProfileFirstName);  
    	lastName = (EditText) findViewById(R.id.editProfileLastName);
    	address = (EditText) findViewById(R.id.editProfileAddress);  
    	car = (EditText) findViewById(R.id.editProfileCarDescription);
 
    	try 
    	{       	
            DefaultHttpClient httpPostclient = new DefaultHttpClient();
            HttpConnectionParams.setConnectionTimeout(httpPostclient.getParams(), 10000);
            HttpPost httpPostRequest = new HttpPost(Resources.getServer()+"/service/account/info");
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
                 	AutoDeserializerItem userItem = new AutoDeserializerItem("user", null, UserUpdate.class);
                 	AutoDeserializer.factory(deserializer, is, userItem).deserialize();
                 	User user = (User) userItem.getItem();
                 	phone.setText(user.getPhoneNumber());
                 	email.setText(user.getEmail());
                 	firstName.setText(user.getFirstName());
                 	lastName.setText(user.getLastName());
                 	address.setText(user.getAddress());
                 	car.setText(user.getCarDescription());
                 }       	
            }
    	} 
    	catch (Exception e)
    	{
    		System.exit(1);
    	}

        saveBtn.setOnClickListener(new View.OnClickListener() {
        	public void onClick(View v) {
        		try 
            	{  
        			UserUpdate userUpdate = new UserUpdate();
        			userUpdate.setPhoneNumber(phone.getText().toString());	
        			userUpdate.setEmail(email.getText().toString());
        			userUpdate.setFirstName(firstName.getText().toString());
        			userUpdate.setLastName(lastName.getText().toString());
        			userUpdate.setAddress(address.getText().toString());
        			userUpdate.setCarDescription(car.getText().toString());
        			
        			
				
        			if (password.getText().toString().equals(passwordConfirm.getText().toString())){
        				if (!password.getText().toString().equals(""))
        					userUpdate.setPassword(password.getText().toString());

        				XmlSerializer serializer = new XmlSerializer("carshare");
        				AutoSerializer.factory("user-update", userUpdate, serializer).serialize();
        				String output = serializer.getResult();
        			
        				DefaultHttpClient httpPostclient = new DefaultHttpClient();
        				HttpConnectionParams.setConnectionTimeout(httpPostclient.getParams(), 10000);
        				HttpPost httpPostRequest = new HttpPost(Resources.getServer()+"/service/account/update");
        				httpPostRequest.setHeader("Accept", "application/xml");
        				httpPostRequest.setHeader("Content-type", "application/xml");
        				httpPostRequest.addHeader("AuthToken", Resources.getIdUser());
        	
        				httpPostRequest.setEntity(new StringEntity(output,HTTP.UTF_8));
        				HttpResponse responsePost = (HttpResponse) httpPostclient.execute(httpPostRequest);

        				if (responsePost.getStatusLine().getStatusCode()==HttpStatus.SC_OK)
        					msbox("User updated");        				
        			}
        			else
        				validity.setHeight(20);
        			
            	}
        		catch (Exception e)
        		{
        			ExitMsbox("Fatal Error!");
        		}
        	}
        });
        
        cencelBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	EditProfileActivity.this.startActivity(new Intent(EditProfileActivity.this,MenuActivity.class));
            }
        });     
	}
	
    public void msbox(String message)
    {
        AlertDialog.Builder dlgAlert  = new AlertDialog.Builder(this);  
        dlgAlert.setTitle("Info"); 
        dlgAlert.setMessage(message);
        dlgAlert.setPositiveButton("OK",new DialogInterface.OnClickListener() {
        public void onClick(DialogInterface dialog, int whichButton) {
        	EditProfileActivity.this.startActivity(new Intent(EditProfileActivity.this,MenuActivity.class));	
        }});
        dlgAlert.create().show();
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