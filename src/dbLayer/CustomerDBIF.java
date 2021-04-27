package dbLayer;

import java.util.List;


import controllerLayer.DataAccessException;
import modelLayer.*;

public interface CustomerDBIF {
	Customer findByCustomerID(int customerID, boolean fullAssociation) throws DataAccessException;
	Customer findCustomerByName(String firstName,  boolean fullAssociation) throws DataAccessException;
	void update(int customerID, String firstName, String lastName, String phoneNumber, String contactInfo) throws DataAccessException;
	void updatePrivateCustomer (int customerID) throws DataAccessException;
	void updateCompany (int customerID,  String CVRno, String companyName) throws DataAccessException;
	List<Customer> findAll(boolean fullAssociation) throws DataAccessException;
	Customer insert(Customer customer) throws DataAccessException;
	PrivateCustomer insertPrivateCustomer (PrivateCustomer privateCustomer) throws DataAccessException;
	Company insertCompany (Company company) throws DataAccessException;
	void delete(Customer customer) throws DataAccessException;
	void deletePrivateCustomer(Customer customer) throws DataAccessException;
	void deleteCompany(Company company) throws DataAccessException;
}
