package dbLayer;

import java.util.List;

import controllerLayer.DataAccessException;
import modelLayer.*;

public interface ProductDBIF {
	Product findByProductID(int productID, boolean fullAssociation) throws DataAccessException;
	void updateProduct(int productID, String name, double purchasePrice, double salePrice, double rentPrice,
			String countryOfOrigin, int minStock, int maxStock) throws DataAccessException;
	List<Product> findAll(boolean fullAssociation) throws DataAccessException;
	Product insertProduct(Product product) throws DataAccessException;
	void deleteProduct(Product product) throws DataAccessException;
	
}
