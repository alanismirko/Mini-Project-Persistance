package dbLayer;

import controllerLayer.DataAccessException;
import modelLayer.Equipment;

public interface EquipmentDBIF {
	void updateEquipment (int productID,  String type, String description) throws DataAccessException;
	Equipment insertEquipment (Equipment equipment) throws DataAccessException;
	void deleteEquipment(Equipment equipment) throws DataAccessException;
	Equipment findEquipmentByProductID(int productID, boolean fullAssociation) throws DataAccessException;

}
