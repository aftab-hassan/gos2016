/*
 * Driver.java
 * 
 * Copyright (c) 2016 by General Electric Company. All rights reserved.
 * 
 * The copyright to the computer software herein is the property of
 * General Electric Company. The software may be used and/or copied only
 * with the written permission of General Electric Company or in accordance
 * with the terms and conditions stipulated in the agreement/contract
 * under which the software has been supplied.
 */
package Graphs.minimummaximum_hops_between_2nodes;
/**
 * @author aftabhassan
 *
 */
public class Driver {

    /**
     * @param args
     */
    public static void main( String[] args ) {
        // TODO Auto-generated method stub

        Graph graph = new Graph();
        
        /* adding vertices */
        graph.addVertex( "A" );
        
        graph.addVertex( "B" );
        graph.addVertex( "C" );
        graph.addVertex( "D" );
        
        graph.addVertex( "E" );
        graph.addVertex( "F" );
        
        graph.addVertex( "G" );
        
        graph.addVertex( "H" );
        
        graph.addVertex( "I" );
        
        /* adding edges */
        graph.addEdge( "A", "B" );
        graph.addEdge( "A", "C" );
        graph.addEdge( "A", "D" );
        
        graph.addEdge( "B", "E" );
        graph.addEdge( "C", "F" );
        
        graph.addEdge( "E", "G" );
        graph.addEdge( "G", "H" );
        graph.addEdge( "H", "I" );
        
        graph.addEdge( "F", "H" );
        graph.addEdge( "D", "H" );
        
        graph.addEdge( "E", "B" );
        graph.addEdge( "G", "E" );
        
        graph.addEdge( "H", "G" );
        
        System.out.println( BFS2Queues.distBFS2Queues( graph.getVertex( "A" ), graph.getVertex( "I" ) ) );
        for(String vertexName : graph.vertices.keySet()){graph.vertices.get(vertexName).visited = false;}
        
        System.out.println( BFSHashtable.distBFSHashtable( graph.getVertex( "A" ), graph.getVertex( "I" ) ) );
        for(String vertexName : graph.vertices.keySet()){graph.vertices.get(vertexName).visited = false;}
        
        System.out.println( Backtracking.Backtracking_EarlierusedtocallDFS( graph.getVertex( "A" ), graph.getVertex( "I" ) ) );
        for(String vertexName : graph.vertices.keySet()){graph.vertices.get(vertexName).visited = false;}
        
        System.out.println( TODO_BacktrackingExplicitStack.DFSExplicitStack( graph.getVertex( "A" ), graph.getVertex( "I" ) ) );
        for(String vertexName : graph.vertices.keySet()){graph.vertices.get(vertexName).visited = false;}
    }

}
