package Searching.WeightedRandomNumber;

import java.util.Hashtable;

/*
 * WeightedRandomNumber.java
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


public class WeightedRandomNumber {

    /**
     * @param args
     */
    public static void main( String[] args ) {
        // TODO Auto-generated method stub
        int[] a = {1,1,2,3,1};
        
        Hashtable<Character, Integer> myHashtable = new Hashtable<>();
        for(int i = 0;i<1000;i++)
        {
            char val = random( a );
            if(myHashtable.containsKey( val ))
                myHashtable.put( val, myHashtable.get( val )+1 );
            else
                myHashtable.put( val, 1 );
        }
        System.out.println( myHashtable );
        
//        System.out.println( random( a ) );
    }
    
    static char random(int[] a)
    {
        int pos = 0;
        int[] b = new int[a.length];
        for(int i = 0;i<a.length;i++)
        {
            pos += a[i];
            b[i] = pos;
        }
        
        return (char)(findLarger(b, ((int)(Math.random()*pos))+1, 0, b.length-1)+'A');
    }
    
    static int findLarger(int[] a, int key, int low, int high)
    {
        if(low > high)
            return -1;
        
        int mid = (low + high)/2;
        
        if(a[mid] == key)
            return mid;
        else
        {
            if(a[mid] > key)
            {
                int left = findLarger( a, key, low, mid-1 );
                if(left == -1)
                    return mid;
                return a[mid]<a[left]?mid:left;
            }
            else
            {
                return findLarger( a, key, mid+1, high );
            }
        }
    }

}
