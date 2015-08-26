package controllers;

import static org.junit.Assert.assertEquals;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import data_access.DBConnection;
import data_access.DBConnection.DBType;
import data_access.Room;

public class RoomCtrlTests {
	
	// hello carla
	// hello alex
	private static Connection connection;

	@BeforeClass
	public static void setup() throws SQLException {
		DBConnection.setup(DBType.H2);
		connection = DBConnection.getInstance().getConnection();
		createRoomTable();
		createResourceTable();
		createRoomResourceTable();
		connection.commit();
		prepareRoom();
		prepareRoom();
	}

	@Test
	public void testReadRoomAvailable() throws SQLException {
		RoomController rc = new RoomController();

		Room room = rc.readRoom("A11");
		assertEquals(1, room.getIdRoom());
		assertEquals("A11", room.getName());
		assertEquals(8, room.getCapacity());
		assertEquals("no description", room.getDescription());
	}

	@Test
	public void testReadRoomNoDataAvailable() {
		RoomController rc = new RoomController();
		Room room = rc.readRoom("NO_DATA");

		assertEquals(null, room);
	}

	@Test
	public void testReadRoomWithNullId() throws SQLException {
		RoomController rc = new RoomController();
		Room room = rc.readRoom(null);
		assertEquals(null, room);
	}

	@Test
	public void readRooms(){
		RoomController rc = new RoomController();
		List<Room> rooms = rc.readRooms();
		
		List<Room> rms = new ArrayList<Room>();
		Room room = new Room();
		room.setIdRoom(1);
		room.setName("A11");
		room.setCapacity(8);
		room.setDescription("no description");
		rms.add(room);
		
		assertEquals(rms, rooms);
	}
	
	
	private static void prepareRoom() throws SQLException {
		String InsertQuery = "INSERT INTO ROOM"
				+ "(idRoom, name, capacity, description) values" + "(?,?,?,?)";

		PreparedStatement insertPreparedStatement = connection
				.prepareStatement(InsertQuery);
		insertPreparedStatement.setInt(1, 1);
		insertPreparedStatement.setString(2, "A11");
		insertPreparedStatement.setInt(3, 8);
		insertPreparedStatement.setString(4, "no description");
		insertPreparedStatement.executeUpdate();
		insertPreparedStatement.close();
		connection.commit();
	}
	
	private static void createRoomTable() throws SQLException{
		String CreateQuery = "CREATE TABLE ROOM(idRoom int primary key, name varchar(255), capacity int, description varchar(255))";
		PreparedStatement createPreparedStatement = null;
		createPreparedStatement = connection.prepareStatement(CreateQuery);
		connection.setAutoCommit(false);
		createPreparedStatement.executeUpdate();
		createPreparedStatement.close();
	}
	
	private static void createResourceTable() throws SQLException{
		String CreateQuery = "CREATE TABLE RESOURCE(idResource int primary key, name varchar(255), description varchar(255), icon varchar(255))";
		PreparedStatement createPreparedStatement = null;
		createPreparedStatement = connection.prepareStatement(CreateQuery);
		connection.setAutoCommit(false);
		createPreparedStatement.executeUpdate();
		createPreparedStatement.close();
	}
	
	private static void createRoomResourceTable() throws SQLException{
		String CreateQuery = "CREATE TABLE ROOM_RESOURCE(idRoom int, idResource int, FOREIGN KEY (idRoom) references Room(idRoom), FOREIGN KEY (idResource) references Resource(idResource))";
		PreparedStatement createPreparedStatement = null;
		createPreparedStatement = connection.prepareStatement(CreateQuery);
		connection.setAutoCommit(false);
		createPreparedStatement.executeUpdate();
		createPreparedStatement.close();
	}
	@AfterClass
	public static void destroy() throws SQLException {
		connection.close();
	}

}
