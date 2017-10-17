/* Michael Wu 
 * mvw5mf
 */


/* For each method:
 * two inputs used
 * the output from these tests
 */

import java.util.Scanner; 
import java.math.*;
import java.text.DateFormatSymbols;
import java.util.Random;
import java.util.Arrays;

public class HW1 
{ 
	
	public static void main(String[] args) 
	{
		Scanner reader = new Scanner(System.in);
		System.out.println("How many digits of pi would you like? ");
		int n = reader.nextInt();
		double answer = pi(n);
		System.out.println("Pi to " + n + " digits is: ");
		System.out.printf ("%." + n + "f", answer*4);
		
		System.out.println("\n");
		System.out.println("Choose a year: ");
		int y = reader.nextInt();
		String date = easter(y);
		System.out.println("In " + y + " Easter Sunday fell on " + date);
		
		System.out.println("\n");
		System.out.println("Launch velocity of the Astronaut? ");
		double v = reader.nextDouble();
		String jump = escape(v);
		System.out.println(jump);
		
		System.out.println("\n");
		System.out.println("Choose a number for r(old):");
		int r = reader.nextInt();
		System.out.println("Choose a number for a:");
		int a = reader.nextInt();
		System.out.println("Choose a number for b:");
		int b = reader.nextInt();
		System.out.println("Choose a number for m:");
		int m = reader.nextInt();
		
		int [] rando = random (r,a,b,m);
		System.out.println(Arrays.toString(rando));
	} 
	
	public static double pi(int n)
	{ 
		double piVal = 0.0;
		for(double i=1.0; i<1000000; i++)
		{
		    piVal += ((Math.pow((-1),(i+1)) / (2 * i - 1) ));
		}
		return (piVal); 
	}
	
	public static String easter(int y)
	{
		int a = y%19; 
		int b = y/100;
		int c = y%100;
		int d = b / 4;
		int e = b % 4;
		int g = (8 * b + 13)/25;
		int h = (19* a + b - d -g + 15)%30;
		int j = c/4 ;
		int k = c%4;
		int m = (a + 11 *h)/319;
		int r = (2*e+2*j-k-h+m+32)%7;
		int n = (h-m+r+90)/25;
		int p = (h-m+r+n+19)%32;
		
		String month = new DateFormatSymbols().getMonths()[n-1];
		String date = month + " " + p;
		return date;
	}
	
	public static String escape(double v)
	{
		double G = (6.67 * Math.pow(10, -11));
		double M = (1.3 * Math.pow(10, 22));
		double R = (1.153 * Math.pow(10, 6));
		
		//System.out.println(R);

		double fly = ((2*G*M)/R);
		fly = Math.sqrt(fly); 
		fly = fly * 2.237; 
		
		double m2 = 0.0;
		if (fly < v)
		{
			m2 = Math.pow((v * 0.44704), 2)/G/2 *R;
		}
		String jump = "";
		if (fly > v)
			jump = ("The astronaut will return to Halley's Comet.");
		else
			jump = ("The astronaut will not return to Halley’s Comet. \n"
					+ "In order for the astronaut to return, the comet \n would need "
					+ "to have a mass larger than " + m2 + " kilograms");
		return jump; 
	}
	
	public static int[] random(int r, int a, int b, int m)
	{
		int [] junk =  new int[25];
		int rNew = ((a* r + b)%m);
		
		for (int i =0; i<junk.length; i++)
		{
			junk [i]= rNew;
			r = rNew;
			rNew = ((a* r + b)%m);
		}
		return junk;
	}
}

/*
 * pi input: 5
 * easter input 2001
 * escape input 7
 * random [] inputs 5, 44, 3, 9
 * 
 
 * How many digits of pi would you like? 
5
Pi to 5 digits is: 
3.14159

Choose a year: 
2001
In 2001 Easter Sunday fell on April15


Launch velocity of the Astronaut? 
7
1153000.0
The astronaut will return to Halley's Comet.


Choose a number for r(old):
5
Choose a number for a:
44
Choose a number for b:
3
Choose a number for m:
9
[7, 5, 7, 5, 7, 5, 7, 5, 7, 5, 7, 5, 7, 5, 7, 5, 7, 5, 7, 5, 7, 5, 7, 5, 7]
*/

// Second test run:
/* pi input : 18
 * easter input 2020
 * escape input 5000
 * random [] input 1, 2, 3, 9
 * 
 */

/*
 * How many digits of pi would you like? 
18
Pi to 18 digits is: 
3.141593653590774200

Choose a year: 
2020
In 2020 Easter Sunday fell on April12


Launch velocity of the Astronaut? 
5000
1153000.0
The astronaut will not return to Halley’s Comet. 
In order for the astronaut to return, the comet 
 would need to have a mass larger than 4.318234822428785E22 kilograms


Choose a number for r(old):
1
Choose a number for a:
2
Choose a number for b:
3
Choose a number for m:
9
[5, 4, 2, 7, 8, 1, 5, 4, 2, 7, 8, 1, 5, 4, 2, 7, 8, 1, 5, 4, 2, 7, 8, 1, 5]
*/


