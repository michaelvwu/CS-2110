import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.*;

public class Lab1Scanner 
{
	public static void main(String[] args) throws FileNotFoundException 
	{
			/*Scanner theInput = new Scanner(System.in);
			double [] numbers = new double[5]; 
			for (int i = 0; i < 5; i++)
			{
				
				System.out.println("Enter a number: ");
				numbers[i] = theInput.nextDouble();
			}
			int sum = 0;
			for (double number : numbers)
				sum += number;
			
			double average = sum / numbers.length;
			System.out.println("The average of " + Arrays.toString(numbers) + " is " + average);*/

		// when inputing something other than an integer or double, the error is an InputMismatchException
			
//			File labFile = new File("data1.txt");
//			Scanner fileScnr = null; 
//			try
//			{
//				fileScnr = new Scanner(labFile);
//			}
//			catch (Exception e)
//			{
//				System.exit(1);
//			}
//			
//			Scanner inputFile = new Scanner(labFile);
//			String str = inputFile.nextLine();
//			inputFile.close();
//			System.out.println("Size: " + labFile.length());
//			System.out.println("Path: " + labFile.getAbsolutePath());
//			
		System.out.println("Working Directory= " + System.getProperty("user.dir"));
			
		
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Enter the filename: ");
		String fileName = keyboard.nextLine();
		File labFile = new File(fileName);
		Scanner inputFile = new Scanner(labFile);
		
		Scanner fileScnr = null;
		try
		{
			fileScnr = new Scanner(labFile);
		}
		catch (Exception e)
		{
			System.out.println("File not found.");
			System.exit(1);
		}
		
		String labRead = inputFile.nextLine();
		//System.out.println("Size: " + labFile.length());
		//System.out.println("Path: " + labFile.getAbsolutePath());
		
		char[] arrCharacter;
		int[] arrCount = new int[26];
		
		
		
		labRead = labRead.toLowerCase(Locale.ENGLISH);
		
		arrCharacter = labRead.toCharArray();
		
		for (int i = 0; i<arrCharacter.length; i++)
		{
			if (arrCharacter[i] == 'a') {
                arrCount[0] = arrCount[0] + 1;
            } else if (arrCharacter[i] == 'b') {
                arrCount[1] = arrCount[1] + 1;
            } else if (arrCharacter[i] == 'c') {
                arrCount[2] = arrCount[2] + 1;
            } else if (arrCharacter[i] == 'd') {
                arrCount[3] = arrCount[3] + 1;
            } else if (arrCharacter[i] == 'e') {
                arrCount[4] = arrCount[4] + 1;
            } else if (arrCharacter[i] == 'f') {
                arrCount[5] = arrCount[5] + 1;
            } else if (arrCharacter[i] == 'g') {
                arrCount[6] = arrCount[6] + 1;
            } else if (arrCharacter[i] == 'h') {
                arrCount[7] = arrCount[7] + 1;
            } else if (arrCharacter[i] == 'i') {
                arrCount[8] = arrCount[8] + 1;
            } else if (arrCharacter[i] == 'j') {
                arrCount[9] = arrCount[9] + 1;
            } else if (arrCharacter[i] == 'k') {
                arrCount[10] = arrCount[10] + 1;
            } else if (arrCharacter[i] == 'l') {
                arrCount[11] = arrCount[11] + 1;
            } else if (arrCharacter[i] == 'm') {
                arrCount[12] = arrCount[12] + 1;
            } else if (arrCharacter[i] == 'n') {
                arrCount[13] = arrCount[13] + 1;
            } else if (arrCharacter[i] == 'o') {
                arrCount[14] = arrCount[14] + 1;
            } else if (arrCharacter[i] == 'p') {
                arrCount[15] = arrCount[15] + 1;
            } else if (arrCharacter[i] == 'q') {
                arrCount[16] = arrCount[16] + 1;
            } else if (arrCharacter[i] == 'r') {
                arrCount[17] = arrCount[17] + 1;
            } else if (arrCharacter[i] == 's') {
                arrCount[18] = arrCount[18] + 1;
            } else if (arrCharacter[i] == 't') {
                arrCount[19] = arrCount[19] + 1;
            } else if (arrCharacter[i] == 'u') {
                arrCount[20] = arrCount[20] + 1;
            } else if (arrCharacter[i] == 'v') {
                arrCount[21] = arrCount[21] + 1;
            } else if (arrCharacter[i] == 'w') {
                arrCount[22] = arrCount[22] + 1;
            } else if (arrCharacter[i] == 'x') {
                arrCount[23] = arrCount[23] + 1;
            } else if (arrCharacter[i] == 'y') {
                arrCount[24] = arrCount[24] + 1;
            } else if (arrCharacter[i] == 'z') {
                arrCount[25] = arrCount[25] + 1;
            }
			
			int totCount = 0;
			for (int c = 0; c <arrCount.length; c++) 
			{
	            totCount+=arrCount[c];
	        }
			
			double [] precntage = null;
	        for (int z = 0; z <arrCount.length; z++) 
	        {
	               precntage[z]=((arrCount[z]/totCount)*100);
	               precntage[z]=Math.round(precntage[z]);
	        }

	        char s1='A';
	      
	        for (int t = 0; t < arrCount.length; t++) 
	        {
	            String gs=Character.toString(s1++);
	            System.out.println(gs+" has frequency "+precntage[t]);
	        }

// does not work, trying to find Null Pointer Exception
		}
		
		
	}

}