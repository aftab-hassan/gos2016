package Array;

public class rangetosort {
	public static void main(String[] args)
	{
//		int[] a = {1, 2, 3, 4, 9, 7, 10, 8, 6, 11, 12, 13, 14, 15, 16};
		int[] a = {1, 2, 3, 4, 5, 11, 10, 9, 8, 7, 6, 12, 13, 14, 15, 16};
		int[] output = fun(a);
		System.out.println("{"+output[0]+","+output[1]+"}");
	}
	
	static int[] fun(int[] a)
	{
		int[] output = new int[2];
		
		int left = 1;
		for(left = 1;left<a.length;left++)
		{
			if(a[left] < a[left-1])
				break;
		}
		
		if(left == a.length)
		{
			output[0]=output[1]=-1;
			return output;
		}
			
		int right = a.length-2;
		for(right = a.length-2;right>=0;right--)
		{
			if(a[right] > a[right+1])
				break;
		}
		
		int min = left;
		int max = left;
		for(int i = left;i<= right;i++)
		{
			if(a[i] < a[min])
				min = i;
			if(a[i] > a[max])
				max = i;
		}

		for(int k = left-1;k>=0;k--)
		{
			if(a[k] > a[min])
			{
				output[0] = k;
				break;
			}
		}
		for(int k = right+1;k<a.length;k++)
		{
			if(a[k] < a[max])
			{
				output[1] = k;
				break;
			}
		}
		
		return output;
	}
}
