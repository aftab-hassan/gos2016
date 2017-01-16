package DP.MinimumUnrecognizedCharacters_1714;
import java.util.HashSet;

/*
 * CTCI1714.java
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
public class MinimumUnrecognizedCharacters_CHECK {

    /**
     * @param args
     */
    public static void main( String[] args ) {
        // TODO Auto-generated method stub
        
        String str = "thit";
        
        
//        System.out.println( str.substring( 2, 2 ) );
//        System.out.println( str.substring( 2, 3 ) );
//        System.out.println( str.substring( 2, string.length() ) );
//        System.out.println( str.substring( 2, 1 ) );
        
        MinimumUnrecognizedCharacters_CHECK obj = new MinimumUnrecognizedCharacters_CHECK();
        str = "hello";
        HashSet<String> dictionary = new HashSet<>();
        dictionary.add( "he" );
        dictionary.add( "ll" );
        dictionary.add( "oo" );
        System.out.println( obj.minimumUnRecognizedCharacter( str, dictionary  ) );
    }

    public int minimumUnRecognizedCharacter(String str, HashSet<String> dictionary)
    {
        if(str.length() == 0)
            System.out.println( "shoutout!!!" );
        
        if(dictionary.contains( str ))
            return 0;
        
//        if(str.length() == 1 )
//            return str.length();
                
//        int minCount = Integer.MAX_VALUE;
        int minCount = str.length();
        for(int i = 1;i<str.length();i++)
        {
            String left = str.substring( 0, i );
            String right = str.substring( i, str.length() );
            int count = 0;
            
            if(dictionary.contains( left ))
                count = 0;
            else
                count = left.length();
            
            count += minimumUnRecognizedCharacter( right, dictionary );
            minCount = Math.min( minCount, count );    
        }
        
        return minCount;
    }
}
