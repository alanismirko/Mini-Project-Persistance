package dbLayer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import controllerLayer.DataAccessException;
import modelLayer.Clothing;
import modelLayer.Product;

public class ClothingDB implements ClothingDBIF {
	private static final String findAllClothingQ =
			"select productID, name, purchasePrice, salePrice, rentPrice, countryOfOrigin, minStock, maxStock from Product";
	private static final String findClothingByProductIDQ =
			findAllClothingQ + " where id = ?";
	private static final String insertClothingQ = 
			"insert into Clothing (productID, size, color)";
	private static final String updateClothingQ = 
			"update Clothing set size=? color=? where productID = ?";
	private static final String deleteClothingQ = 
			"DELETE FROM Clothing WHERE productID = ?";
	private PreparedStatement insertClothing, updateClothing, findClothingByProductID, findAllClothing, deleteClothing;

	private ProductDBIF prodDB ;
	public ClothingDB() throws DataAccessException {
		prodDB = new ProductDB();
		try {
			updateClothing = DBConnection.getInstance().getConnection()
					.prepareStatement(updateClothingQ);
			insertClothing = DBConnection.getInstance().getConnection()
					.prepareStatement(insertClothingQ);
			findClothingByProductID = DBConnection.getInstance().getConnection()
					.prepareStatement(findClothingByProductIDQ);
			findAllClothing = DBConnection.getInstance().getConnection()
					.prepareStatement(findAllClothingQ);
			deleteClothing = DBConnection.getInstance().getConnection()
					.prepareStatement(deleteClothingQ);
		} catch (SQLException e) {
			throw new DataAccessException("Could not prepare statement", e);
		}
	}
	
	@Override
	public void updateClothing(int productID, String size, String color) throws DataAccessException {
		try {
			updateClothing.setString(2, size);
			updateClothing.setString(3, color);
			updateClothing.executeUpdate();
		} catch (SQLException e) {
			throw new DataAccessException("Could not update clothing where id = " + productID, e);
		}
	}
	
	@Override
	public Clothing insertClothing(Clothing clothing) throws DataAccessException {
		try {
			insertClothing.setInt(1, clothing.getProductID());
			insertClothing.setString(2, clothing.getSize());
			insertClothing.setString(3, clothing.getColor());
		} catch (SQLException e) {
			throw new DataAccessException("Could not insert clothing into database", e);
		}
		try {
			insertClothing.executeUpdate();
		} catch (SQLException e) {
			throw new DataAccessException("Could not insert clothing into database", e);
		}

		return clothing;
	}
	
	//find clothing by id

	@Override
	public Clothing findClothingByProductID(int productID, boolean fullAssociation) throws DataAccessException {
		try {
			findClothingByProductID.setInt(1, productID);
			ResultSet rs = findClothingByProductID.executeQuery();
			ResultSet rss = (ResultSet) prodDB.findByProductID(productID, fullAssociation);
			Clothing c = null;
			if(rs.next() && rss.next()) {
				c = buildObject(rs, rss);
			}
		return c;
		} catch (SQLException e) {
			throw new DataAccessException("Could not find by id = " + productID, e);
		}
	}
	
	private Clothing buildObject(ResultSet rsClotT, ResultSet rsProdT) throws SQLException {
		Clothing c = new Clothing(
				rsProdT.getInt("productID"),
				rsProdT.getString("name"),
				rsProdT.getDouble("purchasePrice"),
				rsProdT.getDouble("salePrice"),
				rsProdT.getDouble("rentPrice"),
				rsProdT.getString("countryOfOrigin"),
				rsProdT.getInt("minStock"),
				rsProdT.getInt("maxStock"),
				rsClotT.getString("size"),
				rsClotT.getString("color")
				);
		return c;
	}
	
	//find list of all clothing ... TODO
	@Override
	public List<Clothing> findAll(boolean fullAssociation) throws DataAccessException {
		return null;
	}
	
	private List<Product> buildObjects(ResultSet rsClotT) throws SQLException {
		List<Product> res = new ArrayList<>();
		while(rsClotT.next()) {
			res.add(buildObject(rsClotT, null));				//to be built.
		}
		return res;
	}
	
	@Override
	public void deleteClothing(Clothing clothing) throws DataAccessException {
		try {
			deleteClothing.setInt(1, clothing.getProductID());
		} catch (SQLException e) {
			throw new DataAccessException("Product could not be deleted from the database.", e);
		}
		
		try {
			deleteClothing.executeUpdate();
		} catch (SQLException e) {
			throw new DataAccessException("Product could not be deleted from the database.", e);
		}
	}
	
}
