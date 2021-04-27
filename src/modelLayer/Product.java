package modelLayer;

public class Product {
	private Integer productID;
	private String name;
	private double purchasePrice;
	private double salePrice;
	private double rentPrice;
	private String countryOfOrigin;
	private int minStock;
	private int maxStock;
	
	public Product(Integer productID, String name, double purchasePrice, double salePrice, double rentPrice,
			String countryOfOrigin, int minStock, int maxStock) {
		super();
		this.productID = productID;
		this.name = name;
		this.purchasePrice = purchasePrice;
		this.salePrice = salePrice;
		this.rentPrice = rentPrice;
		this.countryOfOrigin = countryOfOrigin;
		this.minStock = minStock;
		this.maxStock = maxStock;
	}

	public int getProductID() {
		return productID;
	}

	public void setProductID(int productID) {
		this.productID = productID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPurchasePrice() {
		return purchasePrice;
	}

	public void setPurchasePrice(double purchasePrice) {
		this.purchasePrice = purchasePrice;
	}

	public double getSalePrice() {
		return salePrice;
	}

	public void setSalePrice(double salePrice) {
		this.salePrice = salePrice;
	}

	public double getRentPrice() {
		return rentPrice;
	}

	public void setRentPrice(double rentPrice) {
		this.rentPrice = rentPrice;
	}

	public String getCountryOfOrigin() {
		return countryOfOrigin;
	}

	public void setCountryOfOrigin(String countryOfOrigin) {
		this.countryOfOrigin = countryOfOrigin;
	}

	public int getMinStock() {
		return minStock;
	}

	public void setMinStock(int minStock) {
		this.minStock = minStock;
	}

	public int getMaxStock() {
		return maxStock;
	}

	public void setMaxStock(int maxStock) {
		this.maxStock = maxStock;
	}

	@Override
	public String toString() {
		return "Product [productID=" + productID + ", name=" + name + ", purchasePrice=" + purchasePrice
				+ ", salePrice=" + salePrice + ", rentPrice=" + rentPrice + ", countryOfOrigin=" + countryOfOrigin
				+ ", minStock=" + minStock + ", maxStock=" + maxStock + "]";
	}
	
	
	
}
