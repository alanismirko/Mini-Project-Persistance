package controllerLayer;

import dbLayer.*;
import modelLayer.*;


public class ProductController {
	private ProductDBIF prodDB;
	private ClothingDBIF clotDB;
	private EquipmentDBIF eqDB;
	private GunReplicaDBIF grDB;
	
	public ProductController() throws DataAccessException {
		prodDB = new ProductDB();
		clotDB = new ClothingDB();
		eqDB = new EquipmentDB();
		grDB = new GunReplicaDB();
	}
	
	//All the create methods for adding the products of all types
	public Clothing insertClothing(Clothing clothing) throws DataAccessException {
		prodDB.insertProduct(clothing);
		clotDB.insertClothing(clothing);
		return clothing;
	}
	
	public Equipment insertEquipment(Equipment equipment) throws DataAccessException {
		prodDB.insertProduct(equipment);
		eqDB.insertEquipment(equipment);
		return equipment;
	}
	
	public GunReplica insertGunReplica(GunReplica gunReplica) throws DataAccessException {
		prodDB.insertProduct(gunReplica);
		grDB.insertGunReplica(gunReplica);
		return gunReplica;
	}
	
	public Product insertProduct(Product product) throws DataAccessException {
		prodDB.insertProduct(product);
		return product;
	}
	
	//All the update methods for all the product types
	public void updateProduct(int productID, String name, double purchasePrice, double salePrice, double rentPrice,
			String countryOfOrigin, int minStock, int maxStock) throws DataAccessException{
		prodDB.updateProduct(productID, name, purchasePrice, salePrice, rentPrice, countryOfOrigin, minStock, maxStock);
	}
	
	public void updateClothing(int productID, String name, double purchasePrice, double salePrice, double rentPrice,
			String countryOfOrigin, int minStock, int maxStock, String size, String color) throws DataAccessException{
		prodDB.updateProduct(productID, name, purchasePrice, salePrice, rentPrice, countryOfOrigin, minStock, maxStock);
		clotDB.updateClothing(productID, size, color);
	}
	
	public void updateEquipment(int productID, String name, double purchasePrice, double salePrice, double rentPrice,
			String countryOfOrigin, int minStock, int maxStock, String type, String description) throws DataAccessException{
		prodDB.updateProduct(productID, name, purchasePrice, salePrice, rentPrice, countryOfOrigin, minStock, maxStock);
		eqDB.updateEquipment(productID, type, description);
	}
	
	public void updateGunReplica(int productID, String name, double purchasePrice, double salePrice, double rentPrice,
			String countryOfOrigin, int minStock, int maxStock, String calibre, String material) throws DataAccessException{
		prodDB.updateProduct(productID, name, purchasePrice, salePrice, rentPrice, countryOfOrigin, minStock, maxStock);
		grDB.updateGunReplica(productID, calibre, material);
	}
	
	//All the find methods for all the product types
	
	public Product findProductByProductID (int productID, boolean fullAssociation) throws DataAccessException {
		return prodDB.findByProductID(productID, fullAssociation);
	}
	
	public Clothing findClothingByID (int productID, boolean fullAssociation) throws DataAccessException {
		return clotDB.findClothingByProductID(productID, fullAssociation);
	}
	
	public Equipment findEquipmentByID (int productID, boolean fullAssociation) throws DataAccessException {
		return eqDB.findEquipmentByProductID(productID, fullAssociation);	
	}
	
	public GunReplica findGunReplicaByID (int productID, boolean fullAssociation) throws DataAccessException {
		return grDB.findGunReplicaByProductID(productID, fullAssociation);	
	}
	
	public Product findProductByID(String text) {
		// TODO Auto-generated method stub
		return null;
	}
	
	//All the delete methods for all the product types
	public Product deleteProduct(Product product) throws DataAccessException {
		prodDB.deleteProduct(product);
		return product;
	}
	
	public Clothing deleteClothing(Clothing clothing) throws DataAccessException {
		prodDB.deleteProduct(clothing);
		clotDB.deleteClothing(clothing);
		return clothing;
	}
	
	public Equipment deleteEquipment(Equipment equipment) throws DataAccessException {
		prodDB.deleteProduct(equipment);
		eqDB.deleteEquipment(equipment);
		return equipment;
	}
	
	public GunReplica deleteGunReplica(GunReplica gunReplica) throws DataAccessException {
		prodDB.deleteProduct(gunReplica);
		grDB.deleteGunReplica(gunReplica);
		return gunReplica;
	}
	
}

