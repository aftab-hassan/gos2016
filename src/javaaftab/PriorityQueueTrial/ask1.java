package javaaftab.PriorityQueueTrial;

public class ask1
{
	String regno;
	int price;
	
	/* constructors */
	public ask1(String regno, int price)
	{
		this.regno =regno;
		this.price = price;
	}
	
	public ask1(String regno)
	{
		this.regno = regno;
	}
	
	/* getter */
	public String getregno()
	{
		return this.regno;
	}
	
	public int getprice()
	{
		return this.price;
	}
	
	/* setter */
	public void setregno(String regno)
	{
		this.regno = regno;
	}
	
	public void setprice(int price)
	{
		this.price = price;
	}
	
	/* equals and hashCode */
	public boolean equals(Object o)
	{
		if(o != null && o instanceof ask1)
		{
			if( ((ask1)o).regno == this.regno )
				return true;
		}
		return false;
	}
	public int hashCode()
	{
		return this.price*31;
	}
	
	/* Natural ordering */
	public int compareTo(Object o)
	{ 
//		switch( val )
//		{
//		case (val > 0):
//			return 1;
//		
//		}
//		return 1;
		
		if(((ask1)o).price > this.price)
			return 1;
		else if(((ask1)o).price == this.price)
			return 0;
		return -1;
	}
}