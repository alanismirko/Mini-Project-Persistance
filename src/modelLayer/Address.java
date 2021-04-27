package modelLayer;

public class Address {
	private String county;
	private String city;
	private String zipCode;
	private String street;
	private String strNo;
	
	public Address(String county, String city, String zipCode, String street, String strNo) {
		super();
		this.county = county;
		this.city = city;
		this.zipCode = zipCode;
		this.street = street;
		this.strNo = strNo;
	}

	public String getCounty() {
		return county;
	}

	public void setCounty(String county) {
		this.county = county;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getStrNo() {
		return strNo;
	}

	public void setStrNo(String strNo) {
		this.strNo = strNo;
	}

	@Override
	public String toString() {
		return "Address [county=" + county + ", city=" + city + ", zipCode=" + zipCode + ", street=" + street
				+ ", strNo=" + strNo + "]";
	}
	
	
}
