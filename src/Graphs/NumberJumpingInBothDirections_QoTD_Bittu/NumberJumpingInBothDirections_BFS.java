package Graphs.NumberJumpingInBothDirections_QoTD_Bittu;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Queue;

/*
 * NumberJumpingInBothDirections.java
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
/*
 * Given an array containing one digit numbers only, assuming we are standing at first index, 
 * we need to reach to end of array using minimum number of steps where in one step, 
 * we can jump to neighbor indices or can jump to a position with same value.
 * 
 * Say, we are at index i, we can jump to
 * a) i-1
 * b) i+1
 * c) or an index k, iff a[k] == a[i]
 */
public class NumberJumpingInBothDirections_BFS {

    public static void main( String[] args ) {
        int[] a = {0, 1, 2, 3, 4, 5, 6, 7, 5, 4, 3, 6, 0, 1, 2, 3, 4, 5, 7};
//        int[] a = {5, 4, 2, 5, 0};
        
        NumberJumpingInBothDirections_BFS numberJumpingInBothDirections = new NumberJumpingInBothDirections_BFS();
        System.out.println( "Min jumps == " + numberJumpingInBothDirections.minJumps( a, 0 ) );
    }
    
    public int minJumps(int[] a, int i)
    {
        Hashtable<Integer, ArrayList<Integer>> myHashtable = new Hashtable<>();
        for(int j = 0;j<a.length;j++)
        {
            if(myHashtable.containsKey( a[j] ))
            {
                ArrayList<Integer> contents = myHashtable.get( a[j] );
                contents.add(j);    
            }
            else
            {
                ArrayList<Integer> contents = new ArrayList<Integer>();
                contents.add( j );
                myHashtable.put( a[j], contents );
            }
        }
        
        boolean[] visited = new boolean[a.length];
        
        return minJumps( a, myHashtable, visited );
    }
    
    public int minJumps(int[] a, Hashtable<Integer, ArrayList<Integer>> myHashtable, boolean[] visited)
    {
        Queue<Integer> parents = new LinkedList<>();
        Queue<Integer> children = new LinkedList<>();
        
        int hops = 0;
        
        parents.add( 0 );
        visited[0] = true;
        while(parents.size() > 0)
        {
            int current = parents.poll();
            
            if(current == a.length-1)
                return hops;
            
            if(current > 0 && visited[current-1] == false)
            {
                visited[current-1] = true;
                children.add( current-1 );
            }
                
            if(current < a.length-1 && visited[current+1]==false)
            {
                visited[current+1] = true;
                children.add( current + 1 );
            }
                
            ArrayList<Integer> sameIndices = myHashtable.get( a[current] );
            for(int i = 0;i<sameIndices.size();i++)
            {
                int index = sameIndices.get( i );
                if(visited[index] == false)
                {
                    visited[index] = true;
                    children.add( index );
                }
            }
                         
            if(parents.size() == 0)
            {
                hops++;
                parents.addAll( children );
                children.clear();
            }
        }
        
        return -1;
    }
}
