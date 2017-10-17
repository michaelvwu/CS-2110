import java.util.ArrayList;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;


/* Michael Wu
 * mvw5mf
 * Homework 3
 */

public class Library 
{
	private ArrayList<Book> libraryBooks = new ArrayList<Book>();
	private ArrayList<Person> patrons = new ArrayList<Person>();
	private String name; 
	private int numBooks;
	private int numPeople;
	private String currentDate;
	
	
	public Library (String name)
	{
		this.name = name;
	}
	
	public ArrayList<Book> getLibraryBooks()
	{
		return libraryBooks; 
	}
	
	public void setLibraryBooks(ArrayList<Book> libraryBooks)
	{
		this.libraryBooks = libraryBooks;
		numBooks = libraryBooks.size();
	}
	
	public ArrayList<Person> getPatrons()
	{
		return patrons; 
	}
	
	public void setPatrons(ArrayList<Person> patrons)
	{
		this.patrons = patrons;
		numPeople = patrons.size();
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setName(String name)
	{
		 this.name = name;
	}
	
	public int getNumBooks()
	{
		numBooks = 0;
		for(Book b : libraryBooks)
		{
			if(!b.getCheckedOut())
			{
				numBooks++;
			}
		}
		return numBooks;
	}
	
	public int getNumPeople()
	{
		numPeople = patrons.size();
		return numPeople;
	}
	
	public String getCurrentDate()
	{
		return currentDate;
	}
	
	public void setCurrentDate(String currentDate)
	{
		this.currentDate = currentDate;
	}
	
	public int checkNumCopies( String title, String author)
	{
		int numbers = 0;
		for (Book a1 : libraryBooks)
		{
			if (a1.getTitle().equals(title)&&a1.getAuthor().equals(author))
			{
				numbers ++;
			}
		}
		return numbers;
	}
	
	public int totalNumBooks()
	{
		return libraryBooks.size();
	}
	
	public boolean checkOut(Person p, Book b, String dueDate)
	{ 
		if (patrons.contains(p))
			if (libraryBooks.contains(b))
				if (!b.getCheckedOut())
				{
					Book book = libraryBooks.get(libraryBooks.indexOf(b));
					if (p.addBook(book))
					{
						book.setDueDate(dueDate);
						book.setCheckedOut(true);
						return true;
					}
				}
		return false;
	}
	
	public ArrayList<Book> booksDueOnDate(String date)
	{
		ArrayList<Book> dateDue = new ArrayList<>();
		for (int i = 0; i < libraryBooks.size(); i++)
		{
			if (libraryBooks.get(i).getCheckedOut() && libraryBooks.get(i).getDueDate().equals(date))
			{
				dateDue.add(libraryBooks.get(i));
			}
		}
		return dateDue;
	}
	
	public double lateFee(Person p)
	{
		double fees = 0.01;
		double payment = 0.0;
		long daysBetween = 0;
		
		for (int i = 0; i < p.getCheckedOut().size(); i++)
		{
			String due = "DD MM YYYY";
			due = p.getCheckedOut().get(i).getDueDate();
			String[] dueArray = due.split(" ");
			int dueDay = Integer.parseInt(dueArray[0]);
			int dueMonth = Integer.parseInt(dueArray[1]);
			int dueYear = Integer.parseInt(dueArray[2]);
			
			String now = "DD MM YYYY";
			now = getCurrentDate();
			String[] nowArray = now.split(" ");
			int nowDay = Integer.parseInt(nowArray[0]);
			int nowMonth = Integer.parseInt(nowArray[1]);
			int nowYear = Integer.parseInt(nowArray[2]);
			
			LocalDate dateDue = LocalDate.of(dueYear, dueMonth, dueDay);
			LocalDate dateCurrent = LocalDate.of(nowYear, nowMonth, nowDay);
			daysBetween = ChronoUnit.DAYS.between(dateDue, dateCurrent);
			
//			if (dueYear < nowYear)
//			{
//				if (dueMonth < nowMonth)
//				{
//					if (dueDay < nowDay)
//					{
//						payment = daysBetween* fees * p.getCheckedOut().get(i).getBookValue();
//					}
//				}
//			}
			
			if (daysBetween> 0)
			{
				payment += daysBetween* fees * p.getCheckedOut().get(i).getBookValue();
			}
		}
		
		return payment;
	}
	
	public static void main(String[] args) 
	{

	}
	
	
}
