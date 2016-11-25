package Recursion;

public class Magicindexinarray { 
	public static void main(String[] args) {
		int[] a = {-10, -5, 2, 2, 2, 3, 4, 7, 9, 12, 13};
		
		System.out.println(fun(a, 0, a.length-1));
	}
	
	static int fun(int[] a, int low, int high)
	{
		if(low > high || low < 0 || high >= a.length)
			return -1;
		
		int mid = (low + high)/2;
		
		if(a[mid] == mid)
			return mid;
		
		else
		{
			int left = fun(a, low, Math.min(mid-1, a[mid]));
			if(left > 0)
				return left;
			
			int right = fun(a, Math.max(mid+1, a[mid]), high);
			if(right > 0)
				return right;
			return -1;
		}
	}
}
