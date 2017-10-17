/* Michael Wu
 * mvw5mf
 * Homework 3
 */

public class Book 
{
	private String title;
	private String author;
	private String dueDate;
	private Boolean checkedOut; 
	private int bookId;
	private double bookValue; 
	
	//constructors
	public Book(String title, String author, int bookId, double bookValue)
	{
		this.title = title;
		this.author = author;
		this.bookId = bookId;
		this.bookValue = bookValue;
		this.checkedOut = false;
		this.dueDate = "00 00 0000";
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
		return author;
	}
	
	public String getDueDate()
	{
		return dueDate;
	}
	
	public void setDueDate(String dueDate)
	{
		this.dueDate = dueDate;
	}
	
	public Boolean getCheckedOut()
	{
		return checkedOut;
	}
	
	public void setCheckedOut(Boolean checkedOut)
	{
		this.checkedOut = checkedOut; 
	}
	
	public int getBookId()
	{
		return bookId;
	}
	
	public double getBookValue()
	{
		return bookValue;
	}
	
	public void setBookValue(double bookValue)
	{
		this.bookValue = bookValue;
	}
	
	//comparison method for title and author of book
	public boolean equals(Object o)
	{
		if (o instanceof Book) 
		{
			Book b = (Book) o;
			return (b.getBookId()==(this.bookId));		
		}
		else 
		{
			return false;
		}
	}
	
	//printing method
	public String toString()
	{
		return "Book: " + this.title + " by " + this.author + " ID number " + this.bookId + "Checked Out: " + this.checkedOut + " Due Date: " + this.dueDate + " Cost: " + this.bookValue; 
	}

}
