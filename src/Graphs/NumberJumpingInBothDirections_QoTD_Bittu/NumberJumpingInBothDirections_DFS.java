package Graphs.NumberJumpingInBothDirections_QoTD_Bittu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;

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
public class NumberJumpingInBothDirections_DFS {

    public static void main( String[] args ) {
        int[] a = {0, 1, 2, 3, 4, 5, 6, 7, 5, 4, 3, 6, 0, 1, 2, 3, 4, 5, 7};
//        int[] a = {5, 4, 2, 5, 0};
        
        NumberJumpingInBothDirections_DFS numberJumpingInBothDirections = new NumberJumpingInBothDirections_DFS();
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
        
        /* too much, but okay :) */
        visited[0] = true;
        int ret = minJumps( a, i, myHashtable, visited );
        visited[0] = false;
        
        return ret;
    }
    
    public int minJumps(int[] a, int i, Hashtable<Integer, ArrayList<Integer>> myHashtable, boolean[] visited)
    {
        if(i == a.length-1)
            return 0;
        
        int left = Integer.MAX_VALUE-1;
        int right = Integer.MAX_VALUE-1;
        if(i >= 1 && visited[i-1] == false)
        {
            visited[i-1] = true;
            left = minJumps( a, i-1, myHashtable, visited );
            visited[i-1] = false;
        }
           
        if(i < a.length-1 && visited[i+1] == false)
        {
            visited[i+1] = true;
            right = minJumps( a, i+1, myHashtable, visited );
            visited[i+1] = false;
        }
           
        int same = Integer.MAX_VALUE-1;
        ArrayList<Integer> sameIndices = myHashtable.get( a[i] );
        for(int j = 0;j<sameIndices.size();j++)
        {
            int index = sameIndices.get( j );
            if(visited[index] == false)
            {
                visited[index] = true;
                same = Math.min( same, minJumps( a, index, myHashtable, visited ) );
                visited[index] = false;
            }     
        }
        
        return min( left, right, same ) + 1;
    }
    
    public int min(int a, int b, int c)
    {
        int[] arr = new int[3];
        arr[0] = a; arr[1] = b; arr[2] = c;
        
        Arrays.sort( arr );
        return arr[0];
    }
}
