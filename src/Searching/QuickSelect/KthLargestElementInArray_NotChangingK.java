package Searching.QuickSelect;
/*
 * KthLargestElementInArray.java
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
public class KthLargestElementInArray_NotChangingK {

    /**
     * @param args
     */
    public static void main( String[] args ) {
        // TODO Auto-generated method stub
        
        KthLargestElementInArray_NotChangingK obj = new KthLargestElementInArray_NotChangingK();
//        int[] a = {7,4,1,3,2,5,6};
        int[] a = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
        
        obj.print( a );
        System.out.println( "" );
        obj.shuffle( a );
        obj.print( a );
        
        System.out.println( "" );
        for(int i = 1;i<=a.length;i++)
            System.out.println( obj.KthLargest( a, i, 0, a.length-1 ) );
        
    }

    public int KthLargest(int[] a, int k, int low, int high)
    {
        int pivot = (low + high)/2;
        int startLow = low;
        int startHigh = high;
        
        while(low < high)
        {
            while(a[low] <= a[pivot] && pivot!=low)
                low++;
            while(a[high]>=a[pivot] && pivot!=high)
                high--;
            
            if(low != high)
            {
                int temp = a[low];
                a[low] = a[high];
                a[high] = temp;
                
                if(pivot == low)
                    pivot = high;
                else if(pivot == high)
                    pivot = low;
            }
        }
        
        if(pivot == (k-1))
            return a[pivot];
        else if(pivot > (k-1))
            return KthLargest( a, k, startLow, low-1 );
        else
            return KthLargest( a, k, low+1, startHigh );
    }
    
    public void shuffle(int[] a)
    {
        for(int i = 0;i<10;i++)
        {
            int pos1 = (int)(Math.random()*10);
            int pos2 = (int)(Math.random()*10);
            
            int temp = a[pos1];
            a[pos1] = a[pos2];
            a[pos2] = temp;
        }
    }
    
    public void print(int[] a)
    {
        for(int i = 0;i<a.length;i++)
            System.out.print( a[i] + " " );
    }
}
