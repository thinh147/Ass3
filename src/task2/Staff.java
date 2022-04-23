package task2;

public class Staff {
	private String id;
	private String fullName;
	private String address;
	private Date dateOfBirth;
	private double salary;
	
	public Staff(String id, String fullName, String address, Date dateOfBirth, double salary) {
		super();
		this.id = id;
		this.fullName = fullName;
		this.address = address;
		this.dateOfBirth = dateOfBirth;
		this.salary = salary;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return String.format("%-10s | %-20s | %-20s | %d-%d-%4d | %-20.1f", id,fullName, address, dateOfBirth.getDay(), dateOfBirth.getMonth(), dateOfBirth.getYear(), salary);
	}
	
}
