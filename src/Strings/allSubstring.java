/*
 * allSubstring.java
 * 
 * Copyright (c) 2016 by General Electric Company. All rights reserved.
 * 
 * The copyright to the computer software herein is the property of
 * General Electric Company. The software may be used and/or copied only
 * with the written permission of General Electric Company or in accordance
 * with the terms and conditions stipulated in the agreement/contract
 * under which the software has been supplied.
 */
package Strings;

/**
 * @author aftabhassan
 *
 */
public class allSubstring {
    public static void main( String[] args ) {
        String string = "12345";
        
        printAllSubstring( string );
    }
    
    static void printAllSubstring(String str)
    {
        for(int i = 0;i<str.length();i++)
        {
            System.out.println(  substring( str, 0, i ) + "," + substring( str, i+1, str.length()-1 ));
        }
        
        System.out.println( "" );
        for(int i= 0;i<=str.length();i++)
        {
            System.out.println( str.substring( 0, i ) + "," + str.substring( i, str.length() ) );
        }
    }
    
    static String substring(String str, int start, int end)
    {
        return str.substring( start, end+1 );
    }
}
