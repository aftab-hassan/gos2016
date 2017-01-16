/*
 * QuickSortAlgorithm.java
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

/**
 * @author aftabhassan
 *
 */
public class QuickSortAlgorithm {

    protected static int A[] = {5, 3, 25, 6, 10, 17, 1, 2, 18, 8};
    
    public static void main( String[] args ) {
        QuickSortAlgorithm obj = new QuickSortAlgorithm();
        obj.sort( A );
    }
  
    public void sort(int[] A) {
        if (A == null || A.length == 0)
            return;
        quicksort(A, 0, A.length - 1);
    }

    public void quicksort(int[] A, int left, int right) {
        int pivot = A[left + (right - left) / 2];
        int i = left;
        int j = right;
        while (i <= j) {
            while (A[i] < pivot) {
                i++;
            }
            while (A[j] > pivot) {
                j--;
            }
            if (i <= j) {
                exchange(i, j);
                i++;
                j--;
            }
        }
        
        if(left < j)
            quicksort(A,left,j);
        if(i < right)
            quicksort(A,i,right);
    }

    public void exchange(int i, int j){
        int temp=A[i];
        A[i]=A[j];
        A[j]=temp;
    }
    
    public String toString() {
        String s = "";
        s += "[" + A[0];
        for (int i = 1; i < A.length; i++) {
            s += ", " + A[i];
        }
        s += "]";
        return s;
    }

}