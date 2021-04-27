package modelLayer;

public class Stock {
	private int quantity;
	private int locationID;
	private int productID;
	
	public Stock(int quantity, int locationID, int productID) {
		this.locationID = locationID;
		this.quantity = quantity;
		this.productID = productID;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getLocationID() {
		return locationID;
	}

	public int getProductID() {
		return productID;
	}

	@Override
	public String toString() {
		return "Stock [quantity=" + quantity + ", locationID=" + locationID + ", productID=" + productID + "]";
	}
	
}
