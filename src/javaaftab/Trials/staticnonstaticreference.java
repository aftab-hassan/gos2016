package javaaftab.Trials;

/*If a non static method has to be used inside a static method, object creation is compulsory.
 *If a non static method has to be used inside a non-static method, object creation is not necessary
 *(Because the non-static method is called using an object, and it will assume it's the same object)
 * 
 *Whether a static method is used inside a static or non-static method, object creation is not necessary  
 */
public class staticnonstaticreference {
	String name;
	int grades;
	
	/* Using static method inside static method */
	public static void main(String[] args) {
		grade();
	}

	/* Using static method inside non-static method */
	public void write()
	{
		grade();
	}
	
	/* Using non-static method inside static method */
	static void grade()
	{
		//write();
	}
	
	/* Using non-static method inside non-static method */
	public void correct()
	{
		write();
	}
}

class Test
{
	
}
