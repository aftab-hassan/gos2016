package Matrix;
/*

 * SpiralPrint.java
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
public class SpiralPrint {

    /**
     * @param args
     */
    public static void main( String[] args ) {
        // TODO Auto-generated method stub
//        int[][] a = { {1,2,3,4}, {5,6,7,8}, {9,10,11,12}, {13,14,15,16} };
//        int[][] a = { {1,2,3,4}, {5,6,7,8}, {9,10,11,12} };
//        int[][] a = { {1,2,3,4,5,6,7,8,9,10,11,12} };
//        int[][] a = { {1},{2},{3},{4},{5},{6},{7},{8},{9},{10},{11},{12} };
        int[][] a = { {1} };
        SpiralPrint spiralPrint = new SpiralPrint();
        spiralPrint.print( a );
    }

    public void print(int[][] a)
    {
        int uprow = 0, downrow = a.length-1, leftcol = 0, rightcol = a[0].length-1;
        
        while(true)
        {
            for(int i = leftcol;i<=rightcol;i++)
                System.out.print( a[uprow][i] + " ");
            if(++uprow > downrow)
                break;
            
            for(int i = uprow;i<=downrow;i++)
                System.out.print( a[i][rightcol] + " " );
            if(--rightcol < leftcol)
                break;
            
            for(int i = rightcol;i>=leftcol;i-- )
                System.out.print( a[downrow][i] + " ");
            if(--downrow < uprow)
                break;
            
            for(int i = downrow;i>=uprow;i--)
                System.out.print( a[i][leftcol] + " " );
            if(++leftcol > rightcol)
                break;
            
            System.out.println( "" );
        }
    }
}
