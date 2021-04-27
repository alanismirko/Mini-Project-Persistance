package dbLayer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import controllerLayer.DataAccessException;
import modelLayer.Clothing;
import modelLayer.Equipment;
import modelLayer.GunReplica;

public class EquipmentDB implements EquipmentDBIF {
	private static final String insertEquipmentQ = 
			"insert into Equipment (productID, type, description)";
	private static final String updateEquipmentQ = 
			"update Equipment set type=? description=? where productID = ?";
	private static final String deleteEquipmentQ = 
			"DELETE FROM Clothing WHERE productID = ?";
	private PreparedStatement updateEquipment, insertEquipment, deleteEquipment, findEquipmentByProductID;

	private ProductDB prodDB;
	
	public EquipmentDB() throws DataAccessException {
		try {
			prodDB = new ProductDB();
			updateEquipment = DBConnection.getInstance().getConnection()
					.prepareStatement(updateEquipmentQ);
			insertEquipment = DBConnection.getInstance().getConnection()
					.prepareStatement(insertEquipmentQ);
			deleteEquipment = DBConnection.getInstance().getConnection()
					.prepareStatement(deleteEquipmentQ);
		} catch (SQLException e) {
			throw new DataAccessException("Could not prepare statement", e);
		}
	}
	
	@Override
	public void updateEquipment(int productID, String type, String description) throws DataAccessException {
		try {
			updateEquipment.setString(2, type);
			updateEquipment.setString(3, description);
			updateEquipment.executeUpdate();
		} catch (SQLException e) {
			throw new DataAccessException("Could not update equipment where id = " + productID, e);
		}
	}
	
	@Override
	public Equipment insertEquipment(Equipment equipment) throws DataAccessException {
		try {
			insertEquipment.setInt(1, equipment.getProductID());
			insertEquipment.setString(2, equipment.getType());
			insertEquipment.setString(3, equipment.getDescription());
		} catch (SQLException e) {
			throw new DataAccessException("Could not insert equipment into database", e);
		}
		try {
			insertEquipment.executeUpdate();
		} catch (SQLException e) {
			throw new DataAccessException("Could not insert equipment into database", e);
		}

		return equipment;
	}
	
	@Override
	public Equipment findEquipmentByProductID(int productID, boolean fullAssociation) throws DataAccessException {
		try {
			findEquipmentByProductID.setInt(1, productID);
			ResultSet rs = findEquipmentByProductID.executeQuery();
			ResultSet rss = (ResultSet) prodDB.findByProductID(productID, fullAssociation);
			Equipment eq = null;
			if(rs.next() && rss.next()) {
				eq = buildObject(rs, rss);
			}
		return eq;
		} catch (SQLException e) {
			throw new DataAccessException("Could not find by id = " + productID, e);
		}
	}
	
	private Equipment buildObject(ResultSet rsEQT, ResultSet rsProdT) throws SQLException {
		Equipment eq = new Equipment(
				rsProdT.getInt("productID"),
				rsProdT.getString("name"),
				rsProdT.getDouble("purchasePrice"),
				rsProdT.getDouble("salePrice"),
				rsProdT.getDouble("rentPrice"),
				rsProdT.getString("countryOfOrigin"),
				rsProdT.getInt("minStock"),
				rsProdT.getInt("maxStock"),
				rsEQT.getString("type"),
				rsEQT.getString("description")
				);
		return eq;
	}
	
	@Override
	public void deleteEquipment(Equipment equipment) throws DataAccessException {
		try {
			deleteEquipment.setInt(1, equipment.getProductID());
		} catch (SQLException e) {
			throw new DataAccessException("Product could not be deleted from the database.", e);
		}
		
		try {
			deleteEquipment.executeUpdate();
		} catch (SQLException e) {
			throw new DataAccessException("Product could not be deleted from the database.", e);
		}
	}
	
}
