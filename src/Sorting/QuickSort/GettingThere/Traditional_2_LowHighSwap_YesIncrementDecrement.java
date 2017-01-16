/*
 * Traditional_LowHighSwap_NoIncrementDecrement.java
 * 
 * Copyright (c) 2016 by General Electric Company. All rights reserved.
 * 
 * The copyright to the computer software herein is the property of
 * General Electric Company. The software may be used and/or copied only
 * with the written permission of General Electric Company or in accordance
 * with the terms and conditions stipulated in the agreement/contract
 * under which the software has been supplied.
 */
package Sorting.QuickSort.GettingThere;

/**
 * @author aftabhassan
 *
 */
/*
 * Problem with this approach is when you have
 * 
 * An array like
 * where at some point, low and high are adjacent to each other, but needs swapping
 * In which case, low and high will cross each other, and becomes low>high
 * So, how if you made your condition to be 
 * 
 */
public class Traditional_2_LowHighSwap_YesIncrementDecrement {

    /**
     * @param args
     */
    public static void main( String[] args ) {
        // TODO Auto-generated method stub
        int[] a = new int[6];
        for(int i = 0;i<a.length;i++)
            a[i] = (int)(Math.random()*10);
        
        Traditional_2_LowHighSwap_YesIncrementDecrement obj = new Traditional_2_LowHighSwap_YesIncrementDecrement();
        obj.print( a );
        obj.quickSort( a, 0, a.length-1 );
        System.out.println( "" );
        obj.print( a );
    }

    public void quickSort(int[] a, int low, int high)
    {
        if(low > high)
            return;
        
        int pivotIndex = partition( a, low, high );
        
        quickSort( a, low, pivotIndex-1 );
        quickSort( a, pivotIndex+1, high );
    }
    
    public int partition(int[] a, int low, int high)
    {
        int pivot = a[(low+high)/2];
        
        while(low < high)
        {
            while(a[low] < pivot)
                low++;
            while(a[high] > pivot)
                high--;
            
            if(low < high)
            {
                swap( a, low, high );
                low++;
                high--;
            }
                
        }
        
        return low;
    }
    
    public void swap(int[] a, int i, int j)
    {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    
    public void print(int[] a)
    {
        for(int i = 0;i<a.length;i++)
            System.out.print( a[i] + " " );
    }
}
