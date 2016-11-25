/*
 * hashtTablecheck.java
 * 
 * Copyright (c) 2016 by General Electric Company. All rights reserved.
 * 
 * The copyright to the computer software herein is the property of
 * General Electric Company. The software may be used and/or copied only
 * with the written permission of General Electric Company or in accordance
 * with the terms and conditions stipulated in the agreement/contract
 * under which the software has been supplied.
 */
package javaaftab.Trials;

import java.util.Hashtable;

/**
 * @author aftabhassan
 *
 */
public class hashtTablecheck {

    /**
     * @param args
     */
    public static void main( String[] args ) {
        // TODO Auto-generated method stub

        Hashtable<Integer, Integer> myHashtable = new Hashtable<>();
        
        for(int i= 0;i<10;i++)
        {
            myHashtable.put( i, i+10 );
        }
        
        System.out.println( myHashtable.containsKey( 5 ) );
        System.out.println( myHashtable.containsValue( 15 ) );
        
    }

}
