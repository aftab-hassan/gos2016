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
public class BikeDriver {

    /**
     * @param args
     */
    public static void main( String[] args ) {
        // TODO Auto-generated method stub
        ArrayList<Bike> bikes = new ArrayList<>();

        bikes.add( new Bike( "abc" ) );
        bikes.add( new Bike( "bac" ) );
        bikes.add( new Bike( "ebc" ) );
        bikes.add( new Bike( "cab" ) );
        bikes.add( new Bike( "dbc" ) );

        System.out.println( bikes );

        // Method 3
        Collections.sort( bikes, new BikeComparator() );

        System.out.println( bikes );
    }

}
