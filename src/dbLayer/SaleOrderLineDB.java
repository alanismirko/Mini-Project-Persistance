package dbLayer;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import controllerLayer.DataAccessException;
import modelLayer.SaleOrderLine;

public class SaleOrderLineDB implements SaleOrderLineDBIF {
	private static final String insertSaleOrderLineQ = 
			"insert into SaleOrderLine (saleID, productID, quantity)";
	private PreparedStatement insertSaleOrderLine;
	
	public SaleOrderLineDB() throws DataAccessException {
		try {
			insertSaleOrderLine = DBConnection.getInstance().getConnection()
					.prepareStatement(insertSaleOrderLineQ);

		} catch (SQLException e) {
			throw new DataAccessException("Could not prepare statement", e);
		}
	}
	
	@Override
	public SaleOrderLine insertSaleOrderLine(SaleOrderLine sol) throws DataAccessException{
		try {
			insertSaleOrderLine.setInt(1, sol.getSaleID());
			insertSaleOrderLine.setInt(2, sol.getProductID());  
			insertSaleOrderLine.setDouble(3, sol.getQuantity());        

		} catch (SQLException e) {
			throw new DataAccessException("Sale order line could not be inserted into database.", e);
		}
		try {
			insertSaleOrderLine.executeUpdate();
		} catch (SQLException e) {
			throw new DataAccessException("Sale order line could not be inserted into database.", e);
		}
		return sol;
	}
}
