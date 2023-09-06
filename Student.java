
public class Student {
	//fields for Student Class
	private String name;
	private String address;
	private double GPA;
	
	//Student class constructor
	public Student(String name, String address, double GPA) {
		this.name = name;
		this.address = address;
		this.GPA = GPA;
	}
	
	//methods to get name, address, and GPA
	public String getName() {
		return name;
	}
	public String getAddress() {
		return address;
	}
	public double getGPA() {
		return GPA;
	}
}
