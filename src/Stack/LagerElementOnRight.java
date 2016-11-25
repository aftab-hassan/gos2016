package Stack;

import java.util.Stack;

public class LagerElementOnRight {
	public static void main(String[] args) {
		int[] a = {4, 3, 1, 5, 2, 6, 7};
//		int[] a = {4, 1, 5, 3, 2, 7, 6};
		
		fun(a);
	}
	
	static void fun(int[] a)
	{
		Stack<Integer> mystack = new Stack<>();mystack.add(a.length-1);
		int[] output = new int[a.length];
		for(int i = 0;i<output.length;i++)output[i] = -1;
		
		for(int i = a.length-2;i>=0;i--)
		{
			while( (mystack.size() > 0) && (a[mystack.peek()] < a[i]) )
				mystack.pop();
			output[i] = mystack.size()>0?mystack.peek():-1;
			mystack.add(i);
		}
		print(output);
	}
	
	static void print(int[] a)
	{
		for(int i = 0;i<a.length;i++)
			System.out.print(a[i] + " ");
	}
}
