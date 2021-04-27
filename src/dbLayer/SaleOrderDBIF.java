package dbLayer;

import controllerLayer.DataAccessException;
import modelLayer.SaleOrder;

public interface SaleOrderDBIF {
	SaleOrder insertSaleOrder(SaleOrder so) throws DataAccessException;
}
