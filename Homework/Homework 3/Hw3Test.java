import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

/* Michael Wu
 * mvw5mf
 */

public class Hw3Test 
{	
	@Test
	public void testCheckNumCopies() 
	{		
		
		Library one = new Library("One Test");
		
		ArrayList<Book> books = new ArrayList<Book>();
		
		Book bk1 = new Book ("Dictionary", "Webster", 1990, 250.45);
		Book bk2 = new Book ("Dictionary", "Webster", 1991, 250.45);
		Book bk3 = new Book ("Harry Potter", "Rowling", 2012, 52.99);
		
		
		books.add(bk1);
		books.add(bk2);
		books.add(bk2);
		books.add(bk1);
		books.add(bk3);
		
		one.setLibraryBooks(books);
		assertEquals(one.checkNumCopies("Dictionary", "Webster"), 4);
	}

	@Test
	public void testCheckNumCopies2() 
	{
		Library two = new Library("Two Test");
		
		ArrayList<Book> books2 = new ArrayList<Book>();
		
		Book bk1 = new Book ("Dictionary", "Webster", 1990, 250.45);
		Book bk2 = new Book ("Dictionary", "Webster", 1991, 250.45);
		Book bk3 = new Book ("Harry Potter", "Rowling", 2012, 52.99);
		Book bk4 = new Book ("Huckleberry Fin", "Mark Twain", 1955, 20.99);
		Book bk5 = new Book ("Moby Dick", "Herman Melville", 1857, 69.99);
		Book bk6 = new Book ("Declaration", "Thomas Jefferson", 1776, 5000.00);
		Book bk7 = new Book ("Chickens", "Game", 2015, 2.00);
		Book bk8 = new Book ("Games", "Genius", 2000, 2.99);
		Book bk9 = new Book ("Microsoft", "Bill Gates", 1983, 29.99);
		
		
		books2.add(bk5);
		books2.add(bk6);
		books2.add(bk7);
		books2.add(bk8);
		books2.add(bk9);
		
		two.setLibraryBooks(books2);
		assertEquals(two.checkNumCopies("Games", "Genius"), 1);
	}
	
	@Test
	public void testTotalNumBooks() 
	{
		Library one = new Library("One Test");
		//Library two = new Library("Two Test");
		
		ArrayList<Book> books = new ArrayList<Book>();
		ArrayList<Book> books2 = new ArrayList<Book>();
		
		Person George = new Person("George", "529 Watson Webb", 9);
//		Person Bill = new Person("Bill", "123 East St", 20);
//		Person Ham = new Person("Ham", "420 Help me", 15);
		
		Book bk1 = new Book ("Dictionary", "Webster", 1990, 250.45);
		Book bk2 = new Book ("Dictionary", "Webster", 1991, 250.45);
		Book bk3 = new Book ("Harry Potter", "Rowling", 2012, 52.99);
		Book bk4 = new Book ("Huckleberry Fin", "Mark Twain", 1955, 20.99);
		Book bk5 = new Book ("Moby Dick", "Herman Melville", 1857, 69.99);
		Book bk6 = new Book ("Declaration", "Thomas Jefferson", 1776, 5000.00);
		Book bk7 = new Book ("Chickens", "Game", 2015, 2.00);
		Book bk8 = new Book ("Games", "Genius", 2000, 2.99);
		Book bk9 = new Book ("Microsoft", "Bill Gates", 1983, 29.99);
		
		books.add(bk1);
		books.add(bk2);
		books.add(bk3);
		books.add(bk4);
		books2.add(bk5);
		books2.add(bk6);
		books2.add(bk7);
		books2.add(bk8);
		books2.add(bk9);
		
		one.setLibraryBooks(books);
		assertEquals(one.totalNumBooks(), 4);
	}
	
	@Test
	public void testTotalNumBooks2() 
	{
		//Library one = new Library("One Test");
		Library two = new Library("Two Test");
		
		ArrayList<Book> books = new ArrayList<Book>();
		ArrayList<Book> books2 = new ArrayList<Book>();
		
		Book bk1 = new Book ("Dictionary", "Webster", 1990, 250.45);
		Book bk2 = new Book ("Dictionary", "Webster", 1991, 250.45);
		Book bk3 = new Book ("Harry Potter", "Rowling", 2012, 52.99);
		Book bk4 = new Book ("Huckleberry Fin", "Mark Twain", 1955, 20.99);
//		Book bk5 = new Book ("Moby Dick", "Herman Melville", 1857, 69.99);
//		Book bk6 = new Book ("Declaration", "Thomas Jefferson", 1776, 5000.00);
//		Book bk7 = new Book ("Chickens", "Game", 2015, 2.00);
//		Book bk8 = new Book ("Games", "Genius", 2000, 2.99);
//		Book bk9 = new Book ("Microsoft", "Bill Gates", 1983, 29.99);
		
		books.add(bk1);
		books.add(bk2);
		books.add(bk3);
		books.add(bk4);
		
		
		two.setLibraryBooks(books2);
		assertEquals(two.totalNumBooks(), 0);
	}
	
	@Test
	public void testCheckOut() 
	{
		Library one = new Library("One Test");
		ArrayList<Book> books = new ArrayList<Book>();
		ArrayList<Person> patrons = new ArrayList<Person>();
		
		Book bk1 = new Book ("Dictionary", "Webster", 1990, 250.45);
//		Book bk2 = new Book ("Dictionary", "Webster", 1991, 250.45);
//		Book bk3 = new Book ("Harry Potter", "Rowling", 2012, 52.99);
//		Book bk4 = new Book ("Huckleberry Fin", "Mark Twain", 1955, 20.99);
		
		books.add(bk1);
//		books.add(bk2);
//		books.add(bk3);
//		books.add(bk4);
		
		one.setLibraryBooks(books);
		
		Person George = new Person("George", "529 Watson Webb", 9);
		//Person Bill = new Person("Bill", "123 East St", 20);
		//Person Ham = new Person("Ham", "420 Help me", 15);
		
		patrons.add(George);
		one.setPatrons(patrons);
		
		assertTrue(one.checkOut(George, bk1, "18 09 2016"));
	}
	
	@Test
	public void testCheckOut2() 
	{
		Library two = new Library("Two Test");
		ArrayList<Book> books2 = new ArrayList<Book>();
		ArrayList<Person> patrons = new ArrayList<Person>();
		
		Person George = new Person("George", "529 Watson Webb", 9);
		Person Bill = new Person("Bill", "123 East St", 20);
		Person Ham = new Person("Ham", "420 Help me", 15);
		
//		Book bk1 = new Book ("Dictionary", "Webster", 1990, 250.45);
//		Book bk2 = new Book ("Dictionary", "Webster", 1991, 250.45);
//		Book bk3 = new Book ("Harry Potter", "Rowling", 2012, 52.99);
//		Book bk4 = new Book ("Huckleberry Fin", "Mark Twain", 1955, 20.99);
		Book bk5 = new Book ("Moby Dick", "Herman Melville", 1857, 69.99);
		Book bk6 = new Book ("Declaration", "Thomas Jefferson", 1776, 5000.00);
		Book bk7 = new Book ("Chickens", "Game", 2015, 2.00);
		Book bk8 = new Book ("Games", "Genius", 2000, 2.99);
		Book bk9 = new Book ("Microsoft", "Bill Gates", 1983, 29.99);
		
		books2.add(bk5);
		books2.add(bk6);
		books2.add(bk7);
		books2.add(bk9);
		
		two.setLibraryBooks(books2);
	
		patrons.add(Bill);
		two.setPatrons(patrons);
		
		assertTrue(two.checkOut(Bill, bk9, "18 09 2016"));
	}
	
	@Test
	public void testBooksDueOnDate() 
	{
		Library one = new Library("One Test");
		
		Person George = new Person("George", "529 Watson Webb", 9);
		Person Bill = new Person("Bill", "123 East St", 20);
		Person Ham = new Person("Ham", "420 Help me", 15);
		
		Book bk1 = new Book ("Dictionary", "Webster", 1990, 250.45);
		Book bk2 = new Book ("Dictionary", "Webster", 1991, 250.45);
		Book bk3 = new Book ("Harry Potter", "Rowling", 2012, 52.99);
		Book bk4 = new Book ("Huckleberry Fin", "Mark Twain", 1955, 20.99);
		Book bk5 = new Book ("Moby Dick", "Herman Melville", 1857, 69.99);
		Book bk6 = new Book ("Declaration", "Thomas Jefferson", 1776, 5000.00);
		Book bk7 = new Book ("Chickens", "Game", 2015, 2.00);
		Book bk8 = new Book ("Games", "Genius", 2000, 2.99);
		Book bk9 = new Book ("Microsoft", "Bill Gates", 1983, 29.99);
		
		one.getLibraryBooks().add(bk1);
		one.getLibraryBooks().add(bk2);
		one.getLibraryBooks().add(bk3);
		one.getLibraryBooks().add(bk4);
		one.getLibraryBooks().add(bk5);
		one.getLibraryBooks().add(bk6);
		one.getLibraryBooks().add(bk7);
		one.getLibraryBooks().add(bk8);
		one.getLibraryBooks().add(bk9);
		
		one.getPatrons().add(George);
		one.getPatrons().add(Ham);
		
		one.checkOut(George, bk1, "17 09 2016");
		one.checkOut(George, bk7, "18 09 2016");
		one.checkOut(Ham, bk6, "19 09 2016");
		assertTrue(one.booksDueOnDate("20 09 2016").isEmpty());
	}
	
	@Test
	public void testBooksDueOnDate2() 
	{
		Library one = new Library("One Test");
		ArrayList<Book> booksGone = new ArrayList<Book>();
		
		Person George = new Person("George", "529 Watson Webb", 9);
		Person Bill = new Person("Bill", "123 East St", 20);
		Person Ham = new Person("Ham", "420 Help me", 15);
		
		Book bk1 = new Book ("Dictionary", "Webster", 1990, 250.45);
		Book bk2 = new Book ("Dictionary", "Webster", 1991, 250.45);
		Book bk3 = new Book ("Harry Potter", "Rowling", 2012, 52.99);
		Book bk4 = new Book ("Huckleberry Fin", "Mark Twain", 1955, 20.99);
		Book bk5 = new Book ("Moby Dick", "Herman Melville", 1857, 69.99);
		Book bk6 = new Book ("Declaration", "Thomas Jefferson", 1776, 5000.00);
		Book bk7 = new Book ("Chickens", "Game", 2015, 2.00);
		Book bk8 = new Book ("Games", "Genius", 2000, 2.99);
		Book bk9 = new Book ("Microsoft", "Bill Gates", 1983, 29.99);
		
		one.getLibraryBooks().add(bk1); booksGone.add(bk1);
		one.getLibraryBooks().add(bk2);
		one.getLibraryBooks().add(bk3);
		one.getLibraryBooks().add(bk4);
		one.getLibraryBooks().add(bk5);
		one.getLibraryBooks().add(bk6); booksGone.add(bk6);
		one.getLibraryBooks().add(bk7); booksGone.add(bk7);
		one.getLibraryBooks().add(bk8);
		one.getLibraryBooks().add(bk9);
		
		one.getPatrons().add(George);
		one.getPatrons().add(Ham);
		
		one.checkOut(George, bk1, "18 09 2016");
		one.checkOut(George, bk7, "18 09 2016");
		one.checkOut(Ham, bk6, "18 09 2016");
		assertEquals(one.booksDueOnDate("18 09 2016"), booksGone);
	}
	
	@Test
	public void testLateFee() 
	{
		Library one = new Library("One Test");
		one.setCurrentDate("30 09 2016");
		
		ArrayList<Book> books = new ArrayList<Book>();
		ArrayList<Book> books2 = new ArrayList<Book>();
		
		Person George = new Person("George", "529 Watson Webb", 9);
		Person Bill = new Person("Bill", "123 East St", 20);
		Person Ham = new Person("Ham", "420 Help me", 15);
		
		Book bk1 = new Book ("Dictionary", "Webster", 1990, 250.45);
		Book bk2 = new Book ("Dictionary", "Webster", 1991, 250.45);
		Book bk3 = new Book ("Harry Potter", "Rowling", 2012, 52.99);
		Book bk4 = new Book ("Huckleberry Fin", "Mark Twain", 1955, 20.99);
		Book bk5 = new Book ("Moby Dick", "Herman Melville", 1857, 69.99);
		Book bk6 = new Book ("Declaration", "Thomas Jefferson", 1776, 5000.00);
		Book bk7 = new Book ("Chickens", "Game", 2015, 2.00);
		Book bk8 = new Book ("Games", "Genius", 2000, 2.99);
		Book bk9 = new Book ("Microsoft", "Bill Gates", 1983, 29.99);
		
			
		one.getLibraryBooks().add(bk1);
		one.getLibraryBooks().add(bk9);
		one.getLibraryBooks().add(bk3);

		one.getPatrons().add(George);

		one.checkOut(George, bk1, "10 12 2016"); // on time
		one.checkOut(George, bk9, "20 12 2016"); // on time
		one.checkOut(George, bk3, "30 12 2016"); // on time
		assertEquals(one.lateFee(George), 0, 0.1);
	}
	
	@Test
	public void testLateFee2() 
	{
		Library one = new Library("One Test");
		one.setCurrentDate("30 09 2016");
		
		ArrayList<Book> books = new ArrayList<Book>();
		ArrayList<Book> books2 = new ArrayList<Book>();
		
		Person George = new Person("George", "529 Watson Webb", 9);
		Person Bill = new Person("Bill", "123 East St", 20);
		Person Ham = new Person("Ham", "420 Help me", 15);
		
		Book bk1 = new Book ("Dictionary", "Webster", 1990, 250.45);
		Book bk2 = new Book ("Dictionary", "Webster", 1991, 250.45);
		Book bk3 = new Book ("Harry Potter", "Rowling", 2012, 52.99);
		Book bk4 = new Book ("Huckleberry Fin", "Mark Twain", 1955, 20.99);
		Book bk5 = new Book ("Moby Dick", "Herman Melville", 1857, 69.99);
		Book bk6 = new Book ("Declaration", "Thomas Jefferson", 1776, 5000.00);
		Book bk7 = new Book ("Chickens", "Game", 2015, 2.00);
		Book bk8 = new Book ("Games", "Genius", 2000, 2.99);
		Book bk9 = new Book ("Microsoft", "Bill Gates", 1983, 29.99);
		
			
		one.getLibraryBooks().add(bk1);
		one.getLibraryBooks().add(bk9);
		one.getLibraryBooks().add(bk3);

		one.getPatrons().add(George);

		one.checkOut(George, bk1, "17 09 2016"); // 13 days late
		one.checkOut(George, bk9, "17 09 2016"); // 13 days late
		one.checkOut(George, bk3, "30 09 2016"); // On time
		assertEquals(one.lateFee(George), 36.45, 0.1);
	}
}
	