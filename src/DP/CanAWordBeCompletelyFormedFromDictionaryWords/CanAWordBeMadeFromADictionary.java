package DP.CanAWordBeCompletelyFormedFromDictionaryWords;
import java.util.HashSet;

/*
 * CanAWordBeMadeFromOthersInDictionary.java
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
public class CanAWordBeMadeFromADictionary {

    /**
     * @param args
     */
    public static void main( String[] args ) {
        // TODO Auto-generated method stub
        
        String str = "hello";
        HashSet<String> dictionary = new HashSet<>();
        dictionary.add( "he" );
        dictionary.add( "ll" );
        dictionary.add( "oo" );
        
        CanAWordBeMadeFromADictionary obj = new CanAWordBeMadeFromADictionary();
        System.out.println( obj.canBeFormed( str, dictionary ) );
    }
    
    public boolean canBeFormed(String str, HashSet<String> dictionary)
    {
        if(dictionary.contains( str ))
            return true;
        
        for(int i = 1;i<str.length();i++)
        {
            if(dictionary.contains( str.substring( 0, i ) ) && canBeFormed( str.substring( i, str.length() ), dictionary ))
                return true;
        }
        return false;
    }

}
