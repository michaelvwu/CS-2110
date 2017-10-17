
public class Student extends Person
{
	public String campusAddress; 
	public double gpa;

	public Student(String name, String homeAddress, String campusAddress)
	{
		super(name, homeAddress);
		this.campusAddress = campusAddress; 
		this.gpa = 0.0;
		
	}
	
	@Override
	public String toString() {
		return "{Person: name=" + name + ", homeAddress=" + homeAddress + ", campusAddress=" + campusAddress + ", gpa=" + this.gpa + "}";
	}
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub

	}

}
