package Matrix.MaxSumLessThanK;
import java.util.TreeSet;

/*
 * CopiedRectSumLessThanK.java
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
public class Copied_RectSumLessThanK {

    /**
     * @param args
     */
    public static void main( String[] args ) {
        // TODO Auto-generated method stub
        int[][] a = {{5,-4,-3,4},{-3,-4,4,5},{5,1,5,-4}};
        
        Copied_RectSumLessThanK obj = new Copied_RectSumLessThanK();
        int output = obj.maxSumSubmatrix( a, 8 );
        System.out.println( "output == " + output );
    }

    public int maxSumSubmatrix(int[][] matrix, int k) {
        if(matrix==null||matrix.length==0||matrix[0].length==0)
            return 0;
     
        int row=matrix.length;
        int col=matrix[0].length;
     
        int m = Math.max(row, col);
        int n = Math.min(row, col);
        boolean isRowLarger = false;
        if(row>col)
            isRowLarger=true;
     
        int result = Integer.MIN_VALUE;
     
        for(int c1=0; c1<n; c1++){
     
            int[] each = new int[m];
            for(int c2=c1; c2>=0; c2--){
     
                for(int r=0; r<m; r++){
                    each[r]+=isRowLarger?matrix[r][c2]:matrix[c2][r];   
                }
     
                result = Math.max(result, getLargestSumCloseToK(each, k));
            }
        }
     
        return result;
    }
     
    public int getLargestSumCloseToK(int[] arr, int k){
        int sum=0;
        TreeSet<Integer> set = new TreeSet<Integer>();
        int result=Integer.MIN_VALUE;
        set.add(0);
     
        for(int i=0; i<arr.length; i++){
            sum=sum+arr[i];
     
            Integer ceiling = set.ceiling(sum-k);
            if(ceiling!=null){
                result = Math.max(result, sum-ceiling);        
            }
     
            set.add(sum);
        }
     
        return result;
    }
}
