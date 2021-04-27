package modelLayer;

public class PrivateCustomer extends Customer {

	public PrivateCustomer(String firstName, String lastName, String phoneNumber, String contactInfo) {
		super(firstName, lastName, phoneNumber, contactInfo);
	}

	@Override
	public String toString() {
		return "PrivateCustomer [toString()=" + super.toString() + "]";
	}

}
