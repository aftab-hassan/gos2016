package DP.KnightsAndPrincess;
/*
 * KnightAndPrincess.java
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
/*
 * *QotD* *Dec-07-2016* *-* *Rescue* *The* *Princess*

The demons had captured the princess (P) and imprisoned her in the bottom-right corner of a dungeon. The dungeon consists of M x N rooms laid out in a 2D grid. Our valiant knight (K) was initially positioned in the top-left room and must fight his way through the dungeon to rescue the princess.

The knight has an initial health point represented by a positive integer. If at any point his health point drops to 0 or below, he dies immediately.

Some of the rooms are guarded by demons, so the knight loses health (negative integers) upon entering these rooms; other rooms are either empty (0's) or contain magic orbs that increase the knight's health (positive integers).

In order to reach the princess as quickly as possible, the knight decides to move only rightward or downward in each step.

Write a function to determine the knight's minimum initial health so that he is able to rescue the princess.

(Taken from leetcode: https://leetcode.com/problems/dungeon-game/ )
 */
public class KnightAndPrincessExponential {

    /**
     * @param args
     */
    public static void main( String[] args ) {
        // TODO Auto-generated method stub
//        int[][] a = { {0,-4,3,2}, {-1,-5,-10,1}, {2,-1,3,-2}, {3,-200,1,0} };
//        int[][] a = { {0,-3} };
        int[][] a = { {-4,3,5,-3} };
//        int[][] a = { {-2,-3,3}, {-5,-10,1}, {10,30,-5} };
//        int[][] a = {{-20,-32,31}, {-35,-110,133},{1230,320,-225}};
//        int[][] a = {{2},{1}};
//        int[][] a = { {-2,-3,3,1,-5} };
//        int[][] a = {{1,2,3}};
//        int[][] a = { {100} };
//        int[][] a = {{3,-20,30},{-3,4,0}};
//        int[][] a = {{-200}};
//        int[][] a = {{0,0,0},{1,1,-1}};
        
        KnightAndPrincessExponential obj = new KnightAndPrincessExponential();
        
        int val = 0;
        if(a[0][0] >= 0)
            val = obj.findMinHealth( a, 0, 0, 1 ) + 1;
        else
            val = obj.findMinHealth( a, 0, 0, 0 );
        
        System.out.println( val );
    }
    
    public int findMinHealth(int[][] a, int i, int j, int health)
    {
        if(i == a.length || j == a[0].length)
            return -1;
        
        if(i == a.length-1 && j == a[0].length-1)
            return ((health + a[i][j]) <= 0)?(1-(health + a[i][j])) :0;
            
        int right = findMinHealth( a, i, j+1, (health + a[i][j])<=0?1:(health + a[i][j]));
        int down = findMinHealth( a, i+1, j, (health + a[i][j])<=0?1:(health + a[i][j]));
            
        if(right != -1 && down != -1)
        {
            int min = (right < down)?right:down;
            int bill = ((health + a[i][j]) <= 0)?(1-(health + a[i][j])) :0;
            return min + bill;
        }
        
        if(right != -1)
        {
            int bill = ((health + a[i][j]) <= 0)?(1-(health + a[i][j])) :0;
            return right + bill;
        }
        
        if(down != -1)
        {
            int bill = ((health + a[i][j]) <= 0)?(1-(health + a[i][j])) :0;
            return down + bill;
        }
        
        return -1;
    }
}