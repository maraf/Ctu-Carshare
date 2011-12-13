package carShare.androidAplication;

import java.net.URI;

import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.protocol.HTTP;

import com.carshare.domain.dto.UserLogin;
import com.carshare.domain.dto.UserUpdate;
import com.neptuo.service.io.AutoSerializer;
import com.neptuo.service.io.XmlSerializer;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class RegistrationActivity extends Activity{

	private TextView validity;
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);   
        setContentView(R.layout.registration);         
        Button registrationBtn = (Button) findViewById(R.id.registrationRegistrationBtn);
        Button cencelBtn = (Button) findViewById(R.id.registrationCencelBtn);
        validity = (TextView) findViewById(R.id.registrationValidity);
        validity.setHeight(0);
        registrationBtn.setOnClickListener(new View.OnClickListener() {
        	public void onClick(View v) {
            	
            	EditText phone = (EditText) findViewById(R.id.registrationPhone);  
        		EditText password = (EditText) findViewById(R.id.registrationPassword);
        		EditText passwordConfirm = (EditText) findViewById(R.id.registrationPasswordConfirm);  
        		EditText email = (EditText) findViewById(R.id.registrationEmail);
        		EditText firstName = (EditText) findViewById(R.id.registrationFirstName);  
        		EditText lastName = (EditText) findViewById(R.id.registrationLastName);
        		EditText address = (EditText) findViewById(R.id.registrationAddress);  
        		EditText car = (EditText) findViewById(R.id.registrationCarDescription);
        		
        		
        		if (password.getText().toString().equals(passwordConfirm.getText().toString())&&!password.getText().toString().equals("")){
        			try 
        			{       	
        				UserUpdate registration = new UserUpdate();
        				registration.setPhoneNumber(phone.getText().toString());
                		registration.setPassword(password.getText().toString());
                		registration.setEmail(email.getText().toString());
                		registration.setFirstName(firstName.getText().toString());
                		registration.setLastName(lastName.getText().toString());
                		registration.setAddress(address.getText().toString());
                		registration.setCarDescription(car.getText().toString());

                		XmlSerializer serializer = new XmlSerializer("carshare");
                		AutoSerializer.factory("user-update", registration, serializer).serialize();
                		String output = serializer.getResult();

                		DefaultHttpClient httpPostclient = new DefaultHttpClient();
                		HttpConnectionParams.setConnectionTimeout(httpPostclient.getParams(), 10000);
                		HttpPost httpPostRequest = new HttpPost(Resources.getServer()+"/service/account/register");
                		httpPostRequest.setHeader("Accept", "application/xml");
                		httpPostRequest.setHeader("Content-type", "application/xml");
                	
                		httpPostRequest.setEntity(new StringEntity(output,HTTP.UTF_8));
                		HttpResponse responsePost = (HttpResponse) httpPostclient.execute(httpPostRequest);

                		if (responsePost.getStatusLine().getStatusCode()==HttpStatus.SC_OK)
                		{
                			UserLogin login = new UserLogin();
                            login.setPhoneNumber(registration.getPhoneNumber());
                        	login.setPassword(registration.getPassword());

                        	AutoSerializer.factory("user-login", login, serializer).serialize();
                        	output = serializer.getResult();
                        	
                        	HttpConnectionParams.setConnectionTimeout(httpPostclient.getParams(), 10000);
                        	httpPostRequest.setURI(new URI(Resources.getServer()+"/service/account/login"));
                        	httpPostRequest.setEntity(new StringEntity(output,HTTP.UTF_8));
                        	responsePost = (HttpResponse) httpPostclient.execute(httpPostRequest);

                        	if (responsePost.getStatusLine().getStatusCode()==HttpStatus.SC_OK)
                        	{
                        		Header[] hh = responsePost.getAllHeaders();
                    			Resources.setIdUser(hh[1].getValue());
                    			RegistrationActivity.this.startActivity(new Intent(RegistrationActivity.this,MenuActivity.class));
                        	}
                		}
        			} 
        			catch (Exception e)
        			{
        				System.exit(1);
        			}
        		}
        		else
        			validity.setHeight(20);
            }
        });
        
        cencelBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	RegistrationActivity.this.startActivity(new Intent(RegistrationActivity.this,CarShareAndroidAplicationActivity.class));
            }
        });  
	}
}
