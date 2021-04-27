package modelLayer;

public class Delivery {
	private int deliveryID;
	private boolean isDelivered;
	private String date;
	private double cost;
	
	public Delivery(int deliveryID, boolean isDelivered, String date, double cost) {
		super();
		this.deliveryID = deliveryID;
		this.isDelivered = isDelivered;
		this.date = date;
		this.cost = cost;
	}

	public int getDeliveryID() {
		return deliveryID;
	}

	public void setDeliveryID(int deliveryID) {
		this.deliveryID = deliveryID;
	}

	public boolean isDelivered() {
		return isDelivered;
	}

	public void setDelivered(boolean isDelivered) {
		this.isDelivered = isDelivered;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	@Override
	public String toString() {
		return "Delivery [deliveryID=" + deliveryID + ", isDelivered=" + isDelivered + ", date=" + date + ", cost="
				+ cost + "]";
	}
	
	
}
