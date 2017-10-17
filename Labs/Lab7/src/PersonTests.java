import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;

import org.junit.Test;


public class PersonTests {

	@Test
	public void testPersonOnly() {
		Person p1 = new Person("Jane", "100 Main St, Somewhere");
		Person p2 = new Person("Raul", "27 Elm St, Elsewhere");
		
		assertEquals("toString", "{Person: name=Jane, homeAddress=100 Main St, Somewhere|", p1.toString());
		assertEquals("toString", "{Person: name=Raul, homeAddress=27 Elm St, Elsewhere|", p2.toString());
	}
	@Test
	public void testPersonEmployee() {
		ArrayList<Person> list = new ArrayList<Person>();
		Person p = new Person("Mai", "3156 Grove Rd, Somewhere");
		list.add(p);
		p = new Employee("Don", "6562 Trask Way, Elsewhere", "Front Desk", 2110);
		list.add(p);
		
		assertEquals("toString", "{Person: name=Mai, homeAddress=3156 Grove Rd, Somewhere|", list.get(0).toString());
		assertEquals("toString", "{Empl: n=Don, ha=6562 Trask Way, Elsewhere, wa=Front Desk, id=2110}", list.get(1).toString());
	}
	@Test
	public void testPersonEmployeeStudent() {
		ArrayList<Person> list = new ArrayList<Person>();
		Person p = new Person("Mai", "3156 Grove Rd, Somewhere");
		list.add(p);
		p = new Employee("Don", "6562 Trask Way, Elsewhere", "Front Desk", 2110);
		list.add(p);
		// TODO: uncomment the following
		p = new Student("Dana Wahoo", "21 Wahoo Ave, NOVA", "1 JPA, CVille, VA");
		list.add(p);
		
		assertEquals("toString", "{Person: name=Mai, homeAddress=3156 Grove Rd, Somewhere|", list.get(0).toString());
		assertEquals("toString", "{Empl: n=Don, ha=6562 Trask Way, Elsewhere, wa=Front Desk, id=2110}", list.get(1).toString());
		//fail("Implement student and fix the junit to test it.");
		assertEquals("toString", "{Person: name=Dana Wahoo, homeAddress=21 Wahoo Ave, NOVA, campusAddress=1 JPA, CVille, VA, gpa=0.0}", list.get(2).toString()); // TODO: finish this
		
		for(Object o: list)
		{
			assertTrue(o instanceof Person);
		}
		
		for(Object o: list)
		{
			assertTrue(o instanceof Comparable);
		}
	}
	
	@Test
	public void testPersonNames() {
		ArrayList<Person> list = new ArrayList<Person>();
		Person p1 = new Person("Jane", "100 Main St, Somewhere");
		list.add(p1);
		Person p2 = new Person("Raul", "27 Elm St, Elsewhere");
		list.add(p2);
		Person p3 = new Person("Jorge", "123 Help St, Nowhere");
		list.add(p3);
		Collections.sort(list);
		
		assertEquals("[{Person: name=Jane, homeAddress=100 Main St, Somewhere|, {Person: name=Jorge, homeAddress=123 Help St, Nowhere|, {Person: name=Raul, homeAddress=27 Elm St, Elsewhere|]", list.toString());
		
		
	}
	
	@Test
	
	public void testCmpAddress()
	{
		ArrayList<Person> list = new ArrayList<Person>();
		Person p1 = new Person("Jane", "100 Main St, Somewhere");
		list.add(p1);
		Person p2 = new Person("Raul", "27 Elm St, Elsewhere");
		list.add(p2);
		Person p3 = new Person("Jorge", "123 Help St, Nowhere");
		list.add(p3);
		Collections.sort(list, new CmpByAddress());
		
		assertEquals("[{Person: name=Jane, homeAddress=100 Main St, Somewhere|, {Person: name=Jorge, homeAddress=123 Help St, Nowhere|, {Person: name=Raul, homeAddress=27 Elm St, Elsewhere|]", list.toString());
		
		
	}
	

}
