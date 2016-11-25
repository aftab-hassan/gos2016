/*
 * CarDriver.java
 * 
 * Copyright (c) 2016 by General Electric Company. All rights reserved.
 * 
 * The copyright to the computer software herein is the property of
 * General Electric Company. The software may be used and/or copied only
 * with the written permission of General Electric Company or in accordance
 * with the terms and conditions stipulated in the agreement/contract
 * under which the software has been supplied.
 */
package javaaftab.Comparator;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author aftabhassan
 */
public class BusDriver {

    /**
     * @param args
     */
    public static void main( String[] args ) {
        // TODO Auto-generated method stub
        ArrayList<Bus> buses = new ArrayList<>();

        buses.add( new Bus( "abc" ) );
        buses.add( new Bus( "bac" ) );
        buses.add( new Bus( "ebc" ) );
        buses.add( new Bus( "cab" ) );
        buses.add( new Bus( "dbc" ) );

        System.out.println( buses );

        // Method 4
        Collections.sort( buses, Bus.BusComparator );

        System.out.println( buses );
    }

}
