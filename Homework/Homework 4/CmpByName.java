
/* 
 * Michael Wu 
 * mvw5mf
 * Homework 4 
 * section 100
 */

import java.util.Comparator;

public class CmpByName implements Comparator<Playable> {

	@Override
	public int compare(Playable p1, Playable p2) 
	{
		// TODO Auto-generated method stub
		int retVal = p1.getName().compareTo(p2.getName());
		return retVal;
	}

}
