package FileReading;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class commaseparatedintegers_9oneachline {
	public static void main(String[] args) throws IOException {
		int[][] a = new int[9][9];
		
		validate(a);
		print(a);
	}
	
	/*Input looks as follows
		400,1,7,3,6,9,8,2,5
		6,3,2,1,5,8,9,4,7
		9,5,8,7,2,4,3,1,6
		8,2,5,4,3,7,1,6,9
		7,9,1,5,8,6,4,3,2
		3,4,6,9,1,2,7,5,8
		2,8,9,6,4,3,5,7,1
		5,7,3,2,9,1,6,8,4
		1,6,4,8,7,5,2,9,3
	 */
	static void validate(int[][] a) throws IOException
	{
		Scanner stdin = new Scanner(new BufferedReader(new FileReader("src\\Week1_Day1\\input2")));
		int count = 0;
		
		while(stdin.hasNext())
		{
			String[] splitarray;  
			String line = stdin.nextLine();
			splitarray = line.split(",");
			
			for(int i = 0;i<splitarray.length;i++)
				a[count][i] = Integer.parseInt(splitarray[i]);
			count++;
		}	
	}
	
	static void print(int[][] a)
	{
		for(int i = 0;i<a.length;i++)
		{
			for(int j = 0;j<a[0].length;j++)
			{
				System.out.print(a[i][j] + " ");
			}
			System.out.println("");
		}
	}
}
