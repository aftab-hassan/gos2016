/*
 * numberjustlargerthan.java
 * 
 * Copyright (c) 2016 by General Electric Company. All rights reserved.
 * 
 * The copyright to the computer software herein is the property of
 * General Electric Company. The software may be used and/or copied only
 * with the written permission of General Electric Company or in accordance
 * with the terms and conditions stipulated in the agreement/contract
 * under which the software has been supplied.
 */
package Searching;

/**
 * @author aftabhassan
 */
public class numberjustlargerthan {

    /**
     * @param args
     */
    public static void main( String[] args ) {
        // TODO Auto-generated method stub
        double[] a = {2, 4, 7, 7.1, 7.2, 7.3, 8, 9, 10, 11, 12, 14, 15, 16, 18};

        for(int i= 0;i<100;i++)
        {
            double key = (double)(Math.random()*18);
            System.out.println( "key == " + key );
            System.out.println( fun( a, 0, a.length - 1, Integer.MAX_VALUE, key ) );
            System.out.println( fun( a, 0, a.length-1, key ) );
            System.out.println( "" );
        }
        
    }
    
    static double fun(double[] a, int low, int high, double key)
    {
        if(low > high)
            return Integer.MAX_VALUE;
        
        int mid = (low + high)/2;
        
        if(a[mid] <= key)
            return fun( a, mid+1, high, key );     
        else
            return Math.min( a[mid], fun( a, low, mid-1, key ) );
    }

    static double fun( double[] a, int low, int high, double prev, double key ) {
        if ( low > high )
            return prev;

        int mid = (low + high) / 2;
        if ( a[mid] <= key )
            return fun( a, mid + 1, high, prev, key );
        else
            return fun( a, low, mid - 1, a[mid], key );
    }

}
