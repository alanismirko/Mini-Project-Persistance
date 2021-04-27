package modelLayer;

import java.util.ArrayList;

public class SaleOrder {
	private int saleID;
	private String date;
	private double amount;
	private String paymentDate;
	private ArrayList<SaleOrderLine> orderLines;
	
	//sale with orderlines
	public SaleOrder(String date, double amount, String paymentDate, ArrayList<SaleOrderLine> orderLines) {
		super();
		this.date = date;
		this.amount = amount;
		this.paymentDate = paymentDate;
		this.orderLines = orderLines;
	}
	
	//*sale without orderlines
	public SaleOrder(String date, double amount, String paymentDate) {
		super();
		this.date = date;
		this.amount = amount;
		this.paymentDate = paymentDate;
	}



	public int getSaleID() {
		return saleID;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(String paymentDate) {
		this.paymentDate = paymentDate;
	}

	public ArrayList<SaleOrderLine> getOrderLines() {
		return orderLines;
	}

	public void setOrderLines(ArrayList<SaleOrderLine> orderLines) {
		this.orderLines = orderLines;
	}

	@Override
	public String toString() {
		return "SaleOrder [saleID=" + saleID + ", date=" + date + ", amount=" + amount + ", paymentDate=" + paymentDate
				+ ", orderLines=" + orderLines + "]";
	}
	
	
}
