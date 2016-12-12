package DP.PrintParen;

import java.util.ArrayList;

/*
 * PrintParen.java
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
public class PrintParen2 {

    /**
     * @param args
     */
    public static void main( String[] args ) {
        // TODO Auto-generated method stub
        
        PrintParen2 obj = new PrintParen2();
        ArrayList<String> output = obj.printParen( 0, 0, "", 3 );
        System.out.println( output );
    }
    
    public ArrayList<String> printParen(int left, int right, String str, int n)
    {
        if(left == n && right == n)
        {
            ArrayList<String> ret = new ArrayList<>();
            ret.add( str );
            
//            System.out.println( "ret while returning == " +ret );
            return ret;
        }
         
        ArrayList<String> ret = new ArrayList<>();
        if(left < n)
        {
            ArrayList<String> rec = printParen( left+1, right, str+"(", n );
            ret.addAll( rec );
        }
            
        if(right < left)
        {
            ArrayList<String> rec = printParen( left, right+1, str+")", n );
            ret.addAll( rec );
        }
            
        System.out.println( "ret while returning == " +ret );
        return ret;
    }
}
