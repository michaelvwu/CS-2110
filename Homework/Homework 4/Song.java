
/* 
 * Michael Wu 
 * mvw5mf
 * Homework 4 
 * section 100
 */

public class Song implements Comparable<Song>, Playable
{
	private String artist; // the artist performing the song
	private String title; // the title of the song
	private int minutes; // number of min in length
	private int seconds;  // number of seconds of length of the song (always less than 60)

	//constructor
	public Song(String artist, String title)
	{
		this.artist = artist;
		this.title = title; 
		minutes = 0; 
		seconds = 0; 
	}
	
	//constructor
	public Song(String artist, String title, int minutes, int seconds)
	{
		this.artist= artist;
		this.title = title;
		this.minutes = minutes + seconds/60; 
		this.seconds = seconds %60; 
	}
	
	//constructor
	public Song(Song s)
	{ 
		this.artist= s.artist;
		this.title = s.title;
		this.minutes = s.minutes; 
		this.seconds = s.seconds; 
	}
	
	//accessor
	public String getArtist() 
	{
		return artist;
	}
	
	//mutator
	public void setArtist(String artist)
	{
		this.artist = artist;
	}

	//accessor
	public String getTitle() 
	{
		return title;
	}

	//mutator
	public void setTitle(String title) 
	{
		this.title = title;
	}

	//accessor
	public int getMinutes() 
	{
		int time = this.minutes += seconds /60;
		return time;
	}

	//accessor
	public void setMinutes(int minutes) 
	{
		int conversion = seconds /60;
		this.minutes = minutes + conversion;
	}

	//accessor
	public int getSeconds() 
	{
		return seconds;
	}

	//mutator
	public void setSeconds(int seconds) 
	{
		this.minutes = minutes + seconds / 60;
		this.seconds = seconds % 60;
	}
	
	//equals method to see if two songs are the same
	public boolean equals(Object o)//write this code
	{
		if (o instanceof Song)
		{
			Song n = (Song) o;
			return (this.artist.equals(n.artist)) && (this.title.equals(n.title)) && (this.minutes == (n.minutes)) && (this.seconds == (n.seconds));
		}
		return false;
	}
	
	//to print out songs
	public String toString() 
	{ // Use this code for toString EXACTLY
		return "{Song: title = " + title + " artist = " + artist + "}";
	}
		 
	//used exactly from the given instructions
	public void play() 
	{ // Use this code for play EXACTLY
	   System.out.printf("Playing Song: artis t= %-20s title = %s\n", artist, title);
	}
	
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		
	}

	//comparison method to see if two songs are equal/same
	@Override
	public int compareTo(Song o) 
	{
		
		int minutesCmp = (this.minutes - o.minutes > 0 ? 1 : 0);
		int secondsCmp = (this.seconds - o.seconds > 0 ? 1 : 0);
		
		if (artist.equals(o.artist)) 
		{
			if (title.equals(o.title)) 
			{
				if (minutesCmp == 0) 
				{
					if (secondsCmp == 0) 
					{
						return 0;
					} 
					else 
						{return secondsCmp;}
				} 
				else {return minutesCmp;}
			} 
			else {return title.compareTo(o.title);}
		} 
		else {return artist.compareTo(o.artist);}
		
	}

	//accessor 
	@Override
	public String getName() 
	{
		return getTitle();
	}

	// accessor 
	@Override
	public int getPlayTimeSeconds() 
	{
		int time = getSeconds() + 60*getMinutes();
		return time;
	}
}
