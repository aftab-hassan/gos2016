package Searching;

public class closestbinarysearch {
	public static void main(String[] args) {
		int[] a = {10, 17, 22, 25, 29, 30, 35, 43};
		
		System.out.println(fun(a, 0, a.length-1, 28));
	}
	
	static int fun(int[] a, int low, int high, int key)
	{
		if(low > high)
			return Integer.MAX_VALUE;
		
		int mid = (low + high)/2;
		
		int left = Integer.MAX_VALUE;
		int right = Integer.MAX_VALUE;
		if(a[mid] == key)
			return a[mid];
		else if(key < a[mid])
		{
			left = fun(a, low, mid-1, key);
			return Math.abs(a[mid] - key) < Math.abs(left - key)?a[mid]:left; 
		}
		else
		{
			right = fun(a, mid+1, high, key);
			return Math.abs(a[mid] - key) < Math.abs(right - key)?a[mid]:right; 
		}
	}
}
