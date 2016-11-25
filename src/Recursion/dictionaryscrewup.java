/*
 * dictionaryscrewup.java
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

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author aftabhassan
 */
public class dictionaryscrewup {
    Set<String> mySet;

    public dictionaryscrewup() throws FileNotFoundException {
        Scanner stdin = new Scanner( new FileReader( System.getProperty( "user.dir" ) + "/src/youtubeshell/" + "words.txt" ) );
        mySet = new HashSet<String>();
        while ( stdin.hasNext() ) {
            mySet.add( stdin.nextLine() );
        }

        stdin.close();
    }

    /**
     * @param args
     * @throws FileNotFoundException
     */
    public static void main( String[] args ) throws FileNotFoundException {
        // TODO Auto-generated method stub
        dictionaryscrewup obj = new dictionaryscrewup();

        String str = "jesslookedjustliketimherbrother";
        System.out.println( obj.findMissingFromDictionary( str ) );
    }

    int findMissingFromDictionary( String str ) {
        if ( isFound( str ) )
            return 0;

        if ( str.length() == 1 )
            return 1;

        int ret = Integer.MAX_VALUE - 100;
        for ( int i = 1; i < str.length(); i++ ) {
            System.out.println( "Checking " + str.substring( 0, i ) + " and " + str.substring( i, str.length() ) );
            ret = Math.min( ret, findMissingFromDictionary( str.substring( 0, i ) ) + findMissingFromDictionary( str.substring( i, str.length() ) ) );
        }

        return ret;
    }

    boolean isFound( String str ) {
        return mySet.contains( str );
    }

}
