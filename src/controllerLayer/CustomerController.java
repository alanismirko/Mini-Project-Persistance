package controllerLayer;
import dbLayer.CustomerDB;
import dbLayer.CustomerDBIF;
import modelLayer.*;

public class CustomerController {
	private CustomerDBIF cusDB;
	
	public CustomerController() throws DataAccessException {
		cusDB = new CustomerDB();
	}
	
	//create company and private customer
	public Customer insert (Customer customer)throws DataAccessException {
		cusDB.insert(customer);
		return customer;
	}
	
	public  Customer insertPrivateCustomer(PrivateCustomer privateCustomer) throws DataAccessException {
		cusDB.insertPrivateCustomer(privateCustomer);
		return privateCustomer;
	}
	
	public Customer insertCompany(Company company) throws DataAccessException {
		cusDB.insertCompany(company);
		return company;
	}
	
	//update company and private customer
	public void updatePrivateCustomer(int customerID, String firstName, String lastName, String phoneNumber, String contactInfo) throws DataAccessException{
		cusDB.updatePrivateCustomer(customerID);
	}
	
	public void updateCompany(int customerID, String firstName, String lastName, String phoneNumber, String contactInfo, String CVRno, String companyName) throws DataAccessException{
		cusDB.updateCompany(customerID,CVRno,companyName);
	}
	
	//find by customer ID
	public Customer findByCustomerID (int customerID, boolean fullAssociation) throws DataAccessException {
		return cusDB.findByCustomerID(customerID, fullAssociation);
	}
	
	//find by customer fistName
	public Customer findByCustomerName (String firstName, boolean fullAssociation) throws DataAccessException {
		return cusDB.findCustomerByName(firstName, fullAssociation);
	}
	
	//delete
	public Customer deletePrivateCustomer(Customer customer) throws DataAccessException {
		cusDB.deletePrivateCustomer(customer);
		return customer;
	}
	
	public Customer deleteCompany(Company company) throws DataAccessException {
		cusDB.deleteCompany(company);
		return company;
	}
	
	
}
