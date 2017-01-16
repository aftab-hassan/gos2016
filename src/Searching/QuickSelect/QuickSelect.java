package Searching.QuickSelect;

public class QuickSelect {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/* http://www.geeksforgeeks.org/kth-smallestlargest-element-unsorted-array-set-2-expected-linear-time/ */
		int[] a = {1, 2, 3, 4, 11, 12, 13, 14, 5, 6, 15, 16, 17, 7, 8, 18, 19, 20, 9, 10};
//		int[] a = {2, 5,3,1, 4};
//		int[] a = {1, 2, 3, 4, 5, 6, 7, 8};
		for(int i = 0;i<a.length;i++)
		{
			int k = i+1;
			
			int pos = find(a, 0, a.length-1, k);
			System.out.println("k=="+k+",pos=="+pos+",element"+a[pos]);
		}
	}

	static int find(int[] a, int low, int high, int k)
	{
		int pivot = partition(a, low, high);
		
		if(pivot-low == k-1)
			return pivot;
		else if(pivot-low > k-1)
			return find(a, low, pivot-1, k);//not pivot+1, because if(pivot turns out to be k, that would've been caught in the if(pivot==k) condition above
		else//pivot-low < k-1
			return find(a, pivot+1, high, k-(pivot+1-low));
	}
	
	static int partition(int[] a, int low, int high)
	{
		int pivot = (low+high)/2;
		while(low < high)
		{
			while( a[low]<=a[pivot] && low < pivot )
				low++;
			while( a[high]>=a[pivot] && high > pivot )
				high--;
			
			if(low < high)
			{
				int temp = a[low];
				a[low] = a[high];
				a[high] = temp;
				
				if(low == pivot)
					pivot = high;
				else if(high == pivot)
					pivot = low;	
			}
		}
		return low;
	}
}