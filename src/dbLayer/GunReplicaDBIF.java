package dbLayer;

import controllerLayer.DataAccessException;
import modelLayer.GunReplica;

public interface GunReplicaDBIF {
	void updateGunReplica (int productID, String calibre, String material) throws DataAccessException;
	GunReplica insertGunReplica (GunReplica gunReplica) throws DataAccessException;
	void deleteGunReplica (GunReplica gunReplica) throws DataAccessException;
	GunReplica findGunReplicaByProductID(int productID, boolean fullAssociation) throws DataAccessException;
}
