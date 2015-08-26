package controllers;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import data_access.DBConnection;
import data_access.Resource;

public class ResourceController {

	public void createResource(Resource r) {

	}

	public Resource readResource(Resource r) {
		return null;
	}

	public ArrayList<Resource> readResources() {

		ResultSet resultSet = null;
		try {
			PreparedStatement preparedStatement = DBConnection.getInstance()
					.getConnection()
					.prepareStatement("SELECT * FROM resource;");
			resultSet = DBConnection.getInstance().executeQuery(
					preparedStatement);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return fromResultSetToResource(resultSet);
	}

	public void updateResource(Resource r) {

	}

	public void deleteResource(Resource r) {

	}

	public ArrayList<Resource> fromResultSetToResource(ResultSet resultSet) {
		ArrayList<Resource> resources = new ArrayList<Resource>();
		try {
			while (resultSet.next()) {
				Resource resource = new Resource();
				resource.setIdResource(resultSet.getInt(1));
				resource.setName(resultSet.getString(2));
				resource.setDescription(resultSet.getString(3));
				resource.setIcon(resultSet.getString(4));
				resources.add(resource);
			}
			if (resultSet != null) {
				resultSet.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resources;
	}
}