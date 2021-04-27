package modelLayer;

public class SaleOrderLine {
	private int saleID;
	private int productID;
	private int quantity;
	
	public SaleOrderLine(int saleID, int productID, int quantity) {
		this.saleID = saleID;
		this.productID = productID;
		this.quantity = quantity;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getSaleID() {
		return saleID;
	}

	public int getProductID() {
		return productID;
	}

	@Override
	public String toString() {
		return "SaleOrderLine [saleID=" + saleID + ", productID=" + productID + ", quantity=" + quantity + "]";
	}
	
	
	
	
	
}
