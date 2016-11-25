package javaaftab.EqualsandHashcode;

public class Student {
	String regno;
	public Student(String regno)
	{
		this.regno = regno;
	}
	
	public String getregno()
	{
		return this.regno;
	}
	
	public void setregno(String regno)
	{
		this.regno = regno;
	}
	
	public boolean equals(Object o)
	{
		System.out.println("came inside my equals implementation");
		
		/* Object class' equals method looks like
		 * public boolea equals(Object obj)
		 * {
		 *  return (this==obj);
		 * }
		 * */
		
//		RED FLAG : Don't do this
//		return (((Student)o).regno == this.regno);
		
//		GREEN FLAG : Do this
//		if( (((Student)o).regno).equals(this.regno) )
//			return true;
//		return false;
		
//		DARK GREEN FLAG : Ideal way
		if(o!=null && o instanceof Student)
		{
			if( ((Student)o).regno != null && ((Student)o).regno.equals(this.regno) )
				return true;
		}
		return false;
	}
	
	public int hashCode()
	{
		return this.regno.hashCode();
//		return 1;
		
		/* If there are multiple parameters, you can do anything, say, like below - https://youtu.be/fAlRR2p9Le0?t=760
		 * 
		 * return 12 * contactId + name.hashCode() + phoneNumber.hashCode();
		 * */
		
	}
	
//	public String toString()
//	{
//		return this.regno + " ";
//	}
}
