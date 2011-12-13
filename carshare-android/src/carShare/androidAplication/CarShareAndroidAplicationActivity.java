package carShare.androidAplication;

import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.protocol.HTTP;
import com.carshare.domain.dto.UserLogin;
import com.neptuo.service.io.AutoSerializer;
import com.neptuo.service.io.XmlSerializer;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class CarShareAndroidAplicationActivity extends Activity {
   
	private  TextView validity;

	@Override
    public void onCreate(Bundle savedInstanceState) {
        
        super.onCreate(savedInstanceState);   
        setContentView(R.layout.main); 
        System.setProperty("org.xml.sax.driver","org.xmlpull.v1.sax2.Driver");
        Resources.setIdUser(null);
        validity = (TextView) findViewById(R.id.mainValidity);
        validity.setVisibility(4);
        Button loginBtn = (Button) findViewById(R.id.mainLoginBtn); 
        Button registrationBtn = (Button) findViewById(R.id.mainRegistrationBtn); 
        
        loginBtn.setOnClickListener(new View.OnClickListener() {
        	public void onClick(View v) {
            	validity.setVisibility(4);
            	EditText phone = (EditText) findViewById(R.id.mainPhone);  
        		EditText password = (EditText) findViewById(R.id.mainPassword);
                try 
                {       	
                	UserLogin login = new UserLogin();
                    login.setPhoneNumber(phone.getText().toString());
                	login.setPassword(password.getText().toString());

                	XmlSerializer serializer = new XmlSerializer("carshare");
                	AutoSerializer.factory("user-login", login, serializer).serialize();
                	String output = serializer.getResult();

                	DefaultHttpClient httpPostclient = new DefaultHttpClient();
                	HttpConnectionParams.setConnectionTimeout(httpPostclient.getParams(), 10000);
                	HttpPost httpPostRequest = new HttpPost(Resources.getServer()+"/service/account/login");
                	httpPostRequest.setHeader("Accept", "application/xml");
                	httpPostRequest.setHeader("Content-type", "application/xml");
                	httpPostRequest.setEntity(new StringEntity(output,HTTP.UTF_8));
                	HttpResponse responsePost = (HttpResponse) httpPostclient.execute(httpPostRequest);

                	if (responsePost.getStatusLine().getStatusCode()==HttpStatus.SC_OK)
                	{
                		Header[] hh = responsePost.getAllHeaders();
                		Resources.setIdUser(hh[1].getValue());
                		CarShareAndroidAplicationActivity.this.startActivity(new Intent(CarShareAndroidAplicationActivity.this,MenuActivity.class));
                	}
                	else 
                		validity.setVisibility(0);

                } 
                catch (Exception e)
                {
                	System.exit(1);
                }
            }
        });  

        registrationBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	CarShareAndroidAplicationActivity.this.startActivity(new Intent(CarShareAndroidAplicationActivity.this,RegistrationActivity.class));
            }
        });  
    }
}