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

import java.util.Arrays;

/**
 * @author aftabhassan
 *
 */

/*
 * https://leetcode.com/problems/perfect-squares/
 * Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.
 * For example, given n = 12, return 3 because 12 = 4 + 4 + 4; given n = 13, return 2 because 13 = 4 + 9
 */
public class SumOfPerfectSquares_N2 {
    public static void main( String[] args ) {
    	SumOfPerfectSquares_N2 obj = new SumOfPerfectSquares_N2(); 
        
//        int val = 0;
//        for(int i = 0;i<100;i++)
//        {
//            val += obj.numSquares( i );
//        }
//        System.out.println( val );
        
        System.out.println( obj.numSquares( 13 ) );
    }
    
    public int numSquares(int n) {
        int[]dp = new int[n + 1];
        Arrays.fill(dp, n);
        dp[0] = 0;
        for(int i = 1; i*i <= n; i++){
            dp[i*i] = 1;
            for(int j = i*i + 1; j <= n; j++){
                dp[j] = Integer.min(dp[j], dp[j - i*i] + 1 );
            }        
        }
        return dp[n];
    }
}
