package controllers;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;



import data_access.DBConnection;
import data_access.Reservation;
import data_access.Room;

public class ReservationController {

	public Reservation readReservation(Reservation r) {
		return null;
	}

	public ArrayList<Reservation> readReservations() {
		
		String statement = "SELECT reservation.*, room.* FROM reservation INNER JOIN room ON reservation.idRoom = room.idRoom";
		ResultSet result = null;
		try {
			PreparedStatement prepstatement = DBConnection.getInstance().getConnection().prepareStatement(statement);
			 result = DBConnection.getInstance().executeQuery(prepstatement);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return fromResultSetToResource(result);
	}

	public ArrayList<Reservation> fromResultSetToResource(ResultSet set) {
		ArrayList<Reservation> reservations = new ArrayList<Reservation>();
		try {
			while(set.next()){
				Reservation reservation = new Reservation();
				
				reservation.setIdReservation(set.getInt("idReservation"));
				reservation.setStartTime(set.getDate("startTime"));
				reservation.setEndTime(set.getDate("endTime"));
				reservation.setSubject(set.getString("subject"));
				reservation.setOwner(set.getString("owner"));
				reservation.setCheckInTime(set.getDate("check_in_time"));
				reservation.setCheckOutTime(set.getDate("check_out_time"));
				
				Room room = new Room();
				room.setIdRoom(set.getInt("idRoom"));
				room.setName(set.getString("name"));
				room.setCapacity(set.getInt("capacity"));
				room.setDescription(set.getString("description"));
				reservation.setRoom(room);
				
				reservations.add(reservation);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
	return reservations;
	}
	
}
