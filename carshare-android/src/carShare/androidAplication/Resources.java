package carShare.androidAplication;

import com.carshare.domain.dto.TripRow;

public class Resources {

	private static String idUser;
	private static TripRow [] rows;
	
	public static TripRow[] getRows() {
		return rows;
	}
	public static void setRows(TripRow[] rows) {
		Resources.rows = rows;
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
