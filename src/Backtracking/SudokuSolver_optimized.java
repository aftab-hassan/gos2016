package Backtracking;

import java.util.ArrayList;

public class SudokuSolver_optimized {
	public static void main(String[] args) {
//		int[][] a = { {5,3,0,0,7,0,0,0,0}, {6,0,0,1,9,5,0,0,0}, {0,9,8,0,0,0,0,6,0}, {8,0,0,0,6,0,0,0,3}, {4,0,0,8,0,3,0,0,1}, {7,0,0,0,2,0,0,0,6}, {0,6,0,0,0,0,2,8,0}, {0,0,0,4,1,9,0,0,5}, {0,0,0,0,8,0,0,7,9}};
		int[][] a = {{0,0,3,4}, {3,4,0,0}, {0,0,4,3}, {0,3,2,0} };
//		int[][] a = {{0,1,3,4}, {3,4,0,0}, {1,0,4,3}, {0,3,1,0} };
//		int[][] a = {{0,0,0,0}, {0,0,0,0}, {0,0,0,0}, {0,0,0,0} };
//		int[][] a = { {2,4,0,1,8,0,0,0,5}, {6,0,0,5,0,0,0,8,0}, {0,0,0,3,0,0,6,2,4}, {9,5,0,0,0,4,2,0,0}, {0,0,0,9,2,1,0,0,0}, {0,0,3,6,0,0,0,9,1}, {8,6,5,0,0,3,0,0,0}, {0,7,0,0,0,5,0,0,6}, {1,0,0,0,6,7,0,4,3}};
		
//		print(a);
		System.out.println(solve(a, 0, 0));
		print(a);
	}
	
	static boolean solve(int[][] a, int starti, int startj)
	{
		int[] index = getBestStart(a);
		int i = index[0];
		int j = index[1];
		
		if(i==-1 && j==-1)
			return true;
		
		ArrayList<Integer> options = getPossibleOptions(a, i, j);
		for(int k = 0;k<options.size();k++)
		{
			if(isValid(a, i, j, options.get(k)))
			{
				a[i][j] = options.get(k);
				if(solve(a, i, j) == true)
					return true;
				a[i][j] = 0;
			}
		}
		return false;
	}
	
	static int[] getBestStart(int[][] a)
	{
		int[] ret = {-1,-1};
		int min = Integer.MAX_VALUE;
		int count = 0;
		for(int i = 0;i<a.length;i++)
		{
			for(int j = 0;j<a[0].length;j++)
			{
				if(a[i][j] == 0)
				{
					//in row
					for(int k = 0;k<a.length;k++)
					{
						if(a[i][k] != 0)
							count++;
					}
					
					//in col
					for(int k = 0;k<a.length;k++)
					{
						if(a[k][j] != 0)
							count++;
					}
					
					//box
					int starti = i - (i% (int) Math.sqrt(a.length));
					int startj = j - (j% (int) Math.sqrt(a.length));
					for(int ii=starti;ii<starti+(int) Math.sqrt(a.length);ii++)
					{
						for(int jj=startj;jj<startj+(int) Math.sqrt(a.length);jj++)
						{
							if(a[ii][jj] != 0)
								count++;
						}
					}
					
					if(count < min)
					{
						min = count;
						ret[0] = i;
						ret[1] = j;
					}
				}
			}
		}
		return ret;
	}
	
	static ArrayList<Integer> getPossibleOptions(int[][] a, int row, int col)
	{
		ArrayList<Integer> options = new ArrayList<>();
		int[] check = new int[a.length];
		
		//row
		for(int i = 0;i<a.length;i++)
		{
			if(a[row][i] != 0)
				check[a[row][i]-1] = -1;
		}
		
		//col
		for(int i = 0;i<a.length;i++)
		{
			if(a[i][col] != 0)
				check[a[i][col]-1] = -1;
		}
		
		//box
		int starti = row - (row% (int) Math.sqrt(a.length));
		int startj = col - (col% (int) Math.sqrt(a.length));
		for(int ii=starti;ii<starti+(int) Math.sqrt(a.length);ii++)
		{
			for(int jj=startj;jj<startj+(int) Math.sqrt(a.length);jj++)
			{
				if(a[ii][jj] != 0)
					check[a[ii][jj]-1] = -1;
			}
		}
		
		for(int i = 0;i<a.length;i++)
		{
			if(check[i] != -1)
				options.add(i+1);
		}
		return options;
	}
	
	static boolean isValid(int[][] a, int row, int col, int key)
	{
		if(isValidRow(a, row, key) && isValidCol(a, col, key) && isValidBox(a, row, col, key))
			return true;
		return false;
	}
	
	static boolean isValidRow(int[][] a, int row, int key)
	{
		for(int i = 0;i<a.length;i++)
		{
			if(a[row][i] == key)
				return false;
		}
		return true;
	}
	
	static boolean isValidCol(int[][] a, int col, int key)
	{
		for(int i = 0;i<a.length;i++)
		{
			if(a[i][col] == key)
				return false;
		}
		return true;
	}
	
	static boolean isValidBox(int[][] a, int row, int col, int key)
	{
		row = row - (row%(int)Math.sqrt(a.length));
		col = col - (col%(int)Math.sqrt(a.length));
		
		for(int i = row;i<row+(int)Math.sqrt(a.length);i++)
		{
			for(int j = col;j<col+(int)Math.sqrt(a.length);j++)
			{
				if(a[i][j] == key)
					return false;
			}
		}
		return true;
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
