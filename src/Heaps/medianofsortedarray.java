package Heaps;

import java.util.ArrayList;

public class medianofsortedarray {
	public static void main(String[] args) {
		ArrayList<Integer> al = new ArrayList<Integer>();
		al.add(1);
		al.add(4);
		al.add(3);
		al.add(2);
		al.add(5);
		al.add(6);
		al.add(7);
		al.add(8);
	}
	
	static void printMedian(ArrayList<Integer> al)
	{
		for(int i = 0;i<al.size();i++)
		{
			System.out.println();
		}
	}

}

class Heap
{
	ArrayList<Integer> data;
	int rootindex;
	int currentindex;
	boolean[] type;
	
	public Heap(ArrayList<Integer> data, int rootindex, int currentindex) {
		// TODO Auto-generated constructor stub
		this.data = data;
		this.rootindex = rootindex;
		this.currentindex = currentindex;
		this.type = new boolean[data.size()];//0 implies left max heap, 1 implies min right heap
	}
	
	public void build_min_heap()
	{
		for(int i = (currentindex-1)/2;i>=rootindex;i--)
		{
			min_heapify(this.data, i);
		}
	}
	
	public void min_heapify(ArrayList<Integer> data, int i)
	{
		int next = i;
		int left = (2*i)+1;
		int right = (2*i)+2;
		
		if( left <= currentindex && data.get(left) < data.get(i))
			next = left;
		if( right <= currentindex && data.get(right) < data.get(next))
			next = right;
		
		if(next != i)
			min_heapify(data, next);
	}
}
