/*
 * dijkstras.java
 * 
 * Copyright (c) 2016 by General Electric Company. All rights reserved.
 * 
 * The copyright to the computer software herein is the property of
 * General Electric Company. The software may be used and/or copied only
 * with the written permission of General Electric Company or in accordance
 * with the terms and conditions stipulated in the agreement/contract
 * under which the software has been supplied.
 */
package Graphs;

/**
 * @author aftabhassan
 */
public class Dijkstra {

    /**
     * @param args
     */
    public static void main( String[] args ) {
        // TODO Auto-generated method stub
        /* Let us create the example graph discussed above */
        int graph[][] = new int[][] {{0, 4, 0, 0, 0, 0, 0, 8, 0},
                                     {4, 0, 8, 0, 0, 0, 0, 11, 0},
                                     {0, 8, 0, 7, 0, 4, 0, 0, 2},
                                     {0, 0, 7, 0, 9, 14, 0, 0, 0},
                                     {0, 0, 0, 9, 0, 10, 0, 0, 0},
                                     {0, 0, 4, 14, 10, 0, 2, 0, 0},
                                     {0, 0, 0, 0, 0, 2, 0, 1, 6},
                                     {8, 11, 0, 0, 0, 0, 1, 0, 7},
                                     {0, 0, 2, 0, 0, 0, 6, 7, 0}};

        Dijkstra dijkstra = new Dijkstra();
        int[] output = dijkstra.dijkstraDriver( graph, 0 );
        dijkstra.print( output );
    }

    public int[] dijkstraDriver( int[][] graph, int src ) {
        int V = graph[0].length;

        int[] distance = new int[graph.length];
        for ( int i = 0; i < graph[0].length; i++ )
            distance[i] = (graph[src][i] > 0) ? graph[src][i] : Integer.MAX_VALUE;
        boolean[] shortestfound = new boolean[graph.length];

        distance[src] = 0;
        shortestfound[src] = true;

        return dijkstraUtil( graph, src, distance, shortestfound, V );
    }

    public int[] dijkstraUtil( int[][] graph, int src, int[] distance, boolean[] shortestfound, int V ) {

        int u = findMinDistance( distance, shortestfound );
        if ( u == -1 )
            return distance;
        shortestfound[u] = true;

        for ( int v = 0; v < V; v++ ) {
            if ( shortestfound[v] == false && graph[u][v] != 0 && distance[u] + graph[u][v] < distance[v] )
                distance[v] = distance[u] + graph[u][v];
        }

        return dijkstraUtil( graph, u, distance, shortestfound, V );
    }

    public int findMinDistance( int[] a, boolean[] shortestfound ) {
        int min = Integer.MAX_VALUE;
        int minIndex = -1;
        for ( int i = 0; i < a.length; i++ ) {
            if ( a[i] < min && shortestfound[i] == false ) {
                min = a[i];
                minIndex = i;
            }
        }

        return (min == Integer.MAX_VALUE) ? -1 : minIndex;
    }

    public void print( int[] a ) {
        for ( int i = 0; i < a.length; i++ )
            System.out.print( a[i] + " " );
        System.out.println( "" );
    }
}
