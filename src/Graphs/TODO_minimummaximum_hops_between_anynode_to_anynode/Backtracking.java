package Graphs.TODO_minimummaximum_hops_between_anynode_to_anynode;

public class Backtracking {
	
	/* Depth First Search - This should not be called DFS, it shoule be called Backtracking */
    static public int Backtracking_EarlierusedtocallDFS(Vertex source, Vertex destination)
    {
        if(source == destination)
        {
            source.visited = false;
            return 0;
        }
            
        
        int min = Integer.MAX_VALUE-1;
        for(int i = 0;i<source.neighbors.size();i++)
        {
            Vertex neighbor = source.neighbors.get( i );
            if(neighbor.visited == false)
            {
                neighbor.visited = true;
                min = Math.min( min, Backtracking_EarlierusedtocallDFS( neighbor, destination )+1 );
            }
        }
        
        source.visited = false;
        return min;
    }
}
