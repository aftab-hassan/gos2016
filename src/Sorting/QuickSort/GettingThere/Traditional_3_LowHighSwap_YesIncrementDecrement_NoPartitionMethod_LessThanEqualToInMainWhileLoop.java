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

public class Traditional_3_LowHighSwap_YesIncrementDecrement_NoPartitionMethod_LessThanEqualToInMainWhileLoop {

    /**
     * @param args
     */
    public static void main( String[] args ) {
        // TODO Auto-generated method stub
        int[] a = new int[10];
        for(int i = 0;i<a.length;i++)
            a[i] = (int)(Math.random()*10);
//        int[] a = {5, 4, 7, 9, 6, 4};
        
        Traditional_3_LowHighSwap_YesIncrementDecrement_NoPartitionMethod_LessThanEqualToInMainWhileLoop obj = new Traditional_3_LowHighSwap_YesIncrementDecrement_NoPartitionMethod_LessThanEqualToInMainWhileLoop();
        obj.print( a );
        obj.quickSort( a, 0, a.length-1 );
        System.out.println( "" );
        obj.print( a );
    }

    public void quickSort ( int[] a, int low, int high )
    {
        if(low >= high)
            return;
        
        int startLow = low;
        int startHigh = high;
        
        // pick the pivot
        int middle = low + (high - low) / 2;
        int pivot = a[middle];
        
        while (low <= high) {
            while (a[low] < pivot) {
                    low++;
            }

            while (a[high] > pivot) {
                    high--;
            }

            if (low <= high) {
                    swap( a, low, high );
                    low++;
                    high--;
            }
        }
        
        quickSort( a, startLow, high );
        quickSort( a, low, startHigh );
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
