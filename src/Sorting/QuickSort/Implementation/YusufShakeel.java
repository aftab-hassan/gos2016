/*
 * Traditional.java
 * 
 * Copyright (c) 2017 by General Electric Company. All rights reserved.
 * 
 * The copyright to the computer software herein is the property of
 * General Electric Company. The software may be used and/or copied only
 * with the written permission of General Electric Company or in accordance
 * with the terms and conditions stipulated in the agreement/contract
 * under which the software has been supplied.
 */
package Sorting.QuickSort.Implementation;

/**
 * @author aftabhassan
 *
 */
public class YusufShakeel {

    /**
     * @param args
     */
    public static void main( String[] args ) {
        // TODO Auto-generated method stub
        int[] a = new int[6];
        for(int i= 0;i<a.length;i++)
            a[i] = (int)(Math.random()*10);
        YusufShakeel obj = new YusufShakeel();
        obj.print( a );
        obj.quickSort( a, 0, a.length-1 );
        obj.print( a );
    }
    
    public void quickSort(int[] a, int low, int high)
    {
        if(low >= high)
            return;
        
        int pivotIndex = partition( a, low, high );
        quickSort( a, low, pivotIndex-1 );
        quickSort( a, pivotIndex, high );//
    }
    
    public int partition(int[] a, int low, int high)
    {
        int pivotIndex = high;
        int pivot = a[pivotIndex];
        
        while (low < high)
        {
            while(a[low] <= pivot &&  low!= pivotIndex)
                low++;
            
            while(a[high] >= pivot && high != pivotIndex)
                high--;
            
            if(low != high)
            {
                swap( a, low, high );
                if(pivotIndex == low || pivotIndex == high)
                {
                    if(pivotIndex == low)
                        pivotIndex = high;
                    
                    else if(pivotIndex == high)
                        pivotIndex = low;
                }
            }
        }
        
        return low;
    }

    public void swap(int[] a, int i, int j)
    {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
    
    public void print(int[] a)
    {
        for(int i = 0;i<a.length;i++)
            System.out.print( a[i] + " " );
        System.out.println( "" );
    }
}
