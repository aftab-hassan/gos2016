package Matrix.MaxSumLessThanK;
/*
 * Max_Sum_of_Rectangle_No_Larger_Than_K.java
 * 
 * Copyright (c) 2016 by General Electric Company. All rights reserved.
 * 
 * The copyright to the computer software herein is the property of
 * General Electric Company. The software may be used and/or copied only
 * with the written permission of General Electric Company or in accordance
 * with the terms and conditions stipulated in the agreement/contract
 * under which the software has been supplied.
 */

//https://leetcode.com/problems/max-sum-of-sub-matrix-no-larger-than-k/
/**
 * @author aftabhassan
 *
 */
/* Frequent mistakes : Not using all of the input parameters given, here, k */
public class Max_Sum_of_Rectangle_No_Larger_ThanK {

    public static void main( String[] args ) {
        // TODO Auto-generated method stub
//        int[][] a = {{2,2,-1}};
        int[][] a = {{5,-4,-3,4},{-3,-4,4,5},{5,1,5,-4}};
        
        Max_Sum_of_Rectangle_No_Larger_ThanK obj = new Max_Sum_of_Rectangle_No_Larger_ThanK();
        int output = obj.maxSumSubmatrix( a, 8 );
        System.out.println( "output == " + output );
    }
    
    /* This triages all outputs */
    public int maxSumSubmatrix(int[][] a, int k) 
    {
        int output = Integer.MIN_VALUE;
        
        /* trying starting from each cell */
        for(int i = 0;i<a.length;i++)
        {
            for(int j = 0;j<a[0].length;j++)
            {
                int rec = traverse(a, i, j, k);
                output = Math.max(output, rec);
            }
        }

        return output;
    }

    /*
    public void traverse(int[][] a, int i, int j, int left, int up, int right, int down, int[][] dptable, int k)
    {
        if(down == a.length || right == a[0].length)
                return -1;

        int area = Math.abs((up - down) * (left - right));

        dptable[i][j] = (area <= k)?area:dptable[i][j];
    }*/

    public int traverse(int[][] a, int starti, int startj, int k)
    {
        int output = Integer.MIN_VALUE;
       
        int[][] dptable = new int[a.length][a[0].length];
//        for(int i = starti;i<a.length;i++)
//        {
//            for(int j=startj;j<a[0].length;j++)
//            {
//                dptable[i][j] = a[i][j];
//            }
//        }
        
        for(int i = starti; i < a.length; i++)
        {
            for(int j = startj; j < a[0].length; j++)
            {
                int sum = computeSum(a, starti, startj, i, j, dptable);
                output = sum<=k && sum>output?sum:output;
            }
        }
        
        return output;
    }

    /* computing sum using DP and saving the result in dptable */
    public int computeSum(int[][] a, int starti, int startj, int i, int j, int[][] dptable)
    {
        int sum = 0;
        int jj = j-1;
        if(jj >= startj)
        {
            sum = dptable[i][jj];
        }
        for(int ii = starti;ii<=i;ii++)
            sum += a[ii][j];
      
        dptable[i][j] = sum;
        
        return sum;
    }
}