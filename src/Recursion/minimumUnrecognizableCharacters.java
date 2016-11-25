/*
 * longestwordmadeofotherwordsinlist.java
 * 
 * Copyright (c) 2016 by General Electric Company. All rights reserved.
 * 
 * The copyright to the computer software herein is the property of
 * General Electric Company. The software may be used and/or copied only
 * with the written permission of General Electric Company or in accordance
 * with the terms and conditions stipulated in the agreement/contract
 * under which the software has been supplied.
 */
package Recursion;

import java.util.ArrayList;
import java.util.Hashtable;

/**
 * @author aftabhassan
 *
 */
public class minimumUnrecognizableCharacters {

    /**
     * @param args
     */
    public static void main( String[] args ) {
        // TODO Auto-generated method stub
        
        ArrayList<String> dictionary = new ArrayList<String>();
        dictionary.add( "god" );dictionary.add( "father" );dictionary.add( "gods" );dictionary.add( "zilla" );
        dictionary.add( "rock" );dictionary.add( "on" );dictionary.add( "harry" );dictionary.add( "potter" );

        Hashtable<String, Integer> DPTable = new Hashtable<>();
        System.out.println( "starting..." );
        System.out.println( minUnrecognizable( "xgodxxxxxxxxxxxxxxxxxfather", dictionary, DPTable ) );
        System.out.println( "ending..." );
        
        System.out.println( "xxxxxxxxxxxxxxxxxx".length() );
    }

    static int minUnrecognizable(String str, ArrayList<String> dictionary, Hashtable<String, Integer> DPTable)
    {
        if(dictionary.contains( str ))
            return 0;
        
        if(DPTable.containsKey( str ))
            return DPTable.get( str );
        
        if(str.length() == 1)
            return 1;
        
        int min = Integer.MAX_VALUE;
        for(int i = 0;i<=str.length()-2;i++)
        {
            min = Math.min( min, minUnrecognizable( substring( str, 0, i ), dictionary, DPTable )  + minUnrecognizable( substring( str, i+1, str.length()-1 ), dictionary, DPTable ));
        }
        
        DPTable.put( str, min );
        
        return min;
    }
    
    static String substring(String str, int start, int end )
    {
        return str.substring( start, end +1 );
    }
}
