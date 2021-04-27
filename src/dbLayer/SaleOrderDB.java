package dbLayer;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import controllerLayer.DataAccessException;
import modelLayer.SaleOrder;

public class SaleOrderDB implements SaleOrderDBIF {
	private static final String insertSaleOrderQ = 
			"insert into SaleOrder (date, amount, paymentDate) VALUES (?,?,?)";
	private PreparedStatement insertSaleOrder;
	
	public SaleOrderDB() throws DataAccessException {
		try {
			insertSaleOrder = DBConnection.getInstance().getConnection()
					.prepareStatement(insertSaleOrderQ);

		} catch (SQLException e) {
			throw new DataAccessException("Could not prepare statement", e);
		}
	}

	@Override
	public SaleOrder insertSaleOrder(SaleOrder so) throws DataAccessException{
		try {
			insertSaleOrder.setString(1, so.getDate());  
			insertSaleOrder.setDouble(2, so.getAmount());
			insertSaleOrder.setString(3, so.getPaymentDate());         

		} catch (SQLException e) {
			throw new DataAccessException("Sale order could not be inserted into database.", e);
		}
		try {
			insertSaleOrder.executeUpdate();
		} catch (SQLException e) {
			throw new DataAccessException("Sale order could not be inserted into database.", e);
		}
		return so;
	}
	
	
}
