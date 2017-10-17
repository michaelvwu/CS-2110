/* Michael Wu mvw5mf
 * Matt Guyer msg5as
 */

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class testPerson 
{
	
	//add book test cases 
	@Test(timeout = 100)
	public void testAddBook()
	{
		Person tester = new Person("George", 23452);
		Book bk1 = new Book ("Dictionary", "Webster");
		
		assertTrue(tester.addBook(bk1));
		
	}
	@Test(timeout = 100)
	public void testAddBook2()
	{
		Person tester = new Person("George", 23452);
		Book bk10 = new Book ("Dictionary", "Webster");
		tester.addBook(bk10);
		
		ArrayList<Book> readList = tester.getRead(); 
		assertTrue(readList.contains(bk10)); 
		
	}
	
	@Test(timeout = 100)
	public void testAddBook3()
	{
		Person tester = new Person("George", 23452);
		//Book bk1 = new Book ("Dictionary", "Webster");
		
		Book bk9 = new Book ("Declaration", "Thomas Jefferson");
		Book bk8 = new Book ("Games", "Genius");
		
		assertTrue(tester.addBook(bk8));
		assertTrue(tester.addBook(bk9));
		
	}
	
	@Test(timeout = 100)
	public void testAddBook4()
	{
		Person tester = new Person("George", 23452);
		Book bk1 = new Book ("Dictionary", "Webster");
		
		Book bk2 = new Book ("Dictionary", "Webster");
		
		ArrayList<Book> readList = tester.getRead();
		assertTrue(tester.addBook(bk1));
		assertFalse(tester.addBook(bk2));
		assertEquals(readList.size(), 1);
		assertTrue(readList.contains(bk2));
		
	}
		
	//forget book tests
	@Test(timeout = 100)
	public void testForgetBook()
	{
		Person tester = new Person("George", 23452);
		Book bk1 = new Book ("Dictionary", "Webster");
		tester.addBook(bk1);
		
		assertTrue(tester.forgetBook(bk1));
		
	}
	@Test(timeout = 100)
	public void testForgetBook2()
	{
		Person tester = new Person("George", 23452);
		Book bk10 = new Book ("Dictionary", "Webster");
		tester.addBook(bk10);
		tester.forgetBook(bk10);
		
		ArrayList<Book> readList = tester.getRead(); 
		assertFalse(readList.contains(bk10)); 
		
	}
	
	@Test(timeout = 100)
	public void testForgetBook3()
	{
		Person tester = new Person("George", 23452);
		//Book bk1 = new Book ("Dictionary", "Webster");
		
		Book bk9 = new Book ("Declaration", "Thomas Jefferson");
		Book bk8 = new Book ("Games", "Genius");
		
		assertTrue(tester.addBook(bk8));
		assertTrue(tester.addBook(bk9));
		assertTrue(tester.forgetBook(bk9));
		assertTrue(tester.forgetBook(bk8));
		
	}
	
	@Test(timeout = 100)
	public void testForgetBook4()
	{
		Person tester = new Person("George", 23452);
		Book bk1 = new Book ("Dictionary", "Webster");
		Book bk2 = new Book ("Dictionary", "Webster");
		
		ArrayList<Book> readList = tester.getRead();
		assertTrue(tester.addBook(bk1));
		assertFalse(tester.addBook(bk2));
		assertEquals(readList.size(), 1);
		assertTrue(tester.forgetBook(bk2));
		assertEquals(readList.size(), 0);
		
	}
	

}
