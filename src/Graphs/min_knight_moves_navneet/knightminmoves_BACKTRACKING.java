/*
 * knightstour.java
 * 
 * Copyright (c) 2016 by General Electric Company. All rights reserved.
 * 
 * The copyright to the computer software herein is the property of
 * General Electric Company. The software may be used and/or copied only
 * with the written permission of General Electric Company or in accordance
 * with the terms and conditions stipulated in the agreement/contract
 * under which the software has been supplied.
 */
package Graphs.min_knight_moves_navneet;

import java.util.Arrays;

/**
 * @author aftabhassan
 */
public class knightminmoves_BACKTRACKING {

    /**
     * @param args
     */
    public static void main( String[] args ) {
        // TODO Auto-generated method stub

        int degree = 5;
        int[][] board = new int[degree][degree];
        boolean[][] visited = new boolean[degree][degree];

        System.out.println( minMoves( 0, 0, degree - 1, degree - 1, board, visited ) );
    }

    // Q1
    static int minMoves( int x, int y, int destx, int desty, int[][] board, boolean[][] visited ) {
        if ( x < 0 || y < 0 || x >= board.length || y >= board[0].length )
            return Integer.MAX_VALUE - 2;

        if ( x == destx && y == desty )
            return 0;

        if ( visited[x][y] == true )
            return Integer.MAX_VALUE - 2;
        else
            visited[x][y] = true;

        int upleft = minMoves( x - 2, y - 1, destx, desty, board, visited );
        int upright = minMoves( x - 2, y + 1, destx, desty, board, visited );
        int downleft = minMoves( x + 2, y - 1, destx, desty, board, visited );
        int downright = minMoves( x + 2, y + 1, destx, desty, board, visited );
        int leftup = minMoves( x - 1, y - 2, destx, desty, board, visited );
        int leftdown = minMoves( x + 1, y - 2, destx, desty, board, visited );
        int rightup = minMoves( x - 1, y + 2, destx, desty, board, visited );
        int rightdown = minMoves( x + 1, y + 2, destx, desty, board, visited );

        visited[x][y] = false;

        return min( upleft, upright, downleft, downright, leftup, leftdown, rightup, rightdown ) + 1;
    }

    static int min( int a, int b, int c, int d, int e, int f, int g, int h ) {
        int[] arr = new int[8];
        arr[0] = a;
        arr[1] = b;
        arr[2] = c;
        arr[3] = d;
        arr[4] = e;
        arr[5] = f;
        arr[6] = g;
        arr[7] = h;

        Arrays.sort( arr );
        return arr[0];
    }

}
