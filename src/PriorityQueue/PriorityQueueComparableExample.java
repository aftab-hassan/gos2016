/*
 * PriorityQueueComparableExample.java
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
public class PriorityQueueComparableExample {

    /**
     * @param args
     */
    public static void main( String[] args ) {
        // TODO Auto-generated method stub
        PriorityQueueComparableExample obj = new PriorityQueueComparableExample();
        obj.example();
    }
    
    public void example()
    {
//        PriorityQueue<Cell> myPriorityQueue = new PriorityQueue<>(new DescendingComparator());
        PriorityQueue<Cell> myPriorityQueue = new PriorityQueue<>();
        
        for(int i = 0;i<10;i++)
        {
            myPriorityQueue.add( new Cell( i, i, i*10 ) );
        }
        
        System.out.println( myPriorityQueue );
    }

}

class Cell implements Comparable<Cell>
{
    int count;
    int i;
    int j;
    
    public Cell( int i, int j, int count )
    {
        this.i = i;
        this.j = j;
        this.count = count;
    }
    
    @Override
    public String toString()
    {
        return this.i+":"+this.j+":"+this.count;
    }
    
    @Override
    public int compareTo(Cell c1)
    {
        return this.count - c1.count;
//        return c1.count - this.count;
    }
}

class DescendingComparator implements Comparator<Cell>
{
    @Override
    public int compare(Cell c1, Cell c2)
    {
        return c2.count - c1.count;
    }
}