package Heaps;

import java.util.Arrays;

//http://www.geeksforgeeks.org/nearly-sorted-algorithm/
public class kmessed {
	public static void main(String[] args) {
//		int[] a = {4, 3, 1, 5, 2, 7, 6, 8, 9};
		int[] a = {2, 3, 6, 8, 12, 56};
		int k = 3;
		
//		print(a);
//		fun(a, k);
//		print(a);
		
		System.out.println("");
		MinHeapmethod(a, k);
	}
	
	/* heaps method */
	static void MinHeapmethod(int[] a, int k)
	{
		MinHeap heap = new MinHeap(Arrays.copyOfRange(a, 0, k+1));//0 to k is k+1 elements
		heap.build_min_heap();//no need to pass int[] a, as argument, be professional
		
		for(int i = k+1;i<a.length;i++)//doing the logic from the k+1th element till the end
		{
			a[i-(k+1)] = heap.extract_max_and_replace(a[i]); 
		}
		for(int i = 0;i<(k+1);i++)
		{
			a[a.length-(k+1)+i] = heap.extract_max_and_replace(Integer.MAX_VALUE);
		}
		print(a);
		print(heap.a);
	}
	
	/* Insertion sort method */
	static void fun(int[] a, int k)
	{
		System.out.println("Note that : we're not using k anywhere in this method, it's a property of the array");
		for(int i = 1;i<a.length;i++)
		{
			int temp = a[i];
			int j =i-1;
			while( (j>= 0) && (temp < a[j]) )
			{
				a[j+1] = a[j];
				j--;
			}
			a[j+1] = temp;
		}
	}
	
	static void print(int[] a)
	{
		for(int i = 0;i<a.length;i++)
			System.out.print(a[i] + " ");
		System.out.println("");
	}
}

class MinHeap extends kmessed
{
	int[] a;
	
	public MinHeap(int[] a) {
		// TODO Auto-generated constructor stub
		this.a = a;
	}
	
	public void build_min_heap()
	{
		for(int i = ((a.length-1)/2)-1;i>=0;i--)
		{
			heapify(a, i);
		}
		//super.print(a);
	}
	public void heapify(int[] a, int i)
	{
		int left = i*2 + 1;
		int right = i*2 + 2;
		int next = i;
		
		if( (left < a.length) && (a[left] < a[i]) )
			next = left;
		if( (right < a.length) && (a[right] < a[next]) )
			next = right;
		
		if(next != i)
		{
			int t = a[next];
			a[next] = a[i];
			a[i] = t;
			heapify(a, next);
		}		
	}
	
	public int extract_max_and_replace(int key)
	{
		int temp = a[0];
		a[0] = key;
		heapify(a, 0);
		
		return temp;
	}
}