package controllers;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import data_access.DBConnection;
import data_access.Resource;
import data_access.Room;

public class RoomController {

	/* Reads a room by name */
	public Room readRoom(String name) {
		String statement = "SELECT *FROM room WHERE name=?";
		ResultSet result = null;
		try {
			PreparedStatement prepstatement = DBConnection.getInstance()
					.getConnection().prepareStatement(statement);
			prepstatement.setString(1, name);
			result = DBConnection.getInstance().executeQuery(prepstatement);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return fromResultSetToRoom(result);
	}

	/* Reads all rooms and all resources for every room */
	public List<Room> readRooms() {
		List<Room> rooms = new ArrayList<Room>();
		String statement = "SELECT Room.*, Resource.* FROM room LEFT JOIN room_resource ON room.idRoom=room_resource.idRoom LEFT JOIN resource ON room_resource.idResource=resource.idResource";
		ResultSet result = null;
		try {
			PreparedStatement prepstatement = DBConnection.getInstance()
					.getConnection().prepareStatement(statement);
			result = DBConnection.getInstance().executeQuery(prepstatement);
			rooms = fromResultSetToRoomsAndResources(result);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return rooms;
	}

	/* Reads all resources for a room */
	public List<Resource> readRoomResource(Room r) {
		String statement = "SELECT Resource.* FROM room INNER JOIN room_resource"
				+ " ON room.idRoom=room_resource.idRoom INNER JOIN resource ON room_resource.idResource=resource.idResource"
				+ " WHERE room.idRoom=?";
		ResultSet result = null;
		try {
			PreparedStatement prepstatement = DBConnection.getInstance()
					.getConnection().prepareStatement(statement);
			prepstatement.setInt(1, r.getIdRoom());
			result = DBConnection.getInstance().executeQuery(prepstatement);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return fromResultSetToResources(result);
	}

	/*Returns a list of Rooms and Resources for every Room from a ResultSet*/
	private List<Room> fromResultSetToRoomsAndResources(ResultSet set) {
		Map<Integer, Room> rooms = new HashMap<Integer, Room>();
		try {
			while (set.next()) {
				int roomId = set.getInt("idRoom");
				Room rm = rooms.get(roomId);
				if (rm == null) {
					rm = new Room();
					rm.setIdRoom(roomId);
					rm.setName(set.getString("name"));
					rm.setCapacity(set.getInt("capacity"));
					rm.setDescription(set.getString("description"));
					rooms.put(roomId, rm);
				}
				Resource res = new Resource();
				res.setIdResource(set.getInt("idResource"));
				res.setName(set.getString("name"));
				res.setIcon(set.getString("icon"));
				res.setDescription(set.getString("description"));
				rm.getResources().add(res);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return (new ArrayList<Room>(rooms.values()));
	}

	/*Returns an array of Resources from a ResultSet*/
	private List<Resource> fromResultSetToResources(ResultSet result) {
		ArrayList<Resource> resources = new ArrayList<Resource>();
		try {
			while (result.next()) {
				Resource resource = new Resource();
				resource.setIdResource(result.getInt("idResource"));
				resource.setName(result.getString("name"));
				resource.setIcon(result.getString("icon"));
				resource.setDescription(result.getString("description"));
				resources.add(resource);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resources;
	}

	/*Returns a Room from a ResultSet*/
	private Room fromResultSetToRoom(ResultSet set) {
		Room rm = new Room();
		try {
			set.next();
			rm.setIdRoom(set.getInt("idRoom"));
			rm.setName(set.getString("name"));
			rm.setCapacity(set.getInt("capacity"));
			rm.setDescription(set.getString("description"));
		} catch (SQLException e) {
			//e.printStackTrace();
			rm = null;
		}
		return rm;
	}
	

	public void createRoom(Room r) {

	}

	public void updateRoom(Room r) {

	}

	public void deleteRoom(Room r) {

	}

}
