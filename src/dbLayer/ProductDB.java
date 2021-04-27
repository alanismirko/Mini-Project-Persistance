package dbLayer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import controllerLayer.DataAccessException;
import dbLayer.DBConnection;
import modelLayer.*;

public class ProductDB implements ProductDBIF{	
	private static final String findAllQ =
			"select productID, name, purchasePrice, salePrice, rentPrice, countryOfOrigin, minStock, maxStock from Product";
	private static final String findByProductIDQ =
			findAllQ + " where id = ?";
	private static final String updateProductQ = 
			"update Product set name = ?, purchasePrice = ?, salePrice = ? , rentPrice = ?, countryOfOrigin = ? minStock = ? maxStock = ? where productID = ?";
	private static final String insertProductQ = 
			"insert into Product (productID, name, purchasePrice, salePrice, rentPrice, countryOfOrigin, minStock, maxStock) VALUES (?,?,?,?,?,?,?,?)";
	private static final String deleteProductQ = 
			"DELETE FROM Product WHERE productID = ?";
	private PreparedStatement findAll, findByProductID, updateProduct, insertProduct, deleteProduct;

	public ProductDB() throws DataAccessException {
		try {
			//findAll = DBConnection.getInstance().getConnection()
			//		.prepareStatement(findAllQ);
			findByProductID = DBConnection.getInstance().getConnection()
					.prepareStatement(findByProductIDQ);
			updateProduct = DBConnection.getInstance().getConnection()
					.prepareStatement(updateProductQ);
			insertProduct = DBConnection.getInstance().getConnection()
					.prepareStatement(insertProductQ);
			deleteProduct = DBConnection.getInstance().getConnection()
					.prepareStatement(deleteProductQ);
		} catch (SQLException e) {
			throw new DataAccessException("Could not prepare statement", e);
		}
	}

	@Override
	public Product findByProductID(int productID, boolean fullAssociation) throws DataAccessException {
		try {
			findByProductID.setInt(productID, 1);
			ResultSet rs = findByProductID.executeQuery();
			Product p = null;
			if(rs.next()) {
				p = buildObject(rs);
			}
		return p;
		} catch (SQLException e) {
			throw new DataAccessException("Could not find by id = " + productID, e);
		}
	}

	@Override
	public List<Product> findAll(boolean fullAssociation) throws DataAccessException {
		ResultSet rs;
		try {
			rs = findAll.executeQuery();
			List<Product> res = buildObjects(rs);
			return res;
		} catch (SQLException e) {
			throw new DataAccessException("Could not retrieve all persons", e);
		}
	}
	
	@Override
	public void updateProduct(int productID, String name, double purchasePrice, double salePrice, double rentPrice,
			String countryOfOrigin, int minStock, int maxStock) throws DataAccessException {
		try {
			updateProduct.setString(1, name);
			updateProduct.setDouble(2, purchasePrice);
			updateProduct.setDouble(3, salePrice);
			updateProduct.setDouble(4, rentPrice);
			updateProduct.setString(5, countryOfOrigin);
			updateProduct.setInt(6, minStock);
			updateProduct.setInt(7, maxStock);
			updateProduct.executeUpdate();
		} catch (SQLException e) {
			throw new DataAccessException("Could not update product where id = " + productID, e);
		}
		
	}
	
	private Product buildObject(ResultSet rs) throws SQLException {
		Product p = new Product(
				rs.getInt("productID"),
				rs.getString("name"),
				rs.getDouble("purchasePrice"),
				rs.getDouble("salePrice"),
				rs.getDouble("rentPrice"),
				rs.getString("countryOfOrigin"),
				rs.getInt("minStock"),
				rs.getInt("maxStock")
				);
		return p;
	}

	private List<Product> buildObjects(ResultSet rs) throws SQLException {
		List<Product> res = new ArrayList<>();
		while(rs.next()) {
			res.add(buildObject(rs));
		}
		return res;
	}

	public Product insertProduct(Product product) throws DataAccessException {
		try {
			insertProduct.setInt(1, product.getProductID());
			insertProduct.setString(2, product.getName());                
			insertProduct.setDouble(3, product.getPurchasePrice());      
			insertProduct.setDouble(4, product.getSalePrice());          
			insertProduct.setDouble(5, product.getRentPrice());
			insertProduct.setString(6, product.getCountryOfOrigin());
			insertProduct.setInt(7, product.getMinStock());
			insertProduct.setInt(8, product.getMaxStock());
		} catch (SQLException e) {
			throw new DataAccessException("Product could not be inserted into database.", e);
		}
		try {
			insertProduct.executeUpdate();
		} catch (SQLException e) {
			throw new DataAccessException("Product could not be inserted into database.", e);
		}

		return product;
	}
	
	public void deleteProduct(Product product) throws DataAccessException {
		try {
			deleteProduct.setInt(1, product.getProductID());
		} catch (SQLException e) {
			throw new DataAccessException("Product could not be deleted from the database.", e);
		}
		
		try {
			deleteProduct.executeUpdate();
		} catch (SQLException e) {
			throw new DataAccessException("Product could not be deleted from the database.", e);
		}
	}
	

	
}