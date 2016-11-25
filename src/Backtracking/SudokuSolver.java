package Backtracking;

public class SudokuSolver {
	public static void main(String[] args) {
//		int[][] a = { {5,3,0,0,7,0,0,0,0}, {6,0,0,1,9,5,0,0,0}, {0,9,8,0,0,0,0,6,0}, {8,0,0,0,6,0,0,0,3}, {4,0,0,8,0,3,0,0,1}, {7,0,0,0,2,0,0,0,6}, {0,6,0,0,0,0,2,8,0}, {0,0,0,4,1,9,0,0,5}, {0,0,0,0,8,0,0,7,9}};
//		int[][] a = {{0,0,3,4}, {3,4,0,0}, {0,0,4,3}, {0,3,2,0} };
//		int[][] a = {{0,1,3,4}, {3,4,0,0}, {1,0,4,3}, {0,3,1,0} };
		int[][] a = {{0,0,0,0}, {0,0,0,0}, {0,0,0,0}, {0,0,0,0} };
		
//		print(a);
		System.out.println(solve(a, -1, -1));
		print(a);
	}
	
	static boolean solve(int[][] a, int lasti, int lastj)
	{
		if( (lasti != -1) && (lastj != -1) && (!isValid(a, lasti, lastj)) )
			return false;
			
		boolean ret = true;
		for(int i =0;i<a.length;i++)
		{
			for(int j = 0;j<a[0].length;j++)
			{
				if(a[i][j] == 0)
				{
					for(int k = 1;k<=a.length;k++)
					{
						a[i][j] = k;
						ret = solve(a, i, j);
						
						//break out of the k loop if it's working
						if(ret == true)
							return true;
						
						//continue the k loop, and set this to be 0, if we're going say, 2 stacks down
						else
							a[i][j] = 0;
					}
				}
			}
		}
		return ret;
	}
	
	//only checks if sudoku is valid, not if sudoku is solved
	static boolean isValid(int[][] a, int row, int col)
	{
		//row
		boolean[] check = new boolean[a[0].length];
		for(int i = 0;i<a[0].length;i++)
		{
			if(a[row][i]!= 0)
			{
				if(check[a[row][i]-1] == true)
					return false;
				check[a[row][i]-1] = true;
			}
		}
		
		//col
		check = new boolean[a.length];
		for(int i = 0;i<a.length;i++)
		{
			if(a[i][col] != 0 )
			{
				if(check[a[i][col]-1] == true)
					return false;
				check[a[i][col]-1] = true;
			}
		}
		
		//box
		check = new boolean[a.length];
		int boxsize = (int)Math.sqrt(a.length);
		int starti = row-(row%boxsize);
		int startj = col-(col%boxsize);
		for(int i = starti;i<starti+boxsize;i++)
		{
			for(int j = startj;j<startj+boxsize;j++)
			{
				if(a[i][j] != 0 )
				{
					if(check[a[i][j]-1] == true)
						return false;
					check[a[i][j]-1] = true;
				}
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
