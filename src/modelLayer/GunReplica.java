package modelLayer;

public class GunReplica extends Product {
	
	private String calibre;
	private String material;
	
	public GunReplica(int productID, String name, double purchasePrice, double salePrice, double rentPrice,
			String countryOfOrigin, int minStock, int maxStock, String calibre, String material) {
		super(productID, name, purchasePrice, salePrice, rentPrice, countryOfOrigin, minStock, maxStock);
		this.calibre = calibre;
		this.material = material;
	}

	public String getCalibre() {
		return calibre;
	}

	public void setCalibre(String calibre) {
		this.calibre = calibre;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	@Override
	public String toString() {
		return "GunReplica [calibre=" + calibre + ", material=" + material + ", toString()=" + super.toString() + "]";
	}

}
