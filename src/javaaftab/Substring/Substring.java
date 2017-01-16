/*
 * Substring.java
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
package javaaftab.Substring;

public class Substring {

    /**
     * @param args
     */
    public static void main( String[] args ) {
        // TODO Auto-generated method stub
        String str = "hello";
        
        for(int i=0;i<=str.length();i++)
        {
            System.out.println( str.substring( 0, i ) + ":" + str.substring( i, str.length() ) );
        }
        
        System.out.println( "------------------------" );
        
        for(int i=1;i<str.length();i++)
        {
            System.out.println( str.substring( 0, i ) + ":" + str.substring( i, str.length() ) );
        }
        
        System.out.println( "------------------------" );
        //System.out.println(str.substring(2,1));
        System.out.println(str.substring(2,2));
        System.out.println(str.substring(2,3));
    }

}
