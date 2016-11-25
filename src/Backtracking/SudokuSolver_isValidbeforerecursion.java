package Backtracking;

public class SudokuSolver_isValidbeforerecursion {
	public static void main(String[] args) {
//		int[][] a = { {5,3,0,0,7,0,0,0,0}, {6,0,0,1,9,5,0,0,0}, {0,9,8,0,0,0,0,6,0}, {8,0,0,0,6,0,0,0,3}, {4,0,0,8,0,3,0,0,1}, {7,0,0,0,2,0,0,0,6}, {0,6,0,0,0,0,2,8,0}, {0,0,0,4,1,9,0,0,5}, {0,0,0,0,8,0,0,7,9}};
//		int[][] a = {{0,0,3,4}, {3,4,0,0}, {0,0,4,3}, {0,3,2,0} };
//		int[][] a = {{0,1,3,4}, {3,4,0,0}, {1,0,4,3}, {0,3,1,0} };
		int[][] a = {{0,0,0,0}, {0,0,0,0}, {0,0,0,0}, {0,0,0,0} };
		
//		print(a);
		System.out.println(solve(a, 0, 0));
		print(a);
	}
	
	static boolean solve(int[][] a, int starti, int startj)
	{
		for(int i = starti;i<a.length;i++, startj = 0)
		{
			for(int j=startj;j<a.length;j++)
			{
				if(a[i][j] == 0)
				{
					for(int option = 1;option <=a.length;option++)
					{
						if(isValid(a, i, j, option))
						{
							a[i][j] = option;
							if(solve(a, i, j) == true)
								return true;
							a[i][j] = 0;
						}
					}
//					a[i][j] = 0;
					return false;	
				}
			}
		}
		return true;
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
