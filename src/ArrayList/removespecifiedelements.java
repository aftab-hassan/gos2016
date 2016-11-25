package ArrayList;

import java.util.ArrayList;

/* http://stackoverflow.com/questions/10714233/remove-item-from-arraylist */
public class removespecifiedelements {
	public static void main(String[] args) {
	    
		fun();
		
	}
	
	static void fun()
	{
		ArrayList<String> list = new ArrayList<String>();
		list.add("0");
		list.add("1");
		list.add("2");
		list.add("3");
		list.add("4");
		list.add("5");
		list.add("6");
		list.add("7");
		list.add("8");
		
		int i[] = {1,3,5};
			
		System.out.println("Initial : "+list);
		for (int j = i.length-1; j >= 0; j--) {
		    list.remove(i[j]);
		    System.out.println(list);
		}
	}
}
