package modelLayer;

public class Supplier {
	private int UID;
	private String name;
	private String phoneNo;
	private String email;
	
	//constructor
	public Supplier(int ID, String name, String phoneNo, String email) {
		super();
		this.UID = ID;
		this.name = name;
		this.phoneNo = phoneNo;
		this.email = email;
	}

	//getters and setters - setUID excluded => UID must be unique
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getUID() {
		return UID;
	}

	//toString() method 
	@Override
	public String toString() {
		return "Supplier [UID=" + UID + ", name=" + name + ", phoneNo=" + phoneNo + ", email=" + email + "]";
	}
	
}
