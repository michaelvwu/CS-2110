/*
 * Michael Wu
 * mvw5mf
 * 
 * Homework 6
 */

//import gpdraw.*;
import javax.swing.*;
import java.lang.Math;

public class Recursion 
{
	public static String reverseString(String str)
	{
		if (str.length() == 0)
		{
			return str;
		}
		
		return reverseString(str.substring(1)) + str.charAt(0);
	}
	
	
	public static int countWays(int numStairs)
	{
		if (numStairs < 0)
	        return 0;
	    else if (numStairs == 0)
	        return 1;
	    else
	        return countWays(numStairs - 1) + countWays(numStairs - 2);
	}
	
	
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
	
	
//	public static void snowflake(int length, int level)
//	{
//		if (level == 0)
//	        drawStraightLine(length);
//	    else
//	    {
//	        snowflake(length / 3, level - 1);
//	        turnLeft(60);
//	        snowflake(length / 3, level - 1);
//	        turnRight(120);
//	        snowflake(length / 3, level - 1);
//	        turnLeft(60);
//	        snowflake(length / 3, level - 1);
//	    }
//	}
//	
	
	
	public static void main(String[] args) 
	{
		System.out.println(reverseString("Hamlet"));
		
		System.out.println(countWays(2));
		
		System.out.println(Ackermann(4,2));

	}

}
