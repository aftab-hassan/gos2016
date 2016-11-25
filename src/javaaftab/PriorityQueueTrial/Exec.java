package javaaftab.PriorityQueueTrial;

import java.util.HashSet;
import java.util.PriorityQueue;

/*Notes
 * java9s : https://www.youtube.com/watch?v=TXU44xVc6gY
 * 1. Priority queue places elements in the appropriate position based on the sorting criteria
 * 2. This order is called Natural ordering
 * 3. - Natural ordering - Natural ordering is nothing but the logic implemented in the compareTo method
 * public int compareTo(T t)
 *    - Natural order == comparator
 * {
 * 
 * }
 * 4. Methods that Pqueue implements - offer(), peek(), poll(), clear
 * 5. Car is implementing the Comparable interface which means that I have to implement the compareTo method
 * 6. Above the compareTo method implementation, try to comment as 'Natural ordering of Car instances'
 * 7. Written in the documentation of Priority Queue that iterator of PQ does not essentially
 *    retrieve the elements in the same order that PQ maintains internally.
 *    - PQ is storing correctly, it's the iterator's fault
 *    - The iterator has it's own way of picking out elements
 * 8. Priority queue is not thread safe, that means, multiple threads can
 *    manipulate this Priority Queue, and you have to use a PQ with caution when you
 *    application has multiple threads and could manipulate this collection
 *    
 *    -So, it's important to get a thread-safe instance to ensure that elements getting added 
 *    or removed are part of a synchronized block
 *    -So, to do that, you can actually get the PQ instance using the collections utility class
 *    -PriorityQueue<Car> tsafePQ = (PriorityQueue<Car>)Collections.synchronizedCollection(new PriorityQueue<Car>());
 *    
 * 9. Awesome video - showing the relation between a heap and a PQ - https://www.youtube.com/watch?v=1mm1I40cniQ
 * 10.So, in a priority queue, add and poll both work based on compareTo method
 * 12.Postpone links
 * 	  https://www.youtube.com/results?search_query=priority+queue+java
 *    https://www.youtube.com/watch?v=JSvVsOm4oX0
 *    https://www.youtube.com/watch?v=E8NaqgB3nac - durgasoft
 *    https://www.youtube.com/watch?v=Xy2PqCNgFig
 *    https://www.youtube.com/watch?v=oT973Y-IiMA
 *    https://www.youtube.com/watch?v=nr7ll04J2rI
 *    https://www.youtube.com/watch?v=091U2x3rp0o
 *    https://www.youtube.com/watch?v=qBRBAqA25o8
 *    https://www.youtube.com/watch?v=CO3LE9j9lV4
 *    https://www.youtube.com/watch?v=L4TfytB9e9Q
 *    https://www.youtube.com/watch?v=QYvUmIYgsiA
 *    https://www.youtube.com/watch?v=AU07jJc_qMQ
 *    https://www.youtube.com/watch?v=0xrhqxTOphI - telusko
 *    
 *    https://www.youtube.com/watch?v=TXU44xVc6gY
 *    https://www.youtube.com/watch?v=1mm1I40cniQ
 *    https://www.youtube.com/watch?v=c4ES6jGxqEw
 *    https://www.youtube.com/watch?v=hj9lOSJCy-U
 *    
 *    https://www.youtube.com/watch?v=j5ij59EjPh0
 *    https://www.youtube.com/watch?v=HI97KDV23Ig
 * 13.Comparable, Comparator both are interfaces
 *    Comparable - compareTo
 *    Comparator - compare
 * 14.Regarding order in the compareTo method
 *    If current instance should come before, -ve required
 *    If current instance should come after, +ve required
 *    Else, 0 required
 * 15.How compareTo works
 *    return 1  : means swapping required
 *    return -1 : no swapping required
 *    golden explanation : Telusko https://www.youtube.com/watch?v=0xrhqxTOphI
 *    Also golden        : https://youtu.be/JSvVsOm4oX0?t=1098
 * 16.Aftab awesomeness
 *    -For compare   : think your array looks like {o1  ,  o2}   
 *    -For compareTo : think your array looks like {this,  o}
 *    public int compare(Car o1, Car o2)
 *    {
 *     {o1, o2}
 *    }
 *    public int compareTo(Car o)
 *    {
 *     {this, o}
 *    }
 *    
 *    So, to sort in ascending order would looks like
 *    if(o1.price < o2.price)
 *    	return -1;//don't do anything
 *    return 1;//swap
 *    
 *    if(this.price < o.price)
 *    	return -1;//don't do anything
 *    return 1;//swap
 *    
 *    To sort - such that all even prices first, then odd prices
 *    public int compare(Car o1, Car o2)
 *    {
 *     if(o1.price%2 == 1 && o2.price%2 == 0)
 *      return 1;
 *     return -1;//even odd, odd odd, even even don't have to do anything
 *    }
 *    
 *    public int compare(Car o)
 *    {
 *     if(this.price %2 == 1 && o.price%2 == 0)
 *      return 1;
 *     return -1;
 *    }
 * */
public class Exec {
	public static void main(String[] args) {
		
//		/* 1. adding */
//		HashSet<Car> myHashSet = new HashSet<Car>();
//		for(int i = 0;i<100;i++)
//		{
//			myHashSet.add(new Car("H"+i));
//		}
//		/* 2. printing */
//		print(myHashSet);
//		
//		/* 3.contains */
//		System.out.println(myHashSet.contains(new Car("H19")));
		
		/* 4. making an array and sort based on regno */
//		Car[] allcars = new Car[100];
//		for(int i = 0;i<100;i++)
//			allcars[i] = new Car("H"+i);
//		Arrays.sort(allcars);
//		System.out.println(allcars);
		
		/* 5. Priority queue */
		PriorityQueue<Car> myPriorityQueue = new PriorityQueue<Car>();
		for(int i = 0;i<5;i++)
			myPriorityQueue.add(new Car("H"+i));
		System.out.println(myPriorityQueue);
		for(int i = 0;i<5;i++)
		{
			Car car = myPriorityQueue.poll();
			System.out.println("removed:"+car.regno + "-" + car.price );
			System.out.println(myPriorityQueue);
		}
			
		
		System.out.println(myPriorityQueue);
	}
	
	static void print(HashSet<Car> myHashSet)
	{
		for(Car car : myHashSet)
			System.out.println(car.regno);
	}
}

