/* Michael Wu mvw5mf
 * Matt Guyer msg5as
 */

public class Book 
{
	private String title;
	private String author; 
	
	//constructors
	public Book(String title, String author)
	{
		this.title = title;
		this.author = author; 
	}
	
	
	public static void main(String[] args) 
	{
	
	}
	
	//accessor for title
	public String getTitle()
	{
		return this.title;
	}
	
	//accessor for author
	public String getAuthor()
	{
		return this.author;
	}
	
	//comparison method for title and author of book
	public boolean equals(Object o)
	{
		if (o instanceof Book) 
		{
			Book b = (Book) o;
			return (b.getTitle().equals( this.title) && b.getAuthor().equals(this.author));		
		}
		else 
		{
			return false;
		}
	}
	
	//printing method
	public String toString()
	{
		return "Book: " + this.title + " by " + this.author ; 
	}

}
