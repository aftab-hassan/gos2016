package Graphs.shortest_distance_between_2_nodes;

import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/*
 * Graph.java
 * 
 * Copyright (c) 2016 by General Electric Company. All rights reserved.
 * 
 * The copyright to the computer software herein is the property of
 * General Electric Company. The software may be used and/or copied only
 * with the written permission of General Electric Company or in accordance
 * with the terms and conditions stipulated in the agreement/contract
 * under which the software has been supplied.
 */

/**
 * @author aftabhassan
 *
 */
public class Graph {
    Hashtable<String,Vertex> vertices;
    
    /**
     * 
     */
    public Graph() {
        // TODO Auto-generated constructor stub
        vertices = new Hashtable<String, Vertex>();
    }
    
    public void addVertex(String name)
    {
        vertices.put( name, new Vertex( name ) );
    }
    
    public void addEdge(String from, String to)
    {
        vertices.get( from ).neighbors.add( vertices.get( to ) );
    }
    
    public Vertex getVertex(String name)
    {
        return vertices.get( name );
    }
    
    /* Breadth First Search */
    public int distBFSHashtable(Vertex source, Vertex destination)
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
    
    public int distBFS2Queues(Vertex source, Vertex destination)
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
    
    /* Depth First Search */
    public int DFSrecursive(Vertex source, Vertex destination)
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
                min = Math.min( min, DFSrecursive( neighbor, destination )+1 );
            }
        }
        
        source.visited = false;
        return min;
    }
    
    public int DFSExplicitStack(Vertex source, Vertex destination)
    {
        Stack<Vertex> todo = new Stack<Vertex>();
        todo.add( source );
        
        /* This table gives the distance of each vertex from source */
        Hashtable<Vertex, Integer> distanceTable = new Hashtable<>();
        distanceTable.put( source, 0 );
        
        int distance = Integer.MAX_VALUE;
        
        while(todo.size() > 0)
        {
            Vertex current = todo.pop();
            
            for(int i = 0;i<current.neighbors.size();i++)
            {
                Vertex neighbor = current.neighbors.get( i );
                  
                if(!todo.contains( neighbor ))
                {
                    todo.push( neighbor );
                    distanceTable.put( neighbor, distanceTable.get( current ) + 1 );
                }
                
                if(neighbor == destination)
                {
                    distance = Math.min( distance, distanceTable.get( destination ) );
                }
                    
            }
        }
        
        return distance==Integer.MAX_VALUE?-1:distance;
    }
}
