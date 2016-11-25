package javaaftab.PriorityQueueTrial;

public class Car implements Comparable<Car>
{
	String regno;
	int price;
	
	/* constructors */
	public Car(String regno, int price)
	{
		this.regno =regno;
		this.price = price;
	}
	
	public Car(String regno)
	{
		this.regno = regno;
//		this.setprice((int)Math.random()*100);
		int setting = (int)(Math.random()*100);
		System.out.println("regno=="+regno+",settting == "+setting);
		this.price = setting;
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
		if(o != null && o instanceof Car)
		{
			if( ((Car)o).regno.equals(this.regno) )
				return true;
		}
		return false;
	}
	public int hashCode()
	{
//		return this.price*31;
		return this.regno.hashCode();
	}
	
	/* Natural ordering */
//	@Override
	public int compareTo(Car o)
	{		
		if(this.price < o.price)
			return -1;
		return 1;
	}

	@Override
	public String toString()
	{
		return this.regno + ":" + this.price;
	}
}