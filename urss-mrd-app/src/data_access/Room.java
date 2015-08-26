package data_access;

import java.util.ArrayList;

public class Room {
	
	//test norbi

	private int idRoom;
	private String name;
	private int capacity;
	private String description;
	private ArrayList<Resource> resources = new ArrayList<Resource>();
	
	public int getIdRoom() {
		return idRoom;
	}
	public void setIdRoom(int idRoom) {
		this.idRoom = idRoom;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public ArrayList<Resource> getResources() {
		return resources;
	}
	public void setResources(ArrayList<Resource> resources) {
		this.resources = resources;
	}
	
	
}
