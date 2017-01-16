/*
 * SumOfPerfectSquares.java
 * 
 * Copyright (c) 2016 by General Electric Company. All rights reserved.
 * 
 * The copyright to the computer software herein is the property of
 * General Electric Company. The software may be used and/or copied only
 * with the written permission of General Electric Company or in accordance
 * with the terms and conditions stipulated in the agreement/contract
 * under which the software has been supplied.
 */
package DP.MinimumSquaresToFormANumber;

/**
 * @author aftabhassan
 *
 */

/*
 * https://leetcode.com/problems/perfect-squares/
 * Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.
 * For example, given n = 12, return 3 because 12 = 4 + 4 + 4; given n = 13, return 2 because 13 = 4 + 9
 */
public class SumOfPerfectSquares_Recursion {
    public static void main( String[] args ) {
    	SumOfPerfectSquares_Recursion obj = new SumOfPerfectSquares_Recursion(); 
        
        int val = 0;
        for(int i = 0;i<100;i++)
        {
            val += obj.numSquares( i );
        }
        System.out.println( val );
        
        System.out.println( obj.numSquares( 13 ) );
    }
    
    int numSquares1(int n, int[] memo) {
        if (memo == null) return -1;
        if (memo[n] != Integer.MAX_VALUE) return memo[n];
        int minval = memo[n];
        for (int i = 1; i*i <= n; i++) {
          int ret;
          ret = numSquares1(n - i*i, memo)+1;
          if (minval > ret) minval = ret;
        }
        memo[n] = minval;
        return memo[n];
      }
       
      int numSquares(int n) {
        if ( n < 0) return -1;
        int[] memo = new int[n+1];
        memo[0] = 0;
        for (int i = 1; i <= n; i++)
          memo[i] = Integer.MAX_VALUE;
        return numSquares1(n, memo);   
      }
}
