package DP.DictionaryStringproblems;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Hashtable;
import java.util.Scanner;

/*
 * MinimumConcatForDictionaryWord.java
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
public class MinimumConcatForDictionaryWord {

    /**
     * @param args
     */
    public static void main( String[] args ) throws FileNotFoundException{
        // TODO Auto-generated method stub
        
        String string = "agoodday";
        
//        for(int i = 1;i<string.length();i++)
//            System.out.println( string.substring( 0,i ) +" + " + string.substring( i, string.length() ) );
        
        Scanner stdin = new Scanner( new FileReader( System.getProperty( "user.dir" ) +"//src//Input//words.txt" ) );
        
        Hashtable<String, Boolean> dictionary = new Hashtable<>();
        while(stdin.hasNext())
        {
            dictionary.put( stdin.nextLine(), true );
        }
        
        System.out.println( fun( "zzxzxzxz", dictionary ) );
        System.out.println( dictionary.containsKey( "ff" ) );
    }

    public static int fun(String str, Hashtable<String, Boolean> dictionary)
    {
            if(str.length() == 0)
                    return 0;

            if(dictionary.containsKey(str))
                    return 1;

            int totalret = Integer.MAX_VALUE;
            for(int i = 1;i<str.length();i++)
            {
                    String left = str.substring(0,i);
                    String right = str.substring(i, str.length());

                    if(dictionary.containsKey(left))
                    {
                            int ret = fun(right, dictionary);

                            if(ret < Integer.MAX_VALUE)
                                    totalret = Math.min(totalret, ret+1);
                    }
            }

            return totalret;
    }
}
