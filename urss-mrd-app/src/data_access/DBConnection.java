package data_access;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConnection {

	private static final String DB_DRIVER = "org.h2.Driver";
	private static final String DB_CONNECTION = "jdbc:h2:mem:test;DB_CLOSE_DELAY=-1";
	private static final String DB_USER = "";
	private static final String DB_PASSWORD = "";

	public enum DBType {
		MYSQL, H2
	}

	private static DBConnection instace;
	private static DBType type;
	private Connection connection;

	private DBConnection() {
		switch (type) {
		case MYSQL:
			buildMySQLConnection();
			break;
		case H2:
			buildH2Connection();
			break;
		default:
			buildMySQLConnection();
		}
	}

	private void buildH2Connection() {
		try {
			Class.forName(DB_DRIVER);
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
		try {
			connection = DriverManager.getConnection(DB_CONNECTION, DB_USER,
					DB_PASSWORD);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

	}

	private void buildMySQLConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = (Connection) DriverManager.getConnection(
					"jdbc:mysql://192.168.69.62:3306/mrd_db", "internship",
					"1234");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static DBConnection getInstance() {

		if (instace == null) {
			instace = new DBConnection();
		}

		return instace;
	}

	public static void setup(DBType type) {
		DBConnection.type = type;
	}

	public Connection getConnection() {
		return connection;
	}

	public ResultSet executeQuery(PreparedStatement prep) {
		ResultSet rs = null;
		try {
			rs = prep.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return rs;
	}

	public void executeUpdate(PreparedStatement prep) {
		try {
			prep.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
