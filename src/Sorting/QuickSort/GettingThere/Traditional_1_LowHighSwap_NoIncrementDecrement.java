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
 * a[low] == pivot, or
 * a[high] == pivot, 
 * 
 * so after swapping low and high,
 * if a[low] was equal to pivot, now a[high] is still is same as pivot, and so, it does a swap again,
 * and basically enters a deadlock condition
 * Debug with this array if required : int[] a = {1, 2, 5, 5, 7, 5, 8, 9};//Error condition
 */
public class Traditional_1_LowHighSwap_NoIncrementDecrement {

    /**
     * @param args
     */
    public static void main( String[] args ) {
        // TODO Auto-generated method stub
        int[] a = {2, 3, 4, 5, 1, 6, 7};
//        int[] a = {14, 15, 2, 3, 4, 11, 12, 13, 5, 1, 6, 7, 8, 9, 10, 0, 16};
//        int[] a = {1, 2, 5, 5, 7, 5, 8, 9};//Error condition

        
        Traditional_1_LowHighSwap_NoIncrementDecrement obj = new Traditional_1_LowHighSwap_NoIncrementDecrement();
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
                swap( a, low, high );
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
