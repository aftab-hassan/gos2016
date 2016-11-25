package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Graph {
	ArrayList<Vertex> vertices;
	
	public Graph() {
		// TODO Auto-generated constructor stub
		vertices = new ArrayList<Vertex>();
	}
	
	public void addvertices(String vertexname)
	{
		vertices.add(new Vertex(vertexname));
	}
	
	public void addedges(String from, String to)
	{
		Vertex fromvertex = null;
		Vertex tovertex = null;
		
		for(int i = 0;i<vertices.size();i++)
		{
			if(vertices.get(i).name.equals(from))
				fromvertex = vertices.get(i);
			
			if(vertices.get(i).name.equals(to))
				tovertex = vertices.get(i);
		}
		
		fromvertex.neighbors.add(tovertex);
	}
	
	public void displayedges()
	{
		for(int i = 0;i<vertices.size();i++)
		{
			System.out.println("Vertex : "+vertices.get(i) + ", Adjacency list : "+vertices.get(i).neighbors);
		}
	}
	
	/* BFS */
	public void breadthfirstsearch()
	{
		System.out.println("Printing breadthfirstsearch...");
		Queue<Vertex> myQueue = new LinkedList<Vertex>();
		
		for(int i = 0;i<vertices.size();i++)
		{
			if(vertices.get(i).isVisited == false)
			{
				vertices.get(i).isVisited = true;
				System.out.println(vertices.get(i).name + " ");
				myQueue.add(vertices.get(i));
				breadthfirstsearchDriver(myQueue);
			}
		}
		System.out.println("");
	}
	public void breadthfirstsearchDriver(Queue<Vertex> myQueue)
	{
		while(myQueue.size() > 0)
		{
			Vertex current = myQueue.poll();
			for(int i = 0;i<current.neighbors.size();i++)
			{
				if(current.neighbors.get(i).isVisited == false)
				{
					current.neighbors.get(i).isVisited = true;
					System.out.println(current.neighbors.get(i).name + " ");
					myQueue.add(current.neighbors.get(i));
				}
			}	
		}
	}
	
	/* depth first search iterative */
	public void depthfirstsearchiterative()
	{
		System.out.println("Printing depthfirstsearchiterative...");
		Stack<Vertex> myStack = new Stack<Vertex>();
		for(int i = 0;i<vertices.size();i++)
		{
			if(vertices.get(i).isVisited == false)
			{
				vertices.get(i).isVisited = true;
				myStack.push(vertices.get(i));
				depthfirstsearchiterativeDriver(myStack);
			}
		}
		System.out.println("");
	}
	public void depthfirstsearchiterativeDriver(Stack<Vertex> myStack)
	{
		while(myStack.size() > 0)
		{
			Vertex vertex = myStack.pop();
			System.out.println(vertex + " ");
			
			for(int i = 0;i<vertex.neighbors.size();i++)
			{
				if(vertex.neighbors.get(i).isVisited == false)
				{
					vertex.neighbors.get(i).isVisited = true;
//					System.out.println(vertex.neighbors.get(i) + " ");
					myStack.push(vertex.neighbors.get(i));
				}
			}
		}
	}
	
	/* dfsusingstack */
	public void dfsusingstack()
	{
		System.out.println("Printing dfsusingstack...");
		Stack<Vertex> myStack = new Stack<Vertex>();
		for(int i = 0;i<vertices.size();i++)
		{
			if(vertices.get(i).isVisited == false)
			{
				vertices.get(i).isVisited = true;
				myStack.push(vertices.get(i));
				dfsUsingStackUtil(myStack);
			}
		}
		System.out.println("");
	}
	public  void dfsUsingStackUtil(Stack<Vertex> stack)  
	 {    
	  while (!stack.isEmpty())  
	  {  
	   Vertex element=stack.pop();  
	   System.out.print(element.name + " ");  
	  
	   ArrayList<Vertex> neighbours=element.neighbors;  
	   for (int i = 0; i < neighbours.size(); i++) {  
	    Vertex n=neighbours.get(i);  
	    if(n!=null && !n.isVisited)  
	    {  
	     stack.add(n);  
	     n.isVisited=true;  
	    }  
	   }  
	  }  
	 }  

	/* depth first search recursive */
	public void depthfirstsearchrecursive()
	{
		for(int i = 0;i<vertices.size();i++)
		{
			if(vertices.get(i).isVisited == false)
			{
				vertices.get(i).isVisited = true;
				System.out.println(vertices.get(i).name + " ");
				depthfirstsearchrecursiveDriver(vertices.get(i));
			}
		}
	} 
	public void depthfirstsearchrecursiveDriver(Vertex v)
	{
		for(int i = 0;i<v.neighbors.size();i++)
		{
			if(v.neighbors.get(i).isVisited == false)
			{
				v.neighbors.get(i).isVisited = true;
				System.out.println(v.neighbors.get(i).name + " ");
				depthfirstsearchrecursiveDriver(v.neighbors.get(i));
			}
		}
	}
	
	/* topological sort recursive */
	public void topologicalsortrecursive()
	{
		Stack<Vertex> output = new Stack<Vertex>();
		for(int i = 0;i<vertices.size();i++)
		{
			if(vertices.get(i).isVisited == false)
			{
				vertices.get(i).isVisited = true;
				topologicalsortrecursiveDriver(vertices.get(i), output);
				
//				System.out.println(vertices.get(i).name + " ");
				output.push(vertices.get(i));
			}
		}
	} 
	public void topologicalsortrecursiveDriver(Vertex v, Stack<Vertex> output)
	{
		for(int i = 0;i<v.neighbors.size();i++)
		{
			if(v.neighbors.get(i).isVisited == false)
			{
				v.neighbors.get(i).isVisited = true;
				topologicalsortrecursiveDriver(v.neighbors.get(i), output);
				
//				System.out.println(v.neighbors.get(i).name + " ");
				output.push(v.neighbors.get(i));
			}
		}
	}
	
}

class Vertex
{
	String name;
	ArrayList<Vertex> neighbors;
	boolean isVisited;
	
	public Vertex(String name)
	{
		this.name = name;
		neighbors = new ArrayList<Vertex>();
		this.isVisited = false;
	}
	
//	@Override
//	public boolean equals(Object o)
//	{
//		if(this.name.equals(( (Vertex)o).name ))
//			return true;
//		return false;
//	}
//	
//	@Override
//	public int hashCode()
//	{
//		return 31*Integer.parseInt(name);
//	}
	
	@Override
	public String toString()
	{
		return this.name;
	}
}