package Backtracking;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;

/* http://stackoverflow.com/questions/289537/a-cool-algorithm-to-check-a-sudoku-field */
public class SudokuValidator_27sets {
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
		HashSet<Integer>[] sets = new HashSet[a.length*3];
		for(int k = 0;k<sets.length;k++)
			sets[k] = new HashSet<Integer>();
		for(int i = 0;i<a.length;i++)
		{
			for(int j = 0;j<a[0].length;j++)
			{
				sets[i].add(a[i][j]);//adding to row set(0-8)
				sets[a.length + j].add(a[i][j]);//adding to column set(9-17)
				//adding to box set //(18-26)
				sets[a.length*2 + (i/(int)Math.sqrt(a.length))*(int)Math.sqrt(a.length) + (j/(int)Math.sqrt(a.length))].add(a[i][j]);
			}
		}
		
		for(int i = 0;i<sets.length;i++)
		{
			if(sets[i].size() != a.length)
				return false;
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
