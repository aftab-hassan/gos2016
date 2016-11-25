package Recursion;

public class islandcount {
	/* island count == 6
	0  1  0  1  0
    0  0  1  1  1
    1  0  0  1  0
    0  1  1  0  0
    1  0  1  0  1
    */
	public static void main(String[] args) {
		int[][] a = { {0,1,0,1,0}, {0,0,1,1,1}, {1,0,0,1,0}, {0,1,1,0,0}, {1,0,1,0,1} };
		System.out.println(countisland(a));
	}
	
	static int countisland(int[][] a)
	{
		int count = 0;
		for(int i = 0;i<a.length;i++)
		{
			for(int j = 0;j<a[0].length;j++)
			{
				if(a[i][j] == 1)
				{
					count++;
					makezero(a, i, j);
				}
			}
		}
		
		return count;
	}
	
	static void makezero(int[][] a, int i, int j)
	{
		if(i < 0 || j < 0 || i == a.length || j == a[0].length || a[i][j] == 0)
			return;
		
		a[i][j] = 0;
		makezero(a, i, j-1);//left
		makezero(a, i, j+1);//right
		makezero(a, i-1, j);//up
		makezero(a, i+1, j);//down
	}
}
