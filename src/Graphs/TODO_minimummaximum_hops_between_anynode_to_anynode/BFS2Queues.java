package Graphs.TODO_minimummaximum_hops_between_anynode_to_anynode;

import java.util.LinkedList;
import java.util.Queue;

public class BFS2Queues {
	 static public int distBFS2Queues(Vertex source, Vertex destination)
	    {
	        Queue<Vertex> parent = new LinkedList<>();
	        Queue<Vertex> child = new LinkedList<>();
	        
	        parent.add( source );
	        source.visited = true;
	        
	        int hops = 0;
	        
	        while(parent.size() > 0)
	        {
	            Vertex current = parent.poll();
	            
	            for(int i = 0;i<current.neighbors.size();i++)
	            {
	                Vertex neighbor = current.neighbors.get( i );
	                
	                if(neighbor == destination)
	                    return hops + 1;
	                
	                if(neighbor.visited == false)
	                {
	                    neighbor.visited = true;
	                    child.add( neighbor );
	                }
	            }
	            
	            if(parent.size() == 0)
	            {
	                hops++;
	                parent.addAll( child );
	                child.clear();
	            }
	        }
	        
	        return -1;
	    }
}
