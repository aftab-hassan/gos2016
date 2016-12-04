package Graphs.TODO_minimummaximum_hops_between_anynode_to_anynode;

import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import Graphs.minimummaximum_hops_between_2nodes.Vertex;

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
}
