package dbLayer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import controllerLayer.DataAccessException;
import modelLayer.Company;
import modelLayer.Customer;
import modelLayer.PrivateCustomer;

public class CustomerDB implements CustomerDBIF {
	private static final String findAllQ =
			"select customerID, firstName, lastName, phoneNo, contactInfo FROM Customer";
	private static final String findByCustomerIDQ =
			findAllQ + " where customerID = ?";
	private static final String findCustomerByNameQ =
			findAllQ + " where firstName = '?'";
	private static final String updateQ = 
			"update Customer set firstName = ?, lastName = ?, phoneNo = ?, contactInfo = ? where customerID = ?";
	private static final String updateCompanyQ =
			"update Customer set firstName = ?, lastName = ?, companyName = ?, phoneNo = ?, contactInfo = ?, CVRno = ? WHERE customerID = ?";
	private static final String updatePrivateCustomerQ=
			"update Customer set firstName, lastName, phoneNo, contactInfo = ? where customerID = ?";
	private static final String insertQ = 
			"insert into Customer (firstName, lastName, phoneNo, contactInfo) VALUES (?,?,?,?) " ;
	private static final String insertPrivateCustomerQ=
			"insert into Customer (type, firstName, lastName, phoneNo, contactInfo) VALUES ('private',?,?,?,?)";
	private static final String insertCompanyQ=
			"insert into Customer (type, firstName, lastName, companyName, phoneNo, contactInfo, CVRno) VALUES ('company',?,?,?,?,?,?)";
	private static final String deleteQ = 
			"DELETE FROM Customer WHERE customerID = ?";
	private static final String deletePrivateCustomerQ=
			"DELETE FROM Customer WHERE customerID = ?";
	private static final String deleteCompanyQ=
			"DELETE FROM Customer WHERE customerID = ?";
	
	
	private PreparedStatement findAll, findByCustomerID, update, insert, delete, findCustomerByName,
	updatePrivateCustomer, updateCompany, insertPrivateCustomer, insertCompany, deletePrivateCustomer, deleteCompany;
	
	
	public CustomerDB() throws DataAccessException {
		try {
			findAll = DBConnection.getInstance().getConnection()
					.prepareStatement(findAllQ);
			findByCustomerID = DBConnection.getInstance().getConnection()
					.prepareStatement(findByCustomerIDQ);
			findCustomerByName = DBConnection.getInstance().getConnection()
					.prepareStatement(findCustomerByNameQ);
			update = DBConnection.getInstance().getConnection()
					.prepareStatement(updateQ);
			updateCompany = DBConnection.getInstance().getConnection()
					.prepareStatement(updateCompanyQ);
			updatePrivateCustomer = DBConnection.getInstance().getConnection()
					.prepareStatement(updatePrivateCustomerQ);
			insert = DBConnection.getInstance().getConnection()
					.prepareStatement(insertQ);
			insertPrivateCustomer = DBConnection.getInstance().getConnection()
					.prepareStatement(insertPrivateCustomerQ);
			insertCompany = DBConnection.getInstance().getConnection()
					.prepareStatement(insertCompanyQ);
			delete = DBConnection.getInstance().getConnection()
					.prepareStatement(deleteQ);
			deletePrivateCustomer = DBConnection.getInstance().getConnection()
					.prepareStatement(deletePrivateCustomerQ);
			deleteCompany = DBConnection.getInstance().getConnection()
					.prepareStatement(deleteCompanyQ);
		} catch (SQLException e) {
			throw new DataAccessException("Could not prepare statement", e);
		}
	}
	
	//find customer by customerID
	@Override
	public Customer findByCustomerID(int customerID, boolean fullAssociation) throws DataAccessException {
		try {
			findByCustomerID.setInt(customerID, 1);
			ResultSet rs = findByCustomerID.executeQuery();
			Customer c = null;
			if(rs.next()) {
				c = buildObject(rs);
			}
			findByCustomerID.executeQuery();
			return c;
		} catch (SQLException e) {
			throw new DataAccessException("Could not find by ID = " + customerID, e);
		}
	}
	
	//find customer by name
	@Override
	public Customer findCustomerByName(String firstName, boolean fullAssociation) throws DataAccessException {
		try {
			findCustomerByName.setString(1, firstName);
			ResultSet rs = findCustomerByName.executeQuery();
			Customer c = null;
			if(rs.next()) {
				c = buildObject(rs);
			}
			return c;
		}catch (SQLException e) {
			throw new DataAccessException("Could not find by name = " + firstName, e);
		}
			
	}
	
	//find all customers	
	@Override
	public List<Customer> findAll(boolean fullAssociation) throws DataAccessException {
		ResultSet rs;
		try {
			rs = findAll.executeQuery();
			List<Customer> res = buildObjects(rs);
			return res;
		} catch (SQLException e) {
			throw new DataAccessException("Could not retrieve all customers", e);
		}
	}
	
	//update customer
	@Override
	public void update(int customerID, String firstName, String lastName, String phoneNumber, String contactInfo) throws DataAccessException {
		try {
			update.setString(1, firstName);
			update.setString(2, lastName);
			update.setString(3, phoneNumber);
			update.setString(4, contactInfo);
			update.executeUpdate();
		} catch (SQLException e) {
			throw new DataAccessException("Could not update customer where ID = " + customerID, e);
		}
	}
	
	public void updatePrivateCustomer(int customerID) throws DataAccessException {
		try {
			updatePrivateCustomer.executeUpdate();
		} catch (SQLException e) {
			throw new DataAccessException("Could not update private customer where ID = " + customerID, e);
		}
	}
	
	public void updateCompany(int customerID, String CVRno, String companyName) throws DataAccessException {
		try {
			updateCompany.setString(1, CVRno);
			updateCompany.setString(2, companyName);
			updateCompany.executeUpdate();
		} catch (SQLException e) {
			throw new DataAccessException("Could not update company where ID = " + customerID, e);
		}
	}
	
	//insert new customer
	public Customer insert(Customer customer) throws DataAccessException {
		try {
			insert.setString(1, customer.getFirstName());                
			insert.setString(2, customer.getLastName());  
			insert.setString(3, customer.getPhoneNumber());           
			insert.setString(4, customer.getContactInfo());

		} catch (SQLException e) {
			throw new DataAccessException("Customer could not be inserted into database.", e);
		}
		try {
			insert.executeUpdate();

		} catch (SQLException e) {
			throw new DataAccessException("Customer could not be inserted into database.", e);
		}

		return customer;
	}
	
	//insert private customer
	public PrivateCustomer insertPrivateCustomer(PrivateCustomer privateCustomer) throws DataAccessException {
		try {
			System.out.println(privateCustomer.toString());
			insertPrivateCustomer.setString(1, privateCustomer.getFirstName());                
			insertPrivateCustomer.setString(2, privateCustomer.getLastName());  
			insertPrivateCustomer.setString(3, privateCustomer.getPhoneNumber());           
			insertPrivateCustomer.setString(4, privateCustomer.getContactInfo());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			insertPrivateCustomer.executeUpdate();
			DBConnection.getInstance().commitTransaction();
		} catch (SQLException e) {
			throw new DataAccessException("Customer could not be inserted into database.", e);
		}
		return privateCustomer;
	}
	
	//insert company
	public Company insertCompany(Company company) throws DataAccessException {
		try {
			insertCompany.setString(1, company.getFirstName());
			insertCompany.setString(2, company.getLastName());
			insertCompany.setString(3, company.getCompanyName());
			insertCompany.setString(4, company.getPhoneNumber());
			insertCompany.setString(5, company.getContactInfo());
			insertCompany.setString(6, company.getCVRno());

		} catch (SQLException e) {
			throw new DataAccessException("Could not insert company into database", e);
		}
		try {
			insertCompany.executeUpdate();
		} catch (SQLException e) {
			throw new DataAccessException("Could not insert company into database", e);
		}

		return company;
	}
	
	
	//delete a customer
	public void delete(Customer customer) throws DataAccessException {
		try {
			delete.setInt(1, customer.getCustomerID());
		} catch (SQLException e) {
			throw new DataAccessException("Customer could not be deleted from the database.", e);
		}
		
		try {
			delete.executeUpdate();
		} catch (SQLException e) {
			throw new DataAccessException("Customer could not be deleted from the database.", e);
		}
	}
	
	//delete private customer
	@Override
	public void deletePrivateCustomer(Customer Customer) throws DataAccessException {
		try {
			deletePrivateCustomer.setInt(1, Customer.getCustomerID());
		} catch (SQLException e) {
			throw new DataAccessException("Private customer could not be deleted from the database.", e);
		}
		
		try {
			deletePrivateCustomer.executeUpdate();
		} catch (SQLException e) {
			throw new DataAccessException("Private customer could not be deleted from the database.", e);
		}
	}
	
	//delete company
	@Override
	public void deleteCompany(Company company) throws DataAccessException {
		try {
			deleteCompany.setInt(1, company.getCustomerID());
		} catch (SQLException e) {
			throw new DataAccessException("Company could not be deleted from the database.", e);
		}
		
		try {
			deleteCompany.executeUpdate();
		} catch (SQLException e) {
			throw new DataAccessException("Company could not be deleted from the database.", e);
		}
	}
	
	//build object
	private Customer buildObject(ResultSet rs) throws SQLException {
		Customer c = new Customer(
				rs.getString("firstName"),
				rs.getString("lastName"),
				rs.getString("phoneNumber"),
				rs.getString("contactInfo")
				);
		return c;
	}
	
	private List<Customer> buildObjects(ResultSet rs) throws SQLException {
		List<Customer> res = new ArrayList<Customer>();
		while(rs.next()) {
			res.add(buildObject(rs));
		}
		return res;
	}


}
