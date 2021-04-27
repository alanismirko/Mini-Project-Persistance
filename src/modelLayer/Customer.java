package modelLayer;

public class Customer {
	//static int customersCreated = 0;
	private int customerID;
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String contactInfo;
	
	public Customer(String firstName, String lastName, String phoneNumber, String contactInfo) {
		//customersCreated++;
		//customerID = customersCreated;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.contactInfo = contactInfo;
	}




	public int getCustomerID() {
		return customerID;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getContactInfo() {
		return contactInfo;
	}

	public void setContactInfo(String contactInfo) {
		this.contactInfo = contactInfo;
	}

	@Override
	public String toString() {
		return "Customer [customerID=" + customerID + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", phoneNumber=" + phoneNumber + ", contactInfo=" + contactInfo + "]";
	}
	
	//@Override
	//public String toString() {
	//	return ("ID: " + customerID 
	//			+ ", name: " + firstName + " " + lastName
	//			+ ", phone number: " + phoneNumber
	//			+ ", contact info: " + contactInfo);
	//}
	
}
