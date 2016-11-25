package Array;

public class mindiffbetweentwoarrays{
	public static void main(String[] args) {
		int[] a = {1,2,9,15,25};
		int[] b = {4,10,19};
		
		fun(a, b);
	}
	
	static void fun(int[] a, int[] b)
	{
		Entry[] ea = new Entry[a.length];
		Entry[] eb = new Entry[b.length];
		for(int i = 0;i<a.length;i++)
		{
			ea[i] = new Entry(a[i], "a");
		}
		for(int i = 0;i<b.length;i++)
		{
			eb[i] = new Entry(b[i], "b");
		}
		
		Entry[] ec = new Entry[a.length + b.length];
		for(int i = 0;i<ea.length;i++)
			ec[i] = ea[i];
		for(int i = 0;i<eb.length;i++)
			ec[i+a.length] = eb[i];
		
		/* sorting the array */
		for(int i = 0;i<ec.length;i++)
		{
			for(int j = 0;j<ec.length-1;j++)
			{
				if(ec[j].val >ec[j+1].val)
				{
					Entry temp = ec[j];
					ec[j+1] = ec[j];
					ec[j] = temp;
				}
			}
		}
		
		int min = Integer.MAX_VALUE;
		int index = 1;
		for(int i = 1;i<ec.length;i++)
		{
			if( (Math.abs(ec[i].val-ec[i-1].val) < min) && (ec[i].name!=ec[i-1].name) )
			{
				min = Math.abs(ec[i].val-ec[i-1].val);
				index = i;
			}
		}
	}
}

class Entry
{
	int val;
	String name;
	
	public Entry(int val, String name)
	{
		this.val = val;
		this.name = name;
	}
}
