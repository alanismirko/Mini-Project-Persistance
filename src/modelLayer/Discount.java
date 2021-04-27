package modelLayer;

public class Discount {
	private int discountID;
	private String description;
	private double value;
	private String startDate;
	private String endDate;
	
	public Discount(int discountID, String description, double value, String startDate, String endDate) {
		super();
		this.discountID = discountID;
		this.description = description;
		this.value = value;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public int getDiscountID() {
		return discountID;
	}

	public void setDiscountID(int discountID) {
		this.discountID = discountID;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	@Override
	public String toString() {
		return "Discount [discountID=" + discountID + ", description=" + description + ", value=" + value
				+ ", startDate=" + startDate + ", endDate=" + endDate + "]";
	}
	
}
