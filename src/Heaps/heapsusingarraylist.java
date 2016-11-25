package Heaps;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class heapsusingarraylist {
	public static void main(String[] args) throws IOException{
		MaxHeap heap = new MaxHeap();
		
		/* insert */
		Scanner stdin = new Scanner(new FileReader("C:\\Users\\aftab\\workspace\\GoogleOnSite\\src\\heaps\\input.txt"));
		while(stdin.hasNext())
		{
			heap.insert(stdin.nextInt());
			heap.print();
		}
		
		/* remove */
		System.out.println("Element removed == "+ heap.remove());
		heap.print();
		
//		/* build heap */
//		heap.setdefault();
//		heap.build_heap();
//		heap.print();
	}	
}

class MaxHeap
{
	ArrayList<Integer> heap;
	
	public MaxHeap()
	{
		heap = new ArrayList<Integer>();
	}
	
	public void setdefault()
	{
		heap.add(4);heap.add(1);heap.add(5);heap.add(3);
		heap.add(2);heap.add(7);heap.add(6);
	}
	
	public void insert(int val)
	{
		heap.add(val);
		int cur = heap.size()-1;
		int parent = (cur-1>>1);
		
		while( parent>=0 && (heap.get(cur) > heap.get(parent)) )
		{
			swap(cur, parent);
			cur = parent;
			parent  = (cur-1>>1);
		}
	}
	
	/* build_heap is a O(n . logn) process, which due to the following math is a O(n) process */
	public void build_heap()
	{		
		for(int i = ((heap.size()-1)/2)-1 ;i>=0;i-- )
		{
			heapify(i);
		}
	}
	/* Remember : heapify is a O(log n) process */
	public void heapify(int i)
	{
		int next = i;
		int left = 2*i + 1;
		int right = 2*i + 2;
		if( left<heap.size() && (heap.get(i) < heap.get(left)) )
			next = left;
		if( right < heap.size() && (heap.get(next) < heap.get(right)) )
			next = right;
		
		if(next != i)
		{
			swap(i, next);
			heapify(next);
		}
			
	}
	
	public void swap(int cur, int parent)
	{
		int t = heap.get(cur);
		heap.set(cur, heap.get(parent));
		heap.set(parent, t);
	}
	
	public void print()
	{
		System.out.println(heap);
	}
	
	/* This is a sift down operation */
	public int remove()
	{
		int next = 0;
		int previousroot = heap.get(0);
		heap.set(0, heap.get(heap.size()-1));
		heap.remove(heap.size()-1);
		
		heapify(0);
		
		/* The below lines are not required. removing from a heap is an O(log n) operation because
		 * if the element on the left > element on the right, ie 1>2, then everything in the left sub heap
		 * will surely be greater than everything on the right */
//		for(int i = heap.size()-1;i>=0;i--)
//			heapify(i);
		
		return previousroot;
	}
}
