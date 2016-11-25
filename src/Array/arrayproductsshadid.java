package Array;

import java.util.Arrays;

/* https://www.pramp.com/question/7Lg1WA1nZqfoWgPbgM0M */
public class arrayproductsshadid {
	public static void main(String[] args) {
		int[] a = {2,7,3,4};
		print(arrayproducts(a));
	}
	
	static int[] arrayproducts(int[] a)
	{
		int[] output = new int[a.length];Arrays.fill(output, 1);
		
		//filling left
		for(int i = 1;i<a.length;i++)
			output[i] = output[i-1]*a[i-1];
			
		//filling right
		int right = 1;
		for(int i = a.length-2;i>=0;i--)
		{
			right = right * a[i+1];
			output[i] = output[i]*right;
		}

		return output;
	}
	
	static void print(int[] a)
	{
		for(int i = 0;i<a.length;i++)
			System.out.print(a[i] + " ");
		System.out.println("");
	}
}
