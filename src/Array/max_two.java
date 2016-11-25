package Array;

import java.util.Arrays;

public class max_two {
	public static void main(String[] args) {
		int[] a = {6,3,6};
		int[] output = max_two(a);
		
		System.out.println(output[0] + ", " + output[1]);
	}
	
	static int[] max_two(int[] a) {
		
		int[] temp = new int[a.length];
		copy(a, temp);
		
		int[] output = new int[2];
		int max=  0;
		for(int i = 0;i<a.length;i++)
		{
			for(int j = i+1;j<=a.length;j++)
			{
				copy(temp, a);
				
				int[] sorted = Arrays.copyOfRange(a, i, j);
				Arrays.sort(sorted);
				reverse(sorted);
				
				if(sorted.length>=2)
				{
					if( (sorted[0]&sorted[1]) > max)
					{
						max = sorted[0]&sorted[1];
						output[0] = i;
						output[1] = j-1;
					}		
				}
					
			}
		}
		
		
		return output;
    }
	
	static void reverse(int[] a)
	{
		int j = a.length-1;
		int i = 0;
		while(i < j)
		{
			int temp = a[i];
			a[i] = a[j];
			a[j] = temp;
			
			i++;
			j--;
		}
	}
	
	static void copy(int[] source, int[] destination)
	{
		for(int i = 0;i<source.length;i++)
			destination[i] = source[i];
	}
}
