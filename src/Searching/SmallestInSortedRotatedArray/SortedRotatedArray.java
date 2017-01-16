/*
 * SortedRotatedArray.java
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
 * easier logic : http://www.programcreek.com/2014/02/leetcode-find-minimum-in-rotated-sorted-array/
 * complicated one : http://www.geeksforgeeks.org/search-an-element-in-a-sorted-and-pivoted-array/
 */
package Searching.SmallestInSortedRotatedArray;

public class SortedRotatedArray {
    public static void main( String[] args ) {
        int[] a = { 1, 2, 3, 4, 5, 6, 7 };
        
        SortedRotatedArray obj = new SortedRotatedArray();
        System.out.println( obj.smallestElementInSortedRotatedArray( a, 0, a.length-1 ) );
    }
    
    public int smallestElementInSortedRotatedArray(int[] a, int low, int high)
    {
        if(a[high] > a[low])
            return a[low];
        
        if(low == high)
            return a[low];
        
        if(high - low == 1)
            return Math.min( a[low], a[high] );
              
        int mid = (low + high)/2;
              
        if(a[mid] < a[low])
            return smallestElementInSortedRotatedArray( a, low, mid );
        else
            return smallestElementInSortedRotatedArray( a, mid, high );
    }
}
