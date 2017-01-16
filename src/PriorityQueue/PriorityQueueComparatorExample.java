/*
 * PriorityQueueExample.java
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

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author aftabhassan
 *
 */
public class PriorityQueueComparatorExample {

    /**
     * @param args
     */
    public static void main( String[] args ) {
        // TODO Auto-generated method stub
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new DescendingComparator());
        int size = 10;
        
        for(int i = 0;i<size;i++)
        {
            priorityQueue.add( ( int )(Math.random()*100));
        }
        
        System.out.println( priorityQueue );System.out.println( "" );
        
        for(int i = 0;i<size;i++)
        {
            System.out.println( "Removing : " + priorityQueue.remove() );
            System.out.println( priorityQueue );
            System.out.println( "" );
        }
    }

}

class AscendingComparator implements Comparator<Integer>
{
    @Override
    public int compare (Integer i1, Integer i2)
    {
        return i1-i2;
    }
}

class DescendingComparator implements Comparator<Integer>
{
    @Override
    public int compare (Integer i1, Integer i2)
    {
        return i2-i1;
    }
}