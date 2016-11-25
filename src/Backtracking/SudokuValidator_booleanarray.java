package Backtracking;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/* http://stackoverflow.com/questions/289537/a-cool-algorithm-to-check-a-sudoku-field */
public class SudokuValidator_booleanarray {
	public static void main(String[] args) throws IOException {
		int[][] a = new int[4][4];
		
		populate(a);
		boolean rec = validate(a);
		System.out.println("Given solution is : " + rec);
//		print(a);
	}
	
	/* Every row contains everything from 1-9
	 * Every col contains everything from 1-9
	 * Every box contains everything from 1-9 */
	static boolean validate(int[][] a)
	{
//		if(isRowValid(a) && isColumnValid(a) && isBoxValid(a) )
//			return true;
//		return false;
		
		boolean row = isRowValid(a);
		boolean col = isColumnValid(a);
		boolean box = isBoxValid(a);
		
		System.out.println("row == "+row+",col=="+col+",box=="+box);
		return row&&col&&box;
	}
	
	static boolean isRowValid(int[][] a)
	{
		for(int i = 0;i<a.length;i++)
		{
			boolean[] check = new boolean[a.length];
			for(int j = 0;j<a[0].length;j++)
			{
				if(check[a[i][j]-1] == true)
					return false;
				check[a[i][j]-1] = true;
			}
		}
		return true;
	}
	
	static boolean isColumnValid(int[][] a)
	{
		for(int j = 0;j<a[0].length;j++)
		{
			boolean[] check = new boolean[a.length];
			for(int i = 0;i<a.length;i++)
			{
				if(check[a[i][j]-1] == true)
					return false;
				check[a[i][j]-1] = true;
			}
		}
		return true;
	}
	
	static boolean isBoxValid(int[][] a)
	{
		int boxsize = (int)Math.sqrt(a.length);
		for(int i = 0;i<=a.length-boxsize;i+=boxsize)
		{
			for(int j = 0;j<=a[0].length-boxsize;j+=boxsize)
			{
				boolean[] check = new boolean[a.length];
				for(int k = i;k<i+boxsize;k++)
				{
					for(int l = j;l<j+boxsize;l++)
					{
						if(check[a[k][l]-1] == true)
							return false;
						check[a[k][l]-1] = true;
					}
				}
			}
		}
		return true;
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
	static void populate(int[][] a) throws IOException
	{
		Scanner stdin = new Scanner(new FileReader("src\\Week1_Day1\\input3"));
		int row = 0, col = 0;
		
		while(stdin.hasNext())
		{
			a[row][col++] = stdin.nextInt();
			if(col == a[0].length)
			{
				row++;
				col = 0;
			}
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
