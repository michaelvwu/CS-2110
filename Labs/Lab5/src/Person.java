import java.util.ArrayList;

/* Michael Wu mvw5mf
 * Matt Guyer msg5as
 */

public class Person 
{
	private String name; 
	private int id;
	private ArrayList<Book> read = new ArrayList<>(); 
	
	//constructor
	public Person (String name, int id)
	{
		this.name = name;
		this.id = id;
	}
	
	public static void main(String[] args) 
	{
//		Person p1 = new Person ("George", 23452);
//		Person p2 = new Person ("Ham", 1234);
//		
//		Book bk1 = new Book ("Dictionary", "Webster");
//		Book bk2 = new Book ("Dictionary", "Webster");
//		Book bk3 = new Book ("Harry Potter", "Rowling");
//		Book bk4 = new Book ("Huckleberry Fin", "Mark Twain");
//		Book bk5 = new Book ("Moby Dick", "Herman Melville");
//		Book bk6 = new Book ("Declaration", "Thomas Jefferson");
//		Book bk7 = new Book ("Chickens", "Game");
//		Book bk8 = new Book ("Games", "Genius");
//		Book bk9 = new Book ("Microsoft", "Bill Gates");
//		
//		p1.addBook(bk1);
//		p1.addBook(bk3);
//		p1.addBook(bk5);
//		p1.addBook(bk7);
//		p2.addBook(bk2);
//		p2.addBook(bk4);
//		p2.addBook(bk6);
//		
//		System.out.println(p1);
//		System.out.println(p2);
//		System.out.println(bk1.equals(bk2));
//		System.out.println(bk1.equals(bk9));
//		
//		System.out.println(p1.numBooksRead());
//		System.out.println(p2.numBooksRead());
//		
//		System.out.println(commonBooks(p1, p2));
//		System.out.println(p2.read.size());
//		System.out.println(commonBooks(p1,p2).size());
//		System.out.println(similarity(p1,p2));
//		
//		p1.forgetBook(bk1);
//		p2.forgetBook(bk6);
//		System.out.println(p1);
//		System.out.println(p2);
//		
//		System.out.println(commonBooks(p1, p2));
//		System.out.println(similarity(p1,p2));
//		
//		System.out.println(p1.hasRead(bk3));
//		System.out.println(p2.hasRead(bk4));
		
	}
	
	//acccessor for name
	public String getName()
	{
		return name;
	}
	
	//accessor for ID
	public int getID()
	{
		return id;
	}
	
	//accessor for read arraylist
	public ArrayList<Book> getRead()
	{
		return read;
	}
	
	//mutator 
	public void setName(String name)
	{
		this.name = name;
	}
	
	//add books to arraylist
	public boolean addBook(Book b)
	{
		if (read.contains(b))
		{
			return false; 
		}
		else 
		{
			read.add(b);
			return true; 
		}
	}

	//removal method for deleting books in arraylist
	public boolean forgetBook(Book b)
	{
		if(read.contains(b))
		{
			read.remove(b);
			return true;
		}
		else 
			return false;
	}
	
	//checks for book duplicates
	public boolean hasRead(Book b)
	{
		if(read.contains(b))
		{
			return true;
		}
		else 
			return false;
	}
	
	//finds the size of the arraylist
	public int numBooksRead()
	{
		return read.size(); 
	}
	
	//equivalence method
	public boolean equals(Object o)
	{
		if (o instanceof Person) 
		{
			Person p = (Person) o;
			return p.getID()==this.id;		
		}
		else 
		{
			return false;
		}
	}
	
	//print method
	public String toString()
	{
		return "Name:" + name + " ID: " + id + " " + read.toString();
	}
	
	//finds shared books
	public static ArrayList<Book> commonBooks(Person a, Person b)
	{
		ArrayList<Book> cbks = new ArrayList<>();
		for (Book a1: a.read)
		{
			for(Book b1: b.read)
			{
				if (a1.equals(b1) && !cbks.contains(a1))
				{
					cbks.add(a1);
					break;
				}
			}
		}
		return cbks;
	}
	
	//determines similarity
	public static double similarity(Person a, Person b)
	{
		double sim;
		if (a.read.size() >= b.read.size())
		{
			sim = (double)commonBooks(a,b).size() / (double)b.read.size();
		}
		else if (a.read.size() < b.read.size())
		{
			sim = (double)commonBooks(a,b).size() / (double)a.read.size();
		}
		else
		{
			sim = 0.0;
		}
		return sim;
	}
}
