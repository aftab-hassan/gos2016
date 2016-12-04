/*
 * allways.java
 * 
 * Copyright (c) 2016 by General Electric Company. All rights reserved.
 * 
 * The copyright to the computer software herein is the property of
 * General Electric Company. The software may be used and/or copied only
 * with the written permission of General Electric Company or in accordance
 * with the terms and conditions stipulated in the agreement/contract
 * under which the software has been supplied.
 */
package Graphs.traverse_matrix_all_4_directions;

import java.util.Arrays;

/**
 * @author aftabhassan
 */
//http://stackoverflow.com/questions/40709283/count-paths-from-source-to-destination-in-a-matrix-moving-in-all-4-directions
public class allways {

    /**
     * @param args
     */
    public static void main( String[] args ) {
        // TODO Auto-generated method stub

         findWays2directionsDriver();
         findWays2directionsDPTableDriver();
         findWays2directionsDP_NO_RECURSIONDriver();
         findWays4directionsDriver();
        findWays4directionsLongestPathDriver();
        findWays4directionsShortestPathDriver();

    }

    /****************************************************************************************************************/
    /****************************************************************************************************************/
    /****************************************************************************************************************/
    /* Utils */
    static int findWays4directionsShortestPath( int[][] a, int i, int j, boolean[][] visited ) {
        if ( i < 0 || j < 0 || i == a.length || j == a[0].length )
            return Integer.MAX_VALUE-1;

        if ( i == a.length - 1 && j == a[0].length - 1 )
            return 1;

        if ( visited[i][j] == true )
            return Integer.MAX_VALUE-1;

        visited[i][j] = true;

        int right = findWays4directionsShortestPath( a, i, j + 1, visited );
        int down = findWays4directionsShortestPath( a, i + 1, j, visited );
        int left = findWays4directionsShortestPath( a, i, j - 1, visited );
        int up = findWays4directionsShortestPath( a, i - 1, j, visited );

        visited[i][j] = false;

        return Math.min( Math.min( right, down ), Math.min( left, up ) ) + 1;
    }
    
    static int findWays4directionsLongestPath( int[][] a, int i, int j, boolean[][] visited ) {
        if ( i < 0 || j < 0 || i == a.length || j == a[0].length )
            return Integer.MIN_VALUE;

        if ( i == a.length - 1 && j == a[0].length - 1 )
            return 1;

        if ( visited[i][j] == true )
            return Integer.MIN_VALUE;

        visited[i][j] = true;

        int right = findWays4directionsLongestPath( a, i, j + 1, visited );
        int down = findWays4directionsLongestPath( a, i + 1, j, visited );
        int left = findWays4directionsLongestPath( a, i, j - 1, visited );
        int up = findWays4directionsLongestPath( a, i - 1, j, visited );

        visited[i][j] = false;

        return Math.max( Math.max( right, down ), Math.max( left, up ) ) + 1;
    }

    static int findWays4directions( int[][] a, int i, int j, boolean[][] visited ) {
        if ( i < 0 || j < 0 || i == a.length || j == a[0].length )
            return 0;

        if ( i == a.length - 1 && j == a[0].length - 1 )
            return 1;

        if ( visited[i][j] == true )
            return 0;

        visited[i][j] = true;

        int right = findWays4directions( a, i, j + 1, visited );
        int down = findWays4directions( a, i + 1, j, visited );
        int left = findWays4directions( a, i, j - 1, visited );
        int up = findWays4directions( a, i - 1, j, visited );

        visited[i][j] = false;

        return left + down + right + up;
    }

    static int findWays2directionsDP_NO_RECURSION( int[][] a ) {
        int[][] DPTable = new int[a.length][a[0].length];

        for ( int i = 0; i < DPTable.length; i++ )
            DPTable[i][0] = 1;
        for ( int j = 0; j < DPTable.length; j++ )
            DPTable[0][j] = 1;
        for ( int i = 1; i < DPTable.length; i++ ) {
            for ( int j = 1; j < DPTable[0].length; j++ ) {
                DPTable[i][j] = DPTable[i - 1][j] + DPTable[i][j - 1];
            }
        }

        return DPTable[a.length - 1][a[0].length - 1];
    }

    static int findWays2directionsDPTable( int[][] a, int i, int j, int[][] DPTable ) {
        if ( i < 0 || j < 0 || i == a.length || j == a[0].length )
            return 0;

        if ( DPTable[i][j] != -1 )
            return DPTable[i][j];

        if ( i == a.length - 1 && j == a[0].length - 1 ) {
            DPTable[i][j] = 1;
            return 1;
        }

        int right = findWays2directionsDPTable( a, i, j + 1, DPTable );
        int down = findWays2directionsDPTable( a, i + 1, j, DPTable );

        DPTable[i][j] = right + down;
        return right + down;
    }

    static int findWays2directions( int[][] a, int i, int j ) {
        if ( i < 0 || j < 0 || i == a.length || j == a[0].length )
            return 0;

        if ( i == a.length - 1 && j == a[0].length - 1 )
            return 1;

        int right = findWays2directions( a, i, j + 1 );
        int down = findWays2directions( a, i + 1, j );
        return right + down;
    }

    /****************************************************************************************************************/
    /****************************************************************************************************************/
    /****************************************************************************************************************/
    /* Drivers */
    static void findWays2directionsDriver() {
        /* Normal 2 way */
        long start = System.currentTimeMillis();

        for ( int i = 0; i < 15; i++ ) {
            int degree = i + 1;
            int[][] a = new int[degree][degree];

            System.out.println( "degree " + degree + " : " + findWays2directions( a, 0, 0 ) );

        }
        long end = System.currentTimeMillis();
        System.out.println( "Elapsed for Normal 2 way == " + (end - start) );
        System.out.println( "" );
    }

    static void findWays2directionsDPTableDriver() {
        /* DP 2 way */
        long start = System.currentTimeMillis();
        for ( int i = 0; i < 15; i++ ) {
            int degree = i + 1;
            int[][] a = new int[degree][degree];

            int[][] DPTable = new int[degree][degree];
            for ( int j = 0; j < DPTable.length; j++ )
                Arrays.fill( DPTable[j], -1 );
            System.out.println( "degree " + degree + " : " + findWays2directionsDPTable( a, 0, 0, DPTable ) );
        }
        long end = System.currentTimeMillis();
        System.out.println( "Elapsed for DP 2 way == " + (end - start) );
        System.out.println( "" );
    }

    static void findWays2directionsDP_NO_RECURSIONDriver() {
        /* Actual DP 2 way */
        long start = System.currentTimeMillis();
        for ( int i = 0; i < 15; i++ ) {
            int degree = i + 1;
            int[][] a = new int[degree][degree];

            System.out.println( "degree " + degree + " : " + findWays2directionsDP_NO_RECURSION( a ) );
        }
        long end = System.currentTimeMillis();
        System.out.println( "Elapsed for Actual DP 2 way == " + (end - start) );
        System.out.println( "" );
    }

    static void findWays4directionsDriver() {
        /* Normal 4 way */
        long start = System.currentTimeMillis();
        for ( int i = 0; i < 15; i++ ) {
            int degree = i + 1;
            int[][] a = new int[degree][degree];

            boolean[][] visited = new boolean[a.length][a[0].length];
            System.out.println( "degree " + degree + " : " + findWays4directions( a, 0, 0, visited ) );
        }
        long end = System.currentTimeMillis();
        System.out.println( "Elapsed for Actual DP 2 way == " + (end - start) );
        System.out.println( "" );
    }

    static void findWays4directionsLongestPathDriver() {
        /* Normal 4 way */
        // long start = System.currentTimeMillis();
        // for ( int i = 0; i < 15; i++ ) {
        // int degree = i + 1;
        // int[][] a = new int[degree][degree];
        //
        // boolean[][] visited = new boolean[a.length][a[0].length];
        // System.out.println( "degree " + degree + " : " + findWays4directionsLongestPath( a, 0, 0, visited ) );
        // }
        // long end = System.currentTimeMillis();
        // System.out.println( "Elapsed for Actual DP 2 way == " + (end - start) );
        // System.out.println( "" );

        int degree = 3;
        int[][] a = new int[degree][degree];
        boolean[][] visited = new boolean[degree][degree];
        System.out.println( "degree " + degree + " : " + findWays4directionsLongestPath( a, 0, 0, visited ) );
    }
    
    static void findWays4directionsShortestPathDriver() {
        /* Normal 4 way */
        // long start = System.currentTimeMillis();
        // for ( int i = 0; i < 15; i++ ) {
        // int degree = i + 1;
        // int[][] a = new int[degree][degree];
        //
        // boolean[][] visited = new boolean[a.length][a[0].length];
        // System.out.println( "degree " + degree + " : " + findWays4directionsLongestPath( a, 0, 0, visited ) );
        // }
        // long end = System.currentTimeMillis();
        // System.out.println( "Elapsed for Actual DP 2 way == " + (end - start) );
        // System.out.println( "" );

        int degree = 3;
        int[][] a = new int[degree][degree];
        boolean[][] visited = new boolean[degree][degree];
        System.out.println( "degree " + degree + " : " + findWays4directionsShortestPath( a, 0, 0, visited ) );
    }

}
