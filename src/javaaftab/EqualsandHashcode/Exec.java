package javaaftab.EqualsandHashcode;

import java.util.HashSet;
import java.util.Hashtable;

/* Notes 
 * public boolean equals(Object obj)
	{
		return (this == obj);
	}
 * */


/* Code based on
 * https://www.youtube.com/watch?v=ghswNpRv2t0 - equals and hashCode 101
 * https://www.youtube.com/watch?v=V-vDUbK6wm0 - timing issue
 * 
 * Some more useful tips especially regarding developing a hashCode function if there are multiple arguments passed
 * https://www.youtube.com/watch?v=fAlRR2p9Le0
 * 
 * overriding toString() method - Ranjith Ramachandran
 * https://www.youtube.com/watch?v=IwUwIrz9Ge8
 * 
 * Need for equals and hashCode
 * ----------------------------
 * 1. The implementation of equals and hashCode is really important because certain methods like contains use it
 *    For example, you want to check if a Car exists based on it's name,
 *    or you want to check if a Car of a particular price exists
 * 2. Also important to improve the performance of Collections
 * */
public class Exec {
	public static void main(String[] args) {
		/* Student */
		Student s1 =  new Student("123");
		Student s2 =  new Student("123");
		
		/* Making duplicate entries with the same name */
		System.out.println(s1.equals(s2));
		Hashtable<Student, Boolean> myHashtable = new Hashtable<Student, Boolean>();
		myHashtable.put(s1, true);
		myHashtable.put(s2, true);
		System.out.println(myHashtable.size());
		
		/* Showing difference in timing if hashCode method is not correctly overridden */
		System.out.println("");
		System.out.println("timing check");
		HashSet<Student> myStudents = new HashSet<>();
		for(int i = 0;i<100;i++)
			myStudents.add(new Student("aftab"+i));
		System.out.println(myStudents.size());
		long startTime = System.nanoTime();
		System.out.println(myStudents.contains(new Student("aftab1")));
		System.out.println("Time elapsed == "+ (System.nanoTime() - startTime));
		System.out.println("");
		
		/* Showing overriding toString() method */
		System.out.println(s1);
	}
}
