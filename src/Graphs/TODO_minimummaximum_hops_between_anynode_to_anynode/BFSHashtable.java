package Graphs.TODO_minimummaximum_hops_between_anynode_to_anynode;

import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Queue;

public class BFSHashtable {

	/* Breadth First Search */
    static public int distBFSHashtable(Vertex source, Vertex destination)
    {
        /* Everything in the queue will be unique, because if, already visited, I don't push into queue.
         * Also, at the time of pushing itself, I made it's visited to be true */
        Queue<Vertex> toprocess = new LinkedList<>();
        
        toprocess.add( source );
        source.visited = true;
        
        /* This table gives the distance of each vertex from source */
        Hashtable<Vertex, Integer> distanceTable = new Hashtable<>();
        distanceTable.put( source, 0 );
        
        while(toprocess.size() > 0 )
        {
            Vertex current = toprocess.poll();
          
            for(int i = 0;i<current.neighbors.size();i++)
            {
                Vertex neighbor = current.neighbors.get( i );
//                distanceTable.put( neighbor, distanceTable.get( current )+1 );
              
                if(neighbor.visited == false)
                {
                    neighbor.visited = true;
                    toprocess.add( neighbor );
                    distanceTable.put( neighbor, distanceTable.get( current )+1 );
                }
                
                if(neighbor == destination)
                    return distanceTable.get( neighbor );
            }
        }
        return -1;
    }
}
