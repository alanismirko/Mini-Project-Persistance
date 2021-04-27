package dbLayer;

import controllerLayer.DataAccessException;
import modelLayer.SaleOrderLine;

public interface SaleOrderLineDBIF {
	SaleOrderLine insertSaleOrderLine(SaleOrderLine sol) throws DataAccessException;

}
