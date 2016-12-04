package FileReading;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class spaceseparatedintegers {
	public static void main(String[] args) throws IOException {
		int[][] a = new int[9][9];
		
		validate(a);
	}
	
	/*Input looks as follows
	 *  4 1 7 3 6 9 8 2 5
		6 3 2 1 5 8 9 4 7
		9 5 8 7 2 4 3 1 6
		8 2 5 4 3 7 1 6 9
		7 9 1 5 8 6 4 3 2
		3 4 6 9 1 2 7 5 8
		2 8 9 6 4 3 5 7 1
		5 7 3 2 9 1 6 8 4
		1 6 4 8 7 5 2 9 3
	 */
	static void validate(int[][] a) throws IOException
	{
		Scanner stdin = new Scanner(new FileReader("src\\Week1_Day1\\input"));
		
		while(stdin.hasNext())
		{
			System.out.println(stdin.nextInt());
		}
			
	}
}
