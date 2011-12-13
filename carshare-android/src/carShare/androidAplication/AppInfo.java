package carShare.androidAplication;

import com.neptuo.service.io.annotation.Deserializable;

@Deserializable(name="app-info")
public class AppInfo {
	String appName;
	String hello;
	String version;
	
	public AppInfo(){}
	
    @Deserializable(name="app-name")
    public void setAppName(String appName) {
        this.appName = appName;
    }
    
    public String getAppName() {
        return appName;
    }
    public String getHello() {
        return hello;
    }
    public String getVersion() {
        return version;
    }
    
    @Deserializable(name="hello")
    public void setHello(String hello) {
        this.hello = hello;
    }
    @Deserializable(name="version")
    public void setVersion(String version) {
        this.version = version;
    }
}




/*        	DefaultHttpClient httpclient = new DefaultHttpClient();
HttpGet httpGetRequest = new HttpGet("http://car-share.appspot.com/service/info");
httpGetRequest.setHeader("Accept", "application/xml");
httpGetRequest.setHeader("Content-type", "application/xml");
HttpResponse response = (HttpResponse) httpclient.execute(httpGetRequest);
HttpEntity entity = response.getEntity();

if (entity != null){
	InputStream is = entity.getContent();
	XmlDeserializer deserializer = new XmlDeserializer();
	AutoDeserializerItem loginItem = new AutoDeserializerItem("app-info", null, AppInfo.class);
	AutoDeserializer.factory(deserializer, is, loginItem).deserialize();
	AppInfo appInfoItem = ( AppInfo) loginItem.getItem();
	name.setText(appInfoItem.getAppName());
    hello.setText(appInfoItem.getHello());
    version.setText(appInfoItem.getVersion());
}*/


//       ListView listView =(ListView) findViewById(R.id.listView);  
// ListItemAdapter adapter = new ListItemAdapter(this,R.layout.row,r);

// listView.setAdapter(adapter); 
 
 
 

//      TextView name = (TextView) findViewById(R.id.textView1);  
//	TextView version = (TextView) findViewById(R.id.textView2);  
//	TextView hello = (TextView) findViewById(R.id.textView3);  




/*Ride[] r = {
		new Ride( "Èas odjezdu", "Èas pøíjezdu", "Cena za osobu pøi plném autì", "Celková cena", "Volná místa/Místa celkem", "Hodnocení øidièe", "Detail"),
		new Ride( "11:12", "12:12", "20", "50", "5/10", "100", "Detail"),
		new Ride( "11:12", "12:12", "20", "50", "5/10", "100", "Detail1"),
		new Ride( "11:12", "12:12", "20", "50", "5/10", "100", "Detail2"),
		new Ride( "11:12", "12:12", "20", "50", "5/10", "100", "Detail3"),
		new Ride( "11:12", "12:12", "20", "50", "5/10", "100", "Detail13"),
		new Ride( "11:12", "12:12", "20", "50", "5/10", "100", "Detail"),
		new Ride( "11:12", "12:12", "20", "50", "5/10", "100", "Detail13"),
		new Ride( "11:12", "12:12", "20", "50", "5/10", "100", "Detail"),
		new Ride( "11:12", "12:12", "20", "50", "5/10", "100", "Detail1"),
		new Ride( "11:12", "12:12", "20", "50", "5/10", "100", "Detai3l"),
		new Ride( "11:12", "12:12", "20", "50", "5/10", "100", "Detail1"),
		new Ride( "11:12", "12:12", "20", "50", "5/10", "100", "Deta3il"),
		new Ride( "11:12", "12:12", "20", "50", "5/10", "100", "Detail1"),
		new Ride( "11:12", "12:12", "20", "50", "5/10", "100", "Detail"),
		new Ride( "11:12", "12:12", "20", "50", "5/10", "100", "Detail1"),
		new Ride( "11:12", "12:12", "20", "50", "5/10", "100", "Det3ail"),
		new Ride( "11:12", "12:12", "20", "50", "5/10", "100", "Det2ail1"),
		new Ride( "11:12", "12:12", "20", "50", "5/10", "100", "Detail"),
		new Ride( "11:12", "12:12", "20", "50", "5/10", "100", "Detail1"),
		new Ride( "11:12", "12:12", "20", "50", "5/10", "100", "Detail"),
		new Ride( "11:12", "12:12", "20", "50", "5/10", "100", "Detail1"),
		new Ride( "11:12", "12:12", "20", "50", "5/10", "100", "Detail"),
		new Ride( "11:12", "12:12", "20", "50", "5/10", "100", "Detail1"),
		new Ride( "11:12", "12:12", "20", "50", "5/10", "100", "Detail"),
		new Ride( "11:12", "12:12", "20", "50", "5/10", "100", "Detail1"),
		new Ride( "11:12", "12:12", "20", "50", "5/10", "100", "Detail"),
		new Ride( "11:12", "12:12", "20", "50", "5/10", "100", "Detail1"),
		new Ride( "11:12", "12:12", "20", "50", "5/10", "100", "Detail"),
		new Ride( "11:12", "12:12", "20", "50", "5/10", "100", "Detail1"),
		new Ride( "11:12", "12:12", "20", "50", "5/10", "100", "Detail"),
		new Ride( "11:12", "12:12", "20", "50", "5/10", "100", "Detail1"),
		new Ride( "11:12", "12:12", "20", "50", "5/10", "100", "Det2ail"),
		new Ride( "11:12", "12:12", "20", "50", "5/10", "100", "Deta3il1"),
		new Ride( "11:12", "12:12", "20", "50", "5/10", "100", "Detail"),
		new Ride( "11:12", "12:12", "20", "50", "5/10", "100", "D4etail1"),
		new Ride( "11:12", "12:12", "20", "50", "5/10", "100", "Detail"),
		new Ride( "11:12", "12:12", "20", "50", "5/10", "100", "Detail1"),
		new Ride( "11:12", "12:12", "20", "50", "5/10", "100", "Detail"),
		new Ride( "11:12", "12:12", "20", "50", "5/10", "100", "Detail1"),
		new Ride( "11:12", "12:12", "20", "50", "5/10", "100", "Detail"),
		new Ride( "11:12", "12:12", "20", "50", "5/10", "100", "Detail1"),
		new Ride( "11:12", "12:12", "20", "50", "5/10", "100", "Detail"),
		new Ride( "11:12", "12:12", "20", "50", "5/10", "100", "Detail1"),
		new Ride( "11:12", "12:12", "20", "50", "5/10", "100", "Detail"),
		new Ride( "11:12", "12:12", "20", "50", "5/10", "100", "Det54ail1"),
		new Ride( "11:12", "12:12", "20", "50", "5/10", "100", "Detail"),
		new Ride( "11:12", "12:12", "20", "50", "5/10", "100", "D6tail1"),
		new Ride( "11:12", "12:12", "20", "50", "5/10", "100", "Detail"),
		new Ride( "11:12", "12:12", "20", "50", "5/10", "100", "Detail1"),
		new Ride( "11:12", "12:12", "20", "50", "5/10", "100", "Detail"),
		new Ride( "11:12", "12:12", "20", "50", "5/10", "100", "Detail1"),
		new Ride( "11:12", "12:12", "20", "50", "5/10", "100", "Detail"),
		new Ride( "11:12", "12:12", "20", "50", "5/10", "100", "Detail1"),
		new Ride( "11:12", "12:12", "20", "50", "5/10", "100", "Detail"),
		new Ride( "11:12", "12:12", "20", "50", "5/10", "100", "Detail1"),
		new Ride( "11:12", "12:12", "20", "50", "5/10", "100", "Detail"),
		new Ride( "11:12", "12:12", "20", "50", "5/10", "100", "Detail1"),
		new Ride( "11:12", "12:12", "20", "50", "5/10", "100", "Deta4il"),
		new Ride( "11:12", "12:12", "20", "50", "5/10", "100", "Detail1"),
		new Ride( "11:12", "12:12", "20", "50", "5/10", "100", "De2tail"),
		new Ride( "11:12", "12:12", "20", "50", "5/10", "100", "Detail1"),
		new Ride( "11:12", "12:12", "20", "50", "5/10", "100", "Detail"),
		new Ride( "11:12", "12:12", "20", "50", "5/10", "100", "Detail1"),
		new Ride( "11:12", "12:12", "20", "50", "5/10", "100", "Detail"),
		new Ride( "11:12", "12:12", "20", "50", "5/10", "100", "Detail1"),
		new Ride( "11:12", "12:12", "20", "50", "5/10", "100", "Detail"),
		new Ride( "11:12", "12:12", "20", "50", "5/10", "100", "Detail1"),
		new Ride( "11:12", "12:12", "20", "50", "5/10", "100", "Detail"),
		new Ride( "11:12", "12:12", "20", "50", "5/10", "100", "Detail1"),
		new Ride( "11:12", "12:12", "20", "50", "5/10", "100", "Detail"),
		new Ride( "11:12", "12:12", "20", "50", "5/10", "100", "Det25ail1"),
		new Ride( "11:12", "12:12", "20", "50", "5/10", "100", "Detail"),
		new Ride( "11:12", "12:12", "20", "50", "5/10", "100", "Detail1"),
		
		new Ride( "11:12", "12:12", "20", "50", "5/10", "100", "Detail"),
		new Ride( "11:12", "12:12", "20", "50", "5/10", "100", "Detail1"),
		new Ride( "11:12", "12:12", "20", "50", "5/10", "100", "Detail"),
		new Ride( "11:12", "12:12", "20", "50", "5/10", "100", "Detail1"),
		new Ride( "11:12", "12:12", "20", "50", "5/10", "100", "Detail"),
		new Ride( "11:12", "12:12", "20", "50", "5/10", "100", "Detail1"),
		new Ride( "11:12", "12:12", "20", "50", "5/10", "100", "Detail"),
		new Ride( "11:12", "12:12", "20", "50", "5/10", "100", "Detail1"),
		new Ride( "11:12", "12:12", "20", "50", "5/10", "100", "Deta66il"),
		new Ride( "11:12", "12:12", "20", "50", "5/10", "100", "Detail1"),
		new Ride( "11:12", "12:12", "20", "50", "5/10", "100", "Detail"),
		new Ride( "11:12", "12:12", "20", "50", "5/10", "100", "Detail1"),
		new Ride( "11:12", "12:12", "20", "50", "5/10", "100", "Detail"),
		new Ride( "11:12", "12:12", "20", "50", "5/10", "100", "Detail1"),
		new Ride( "11:12", "12:12", "20", "50", "5/10", "100", "Detail"),
		new Ride( "11:12", "12:12", "20", "50", "5/10", "100", "Detail1"),
		new Ride( "11:12", "12:12", "20", "50", "5/10", "100", "Detail"),
		new Ride( "11:12", "12:12", "20", "50", "5/10", "100", "Detail1"),
		new Ride( "11:12", "12:12", "20", "50", "5/10", "100", "Detail"),
		new Ride( "11:12", "12:12", "20", "50", "5/10", "100", "De6tail1"),
		new Ride( "11:12", "12:12", "20", "50", "5/10", "100", "Detail"),
		new Ride( "11:12", "12:12", "20", "50", "5/10", "100", "Det5ail1"),
		new Ride( "11:12", "12:12", "20", "50", "5/10", "100", "Detail"),
		new Ride( "11:12", "12:12", "20", "50", "5/10", "100", "Detail1"),
		new Ride( "11:12", "12:12", "20", "50", "5/10", "100", "Detail"),
		new Ride( "11:12", "12:12", "20", "50", "5/10", "100", "Detail1"),
		
		new Ride( "11:12", "12:12", "20", "50", "5/10", "100", "Detail"),
		new Ride( "11:12", "12:12", "20", "50", "5/10", "100", "Detail1"),
		new Ride( "11:12", "12:12", "20", "50", "5/10", "100", "Detail"),
		new Ride( "11:12", "12:12", "20", "50", "5/10", "100", "Det4ail1"),
		new Ride( "11:12", "12:12", "20", "50", "5/10", "100", "De3tail"),
		new Ride( "11:12", "12:12", "20", "50", "5/10", "100", "Detail1"),
		new Ride( "11:12", "12:12", "20", "50", "5/10", "100", "Det3ail"),
		new Ride( "11:12", "12:12", "20", "50", "5/10", "100", "Detail1"),
		new Ride( "11:12", "12:12", "20", "50", "5/10", "100", "Detail"),
		new Ride( "11:12", "12:12", "20", "50", "5/10", "100", "Detail1"),
		new Ride( "11:12", "12:12", "20", "50", "5/10", "100", "Detail"),
		new Ride( "11:12", "12:12", "20", "50", "5/10", "100", "Detail1"),
		new Ride( "11:12", "12:12", "20", "50", "5/10", "100", "Detail"),
		new Ride( "11:12", "12:12", "20", "50", "5/10", "100", "Detail1"),
		new Ride( "11:12", "12:12", "20", "50", "5/10", "100", "Detail"),
		new Ride( "11:12", "12:12", "20", "50", "5/10", "100", "Detail1"),
		new Ride( "11:12", "12:12", "20", "50", "5/10", "100", "Detail"),
		new Ride( "11:12", "12:12", "20", "50", "5/10", "100", "Detail1"),
		new Ride( "11:12", "12:12", "20", "50", "5/10", "100", "Detail"),
		new Ride( "11:12", "12:12", "20", "50", "5/10", "100", "Detail1"),
		new Ride( "11:12", "12:12", "20", "50", "5/10", "100", "Detail"),
		new Ride( "11:12", "12:12", "20", "50", "5/10", "100", "Detail1"),
		new Ride( "11:12", "12:12", "20", "50", "5/10", "100", "Detail"),
		new Ride( "11:12", "12:12", "20", "50", "5/10", "100", "Det2ail1"),
		new Ride( "11:12", "12:12", "20", "50", "5/10", "100", "Detail"),
		new Ride( "11:12", "12:12", "20", "50", "5/10", "100", "Detail1"),
		
		new Ride( "11:12", "12:12", "20", "50", "5/10", "100", "Detail"),
		new Ride( "11:12", "12:12", "20", "50", "5/10", "100", "Detail1"),
		new Ride( "11:12", "12:12", "20", "50", "5/10", "100", "Detail"),
		new Ride( "11:12", "12:12", "20", "50", "5/10", "100", "Detail1"),
		new Ride( "11:12", "12:12", "20", "50", "5/10", "100", "Detail"),
		new Ride( "11:12", "12:12", "20", "50", "5/10", "100", "Detail1"),
		new Ride( "11:12", "12:12", "20", "50", "5/10", "100", "Detail"),
		new Ride( "11:12", "12:12", "20", "50", "5/10", "100", "Detail1"),
		new Ride( "11:12", "12:12", "20", "50", "5/10", "100", "Detail"),
		new Ride( "11:12", "12:12", "20", "50", "5/10", "100", "Detail1"),
		new Ride( "11:12", "12:12", "20", "50", "5/10", "100", "Detail"),
		new Ride( "11:12", "12:12", "20", "50", "5/10", "100", "Detail1"),
		new Ride( "11:12", "12:12", "20", "50", "5/10", "100", "Det3ail"),
		new Ride( "11:12", "12:12", "20", "50", "5/10", "100", "Detail1"),
		new Ride( "11:12", "12:12", "20", "50", "5/10", "100", "Det7ail"),
		new Ride( "11:12", "12:12", "20", "50", "5/10", "100", "Detail1"),
		new Ride( "11:12", "12:12", "20", "50", "5/10", "100", "Detail"),
		new Ride( "11:12", "12:12", "20", "50", "5/10", "100", "Detail1"),
		new Ride( "11:12", "12:12", "20", "50", "5/10", "100", "Detail"),
		new Ride( "11:12", "12:12", "20", "50", "5/10", "100", "Detail1"),
		new Ride( "11:12", "12:12", "20", "50", "5/10", "100", "Detail"),
		new Ride( "11:12", "12:12", "20", "50", "5/10", "100", "De8tail1"),
		new Ride( "11:12", "12:12", "20", "50", "5/10", "100", "Det9ail"),
		new Ride( "11:12", "12:12", "20", "50", "5/10", "100", "Detail1"),
		new Ride( "11:12", "12:12", "20", "50", "5/10", "100", "Detail"),
		new Ride( "11:12", "12:12", "20", "50", "5/10", "100", "Detail1"),
		new Ride( "11:12", "12:12", "20", "50", "5/10", "100", "Detail"),
		new Ride( "11:12", "12:12", "20", "50", "5/10", "100", "Detail1"),
		new Ride( "11:12", "12:12", "20", "50", "5/10", "100", "Detail"),
		new Ride( "11:12", "12:12", "20", "50", "5/10", "100", "Detail1"),
		new Ride( "11:12", "12:12", "20", "50", "5/10", "100", "Detail"),
		new Ride( "11:12", "12:12", "20", "50", "5/10", "100", "Det96ail1"),
		new Ride( "11:12", "12:12", "20", "50", "5/10", "100", "Detail"),
		new Ride( "11:12", "12:12", "20", "50", "5/10", "100", "Detail1"),
		new Ride( "11:12", "12:12", "20", "50", "5/10", "100", "Detail"),
		new Ride( "11:12", "12:12", "20", "50", "5/10", "100", "Detail1"),
		new Ride( "11:12", "12:12", "20", "50", "5/10", "100", "Detail"),
		new Ride( "11:12", "12:12", "20", "50", "5/10", "100", "Detail1"),
		new Ride( "11:12", "12:12", "20", "50", "5/10", "100", "Detail"),
		new Ride( "11:12", "12:12", "20", "50", "5/10", "100", "Detail1"),
		new Ride( "11:12", "12:12", "20", "50", "5/10", "100", "Detail"),
		new Ride( "11:12", "12:12", "20", "50", "5/10", "100", "Detail1"),
		new Ride( "11:12", "12:12", "20", "50", "5/10", "100", "Detail"),
		new Ride( "11:12", "12:12", "20", "50", "5/10", "100", "Detail1"),
		new Ride( "11:12", "12:12", "20", "50", "5/10", "100", "Detail"),
		new Ride( "11:12", "12:12", "20", "50", "5/10", "100", "Detail1"),
		new Ride( "11:12", "12:12", "20", "50", "5/10", "100", "Detail"),
		new Ride( "11:12", "12:12", "20", "50", "5/10", "100", "Detail1"),
		new Ride( "11:12", "12:12", "20", "50", "5/10", "100", "Detail"),
		new Ride( "11:12", "12:12", "20", "50", "5/10", "100", "Detail1"),
		new Ride( "11:12", "12:12", "20", "50", "5/10", "100", "Detail"),
		new Ride( "11:12", "12:12", "20", "50", "5/10", "100", "Detail1"),
		new Ride( "11:12", "12:12", "20", "50", "5/10", "100", "Det6ail"),
		new Ride( "11:12", "12:12", "20", "50", "5/10", "100", "Detail1"),
		new Ride( "11:12", "12:12", "20", "50", "5/10", "100", "Detail"),
		new Ride( "11:12", "12:12", "20", "50", "5/10", "100", "Detail1"),
		new Ride( "11:12", "12:12", "20", "50", "5/10", "100", "Detail"),
		new Ride( "11:12", "12:12", "20", "50", "5/10", "100", "Detail1"),
		new Ride( "11:12", "12:12", "20", "50", "5/10", "100", "Detail"),
		new Ride( "11:12", "12:12", "20", "50", "5/10", "100", "Detail1"),
		new Ride( "11:12", "12:12", "20", "50", "5/10", "100", "Detail"),
		new Ride( "11:12", "12:12", "20", "50", "5/10", "100", "Detail1"),
		new Ride( "11:12", "12:12", "20", "50", "5/10", "100", "Detail"),
		new Ride( "11:12", "12:12", "20", "50", "5/10", "100", "Detail1"),
		new Ride( "11:12", "12:12", "20", "50", "5/10", "100", "De3tail"),
		new Ride( "11:12", "12:12", "20", "50", "5/10", "100", "Detail1"),
		new Ride( "11:12", "12:12", "20", "50", "5/10", "100", "Detail"),
		new Ride( "11:12", "12:12", "20", "50", "5/10", "100", "Detail1"),
		new Ride( "11:12", "12:12", "20", "50", "5/10", "100", "Detail"),
		new Ride( "11:12", "12:12", "20", "50", "5/10", "100", "Detail1"),
		new Ride( "11:12", "12:12", "20", "50", "5/10", "100", "Detail"),
		new Ride( "11:12", "12:12", "20", "50", "5/10", "100", "Det2ail1"),
		new Ride( "11:12", "12:12", "20", "50", "5/10", "100", "Detail"),
		new Ride( "11:12", "12:12", "20", "50", "5/10", "100", "Detail1"),
		new Ride( "11:12", "12:12", "20", "50", "5/10", "100", "Detail"),
		new Ride( "11:12", "12:12", "20", "50", "5/10", "100", "Detail1"),
		new Ride( "11:12", "12:12", "20", "50", "5/10", "100", "Detail"),
		new Ride( "11:12", "12:12", "20", "50", "5/10", "100", "Detail1"),
		new Ride( "11:12", "12:12", "20", "50", "5/10", "100", "Detail"),
		new Ride( "11:12", "12:12", "20", "50", "5/10", "100", "Detail1"),
		new Ride( "11:12", "12:12", "20", "50", "5/10", "100", "Det1ail"),
		new Ride( "11:12", "12:12", "20", "50", "5/10", "100", "Detail1"),
		new Ride( "11:12", "12:12", "20", "50", "5/10", "100", "Detail"),
		new Ride( "11:12", "12:12", "20", "50", "5/10", "100", "Detail1"),
		new Ride( "11:12", "12:12", "20", "50", "5/10", "100", "Detail"),
		new Ride( "11:12", "12:12", "20", "50", "5/10", "100", "Detail1"),
		new Ride( "11:12", "12:12", "20", "50", "5/10", "100", "Detail"),
		new Ride( "11:12", "12:12", "20", "50", "5/10", "100", "Detail1"),
		new Ride( "11:12", "12:12", "20", "50", "5/10", "100", "Detail"),
		new Ride( "11:12", "12:12", "20", "50", "5/10", "100", "Det2ail1"),
		new Ride( "11:12", "12:12", "20", "50", "5/10", "100", "Detail"),
		new Ride( "11:12", "12:12", "20", "50", "5/10", "100", "Detail1"),
		new Ride( "11:12", "12:12", "20", "50", "5/10", "100", "Detail"),
		new Ride( "11:12", "12:12", "20", "50", "5/10", "100", "Detail1"),
		new Ride( "11:12", "12:12", "20", "50", "5/10", "100", "Detail"),
		new Ride( "11:12", "12:12", "20", "50", "5/10", "100", "Detail1"),
		new Ride( "11:12", "12:12", "20", "50", "5/10", "100", "Detail"),
		new Ride( "11:12", "12:12", "20", "50", "5/10", "100", "Detail1"),
		new Ride( "11:12", "12:12", "20", "50", "5/10", "100", "Detail"),
		new Ride( "11:12", "12:12", "20", "50", "5/10", "100", "Detail1"),
		new Ride( "11:12", "12:12", "20", "50", "5/10", "100", "Det3ail"),
		new Ride( "11:12", "12:12", "20", "50", "5/10", "100", "Detail1"),
		new Ride( "11:12", "12:12", "20", "50", "5/10", "100", "Detail"),
		new Ride( "11:12", "12:12", "20", "50", "5/10", "100", "Detail1"),
		
		
		}; */

/*   InputStream is = new ByteArrayInputStream(output.getBytes());
XmlDeserializer deserializer = new XmlDeserializer();
AutoDeserializerItem loginItem = new AutoDeserializerItem("user-login", null, UserLogin.class);
AutoDeserializer.factory(deserializer, is, loginItem).deserialize();
UserLogin newLogin = (UserLogin) loginItem.getItem();*/
 
//		name.setText(appInfoItem.getAppName());
//		hello.setText(appInfoItem.getHello());
//		version.setText(appInfoItem.getVersion());
