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

public class Traditional_3_Copied_LowHighSwap_YesIncrementDecrement_WithoutBlindIncrementDecrement {

    /**
     * @param args
     */
    public static void main( String[] args ) {
        // TODO Auto-generated method stub
//        int[] a = new int[500];
//        for(int i = 0;i<a.length;i++)
//            a[i] = (int)(Math.random()*500);
        int[] a = {5, 6, 7, 8, 1, 2, 3, 4};
        
        Traditional_3_Copied_LowHighSwap_YesIncrementDecrement_WithoutBlindIncrementDecrement obj = new Traditional_3_Copied_LowHighSwap_YesIncrementDecrement_WithoutBlindIncrementDecrement();
        obj.print( a );
        obj.quickSort( a, 0, a.length-1 );
        System.out.println( "" );
        obj.print( a );
    }

    public void quickSort(int[] a, int low, int high) {
        if (a == null || a.length == 0)
                return;

        if (low >= high)
                return;

        int pivotIndex = partition( a, low, high );
        quickSort(a, low, pivotIndex-1);
        quickSort(a, pivotIndex, high);
    }
    
    public int partition ( int[] a, int low, int high )
    {
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

            /* The only time when low would be equal to high, is when low and high are pointing to the pivot */
            if(low == high)
            {
                System.out.println( "say that! pivot=="+pivot+",a[low]==a[high]=="+a[low] );
            }
            
            if (low <= high) {
                    swap( a, low, high );
//                    low++;
//                    high--;
            }
        }
        
        if(a[low] == pivot)
        {
            System.out.println( "shoutout! a[low]==pivot" );
        }
        
        return low;
        /*
         * Try
         * 1. return high, and try tweaking to quickSort(a, low, pivotIndex); and quickSort(a, pivotIndex+1, high);
         * 2. return low-1
         * 3. Try alternating low <= high to low < high
         * 4. 
         */
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
