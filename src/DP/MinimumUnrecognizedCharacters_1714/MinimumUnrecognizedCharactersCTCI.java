package DP.MinimumUnrecognizedCharacters_1714;
import java.util.HashSet;

/*
 * MinimumUnrecognizedCharacterCTCI.java
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
public class MinimumUnrecognizedCharactersCTCI {

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
        
        MinimumUnrecognizedCharactersCTCI obj = new MinimumUnrecognizedCharactersCTCI();
        System.out.println( obj.minimumUnRecognizedCharacter( str, dictionary ) );
    }
    
    public int minimumUnRecognizedCharacter(String str, HashSet<String> dictionary)
    {
        if(dictionary.contains( str ))
            return 0;
        
        int min = str.length();
        for(int i = 1;i<str.length();i++)
        {
            int yesSplit = dictionary.contains( str.substring( 0, i ) )?0:(i+1) + minimumUnRecognizedCharacter( str.substring( i ), dictionary );
            int noSplit = dictionary.contains( str.substring( 0, i+1 ) )?0:(i+2) + minimumUnRecognizedCharacter( str.substring( i+1 ), dictionary );
            min = Math.min( min, Math.min( yesSplit, noSplit ) );
        }
        
        return min;
    }

}
