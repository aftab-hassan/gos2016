/*
 * FairBonus.java
 * 
 * Copyright (c) 2016 by General Electric Company. All rights reserved.
 * 
 * The copyright to the computer software herein is the property of
 * General Electric Company. The software may be used and/or copied only
 * with the written permission of General Electric Company or in accordance
 * with the terms and conditions stipulated in the agreement/contract
 * under which the software has been supplied.
 */

//You manage a team of developers and you have to give concert tickets as a bonus to the developers. For each developer, you know how many lines of code he/she wrote the previous week, and you want to reward more productive developers.
//
//The developers sit in a row. Each developer, except the first and last, has two neighbors. You must give each developer one or more tickets in such a way that if a developer has written more lines of code than a neighbor, then he/she receives more tickets than his/her neighbor.
//
//Compute the minimum number of tickets you need to buy to satisfy the constraint.
//For example, if Andy, Bob, Charlie and David sit in a row from left to right, and the previous week they wrote 300, 400, 500, and 200 lines of code respectively, then Andy and David should receive 1 ticket each, Bob should receive 2 tickets, and Charlie should receive 3 tickets, for a total of 7 tickets.
//

/**
 * @author aftabhassan
 *
 */
package DP.FairBonus;

public class FairBonus {

    /**
     * @param args
     */
    public static void main( String[] args ) {
        // TODO Auto-generated method stub
//        int[] a = {300, 400, 500, 200};
//        int[] a = {1, 1000, 999, 1000};
//        int[] a = {2,3,5,2,4,7,3,2,8};
//        int[] a = {1, 1, 1, 1};
        int[] a = {5, 4, 3, 2, 1, 2, 3, 4};
        
        FairBonus obj = new FairBonus();
        System.out.println( obj.fairBonus( a ) );
    }
    
    public int fairBonus(int[] a)
    {
        int[] bonus = new int[a.length];
        int total = 0;

        //right to left
        bonus[0] = 1;
        for(int i = 1;i<a.length;i++)
        {
                bonus[i] = (a[i] > a[i-1])?(bonus[i-1] + 1):1;
        }

        //left to right
        for(int i = a.length-2;i>=0;i--)
        {
                bonus[i] = Math.max(bonus[i], (a[i] > a[i+1])?(bonus[i+1] + 1):1);
                total += bonus[i];
                
        }
        total += Math.max( bonus[a.length-1], 1 );
            

        return total;
    }

}
