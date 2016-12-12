package DP.KnightsAndPrincess;
/*
 * KnightsMemo.java
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
public class TODO_KnightsDPAzwan {

    /**
     * @param args
     */
    public static void main( String[] args ) {
        // TODO Auto-generated method stub
        int[][] a = {{2,-3,3},{-5,-10,1},{10,30,-5}};
        TODO_KnightsDPAzwan obj = new TODO_KnightsDPAzwan();
        System.out.println( obj.CalculateMinimumHP(a));
    }

    public int CalculateMinimumHP(int[][] dungeon)
    {
        if (dungeon==null)
        {
            return 0;
        }
 
        int row = dungeon.length;
        int column = dungeon[0].length;
 
        int[][] minHP = new int[row][column];
 
        if (dungeon[row-1][column-1] <=0)
        {
            minHP[row - 1][column - 1] = dungeon[row - 1][column - 1];
        }
        else
        {
            minHP[row - 1][column - 1] = 0;
        }
 
        for (int i = row-1; i >= 0; i--)
        {
            for (int j = column-1; j >= 0; j--)
            {
                if (i+1<row && j+1<column)
                {
                    int hp1 = minHP[i + 1][j] + dungeon[i][j];
                    int hp2 = minHP[i][j + 1] + dungeon[i][j];
 
                    minHP[i][j] = Math.max(hp1, hp2);
 
                }
                else if (i+1 < row)
                {
                    minHP[i][j] = minHP[i+1][j] + dungeon[i][j];
                }
                else if (j+1 < column)
                {
                    minHP[i][j] = minHP[i][j + 1] + dungeon[i][j];
                }
 
                if (minHP[i][j]>0)
                {
                    minHP[i][j] = 0;
                }
            }
 
        }
 
 
        return Math.abs(minHP[0][0]) + 1;
    }
}
