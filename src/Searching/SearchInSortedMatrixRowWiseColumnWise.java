/*
 * SearchInSortedMatrixRowWiseColumnWise.java
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
 *
 */
public class SearchInSortedMatrixRowWiseColumnWise {

    /**
     * @param args
     */
    public static void main( String[] args ) {
        // TODO Auto-generated method stub

    }
    
    public boolean searchMatrix(int[][] a, int key)
    {
        int i = 0;
        int j = a[0].length-1;
    
        while(i<a.length && j>=0)
        {
            if(a[i][j] == key)
                return true;
    
            if(a[i][j] > key)
                j--;
    
            else if(a[i][j] < key)
                i++;
        }
    
        return false;
    }
}
