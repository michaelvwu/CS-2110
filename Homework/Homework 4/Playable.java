
/* 
 * Michael Wu 
 * mvw5mf
 * Homework 4 
 * section 100
 */

public interface Playable 
{
	public void play();
	
	// returns the name (for PlayList) or title (for Song) of Playable object.
	public String getName(); 
	
	// For Song: returns the number of seconds in the song. 
	//For PlayList: returns the number of seconds in the entire PlayList 
	public int getPlayTimeSeconds(); 
}
