package dbLayer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import controllerLayer.DataAccessException;
import modelLayer.GunReplica;

public class GunReplicaDB implements GunReplicaDBIF {
	private static final String insertGunReplicaQ = 
			"insert into GunReplica (productID, calibre, material)";
	private static final String updateGunReplicaQ = 
			"update GunReplica set calibre=? material=? where productID = ?";
	private static final String deleteGunReplicaQ = 
			"DELETE FROM GunReplica WHERE productID = ?";
	private PreparedStatement insertGunReplica, updateGunReplica, findGunReplicaByProductID,  deleteGunReplica;
	
	private ProductDB prodDB;

	public GunReplicaDB() throws DataAccessException {
		prodDB = new ProductDB();
		try {
			updateGunReplica = DBConnection.getInstance().getConnection()
					.prepareStatement(updateGunReplicaQ);
			insertGunReplica = DBConnection.getInstance().getConnection()
					.prepareStatement(insertGunReplicaQ);
			deleteGunReplica = DBConnection.getInstance().getConnection()
					.prepareStatement(deleteGunReplicaQ);
		} catch (SQLException e) {
			throw new DataAccessException("Could not prepare statement", e);
		}
	}
	
	@Override
	public void updateGunReplica(int productID, String size, String color) throws DataAccessException {
		try {
			updateGunReplica.setString(2, size);
			updateGunReplica.setString(3, color);
			updateGunReplica.executeUpdate();
		} catch (SQLException e) {
			throw new DataAccessException("Could not update gun replica where id = " + productID, e);
		}
	}
	
	@Override
	public GunReplica insertGunReplica(GunReplica gunReplica) throws DataAccessException {
		try {
			insertGunReplica.setInt(1, gunReplica.getProductID());
			insertGunReplica.setString(2, gunReplica.getCalibre());
			insertGunReplica.setString(3, gunReplica.getMaterial());
		} catch (SQLException e) {
			throw new DataAccessException("Could not insert gun replica into database", e);
		}
		try {
			insertGunReplica.executeUpdate();
		} catch (SQLException e) {
			throw new DataAccessException("Could not insert gun replica into database", e);
		}

		return gunReplica;
	}
	
	@Override
	public GunReplica findGunReplicaByProductID(int productID, boolean fullAssociation) throws DataAccessException {
		try {
			findGunReplicaByProductID.setInt(1, productID);
			ResultSet rs = findGunReplicaByProductID.executeQuery();
			ResultSet rss = (ResultSet) prodDB.findByProductID(productID, fullAssociation);
			GunReplica gr = null;
			if(rs.next() && rss.next()) {
				gr = buildObject(rs, rss);
			}
		return gr;
		} catch (SQLException e) {
			throw new DataAccessException("Could not find by id = " + productID, e);
		}
	}
	
	private GunReplica buildObject(ResultSet rsGRT, ResultSet rsProdT) throws SQLException {
		GunReplica gr = new GunReplica(
				rsProdT.getInt("productID"),
				rsProdT.getString("name"),
				rsProdT.getDouble("purchasePrice"),
				rsProdT.getDouble("salePrice"),
				rsProdT.getDouble("rentPrice"),
				rsProdT.getString("countryOfOrigin"),
				rsProdT.getInt("minStock"),
				rsProdT.getInt("maxStock"),
				rsGRT.getString("calibre"),
				rsGRT.getString("material")
				);
		return gr;
	}
	
	@Override
	public void deleteGunReplica(GunReplica gunReplica) throws DataAccessException {
		try {
			deleteGunReplica.setInt(1, gunReplica.getProductID());
		} catch (SQLException e) {
			throw new DataAccessException("Product could not be deleted from the database.", e);
		}
		
		try {
			deleteGunReplica.executeUpdate();
		} catch (SQLException e) {
			throw new DataAccessException("Product could not be deleted from the database.", e);
		}
	}
	
}

