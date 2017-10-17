import java.awt.Color;

/*
 * Michael Wu
 * mvw5mf
 * 
 * Homework 6
 */

// the purpose of this program is to demonstrate recursion in four applications

public class Recursion 
{
	/** method that takes in a string and returns the string backwards
	 * 
	 * @param str,the word that needs to be reversed
	 * @return, the original word spelled backwards
	 */
	public static String reverseString(String str)
	{
		if (str.length() == 0)
		{
			return str;
		}
		
		return reverseString(str.substring(1)) + str.charAt(0);
	}
	
	/**method that determines the number of ways to traverse a set of stairs given the size of the staircase
	 * 
	 * @param numStairs, the number of stairs in a user defined/known staircase 
	 * @return, the number of ways to traverse the staircase using one or two steps at a time
	 */
	public static int countWays(int numStairs)
	{
		if (numStairs < 0)
		{
	        return 0;
		}
	    else if (numStairs == 0)
	    {
	        return 1;
	    }
	    else
	    {
	        return countWays(numStairs - 1) + countWays(numStairs - 2);
	    }
	}
	
	/** method that demonstrates a mathematical algorithm that can be used to test how well a computer performs recursion 
	 * 
	 * @param m, nonnegative integer
	 * @param n, nonnegative integer 
	 * @return, the value from the Ackermann function 
	 */
	public static int Ackermann(int m, int n)
	{
		if (m == 0) 
		{
	         return n + 1;
	    } 
		else if (n == 0) 
		{
	        return Ackermann(m - 1, 1);
	    } 
		else 
		{
	        return Ackermann(m - 1, Ackermann(m, n - 1));
	    }
	}
	
	/** this is a helper method that creates the drawing canvas and recursively calls snowflake to draw the koch snowflake
	 * 
	 * @param depth, the number of recursions to do
	 * @param startX, the starting x coordinate of the snowflake
	 * @param startY, the starting y coordinate of the snowflake
	 * @param size, how big the snowflake is in pixels
	 */
	public static void kochSnowflake(int depth, int startX, int startY, int size)
	{
		World myWorld = new World(900,900,Color.WHITE);
		Turtle koch = new Turtle(myWorld);
		koch.setDelay(0);
		int startX2 = startX + size; 
		int turn = (int)(Math.sin(120)*(startX2));
		
		snowflake(koch,depth,startX, startY, startX2, startY);
        snowflake(koch,depth,startX2, startY, turn, startX);
        snowflake(koch,depth,turn, startX ,startX,startY);
		
	}
	
	/** method creates a koch snowflake given the location (start and end points of snowflake)
	 * draws from the helper method, as this method runs three times over to complete a snowflake 
	 * 
	 * @param t, the drawing tool
	 * @param depth, the number of recursions
	 * @param pointX1, the starting x coordinate
	 * @param pointY1, the starting y coordinate
	 * @param pointX2, ending x coordinate
	 * @param pointY2, ending y coordinate
	 */
	public static void snowflake(Turtle t, int depth, int pointX1, int pointY1, int pointX2, int pointY2)
	{
		//temporary variables 
		 int changeX =0, changeY=0, x2=0, y2=0, x3=0, y3=0, x4=0, y4=0 ;
         
		 //If the user defines only one recursion (zero depth, depth = 0)
		 if (depth == 0)
         {
        	 t.pickPenUp();
             t.goTo(pointX1, pointY1);
             t.putPenDown();
             t.goTo(pointX2, pointY2);
             return;
         }
		 
		 // user defines more than one recursion/more intricate snowflake 
         else
         {
        	 //size of the snowflake 
        	 changeX = pointX2 - pointX1;
             changeY = pointY2 - pointY1;

             // the start/end points for the first one-third of the snowflake on one side
             x2 = pointX1 + changeX / 3;
             y2 = pointY1 + changeY / 3;

             // the start/end points for the middle third of the snowflake on one side
             x3 = (int) ((0.5 * (pointX1+pointX2) + (Math.sqrt(3) * (pointY1-pointY2)/6)));
             y3 = (int) ((0.5 * (pointY1+pointY2) + (Math.sqrt(3) * (pointX2-pointX1)/6)));

             //the start/end points for the last one-third of the snowflake on one side
             x4 = pointX1 + 2 * changeX /3;
             y4 = pointY1 + 2 * changeY /3;
       
             //draw the overlaying triangles to complete one side of the snowflake (really one side of a triangle)
             snowflake (t,depth-1, pointX1, pointY1, x2, y2);
             snowflake (t,depth-1, x2, y2, x3, y3);
             snowflake (t,depth-1, x3, y3, x4, y4);
             snowflake (t,depth-1, x4, y4, pointX2, pointY2);
              
         }
	}
	
	
	//testing methods
	public static void main(String[] args) 
	{
		
		System.out.println(reverseString("Hamlet"));
		
		System.out.println(countWays(2));
		
		System.out.println(Ackermann(2,4));
		
		
		// calling a helper method for the snowflake, read above 
		kochSnowflake(2, 20, 280, 260);

	}

}
