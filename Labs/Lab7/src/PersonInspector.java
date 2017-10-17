import java.util.ArrayList;
import java.util.Collections;

public class PersonInspector 
{
	public static ArrayList<String> classNames(ArrayList<Person> list)
	{
		ArrayList<String> names = new ArrayList<String>();
		
		for(Person p: list)
		{
			names.add(p.getName());
		}
		return names;
	}
	
	public static void main (String[]args)
	{
		ArrayList<Person> list = new ArrayList<Person>();
		Person p1 = new Person("Jane", "100 Main St, Somewhere");
		list.add(p1);
		Person p2 = new Person("Raul", "27 Elm St, Elsewhere");
		list.add(p2);
		Person p3 = new Person("Jorge", "123 Help St, Nowhere");
		list.add(p3);
		
		Person p = new Person("Mai", "3156 Grove Rd, Somewhere");
		list.add(p);
		p = new Employee("Don", "6562 Trask Way, Elsewhere", "Front Desk", 2110);
		list.add(p);
		
		p = new Student("Dana Wahoo", "21 Wahoo Ave, NOVA", "1 JPA, CVille, VA");
		list.add(p);
		
		System.out.println(classNames(list).toString());
	}

}
