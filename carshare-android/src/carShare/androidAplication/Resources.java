package carShare.androidAplication;

import java.util.Collection;

import android.content.Context;
import android.widget.Toast;

import com.carshare.domain.dto.TripRow;

public class Resources {

	private static String idUser;
	private static Collection<TripRow> tripRows;
	
	public static void NotificationMessage(Context context, CharSequence text){
	        Toast toast = Toast.makeText(context, text, Toast.LENGTH_LONG);
	        toast.show();
	}
	
	public static Collection<TripRow> getTripRows() {
		return tripRows;
	}
	
	public static TripRow[] getTripRowsArray() {
		return  (TripRow[]) tripRows.toArray(new TripRow[tripRows.size()]);
	}
	
	public static void setTripRows(Collection<TripRow> tripRows) {
		Resources.tripRows = tripRows;
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
