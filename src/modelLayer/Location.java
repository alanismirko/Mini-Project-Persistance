package modelLayer;

import java.util.ArrayList;

public class Location {
	private int locationID;
	private String name;
	private int capacity;
	private ArrayList<Stock> inStock;
	
	//location without specified items in stock
	public Location(int locationID, String name, int capacity) {
		super();
		this.locationID = locationID;
		this.name = name;
		this.capacity = capacity;
	}

	//location with specified items in stock
	public Location(int locationID, String name, int capacity, ArrayList<Stock> inStock) {
		super();
		this.locationID = locationID;
		this.name = name;
		this.capacity = capacity;
		this.inStock = inStock;
	}

	public int getLocationID() {
		return locationID;
	}

	public void setLocationID(int locationID) {
		this.locationID = locationID;
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

	public ArrayList<Stock> getInStock() {
		return inStock;
	}

	public void setInStock(ArrayList<Stock> inStock) {
		this.inStock = inStock;
	}

	@Override
	public String toString() {
		return "Location [locationID=" + locationID + ", name=" + name + ", capacity=" + capacity + ", inStock="
				+ inStock + "]";
	}
	
	
	
}
