/*
 * rangesorting.java
 * 
 * Copyright (c) 2016 by General Electric Company. All rights reserved.
 * 
 * The copyright to the computer software herein is the property of
 * General Electric Company. The software may be used and/or copied only
 * with the written permission of General Electric Company or in accordance
 * with the terms and conditions stipulated in the agreement/contract
 * under which the software has been supplied.
 */
package Sorting;

/**
 * @author aftabhassan
 */
public class rangesorting {

    /**
     * @param args
     */
    public static void main( String[] args ) {
        // TODO Auto-generated method stub

        int[] a = {1, 2, 4, 7, 10, 11, 7, 8, 9, 12, 6, 7, 16, 18, 19};
        int[] range = findRange( a );
        System.out.println( range[0] + " " + range[1] );

    }

    static int[] findRange( int[] a ) {

        int low = -1;
        for ( int i = 1; i < a.length; i++ ) {
            if ( a[i] < a[i - 1] ) {
                low = i;
                break;
            }
        }

        int high = a.length - 1;
        for ( int i = a.length - 2; i >= 0; i-- ) {
            if ( a[i] > a[i + 1] ) {
                high = i;
                break;
            }

        }

        int minIndex = low;
        int maxIndex = low;
        int i = low;
        while ( i <= high ) {
            if ( a[i] < a[minIndex] )
                minIndex = i;
            if ( a[i] > a[maxIndex] )
                maxIndex = i;

            i++;
        }

        while ( a[minIndex] <= a[low] )
            low--;

        while ( a[maxIndex] >= a[high] )
            high++;

        int[] ret = {low + 1, high - 1};
        return ret;
    }
}
