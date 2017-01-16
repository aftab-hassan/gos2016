/*
 * IterativeQuickSort.java
 * 
 * Copyright (c) 2017 by General Electric Company. All rights reserved.
 * 
 * The copyright to the computer software herein is the property of
 * General Electric Company. The software may be used and/or copied only
 * with the written permission of General Electric Company or in accordance
 * with the terms and conditions stipulated in the agreement/contract
 * under which the software has been supplied.
 */
package Sorting.QuickSort.GettingThere;

import java.util.Stack;

/**
 * @author aftabhassan
 *
 */
//Java implementation of iterative quick sort
class MyIterativeQuickSort
{
 // Driver code to test above
    public static void main(String args[])
    {
        MyIterativeQuickSort ob = new MyIterativeQuickSort();
        
        int[] a = new int[6];
        for(int i = 0;i<a.length;i++)
            a[i] = (int)(Math.random()*10);
        
//        int a[] = {4, 3, 5, 2, 1, 3, 2, 3};
        ob.printa(a, a.length);
        ob.QuickSort(a, 0, a.length-1);
        ob.printa(a, a.length);
    }
    
 // Sorts a[l..h] using iterative QuickSort
    void QuickSort(int a[], int l, int h)
    {
        Stack<Position> myStack = new Stack<>();
        
        myStack.add( new Position( l, h ) );
        
        while(myStack.size() > 0)
        {
            Position position = myStack.pop();
            
            if(position.low >= position.high)
                continue;
            
            int pivotIndex = partition( a, position.low, position.high );
            
            myStack.push( new Position( position.low, pivotIndex-1 ) );
            myStack.push( new Position( pivotIndex+1, position.high ) );
        }
    }
    
        /* This function is same in both iterative and
        recursive*/
//     int partition (int a[], int l, int h)
//     {
//         int x = a[h];
//         int i = (l - 1);
//    
//         for (int j = l; j <= h- 1; j++)
//         {
//             if (a[j] <= x)
//             {
//                 i++;
//                 // swap a[i] and a[j]
//                 swap(a,i,j);
//             }
//         }
//         // swap a[i+1] and a[h]
//         swap(a,i+1,h);
//         return (i + 1);
//     }
    
    int partition (int[] a, int low, int high)
    {
        int leftOfWall = low - 1;
        int pivot = a[high];
                
        while(low <= high)
        {
            if(a[low] <= pivot)
            {
                swap( a, ++leftOfWall, low );
            }
            low++;
        }
//        swap( a, ++leftOfWall, high );
        
        return leftOfWall;
    }

     void swap(int a[],int i,int j)
     {
         int t = a[i];
         a[i] = a[j];
         a[j] = t;
     }
    
     // A utility function to print contents of a
     void printa( int a[], int n )
     {
         int i;
         for ( i = 0; i < n; ++i )
             System.out.print(a[i]+" ");
         System.out.println( "" );
     }
     
}

class Position
{
    int low;
    int high;
    
    /**
     * 
     */
    public Position(int low, int high) {
        // TODO Auto-generated constructor stub
        this.low = low;
        this.high = high;
    }
}