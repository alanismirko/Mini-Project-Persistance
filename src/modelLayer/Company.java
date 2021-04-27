package modelLayer;

public class Company extends Customer {
	
	private String CVRno;
	private String companyName;
	
	public Company(String firstName, String lastName, String phoneNumber, String contactInfo, String CVRno, String companyName) {
		super(firstName, lastName, phoneNumber, contactInfo);
		this.CVRno = CVRno;
		this.companyName = companyName;
	}

	public String getCVRno() {
		return CVRno;
	}

	public void setCVRno(String cVRno) {
		CVRno = cVRno;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	@Override
	public String toString() {
		return "Company [CVRno=" + CVRno + ", companyName=" + companyName + ", toString()=" + super.toString() + "]";
	}
	
}