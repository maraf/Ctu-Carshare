package carShare.androidAplication;

import java.util.Collection;
import java.util.Date;

import android.content.Context;
import android.widget.Toast;

import com.carshare.domain.dto.TripRow;
import com.carshare.domain.dto.UserInTrip;
import com.carshare.domain.dto.UserMessage;

public class Resources {

	public static UserMessage selectedMessage;
	private static String idUser;
	private static Collection<TripRow> tripRows;
	private static Collection<UserInTrip> passangerRows;
	public static Collection<UserMessage> messages = null;
	public static int selectedRow = 0;
	
	public static void NotificationMessage(Context context, CharSequence text){
	        Toast toast = Toast.makeText(context, text, Toast.LENGTH_LONG);
	        toast.show();
	}
	
	public static Collection<TripRow> getTripRows() {
		return tripRows;
	}
	
	public static TripRow[] getTripRowsArray() {
	
		return new TripRow[] {new TripRow("1","A","B",new Date(),new Date(),5,2,10,"d1",3)};
		//return  (TripRow[]) tripRows.toArray(new TripRow[tripRows.size()]);
	}
	
	public static UserInTrip[] getUserInTripArray() {

		return  (UserInTrip[]) passangerRows.toArray(new UserInTrip[passangerRows.size()]);
	}
	
	public static UserMessage[] getMessageArray(){
		return (UserMessage[]) messages.toArray(new UserMessage[messages.size()]);
	}
	
	public static void setTripRows(Collection<TripRow> tripRows) {
		Resources.tripRows = tripRows;
	}
	
	public static void setUserInTrip(Collection<UserInTrip> userInTrip) {
		Resources.passangerRows = userInTrip;
	}
	
	private static String server = "http://car-share.appspot.com";
	
	public static String getIdUser() {
		return idUser;
	}
	public static void setIdUser(String idUser) {
		Resources.idUser = idUser;
	}
	public static String getServer() {
		return server;
	}
	public static void setServer(String server) {
		Resources.server = server;
	}
}
