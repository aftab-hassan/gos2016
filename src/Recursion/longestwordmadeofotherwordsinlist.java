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

/**
 * @author aftabhassan
 *
 */
public class longestwordmadeofotherwordsinlist {

    /**
     * @param args
     */
    public static void main( String[] args ) {
        // TODO Auto-generated method stub
        
        ArrayList<String> dictionary = new ArrayList<String>();
        dictionary.add( "god" );dictionary.add( "father" );dictionary.add( "gods" );dictionary.add( "zilla" );
        dictionary.add( "rock" );dictionary.add( "on" );dictionary.add( "harry" );dictionary.add( "potter" );

        System.out.println( splittable( "godfather", dictionary ) );
        System.out.println( splittable( "godszilla", dictionary ) );
        System.out.println( splittable( "godszilla", dictionary ) );
        System.out.println( splittable( "fathergodgodszillapotterharryonrock", dictionary ) );
    }

    static boolean splittable(String str, ArrayList<String> dictionary)
    {
        if(dictionary.contains( str ))
            return true;
        
        for(int i = 0;i<str.length();i++)
        {
            if(dictionary.contains( substring( str, 0, i ) ) && splittable( substring( str, i+1, str.length()-1), dictionary ))
                return true;
        }
        return false;
    }
    
    static String substring(String str, int start,int end)
    {
        return str.substring( start, end+1 );
    }
}
