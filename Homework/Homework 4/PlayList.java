import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/* 
 * Michael Wu 
 * mvw5mf
 * Homework 4 
 * section 100
 */


public class PlayList implements Comparator <Playable>, Playable
{
	private String name; //name of the playlist
	private ArrayList<Playable> playableList; //arraylist of playable elements that make up the play list 
	
	
	public PlayList() // empty play list named "Untitled"
	{
		this.name = "Untitled";
		this.playableList = new ArrayList<Playable>();
	}
	
	public PlayList(String newName) // empty play list
	{
		this.name = newName;
		this.playableList = new ArrayList<Playable>();
	}
	
	// main method used to hard testing (will find most of the test in jUnit)
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
	}
	
	//accessor
	public String getName() 
	{
		return name;
	}
	
	//mutator
	public void setName(String name) 
	{
		this.name = name;
	}

	//accessor
	public ArrayList<Playable> getPlayableList() {
		return playableList;
	}
	
	//mutator
	public void setPlayableList(ArrayList<Playable> playableList) {
		this.playableList = playableList;
	}
	
	// loads songs from file, more on this below
	@SuppressWarnings("resource")
	public boolean loadSongs(String fileName) 
	{
		Scanner reader = null;
		try 
		{
			reader = new Scanner(new File(fileName));
		} 
		catch(FileNotFoundException e) 
		{
			return false;
		}
		
		boolean added = false;
		while(reader.hasNext()) 
		{
			String title  = reader.nextLine().trim();
			String artist = reader.nextLine().trim();
			String time   = reader.nextLine().trim();
			reader.nextLine();
			
			if(artist.equals("") || time.contains(" "))
			{
				return false;
			}
			
			int minutes = Integer.parseInt(time.substring(0, time.indexOf(':')));
			int seconds = Integer.parseInt(time.substring(time.indexOf(':') +1));
			
			minutes += seconds /60;
			seconds = seconds % 60;
			added = addSong(new Song(artist, title, minutes, seconds));
		}
		return added;
		
	}
	
	public boolean clear() // removes all playable elements in the play list
	{
		if (playableList.isEmpty())
		{
			return false; 
		}
		this.playableList.clear();
		return true;
	}
	
	public boolean addSong(Song s) // adds Song s to the end of the play list
	{		
		this.playableList.add(s);
		return true; 
	}
	
	public Playable removePlayable(int index) // removes Playable element at index from the list and returns it
	{
		this.playableList.trimToSize();
		if (index < this.playableList.size() && index >= 0) 
		{
			Playable p = this.playableList.get(index);
			this.playableList.remove(index);
			return p;
		}
		else
		{
			return null;
		}
	}
	
	public Playable removePlayable(Playable p) // removes every occurrence of Playable p from the list and returns p
	{
		this.playableList.trimToSize();
		if (playableList.contains(p)) 
		{
			while(this.playableList.contains(p))
			{
				this.playableList.remove(p);
			}
			return p;
		}
		else
		{
			return null;
		}		
	}
	
	public Playable getPlayable(int index) // returns the Playable element at the appropriate index
	{
		if(this.playableList.size() > index && index >=0)
		{
			return this.playableList.get(index);
		}
		else
		{
			return null;
		}
	}
	
	
	public boolean addPlayList(PlayList pl) //add songs to a playlist if they are not already in the playlist
	{
		for(Playable p : playableList) 
		{
			if(p instanceof PlayList && ((PlayList)p).name.equals(pl.name))
			{
				return false;
			}
		}
		return playableList.add(pl);
	}
	
	// plays the play list by calling play() on each item in the play list in order
	@Override
	public void play()
	{
		for (Playable p : playableList)
		{
			p.play();
		}
	}
	
	// returns the number of songs in the play list and all songs contained in any of the nested play lists. 
	public int size()
	{
		int songs = 0; 
		for(Playable p : playableList)
		{
			songs += p instanceof PlayList ? ((PlayList)p).size() : 1;
		}
		return songs; 
	}
	
	// return the total length of time of the playlist
	public int getPlayTimeSeconds() 
	{
		int playTime = 0;
		for(Playable p : playableList) 
		{
			playTime += p.getPlayTimeSeconds();
		}
		return playTime;
	}
	
	//sort the playlist by the name 
	public Playable sortByName()
	{
		Collections.sort(playableList, new CmpByName());
		return null;
	}
	
	//sort the playlist by length of time of each song
	public Playable sortByTime()
	{
		Collections.sort(playableList, new CmpByTime());
		return null;
	}

	//compare the name of the songs to another song in the playlist to see if duplications exist
	@Override
	public int compare(Playable p1, Playable p2) 
	{
		int retVal = p1.getName().compareTo(p2.getName());
		return retVal;
	}
	
	//to properly display the playlist and songs
	public String toString() 
	{
		String output = "PlayList: " + name + " {\n";
		for(Playable p : playableList) 
		{
			output += p.toString() + "\n";
		}
		return output + "}\n";
	}
	
	
}
