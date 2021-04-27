package modelLayer;

public class Clothing extends Product {

		private String size;
		private String color;
		
	public Clothing(int productID, String name, double purchasePrice, double salePrice, double rentPrice,
			String countryOfOrigin, int minStock, int maxStock, String size, String color) {
		super(productID, name, purchasePrice, salePrice, rentPrice, countryOfOrigin, minStock, maxStock);
		this.size = size;
		this.color = color;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return "Clothing [size=" + size + ", color=" + color + ", toString()=" + super.toString() + "]";
	}
	
	

}
