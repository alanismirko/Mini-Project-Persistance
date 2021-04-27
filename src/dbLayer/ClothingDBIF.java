package dbLayer;

import java.util.List;

import controllerLayer.DataAccessException;
import modelLayer.Clothing;

public interface ClothingDBIF {
	void updateClothing (int productID,  String size, String color) throws DataAccessException;
	Clothing insertClothing (Clothing clothing) throws DataAccessException;
	Clothing findClothingByProductID(int productID,  boolean fullAssociation) throws DataAccessException;
	List<Clothing> findAll(boolean fullAssociation) throws DataAccessException;
	void deleteClothing(Clothing clothing) throws DataAccessException;
}
