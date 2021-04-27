package controllerLayer;
import java.util.ArrayList;

import dbLayer.SaleOrderDB;
import dbLayer.SaleOrderDBIF;
import dbLayer.SaleOrderLineDB;
import dbLayer.SaleOrderLineDBIF;
import modelLayer.*;

public class SaleOrderController {
	private SaleOrderDBIF soDB;
	private SaleOrderLineDBIF solDB;
	public SaleOrderController(SaleOrderDBIF soDB, SaleOrderLineDBIF solDB) throws DataAccessException {
		soDB = new SaleOrderDB();
		solDB = new SaleOrderLineDB();
	}
	
	//insert sale order method 
	public SaleOrder insertSaleOrder(SaleOrder so) throws DataAccessException {
		soDB.insertSaleOrder(so);
		for(SaleOrderLine sol:so.getOrderLines()) {
			insertSaleOrderLine(sol);
		}
		return so;
	}
	
	public SaleOrderLine insertSaleOrderLine(SaleOrderLine sol) throws DataAccessException {
		solDB.insertSaleOrderLine(sol);
		return sol;
	}
	
	public SaleOrder createSaleOrder(String date, double amount, String paymentDate) {
		SaleOrder so = new SaleOrder(date, amount, paymentDate);
		return so;
	}
	
	public SaleOrderLine createSaleOrderLine(SaleOrder saleOrder, Product product, int quantity) {
		SaleOrderLine sol = new SaleOrderLine(saleOrder.getSaleID(), product.getProductID(), quantity);
		return sol;
	}
	
}
