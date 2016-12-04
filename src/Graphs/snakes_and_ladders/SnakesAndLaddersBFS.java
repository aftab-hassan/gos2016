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
package Graphs.snakes_and_ladders;

import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author aftabhassan
 *
 */
public class SnakesAndLaddersBFS {

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
        for(int i = 0;i<a.length;i++)
        {
            for(int j = 0;j<a[0].length;j++)
            {
                a[i][j] = (int)(Math.random() * 25);
            }
        }
        print( a );
        
        Hashtable<Integer, Integer> distanceTable = new Hashtable<Integer, Integer>();   
        System.out.println( shortestPath( a, distanceTable) );
        System.out.println( "" );
        
        boolean[][] visited = new boolean[a.length][a[0].length];
        System.out.println( shortestPathTwoQueues( a, visited ) );
    }

    static int shortestPathTwoQueues(int[][] a, boolean[][] visited)
    {
        Queue<Integer> parentQueue = new LinkedList<>();
        Queue<Integer> childQueue = new LinkedList<>();
        
        int hops = 0;
        parentQueue.add( 0 );
        visited[0][0] = true;
        while(parentQueue.size() > 0)
        {
            int pos = parentQueue.poll();
            
            int i = pos/a[0].length;
            int j = pos%a[0].length;
            
            if(i == a.length-1 && j == a[0].length-1)
                return hops;
            
            if(a[i][j] == 0)
            {
                for(int k = 1;k<=6;k++)
                {
                    int newpos = pos + k;
                    if(newpos <= (a.length*a[0].length)-1)
                    {
                        int newi = newpos/a[0].length;
                        int newj = newpos%a[0].length;
                        
                        if(visited[newi][newj] == false)
                        {
                            visited[newi][newj] = true;
                            childQueue.add( newpos );
                        }         
                    }                             
                }
            }
            else{
                int newpos = a[i][j];
                int newi = newpos/a[0].length;
                int newj = newpos%a[0].length;
                
                if(visited[newi][newj] == false)
                {
                    visited[newi][newj] = true;
                    childQueue.add( newpos );
                }      
            }
            
            if(parentQueue.size() == 0)
            {
                hops++;
                parentQueue.addAll( childQueue );
                childQueue.clear();
            }
        }
        
        return -1;
    }
    
    static int shortestPath(int[][] a, Hashtable<Integer, Integer> distanceTable)
    {
        Queue<Integer> processing = new LinkedList<Integer>();
        
        processing.add( 0 );
        distanceTable.put( 0, 0 );
        
        while(processing.size() > 0)
        {
            int pos = processing.poll();
           
            if(pos == (a.length*a[0].length)-1)
                return distanceTable.get( pos );
                      
            if(a[pos/a[0].length][pos%a[0].length] == 0)
            {    
                for(int i = 1;i<=6;i++)
                {
                    if( ((pos+i) <= (a.length*a[0].length)-1) && !(distanceTable.containsKey( pos+i )) )
                    {
                        distanceTable.put( pos+i, distanceTable.get( pos )+1 );
                        processing.add( pos+i );
                    }  
                }
            }
            else
            {
                if(distanceTable.get( a[pos/a[0].length][pos%a[0].length] ) == null)
                {
                    distanceTable.put( a[pos/a[0].length][pos%a[0].length], distanceTable.get( pos ) +1);
                    processing.add( a[pos/a[0].length][pos%a[0].length] );
                }
            }
        }
        
        return -1;
    }
    
    static void print(int[][] a)
    {
        for(int i = 0;i<a.length;i++)
        {
            for(int j = 0;j<a[0].length;j++)
            {
                System.out.print( a[i][j] + " " );
            }
            System.out.println( "" );
        }
    }
}
