//Michael Wu (mvw5mf)
//Matthew Guyer (msg5as)

import java.util.ArrayList;

public class Student {

	private String name;
	private double gpa;
	private ArrayList<Course> courses =  new ArrayList<>();
	

	public Student(String aName) 
	{
		name = aName;
		this.gpa = 0.0;
	}
	public Student(String aName, double gpa){
		this.name = aName;
		this.gpa = gpa;
	}

	public String getName() {
		return name;
	}


	public double getGpa() {
		return gpa;
	}
	
	public ArrayList<Course> getCourse(){
		return courses;
	}

	public void setGpa(double gpa) {
		if(gpa <= 4.0 && gpa >= 0){
			this.gpa = gpa;}
		else{
			System.out.println("Tha at is not a valid gpa");
		}
	}
	
	public boolean add(Course aCourse){//true if you add a course that is not existant
		if (courses.contains(aCourse)){
			return false;
		}
		else {
			courses.add(aCourse);
			return true;
		}
	}
	public boolean drop(Course aCourse) {
		if (courses.contains(aCourse)){
			courses.remove(aCourse);
			return true;
		}
		else{
			return false;
		}
	}
	
	public void dropAll(){
		courses.removeAll(courses);
	}
	
	

	public static void main(String[] args) {
		Student s1 = new Student("bob");
		System.out.println(s1 + " " + s1.getGpa());	
		Student s1Twin = new Student("bob");
		Student notS1 = new Student("joe");
		
		System.out.println(s1.equals(s1Twin));//true
		System.out.println(s1.equals(notS1));//false
		System.out.println(s1.equals(s1));//true
		System.out.println(s1.equals("hello"));//false
		
		Course c2 = new Course("mse2090", "MSE");
		c2.add(s1);
		System.out.println(c2);
		
		s1.setGpa(3.0);
		System.out.println(c2);
		
		System.out.println(s1.getGpa());
		System.out.println(s1.getName());
	}
	
	// Without this method written correctly, Course.inClass() won't work!
	// Pages 153-154 in the MSD book says a bit about writing equals().
	public boolean equals(Object s2) {
		if ( s2 instanceof Student ) {
			Student s = (Student) s2;
			return s.getName().equals( this.name );		
		}
		else {
			return false;
		}
	}


	@Override
	public String toString() {
		return "(" + name + "," + getGpa() + ")";
	}

}
