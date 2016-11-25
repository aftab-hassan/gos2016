/*
 * SnakesAndLadders.java
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
 *
 */
public class SnakesAndLaddersDFS {

    /**
     * @param args
     */
//    http://codereview.stackexchange.com/questions/147957/snakes-and-ladders-using-a-magic-dice
    public static void main( String[] args ) {
        // TODO Auto-generated method stub
        int[][] a = {
                     {0,11,0,0,0},
                     {0,0,0,0,0},
                     {0,0,1,23,0},
                     {0,0,4,0,0},
                     {10,0,0,0,0}
        };
        boolean[][] visited = new boolean[a.length][a[0].length];
        
        System.out.println( shortestPath( a, 0, 0, visited ) );
    }

    /* Backtrack : 
     * 1. Roll back operation - When you reach a point where you realize you have tried everything possible here, and doesn't
     * work, which means there should be something wrong in the past, you roll back to that past point, setting everything
     * till the roll back state to false.
     * 
     * 2. You successfully computed the value of something. You roll back to a previous state, you set all the resources
     * you used to unset, so that others in the same hierarchy also have access to all of these resources.
     * 
     * Basically, unsetting is done right before returning */
    static int shortestPath(int[][] a, int i, int j, boolean[][] visited)
    {
        if(i >= a.length || j >= a[0].length)
            return Integer.MAX_VALUE-100;
        
        if( i == a.length-1 && j == a[0].length-1)
            return 0;
        
        if(visited[i][j] == true )
            return Integer.MAX_VALUE-100;
        
        visited[i][j] = true;
        int min = Integer.MAX_VALUE-100;
        if(a[i][j] == 0)
        {
            int pos = i*a[0].length + j;    
            for(int k = pos+1;k<=pos+6;k++)
            {
                min = Math.min( min, shortestPath( a, k/a[0].length, k%a[0].length, visited ) + 1) ;
            }
            
        }
        else
            return shortestPath( a, a[i][j]/a[0].length, a[i][j]%a[0].length, visited ) + 1;
        
        visited[i][j] = false;
        return min;
    }
}
