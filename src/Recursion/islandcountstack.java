package Recursion;

import java.util.Stack;

public class islandcountstack {
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
		Stack<Entry> myStack = new Stack<Entry>();
		
		myStack.push(new Entry(i, j));
		a[i][j] = 0;
		while(myStack.size() > 0)
		{
			Entry current = myStack.pop();
			
			Entry left = new Entry(current.i, current.j-1);
			Entry right = new Entry(current.i, current.j+1);
			Entry top = new Entry(current.i-1, current.j);
			Entry bottom = new Entry(current.i+1, current.j);
			
			 if(left.i >= 0 && left.i < a.length && left.j>=0 && left.j<a[0].length && a[left.i][left.j]==1)
			 {
				 a[left.i][left.j] = 0;
				 myStack.push(left);
			 }
				 
			 if(right.i >= 0 && right.i < a.length && right.j>=0 && right.j<a[0].length && a[right.i][right.j]==1)
			 {
				 a[right.i][right.j] = 0;
				 myStack.push(right);
			 }
				 
			 if(top.i >= 0 && top.i < a.length && top.j>=0 && top.j<a[0].length && a[top.i][top.j]==1)
			 {
				 a[top.i][top.j] = 0;
				 myStack.push(top);
			 }
				 
			 if(bottom.i >= 0 && bottom.i < a.length && bottom.j>=0 && bottom.j<a[0].length && a[bottom.i][bottom.j]==1)
			 {
				 a[bottom.i][bottom.j] = 0;
				 myStack.push(bottom);
			 }
				 
			 a[i][j] = 0;
		}
	}
}

class Entry
{
	int i;
	int j;
	public Entry(int i, int j)
	{
		this.i = i;
		this.j = j;
	}
}