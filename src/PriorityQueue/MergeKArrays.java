/*
 * MergeKArrays.java
 * 
 * Copyright (c) 2016 by General Electric Company. All rights reserved.
 * 
 * The copyright to the computer software herein is the property of
 * General Electric Company. The software may be used and/or copied only
 * with the written permission of General Electric Company or in accordance
 * with the terms and conditions stipulated in the agreement/contract
 * under which the software has been supplied.
 */
package PriorityQueue;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author aftabhassan
 *
 */
public class MergeKArrays {

    /**
     * @param args
     */
    public static void main( String[] args ) {
        // TODO Auto-generated method stub
        int[][] lists = new int[3][5];
        
        MergeKArrays obj = new MergeKArrays();
        
        obj.populate( lists );
        obj.display( lists );
        System.out.println( "" );
        obj.merge( lists );
    }
    
    /* algorithm */
    public void merge(int[][] lists)
    {
        PriorityQueue<Tuple> myPriorityQueue = new PriorityQueue<>(new AscendingComparator());
            
        for(int i = 0;i<lists.length;i++)
        {
            myPriorityQueue.add( new Tuple( lists[i][0], i, 0 ) );
        }
        
        while( myPriorityQueue.size() > 0 )
        {
            Tuple smallest = myPriorityQueue.poll();
            System.out.print( smallest.val + " " );
            
            if(smallest.j+1 < lists[smallest.i].length)
                myPriorityQueue.add( new Tuple( lists[smallest.i][smallest.j+1], smallest.i, smallest.j+1 ) );
        }
    }
    
    /* utilities */
    public void populate (int[][] lists)
    {
        for(int i = 0;i<lists.length;i++)
        {
            for(int j = 0;j<lists[0].length;j++)
            {
                lists[i][j] = (int)(Math.random()*50);
            }
            Arrays.sort( lists[i] );
        }
    }
    
    public void display(int[][] lists)
    {
        for(int i = 0;i<lists.length;i++)
        {
            for(int j = 0;j<lists[0].length;j++)
            {
                System.out.print( lists[i][j] + " " );
            }
            System.out.println( "" );
        }
    }
}

class Tuple
{
    int val;
    int i;
    int j;
    
    /**
     * 
     */
    public Tuple(int val, int i, int j) {
        // TODO Auto-generated constructor stub
        this.val = val;
        this.i = i;
        this.j = j;
    }
}

class AscendingComparator implements Comparator<Tuple>
{
    @Override
    public int compare (Tuple t1, Tuple t2)
    {
        return t1.val - t2.val;
    }
}
