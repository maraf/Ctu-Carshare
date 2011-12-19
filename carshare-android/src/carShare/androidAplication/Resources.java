package carShare.androidAplication;

import java.util.Collection;

import com.carshare.domain.dto.TripRow;

public class Resources {

	private static String idUser;
	private static Collection<TripRow> tripRows;
	
	public static Collection<TripRow> getTripRows() {
		return tripRows;
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
