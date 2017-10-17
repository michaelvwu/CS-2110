//Michael Wu (mvw5mf)
//Matthew Guyer (msg5as)


import java.util.ArrayList;

public class Course {
	
	private String id;
	private String name; 
	private ArrayList<Student> roll = new ArrayList<>();

	public Course(String id, String name) {
		this.id = id;
		this.name = name;
		// IllegalArgumentException
	}

	public static void main(String[] args) 
	{
		Course c1 = new Course("cs2110", "CS");
		System.out.println(c1);
		Student s1 = new Student("bob");
		c1.add(s1);
		c1.add( new Student("ali") );
		c1.add( new Student("cat") );
		c1.add( new Student("don") );
		c1.add( new Student("tom") );
		
		System.out.println(c1);
		System.out.println(c1.getID());
		
		s1.setGpa(4.0);
		System.out.println(c1.averageGPA());
	}
	
	public String getID()
	{
		return this.id;
	}
	
	public String getName()
	{
		return this.name; 
	}
	
	public ArrayList<Student> roll()
	{
		return this.roll;
	}
	
	public boolean add(Student aStudent)
	{
		if (roll.contains(aStudent))
		{
			return false; 
		}
		else 
		{
			roll.add(aStudent);
			return true; 
		}
	}
	
	public boolean drop(Student aStudent)
	{
		if(roll.contains(aStudent))
		{
			roll.remove(aStudent);
			return true;
		}
		else 
			return false; 
	}
	
	public void cancel()
	{
		roll.removeAll(roll);
		
	}

	public double averageGPA()
	{
		if (roll.isEmpty())
			return -1.0;
		else
		{
			double sum = 0.0;
			for (Student name: roll)
			{
				sum += name.getGpa();
			}
			return (sum / roll.size());
		}
	}
		

	@Override
	public String toString() {
		return "<" + id + "," + name + "," + roll + ">";
	}

}
